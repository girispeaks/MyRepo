package com.selenium.bdd.coursera.register;

import com.selenium.bdd.coursera.util.BaseClass;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;



public class RegisterUser {
	
	BaseClass selenium=new BaseClass();

	@Given("^I go to \"([^\"]*)\" on \"([^\"]*)\"$")
	public void i_go_to_screen(String url, String browser) throws Throwable {
	   selenium.openBrowser(browser);
	   selenium.launchApplication(url);	  
	}
	
	/*@When("^I click on \"([^\"]*)\" button$")
	public void i_click_on_signUp(String signUp){
		selenium.click(signUp);
	}*/

	@And("^I enter \"([^\"]*)\" in \"([^\"]*)\" field$")
	public void i_enter(String values, String object) throws Throwable {
	    selenium.type(values, object);
	}
	
	@And("^I click on \"([^\"]*)\" button$")
	public void i_click_on_button(String button) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   selenium.click(button);
	   
	}
	
	@Then("^user registration must be successful$")
	public void user_registration_must_be_successful() throws Throwable {
	   //selenium.getElement("AdvanceMyCareer");
	   Assert.assertTrue(selenium.getElement("AdvanceMyCareer"));
	}
	
	@Then("^I close the browser$")
	public void i_close_the_browser(){
		selenium.driver.quit();
	}

}
