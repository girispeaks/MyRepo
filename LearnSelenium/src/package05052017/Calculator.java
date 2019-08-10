package package05052017;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Calculator {
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
		driver.findElement(By.xpath("html/body/div[1]/div[3]/form/div[2]/div[2]/div[1]/div[1]/div[3]/div/div/div[3]/div/input[3]")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		List<WebElement> digits=driver.findElements(By.xpath("//div[@class='cwcd cwbbc']/div/div/div/span"));
        System.out.println("Size of digits list "+digits.size());
        WebElement first=null;
        WebElement second=null;
        WebElement sign=null;
        String actualResult="";
        for(int i=1;i<rowcnt;i++){
            String rowfirst=data.cellValue(0, i, 0);
            String rowSecond=data.cellValue(0, i, 1);
            String signRow=data.cellValue(0, i, 2);
            for(int j=0;j<digits.size();j++){
            	//System.out.println(digits.get(j).getText());
                 if(rowfirst.equals(digits.get(j).getText()))
                        first=digits.get(j);
                  if(signRow.equals(digits.get(j).getText()))
                        sign=digits.get(j);
                  if(rowSecond.equals(digits.get(j).getText()))
                        second=digits.get(j);
            }
            //Thread.sleep(2000);
            //System.out.println(first.getText()+"---"+sign.getText()+"---"+second.getText());

           first.click();
           sign.click();
           second.click();
           driver.findElement(By.xpath("//*[@id='cwtltblr']/div[2]")).sendKeys(Keys.ENTER);
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
