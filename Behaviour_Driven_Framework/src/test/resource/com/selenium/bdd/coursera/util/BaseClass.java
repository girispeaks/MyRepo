package com.selenium.bdd.coursera.util;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {
		public static Properties prop=null;
		public static WebDriver driver=null;
	public BaseClass(){
		try
		{
		prop=new Properties();
		FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resource\\com\\selenium\\bdd\\coursera\\config\\OR.properties");
		prop.load(ip);
		System.out.println(prop.get("applicationUrl"));
		} catch(Exception e){
			e.printStackTrace();
		}		
	}

	public void openBrowser(String browser){
		if(browser.equals(prop.get("browser"))){
			System.setProperty("webdriver.gecko.driver", "C://Users//gramakrishn6//Desktop//Jars//geckodriver-v0.17.0-win64//geckodriver.exe");
			driver=new FirefoxDriver();
		}else if(browser.equals(prop.get("browser"))){
			System.setProperty("webdriver.chrome.driver", "");
			driver=new ChromeDriver();
		}else if(browser.equals(prop.get("browser"))){
			System.setProperty("webdriver.ie.driver", "");
			driver=new InternetExplorerDriver();
		}else {
			System.setProperty("webdriver.gecko.driver", "C://Users//gramakrishn6//Desktop//Jars//geckodriver-v0.17.0-win64//geckodriver.exe");
			driver=new FirefoxDriver();
		}
		//driver.manage().window().maximize();
	}
	
	public void launchApplication(String url){
		driver.get(prop.getProperty(url));		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	public void type(String value, String object){
		driver.findElement(By.xpath(prop.getProperty(object))).sendKeys(value);		
	}
	
	public void click(String object){
		driver.findElement(By.xpath(prop.getProperty(object))).click();
		custWait(1);
		pageload();
	}
	
	public String verifyTitle(){
		return driver.getTitle();
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
	
	public boolean getElement(String object){
		List<WebElement> elements=null;
		elements=driver.findElements(By.xpath(prop.getProperty(object)));
		if(elements.size()>0)
			return true;
		else
			return false;
		
	}
	/*public static WebElement getElement(String object){
		WebElement element=null;
		
		if(object.endsWith("_xpath")){
			element=driver.findElement(By.xpath(prop.getProperty(object)));
		} else if(object.endsWith("_id")){
			element=driver.findElement(By.id(""));
		} else if(object.endsWith("_name")){
			element=driver.findElement(By.name(""));
		} else if(object.endsWith("_classname")){
			element=driver.findElement(By.className(""));
		} else if(object.endsWith("_tagname")){
			element=driver.findElement(By.tagName(""));
		} else if(object.endsWith("_linktext")){
			element=driver.findElement(By.linkText(""));
		} else if(object.endsWith("_partiallinktext")){
			element=driver.findElement(By.partialLinkText(""));
		} else if(object.endsWith("_cssselector")){
			element=driver.findElement(By.cssSelector(""));
		}
		
		return element;
	}*/
	
	
}



//C:\Users\gramakrishn6\workspace\Behaviour_Driven_Framework\src\test\resource\com\selenium\bdd\coursera\config\OR.properties