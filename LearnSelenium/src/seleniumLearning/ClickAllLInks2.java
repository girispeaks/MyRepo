package seleniumLearning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ClickAllLInks2 {
	static WebDriver driver=null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "//users//girishr//Downloads//geckodriver");
		driver=new FirefoxDriver();
		driver.get("http://shopping.rediff.com/?sc_cid=ushome_icon");
		String str1="//*[@id='popular_cat']/h3[";
		String str2="]/a";
		int i=0;
		while(isElementPresent(str1+i+str2)){
			driver.findElement(By.xpath(str1+i+str2)).click();
			System.out.println(driver.getTitle());
			driver.get("http://shopping.rediff.com/?sc_cid=ushome_icon");
			i++;
		}

	}
	public static Boolean isElementPresent(String xpathexp){
		List<WebElement> ele=driver.findElements(By.xpath(xpathexp));
		if(ele.size()==0)
			return false;
			else 
				return true;
	}

}



//*[@id='popular_cat']/h3[1]/a
//*[@id='popular_cat']/h3[2]/a
//*[@id='popular_cat']/h3[14]/a