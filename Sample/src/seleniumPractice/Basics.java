package seleniumPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Basics {
	WebDriver driver=null;
	public void openBrower(String browser){
		if(browser.equals("Mozilla")){
			System.setProperty("webdriver.gecko.driver", "");
			driver=new FirefoxDriver();
		}else if(browser.equals("IE")){
			System.setProperty("webdriver.gecko.driver", "");
			driver=new InternetExplorerDriver();
		}else if(browser.equals("Chome")){
			System.setProperty("webdriver.gecko.driver", "");
			driver=new ChromeDriver();
		}
	}
	
	public void launchApp(String url){
		driver.get(url);
		wait(1);
		pageload();
	}
	
	public void wait(int sec){
		try{
		Thread.sleep(sec*1000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void pageload(){
		wait(1);
		String state=(String)((JavascriptExecutor)driver).executeScript("return document.readystate");
		while(state!="complete"){
			wait(1);
			state=(String)((JavascriptExecutor)driver).executeScript("return document.readystate");
		}
	}
	
	public void prop() throws Exception{
		Properties prp=new Properties();
		FileInputStream ip=new FileInputStream("C:\\Users\\gramakrishn6\\workspace\\Sample\\src\\test12092017\\Test.properties");
		prp.load(ip);
		prp.getProperty("url");
	}
}
