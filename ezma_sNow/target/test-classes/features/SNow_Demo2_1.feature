Feature: SNow Tests 

Scenario: RiskAssessment

Given I open "https://developer.servicenow.com/app.do#!/home" URL in the browser 
       And I click on "signin" button
       Then I enter "syenumala@csc.com" into "SigninEmail" text field 
       Then I enter "!Apr@123" into "Signinpassword" text field 
       And I click on "Signinsubmit" button
       Then I wait for "10" seconds
       And I click on "Manage" button
       Then I click on "DevInstanceUrl" button
       Then I switch to popup
       Then I switch to frame "gsft_main"
       Then I enter "admin" into "Uname" text field 
       Then I enter "!Apr@123" into "Pwd" text field
       Then I wait for "2" seconds
       Then I unselect "Rembrme" checkbox
       Then I click on "Login" button
       And I enter "change" into "search" field and click enter
       Then I switch to frame "gsft_main"
       Then I wait for "4" seconds
       Then I click on "NormalCRQ" button
       Then I wait for "3" seconds
       Then I enter "Testing" into "sdec" text field
       Then I enter "Testing purpose" into "desc" text field
       Then I click on "Configuration" link
       And I switch to popup
       Then I wait for "5" seconds
       Then I click on "ConfigurationItem" link
       Then I Switch to Parent Window
       Then I wait for "3" seconds
       Then I switch to frame "gsft_main"
       Then I click on "Assignmentgroup" link
       And I switch to popup
       Then I wait for "5" seconds
       Then I click on "heirarchy" link
       Then I Switch to Parent Window
       Then I wait for "3" seconds
       Then I switch to frame "gsft_main"
       And I click on "assigned" link
       And I switch to popup
       Then I wait for "5" seconds
       And I click on "assignedto" link
       Then I Switch to Parent Window
       Then I wait for "3" seconds
       Then I switch to frame "gsft_main"
       Then I enter "Change for selcuke" into "justification" text field
       Then I enter "steps:Install necessary softwares required for testing" into "implementationplan" text field
       Then I enter "System downtime" into "riskfield" text field
       Then I enter "Revert the changes" into "backoutfiled" text field
       Then I enter "Attached the same" into "testplanfield" text field
       And I wait for "5" seconds
       Then I click on "Scheduletab" button
       Then I enter PST time zone in "RequestedbyDate" datepicker
       Then I wait for "4" seconds
       Then I enter PST time zone in "Datepicker" datepicker
       Then I increment "5" days in "PlannedStartDate" field
       Then I wait for "4" seconds
       Then I increment "5" days in "PlannedEndDate" field
       #Then I enter "PlannedEndDate" in datepicker
       Then I wait for "2" seconds
       And I store "ChangeNumber" field
       Then I wait for "2" seconds
       Then I save "Assignee" field value element
       Then I wait for "2" seconds
       And I click on "submitCRQ" button
       Then I wait for "2" seconds
       Then I search for "searchCRQ" in search field and click enter
       Then I click on "CRQLink" button
    And I wait for "5" seconds
    Then I compare the "New" state with the "stateComp" element state
    And I wait for "5" seconds
       Then I click on "RequestApproval" button 
       And I wait for "2" seconds
       Then I compare the "Assess" state with the "stateComp" element state
       And I wait for "4" seconds
       Then I switch to default content
       And I click on "userInfo" button
       Then I wait for "2" seconds
       Then I click on "impersonate" button
       Then I wait for "3" seconds
       Then I click on "SearchForuser" button
       Then I wait for "3" seconds
       Then I search for "searchUser" value saved in search field element and click enter 
       Then I wait for "2" seconds
       Then I click on "ApproverName" button 
       Then I wait for "5" seconds
      Then I click on "Change" button 
      Then I wait for "5" seconds
       Then I click on "OpenCRQ" button 
       Then I wait for "2" seconds
       Then I switch to frame "gsft_main"
       Then I search for "searchCRQ" in search field and click enter
       Then I click on "CRQLink" button
       Then I compare the "Moderate" state with the "RiskState" element state
       Then I wait for "2" seconds
       Then I click on "calculaterisk" link
       #Then I click on "calculaterisk" link
       Then I wait for "4" seconds
       And I should see "Risk Condition applied: Default; Risk: Low; impact: 3 - Low" on the page
       And I should see "Risk: Low" on the page
       Then I wait for "2" seconds
       Then I compare the "Low" state with the "RiskState" element state
       And I wait for "5" seconds
       And I click on "ApproversTab" button
       Then I wait for "5" seconds
       Then I select "ApproversCheck" checkbox
       Then I wait for "3" seconds
       Then I click on "ApprovalDrp" button
       Then I click on "ApprovalSel" button
       Then I wait for "2" seconds
       Then I compare the "Authorize" state with the "stateComp" element state
       Then I switch to default content
       And I click on "userInfo" button
       Then I wait for "2" seconds
       Then I click on "impersonate" button
       Then I wait for "3" seconds
       Then I click on "SearchForuser" button
       Then I wait for "3" seconds
       Then I enter "Bernard Laboy" into "searchUser" text field 
       Then I wait for "2" seconds
       Then I click on "ApproverName" button 
       Then I wait for "3" seconds
      And I enter "change" into "search" field and click enter
      Then I wait for "2" seconds
      Then I click on "OpenCREQ" button 
       Then I wait for "2" seconds
      Then I switch to frame "gsft_main"
      
       Then I search for "searchCRQ" in search field and click enter
       Then I click on "CRQLink" button
       
       And I click on "AuthApprovaltab" button
       Then I wait for "5" seconds
       Then I select "AuthApproversCheck" checkbox
       Then I wait for "3" seconds
       Then I click on "AuthApprovalDrp" button
       Then I click on "AuthApprovalSel" button
       Then I wait for "2" seconds
       Then I compare the "Scheduled" state with the "stateComp" element state
       Then I wait for "2" seconds
       
       Then I switch to default content
       And I click on "userInfo" button
       
       Then I wait for "2" seconds
       Then I click on "impersonate" button
       Then I wait for "3" seconds
       Then I click on "SearchForuser" button
       Then I wait for "3" seconds
       Then I search for "searchUser" value saved in search field element and click enter
       Then I wait for "2" seconds
       Then I click on "ApproverName" button 
       Then I wait for "5" seconds
      Then I click on "OpenCRQ" button 
       Then I wait for "2" seconds
      Then I switch to frame "gsft_main"
       Then I search for "searchCRQ" in search field and click enter
       Then I click on "CRQLink" button
       And I wait for "5" seconds
       Then I click on "Scheduletab" button
       #Then I enter PST time zone in "Datepicker" datepicker
       Then I wait for "2" seconds
       Then I clear dates and increment "2" days in "PlannedStartDate" field
       #Then I enter "PlannedStartDate" in datepicker
       Then I increment "2" days in "ActualStartDate" field
       #Then I enter "ActualStartDate" in datepicker
       Then I wait for "4" seconds
       Then I increment "2" days in "ActualEndDate" field
       #Then I enter "ActualEndDate" in datepicker
       Then I wait for "4" seconds
       Then I clear dates and increment "2" days in "PlannedEndDate" field
       #Then I enter "PlannedEndDate" in datepicker
       Then I wait for "2" seconds
       Then I click on "calculaterisk" link
       Then I wait for "2" seconds
       And I should see "Risk Condition applied: Insufficient lead time; Risk: Very High; Impact unchanged" on the page
       And I should see "Risk: Very High" on the page
       Then I wait for "3" seconds
       And I compare the "Very High" state with the "RiskState" element state
