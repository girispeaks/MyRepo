Feature: Registering an user in courseRA

Scenario: Registering an user

Given I go to "applicationUrl" on "browser"
When I click on "signUp" button
And I enter "DemoName" in "fullName" field
And I enter "demo333@gmail.com" in "email" field
And I enter "demo@3e16234" in "Password" field
And I click on "SignUp_Submit" button
Then I close the browser
#Then user registration must be successful
