package com.qa.dec01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Collections {
	
	public static void arrList(){
		List<String> arr=new ArrayList<String>();
		arr.add("test1");
		arr.add("test2");
		for(String str:arr)
			System.out.println(str);
		
		System.out.println("----------------------");
		
		for(int i=0;i<arr.size();i++)
			System.out.println(arr.get(i));
	}
	
	public static void hshTable(){
		Hashtable<String, String> tab=new Hashtable<String,String>();
		tab.put("Country", "India");
		tab.put("State", "Karnataka");
		tab.put("City", "Bangalore");
		tab.put("City", "Mysore");
		
		//System.out.println(tab.get("Country"));
		//System.out.println(tab.keySet());
		Set dt=tab.entrySet();
		Iterator<Map.Entry<String, String>> it=dt.iterator();
		while(it.hasNext()){
			
			Map.Entry<String,String> mp=it.next();
			System.out.println(mp.getKey()+"---"+mp.getValue()); 
			
		}
	}
	
	public static void main(String[] args){
		//arrList();
		hshTable();
	}

}
