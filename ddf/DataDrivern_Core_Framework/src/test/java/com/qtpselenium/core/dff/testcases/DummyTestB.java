package com.qtpselenium.core.dff.testcases;

import java.io.IOException;
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

public class DummyTestB extends BaseTest{
	
	String testCaseName="TestB";
	XLsReader xls;

	@Test(dataProvider="getData")
	public void testB(Hashtable<String,String> data) throws IOException{
		sa=new SoftAssert();
		test=rep.startTest("DummyTestB");
		test.log(LogStatus.INFO, "Starting the test testB");
		if(!DataUtil.isRunnable(xls, testCaseName)||data.get("Runmode").equals("N")){
			test.log(LogStatus.SKIP, "Skipping the test as runmode is N");
			throw new SkipException("Skipping the test as runmode is N");
		}
		openBrowser("Mozilla");
		test.log(LogStatus.INFO, "Opened Browser");
		navigate("appurl");
		test.log(LogStatus.INFO, "Navigated to the URL");
		
		sa.assertTrue(verifyTitle("gmailText_xpath","gmailText"), "Text not matching");

		//check if email id field is present
		//reportFailure("email field not found");
		if(!isElementPresent("email_xpath")){
			reportFailure("Element not present");
		}
		type("email_xpath","email_value");
		click("clickbutton_xpath");
		test.log(LogStatus.INFO, "Verifying the text");
		//verifyTitle("gmailText_xpath","gmailText");
		//sa.assertTrue(verifyTitle("gmailText_xpath","gmailText"), "Text not matching");
		//reportFailure("Fail");
		test.log(LogStatus.PASS,"testB passed");
		//adding screenshot to report
		takeScreenshot();
	}
	@AfterMethod
	public void quit(){
		try{
		sa.assertAll();
		}catch(Error e){
			e.printStackTrace();
			test.log(LogStatus.FAIL, e.getMessage());
		}
		rep.endTest(test);
		rep.flush();
	}
	
	@BeforeMethod
	public void init(){
		sa=new SoftAssert();
	}
	
	@DataProvider
	public Object[][] getData() throws Exception{
		super.init();
		xls=new XLsReader(prop.getProperty("xlspath"));		
		return DataUtil.getTestData(xls, testCaseName);	
	}

}
