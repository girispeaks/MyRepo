package package05052017;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Calc2 {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		XLReader data=new XLReader("//Users//girishr//Documents//workspace//LearnSelenium//Temp//Calculator.xlsx");
        int rowcnt=data.rowNumber(0);
        System.out.println("Total rows are "+rowcnt);
        String expectedResult="";
        
		System.setProperty("webdriver.gecko.driver", "//users//girishr//Downloads//geckodriver");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("http://google.com");
		driver.findElement(By.xpath("//div[@id='als']/div/a[text()='English']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/div[1]/div[3]/form/div[2]/div[2]/div[1]/div[1]/div[3]/div/div/div[3]/div/input[3]")).sendKeys("Calculator");
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[1]/div[3]/form/div[2]/div[2]/div[1]/div[1]/div[3]/div/div/div[3]/div/input[3]")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
        String actualResult="";
        for(int i=1;i<rowcnt;i++){
            String rowfirst=data.cellValue(0, i, 0);
            String rowSecond=data.cellValue(0, i, 1);
            String signRow=data.cellValue(0, i, 2);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='cwos']")).click();
            driver.findElement(By.xpath("//*[@id='cwos']")).sendKeys(rowfirst+signRow+rowSecond, Keys.ENTER);
            Thread.sleep(2000);
            actualResult=driver.findElement(By.xpath("//*[@id='cwos']")).getText();
            System.out.println(actualResult);
            actualResult=driver.findElement(By.xpath("//*[@id='cwos']")).getText();
            data.writeCellValue("Addition", i, 4, actualResult);
            expectedResult=data.cellValue(0, i, 3);
            if(expectedResult.equals(actualResult)){
                  data.writeCellValue("Addition", i, 5, "Pass");
            }else
                  data.writeCellValue("Addition", i, 5, "Fail");   
        }

	}
	
}


