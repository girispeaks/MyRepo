package seleniumLearning;

//package practice27042017;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetLinks1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "//users//girishr//Downloads//geckodriver");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.get("http://shopping.rediff.com/");
		WebElement box=driver.findElement(By.xpath("//div[@id='popular_cat']"));
		List<WebElement> links=box.findElements(By.tagName("a"));
		System.out.println("Number of links "+links.size());
		//for(WebElement lk:links){
		for(int i=0;i<links.size();i++){
			links.get(i).click();
			//lk.click();
			System.out.println("Link1");
			driver.get("http://shopping.rediff.com/");
			System.out.println("Back to home");
			box=driver.findElement(By.xpath("//div[@id='popular_cat']"));
			System.out.println("Get box");
			links=box.findElements(By.tagName("a"));
			System.out.println("Get links");
		}
	}

}