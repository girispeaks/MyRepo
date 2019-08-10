Feature: SNow Tests 

@1234 @chrome @smoke @regression
Scenario: Create CRQ
	Given I open "https://dev20420.service-now.com/nav_to.do?uri=%2Fchange_request.do%3Fsys_id%3Df7e17d990f7bd2009a0b4f8ce1050ec1%26sysparm_record_target%3Dchange_request%26sysparm_record_row%3D170%26sysparm_record_rows%3D170%26sysparm_record_list%3DORDERBYnumber" URL in the browser 
	And I wait for "20" seconds
	Then I switch to frame "gsft_main"
	And I store "ChangeNumber" field
	And I store "ChangeNumber" field
	#Then I search for CRQ in "ShrtDesc" search field
	#And I store the "ChangeNumber" and place in "ShrtDesc" field
	#And I wait for "20" seconds
	
	#And I compare the "stateComp" element state
	Then I wait for "2" seconds
	#And I click on "ClosureTab" button
	#And I store the "ChangeNumber" and place in field
	Then I click on "RequestApproval" button	
	And I wait for "10" seconds
	#And I compare the "stateComp" element state
	And I wait for "5" seconds
	Then I switch to default content
	And I click on "userInfo" button
	
	Then I wait for "2" seconds
	Then I click on "impersonate" button
	Then I wait for "3" seconds
	Then I click on "SearchForuser" button
	Then I wait for "3" seconds
	#Then I enter "Beth Anglin" into "searchUser" text field 
	Then I wait for "2" seconds
	Then I click on "ApproverName" button 
 	Then I wait for "5" seconds
 	Then I click on "Change" button
 	Then I click on "OpenCRQ" button 
 	Then I wait for "2" seconds
 	Then I switch to frame "gsft_main"
 	#code needs to be changed once search feature is automated
 	Then I search for "SearchCRQ" in search field and click enter
	#Then I enter "CHG0030196" into "SearchCRQ" field and click enter 
	Then I click on "ClickCRQ" button
	
	And I wait for "5" seconds
	And I click on "ApproversTab" button
	Then I wait for "5" seconds
	Then I select "ApproversCheck" checkbox
	Then I wait for "3" seconds
	Then I click on "ApprovalDrp" button
	Then I click on "ApprovalSel" button
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
 	Then I wait for "5" seconds
 	Then I click on "Change" button
 	Then I click on "OpenCRQ" button 
 	Then I wait for "2" seconds
 	Then I switch to frame "gsft_main"
 	#code needs to be changed once search feature is automated
	Then I enter "CHG0030196" into "SearchCRQ" field and click enter 
	Then I click on "ClickCRQ" button
	
	And I click on "AuthApprovaltab" button
	Then I wait for "5" seconds
	Then I select "AuthApproversCheck" checkbox
	Then I wait for "3" seconds
	Then I click on "AuthApprovalDrp" button
	Then I click on "AuthApprovalSel" button
	Then I wait for "2" seconds
	Then I switch to default content
	And I click on "userInfo" button
	
	Then I wait for "2" seconds
	Then I click on "impersonate" button
	Then I wait for "3" seconds
	Then I click on "SearchForuser" button
	Then I wait for "3" seconds
	Then I enter "Beth Anglin" into "searchUser" text field 
	Then I wait for "2" seconds
	Then I click on "ApproverName" button 
 	Then I wait for "5" seconds
 	Then I click on "Change" button
 	Then I click on "OpenCRQ" button 
 	Then I wait for "2" seconds
 	Then I switch to frame "gsft_main"
 	#code needs to be changed once search feature is automated
	Then I enter "CHG0030196" into "SearchCRQ" field and click enter 
	Then I click on "ClickCRQ" button
	
	And I wait for "5" seconds
	Then I click on "Implement" button
	Then I wait for "2" seconds
	Then I click on "Review" button
	Then I wait for "2" seconds
	And I click on "ClosureTab" button
	Then I wait for "2" seconds
	Then I enter "CRQ completed successfully" into "CloseNotes" text field
	Then I click on "CloseCode" button
	
	Then I click on "CloseCodeVal" button
	#Then I select "CloseCodeVal" from "CloseCode" select box
	Then I wait for "8" seconds
	Then I click on "CloseCRQ" button
	Then I wait for "2" seconds
	Then I click on "CloseCRQ" button
	Then I wait for "8" seconds
	And I compare the "Closed" state with the "stateComp" element state
	

 	
	#And I compare the "stateComp" element state