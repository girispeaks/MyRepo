package com.qtpselenium.core.dff.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.qtpselenium.core.dff.util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {
	public WebDriver driver;
	public Properties prop=null;
	public ExtentReports rep=ExtentManager.getInstance();
	public ExtentTest test;
	public SoftAssert sa=null;

	public void init(){
		if(prop==null){
			prop=new Properties();
			try{
			FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//projectconfig.properties");
			prop.load(fs);
			} catch(Exception e){
				e.getStackTrace();
			}
		}
	}
	public void openBrowser(String bType) throws IOException{
		
		if(bType.equals("Mozilla")){
			System.setProperty("webdriver.gecko.driver", prop.getProperty("geckodriver_exe"));
			driver=new FirefoxDriver();
		}else if(bType.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver_exe"));
			driver=new ChromeDriver();
		}else if(bType.equals("IE")){
			System.setProperty("webdriver.IE.driver", prop.getProperty("iedriver_exe"));
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
	}
	public void navigate(String url){
		driver.get(prop.getProperty(url));
	}
	
	public void type(String emailxpthkey, String val){
		getElement(emailxpthkey).sendKeys(prop.getProperty(val));;
		//driver.findElement(By.xpath(prop.getProperty(emailxpthkey))).sendKeys(prop.getProperty(val));
	}
	public void click(String clickkey){
		getElement(clickkey).click();
		//driver.findElement(By.xpath(prop.getProperty(clickkey))).click();
		
	}
	
	public WebElement getElement(String locator){
		WebElement e=null;
		try{
		if(locator.endsWith("_xpath")){
			e=driver.findElement(By.xpath(prop.getProperty(locator)));
		}else if(locator.endsWith("_id")){
			e=driver.findElement(By.id(prop.getProperty(locator)));
		}else if(locator.endsWith("_name")){
			e=driver.findElement(By.name(prop.getProperty(locator)));
		}else if(locator.endsWith("_tagName")){
			e=driver.findElement(By.tagName(prop.getProperty(locator)));		
		}else {
			reportFailure("Invalid locator "+locator);
			//Assert.fail("Invalid locator "+locator);
		}
		}catch(ElementNotFoundException ex){
			//fail the test case and report error
			reportFailure(ex.getMessage());
			ex.printStackTrace();
			Assert.fail("Fail the test - "+ex.getMessage());
		}
		return e;

	}

	/*************Validations*******************/
	public boolean verifyTitle(String locator, String expectedText){
		String actualText=null;
		actualText=getElement(locator).getText().trim();
		if(actualText.equals(prop.getProperty(expectedText)))		
			return true;
		else
			return false;
	}
	public boolean isElementPresent(String locator){
		List<WebElement> elementList=null;		
		if(locator.endsWith("_xpath")){
			elementList=driver.findElements(By.xpath(prop.getProperty(locator)));
		}else if(locator.endsWith("_id")){
			elementList=driver.findElements(By.id(prop.getProperty(locator)));
		}else if(locator.endsWith("_name")){
			elementList=driver.findElements(By.name(prop.getProperty(locator)));
		}else if(locator.endsWith("_tagName")){
			elementList=driver.findElements(By.tagName(prop.getProperty(locator)));		
		}else {
			reportFailure("Invalid locator "+locator);
			Assert.fail("Invalid locator "+locator);
		}
		if(elementList.size()==0)
			return false;
		else 
			return true;	
	}
	
	
	/*************Reporting*******************/
	public void reportPass(String msg){
		test.log(LogStatus.PASS, msg);
	}
    public void reportFailure(String msg){
    	test.log(LogStatus.FAIL, msg);
		takeScreenshot();
		Assert.fail(msg);
	}
    public void takeScreenshot(){
    	//file name of screenshot
    	Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		//store screenshot in that file
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));
		}catch(IOException e){
			e.printStackTrace();
		}
		//puts screenshot into reports
		test.log(LogStatus.INFO, "Screenshot-->"+test.addScreenCapture(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));
	}
}
