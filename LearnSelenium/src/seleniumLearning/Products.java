package seleniumLearning;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Products {
	static WebDriver driver=null;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "//users//girishr//Downloads//geckodriver");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://www.bigbasket.com/cl/fruits-vegetables/?nc=nb");
		//driver.findElement(By.xpath("")).sendKeys();
		pageLoad();
		List<WebElement> products=driver.findElements(By.xpath("//div[@class='col-sm-12 col-xs-7 prod-name']/a"));
		List<WebElement> buttons=driver.findElements(By.xpath("//button[@class='btn btn-add col-xs-9']"));
		System.out.println("Size is "+products.size());
		for(int i=0;i<products.size();i++){
			System.out.println(products.get(i).getText());
			System.out.println(buttons.get(i).getText());
			System.out.println("------------");
		}
		//button[@class='btn btn-add col-xs-9']
		ArrayList<String> selectedProducts=new ArrayList<String>();
		Random rd=new Random();
		for(int i=0;i<5;i++){
			int rand=rd.nextInt(20);
			buttons.get(rand).click();
			sleep();
			selectedProducts.add(products.get(rand).getText());
		}
		//products.get(i).click();
		//a[@class='ng-binding']
		//h6[@class='ng-binding'] AND a[@class='ng-binding']
		//div[@class='item prod-deck row ng-scope']/product-template/div/div[3]/div[1]
		//div[@class='col-sm-12 col-xs-7 prod-name']/a
		System.out.println(selectedProducts.size());
		for(int i=0;i<selectedProducts.size();i++)
			System.out.println(selectedProducts.get(i));
		//Actions act=new Actions(driver);
		
	}
	
	public static void sleep() throws Exception{
		Thread.sleep(2000);
	}
	
	public static void pageLoad() throws Exception{
		sleep();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		String str=(String)jse.executeScript("return document.readyState;");
		if(!str.equals("complete")){
			sleep();
			str=(String)jse.executeScript("return document.readyState;");
		}
	}

}
