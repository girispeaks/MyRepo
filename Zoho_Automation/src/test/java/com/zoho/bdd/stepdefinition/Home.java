package com.zoho.bdd.stepdefinition;

import org.junit.Assert;
import com.zoho.bdd.util.BaseTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Home {
	BaseTest selenium=new BaseTest();
	
@Given("^I am logged into the application using \"([^\"]*)\"$")
public void login(String browser) throws Exception{
	selenium.doLogin(browser);
	selenium.wait(1000);
	selenium.pageLoad();
	Assert.assertTrue("Login Failed", selenium.isElementPresent("crm_link"));
	}

@Then("^I verify the \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" of home page$")
public void vfyHome(String cliqlocator, String crmlocator, String salesiqlocator) throws Exception{
	Assert.assertTrue("Incorrect contents", selenium.isElementPresent(cliqlocator));
	Assert.assertTrue("Incorrect contents", selenium.isElementPresent(crmlocator));
	Assert.assertTrue("Incorrect contents", selenium.isElementPresent(salesiqlocator));
}
}
