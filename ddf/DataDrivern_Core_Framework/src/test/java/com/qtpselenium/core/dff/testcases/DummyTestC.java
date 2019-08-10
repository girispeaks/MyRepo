package com.qtpselenium.core.dff.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qtpselenium.core.dff.base.BaseTest;
import com.qtpselenium.core.dff.util.DataUtil;
import com.qtpselenium.core.dff.util.XLsReader;
import com.relevantcodes.extentreports.LogStatus;

public class DummyTestC extends BaseTest{
	String testCaseName="TestC";
	XLsReader xls;
	@Test(dataProvider="getData")
	public void testC(Hashtable<String,String> data){
		test=rep.startTest("DummyTestC");
		
		if(!DataUtil.isRunnable(xls, testCaseName) || data.get("Runmode").equals("N")){
			test.log(LogStatus.SKIP, "Skipping the test as runmode is N for data "+data.toString());
			throw new SkipException("Skipping the test as runmode is N");
		}
		test.log(LogStatus.INFO, "Starting the test testB");
		test.log(LogStatus.FAIL,"testC failed");
		test.log(LogStatus.FAIL, "Screenshot--->"+test.addScreenCapture("User//girishr//Desktop//screen.png"));
	}
	@AfterMethod
	public void quit(){
		rep.endTest(test);
		rep.flush();
	}
	@BeforeMethod
	public void init(){
		sa=new SoftAssert();
	}
	
	@DataProvider
	public  Object[][] getData() throws Exception{
		super.init();
		xls=new XLsReader(prop.getProperty("xlspath"));		
		return DataUtil.getTestData(xls, testCaseName);	
	}
}