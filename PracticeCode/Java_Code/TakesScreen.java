package com.qa.test;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakesScreen {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		Date d=new Date();
		String fname=d.toString().replaceAll(" ", "_").replaceAll(":", "")+".jpg";
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyDirectory(f, new File("c://desktop/"+fname));
		//test.log(LogStatus.INFO, "Screenshot--->"+test.addScreenCapture(c://desktop/"+fname)
	}

}
