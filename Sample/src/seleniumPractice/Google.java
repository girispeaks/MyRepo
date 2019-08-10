package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gramakrishn6\\Desktop\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://google.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		int i=2;
		WebElement page=driver.findElement(By.xpath("//table[@id='nav']/tbody/tr/td/a[text()='"+i+"']"));
		while(page.isDisplayed()){
			page.click();
			Thread.sleep(2000);
			i++;
			page=driver.findElement(By.xpath("//table[@id='nav']/tbody/tr/td/a[text()='"+i+"']"));
		}
			
		//System.out.println(nav.getText());
	}

}
