package com.qa.test;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;



public class BaseClass {
	public Properties prop=null;
	public WebDriver driver=null;
	
	
	public void initProp() throws Exception{
		File f=new File("");
		FileInputStream ip=new FileInputStream(f);
		prop=new Properties();
		prop.load(ip);
	}
	
	public void openBrowser(String browser){
		if(browser.equals("Mozilla")){
			System.setProperty("webdriver.gecko.driver", "");
			driver=new FirefoxDriver();
		}else if(browser.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "");
			driver=new ChromeDriver();
		}else{
			System.setProperty("webdriver.ie.driver", "");
			driver=new InternetExplorerDriver();		
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	public void launchApp(String url){
		driver.get("");		
	}
	
	public void type(String locator, String value){
		driver.findElement(By.xpath(locator)).sendKeys(value);
		WebElement ele=null;
		Select select=new Select(ele);
		select.selectByVisibleText("India");
		Alert alert=driver.switchTo().alert();
		Set<String> set=driver.getWindowHandles();
		for(String hand:set){
			
		}
		
	}
	
	public void scriptjava(WebDriver driver, WebElement element){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
		
	}
	
	public void waitSele(String sec) throws Exception{
		try{
		Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String state=(String)js.executeScript("return document.readyState");
		while(!state.equals("complete")){
			Thread.sleep(1000);		
			state=(String)js.executeScript("return document.readyState");
		}
		
	}
	
	public void database() throws Exception{
		String username="sdfd";
		String password="dsfs";
		String name=null;
		String url="mysql://ip:8080//schema";
		
		Class.forName("com.mysql.jdbc.driver");
		Connection con=DriverManager.getConnection(url, username, password);
		Statement st=con.createStatement();
		ResultSet res=st.executeQuery("select * from db");
		while(res.next())
			name=res.getString(1);
	}
}
