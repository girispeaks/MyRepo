package com.qtpselenium.zoho.project.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "//users//girishr//Desktop//geckodriver");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://zoho.com");
		driver.findElement(By.xpath("//a[@class='signin']")).click();
		Thread.sleep(8000);
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='lid']")).sendKeys("girispeaks@gmail.com");
		driver.findElement(By.xpath("//*[@id='pwd']")).sendKeys("pass@1234");
		driver.findElement(By.xpath("//*[@id='submit_but']")).click();
		//driver.findElements(By.xpath(""))
		//Thread.sleep(3000);
		//driver.switchTo().defaultContent();
		//Thread.sleep(3000);
		//int size=driver.findElements(By.tagName("iframe")).size();
		//System.out.println(size);
		//driver.findElement(By.xpath("//*[@id='zl-myapps']/div[1]/div[2]/div/a/span")).click();

	}

}
