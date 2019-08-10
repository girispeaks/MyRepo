package com.qa.test;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentRep {
	
	public static ExtentReports rep=null;
	
	public ExtentReports getInstance(){
		Date d=new Date();
		String fname=d.toString().replaceAll(" ", "_").replaceAll(":", " ")+".html";
		rep=new ExtentReports("c://desktop/"+fname,true, DisplayOrder.NEWEST_FIRST);
		rep.loadConfig(new File(""));
		return rep;
	}

}
