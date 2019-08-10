package seleniumLearning;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebTbl {
	static WebDriver driver;
	static int rowcnt;
	static int clmcnt;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "//users//girishr//Downloads//geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("http://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		WebElement box = driver.findElement(By.xpath("//*[@id='leftcontainer']/table"));
		// System.out.println(box.getSize());

		List<WebElement> row = box.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
		// System.out.println(row.size());
		List<WebElement> col = box.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[1]/td"));
		// System.out.println(col.size());
		rowcnt = row.size();
		clmcnt = col.size();
		List<WebElement> currPrice=driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[4]"));
		// print company and corresponding current price
		// return company name based on current price(customized method)
		// sum of all current price
		/*
		 * List<WebElement> compName=driver.findElements(By.xpath(
		 * "//*[@id='leftcontainer']/table/tbody/tr/td[1]")); List<WebElement>
		 currPrice=driver.findElements(By.xpath(
		 * "//*[@id='leftcontainer']/table/tbody/tr/td[4]")); for(int
		 * i=1;i<=row.size();i++){ String comp=driver.findElement(By.xpath(
		 * "//*[@id='leftcontainer']/table/tbody/tr["+i+"]/td[1]")).getText();
		 * String curr=driver.findElement(By.xpath(
		 * "//*[@id='leftcontainer']/table/tbody/tr["+i+"]/td[4]")).getText();
		 * System.out.println("Company name is "+comp+" and Current Price is "
		 * +curr); }
		 */
		String corrCompany = comp_Name("1,744.00");
		System.out.println(corrCompany);
		System.out.println("Sum of current price is "+sumOfCurrentPrice(currPrice));

	}

	public static String comp_Name(String d) {
		String value = "";
		for (int i = 1; i <= rowcnt; i++) {
			List<WebElement> rows = driver
					.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[" + i + "]/td"));
			for (int j = 0; j < clmcnt; j++) {
				if ((rows.get(j).getText()).equals(d)) {
					value = rows.get(0).getText();
					// System.out.println(value);
					break;
				}
			}
		}
		return value;

	}
	public static float sumOfCurrentPrice(List<WebElement> currP){
		int length=currP.size();
		String str="";
		float temp=0.0f;
		for(int i=0;i<length;i++){
			str=currP.get(i).getText();
			//double d=Double.parseDouble(str);
			System.out.println(str.replaceAll(",",""));
			float f=Float.parseFloat(str.replaceAll(",",""));
			temp=temp+f;
		}
		return temp;
	}
}
