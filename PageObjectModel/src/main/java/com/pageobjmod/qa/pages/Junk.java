package com.pageobjmod.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pageobjmod.qa.base.BaseTest;

public class Junk extends BaseTest{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//System.out.println(System.getProperty("user.dir"));
		BaseTest test=new BaseTest();
		System.setProperty("webdriver.chrome.driver", "C://Users//gramakrishn6//Desktop//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.freecrm.com");
		Thread.sleep(3000);
		String str=driver.getTitle();
		System.out.println(str);
		driver.findElement(By.name("username")).sendKeys("girispeaks");
		driver.findElement(By.name("password")).sendKeys("Wed@1234");
		/*
		System.out.println(test.prop.getProperty("browser"));*/
	}

}
