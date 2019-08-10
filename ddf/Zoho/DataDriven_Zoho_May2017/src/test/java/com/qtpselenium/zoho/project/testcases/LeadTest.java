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

public class LeadTest extends BaseTest{
	
	String testCaseName="CreateLeadTest";
	XLsReader xls;
	SoftAssert sa;
	
	@Test(priority=1, dataProvider="getData")
	public void createLeadTest(Hashtable<String,String> data) throws Exception{
		test=rep.startTest("createLeadTest");
		test.log(LogStatus.INFO, "Starting test");
		if(!DataUtil.isRunnable(xls, testCaseName)||data.get("Runmode").equals("N")){
			test.log(LogStatus.SKIP, "Skipping the test as runmode is N");
			throw new SkipException("Skipping the test as runmode is N");
		}
	    
		openBrowser(data.get("Browser"));
		navigate(prop.getProperty("appurl"));
		doLogin(prop.getProperty("username"),prop.getProperty("password"));

		click("crmLink_xpath");
		System.out.println("Clicked successfully");
		wait(5);
		waitForPageToLoad();
		click("leadsTab_xpath");
		wait(1);
		waitForPageToLoad();
		
		click("createLead_xpath");
		type("company_xpath",data.get("LeadCompany"));
		type("lastName_xpath",data.get("LeadLastName"));
		click("save_xpath");
		wait(5);
		click("leadsTab_xpath");	
		//validate whether lead is created
		int rNum=getLeadRowNum(data.get("LeadLastName"));
		if(rNum==-1)
			reportFailure("Lead not found");
		
		reportPass("Lead found");
	}
	@Test(priority=2, dataProvider="getData")
	public void convertLeadTest(Hashtable<String,String> data) throws Exception{
		/*Assert.fail("Failed");*/
		test=rep.startTest("convertLeadTest");
		test.log(LogStatus.INFO, "Starting test");
		if(!DataUtil.isRunnable(xls, "ConvertLeadTest")||data.get("Runmode").equals("N")){
			test.log(LogStatus.SKIP, "Skipping the test as runmode is N");
			throw new SkipException("Skipping the test as runmode is N");
		}
	    
		openBrowser(data.get("Browser"));
		navigate(prop.getProperty("appurl"));
		doLogin(prop.getProperty("username"),prop.getProperty("password"));
		click("crmLink_xpath");
		System.out.println("Clicked successfully");
		wait(5);
		waitForPageToLoad();
		click("leadsTab_xpath");
		wait(1);
		waitForPageToLoad();
		clickOnLead(data.get("LeadLastName"));
		wait(5);
		waitForPageToLoad();
		click("convertBtn_xpath");
		wait(5);
		waitForPageToLoad();
		click("convertAndSaveBtn_xpath");
		
		/*wait(2);
		if(!isElementPresent("goToLeadsBtn_xpath"))
			reportFailure("Conversion Failed");
		
		reportPass("Conversion Successfull");*/
			
	}
	
	@Test(priority=3,dataProvider="getDataDeleteLead")
	public void deleteLeadAccountTest(Hashtable<String,String> data) throws Exception{
		test=rep.startTest("deleteLeadAccountTest");
		test.log(LogStatus.INFO, "Starting test");
		if(!DataUtil.isRunnable(xls, "DeleteLeadAccountTest")||data.get("Runmode").equals("N")){
			test.log(LogStatus.SKIP, "Skipping the test as runmode is N");
			throw new SkipException("Skipping the test as runmode is N");
		}
	    
		openBrowser(data.get("Browser"));
		navigate(prop.getProperty("appurl"));
		doLogin(prop.getProperty("username"),prop.getProperty("password"));
		click("crmLink_xpath");
		System.out.println("Clicked successfully");
		wait(5);
		waitForPageToLoad();
		click("leadsTab_xpath");
		wait(1);
		waitForPageToLoad();
		clickOnLead(data.get("LeadLastName"));
		wait(5);
		waitForPageToLoad();
		click("deleteCustomTool_xpath");
		wait(2);
		click("deletebtn_xpath");
		//acceptAlert();
		wait(1);
		click("confDeleteBtn_xpath");
		wait(5);
		waitForPageToLoad();
		int rNum=getLeadRowNum(data.get("LeadLastName"));
		if(rNum!=-1)
			reportFailure("Could not delete lead "+data.get("LeadLastName"));
		reportPass("Deleted lead successfully "+data.get("LeadLastName"));
		
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
		if(rep!=null){
		rep.endTest(test);
		rep.flush();
		}
		if(driver!=null)
			driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() throws Exception{
		super.init();
		xls=new XLsReader(prop.getProperty("xlspath"));		
		return DataUtil.getTestData(xls, testCaseName);	
	}
	
	@DataProvider
	public Object[][] getDataDeleteLead() throws Exception{
		super.init();
		xls=new XLsReader(prop.getProperty("xlspath"));		
		return DataUtil.getTestData(xls, "DeleteLeadAccountTest");	
	}
}
