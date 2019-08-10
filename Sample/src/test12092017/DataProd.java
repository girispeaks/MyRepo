package test12092017;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProd {
	
	@Test(dataProvider="giveData")
	public static void doLogin(String Username, String pwd){
		
	}
	
	@DataProvider
	public Object[][] giveData(){
		Object[][] obj=new Object[2][2];
		obj[0][0]="user1";
		obj[0][1]="pwd1";
		obj[1][0]="user2";
		obj[1][1]="pwd2";
		
		return obj;
	}

}
