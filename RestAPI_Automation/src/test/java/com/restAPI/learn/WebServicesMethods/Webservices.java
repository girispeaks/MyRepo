package com.restAPI.learn.WebServicesMethods;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class Webservices {
	
	public static Response post(String uri, String stringJSON){
		RequestSpecification requestSpecification=RestAssured.given().body(stringJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response=requestSpecification.post(uri);
		response.getBody().equals("Australia");
		return response;
	}
	
	public static Response get(String uri){
		RequestSpecification requestSpecification=RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		//requestSpecification.accept(ContentType.XML);
		//requestSpecification.header("Content-Type", "application/xml");
		Response response=requestSpecification.contentType(ContentType.JSON).get(uri);
		return response;
	}
	
	public static Response put(String uri, String stringJSON){
		RequestSpecification requestSpecification=RestAssured.given().body(stringJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response=requestSpecification.put(uri);
		return response;
	}
	
	public static Response delete(String uri, String stringJSON){
		RequestSpecification requestSpecification=RestAssured.given().body(stringJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response=requestSpecification.delete(uri);
		return response;
	}
}
