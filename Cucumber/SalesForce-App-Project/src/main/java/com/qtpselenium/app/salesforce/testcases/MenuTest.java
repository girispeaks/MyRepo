package com.qtpselenium.app.salesforce.testcases;



import java.util.List;

import org.junit.Assert;

import com.qtpselenium.app.salesforce.util.WebConnector;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class MenuTest {
	
	WebConnector selenium=WebConnector.getInstance();
	
	@Given("^I am logged in \"([\"]*)\"$")
	public void I_am_logged_in(String browser){
		//check if logged in.... if not log in
		selenium.openBrowser(browser);
		if(!selenium.isLoggedIn("searchText")){
			selenium.log("Opening brower and logging in as a default user");
			selenium.doDefaultLogin();
		}
	}
	
	@Then("\"([\"]*)\" should be present$")
	public void Should_be_present(String objectName){	
		Assert.assertTrue("Element not present",selenium.isElementPresent(objectName));
	}

	@Then("^All tabs on the menu should be present$")
	public void All_tabs_on_the_menu_should_be_present(DataTable table){
		List<String> names=table.asList(String.class);
		System.out.println(names.toString());// this prints all values in the list
		for(int i=0;i<names.size();i++){
			selenium.log("Checking "+names.get(i));
			Assert.assertTrue("Element not found "+names.get(i), selenium.isElementPresent(names.get(i)));
		}
		
	}
}
