#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios 
#<> (placeholder)
#""
## (Comments)

#Sample Feature Definition Template
@tag
Feature: Login page functionalities
	Valid login, Invalid login, Forgot Password

@login_validCredentials
Scenario: Login with valid login credentials
Given I go to "url" on "browser"
When I enter the "girispeaks@gmail.com" in the "email" field
And I enter "Aug@1234" in the "password" field
And I click on "sign_in" button
Then login must be successful

@login_invalidemail
Scenario: Login with invalid email
Given I go to "url" on "browser"
When I enter the "girispeaks234@gmail.com" in the "email" field
And I enter "Aug@1234" in the "password" field
And I click on "sign_in" button
Then "Invalid email address" message must be displayed for "incorrect_email"

@login_invalidPwd	
Scenario: Login with invalid password
Given I go to "url" on "browser"
When I enter the "girispeaks@gmail.com" in the "email" field
And I enter "Aug23@1234" in the "password" field
And I click on "sign_in" button
Then "Invalid password" message must be displayed for "incorrect_pwd" 

#@tag2
#Scenario Outline: Title of your scenario outline
#Given I want to write a step with <name>
#When I check for the <value> in step
#Then I verify the <status> in step

#Examples:
#    | name  |value | status |
 #   | name1 |  5   | success|
 #   | name2 |  7   | Fail   |
