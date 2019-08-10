package com.selcukesfw.alm.utils;

import java.util.HashMap;
import java.util.Map;

import com.selcukesfw.utilities.XMLUtils;


public class ALMUtils {


	
//	private static void getTestSetDetails()
//	{
//		ALMRestConnector con = ALMRestConnector.getInstance().init(new HashMap<String, String>(), Constants.HOST, Constants.PORT, Constants.DOMAIN, Constants.PROJECT);
//		ALMLoginLogout login = new ALMLoginLogout();
//		try {
//			login.login(Constants.USERNAME, Constants.PASSWORD);
//		} catch (Exception e1) {
//			System.out.println("Could not login to ALM, Authentication failed. Please verify DOMAIN, PROJECT, USERNAME & PASSWORD in object-config.xml");
//			e1.printStackTrace();
//		}
//		String requestURL = con.buildUrl("qcbin/rest/domains/" + Constants.DOMAIN + "/projects/" + Constants.PROJECT + "/test-instances?query={cycle-id[19302]}");
//		Map<String, String> requestHeaders = new HashMap<String, String>();
//		requestHeaders.put("Accept", "application/xml");
//		String responseStr = null;
//		try {
//			responseStr = con.httpGet(requestURL, null, requestHeaders).toString();
//			System.out.println(responseStr);
//			createTable(responseStr);
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Unexpected error occurred while fetching ALM test instance id. Test Case Id :");
//		}
//		try {
//			login.logout();
//		} catch (Exception e) {
//			System.out.println("Could not logout from ALM after test. This is just a warning, you can ignore");
//			e.printStackTrace();
//		}
//	}
	
//	private static void createTable(String responseXML)
//	{
//		String testid = XMLUtils.getNodeValue(responseXML, "//Field[@Name='test-id']/Value");
//		String status = XMLUtils.getNodeValue(responseXML, "//Field[@Name='status']/Value");
//		System.out.println("testid:"+testid+", status:"+status);
//	}
	
	
//	private static void getTestSetDetails(String testSetID)
//	{
//		///qcbin/rest/domains/DOMAIN_NAME/projects/PROJECT_NAME/test-sets/1
//		ALMRestConnector con = ALMRestConnector.getInstance().init(new HashMap<String, String>(), Constants.HOST, Constants.PORT, Constants.DOMAIN, Constants.PROJECT);
//		ALMLoginLogout login = new ALMLoginLogout();
//		try {
//			login.login(Constants.USERNAME, Constants.PASSWORD);
//		} catch (Exception e1) {
//			System.out.println("Could not login to ALM, Authentication failed. Please verify DOMAIN, PROJECT, USERNAME & PASSWORD in object-config.xml");
//			e1.printStackTrace();
//		}
//		String requirementsUrl = con.buildUrl("qcbin/rest/domains/" + Constants.DOMAIN + "/projects/" + Constants.PROJECT + "/test-sets/19302");
//		Map<String, String> requestHeaders = new HashMap<String, String>();
//		requestHeaders.put("Accept", "application/xml");
//		String responseStr = null;
//		try {
//			responseStr = con.httpGet(requirementsUrl, null, requestHeaders).toString();
//			System.out.println(responseStr);
//		} catch (Exception e) {
//			System.out.println("Unexpected error occurred while fetching ALM test instance id. Test Case Id : " );
//		}
//	}
//	public static void getAssets()
//	{
//		ALMRestConnector con = ALMRestConnector.getInstance().init(new HashMap<String, String>(), Constants.HOST, Constants.PORT, Constants.DOMAIN, Constants.PROJECT);
//		ALMLoginLogout login = new ALMLoginLogout();
//		try {
//			login.login(Constants.USERNAME, Constants.PASSWORD);
//		} catch (Exception e1) {
//			System.out.println("Could not login to ALM, Authentication failed. Please verify DOMAIN, PROJECT, USERNAME & PASSWORD in object-config.xml");
//			e1.printStackTrace();
//		}
//		String requirementsUrl = con.buildUrl("qcbin/rest/domains/" + Constants.DOMAIN + "/projects/" + Constants.PROJECT + "/test-sets/19302/assets-relations/");
//		Map<String, String> requestHeaders = new HashMap<String, String>();
//		requestHeaders.put("Accept", "application/xml");
//		String responseStr = null;
//		try {
//			responseStr = con.httpGet(requirementsUrl, null, requestHeaders).toString();
//			System.out.println(responseStr);
//		} catch (Exception e) {
//			System.out.println("Unexpected error occurred while fetching ALM test instance id. Test Case Id : " );
//		}
//		String testInstanceId = XMLUtils.getNodeValue(responseStr, "//Field[@Name='id']/Value");
//		System.out.println("testInstanceID:" + testInstanceId);
//	}
//
//	public static void getTestSetData()
//	{
////		/qcbin/rest/domains/{domain}/projects/{project}/test-sets/{Test Set ID}
//		ALMRestConnector con = ALMRestConnector.getInstance().init(new HashMap<String, String>(), Constants.HOST, Constants.PORT, Constants.DOMAIN, Constants.PROJECT);
//		ALMLoginLogout login = new ALMLoginLogout();
//		try {
//			login.login(Constants.USERNAME, Constants.PASSWORD);
//		} catch (Exception e1) {
//			System.out.println("Could not login to ALM, Authentication failed. Please verify DOMAIN, PROJECT, USERNAME & PASSWORD in object-config.xml");
//			e1.printStackTrace();
//		}
//		String requestURL = con.buildUrl("qcbin/rest/domains/" + Constants.DOMAIN + "/projects/" + Constants.PROJECT + "/test-sets/19302");
//		Map<String, String> requestHeaders = new HashMap<String, String>();
//		requestHeaders.put("Accept", "application/xml");
//		String responseStr = null;
//		try {
//			responseStr = con.httpGet(requestURL, null, requestHeaders).toString();
//			System.out.println(responseStr);
//		} catch (Exception e) {
//			System.out.println("Unexpected error occurred while fetching ALM test instance id. Test Case Id : " );
//		}
//		String testInstanceId = XMLUtils.getNodeValue(responseStr, "//Field[@Name='id']/Value");
//		System.out.println("testInstanceID:" + testInstanceId);
//	}
	/*
	public static void setTestCaseStatus(String testSetId, String testCaseId, String execResult) {

		ALMRestConnector con = ALMRestConnector.getInstance().init(new HashMap<String, String>(), Constants.HOST, Constants.PORT, Constants.DOMAIN, Constants.PROJECT);
		ALMLoginLogout login = new ALMLoginLogout();
		try {
			login.login(Constants.USERNAME, Constants.PASSWORD);
		} catch (Exception e1) {
			System.out.println("Could not login to ALM, Authentication failed. Please verify DOMAIN, PROJECT, USERNAME & PASSWORD in object-config.xml");
			e1.printStackTrace();
		}
		String requestURL = con.buildUrl("qcbin/rest/domains/" + Constants.DOMAIN + "/projects/" + Constants.PROJECT + "/test-instances?query={cycle-id[" + testSetId + "];test-id[" + testCaseId + "]}");
		Map<String, String> requestHeaders = new HashMap<String, String>();
		requestHeaders.put("Accept", "application/xml");
		String responseStr = null;
		try {
			responseStr = con.httpGet(requestURL, null, requestHeaders).toString();
			System.out.println(responseStr);
		} catch (Exception e) {
			System.out.println("Unexpected error occurred while fetching ALM test instance id. Test Case Id : " + testCaseId);
		}
		String testInstanceId = XMLUtils.getNodeValue(responseStr, "//Field[@Name='id']/Value");
		System.out.println("testInstanceID:" + testInstanceId);

		// Update the test-instance with the new exec status
		requestURL = con.buildUrl("qcbin/rest/domains/" + Constants.DOMAIN + "/projects/" + Constants.PROJECT + "/test-instances/" + testInstanceId);
		requestHeaders.clear();
		requestHeaders.put("Content-Type", "application/xml");
		requestHeaders.put("Accept", "application/xml");
		String str = ("<Entity Type=\"test-instance\"><Fields><Field Name=\"status\"><Value>" + execResult + "</Value></Field></Fields></Entity>");
		responseStr = null;
		try {
			responseStr = con.httpPut(requestURL, str.getBytes(), requestHeaders).toString();
		} catch (Exception e) {
			System.out.println("Unexpected error occurred while updating ALM test case status. Test Case Id : " + testCaseId);
		}
		
		// Log out ALM session
		try {
			login.logout();
		} catch (Exception e) {
			System.out.println("Could not logout from ALM after test. This is just a warning, you can ignore");
			e.printStackTrace();
		}
	}
	

	
//	private static String getTestSetID(String testSetName)
//	{
//		String testSetID = "";
////		String testSetName = "SelCukesALMIntegration 2";
//        ALMRestConnector con =
//                ALMRestConnector.getInstance().init(
//                        new HashMap<String, String>(),
//                        Constants.HOST,
//                        Constants.PORT,
//                        Constants.DOMAIN,
//                        Constants.PROJECT);
//
//        ALMLoginLogout login = new ALMLoginLogout();
//        try {
//			login.login(Constants.USERNAME, Constants.PASSWORD);
//		} catch (Exception e1) {
//			 System.out.println("Could not login to ALM, Authentication failed. Please verify DOMAIN, PROJECT, USERNAME & PASSWORD in object-config.xml");
//			e1.printStackTrace();
//		}
//        System.out.println(testSetName.trim());
//        testSetName = testSetName.replaceAll(" ", "%20");
//        String requirementsUrl = con.buildUrl("qcbin/rest/domains/" + Constants.DOMAIN + "/projects/" + Constants.PROJECT + "/test-sets?query={name['"+testSetName+"']}&fields=id,name");
////        /qcbin/rest/domains/DOMAIN_NAME/projects/PROJECT_NAME/test-instances
//		Map<String, String> requestHeaders = new HashMap<String, String>();
//		requestHeaders.put("Accept", "application/xml");
//		String responseStr = null;
//		try {
//			responseStr = con.httpGet(requirementsUrl, null, requestHeaders).toString();
//			System.out.println(responseStr);
//		} catch (Exception e) {
//			System.out.println("Unexpected error occurred while fetching ALM test case id. Scenario Name : "+testSetName );
//		}
//		testSetID = XMLUtils.getNodeValue(responseStr, "//Field[@Name='id']/Value");
//		System.out.println("testCaseID:"+testSetID);
//        try {
//			login.logout();
//		} catch (Exception e) {
//			System.out.println("Could not logout from ALM after test. This is just a warning, you can ignore");
//			e.printStackTrace();
//		}
//        return testSetID;
//		
//	}
	public static String getTestCaseID(String testCaseName)
	{
		String testCaseID = "";
        ALMRestConnector con =
                ALMRestConnector.getInstance().init(
                        new HashMap<String, String>(),
                        Constants.HOST,
                        Constants.PORT,
                        Constants.DOMAIN,
                        Constants.PROJECT);

        ALMLoginLogout login = new ALMLoginLogout();
        try {
			login.login(Constants.USERNAME, Constants.PASSWORD);
		} catch (Exception e1) {
			 System.out.println("Could not login to ALM, Authentication failed. Please verify DOMAIN, PROJECT, USERNAME & PASSWORD in object-config.xml");
			e1.printStackTrace();
		}
        System.out.println(testCaseName.trim());
        testCaseName = testCaseName.replaceAll(" ", "%20");
        String requirementsUrl = con.buildUrl("qcbin/rest/domains/" + Constants.DOMAIN + "/projects/" + Constants.PROJECT + "/tests?query={name['"+testCaseName+"']}&fields=id,name");
//        /qcbin/rest/domains/DOMAIN_NAME/projects/PROJECT_NAME/test-instances
		Map<String, String> requestHeaders = new HashMap<String, String>();
		requestHeaders.put("Accept", "application/xml");
		String responseStr = null;
		try {
			responseStr = con.httpGet(requirementsUrl, null, requestHeaders).toString();
			System.out.println(responseStr);
		} catch (Exception e) {
			System.out.println("Unexpected error occurred while fetching ALM test case id. Scenario Name : "+testCaseName );
		}
        
		testCaseID = XMLUtils.getNodeValue(responseStr, "//Field[@Name='id']/Value");
		System.out.println("testCaseID:"+testCaseID);
        try {
			login.logout();
		} catch (Exception e) {
			System.out.println("Could not logout from ALM after test. This is just a warning, you can ignore");
			e.printStackTrace();
		}
        
        return testCaseID;
	}*/

}
