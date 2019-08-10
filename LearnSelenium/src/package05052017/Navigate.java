package package05052017;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Navigate {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "//users//girishr//Downloads//geckodriver");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("http://google.com");
		driver.findElement(By.xpath("//div[@id='als']/div/a[text()='English']")).click();
		driver.findElement(By.xpath("html/body/div[1]/div[3]/form/div[2]/div[2]/div[1]/div[1]/div[3]/div/div/div[3]/div/input[3]")).sendKeys("Bangalore");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='sbsb_a']/ul/li[1]")).click();
		int i=2;
		while(isElementFound("//div[@id='navcnt']/table/tbody/tr/td/a[text()="+i+"]")){
			WebElement link=driver.findElement(By.xpath("//div[@id='navcnt']/table/tbody/tr/td/a[text()="+i+"]"));
			link.click();
			Thread.sleep(3000);
			i++;
		}
		//WebElement link=driver.findElement(By.xpath("//div[@id='navcnt']/table/tbody/tr/td/a[text()='3']"));
	}
	
	public static Boolean isElementFound(String xpth){
		List<WebElement> count=driver.findElements(By.xpath(xpth));
		if(count.size()==0){
			return false;
		}
			else
				return true;
		}
	
}
