import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleClass {
	
	@Test
	public void simple(){
		System.out.println("Testing");
	}
	
	@BeforeMethod
	public void bmethod(){
		System.out.println("Before method");
	}
	
	@AfterMethod
	public void amethod(){
		System.out.println("After method");
	}
	
	@BeforeTest
	public void btest(){
		System.out.println("Before Test");
	}
	
	@AfterTest
	public void atest(){
		System.out.println("After Test");
	}
	
	@Test
	public void simpleTest(){
		System.out.println("Simple Test");
	}
}
