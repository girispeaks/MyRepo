package seleniumLearning;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ClickAllLinks1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "//users//girishr//Downloads//geckodriver");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://shopping.rediff.com/?sc_cid=ushome_icon");
		WebElement prod=driver.findElement(By.id("popular_cat"));
		List<WebElement> links=prod.findElements(By.tagName("a"));
		for(int i=0;i<links.size();i++){
			links.get(i).click();
			System.out.println(driver.getTitle());
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver.get("http://shopping.rediff.com/?sc_cid=ushome_icon");
			prod=driver.findElement(By.id("popular_cat"));
			links=prod.findElements(By.tagName("a"));
		}
		//links.get(13).click();
		//System.out.println(driver.getTitle());
		driver.quit();
	}

}

//*[@id='popular_cat']/h3[1]/a
//*[@id='popular_cat']/h3[2]/a
//*[@id='popular_cat']/h3[14]/a

