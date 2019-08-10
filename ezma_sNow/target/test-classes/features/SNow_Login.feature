Feature: SNow Tests 

@1234 @chrome @smoke @regression
Scenario: Registration  scenario 
	Given I open "https://developer.servicenow.com/app.do#!/home" URL in the browser 
	And I click on "signin" button
	Then I enter "edcruz@csc.com" into "SigninEmail" text field 
	Then I enter "Emaria@123" into "Signinpassword" text field 
	And I click on "Signinsubmit" button
	Then I wait for "10" seconds
	And I click on "Manage" button
	Then I click on "DevInstanceUrl" button
	Then I switch to popup
	Then I switch to frame "gsft_main"
	Then I enter "admin" into "Uname" text field 
	Then I enter "Emaria@123" into "Pwd" text field
	Then I unselect "Rembrme" checkbox
	Then I click on "Login" button
	And I enter "workflow" into "search" field and click enter
	
	

