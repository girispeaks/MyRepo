package com.qtpselenium.app.salesforce.util;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebConnector {
	
	Properties OR=null;
	Properties CONFIG=null;
	WebDriver driver=null;
	WebDriver mozilla=null;
	WebDriver chrome=null;
	WebDriver ie=null;
	Logger APPLICATION_LOGS=Logger.getLogger("devpinoyLogger");
	public static WebConnector c=null;
	//constructor
	private WebConnector(){
		if(OR==null){
			try{
				OR=new Properties();
				FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//com//qtpselenium//app//salesforce//config//OR.properties");
				OR.load(ip);
				/*if(OR.getProperty("testEnv").equals("prod")){
					CONFIG=new Properties();
					FileInputStream cip=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//com//qtpselenium//app//salesforce//config//prod_config.properties");
					CONFIG.load(cip);
				}else if(OR.getProperty("testEnv").equals("uat")){
					CONFIG=new Properties();
					FileInputStream cip=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//com//qtpselenium//app//salesforce//config//uat_config.properties");
					CONFIG.load(cip);*/
				//or use below code
				CONFIG =new Properties();
				FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//com//qtpselenium//app//salesforce//config//"+OR.getProperty("testEnv")+"_config.properties");
				CONFIG.load(fs);
				System.out.println(OR.get("loginusername"));
				System.out.println(CONFIG.getProperty("LoginURL"));
				
			}catch(Exception e){
				System.out.println("Error in loading properties file");
			}
		}
	}
	
	
	/***************************Singleton Implementation*****************************/
	public static WebConnector getInstance(){
		if(c==null)
			c=new WebConnector();
		
		return c;
	}
	
	/***************************Generic Functions************************************/
	
	public void openBrowser(String browserType){
		if(browserType.equals("Mozilla") && mozilla==null){
			System.setProperty("webdriver.gecko.driver", OR.getProperty("geckodriver_exe"));
			driver=new FirefoxDriver();
			mozilla=driver;
		}else if(browserType.equals("Mozilla") && mozilla!=null){
			driver=mozilla;				
		}else if(browserType.equals("Chrome")&&chrome==null){
			System.setProperty("webdriver.chrome.driver",OR.getProperty("chromedriver_exe"));
			driver=new ChromeDriver();
			chrome=driver;
		}else if(browserType.equals("Chrome")&&chrome==null){
			driver=chrome;
		}else if(browserType.equals("IE")&&ie==null){
			System.setProperty("webdriver.chrome.driver",OR.getProperty("IEdriver_exe"));
			driver=new InternetExplorerDriver();
			ie=driver;
		}else if(browserType.equals("IE")&&ie!=null){
			driver=ie;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	public void navigate(String url){
		driver.get(CONFIG.getProperty(url));
		
	}
	
	public void click(String objectName){
		driver.findElement(By.xpath(OR.getProperty(objectName))).click();
	}
	
	public void type(String objectName,String value){
		driver.findElement(By.xpath(OR.getProperty(objectName))).sendKeys(value);
		
	}
	
	public void select(String objectName,String value){
		driver.findElement(By.xpath(OR.getProperty(objectName))).sendKeys(value);
	}
	
	public boolean isElementPresent(String objectName){
		List<WebElement> elements=driver.findElements(By.xpath(OR.getProperty(objectName)));
		if(elements.size()!=0)
			return true;
		else 
			return false;
	}
	
	/***********************Application functions*********************/
	public boolean isLoggedIn(String objectName){
		if(isElementPresent(objectName))
		return true;
		else 
		return false;
	}
	
	public void doDefaultLogin(){
		navigate("LoginURL");
		type("loginusername", CONFIG.getProperty("defaultusername"));
		type("loginusername", CONFIG.getProperty("defaultpassword"));
		click("loginButton");
		
	}
	
	/********************Logging**********************************/
	public void log(String msg){
		APPLICATION_LOGS.debug(msg);
	}
}
