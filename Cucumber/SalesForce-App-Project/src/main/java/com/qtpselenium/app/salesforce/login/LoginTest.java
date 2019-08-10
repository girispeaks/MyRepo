package com.qtpselenium.app.salesforce.login;

import org.junit.Assert;

import com.qtpselenium.app.salesforce.util.WebConnector;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginTest {
	WebConnector selenium=WebConnector.getInstance();
	
	@Given("^I go to \"([^\"]*)\" on \"([^\"]*)\"$")
	public void I_Go_To_Salesforce(String url,String browser){
		System.out.println("I am going to "+url+" using browser "+browser);
	    selenium.openBrowser(browser);
		selenium.navigate(url);
		
	}
	
	@Then("^login should be \"([^\"]*)\"$")
	public void Then_Login_Should_Be(String expectedResult){
		System.out.println("The expected Result is "+expectedResult);
		Assert.assertTrue("Login failed", selenium.isElementPresent("verifyButton"));
	}
}


//And I enter username as loadrunner.jmeter@gmail.com
//And I click on loginbutton