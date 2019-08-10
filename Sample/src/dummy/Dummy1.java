package dummy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Dummy1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C://Users//gramakrishn6//Desktop//Jars//geckodriver-v0.17.0-win64//geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://google.com");
		driver.findElement(By.xpath("//input[@class='gsfi' or @id='lst-ib']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@class='gsfi']")).sendKeys(Keys.ENTER);
		Thread.sleep(9000);
		//WebElement ele=driver.findElement(By.xpath("//*[@id='rso']/div[3]/div/div[1]/div/div/h3/a"));
		//System.out.println(ele.getText());
		List<WebElement> links=driver.findElements(By.xpath("//div[@class='srg']/div/div[1]/div[1]/h3/a"));
		Thread.sleep(9000);
		System.out.println("Total Links "+links.size());
	}

}
