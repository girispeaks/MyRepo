Feature: SNow Tests 

Scenario: Conflicts 

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
       #Then I enter "Testing" into "sdec" text field
       #Then I enter "Testing purpose" into "desc" text field
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
       #Then I enter "Change for selcuke" into "justification" text field
       #Then I enter "steps:Install necessary softwares required for testing" into "implementationplan" text field
       #Then I enter "System downtime" into "riskfield" text field
       #Then I enter "Revert the changes" into "backoutfiled" text field
       #Then I enter "Attached the same" into "testplanfield" text field
       
       Then I wait for "2" seconds
       And I store "ChangeNumber" field
       Then I wait for "2" seconds
       And I click on "submitCRQ" button
       Then I wait for "2" seconds
       Then I search for "searchCRQ" in search field and click enter
       Then I click on "CRQLink" button
    And I wait for "5" seconds
       Then I click on "RequestApproval" button 
       And I wait for "4" seconds
       #Then I switch to default content
       
       #Conflicts
       
       Then I click on "Scheduletab" button
       #Then I click on "requesteddate" button
#      Then I enter PST time zone in "date field" datepicker
       Then I enter PST time zone in "Datepicker" datepicker
       Then I enter PST time zone in "PlannedStartDate" datepicker
       Then I enter "PlannedEndDate" in datepicker
       Then I enter PST time zone in "ActualStartDate" datepicker
       Then I enter "ActualEndDate" in datepicker
       Then I wait for "2" seconds
       Then I click on "conflictsTab" button
       Then I click on "checkconflicts" button
       Then I wait for "30" seconds
       And I click on "conflictsclose" button
       Then I wait for "8" seconds
       And I compare the "Conflict" state with the "conflictstatus" element state
       Then I wait for "2" seconds
       And I should see "Conflicts detected, see the Conflicts section below" on the page
       Then I click on "copychange" button 
       Then I wait for "3" seconds
       Then I click on "Scheduletab" button
       Then I enter same PST time zone in "Datepicker" datepicker
       #Then I click on "conflictsTab" button
