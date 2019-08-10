package com.reqres.automation.testCases;

import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;
import com.reqres.automation.webservicemethods.Util;
import com.reqres.automation.webservicemethods.WebServices;

public class TestGetRequests extends WebServices{
	@BeforeClass
	public void initialize() throws Exception{
		new WebServices();
		ini();
	}
	
	@Test(description="first test")
	public void getService() throws Exception{
		Response resp=getUsers(prop.getProperty("getUsers"));
		JSONObject obj=new JSONObject(resp.asString());
		System.out.println(obj.toString());
		System.out.println(obj.get("data[1].last_name"));
		//System.out.println(Util.getValueByJPath(obj, "data[1]/last_name"));
		/*Assert.assertEquals("Bluth", Util.getValueByJPath(obj, "data[0]/last_name"));
		System.out.println("Total records "+Util.totalRecs(obj, "data[0]/last_name"));*/
	}

}
