package com.qa.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FreeCRMLogin {
	
	@Test
	public void CRMLogin() throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gramakrishn6\\workspace\\Practice\\src\\Resource\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com/index.html");
		Thread.sleep(4000);
		driver.switchTo().frame("intercom-borderless-frame");
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//span[text()='CRMPRO']")));
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='intercom-container']/div/div[1]/div/div/span")).click();
		//Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("girispeaks");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Wed@1234");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

}
