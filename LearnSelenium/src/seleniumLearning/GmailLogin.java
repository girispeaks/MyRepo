package seleniumLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GmailLogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "//users//girishr//Downloads//geckodriver");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://yahoo.com");
		Thread.sleep(20000);
		//driver.findElement(By.xpath("//*[@id='UHSearchBox']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='UHSearchBox']")).sendKeys("games");
		String str = driver.findElement(By.xpath("//*[starts-with(@id='yui_3_12')]/li[3]/a[@text='games for girls']")).getText();
		Thread.sleep(2000);
		//String str=driver.getTitle();
				//driver.findElement(By.xpath("//div[@class='logo logo-w']")).getText();
		System.out.println(str);
		driver.quit();
	}

}
