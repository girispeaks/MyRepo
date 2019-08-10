package com.learnselenium.ddf.zoho.Basetest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import com.learnselenium.ddf.util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest{
	public WebDriver driver=null;
	public Properties prop=null;
	public ExtentTest test=null;
	public ExtentReports extent=ExtentManager.getInstance();
	
	/***************Generic functions***********************/
	
	public void init(){
		if(prop==null){	
		prop=new Properties();
		try{
		FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//OR.properties");
		prop.load(ip);
		
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
			}
		}
	}
	
	public void wait(int timesec){
		try{
			Thread.sleep(timesec*1000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void waitPageLoad(){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String state=(String)js.executeScript("return document.readystate");
		while(state!="complete"){
			wait(1);
			state=(String)js.executeScript("return document.readystate");
		}
	}
	
	public void openBrowser(String browser){
		if(browser.equals("Mozilla")){
			System.setProperty("webdriver.gecko.driver", "//users//girishr//Desktop//geckodriver");
			 driver=new FirefoxDriver();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}else if(browser.equals("Chrome")){
			System.setProperty("webdriver.gecko.driver", "//users//girishr//Desktop//chromedriver");
			 driver=new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}else if(browser.equals("IE")){
			System.setProperty("webdriver.gecko.driver", "//users//girishr//Desktop//IE");
			 driver=new InternetExplorerDriver();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}		
	}
	
	public void navigate(String envi){
		if(envi.equals("UAT"))
		driver.get(prop.getProperty("UAT"));
		else if(envi.equals("Production"))
		driver.get(prop.getProperty("Production"));
		else
			System.out.println("Incorrect environment");
	}
	
	
	/*******************Reporting
	 * @throws Exception *********************/
	
	public void reportPass(String msg) throws Exception{
		test.log(LogStatus.PASS, msg);
	}
	
	public void reportFailure(String msg) throws Exception{
		test.log(LogStatus.FAIL, msg);
		Assert.fail();
		screenShot();
	}
	
	public void screenShot() throws Exception{
		Date d=new Date();
		String sname=d.toString().replaceAll(":", "_").replaceAll(" ", "_");
		File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File(System.getProperty("user.dir")+"//Screens//"+sname+".png"));
		test.log(LogStatus.INFO, "Screens-->"+test.addScreenCapture(System.getProperty("user.dir")+"//Screens"+sname+".png"));
	}

}
