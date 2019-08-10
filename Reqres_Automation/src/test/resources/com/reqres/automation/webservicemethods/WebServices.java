package com.reqres.automation.webservicemethods;

import java.io.FileInputStream;
import java.util.Properties;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class WebServices {
	
	static FileInputStream ip=null;
	public static Properties prop=null;
	
	public WebServices(){
		RestAssured.baseURI="https://reqres.in";
	}
	
	public static void ini() throws Exception{
		ip=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		prop=new Properties();
		prop.load(ip);
	}
	
	public static Response getUsers(String serviceURI){
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response=requestSpecification.given().get(serviceURI);
		return response;
	}
	
	public static Response postUser(String serviceURI, String jsonBody){
		RequestSpecification requestSpecification=RestAssured.given().body(jsonBody);
		requestSpecification.contentType(ContentType.JSON);
		Response response=requestSpecification.given().post(serviceURI);
		return response;
	}
	
	public static Response putUser(String serviceURI, String jsonBody){
		RequestSpecification requestSpecification=RestAssured.given().body(jsonBody);
		requestSpecification.contentType(ContentType.JSON);
		Response response=requestSpecification.given().put(serviceURI);
		return response;		
	}
	
	public static Response deleteUser(String serviceURI, String jsonBody){
		RequestSpecification requestSpecification=RestAssured.given().body(jsonBody);
		requestSpecification.contentType(ContentType.JSON);
		Response response=requestSpecification.given().delete(serviceURI);
		return response;
	}

}
