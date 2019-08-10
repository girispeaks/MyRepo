package com.testing;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Unit test for simple App.
 */
public class GoogleTest {
    
    @Test
    public void testGoogle(){
    	System.setProperty("webdriver.gecko.driver", "//users//girishr//Downloads//geckodriver");
    	WebDriver driver=new FirefoxDriver();
    	driver.get("http://google.com");
    	driver.quit();
}

}