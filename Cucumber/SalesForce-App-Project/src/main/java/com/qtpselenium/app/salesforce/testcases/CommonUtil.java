package com.qtpselenium.app.salesforce.testcases;

import org.junit.Assert;

import com.qtpselenium.app.salesforce.util.WebConnector;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class CommonUtil {
	WebConnector selenium=WebConnector.getInstance();
	
	@And("^I click on \"([\"]*)\"$")
	public void I_click_on(String objectName){
		selenium.click(objectName);
	}
	
	@And("^I enter \"([^\"]*)\" as \"([^\"]*)\"$")
	public void I_Enter_UserName_Password(String object,String text){
		selenium.type(object, text);
		//System.out.println("Entering "+object+" value "+text);
	}

	@Given("^I am logged in salesforce$")
	public void I_am_logged_in_app(){
		Assert.assertTrue("Not logged in", selenium.isLoggedIn("searchText"));
	}
	
	@Given("^Runmode is \"([^\"]*)\"$")
	public void Runmode_is(String runmode){
		if(runmode.equals("N"))
			throw new PendingException("Skipping the test as runmode is N");
		
	}
}
