package Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Parameterize {
	
	@Test(dataProvider="senddata")
	public void testparameter(String username, String Pwd, String City){
		System.out.println(username+ "----"+ Pwd +"-----"+City );
	}
	
	
	@DataProvider
	public Object[][] senddata(){
		Object[][] data = new Object[2][3];
		data[0][0]="Username1";
		data[0][1]="Pwd1";
		data[0][2]="City1";
		
		data[1][0]="Username2";
		data[1][1]="Pwd2";
		data[1][2]="City2";
		
		//data[2][0]="Username3";
		//data[2][1]="Pwd3";
		//data[2][2]="City3";
		return data;
		
	}

}
