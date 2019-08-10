package seleniumPractice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DatePick {

	public static void main(String[] args) throws Exception {
		String selDate="24/04/2014";
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C://Users//gramakrishn6//Desktop//Jars//geckodriver-v0.17.0-win64//geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("http://demoqa.com/datepicker/");
		driver.findElement(By.id("datepicker1")).click();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date currentDate=new Date();
		Date dateTBS=sdf.parse(selDate);
		sdf=new SimpleDateFormat("dd");
		String dateToBeSelected=sdf.format(dateTBS);
		sdf=new SimpleDateFormat("MMMM");
		String monthToBeSelected=sdf.format(dateTBS);
		sdf=new SimpleDateFormat("yyyy");
		String yearToBeSelected=sdf.format(dateTBS);
		String monthYearToBeSelected=monthToBeSelected+" "+yearToBeSelected;
		String monthOnScreen=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[1]")).getText();
		String yearOnScreen=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[2]")).getText();		
		String monthYearOnScreen=monthOnScreen+" "+yearOnScreen;
		while(true){
			if(currentDate.after(dateTBS))
				driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']/a[1]")).click();
			if(currentDate.before(dateTBS))
				driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']/a[2]")).click();
			monthOnScreen=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[1]")).getText();
			yearOnScreen=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[2]")).getText();
			monthYearOnScreen=monthOnScreen+" "+yearOnScreen;
			if(monthYearToBeSelected.equals(monthYearOnScreen))
				break;
		}
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a[text()="+dateToBeSelected+"]")).click();
	}
}
