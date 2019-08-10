package com.selcukesfw.stepimplementations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CourseraRegistration {

	public void courseraRegistration() {
		WebDriver driver = new ChromeDriver();

		driver.get("https://accounts.coursera.org/signup");
		WebElement fullname = driver.findElement(By.id("coursera-signup-fullname"));
		fullname.sendKeys("my full name");
		WebElement email = driver.findElement(By.id("coursera-signup-email"));
		email.sendKeys("test@gmail.com");
		WebElement confirmEmail = driver.findElement(By.id("coursera-signup-email-confirm"));
		confirmEmail.sendKeys("test@gmail.com");
		WebElement password = driver.findElement(By.id("coursera-signup-password"));
		password.sendKeys("password123");
		WebElement terms = driver.findElement(By.id("coursera-signup-agree"));
		terms.click();
		WebElement signup = driver.findElement(By.xpath("//*[@id=\"origami\"]/div/div/div[1]/div[3]/div/div/div[2]/div[1]/div/form/div[8]/div/button[1]"));
		signup.click();
		String bodyText = driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue("'Welcome to Coursera!' not found on the page", bodyText.contains("Welcome to Coursera!"));
	}

}


