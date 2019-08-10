
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Demoqa {
	@Test
	public static void registration() throws Exception{
		System.setProperty("webdriver.gecko.driver", "//users//girishr//Desktop//geckodriver");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("http://demoqa.com");
		WebElement regButton=driver.findElement(By.xpath("//div[@class='menu-registration-container']/ul/li/a"));
		//print button name
		System.out.println("Button name is "+regButton.getText());
		regButton.click();
		WebDriverWait wt=new WebDriverWait(driver,10);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='post-49']/header/h1")));
		System.out.println("Page loaded");
		//WebElement frames=driver.findElement(By.tagName("iframe"));
		//System.out.println("Size of frame is "+frames.size());
		//String frameid=frames.get(0).getText();
		//driver.switchTo().frame(frames);
		WebElement fname=driver.findElement(By.xpath("//*[@id='name_3_firstname']"));
			//System.out.println(fname.getText());
		//fname.click();
		fname.sendKeys("dummy");
	}

}
