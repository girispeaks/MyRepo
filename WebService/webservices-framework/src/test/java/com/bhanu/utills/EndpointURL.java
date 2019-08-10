package com.bhanu.utills;

public enum EndpointURL {

	ADD_COUNTRY("/countries/details"),
	UPDATE_COUNTRY("/countries/update/details"),
	GET_COUNTRY_BY_ID("/country/"),
	DELETE_COUNTRY("/country/"),
	GET_COUNTRIES("/countries");
	
	String resourcePath;
	
	EndpointURL(String resourcePath){
		this.resourcePath = resourcePath;
		}
	
	public String getResourcePath() {
		return this.resourcePath;
		}
	//path parameter
	public String getResourcePath(String data, String type) {
		//System.out.println(this.resourcePath);
		String query;
		if(type=="path")
		return this.resourcePath+data;
		else 
			query="?id="+data;
			return this.resourcePath+query;
		}
	
	public static void main(String[] args) {
		System.out.println(EndpointURL.ADD_COUNTRY.getResourcePath());
		
		System.out.println("making full url for Add_country");
		
		String url = URL.fixURL+EndpointURL.ADD_COUNTRY.getResourcePath();
		System.out.println(url);
	}
}
