package com.zoho.bdd.stepdefinition;

import com.zoho.bdd.util.BaseTest;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Login{
	static BaseTest selenium=new BaseTest();
	@Given("^I go to \"([^\"]*)\" on \"([^\"]*)\"$")
	public static void navigateLogin(String url, String browser)throws Exception{
		selenium.launchBrowser(browser);
		selenium.navigate(url);
		selenium.click("login_link");
	}
	@When("^I enter the \"([^\"]*)\" in the \"([^\"]*)\" field$")
	public static void typeEmail(String value, String locator)throws Exception{
		selenium.wait(1000);
		selenium.pageLoad();
		selenium.type(locator, value);
		selenium.dfltWind();
	}
	@And("^I enter \"([^\"]*)\" in the \"([^\"]*)\" field$")
	public static void typePassword(String value, String locator)throws Exception{
		selenium.type(locator, value);
		selenium.dfltWind();
	}
	@And("^I click on \"([^\"]*)\" button$")
	public static void click(String locator)throws Exception{
		selenium.click(locator);
		selenium.dfltWind();
	}
	@Then("^login must be successful$")
	public static void validateLogin()throws Exception{		
		selenium.wait(1000);
		selenium.pageLoad();
		Assert.assertTrue("login failed", selenium.isElementPresent("crm_link"));
	}
	
	@Then("^\"([^\"]*)\" message must be displayed for \"([^\"]*)\"$")
	public static void invalidCredential(String msg, String locator)throws Exception{
		if(!selenium.getElement(locator).getText().trim().equals(msg))
			Assert.fail();
	}
	
	@After("@login_validCredentials,@login_invalidemail")
	public void cleanup(){
		selenium.quit();
	}
}
