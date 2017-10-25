package dummy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebTable {
	static WebDriver driver=null;
	static List<WebElement> rws;
	static List<WebElement> clms;
	static String build="Taipei";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cty="Financial Center";
		System.setProperty("webdriver.gecko.driver", "C://Users//gramakrishn6//Desktop//Jars//geckodriver-v0.17.0-win64//geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://toolsqa.com/automation-practice-table/");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		rws=driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr"));
		clms=driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr[1]/td"));
		//System.out.println("Total rows "+rws.size());
		System.out.println("Height of building is "+height().split("m")[0]);
		//System.out.println("Value found in row "+tableValue(build));
	}
	public static int structure(List<WebElement> eleList, String building){
		for(int i=1;i<=eleList.size();i++){
			WebElement element=driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr["+i+"]/th"));
			System.out.println(element.getText());
			if(element.getText().trim().equals(building))
				return i;
		}
		return -1;
	}
	
	public static String height(){
		int row=tableValue(build);
		if(row==-1){
			System.out.println("Building not found");
			return "";
		}else {
			WebElement hgt=driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr["+row+"]/td[3]"));		
			return hgt.getText();
		}
	}
	
	public static int tableValue(String value){
		ArrayList<String> struct=new ArrayList<String>();
		for(int i=1;i<=rws.size();i++){
			WebElement element=driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr["+i+"]/th"));
			struct.add(element.getText());
		}

		if(struct.contains(value)){
			for(int i=0;i<struct.size();i++){
				if(struct.get(i).trim().equals(value))
					return i+1;
			}		
		}else {
			for(int i=1;i<=rws.size();i++)
				for(int j=1;j<=clms.size();j++){
					String gtElement=driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr["+i+"]/td["+j+"]")).getText();
					if(gtElement.trim().equals(value))
						return i;
				}
		}
		return -1;
	}
	
}
