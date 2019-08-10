package dummy;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Screenshot extends ExtentManager{
	
	public void takeScreenshot() throws Exception{
		ExtentReports ext=ExtentManager.getInstance();
		ExtentTest test=ext.startTest("");
		WebDriver driver=new ChromeDriver();
		Date d=new Date();
		String flnm=d.toString().replaceAll(":", "_").replaceAll(" ", "_")+".png";
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File(""+flnm));
		test.log(LogStatus.INFO, "Screenshot--->"+test.addScreenCapture(""+flnm));
	}

}
