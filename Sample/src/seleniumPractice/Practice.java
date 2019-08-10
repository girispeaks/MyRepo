package seleniumPractice;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practice {
	static WebDriver driver;
	public static void main(String[] args) throws Exception{
		Practice prac=new Practice();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gramakrishn6\\Desktop\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		//prac.simpleFormTest(driver);
		//prac.checkBoxTest(driver, "Option 3");
		
		/*ArrayList<String> options=new ArrayList<String>();
		options.add("Texas");
		options.add("New York");
		options.add("California");
		prac.selectDrpDwnTest(driver, "Friday",options);*/
		//prac.ajaxFormTest(driver);
		prac.tableTest(driver);
	}	
	
	public void simpleFormTest(WebDriver driver) throws Exception{
		
		driver.get("http://www.seleniumeasy.com/test/basic-first-form-demo.html");
		Thread.sleep(3000);
		//Single input
		String expMsg="test message";
		driver.findElement(By.xpath("//input[@id='user-message']")).sendKeys(expMsg);
		driver.findElement(By.xpath("//form[@id='get-input']/button[@class='btn btn-default']")).click();
		String actMsg=driver.findElement(By.xpath("//span[@id='display']")).getText();
		if(actMsg.equals(expMsg))
			System.out.println("Single Test pass");
		else
			System.out.println("Single Test fail");		
		//Multi input
		int a=10;
		int b=10;
		int exptot=a+b;
		String x=String.valueOf(a);
		String y=String.valueOf(b);	
		driver.findElement(By.xpath("//input[@id='sum1']")).sendKeys(x);
		driver.findElement(By.xpath("//input[@id='sum2']")).sendKeys(y);
		driver.findElement(By.xpath("//form[@id='gettotal']/button")).click();
		String total=driver.findElement(By.xpath("//span[@id='displayvalue']")).getText();
		int acttot=Integer.valueOf(total);
		if(acttot==exptot)
			System.out.println("Multi Test pass");
		else
			System.out.println("Multi Test fail");
	}
	
	public void checkBoxTest(WebDriver driver, String chkBxNm) throws Exception{
		driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
		Thread.sleep(3000);
		//Single checkbox
		driver.findElement(By.xpath("//input[@id='isAgeSelected']")).click();
		//Multi checkbox
		List<WebElement> checkbox=driver.findElements(By.xpath("//div[@class='col-md-6 text-left']/div[2]/div[2]/div/label"));
		for(WebElement chkbx:checkbox)
			if(chkbx.getText().equals(chkBxNm)){
				chkbx.click();
				if(chkbx.isSelected())
					System.out.println(chkbx.getText()+" is selected");
				break;
		}
	}
	
	public void selectDrpDwnTest(WebDriver driver, String value, ArrayList<String> options) throws Exception{
		Select select;
		Actions act = null;
		driver.get("http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		Thread.sleep(2000);
		WebElement vals=driver.findElement(By.xpath("//select[@id='select-demo']"));
		select=new Select(vals);
		select.selectByVisibleText(value);
		List<WebElement> selectedVals=select.getAllSelectedOptions();
		String selVal=driver.findElement(By.xpath("//p[@class='selected-value']")).getText().split(" ")[3];
		for(WebElement selectedVal:selectedVals)
			if(selectedVal.getText().equals(selVal))
				System.out.println("Single select case pass");
			else
				System.out.println("Single select case fail");
		//Multi select		
		WebElement mulvals=driver.findElement(By.xpath("//select[@id='multi-select']"));
		select=new Select(mulvals);
		for(String option:options){
		select.selectByVisibleText(option);
		act=new Actions(driver);
		act.keyDown(Keys.CONTROL).build().perform();
		}
		act.keyUp(Keys.CONTROL).build().perform();
		int i=0;
		List<WebElement> selOptions=select.getAllSelectedOptions();
		for(WebElement selOption:selOptions)
			if(options.contains(selOption.getText()))
				i++;
		if(i==options.size())
			System.out.println("Multi select case pass");
	}
	
	public void ajaxFormTest(WebDriver driver) throws Exception{
		driver.get("http://www.seleniumeasy.com/test/ajax-form-submit-demo.html");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='title']")).sendKeys("Ajax Title");
		driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("Ajax Comments");
		driver.findElement(By.xpath("//input[@id='btn-submit']")).click();
		WebElement msg=driver.findElement(By.xpath("//div[@id='submit-control']"));
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(msg));	
		if(msg.isDisplayed())
			System.out.println("Form filled successfully");
	}
	
	public void tableTest(WebDriver driver){
		int i;
		int j;
		WebElement element;
		driver.get("http://www.seleniumeasy.com/test/table-search-filter-demo.html");
		int totRows=driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr")).size();
		int totCols=driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr[1]/td")).size();
		
		//breaking using label will come out of both the loops here.
		loop1:
		for(i=1;i<=totRows;i++)
			for(j=1;j<=totCols;j++){
				element=driver.findElement(By.xpath("//table[@id='task-table']/tbody/tr["+i+"]/td["+j+"]"));
			    if(element.getText().equals("SEO tags")){
			    	System.out.println("Element found");
			    	break loop1;
			    }			    	
			}
	   }
	
	
	
	
}
	
