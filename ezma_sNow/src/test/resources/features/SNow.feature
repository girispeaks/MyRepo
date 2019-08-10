Feature: SNow Tests 

@1234 @chrome @smoke @regression
Scenario: Registration  scenario 
	Given I open "https://developer.servicenow.com/app.do#!/home" URL in the browser 
	
	And I click on "page.signup" button
	Then I should see "Welcome" on the page
	Then I enter "test4" into "firstname" text field 
	Then I enter "test5" into "lastname" text field 
	Then I enter "ezmadcruz@yahoo.co.in" into "email" text field 
	Then I enter "Emaria@123" into "password" text field 
	Then I enter "Emaria@123" into "confirmpassword" text field
	Then I wait for "20" seconds
	Then I select "terms" checkbox 
	And I click on "submit" button
	
	

