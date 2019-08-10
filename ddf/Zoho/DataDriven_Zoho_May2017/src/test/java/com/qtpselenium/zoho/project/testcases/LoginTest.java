package com.qtpselenium.zoho.project.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qtpselenium.zoho.project.base.BaseTest;
import com.qtpselenium.zoho.project.util.DataUtil;
import com.qtpselenium.zoho.project.util.XLsReader;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends BaseTest{
	
	String testCaseName="LoginTest";
	XLsReader xls;
	
	
	@Test(dataProvider="getData")
	public void doLoginTest(Hashtable<String, String> data) throws Exception{
		test=rep.startTest("LoginTest");
		test.log(LogStatus.INFO, "Starting test");
		test.log(LogStatus.INFO, data.toString()); //logging the data in the report
		if(!DataUtil.isRunnable(xls, testCaseName)||data.get("Runmode").equals("N")){
			test.log(LogStatus.SKIP, "Skipping the test as runmode is N");
			throw new SkipException("Skipping the test as runmode is N");
		}
		openBrowser(data.get("Browser"));
		navigate(prop.getProperty("appurl"));
		//click("loginLink_xpath");
		Boolean actualResult=doLogin(data.get("Username"),data.get("Password"));
		Boolean expectedResult=false;
		if(data.get("ExpectedResult").equals("Y"))
			expectedResult=true;
		else
			expectedResult=false;
		
		if(expectedResult!=actualResult)
			reportFailure("Test Failed");
		else 
			reportPass("Test Pass");
	}
	
	@BeforeMethod
	public void init(){
		sa=new SoftAssert();
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
		if(driver!=null)
			driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() throws Exception{
		super.init();
		xls=new XLsReader(prop.getProperty("xlspath"));		
		return DataUtil.getTestData(xls, testCaseName);	
	}

}
