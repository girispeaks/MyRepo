Feature: Testing the top menu

In order to perform all operations after login  
As a sales person
I want to check menu items
@menu
Scenario Outline: Testing Top Menu

Given I am logged in "<Browser>"
Then All tabs on the menu should be present	
	|hometab|
	|Leadtab|
	
And I click on "<HeaderLink>"
Then "<VerificationObject>" should be present

Examples:
	|Browser|HeaderLink|VerificationObject|
	|Mozilla|hometab   |searchtext        |
	|Mozilla|leadtab   |recentLead        |
