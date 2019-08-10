package com.testng.tests2;

public class Str {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="sdfs#$DFG34#$$%&dsd#";
		str=str.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(str);
	}

}
