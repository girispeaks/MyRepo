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
       Then I switch to frame "gsft_nav"
       
       And I enter "change" into "search1" field and click enter
       Then I switch to default content
       Then I switch to frame "gsft_main"
       #Then I wait for "4" seconds
       #Then I click on "NormalCRQ" button
       #Then I wait for "3" seconds
       Then I enter "Testing" into "sdec" text field
       Then I enter "Testing purpose" into "desc" text field
       Then I click on "Configuration1" link
       And I switch to popup
       Then I wait for "5" seconds
       Then I click on "ConfigurationItem" link
       Then I Switch to Parent Window
       Then I wait for "3" seconds
       Then I switch to frame "gsft_main"
       Then I click on "Assignmentgroup1" link
       And I switch to popup
       Then I wait for "5" seconds
       Then I click on "heirarchy1" link
       Then I Switch to Parent Window
       Then I wait for "3" seconds
       Then I switch to frame "gsft_main"
       And I click on "assigned1" link
       And I switch to popup
       Then I wait for "5" seconds
       And I click on "assignedto" link
       Then I Switch to Parent Window
       Then I wait for "3" seconds
       Then I switch to frame "gsft_main"
       #Then I enter "Change for selcuke" into "justification" text field
       #Then I enter "steps:Install necessary softwares required for testing" into "implementationplan" text field
       #Then I enter "System downtime" into "riskfield" text field
       Then I enter "Change for develper instance to be implemented" into "changeplan" text field
       Then I enter "Revert the changes" into "backoutfiled" text field
       Then I enter "Attached the same" into "testplanfield" text field
       Then I compare the "Not Run" state with the "conflictstatus" element state
       And I wait for "5" seconds
       Then I click on "Scheduletab" button
       Then I enter PST time zone in "RequestedbyDate" datepicker
       Then I save "RequestedbyDate" requestdate field value element
       Then I wait for "4" seconds
       Then I enter planned start future date in "PlannedStartDate" datepicker
       Then I save "PlannedStartDate" PlannedStartDate field value element
       Then I wait for "4" seconds
      Then I enter planned end future date in "PlannedEndDate" field
      Then I save "PlannedEndDate" PlanendDate field value element
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
      #Then I click on "Change" button
      #Then I wait for "5" seconds
       Then I click on "OpenCRQ" button 
       Then I wait for "2" seconds
       Then I switch to frame "gsft_main"
       Then I search for "searchCRQ" in search field and click enter
       Then I click on "CRQLink" button  
       And I wait for "6" seconds
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
       Then I wait for "3" seconds
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
       
      	#And I store "CI" field
       
       Then I wait for "3" seconds
       Then I click on "conflictsTab" button
       Then I click on "checkconflicts" button
       Then I wait for "10" seconds
       And I click on "conflictsclose" button
       Then I wait for "5" seconds
       And I compare table "Not In Maintenance Window" value exists in table
        And I compare table "Inside blackout window" value exists in table
         And I compare table "CI Already Scheduled" value exists in table
         #And I compare table "*ANNIE-IBM" value exists in table
         #And I compare the saved value exists in table
         #And I compare table "CI Already Scheduled" value exists in table
       
       #Then I validate if "Not In Maintenance Window" value exists as "ConflictType" field in table
       #Then I validate if "Not In Maintenance Window" values exists as "ConflictType" field in table
       #Then I wait for "8" seconds
       #And I compare the "Conflict" state with the "ConflictStatusVal" element state
       #Then I wait for "2" seconds
       #And I should see "Conflicts detected, see the Conflicts section below" on the page
       Then I wait for "8" seconds
       And I compare the "Conflict" state with the "ConflictStatusVal" element state
       Then I wait for "2" seconds
       And I should see "Conflicts detected, see the Conflicts section below" on the page
       Then I wait for "2" seconds
       And I store "ChangeNumber" field
       
       #compare ANNIE-IBM
       
       #Store CRQ value
       
       Then I click on "copychange" button 
       Then I wait for "3" seconds
        And I store "Requestnumber" CRQfield of copychange
       Then I wait for "2" seconds
       Then I click on "Scheduletab" button
	   Then I wait for "2" seconds
	   Then I enter same PST date in "RequestedbyDate" field
       Then I wait for "4" seconds
       Then I enter same planned start future date in "PlannedStartDate" field
       Then I wait for "4" seconds
       Then I enter same plan end future date in "PlannedEndDate" field
       Then I wait for "2" seconds
       Then I save "Assignee" field value element
       Then I wait for "2" seconds
       And I click on "submitCRQ" button
       Then I wait for "6" seconds
        And I click on "conflictsclose" button
       Then I wait for "4" seconds
       Then I switch to default content
       And I enter "change" into "search" field and click enter
       Then I wait for "2" seconds
       Then I click on "OpenCREQ" button 
       Then I wait for "2" seconds
       Then I switch to frame "gsft_main"
      Then I search for "searchcopyuser" in CRQsearch field and click enter
      #Then I search for "searchCRQ" in search field and click enter
       Then I click on "CRQLink" button
       And I wait for "5" seconds
       Then I compare the "New" state with the "stateComp" element state
       And I wait for "5" seconds
       Then I click on "RequestApproval" button 
       And I wait for "2" seconds
       Then I compare the "Assess" state with the "stateComp" element state
       And I wait for "4" seconds
       #Then I switch to default content
       
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
       #Then I search for "searchCRQ" in search field and click enter
       Then I search for "searchcopyuser" in CRQsearch field and click enter
       Then I click on "CRQLink" button
       Then I wait for "3" seconds
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
       #Then I search for "searchCRQ" in search field and click enter
       Then I search for "searchcopyuser" in CRQsearch field and click enter
       Then I click on "CRQLink" button
       Then I click on "conflictsTab" button
       Then I click on "checkconflicts" button
       Then I wait for "20" seconds
       And I click on "conflictsclose" button
       Then I wait for "4" seconds
       And I compare table "Not In Maintenance Window" value exists in table
       And I compare table "Inside blackout window" value exists in table
       And I compare table "CI Already Scheduled" value exists in table
       And I compare the saved value exists in table
       Then I wait for "2" seconds
       And I store "CI" field
       #And I compare table "*ANNIE-IBM" value exists in table
       And I compare the saved value exists in table
       Then I wait for "8" seconds
       And I compare the "Conflict" state with the "ConflictStatusVal" element state
       Then I wait for "2" seconds
       And I should see "Conflicts detected, see the Conflicts section below" on the page
       Then I wait for "2" seconds
       