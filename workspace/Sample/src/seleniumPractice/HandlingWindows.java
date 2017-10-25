package seleniumPractice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C://Users//gramakrishn6//Desktop//Jars//geckodriver-v0.17.0-win64//geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"t");
		Set<String> win=driver.getWindowHandles();
		System.out.println(win.size());
		Iterator<String> it=win.iterator();
		while(it.hasNext()){
			
			String window=(String)it.next();
			window=it.hasNext()?it.next():window;
			driver.switchTo().window(window);
			//driver.switchTo().window("27");
			driver.get("http://gmail.com");
				
			
			//driver.switchTo().defaultContent();
		}
		
	/*	try{
		driver.get("http://gmail.com");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}*/
		//System.out.println(win.size());
		//driver.switchTo().window(win.);
	}

}
