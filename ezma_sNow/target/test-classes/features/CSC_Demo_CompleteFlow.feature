Feature: SNow Tests 

Scenario: Creating Change Request scenario 

       Given I open "https://cscqa.service-now.com/login_with_sso.do?glide_sso_id=8769c3ed6f79d600116dbd5dbb3ee460" URL in the browser
       Then I enter "mchandramoh2" into "UserId" text field 
       Then I enter "Imwaiting@43" into "Signinpassword" text field 
       And I click on "Signinsubmit" button
       Then I wait for "15" seconds
       And I enter "change" into "search" text field
       Then I wait for "6" seconds
       Then I click on "CreateNew" button
       Then I switch to frame "gsft_main"
       Then I click on "NormalCRQ" button
       Then I click on "Company" button
       And I switch to popup
       Then I wait for "5" seconds
       Then I click on "CompanyName" link
       Then I Switch to Parent Window
       Then I wait for "3" seconds
       Then I switch to frame "gsft_main"
       Then I wait for "2" seconds
       Then I select "Software" from "Category" select box
       Then I wait for "2" seconds
       Then I click on "Configuration1" button
       And I switch to popup
       Then I wait for "5" seconds
       Then I click on "ConfigurationItem" link
       Then I Switch to Parent Window
       Then I wait for "3" seconds
       Then I switch to frame "gsft_main"
       And I enter "ServiceNow Data Support" into "AssignmentGroup" field and click enter
       Then I wait for "2" seconds
       Then I click on "AssignedTo" link
       And I switch to popup
       Then I wait for "5" seconds
       Then I click on "AssignedToList" link
       Then I Switch to Parent Window
       Then I wait for "5" seconds
       Then I switch to frame "gsft_main"
       Then I enter "demo short desc for selcuke" into "ShortDesc" text field
       Then I wait for "2" seconds

       And I store "ChangeNumber" field
       Then I wait for "2" seconds
       Then I click on "Scheduletab" button
       Then I enter future date in "PlannedStartDate" datepicker
       Then I save "PlannedStartDate" PlannedStartDate field value element
       Then I wait for "4" seconds
       Then I enter future date in "PlannedEndDate" datepicker
       Then I save "PlannedEndDate" PlanendDate field value element
       Then I wait for "2" seconds
       Then I click on "Planning" button
       Then I enter "demo justification for selcuke" into "Justification" text field
       Then I click on "CRQSubmit" button
       
       Then I search for "searchCRQ" in search field and click enter
       Then I click on "CRQLink" button
       And I wait for "5" seconds
       Then I click on "RequestApproval" button
       Then I save "AssngedToValue" field value element
	   Then I wait for "2" seconds
       Then I switch to default content
       And I click on "userInfo" button
       Then I wait for "2" seconds
       Then I click on "impersonate" button
       Then I wait for "3" seconds
       Then I click on "SearchForuser" button
       Then I wait for "3" seconds
       Then I enter "searchUser" value saved in search field element and click enter
       Then I wait for "4" seconds
       Then I click on "ApproverName" button 
       Then I wait for "15" seconds
       
       And I enter "open" into "search" text field
       Then I wait for "6" seconds
#       Then I switch to frame "gsft_nav"
       Then I click on "OpenCRQ" button 
       Then I wait for "5" seconds
       Then I switch to frame "gsft_main"
       Then I search for "searchCRQ" in search field and click enter
       Then I click on "CRQLink" button  
       And I wait for "6" seconds
       Then I select "Approver" from "ApproversGoTo" select box
       Then I enter "AprroversSearchUser" value saved in search field element and click enter
       And I wait for "3" seconds
       Then I select "ApproversCheck" checkbox
       Then I select "   Approve" from "Approversdropdown" select box
       Then I wait for "3" seconds
       Then I select "State" from "ApproversGoTo" select box
       And I enter "Requested" into "ApproverSearch" field and click enter
       Then I wait for "3" seconds
       Then I select "CABApproversCheck" checkbox
       Then I select "   Approve" from "Approversdropdown" select box
       Then I wait for "5" seconds
       Then I select "TaskCheck" checkbox
       Then I select "   Close Task" from "ChangeTaskdropdown" select box
       Then I wait for "10" seconds
       
       Then I increment "2" days in "ActualStartDate" field
       Then I wait for "4" seconds
       Then I increment "3" days in "ActualEndDate" field
       Then I wait for "4" seconds
       
       Then I enter "Completed Successfully" into "CloseNotes" text field
       Then I wait for "2" seconds
       Then I select "Completed Successful" from "StateDropdown" select box
       Then I wait for "2" seconds
       Then I click on "Update" button
       And I should see "Completed Successful" on the page

       

      
       