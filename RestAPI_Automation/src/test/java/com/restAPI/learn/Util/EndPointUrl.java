package com.restAPI.learn.Util;

public enum EndPointUrl {
	//GET_COUNTRIES("/Countries/"),
	GET_LAT_LNG("/get");
	//GET_LAT_LNG("maps/api/geocode/json/");
	String resourcePath;
	
	EndPointUrl(String resourcePath){
		this.resourcePath=resourcePath;
	}
	
	public String completeUri(){
		return this.resourcePath;
	}
	


	
	//String type, String data
	public String completeUri(String type, String data){
		String param;
		if(type=="path")
			return this.resourcePath+data;
		else{
			param="?address="+data;
			return this.resourcePath+param;
		}			
	}
	
	public static void main(String[] args){
		System.out.println(Url.fixedUrl+EndPointUrl.GET_LAT_LNG.completeUri("path", "user1"));
		
		
		//System.out.println(Url.fixedUrl+EndPointUrl.GET_LAT_LNG.completeUri("param", "Hyderabad"));
	}
}
