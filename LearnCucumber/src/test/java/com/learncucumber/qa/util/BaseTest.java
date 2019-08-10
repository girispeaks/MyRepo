package com.learncucumber.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseTest {
	public Properties prop;
	public WebDriver driver;
	public BaseTest(){
		try{
		File f=new File("C:\\Users\\gramakrishn6\\workspace\\LearnCucumber\\OR.properties");
		FileInputStream ip=new FileInputStream(f);
		prop=new Properties();
		prop.load(ip);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void openBrowser(String browser){
		if(prop.getProperty("browser").equals("Mozilla")){
			System.setProperty("webdriver.gecko.driver", "C://Users//gramakrishn6//Desktop//Jars//geckodriver-v0.17.0-win64//geckodriver.exe");
			driver=new FirefoxDriver();			
		} else if(prop.getProperty("browser").equals("Chrome")){
			System.setProperty("webdriver.chromedriver.driver", "");
			driver=new ChromeDriver();
		} else if(prop.getProperty("browser").equals("IE")){
			System.setProperty("webdriver.iedriver.driver", "");
			driver=new InternetExplorerDriver();
		} else{
			System.setProperty("webdriver.gecko.driver", "C://Users//gramakrishn6//Desktop//Jars//geckodriver-v0.17.0-win64//geckodriver.exe");
			driver=new FirefoxDriver();	
		}		
		//driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	public void launchApp(String url){
		driver.get(prop.getProperty(url));
		waitDriver(1000);
		pageLoad();
	}
	
	public void waitDriver(int sec){
		try{
		Thread.sleep(sec);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void pageLoad(){
		waitDriver(1000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String state=(String)js.executeScript("return document.readyState");
		while(!state.equals("complete")){
			waitDriver(1000);
			state=(String)js.executeScript("return document.readyState");
		}
	}
	
	public void click(String locator){
		getElement(locator).click();
		
	}
	
	public WebElement getElement(String locator){
		WebElement element=driver.findElement(By.xpath(prop.getProperty("loginlink")));
		return element;
	}
	
	public int frames(){
		List<WebElement> frame=driver.findElements(By.tagName("iframe"));
		System.out.println(frame.size());
		return frame.size();
	}

}
