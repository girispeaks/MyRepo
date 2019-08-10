package com.pageobjmod.qa.util;

import java.io.File;
import java.util.Date;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportManager {
	private static ExtentReports extent;
	
	public static ExtentReports getInstance(){
		Date d=new Date();
		String file=d.toString().replaceAll(":", "_").replaceAll(" ", "_")+".html";
		extent=new ExtentReports("C:\\Users\\gramakrishn6\\workspace\\PageObjectModel\\Reports\\"+file, true, DisplayOrder.NEWEST_FIRST);
		extent.loadConfig(new File("C:\\Users\\gramakrishn6\\workspace\\PageObjectModel\\Resources\\ReportConfig.xml"));
		extent.addSystemInfo("OS", "Windows").addSystemInfo("Environment", "QA");		
		return extent;
	}

}
