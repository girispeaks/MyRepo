package seleniumPractice;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import test12092017.Xls_Reader;

public class BigBasket {
	static WebDriver driver=null;
	static WebElement ele=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C://Users//gramakrishn6//Desktop//Jars//geckodriver-v0.17.0-win64//geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.bigbasket.com/auth/login/?nc=nb");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		custWait(1);
		pageload();
		driver.findElement(By.xpath("//input[@name='username']")).clear();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("girisearchs@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).clear();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Wed@1234");
		//driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Keys.CONTROL+"n");
		driver.findElement(By.xpath("//*[@id='uiv2-loginform']/button")).click();
		custWait(1);
		pageload();
		driver.findElement(By.xpath("//li[@class='dropdown full-wid hvr-drop']/a")).click();	
		driver.findElement(By.xpath("//*[@id='navBarMegaNav']/li[1]/a")).click();
		custWait(1);
		pageload();
		//getting all product names on a page into a list
		List<WebElement> allProducts=driver.findElements(By.xpath("//div[@qa='product_name']/a"));
		List<WebElement> allButtons=driver.findElements(By.xpath("//div[@class='col-sm-5 col-xs-5 pad-0']/button"));
		List<WebElement> allQuantity=driver.findElements(By.xpath("//input[@ng-model='vm.startQuantity']"));
		System.out.println("Total products count is "+allProducts.size());
		System.out.println("Total buttons count is "+allProducts.size());
		for(int i=0;i<allProducts.size();i++){
			System.out.println(allProducts.get(i).getText()+"--------------"+allButtons.get(i).getText());
		}
		//Read product names from excel and store it in Arraylist
		Xls_Reader xls=new Xls_Reader("C:\\Users\\gramakrishn6\\Desktop\\Test.xlsx");
		Hashtable<String, String> productsQnty=new Hashtable<String,String>();
		ArrayList<String> productsToBeSelected=new ArrayList<String>();
		int totalrows=xls.getrowNum(0);
		System.out.println(totalrows);
		for(int i=2;i<=totalrows;i++){
			productsToBeSelected.add(xls.getCellData("Data", 0, i));
			productsQnty.put(xls.getCellData("Data", 0, i), xls.getCellData("Data", 1, i));
		}
		System.out.println(productsToBeSelected.size());
		System.out.println("Products to be selected are");
		System.out.println("---------------------------");
		for(int i=0;i<productsToBeSelected.size();i++)	{	
			System.out.println("Products from ArrayList "+productsToBeSelected.get(i));	
			System.out.println("Quantity from Hashtable "+productsQnty.get(productsToBeSelected.get(i)));
		}
		int itemsInCart=0;
		for(int i=0;i<allProducts.size();i++){
			if(productsToBeSelected.contains(allProducts.get(i).getText())){
				allQuantity.get(i).clear();
				allQuantity.get(i).sendKeys(productsQnty.get(allProducts.get(i).getText()));
				allButtons.get(i).click();	
				itemsInCart++;
				custWait(1);
			}
		}
		if(isElementFound("//button[@class='toast-close-button']"))
			ele.click();
		driver.navigate().refresh();
		custWait(1);
		pageload();
		System.out.println("Total items selected "+itemsInCart);
		WebElement cartOnScreen=driver.findElement(By.xpath("//span[@id='totalNumberOfCartItems']"));
		String count=cartOnScreen.getText().split(" ")[0];
		int cnt=Integer.parseInt(count);
		System.out.println(cnt);
		Assert.assertEquals(itemsInCart, cnt);
		Actions act=new Actions(driver);
		act.moveToElement(cartOnScreen).build().perform();
		custWait(2);
		driver.findElement(By.xpath("//div[@id='navbar-main']/div/bigbasket-cart-template/div/div[2]/ul/li[2]/div[2]/div[2]/button")).click();
		custWait(1);
		pageload();
		//Get all selected items in cart
		String qntcnt=null;
		List<WebElement> selectedItems=driver.findElements(By.xpath("//div[@class='uiv2-yourbasketitems-gridlist']/div/ul/li[2]/a[2]"));
		List<WebElement> quantity=driver.findElements(By.xpath("//div[@class='uiv2-yourbasketitems-gridlist']/div/ul/li[4]/div/input"));
		
		//compare the quantity from xl sheet and values displayed on screen
		for(int i=0;i<selectedItems.size();i++){
			for(int j=1;j<=totalrows;j++){
				if(xls.getCellData("Data", 0, j).equals(selectedItems.get(i).getText().split("1")[0].trim()))
						qntcnt=xls.getCellData("Data", 1, j);
			}
			System.out.println("Product is "+selectedItems.get(i).getText().split("1")[0].trim());
			Assert.assertEquals(quantity.get(i).getAttribute("value"),qntcnt);
		}
		
	}
	
	public static Boolean isElementFound(String path){
		try{
		ele=driver.findElement(By.xpath(path));		
		if(ele.isDisplayed())
			return true;
		else
			return false;
		}catch(Exception e){
			return false;
		}
	}
	
	
	public static void custWait(int sec){
		try
		{
		Thread.sleep(sec*1000);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void pageload(){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String state=(String)js.executeScript("return document.readyState");
		while(!state.equals("complete")){
			custWait(1);
			state=(String)js.executeScript("return document.readyState");
		}
	}	
}
