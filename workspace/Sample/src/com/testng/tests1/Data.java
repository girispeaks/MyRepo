package com.testng.tests1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data {
	
	@Test(dataProvider="getData")
	public void testData(String username, String pwd){
		System.out.println("Username is "+username+" and Password is "+pwd);		
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] obj=new Object[2][2];
		obj[0][0]="username1";
		obj[0][1]="password1";
		obj[1][0]="username2";
		obj[1][1]="password2";
		return obj;
	}

}
