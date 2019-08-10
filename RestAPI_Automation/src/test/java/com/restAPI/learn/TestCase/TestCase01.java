package com.restAPI.learn.TestCase;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.restAPI.learn.PojoClass.project1.Address_components;
import com.restAPI.learn.PojoClass.project1.Geometry;
import com.restAPI.learn.PojoClass.project1.LatLng;
import com.restAPI.learn.PojoClass.project1.Results;
import com.restAPI.learn.Util.EndPointUrl;
import com.restAPI.learn.Util.Url;
import com.restAPI.learn.WebServicesMethods.Webservices;

public class TestCase01 {

	
@Test
public void getLatLon(){
	//Gson gson = new GsonBuilder().create();
	//LatLng latlng;
	RestAssured.baseURI="https://reqres.in";
	//RestAssured.basePath="https://httpbin.org/get";
	//Response response=Webservices.get(EndPointUrl.GET_LAT_LNG.completeUri());
	Response response=Webservices.get("/api/users");
	//"param","Hyderabad"
/*	latlng=gson.fromJson(response.getBody().asString(), LatLng.class);
	Results[] result=latlng.getResults();
	Geometry geometry=result[0].getGeometry();
	Address_components[] address=result[0].getAddress_components();
	System.out.println(address[0].getLong_name());
	System.out.println(address[1].getTypes()[0]);
	System.out.println(geometry.getLocation_type());*/
	System.out.println(response.headers());
	System.out.println("------------");
	System.out.println(response.body().asString());
	//System.out.println(response.asString());
	//System.out.println(response.statusLine());
	//System.out.println(response.contentType());
	//System.out.println(response.toString());
}
}
