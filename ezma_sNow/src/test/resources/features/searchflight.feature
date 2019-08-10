Feature: united airlines ticket booking scenarios 

Scenario: Book ticket 
	Given I open "http://www.united.com" URL in the browser 
	Then I enter "Chicago, IL (ORD - O'Hare)" into "from" text field 
	Then I enter "Bangalore IN (BLR)" into "to" text field 
	Then I enter "4/25/2015" into "departDate" text field 
	Then I click on "submit" button 
	Then I wait for "20" seconds 
	Then I click on "toFlightOption" link 
	Then I wait for "10" seconds
	Then I click on "returnOption" link
	Then I wait for "20" seconds 