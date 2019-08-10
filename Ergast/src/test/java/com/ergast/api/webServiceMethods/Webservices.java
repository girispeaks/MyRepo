package com.ergast.api.webServiceMethods;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class Webservices {
	
	public static Response getService(String uRI){
		RequestSpecification restSpecification=RestAssured.given();
		restSpecification.contentType(ContentType.JSON);
		Response response=restSpecification.given().get(uRI);
		return response;
	}
	//path parameter - https://jsonplaceholder.typicode.com/posts/{Id}
	public static Response getServicebyPath(String uRI, String id){
		RequestSpecification restSpecification=RestAssured.given();
		restSpecification.contentType(ContentType.JSON);
		Response response=restSpecification.given().pathParam("Id", id).get(uRI);
		return response;
	}
		
	//query parameter
	public static Response getCommentbyQuery(String uRI, String id){
		RequestSpecification restSpecification=RestAssured.given();
		restSpecification.contentType(ContentType.JSON);
		Response response=restSpecification.given().queryParam("postId", id).queryParam("id", "2").get(uRI);
		return response;
	}
	
	//query parameter
		public static Response getPostbyQuery(String uRI, String id){
			RequestSpecification restSpecification=RestAssured.given();
			restSpecification.contentType(ContentType.JSON);
			Response response=restSpecification.given().queryParam("userId", id).get(uRI);
			return response;
		}
	
	public static Response putPostService(String uRI, String jsonBody, String id){
		RequestSpecification restSpecification=RestAssured.given().body(jsonBody);
		restSpecification.contentType(ContentType.JSON);
		restSpecification.headers("Accept", "application/xml");
		Response response=restSpecification.given().pathParam("Id", id).put(uRI);	
		return response;
		//.header("Name", "content-type").
	}
	
	public static Response postPostService(String uRI, String jsonBody){
		RequestSpecification requestSpecification=RestAssured.given().body(jsonBody);
		requestSpecification.contentType(ContentType.JSON);//contentType(ContentType.XML);
		Response response=requestSpecification.post(uRI);
		return response;
	}
	
	public static Response deleteService(String uRI, String jsonBody, String id){
		RequestSpecification restSpecification=RestAssured.given().body(jsonBody);
		restSpecification.contentType(ContentType.JSON);
		Response response=restSpecification.given().pathParam("Id", id).delete(uRI);
		return response;
	}
}
