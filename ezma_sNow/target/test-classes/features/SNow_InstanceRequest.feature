Feature: SNow Tests 

@1234 @chrome @smoke @regression
Scenario: Request for Developer Instance  scenario 
	Given I open "https://developer.servicenow.com/app.do#!/home" URL in the browser 
	And I click on "signin" button
	Then I enter "ezmadcruz@yahoo.co.in" into "SigninEmail" text field 
	Then I enter "Emaria@123" into "Signinpassword" text field 
	
	And I click on "Signinsubmit" button
	Then I wait for "10" seconds
	And I click on "Manage" button
	Given I go to "https://developer.servicenow.com/app.do#!/instance" URL later
	Then I wait for "40" seconds
	Then I click on "DevInstURL" button
	Then I switch to popup
	Then I switch to frame "gsft_main"
	Then I wait for "10" seconds
	Then I enter "admin" into "Uname" text field 
	Then I enter "ck3eqk2m" into "Pwd" text field
	Then I unselect "Rembrme" checkbox
	Then I click on "Login" button
	And I enter "workflow" into "search" field and click enter
	
	
	Then I click on "ReqInst" button
	
	Then I wait for "ReqInstTerms" element for 2 mins
	And I click on "ReqInstTerms" button
	
	Then I wait for "DevInstURL" element for 2 mins

