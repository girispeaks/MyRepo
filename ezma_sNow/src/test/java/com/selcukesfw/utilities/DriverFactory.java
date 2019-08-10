package com.selcukesfw.utilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.configuration.XMLConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DriverFactory {
	private static WebDriver driver;
    
    private DriverFactory(){}
     
    public static WebDriver getDriver(){
    	if(driver==null || (driver != null && driver.toString().contains("null"))){
            try{
            	XMLConfiguration config = new XMLConfiguration("configurations/object-config.xml");
            	String browserType = config.getString("browser");
            	
            	if(browserType != null && browserType.equalsIgnoreCase("chrome"))
            	{
            	
            		driver = new ChromeDriver();
            	}else{
            		File pathBinary = new File("C://Program Files (x86)//Mozilla Firefox//firefox.exe");
            		FirefoxBinary Binary = new FirefoxBinary(pathBinary);
            		FirefoxProfile firefoxPro = new FirefoxProfile();       
            		driver = new FirefoxDriver(Binary,firefoxPro);
            		//driver = new FirefoxDriver();
            	}   
//            	driver = new HtmlUnitDriver(true);
        		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        		driver.manage().window().maximize();
            }
                        catch(Exception e){
                        	System.out.println("ASP Ex: "+e.getMessage());
                throw new RuntimeException("Exception occured in creating driver object");
            }
    	}
        return driver;
    }
    
    public static void quit()
    {
    	if(!(driver==null || (driver != null && driver.toString().contains("null")))){
    		driver.quit();
    	}
    }
}
