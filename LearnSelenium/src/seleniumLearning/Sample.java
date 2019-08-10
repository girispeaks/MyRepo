package seleniumLearning;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Sample {
public static void main(String[] args) throws Exception{
	//String radio="FeMale";
	System.setProperty("webdriver.gecko.driver", "//users//girishr//Downloads//geckodriver");
	WebDriver driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.get("http://www.seleniumeasy.com/test/jquery-dual-list-box-demo.html");
	WebElement box=driver.findElement(By.xpath("//*[@id='pickList']/div/div[1]/select"));
	Select s=new Select(box);
	s.selectByVisibleText("Alice");
	s.selectByVisibleText("Laura");

	
/*	driver.findElement(By.xpath("//*[@id='Tabbed']/a/button")).click();
	Set win=driver.getWindowHandles();
	System.out.println(win);*/
	//List<WebElement> frame=driver.findElements(By.tagName("iframe"));
	//System.out.println(frame.size());
	/*driver.findElement(By.xpath("//*[@id='Textbox']/button")).click();
	Alert alt=driver.switchTo().alert();
	System.out.println(alt.getText());
	alt.accept();*/
	/*String msg=driver.findElement(By.xpath("//*[@id='demo']")).getAttribute("innerHTML");
	System.out.println("The actual message is "+msg);
	if(msg.contains("Cancel"))
		System.out.println("Clicked on Cancel button");
	else
		System.out.println("Clicked on Ok button");*/
	/*WebElement source=driver.findElement(By.xpath("//*[@id='angular']"));
	Actions act=new Actions(driver);
	//act.dragAndDrop(source, target).build().perform();
	act.clickAndHold(source).moveToElement(target).release().build().perform();*/
	
	//WebElement element=driver.findElement(By.xpath("//div[@class='ui-grid-canvas']/div[1]/div/div[6]/user-click-select/div[1]/button"));
	/*String dt="06/08/2018";
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	Date dateToBeSelected=sdf.parse(dt);
	Date currentDate=new Date();
	sdf=new SimpleDateFormat("d");
	String dayToBeSelected=sdf.format(dateToBeSelected);
	System.out.println(dayToBeSelected);
	sdf=new SimpleDateFormat("MMMM");
	String monthToBeSelected=sdf.format(dateToBeSelected);
	System.out.println(monthToBeSelected);
	sdf=new SimpleDateFormat("yyyy");
	String yearToBeSelected=sdf.format(dateToBeSelected);
	System.out.println(yearToBeSelected);
	String monthYrToBeSelected=monthToBeSelected+" "+yearToBeSelected;
	System.out.println(monthYrToBeSelected);
	driver.findElement(By.xpath("//*[@id='datepicker2']")).click();
	WebElement month=driver.findElement(By.xpath("//div[@class='datepick-month-header']/select[1]"));
	Select s=new Select(month);
	s.selectByVisibleText(monthToBeSelected);
	WebElement year=driver.findElement(By.xpath("//div[@class='datepick-month-header']/select[2]"));
	s=new Select(year);
	s.selectByVisibleText(yearToBeSelected);
	*/
	
	/*String actualDate=driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div")).getText();
	System.out.println(actualDate);
	while(!actualDate.equals(monthYrToBeSelected)){
			if(currentDate.compareTo(dateToBeSelected)==-1)
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[2]/span")).click();
			else if(currentDate.compareTo(dateToBeSelected)==1)
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[1]/span")).click();
			
			actualDate=driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div")).getText();
	}*/
	//driver.findElement(By.xpath("//td/a[text()='"+dayToBeSelected+"']")).click();
	//td/a[text()='+"dayToBeSelected"+']
	
	
	
	//div[@class='col-xs-1']/img
	//JavascriptExecutor js=(JavascriptExecutor)driver;
	//js.executeScript("element.value=\"United\";");
	/*element.click();
	String text=driver.findElement(By.xpath("//*[@id='collapse1']/div")).getAttribute("innerHTML");
	String[] sttext=text.split("\n");
	System.out.println(sttext.length);
	String compText=sttext[0].trim()+sttext[1].trim()+sttext[2].trim();
	System.out.println(compText);*/
	//JavascriptExecutor js=(JavascriptExecutor)driver;
	//js.executeScript("document.getElementById(\"datepicker1\").value=\"\";");
	
	/*Actions act=new Actions(driver);
	act.moveToElement(element).build().perform();
	act.doubleClick(element).build().perform();*/
	//act.doubleClick(element).perform();
	//'1496334991848-0-uiGrid-000B-cell'
	//'1496335041325-0-uiGrid-000B-cell'
	//div[contains("-0-uiGrid-000B-cell",id)]/user-click-select/div[1]/button
	//div[@class='ui-grid-canvas']/div[1]/div/div[6]/user-click-select/div[1]/button
	/*WebElement element=driver.findElement(By.xpath("//button[@class='ui-grid-pager-next']"));
	List<WebElement> email=driver.findElements(By.xpath("//div[@class='ui-grid-row ng-scope']/div/div[1]"));
	List<WebElement> firstName=driver.findElements(By.xpath("//div[@class='ui-grid-row ng-scope']/div/div[2]"));
	String mailid="unu@abc.com";
	do
	{
		for(int i=0;i<email.size();i++)
			if((email.get(i).getText()).trim().equals(mailid.trim())){
				System.out.println(firstName.get(i).getText());	
				break;
			}
		element.click();
	}while(element.isEnabled());*/
	
	/*for(int i=0;i<email.size();i++)
		if(email.equals(mailid))
			System.out.println(firstName.get(i).getText());
		else{	
			while(element.isEnabled()){
				element.click();
				email=driver.findElements(By.xpath("//div[@class='ui-grid-row ng-scope']/div/div[1]"));
				for(int j=0;j<email.size();j++)
					if(email.equals(mailid))
						System.out.println(firstName.get(i).getText());
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		
	}*/
	//button[@class='ui-grid-pager-next']
	//String str=driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[1]/div[1]/input")).getAttribute("placeholder");
	//String str=driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[5]/div/label[2]")).getAttribute("innerHTML").split(">")[1];;
	/*Select s=new Select(element);
	s.selectByVisibleText("1984");*/
	//List<WebElement> buttons=driver.findElements(By.xpath("//div[@class='col-md-4 col-xs-4 col-sm-4']/label"));
	//System.out.println(buttons.get(0).getText());
	/*for(int i=0;i<buttons.size();i++){
		if(radio.equals(buttons.get(i).getText().trim()))
			buttons.get(i).click();
	}
	driver.findElement(By.id("Button1")).click();
	JavascriptExecutor js=(JavascriptExecutor)driver;
	String state=(String)js.executeScript("return document.readyState");
	System.out.println("Page Loading status is "+state);*/
	//driver.quit();
	
	
	
	/*driver.findElement(By.id("secondpassword")).sendKeys("test");
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("document.getElementById(\"secondpassword\").value=\"test\";");
	js.executeScript("document.getElementById(\"secondpassword\").scrollIntoView(true);");
	
	
	driver.get("https://enterprise-demo.orangehrmlive.com/auth/login");
	
	String str=driver.findElement(By.xpath("//div[@id='divUsername']/span")).getText();
	//div[@id='divUsername']/span
	System.out.println(str);
	WebElement element=driver.findElement(By.xpath("//*[@id='txtUsername']"));
	element.clear();
	JavascriptExecutor myExecutor = ((JavascriptExecutor) driver);
	myExecutor.executeScript("document.getElementById(\"txtUsername\").value=\"test\"");
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(element.getAttribute("value"));*/
	
	}
}
