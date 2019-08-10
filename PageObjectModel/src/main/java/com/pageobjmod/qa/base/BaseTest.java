package com.pageobjmod.qa.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseTest {
	public static Properties prop;
	public static WebDriver driver;
	public BaseTest(){
		try{
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"//Resources//OR.properties");
			prop=new Properties();
			prop.load(ip);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void openBrowser(String browser){
		if(browser.equals("Mozilla")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//geckodriver.exe");
			driver=new FirefoxDriver();			
		}else if(browser.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Resources//chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browser.equals("IE")){
			System.setProperty("webdriver.ie.driver", "");
			driver=new InternetExplorerDriver();
		}		
		driver.manage().window().maximize();
	}
	
	public static void launchApp(String url){
		driver.get(url);
		waitTime(1);
		loadPageTime();
	}
	
	public static void waitTime(int sec){
		try{
		Thread.sleep(sec*1000);
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	public static void loadPageTime(){
		waitTime(1);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String state=(String)js.executeScript("return document.readyState");
		while(!state.equals("complete")){
			waitTime(1);
			state=(String)js.executeScript("return document.readyState");
		}
	}
	
	public static void switchFrame(){
		driver.switchTo().frame("mainpanel");
	}
	
	public static void defFrame(){
		driver.switchTo().defaultContent();
	}
	
	public static void quitBrowser(){
		driver.quit();
	}
}
