package com.ergast.api.testcases;

import org.junit.Test;

import com.ergast.api.util.BaseURL;
import com.ergast.api.util.EndPoint;
import com.ergast.api.webServiceMethods.Webservices;
import com.jayway.restassured.response.Response;

public class Test01 {
	//@Test
	public void getPosts(){
		String completeURL=BaseURL.baseURL+EndPoint.GET_POSTS.endPnt();
		System.out.println(completeURL);
		Response response=Webservices.getService(completeURL);
		System.out.println(response.asString());
	}
	
	@Test
	public void getPostByIdPath(){
		String completeURL=BaseURL.baseURL+EndPoint.GET_POST_ID_PATH.endPnt();
		System.out.println(EndPoint.GET_POST_ID_PATH.endPnt());
		Response response=Webservices.getServicebyPath(completeURL, "1");
		System.out.println(response.asString());
	}
	
	//@Test
	public void getCommentByPostIdQuery(){
		String completeURL=BaseURL.baseURL+EndPoint.GET_COMMENT_POSTID_QUERY.endPnt();
		System.out.println(completeURL);
		Response response=Webservices.getCommentbyQuery(completeURL, "1");
		System.out.println(response.asString());
	}
	
	//@Test
	public void getPostByUserIdQuery(){
		String completeURL=BaseURL.baseURL+EndPoint.GET_POST_USERID_QUERY.endPnt();
		System.out.println();
		Response response=Webservices.getPostbyQuery(completeURL, "1");
		//System.out.println(response.headers().toString());
		//System.out.println(response.getHeader("Content-Type"));
		System.out.println(response.asString());
	}
	
	//@Test
	public void postPostService(){
		String completeURL=BaseURL.baseURL+EndPoint.POST_POSTS.endPnt();
		String body="{\"userId\": 45,\"id\": 567,\"title\": \"sunt\", \"body\": \"quia\"}";
		Response response=Webservices.postPostService(completeURL, body);
		//System.out.println(response.asString());
		System.out.println(response.header("content-type"));
	}
	//@Test
	public void putPostService(){
		String completeURL=BaseURL.baseURL+EndPoint.PUT_POST.endPnt();
		String body="{\"userId\": 1,\"id\": 1,\"title\": \"foo\", \"body\": \"bar\"}";
		Response response=Webservices.putPostService(completeURL, body, "1");
		System.out.println(response.asString());
		//System.out.println(response);
	}
	//@Test
		public void deletePostService(){
			String completeURL=BaseURL.baseURL+EndPoint.PUT_POST.endPnt();
			String body="{\"userId\": 1,\"id\": 1,\"title\": \"foo\", \"body\": \"bar\"}";
			Response response=Webservices.putPostService(completeURL, body, "1");
			System.out.println(response.asString());
		}
	
}
