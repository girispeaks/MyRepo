import org.testng.annotations.Test;
//import org.testng.annotations.DataProvider;

public class Prioritize {
	
	@Test(priority=1,dataProviderClass=ProvideData.class,dataProvider="Dummy_Data")
	public void case_a (String username, String Pwd, String City){
		System.out.println("Test Case 1");
	}
	
	@Test(priority=2,dataProviderClass=ProvideData.class,dataProvider="Dummy")
	public void case_b(String Name,String Passwd, String Place){
		System.out.println("Test Case 2");
	}

	@Test(priority=3)
	public void case_c(){
		System.out.println("Test Case 3");
	}

}
