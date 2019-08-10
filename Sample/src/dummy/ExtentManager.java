package dummy;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	public static ExtentReports getInstance(){
		Date d=new Date();
		String flnm=d.toString().replaceAll(":", "_").replaceAll(" ", "_")+".html";
		extent=new ExtentReports(""+flnm,true,DisplayOrder.NEWEST_FIRST);
		extent.loadConfig(new File(""));
		extent.addSystemInfo("Operating System","Windows");
		return extent;
		
	}
	
	public static void main(String[] args){
		ExtentReports rep=ExtentManager.getInstance();
		ExtentTest test=rep.startTest("");
		test.log(LogStatus.PASS, "");
		test.log(LogStatus.FAIL, "");
		rep.endTest(test);
		rep.flush();
	}

}
