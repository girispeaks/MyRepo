package com.learnselenium.dff.zoho.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.learnselenium.ddf.util.DataUtil;
import com.learnselenium.ddf.util.Xls_Reader;
import com.learnselenium.ddf.zoho.Basetest.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends BaseTest{
	static String testName="Login";
	static Xls_Reader xls=null;
	@Test(dataProvider="getData")
	public void doLogin(Hashtable<String,String> hash) throws Exception{
		test=extent.startTest("doLogin");
		test.log(LogStatus.INFO, "Starting test");
		if(!DataUtil.testMode(xls, testName)||hash.get("Runmode").equals("N")){
			test.log(LogStatus.SKIP, "Runmode is N--> "+hash.get("Email")+", "+hash.get("Password"));
			throw new SkipException("Runmode is N");			
		}
		
		openBrowser(prop.getProperty("Browser"));
		navigate(prop.getProperty("Environment"));
		//test.log(LogStatus.PASS, "Test case pass");
		reportPass("Test passed");
	}
	
	@BeforeMethod
	public void beforeTest(){
		init();
	}
	
	@AfterMethod
	public void afterTest(){
		
		extent.endTest(test);
		extent.flush();
		if(driver!=null)
			driver.quit();
	}
	
	@DataProvider
	public static Object[][] getData(){		
		xls=new Xls_Reader(System.getProperty("user.dir")+"//TestData.xlsx");
		return DataUtil.getInstance(xls, testName);
	}

}
