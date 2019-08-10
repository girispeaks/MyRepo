package com.pageobjmod.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.pageobjmod.qa.base.BaseTest;

public class LoginPage extends BaseTest{
	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit' and @value='Login']")
	WebElement loginButton;
	
	@FindBy(xpath="//a[@class='navbar-brand']/img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//BaseTest test=new BaseTest();
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String pageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateLogo(){
		return crmLogo.isDisplayed();
	}
	

	public HomePage doLogin(String userNm, String pwd){
		userName.sendKeys(userNm);
		password.sendKeys(pwd);
		loginButton.click();
		return new HomePage();
	}

}
