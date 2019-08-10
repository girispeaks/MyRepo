Feature: Logging into Salesforce

In order to work 
As a sales person
I want to login
@login
Scenario Outline: Loggin in salesforce

Given Runmode is "<Runmode>"
Given I go to "LoginURL" on "<Browser>"
And I enter "loginusername" as "<Username>"
And I enter "loginpassword" as "<Password>"
And I click on "loginButton"
Then login should be "<ExpectedResult>"

Examples:
	|Runmode| Browser | Username 			 | Password | ExpectedResult |
	|N		| Mozilla | xxxxxxx 			 | yyyyyy   | Fail           |
	|N		| Mozilla | girispeaks@gmail.com | Wed@1234 | Success        |
