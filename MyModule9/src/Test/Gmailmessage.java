package Test;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Gmailmessage {
	
	@Test
	public void testmessage(){
		System.out.println("Test Message2");
	}
	
	@BeforeTest
	public void testreceive(){
		System.out.println("Test Receive2");
		throw new SkipException("Skiping the test");
	}

}
