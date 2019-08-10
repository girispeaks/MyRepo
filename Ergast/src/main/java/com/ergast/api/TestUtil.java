package com.ergast.api;
import org.json.JSONArray;
import org.json.JSONObject;
//Not related to project... jst for practice.
public class TestUtil {
	
	
	public static String getValueByJPath(JSONObject responsejson, String jpath){
		Object obj = responsejson;
		for(String s : jpath.split("/")) 
			if(!s.isEmpty()) 
				if(!(s.contains("[") || s.contains("]")))
					obj = ((JSONObject) obj).get(s);
				else if(s.contains("[") || s.contains("]")){
					obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replace("]", "")));
					int i=((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0])).length();
				}
		return obj.toString();
	}
	
	public static String getValueByJPath1(JSONObject responsejson, String jpath){
		JSONObject obj = responsejson;
		Object str=null;
		JSONArray arr=null;
		for(String s : jpath.split("/")) 
			if(!s.isEmpty()) 
				if(!(s.contains("[") || s.contains("]")))
				obj=	(JSONObject) obj.get(s);
				//obj=	((JSONObject) obj).get(s);
					
				else if(s.contains("[") || s.contains("]")){
					str = ((JSONArray) obj.get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replace("]", "")));
					obj=((JSONObject) obj.get(s.split("\\[")[0]));
				}
		return str.toString();
	}
	
}