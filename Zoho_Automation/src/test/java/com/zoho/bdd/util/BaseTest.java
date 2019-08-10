package com.zoho.bdd.util;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseTest {
	WebDriver driver=null;
	Properties prop=null;
	public void init(){
		if(prop==null){
		prop=new Properties();
		try
		{
		FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resource\\config\\OR.properties");
		prop.load(ip);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
			}
		}
	}
	
	public void launchBrowser(String browser){
		init();
		if(prop.get(browser).equals("Mozilla")){
			System.setProperty("webdriver.gecko.driver", "C://Users//gramakrishn6//Desktop//Jars//geckodriver-v0.17.0-win64//geckodriver.exe");
			driver=new FirefoxDriver();
		}else if(prop.getProperty(browser).equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "C://Users//gramakrishn6//Desktop//Jars//geckodriver-v0.17.0-win64//geckodriver.exe");
			driver=new ChromeDriver();
		}else if(prop.getProperty(browser).equals("IE")){
			System.setProperty("webdriver.ie.driver", "C://Users//gramakrishn6//Desktop//Jars//geckodriver-v0.17.0-win64//geckodriver.exe");
			driver=new InternetExplorerDriver();
		}else{
			System.setProperty("webdriver.gecko.driver", "C://Users//gramakrishn6//Desktop//Jars//geckodriver-v0.17.0-win64//geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public int frames(){
		List<WebElement> frame=driver.findElements(By.tagName("iframe"));
		return frame.size();
	}
	
	public int switchframe(String locator){
		int i=0;
		int totfrm=driver.findElements(By.tagName("iframe")).size();
		//System.out.println("totalframes "+totfrm);
		for(i=0;i<totfrm;i++){
			//System.out.println("Entering for loop");
			driver.switchTo().frame(i);
			wait(1000);
			int ele=driver.findElements(By.xpath(prop.getProperty(locator))).size();
			//System.out.println("Total Elements "+ele);
			driver.switchTo().defaultContent();	
			if(ele>0){
				break;						
			}								
		}
		//driver.switchTo().activeElement().getAttribute("id");
		//driver.findElement(By.cssSelector("")).getCssValue("color");
		return i;
		
		
		/*List<WebElement> frames=driver.findElements(By.tagName("iframe"));
		System.out.println("total frames "+frames.size());
		for(int i=1;i<=frames.size();i++){
			driver.switchTo().frame(frames.get(i));
			List<WebElement> elements=driver.findElements(By.xpath(locator));
			System.out.println("Webelement size "+elements.size());
			if(elements.size()>0){
				System.out.println("Element found");
				break;		
			}
			frames=driver.findElements(By.tagName("iframe"));
		}*/
	}
	public void navigate(String url){
		driver.get(prop.getProperty(url));
		pageLoad();
	}
	
	public void type(String locator, String value)throws Exception{
		/*if(frames()<=1)
			getElement(locator).sendKeys(value);	
		else{
			int frm=switchframe(locator);
			System.out.println("Frame to be switched");
			driver.switchTo().frame(frm);*/
			getElement(locator).sendKeys(value);
			//driver.switchTo().defaultContent();
			/*switchframe(locator);
			getElement(locator).sendKeys(value);
			driver.switchTo().defaultContent();*/
		//}
	}
	
	public void click(String locator)throws Exception{
		//if(frames()<=1){
		getElement(locator).click();
		//pageLoad();
		/*} else {
			driver.switchTo().frame(switchframe(locator));
			getElement(locator).click();			
			driver.switchTo().defaultContent();
			//pageLoad();
		}*/
	}
	
	/*public boolean validateText(String locator){
		if(getElement(locator).isDisplayed())
			return true;
		else
			return false;
	}*/
	
	public void wait(int milsec){
		try
		{
			Thread.sleep(milsec);
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void pageLoad(){
		wait(1000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String state=(String)js.executeScript("return document.readyState");
		while(!state.equals("complete")){
			wait(1000);
			state=(String)js.executeScript("return document.readyState");
		}
	}
	
	public WebElement getElement(String locator)throws Exception{
		WebElement element=null;
		
		if(frames()<=1){
		element=driver.findElement(By.xpath(prop.getProperty(locator)));
		return element;
		}
		else{
			driver.switchTo().frame(switchframe(locator));			
			element=driver.findElement(By.xpath(prop.getProperty(locator)));
			return element;
			//driver.switchTo().defaultContent();
		}
		
	
		
		
		//}catch(Exception e){
		//	e.printStackTrace();
		//	System.out.println(e.getMessage());
		//	Assert.fail();
		//}
		/*try
		{
		if(locator.endsWith("_id")){
			element=driver.findElement(By.id("object"));
		}else if(locator.endsWith("_xpath")){
			element=driver.findElement(By.xpath("object"));
		}else if(locator.endsWith("_name")){
			element=driver.findElement(By.name("object"));
		}else if(locator.endsWith("_classname")){
			element=driver.findElement(By.className("object"));
		}else if(locator.endsWith("_tagname")){
			element=driver.findElement(By.tagName("object"));
		}else if(locator.endsWith("_linktext")){
			element=driver.findElement(By.linkText("object"));
		}else if(locator.endsWith("_partiallinktext")){
			element=driver.findElement(By.partialLinkText("object"));
		}else if(locator.endsWith("_cssValue")){
			element=driver.findElement(By.cssSelector("object"));
		}else{
			Assert.fail("Incorrect locator");
		}
		}catch(Exception e){
			Assert.fail(e.getMessage());
		}*/
		//return element;
	}
	
	public void dfltWind(){
		driver.switchTo().defaultContent();
	}
	
	public Boolean isElementPresent(String locator)throws Exception{
/*		List<WebElement> elements=driver.findElements(By.xpath(prop.getProperty(locator)));
		if(elements.size()!=0)
			return true;
		else
			return false;*/
		if(getElement(locator).isDisplayed())
			return true;
		else
			return false;
		
		
		
		/*if(frames()<=1){
			if(getElement(locator).isDisplayed());
				return true;
		}
		if (frames()>1){
			driver.switchTo().frame(switchframe(locator));
			if(getElement(locator).isDisplayed());
			//driver.switchTo().defaultContent();
			return true;
		}
		
		return false;*/
	}
	
	public void doLogin(String browser) throws Exception{
		launchBrowser(browser);
		navigate("url");
		click("login_link");
		dfltWind();
		type("email",prop.getProperty("default_email"));
		dfltWind();
		type("password",prop.getProperty("default_pwd"));
		dfltWind();
		click("sign_in");
		/*wait(1000);
		pageLoad();*/
		dfltWind();
		wait(1000);
	}
	
	public void quit(){
		driver.quit();
	}
	
	
}
