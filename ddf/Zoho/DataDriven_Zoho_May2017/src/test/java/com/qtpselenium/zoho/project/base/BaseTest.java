package com.qtpselenium.zoho.project.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.qtpselenium.zoho.project.util.ExtentManager;
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
			test.log(LogStatus.INFO, "Opening the browser "+bType);
		}else if(bType.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver_exe"));
			driver=new ChromeDriver();
			test.log(LogStatus.INFO, "Opening the browser "+bType);
		}else if(bType.equals("IE")){
			System.setProperty("webdriver.IE.driver", prop.getProperty("iedriver_exe"));
			driver=new InternetExplorerDriver();
			test.log(LogStatus.INFO, "Opening the browser "+bType);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Browser opened successfully "+bType);
	}
	public void navigate(String url){
		driver.get(url);
		test.log(LogStatus.INFO, "Launching the application");
	}
	
	public void type(String emailxpthkey, String val){
		test.log(LogStatus.INFO, "Typing in "+emailxpthkey+" . Data - "+val);
		getElement(emailxpthkey).sendKeys(val);;
		//driver.findElement(By.xpath(prop.getProperty(emailxpthkey))).sendKeys(prop.getProperty(val));
		test.log(LogStatus.INFO, "Typed successfully in "+emailxpthkey+" . Data - "+val);
	}
	public void click(String clickkey){
		if(getElement(clickkey).isEnabled()){
			getElement(clickkey).click();
			test.log(LogStatus.INFO, "Successfully clicked the button "+clickkey );
		}
		else
			reportFailure("Element not enabled");
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
		}catch(Exception ex){
			//fail the test case and report error
			reportFailure(ex.getMessage());
			ex.printStackTrace();
			Assert.fail("Fail the test - "+ex.getMessage());
		}
		return e;

	}
	
	public void waitForPageToLoad(){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String state=(String)js.executeScript("return document.readyState");
		while(!state.equals("complete")){
			try {
				Thread.sleep(2000);
				state=(String)js.executeScript("return document.readyState");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void wait(int timeinsecs){
		try {
			Thread.sleep(timeinsecs*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void acceptAlert(){
		WebDriverWait wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}
	
	/*************Application Functions
	 * @throws Exception *****************/
	
	public boolean doLogin(String userid, String pwd) throws Exception{
		test.log(LogStatus.INFO, "Trying to login with "+userid+","+pwd);
		click("loginLink_xpath");
		//Wait for page to load
		wait(1);
		waitForPageToLoad();
		driver.switchTo().frame(0);
		wait(1);
		waitForPageToLoad();
		type("userid_xpath",userid);
		type("password_xpath",pwd);
		click("signBtn_xpath");
		wait(1);
		waitForPageToLoad();
		driver.switchTo().defaultContent();
		wait(1);
		waitForPageToLoad();
		if(isElementPresent("crmLink_xpath")){
			test.log(LogStatus.INFO, "Login Success");
			return true;
		}
		else{
			test.log(LogStatus.INFO, "Login Failed");
			return false;
		}
	}
	
	public int getLeadRowNum(String leadName){
		test.log(LogStatus.INFO, "Finding lead name after its created" +leadName);
		List<WebElement> leadNames=driver.findElements(By.xpath(prop.getProperty("leadNames_xpath")));
		for(int i=0;i<leadNames.size();i++){
			if(leadName.equals(leadNames.get(i).getText().trim())){
				test.log(LogStatus.INFO, "Found Lead name at "+(i+1));
				return (i+1);		
			}
		}	
		test.log(LogStatus.INFO,"Lead not found");
		return -1;
	}
	
	public void clickOnLead(String leadName){
		test.log(LogStatus.INFO, "Clicking on Lead" +leadName);
		List<WebElement> leadNames=driver.findElements(By.xpath(prop.getProperty("leadNames_xpath")));
		for(int i=0;i<leadNames.size();i++){
			if(leadName.equals(leadNames.get(i).getText().trim())){
				test.log(LogStatus.INFO, "Found Lead name at "+(i+1));
				leadNames.get(i).click();
				test.log(LogStatus.INFO, "Successfully clicked on Lead "+leadName);
				break;
			}
		}
	}
//table[@id='listViewTable']/tbody/tr/td[4]
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
