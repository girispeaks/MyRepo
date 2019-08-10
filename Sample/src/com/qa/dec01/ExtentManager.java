package com.qa.dec01;

import java.io.File;
import java.util.Date;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentManager {
	
	private static ExtentReports rep=null;
	
	public static ExtentReports getInstance(){
		Date d=new Date();
		String flNm=d.toString().replaceAll(":", "_").replaceAll(" ", "_")+".html";
		rep=new ExtentReports("C:\\Users\\gramakrishn6\\workspace\\Sample\\Resource\\"+flNm, true, DisplayOrder.NEWEST_FIRST);
	    rep.loadConfig(new File("C:\\Users\\gramakrishn6\\workspace\\Sample\\Resource\\ReportConfig.xml"));
	    rep.addSystemInfo("OS", "Windows10").addSystemInfo("Environment", "SIT");
	    return rep;	    
	}
}

class CallExtent{
	public static void main(String[] args){
		testRep();
	}
	
	public static void testRep(){
		ExtentReports ext=ExtentManager.getInstance();
		ExtentTest test=ext.startTest("testRep");
		test.log(LogStatus.PASS, "working");
		test.log(LogStatus.INFO, "FYI");
		test.log(LogStatus.FAIL,"not working");
		ext.endTest(test);
		ext.flush();
	}
}
