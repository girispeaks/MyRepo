package com.reqres.automation.webservicemethods;

import org.json.JSONArray;
import org.json.JSONObject;

public class Util {
	//The entire method basically works on Object type hence assign jobj into obj.
	//There is a function called .get which is present only in the JSONObject class hence we need to type
	//cast Object to JSONObject.
	public static String getValueByJPath(JSONObject jobj, String jpath) throws Exception{
		Object obj=jobj;		
		JSONArray arr=null;
		String[] path=jpath.split("/");
		for(String eachpar: path){
			if(!(eachpar.contains("[")||eachpar.contains("]")))
				//obj=(JSONObject)jobj.get(eachpar);
				obj=((JSONObject) obj).get(eachpar);
			else if(eachpar.contains("[")||eachpar.contains("]")){
				arr=(JSONArray)((JSONObject)obj).get(eachpar.split("\\[")[0]);
				obj=arr.get(Integer.parseInt(eachpar.split("\\[")[1].replace("]","")));				
			}
		}			
		return obj.toString();
	}
	
	public static int totalRecs(JSONObject jobj, String jpath) throws Exception{
		Object obj=jobj;
		JSONArray arr=null;
		String[] path=jpath.split("/");
		for(String eachpar: path){
			if(eachpar.contains("[")||eachpar.contains("]")){
			arr=(JSONArray)((JSONObject)obj).get(eachpar.split("\\[")[0]);
			obj=arr.get(Integer.parseInt(eachpar.split("\\[")[1].replace("]","")));
		}		
	}
		return arr.length();
	}
}
