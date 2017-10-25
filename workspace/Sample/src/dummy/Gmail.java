package dummy;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Gmail {
	WebDriver driver=null;
	static Element userElement=null;
	static XPath xpath=null;
	static Document document=null;
	public static void main(String[] args) throws Exception{
		Gmail gm=new Gmail();
		userElement = (Element) xpath.evaluate("/schema/browser", document,XPathConstants.NODE);
		gm.openBrowser(userElement.getTextContent());
		userElement = (Element) xpath.evaluate("/schema/Url", document,XPathConstants.NODE);	
		gm.launchApp(userElement.getTextContent());
		userElement = (Element) xpath.evaluate("/schema/emailid", document,XPathConstants.NODE);
		gm.type(userElement.getAttribute("locatortype"), userElement.getTextContent(), userElement.getAttribute("value"));
		userElement = (Element) xpath.evaluate("/schema/Nextbutton", document,XPathConstants.NODE);
		gm.click(userElement.getAttribute("locatortype"), userElement.getTextContent());
		Thread.sleep(3000);
		userElement = (Element) xpath.evaluate("/schema/password", document,XPathConstants.NODE);
		gm.type(userElement.getAttribute("locatortype"), userElement.getTextContent(), userElement.getAttribute("value"));
		userElement = (Element) xpath.evaluate("/schema/Nextbutton", document,XPathConstants.NODE);
		gm.click(userElement.getAttribute("locatortype"), userElement.getTextContent());
	}
	
	public Gmail(){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();		
			document = db.parse(new FileInputStream(new File("C:\\Users\\gramakrishn6\\Desktop\\new.xml")));// same xml comments as above.
			XPathFactory xpf = XPathFactory.newInstance();
			xpath = xpf.newXPath();
			//userElement = (Element) xpath.evaluate("/schema/UserId", document,XPathConstants.NODE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public void openBrowser(String browser){
		if(browser.equals("Mozilla")){
			System.setProperty("webdriver.gecko.driver", "C://Users//gramakrishn6//Desktop//Jars//geckodriver-v0.17.0-win64//geckodriver.exe");
			driver=new FirefoxDriver();
		} else if(browser.equals("Chrome")){
			System.setProperty("webdriver.gecko.driver", "C://Users//gramakrishn6//Desktop//Jars//geckodriver-v0.17.0-win64//geckodriver.exe");
			driver=new ChromeDriver();
		} else if(browser.equals("IE")){
			System.setProperty("webdriver.gecko.driver", "C://Users//gramakrishn6//Desktop//Jars//geckodriver-v0.17.0-win64//geckodriver.exe");
			driver=new InternetExplorerDriver();
		} else {
			System.setProperty("webdriver.gecko.driver", "C://Users//gramakrishn6//Desktop//Jars//geckodriver-v0.17.0-win64//geckodriver.exe");
			driver=new FirefoxDriver();
		}			
	}
	
	public void launchApp(String url){
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	public void type(String locatortype, String locator, String value){
		getEle(locatortype,locator).sendKeys(value);
	}
	
	public void click(String locatortype, String locator){
		getEle(locatortype,locator).click();
	}
	
	public WebElement getEle(String locatortype, String locator){
		WebElement element=null;
		if(locatortype.equals("xpath")){
			element=driver.findElement(By.xpath(locator));
		}else if(locatortype.equals("id")){
			element=driver.findElement(By.id(locator));
		}else if(locatortype.equals("classname")){
			element=driver.findElement(By.className(locator));
		}else if(locatortype.equals("name")){
			element=driver.findElement(By.name(locator));
		}else if(locatortype.equals("linktext")){
			element=driver.findElement(By.linkText(locator));
		}else if(locatortype.equals("partiallinktext")){
			element=driver.findElement(By.partialLinkText(locator));
		}else if(locatortype.equals("cssSelector")){
			element=driver.findElement(By.cssSelector(locator));
		}else{
			element=driver.findElement(By.tagName(locator));
		}		
		return element;
	}	
}
