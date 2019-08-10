package com.testing;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class YahooTest {
	@Test
	public void testYahoo(){
	System.setProperty("webdriver.gecko.driver", "//users//girishr//Downloads//geckodriver");
	WebDriver driver=new FirefoxDriver();
	driver.get("http://yahoo.com");
	driver.quit();
	}
}
