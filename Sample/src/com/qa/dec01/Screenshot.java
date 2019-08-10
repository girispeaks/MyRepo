package com.qa.dec01;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Screenshot {
	public static void main(String[] args) throws Exception{
		takeScreenshot();
	}
	public static void takeScreenshot() throws IOException, Exception{
		System.setProperty("webdriver.gecko.driver", "C://Users//gramakrishn6//Desktop//Jars//geckodriver-v0.17.0-win64//geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.google.com");
		Thread.sleep(5000);
		Date d=new Date();
		String fileNm=d.toString().replaceAll(":", "_").replaceAll(" ", "_")+".jpg";
		TakesScreenshot st=(TakesScreenshot)driver;
		File f=st.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("C://Users//gramakrishn6//workspace//Sample//Resource//"+fileNm));
	}

}
