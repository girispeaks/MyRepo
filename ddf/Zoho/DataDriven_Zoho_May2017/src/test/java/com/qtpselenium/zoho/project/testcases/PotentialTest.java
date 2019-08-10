package com.qtpselenium.zoho.project.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.qtpselenium.zoho.project.base.BaseTest;
import com.qtpselenium.zoho.project.util.DataUtil;
import com.qtpselenium.zoho.project.util.XLsReader;
import com.relevantcodes.extentreports.LogStatus;

public class PotentialTest extends BaseTest{
	String testCaseName="CreateLeadTest";
	XLsReader xls;
	@Test(priority=1)
	public void createPotentialTest(Hashtable<String, String> data){
		test=rep.startTest("createPotentialTest");
		test.log(LogStatus.INFO, "Starting test");
		if(!DataUtil.isRunnable(xls, "CreatePotentialTest")||data.get("Runmode").equals("N")){
			test.log(LogStatus.SKIP, "Skipping the test as runmode is N");
			throw new SkipException("Skipping the test as runmode is N");
		}		
	}
	
	@Test(priority=2, dependsOnMethods={"createPotentialTest"})
	public void deletePotentialAccountTest(){
		test = rep.startTest("deletePotentialAccountTest");
		reportPass("Test Passed");
	}

}
