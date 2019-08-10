package seleniumPractice;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Phones {
	
	@Test
	public void getPhones(){
		String offer;
		String price;
		String item;
		System.setProperty("webdriver.gecko.driver", "C://Users//gramakrishn6//Desktop//Jars//geckodriver-v0.17.0-win64//geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//a[@class='Vh2GZz']/p[text()='Mobiles & Tablets']")).click();
		//driver.switchTo().activeElement();
		//*[@id="container"]/div/div[1]/div/div[2]/div[2]/div/div[1]/div/div/div[2]/a[1]/p
		List<WebElement> itemNames=driver.findElements(By.xpath("//div[@class='_2kSfQ4']/div[contains(@data-tkid,'1c355474c4f0_3')]/a/div[2]"));
		List<WebElement> itemOffer=driver.findElements(By.xpath("//div[@class='_2kSfQ4']/div[contains(@data-tkid,'1c355474c4f0_3')]/a/div[3]"));
		List<WebElement> itemPrice=driver.findElements(By.xpath("//div[@class='_2kSfQ4']/div[contains(@data-tkid,'1c355474c4f0_3')]/a/div[4]"));
		/*for(int i=0;i<itemNames.size();i++)
			System.out.println(itemNames.get(i).getText());*/
		System.out.println(itemNames.size());
		/*for(int i=0;i<itemNames.size();i++)
			if(itemNames.get(i).getText().contains("Samsung")){
				item=itemNames.get(i).getText();
				offer=itemOffer.get(i).getText();
				price=itemPrice.get(i).getText().split(" ")[1].split("?")[1];
				System.out.println(item+"---"+offer+"----"+price);
			}*/
			//System.out.println(ele.getText());
	}

}
