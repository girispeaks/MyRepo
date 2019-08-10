package com.pageobjmod.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pageobjmod.qa.base.BaseTest;

public class HomePage extends BaseTest{
	
	@FindBy(xpath="//a[text()='Home']")
	WebElement homeLabel;
	
	@FindBy(xpath="//td[contains(text(),'User')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement contactsLink;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String getUserName(){
		return userNameLabel.getText();
	}
	
	public Boolean homePageValidate(){
		return homeLabel.isDisplayed();
	}
	
	public ContactsPage clickContacts(){
		contactsLink.click();
		return new ContactsPage();
	}
	
	
}
