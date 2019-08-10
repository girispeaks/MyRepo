package seleniumLearning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ClickAllLinks3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "//users//girishr//Downloads//geckodriver");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://shopping.rediff.com/?sc_cid=ushome_icon");
		List<WebElement> lst=driver.findElements(By.xpath("//*[@class='popularcatlink']"));
		System.out.println("Total links "+lst.size());
		for(int i=0;i<lst.size();i++){
			System.out.println(lst.get(i).getText()+"------"+lst.get(i).isDisplayed());
			lst.get(i).click();
			//System.out.println(lst.get(i).getText());//+"------"+lst.get(i).isDisplayed());
			System.out.println(driver.getTitle());
			driver.get("http://shopping.rediff.com/?sc_cid=ushome_icon");	
			lst=driver.findElements(By.xpath("//*[@class='popularcatlink']"));
		}
		driver.quit();

	}

}
