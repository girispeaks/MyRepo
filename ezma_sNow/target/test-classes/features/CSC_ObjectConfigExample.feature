Feature: SNow Tests 

Scenario: Test Case-1 with valid user id

       Given I open "https://cscqa.service-now.com/login_with_sso.do?glide_sso_id=8769c3ed6f79d600116dbd5dbb3ee460" URL in the browser
       Then I enter "mchandramoh2" into "UserId" text field 
       Then I enter "Imwaiting@43" into "Signinpassword" text field 
       And I click on "Signinsubmit" button
       Then I wait for "4" seconds
       And I should see "Service Automation - QA Environment" on the page
       
       
 Scenario: Test Case-2 with invalid user id and valid password
 
       Given I open "https://cscqa.service-now.com/login_with_sso.do?glide_sso_id=8769c3ed6f79d600116dbd5dbb3ee460" URL in the browser
       Then I enter "mchandramoh123" into "UserId" text field 
       Then I enter "Test@123" into "Signinpassword" text field 
       And I click on "Signinsubmit" button
       Then I wait for "4" seconds
       And I should see "Your User ID or Password is invalid, please re-enter." on the page
       
       
Scenario: Test Case-3 with valid user id and invalid password
 
       Given I open "https://cscqa.service-now.com/login_with_sso.do?glide_sso_id=8769c3ed6f79d600116dbd5dbb3ee460" URL in the browser
       Then I enter "mchandramoh2" into "UserId" text field 
       Then I enter "Test@123456" into "Signinpassword" text field 
       And I click on "Signinsubmit" button
       Then I wait for "4" seconds
       And I should see "Your User ID or Password is invalid, please re-enter." on the page
    
Scenario: Test Case-4 with invalid user id and invalid password
		
	   Given I open "https://cscqa.service-now.com/login_with_sso.do?glide_sso_id=8769c3ed6f79d600116dbd5dbb3ee460" URL in the browser
       Then I enter "mchandramoh21234" into "UserId" text field 
       Then I enter "Test@123456" into "Signinpassword" text field 
       And I click on "Signinsubmit" button
       Then I wait for "4" seconds
       And I should see "Your User ID or Password is invalid, please re-enter." on the page
       