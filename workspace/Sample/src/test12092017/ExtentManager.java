package test12092017;

import java.io.File;
import java.util.Date;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports rep;
	public static ExtentReports main(String[] args) {
		// TODO Auto-generated method stub
		Date d=new Date();
		String f=d.toString().replaceAll(" ", "_").replaceAll(":", "_")+".html";
		rep=new ExtentReports("//"+f,true,DisplayOrder.NEWEST_FIRST);
		rep.loadConfig(new File(""));
		rep.addSystemInfo("", "").addSystemInfo("", "");
		return rep;
	}
}