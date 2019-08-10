package seleniumLearning;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchJava {
	static WebDriver driver=null;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "//users//girishr//Downloads//geckodriver");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("http://dice.com");
		sleep();
		pageLoad();
		//driver.findElement(By.xpath("//input[@id='search-field-keyword']")).sendKeys("Java");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementById(\"search-field-keyword\").value=\"Java\";");
		driver.findElement(By.xpath("//*[@id='search-field-location']")).clear();
		driver.findElement(By.xpath("//*[@id='search-form']/fieldset/div[4]/div/div[1]/button")).click();
		sleep();
		pageLoad();
		//List<WebElement> header=driver.findElements(By.xpath("//div[@id='serp']/div/div[1]/ul[1]/li[1]"));
		//System.out.println(header.size());
		int index=1;
		
		
		while(index<=5){	
			System.out.println("---------------Page number is "+index+" ---------------------");
			driver.findElement(By.xpath("//div[@id='dice_paging_btm']/ul/li/a[text()='"+index+"']")).click();
			sleep();
			pageLoad();	
			List<WebElement> header=driver.findElements(By.xpath("//div[@id='serp']/div/div[1]/ul[1]/li[1]"));
			for(int i=0;i<header.size();i++){
				System.out.println(header.get(i).getText());
				if(header.get(i).getText().contains("Java"))
					System.out.println("Java related search result");
				else
					System.out.println("Not Java related search result");
				}				
			index++;
		}//while(index<5);
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
