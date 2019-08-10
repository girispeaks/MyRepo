package seleniumLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DrpDwn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "//users//girishr//Downloads//geckodriver");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://qtpselenium.com/home/contact_trainer");
		WebElement drop=driver.findElement(By.name("country_id"));
		//String str="test";
		
		//drop.sendKeys("Australia");
		//System.out.println(drop.getAttribute("value"));
		//System.out.println(drop.getText());
		//List<WebElement> opt=drop.findElements(By.tagName("option"));
		//System.out.println("Dropdown list size "+opt.size());
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//drop.sendKeys("Egypt");
		//for(int i=0;i<opt.size();i++)
		//	System.out.println(opt.get(i).getText());
		//driver.quit();
		Select sel=new Select(drop);
		//sel.selectByValue("10");
		//System.out.println(sel.getFirstSelectedOption().getText());
		String exploc="Egypt";
		sel.selectByVisibleText(exploc);
		String actloc=sel.getFirstSelectedOption().getText();
		System.out.println(actloc);
		System.out.println(exploc);
		if(exploc==actloc)
			System.out.println("Test Case Pass");
		else
			System.out.println("Test Case Fail");
		
		driver.quit();
	}

}
