package com.learnselenium.ddf.util;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	static ExtentReports rep=null;
	public static ExtentReports getInstance(){
		Date d=new Date();
		String fname=d.toString().replaceAll(":", "_").replaceAll(" ", "_");
		rep=new ExtentReports(System.getProperty("user.dir")+"//Reports//"+fname+".html",true,DisplayOrder.NEWEST_FIRST);
		rep.loadConfig(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));
		rep.addSystemInfo("Selenium version", "3.4").addSystemInfo("OS", "MacOS");
		return rep;		
	}

}
