package com.ergast.api.util;

public enum EndPoint {
/*	GET_COUNTRIES("/2017/circuits.json"),
	GET_COUNTRY("circuits/{country}.json"),*/
	GET_POSTS("/posts"),
	//GET_POSTS("/api/users"),
	GET_POST_ID_PATH("/posts/{Id}"),
	GET_COMMENT_POSTID_QUERY("/comments"),
	GET_POST_USERID_QUERY("/posts"),
	POST_POSTS("/posts"),
	PUT_POST("/posts/{Id}"),
	DELETE_POST("/posts/{Id}");
	final String resourcepath;
	
	
	EndPoint(String resourcepath){
		this.resourcepath=resourcepath;
	}
	
	public String endPnt(){
		return resourcepath;
	}
	
	
	/*public static void main(String[] args){
		System.out.println(BaseURL.baseURL+EndPoint.GET_COUNTRIES.endPnt());
	}*/

}
