package dummy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ReadXML extends XLMFunction{
	public static void main(String[] args)  throws Exception{
       System.out.println(xmlData("emailid").getAttribute("locatortype"));
       WebDriver driver=new FirefoxDriver();
       driver.findElement(By.xpath(xmlData("emailid").getAttribute("locatortype"))).sendKeys(xmlData("emailid").getTextContent());;
        //gm.type("userElement.getAttribute(\"locatortype\")", "userElement.getTextContent()", "userElement.getAttribute(\"value\")");
	}	
}
	
