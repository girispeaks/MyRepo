package dummy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Samp {
	//static WebDriver driver=null;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
/*		System.setProperty("webdriver.gecko.driver", "C://Users//gramakrishn6//Desktop//Jars//geckodriver-v0.17.0-win64//geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://demoqa.com/tooltip/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.id("age")).sendKeys("33");
		String str=driver.findElement(By.id("age")).getAttribute("title");
		String str1=driver.findElement(By.id("age")).getAttribute("value");
		System.out.println(str+"---------"+str1);*/
		String selDate="12/09/2019";
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date currentdate=new Date();
		System.out.println(currentdate);
		Date dateTBS=sdf.parse(selDate);
		sdf=new SimpleDateFormat("MMMM");
		String monthToBeSelected=sdf.format(dateTBS);
		sdf=new SimpleDateFormat("yyyy");
		String yearToBeSelected=sdf.format(dateTBS);
		String monthYearToBeSelected=monthToBeSelected+" "+yearToBeSelected;
		System.out.println(monthYearToBeSelected);
		//Date mytbs=sdf.parse(monthYearToBeSelected);
		//String currentDate=sdf.format(d);
		//System.out.println(mytbs);
		
		//System.out.println(d.compareTo(dateTBS));
	}
}	
	/*public static WebElement getElement(String object){
		WebElement element=null;
		
		if(object.endsWith("_xpath")){
			element=driver.findElement(By.xpath("//div[@class='c-user-modal-controls']/div[1]/input"));
		} else if(object.endsWith("_id")){
			element=driver.findElement(By.id(""));
		} else if(object.endsWith("_name")){
			element=driver.findElement(By.name(""));
		} else if(object.endsWith("_classname")){
			element=driver.findElement(By.className(""));
		} else if(object.endsWith("_tagname")){
			element=driver.findElement(By.tagName(""));
		} else if(object.endsWith("_linktext")){
			element=driver.findElement(By.linkText(""));
		} else if(object.endsWith("_partiallinktext")){
			element=driver.findElement(By.partialLinkText(""));
		} else if(object.endsWith("_cssselector")){
			element=driver.findElement(By.cssSelector(""));
		}
		
		return element;
	}

}
*/