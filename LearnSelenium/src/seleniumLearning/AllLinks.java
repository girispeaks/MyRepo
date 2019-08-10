package seleniumLearning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AllLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "//users//girishr//Downloads//geckodriver");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://rediff.com");
		List<WebElement> alllink=driver.findElements(By.tagName("a"));
		int size=alllink.size();
		System.out.println("Total number of links "+size);
		for(int i=0;i<size;i++)
			System.out.println(alllink.get(i).getText()+"--------"+alllink.get(i).isDisplayed());
		driver.quit();

	}

}
