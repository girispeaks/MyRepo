package seleniumPractice;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Prac1 {
	WebDriver driver;
	Properties prop;
	
	@Test(dataProvider="formFill")
	public  void formFill(String runMode,String firstName,String lastName,String gndr,String yrs,String date,String favChai,String tea,String conti,String bktowk ) throws Exception {
		init();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gramakrishn6\\workspace\\PageObjectModel\\Resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.practiceselenium.com/practice-form.html");
		driverWait(1);
		pageWait();
		driver.findElement(By.name(prop.getProperty("firstName_name"))).sendKeys(firstName);
		driver.findElement(By.name(prop.getProperty("lastName_name"))).sendKeys(lastName);
		
		List<WebElement> gender=driver.findElements(By.xpath(prop.getProperty("gender_xpath")));
		for(WebElement ele:gender)
			if(ele.getAttribute("value").equals(gndr)){
			ele.click();
			break;
		}
		
		List<WebElement> years=driver.findElements(By.xpath(prop.getProperty("years_xpath")));
		for(WebElement ele:years)
			if(ele.getAttribute("value").equals(yrs)){
				ele.click();
				break;
			}
		
		driver.findElement(By.id("datepicker")).sendKeys(date);
		
		List<WebElement> favchai=driver.findElements(By.xpath(prop.getProperty("favchai_xpath")));
		for(WebElement ele:favchai)
			if(ele.getAttribute("value").equals(favChai)){
				ele.click();
				break;
			}
		
		List<WebElement> chai=driver.findElements(By.xpath(prop.getProperty("chai_xpath")));
		for(WebElement ele:chai)
			if(ele.getAttribute("value").equals(tea)){
				ele.click();
				break;
			}
				
		Select sel=new Select(driver.findElement(By.id(prop.getProperty("continent_id"))));
		sel.selectByVisibleText(conti);
		
		sel=new Select(driver.findElement(By.id(prop.getProperty("backtowrk_id"))));
		sel.selectByVisibleText(bktowk);
		
		driverWait(5);
		
		driver.findElement(By.id(prop.getProperty("okBtn_id"))).click();	
	}
	
	public void init() throws Exception{
		FileInputStream ip=new FileInputStream("C:\\Users\\gramakrishn6\\workspace\\Sample\\Resource\\OR.properties");
		prop=new Properties();
		prop.load(ip);
	}
	
	public void driverWait(int sec){
		try{
			Thread.sleep(sec*1000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void pageWait(){
		driverWait(1);
		String state=(String)((JavascriptExecutor)driver).executeScript("return document.readyState");
		while(!state.equals("complete")){
			driverWait(1);
			state=(String)((JavascriptExecutor)driver).executeScript("return document.readyState");
		}
	}

	@DataProvider(name="formFill")
	public Object[][] getData() throws Exception{
		Xlsx_Reader reader= new Xlsx_Reader("C:\\Users\\gramakrishn6\\Desktop\\Test.xlsx");
		
		int k=1;
		while(!(reader.getCellValue("TestData", k, 0).equals("formFill")))
			k++;
		int testCaseName=k;
		int testCaseHeader=k+1;
		int testDataStart=k+2;
		System.out.println("Test Case found at "+k);
		System.out.println("Test Case Header found at "+(k+1));
		System.out.println("Test data starts from "+(k+2));
		int temp=testDataStart;
		while(!(reader.getCellValue("TestData", temp, 0).equals("")))
			temp++;
		
		int testDataEnd=temp-1;
		
		System.out.println("Test data ends at "+testDataEnd);
		int row=temp-testDataStart;
		System.out.println("Total test data rows "+row);
		Object[][] data=new Object[row][reader.getCellCnt(1, testDataStart)];
		int a=0;
		for(int i=testDataStart;i<=testDataEnd;i++){			 
			for(int j=0;j<reader.getCellCnt(1, testDataStart);j++){
				data[a][j]=reader.getCellValue("TestData", i, j);
			}
			a++;
		}
		return data;
		
	}
	
}
