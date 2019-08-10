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
Feature: Testing Login Feature
	This file will be used to test the login functionalities

@tag1
Scenario: Login with valid user credential
Given I have opened the "browser"
	And I launch the application using "url"
Then I click on "loginlink"
	And I enter "girispeaks@gmail.com" as "userid"
	And I enter "Wed@1234" as "password"
	And I click on "loginbutton"
Then the home page must be displayed
	

#@tag2
#Scenario Outline: Title of your scenario outline
#Given I want to write a step with <name>
#When I check for the <value> in step
#Then I verify the <status> in step

#Examples:
#    | name  |value | status |
#    | name1 |  5   | success|
#    | name2 |  7   | Fail   |
