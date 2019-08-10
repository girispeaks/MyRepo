import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class ProvideData {
	
	@DataProvider(name="Dummy_Data")
	public static Object[][] testdata(){
		Object data[][] = new Object[2][3];
		
		data[0][0]="User1";
		data[0][1]="Pwd1";
		data[0][2]="City1";
		data[1][0]="User2";
		data[1][1]="Pwd2";
		data[1][2]="City2";
		
		return data;
		
	}
	@DataProvider(name="Dummy")
	public static Object[][] dummytest(){
		Object data[][] = new Object[2][3];
		
		data[0][0]="U1";
		data[0][1]="P1";
		data[0][2]="C1";
		data[1][0]="U2";
		data[1][1]="P2";
		data[1][2]="C2";
		
		return data;
		
	}


	@DataProvider(name="Same_Name")
	public static Object[][] DiffData(Method m){
		Object data[][] = null;
		if(m.getName().equals("testA")){
			data = new Object[2][2];
			data[0][0]="Firstname1";
			data[0][1]="Lastname1";
			data[1][0]="Firstname2";
			data[1][1]="Lastname2";
		} else if(m.getName().equals("testB")){
			data = new Object[3][3];
			data[0][0]="City1";
			data[0][1]="State1";
			data[0][2]="Ctry1";
			data[1][0]="City2";
			data[1][1]="State2";
			data[1][2]="Ctry2";
			data[2][0]="City3";
			data[2][1]="State3";
			data[2][2]="Ctry3";
		
		}
		return data;
		
	}
}
