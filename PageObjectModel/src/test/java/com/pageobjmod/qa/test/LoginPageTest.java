package com.pageobjmod.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pageobjmod.qa.base.BaseTest;
import com.pageobjmod.qa.pages.HomePage;
import com.pageobjmod.qa.pages.LoginPage;
import com.pageobjmod.qa.util.ExtentReportManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class LoginPageTest extends BaseTest{
	LoginPage loginPage;
	HomePage homePage;
	ExtentTest test;
	ExtentReports repo=ExtentReportManager.getInstance();
	public LoginPageTest(){
		super();
		
	}
	
	@BeforeMethod
	public void setUp(){
		
		openBrowser(prop.getProperty("browser"));
		launchApp(prop.getProperty("url"));
		loginPage=new LoginPage();
	}
	
	@Test(priority=1)
	public void validatePageTitle(){
		test=repo.startTest("validatePageTitle");
		test.log(LogStatus.INFO,"Validating the title page");
		Assert.assertEquals(prop.getProperty("pageTitle"), loginPage.pageTitle(),"Page title not matching");
		test.log(LogStatus.PASS, "validate page success");
		//System.out.println(loginPage.pageTitle());
	}
	
	//@Test(priority=2)
	public void validateCRMLogo(){
		test=repo.startTest("validateCRMLogo");
		test.log(LogStatus.INFO, "Validating logo");
		Assert.assertTrue(loginPage.validateLogo(),"Logo not displayed");
		test.log(LogStatus.PASS, "validate logo success");
	}

	//@Test(priority=3)
	public void login(){		
		homePage=loginPage.doLogin("girispeaks","Wed@1234");
	}
	
	@AfterMethod
	public void tearDown(){
		quitBrowser();
		repo.endTest(test);
		repo.flush();
	}
}
