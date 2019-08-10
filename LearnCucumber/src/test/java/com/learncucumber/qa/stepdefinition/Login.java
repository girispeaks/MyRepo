package com.learncucumber.qa.stepdefinition;

import com.learncucumber.qa.util.BaseTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Login {
	BaseTest selenium=new BaseTest();
	
	@Given("^I have opened the \"([^\"]*)\"$")
	public void openBrowser(String browser){
		selenium.openBrowser(browser);
	}
	
	@And("^I launch the application using \"([^\"]*)\"$")
	public void launchApplication(String url){
		selenium.launchApp(url);
		selenium.waitDriver(1000);
		selenium.pageLoad();
	}
	
	@Then("^I click on \"([^\"]*)\"$")
	public void navigateLogin(String locator){
		selenium.frames();
		selenium.click(locator);
		selenium.waitDriver(1000);
		selenium.pageLoad();
	}
	
	@And("^I enter \"([^\"]*)\" as \"([^\"]*)\"$")
	public void enterUsrPwd(String value, String locator){
		selenium.frames();
		//selenium.getElement(locator).sendKeys(value);		
	}
	
	
	@Then("^the home page must be displayed$")
	public void validateHomePage(){
		
	}

}
