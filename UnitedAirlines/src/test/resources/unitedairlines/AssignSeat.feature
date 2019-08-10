Feature: AssignSeat Feature

  @Smoke @Functional @Regression
  Scenario: TC01_AssignSeat #To verify assign Seat
    Given I create "RequestSeats" WS request with "TC001" test data and save request as "Req_TC001.xml" file
    Then I post "Req_TC001.xml" request to "RequestSeats" WS method and save response as "Res_TC001.xml" file
#    Then I verify If "100" exists in "Res_SENDSMS_TC01.xml" response in "//SendSMSResponse/SendSMSResult/MessageStatus/StatusCode" tag

	#@Functional @Regression 
	#Scenario Outline: TC03_VerifyMobileNumberDataTypeValidation #To verify Send SMS Method with Invalid Mobile Number Data Type or Format
	#    Given I create "SendSMS" WS request with "TC03_VerifyMobileNumberDataTypeValidation" test data and save request as "Req_SENDSMS_TC03.xml" file 
	#	And I update "//SendSMS/messages/SMSMessage/MobileNumber" tag in "Req_SENDSMS_TC03.xml" file with <InvalidMobileNo> 
	#	Then I post "Req_SENDSMS_TC03.xml" request to "SendSMS" WS method and save response as "Res_SENDSMS_TC03.xml" file 
	#	Then I verify If "300" exists in "Res_SENDSMS_TC03.xml" response in "//SendSMSResponse/SendSMSResult/MessageStatus/StatusCode" tag 
	#	Then I verify If "3008" exists in "Res_SENDSMS_TC03.xml" response in "//SendSMSResponse/SendSMSResult/MessageStatus/StatusDescription" tag 
	#	
	#	Examples: 
	#		| InvalidMobileNo |
	#		|                 |
	#		| 809$535335      |
	#		| 1.80953535      |
	#		| 80ABC53535      |
	#		| $%%^$&&$*^&     |
	#		| abc8343         |
	#		| 8095 35335      |
	#		| 809             |
