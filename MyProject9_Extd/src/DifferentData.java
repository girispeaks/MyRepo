import org.testng.annotations.Test;

public class DifferentData {
	//multiple test cases, different test data, same dataprovider
	
	@Test(priority=1,dataProviderClass=ProvideData.class,dataProvider="Same_Name")
	public void testA(String FirstName,String LastName){
		System.out.println("Print A");
	}

	@Test(priority=2,dataProviderClass=ProvideData.class,dataProvider="Same_Name")
	public void testB(String City,String State,String Country){
		System.out.println("Print B");
	}
}
