package seleniumLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Facebook {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Proxy p=new Proxy();
		p.setProxyAutoconfigUrl("http://someproxy.com");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(CapabilityType.PROXY, p);
		System.setProperty("webdriver.gecko.driver","//users//girishr//Downloads//geckodriver");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://facebook.com");
		driver.findElement(By.xpath("//*[@id='pageFooter']/ul/li[2]/a")).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("girispeaks@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("pass")).sendKeys("Wed@1234");
		Thread.sleep(1000);
		String str=driver.findElement(By.id("pass")).getAttribute("value");
		System.out.println(str);
		driver.findElement(By.id("u_0_q")).click();
		driver.quit();
	}

}
