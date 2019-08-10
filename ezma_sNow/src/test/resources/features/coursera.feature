Feature: Coursera Tests 

@1234 @chrome @smoke @regression
Scenario: Registration negative scenario 
	Given I open "https://accounts.coursera.org/signup" URL in the browser 
	Then I enter "Beena Shah" into "page.fullname" text field 
	Then I enter "test@gmail.com" into "email1" text field 
	Then I enter "password123" into "password1" text field 
	Then I wait for "2" seconds 
	Then I click on "signup1" button
	Then I wait for "20" seconds 
	Then I should see "A coursera.org account with that email address already exists." on the page
	Then close browser window
	


