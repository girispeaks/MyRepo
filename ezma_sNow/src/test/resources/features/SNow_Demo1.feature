Feature: SNow Tests 

Scenario: Creating Change Request scenario 
       Given I open "https://cscqa.service-now.com/login_with_sso.do?glide_sso_id=8769c3ed6f79d600116dbd5dbb3ee460" URL in the browser 
#       And I click on "signin" button
       Then I enter "mchandramoh2" into "UserId" text field 
       Then I enter "Babyma@43" into "Signinpassword" text field 
       And I click on "Signinsubmit" button
       Then I wait for "10" seconds
#       And I click on "Manage" button
#       Then I click on "Instance" button
#       Then I click on "DevInstanceUrl" button
#       Then I switch to popup
#       Then I switch to frame "gsft_nav"
#       Then I enter "admin" into "Uname" text field 
#       Then I enter "manova91" into "Pwd" text field
#       Then I wait for "2" seconds
#       Then I unselect "Rembrme" checkbox
#       Then I click on "Login" button
       And I enter "change" into "search" field and click enter
#       Then I switch to frame "gsft_main"
#       Then I wait for "4" seconds
##       Then I click on "NormalCRQ" button
##       Then I wait for "3" seconds
#       Then I enter "Testing" into "sdec" text field
#       Then I enter "Testing purpose" into "desc" text field
#       Then I click on "Configuration" link
#       And I switch to popup
#       Then I wait for "5" seconds
#       Then I click on "ConfigurationItem" link
#       Then I Switch to Parent Window
#       Then I wait for "3" seconds
#       Then I switch to frame "gsft_main"
#       Then I click on "Assignmentgroup" link
#       And I switch to popup
#       Then I wait for "5" seconds
#       Then I click on "heirarchy" link
#       Then I Switch to Parent Window
#       Then I wait for "3" seconds
#       Then I switch to frame "gsft_main"
#       And I click on "assigned" link
#       And I switch to popup
#       Then I wait for "5" seconds
#       And I click on "assignedto" link
#       Then I Switch to Parent Window
#       Then I wait for "3" seconds
#       Then I switch to frame "gsft_main"
#       
#       Then I enter "Change for selcuke" into "justification" text field
#       Then I enter "steps:Install necessary softwares required for testing" into "implementationplan" text field
#       Then I enter "System downtime" into "riskfield" text field
#       Then I enter "Revert the changes" into "backoutfiled" text field
#       Then I enter "Attached the same" into "testplanfield" text field
#       Then I wait for "2" seconds
#       And I store "ChangeNumber" field
#       Then I save "Assignee" field value element
#       Then I wait for "2" seconds
#       And I click on "submitCRQ" button
#       Then I wait for "2" seconds
#       
#       Then I wait for "2" seconds
#       Then I search for "searchCRQ" in search field and click enter
#       Then I click on "CRQLink" button
#    	And I wait for "5" seconds
#    Then I compare the "New" state with the "stateComp" element state
#     Then I wait for "2" seconds
#       Then I click on "RequestApproval" button 
#       Then I wait for "2" seconds
#       Then I compare the "Assess" state with the "stateComp" element state
#       And I wait for "4" seconds
#       Then I switch to default content
#       And I click on "userInfo" button
#       Then I wait for "2" seconds
#       Then I click on "impersonate" button
#       Then I wait for "3" seconds
#       Then I click on "SearchForuser" button
#       Then I wait for "3" seconds
#       Then I search for "searchUser" value saved in search field element and click enter
#       #Then I enter "Beth Anglin" into "searchUser" text field 
#       Then I wait for "2" seconds
#       Then I click on "ApproverName" button 
#       Then I wait for "5" seconds
#      #Then I click on "Change" button
#      #Then I wait for "5" seconds
#      Then I click on "OpenCRQ" button 
#       Then I wait for "2" seconds
#      Then I switch to frame "gsft_main"
#      #code needs to be changed once search feature is automated
#       Then I search for "searchCRQ" in search field and click enter
#       Then I click on "CRQLink" button
#       
#       And I wait for "5" seconds
#       And I click on "ApproversTab" button
#       Then I wait for "5" seconds
#       Then I select "ApproversCheck" checkbox
#       Then I wait for "3" seconds
#       Then I click on "ApprovalDrp" button
#       Then I click on "ApprovalSel" button
#       Then I wait for "2" seconds
#       Then I compare the "Authorize" state with the "stateComp" element state
#       Then I switch to default content
#       And I click on "userInfo" button
#       Then I wait for "2" seconds
#       Then I click on "impersonate" button
#       Then I wait for "3" seconds
#       Then I click on "SearchForuser" button
#       Then I wait for "3" seconds
#       Then I enter "Bernard Laboy" into "searchUser" text field 
#       Then I wait for "2" seconds
#       Then I click on "ApproverName" button 
#       Then I wait for "3" seconds
#      And I enter "change" into "search" field and click enter
#      Then I wait for "2" seconds
#      Then I click on "OpenCREQ" button 
#       Then I wait for "2" seconds
#      Then I switch to frame "gsft_main"
#      
#       Then I search for "searchCRQ" in search field and click enter
#       Then I click on "CRQLink" button
#       
#       And I click on "AuthApprovaltab" button
#       Then I wait for "5" seconds
#       Then I select "AuthApproversCheck" checkbox
#       Then I wait for "3" seconds
#       Then I click on "AuthApprovalDrp" button
#       Then I click on "AuthApprovalSel" button
#       Then I wait for "2" seconds
#       Then I compare the "Scheduled" state with the "stateComp" element state
#       Then I wait for "2" seconds
#       Then I switch to default content
#       And I click on "userInfo" button
#       
#       Then I wait for "2" seconds
#       Then I click on "impersonate" button
#       Then I wait for "3" seconds
#       Then I click on "SearchForuser" button
#       Then I wait for "3" seconds
#       Then I search for "searchUser" value saved in search field element and click enter
#       Then I wait for "2" seconds
#       Then I click on "ApproverName" button 
#       Then I wait for "5" seconds
#      Then I click on "OpenCRQ" button 
#       Then I wait for "2" seconds
#      Then I switch to frame "gsft_main"
#       Then I search for "searchCRQ" in search field and click enter
#       Then I click on "CRQLink" button
#       
#       And I wait for "5" seconds
#       Then I click on "Implement" button
#       Then I wait for "2" seconds
#       Then I compare the "Implement" state with the "stateComp" element state
#       Then I wait for "2" seconds
#       Then I click on "Review" button
#       Then I wait for "2" seconds
#       Then I compare the "Review" state with the "stateComp" element state
#       Then I wait for "2" seconds
#       And I click on "ClosureTab" button
#       Then I wait for "2" seconds
#       Then I enter "CRQ completed successfully" into "CloseNotes" text field
#       Then I click on "CloseCode" button
#       
#       Then I click on "CloseCodeVal" button
#       Then I wait for "8" seconds
#       Then I click on "CloseCRQ" button
#       Then I wait for "2" seconds
#       Then I click on "CloseCRQ" button
#       Then I wait for "8" seconds
#       Then I compare the "Closed" state with the "stateComp" element state
