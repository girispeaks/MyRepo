package com.pageobjmod.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pageobjmod.qa.base.BaseTest;
import com.pageobjmod.qa.pages.ContactsPage;
import com.pageobjmod.qa.pages.HomePage;
import com.pageobjmod.qa.pages.LoginPage;


public class HomePageTest extends BaseTest{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void initialize(){
		openBrowser(prop.getProperty("browser"));
		launchApp(prop.getProperty("url"));
		loginPage=new LoginPage();
		homePage=loginPage.doLogin(prop.getProperty("userName"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void validateUserName(){
		switchFrame();
		Assert.assertEquals("User: Girish R".trim(), homePage.getUserName().trim(),"UserName is incorrect");
		//defFrame();
	}
	
	@Test(priority=2)
	public void validateHomePage(){
		switchFrame();
		Assert.assertTrue(homePage.homePageValidate(), "Home page not valid");
	}
	
	@Test(priority=3)
	public void clickContacts(){
		switchFrame();
		contactsPage=homePage.clickContacts();
	}
	
	@AfterMethod
	public void tearDown(){
		quitBrowser();
	}
}
