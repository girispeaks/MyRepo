package seleniumLearning;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sellinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "//users//girishr//Downloads//geckodriver");
		WebDriver driver=new FirefoxDriver();
		driver.navigate().to("http://shopping.rediff.com/?sc_cid=ushome_icon");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement prodlink=driver.findElement(By.id("popular_cat"));
		//System.out.println(prodlink.getText());
		List<WebElement> allplinks=prodlink.findElements(By.tagName("a"));
		System.out.println("No of links in product categories "+allplinks.size());
		for(int i=0;i<allplinks.size();i++)
		System.out.println(allplinks.get(i).getText());
		driver.quit();
	}

}
