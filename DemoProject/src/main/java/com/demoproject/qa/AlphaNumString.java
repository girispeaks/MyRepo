package com.demoproject.qa;

import java.util.ArrayList;

public class AlphaNumString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0;
		String alpnum="0123456789";
		String str="gfh124ph5anum456ic98gfhfg6dgf454";
		ArrayList<String> arrlst=new ArrayList<String>();
		String temp="";
		for(int i=0;i<str.length();i++){
			if(alpnum.contains(String.valueOf(str.charAt(i)))){
				temp=temp+str.charAt(i);
			}			
			if(!alpnum.contains(String.valueOf(str.charAt(i)))&temp!=""){
				arrlst.add(temp);
				temp="";
			}		
		}
		//To add the last digit if the string ends with digits
		arrlst.add(temp);
		
		for(String s:arrlst){
			System.out.println(s);
			sum=sum+Integer.parseInt(s);
		}
		
		System.out.println("Addition of all "+sum);
	}
}

