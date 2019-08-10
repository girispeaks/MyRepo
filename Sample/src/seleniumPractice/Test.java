package seleniumPractice;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {
	static Properties prop=null;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		/*if(prop==null){
			prop=new Properties();
			try
			{
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resource\\config\\OR.properties");
			prop.load(ip);
			}catch(Exception e){
				e.printStackTrace();
				System.out.println(e.getMessage());
				}
			}
		System.out.println(prop.getProperty("browser"));*/
		
		System.setProperty("webdriver.gecko.driver", "C://Users//gramakrishn6//Desktop//Jars//geckodriver-v0.17.0-win64//geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		  driver.get("https://www.zoho.com/login.html");
		  int size = driver.findElements(By.tagName("iframe")).size();
		  for(int i=0; i<size; i++){
				driver.switchTo().frame(i);
				int eletotal=driver.findElements(By.xpath("//input[@type='email']")).size();
				if(eletotal>0)
				break;
		  }	
		
		  driver.findElement(By.xpath("//input[@type='email']")).sendKeys("girispeaks@gmail.com");
		  driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Aug@1234");
		  driver.findElement(By.xpath("//button[@type='submit']")).click();
		  driver.switchTo().defaultContent();
		  Thread.sleep(5000);
		  WebElement wele=driver.findElement(By.xpath("//div[@class='ea-app-container']/div[2]/div/a/div[text()='CRM']"));
		 // Assert.assertFalse(wele.isDisplayed());
		  System.out.println(wele.getText());
			//System.out.println(total);
		   // driver.manage().window().maximize();
		    //driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		/* int size = driver.findElements(By.tagName("iframe")).size();
		 //   System.out.println("Total frames "+size);
		   for(int i=0; i<size; i++){
			driver.switchTo().frame(i);
			int eletotal=driver.findElements(By.xpath("//div[@class='ea-app-container']/div[2]/div/a/div[text()='CRM']")).size();
			System.out.println(eletotal);
		    driver.switchTo().defaultContent();
		    	}
		  }  */ 
		/*driver.get("https://www.zoho.com/login.html");
		List<WebElement> frames=driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());*/
		/*for(int i=0;i<frames.size();i++){
			System.out.println("Test");
			driver.switchTo().frame(i);
			int ele=driver.findElements(By.xpath("//a[text()='Login']")).size();
			System.out.println("total elements "+ele);
			driver.switchTo().defaultContent();
		}*/
		//driver.switchTo().frame(frames.get(1));
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("//input[@type='email']")).sendKeys("test");
		//driver.switchTo().defaultContent();
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguement[0].value='test'", element);
		//js.executeScript("document.getElementById(\"lid\").value='test';");
		//driver.findElement(By.xpath("//input[@type='email']")).sendKeys("test");
		//js.executeScript("document.getElementById("textbox_id").value='new value';");
	}	
	}


