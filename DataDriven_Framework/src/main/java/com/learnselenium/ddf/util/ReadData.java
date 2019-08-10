package com.learnselenium.ddf.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class ReadData {
	static WebDriver driver=null;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "//users//girishr//Desktop//geckodriver");

		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://zoho.com");
		waitPageLoad();
		driver.findElement(By.xpath("//div[@class='signing']/a[3]")).click();
		//div[@class='signing']/a[@text()='login']
		waitPageLoad();
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("document.getElementById('username').value=\"girispeaks@gmail.com\";");
		//js.executeScript("document.getElementById('password').value=\"Wed@1234\";");
		driver.findElement(By.xpath("//input[@id='lid']")).sendKeys("girispeaks@gmail.com");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("Wed@1234");
		driver.findElement(By.xpath("//*[@id='submit_but']")).click();
	}
	
	public static void waits(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void waitPageLoad(){
		String state=null;
		waits();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		state=(String)js.executeScript("return document.readyState;");
		while(!state.equals("complete")){
			waits();
			state=(String)js.executeScript("return document.readyState;");
		}		
	}
}
