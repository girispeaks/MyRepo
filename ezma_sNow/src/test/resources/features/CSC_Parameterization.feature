Feature: SNow Tests 

Scenario Outline: Parameterized Example

       Given I open "https://cscqa.service-now.com/login_with_sso.do?glide_sso_id=8769c3ed6f79d600116dbd5dbb3ee460" URL in the browser
       Then I enter "<UserName>" into "UserId" text field 
       Then I enter "<Password>" into "Signinpassword" text field 
       And I click on "Signinsubmit" button
       Then I wait for "4" seconds
       And I should see "Your User ID or Password is invalid, please re-enter." on the page
     
       
 Examples:
 
 	|UserName		|Password	|
 	|mchandramoh2	|Test@1234	|
 	|rromita		|Test@123	|
 	|testuser		|Test@1234	|