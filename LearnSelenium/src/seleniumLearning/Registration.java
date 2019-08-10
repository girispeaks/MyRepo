package seleniumLearning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Registration {
	
	@Test
	public static void doRegistration(){
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://demoqa.com/registration/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		
	}

}
