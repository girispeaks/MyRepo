package com.api.webservice;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class APIMethods {
	/*this method is to check if the particular service is up and running.
	 * Response looks as below which can be used to validate the health of service.
	 * Content-Length --> 178
	 * Content-Type --> application/json;charset=UFT-8
	 * Date --> Sat, 24Jan 2017 19:38:23 GMT
	*/
	public static Response statusURI(String URL){
		RequestSpecification reqsp=RestAssured.given();
		reqsp.contentType(ContentType.JSON);
		reqsp.accept(ContentType.JSON);
		Response response=reqsp.given().head(URL);
		return response;
	}
	
	public static Response getUsers(String URL, String qParam){
		RequestSpecification reqsp=RestAssured.given();
		reqsp.contentType(ContentType.JSON);
		reqsp.accept(ContentType.JSON);
		Response response=reqsp.given().queryParam("page", qParam).get(URL);
		return response;
	}
	
	public static Response postUser(String URL, String body){
		//System.out.println(URL);
		RequestSpecification reqsp=RestAssured.given().body(body);
		reqsp.contentType(ContentType.JSON);
		reqsp.accept(ContentType.JSON);
		Response response=reqsp.given().post(URL);
		return response;
		
	}

}
