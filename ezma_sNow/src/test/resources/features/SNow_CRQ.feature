Feature: SNow Tests 

@1234 @chrome @smoke @regression
Scenario: Create CRQ
	Given I open "https://dev20420.service-now.com/nav_to.do?uri=%2Fchange_request.do%3Fsys_id%3D1379ae100ffb92009a0b4f8ce1050e40%26sysparm_record_target%3Dchange_request%26sysparm_record_row%3D108%26sysparm_record_rows%3D108%26sysparm_record_list%3DORDERBYnumber" URL in the browser 
	And I wait for "20" seconds
	Then I switch to frame "gsft_main"
	Then I click on "RequestApproval" button	
	And I wait for "5" seconds
	And I click on "ApproversTab" button
	Then I wait for "5" seconds
	Then I select "ApproversCheck" checkbox
	Then I wait for "3" seconds
	Then I click on "ApprovalDrp" button
	Then I click on "ApprovalSel" button
	And I wait for "5" seconds
	And I click on "AuthApprovaltab" button
	Then I wait for "5" seconds
	Then I select "AuthApproversCheck" checkbox
	Then I wait for "3" seconds
	Then I click on "AuthApprovalDrp" button
	Then I click on "AuthApprovalSel" button
	Then I wait for "2" seconds
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
