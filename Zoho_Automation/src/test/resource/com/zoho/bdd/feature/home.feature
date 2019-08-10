@tag
Feature: Validating the features of Home screen


#Given I am logged into the application using "browser"

 @Home
 Scenario: Check the contents of home page   
  	Given I am logged into the application using "browser"
    Then I verify the "cliq_link" and "crm_link" and "salesiq_link" of home page

   