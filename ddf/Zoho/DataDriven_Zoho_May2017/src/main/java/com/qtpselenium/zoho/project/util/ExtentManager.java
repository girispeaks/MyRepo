package com.qtpselenium.zoho.project.util;

//http://relevantcodes.com/Tools/ExtentReports2/javadoc/index.html?com/relevantcodes/extentreports/ExtentReports.html


import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports extent=null;

	public static ExtentReports getInstance() {
		if (extent == null) {
			Date d=new Date();
			String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
			//new ExtentReports());
			extent = new ExtentReports("//users//girishr//Documents//workspace//ddf//report//"+fileName, true, DisplayOrder.NEWEST_FIRST);			
			extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));
			// optional
			extent.addSystemInfo("Selenium Version", "3.4.0").addSystemInfo(
					"Environment", "QA");
		}
		return extent;
	}
}
