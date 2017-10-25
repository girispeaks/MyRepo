package com.string1;

import java.util.ArrayList;
import java.util.Set;

public class StringPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(revString("Sample"));
		//occChar("Selenium");
		vowelStr("Selenium");
	}
	
	public static String revString(String str){
		String rev="";
		for(int i=(str.length()-1);i>=0;i--)
			rev=rev+str.charAt(i);
		return rev;
	}
	
	public static void occChar(String str){	
		for(int i=0;i<str.length();i++){
			int count=0;
			for(int j=0;j<str.length();j++){
				if(j<i&(str.charAt(i)==str.charAt(j)))
					break;
				if(str.charAt(i)==str.charAt(j))
					count++;
			}	
			if(count>=1)
				System.out.println(str.charAt(i)+ " occurs "+count+" times");
		}		
	}
	
	public static void vowelStr(String str){
		ArrayList<Character> arr=new ArrayList<Character>();
		String vowel="aeiouAEIOU";
		for(int i=0;i<str.length();i++){
			if(vowel.contains(String.valueOf(str.charAt(i))))
				if(!arr.contains(str.charAt(i)))
				System.out.println(str.charAt(i)+" is an vowel");
				arr.add(str.charAt(i));
		}
	}
	
/*public static void vowelStr1(String str){
		Set<Character> strchar=null;
		String vowel="aeiouAEIOU";
		for(int i=0;i<str.length();i++){
			if(vowel.contains(String.valueOf(str.charAt(i))))
				if(!strchar.contains(str.charAt(i)))
				System.out.println(str.charAt(i)+" is an vowel");
				strchar.add(str.charAt(i));
		}
	}*/
}
