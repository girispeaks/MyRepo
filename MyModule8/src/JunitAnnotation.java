import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
//import org.hamcrest.core_1xx;
public class JunitAnnotation {
	
	@BeforeClass
	public static void testname(){
		System.out.println("MY Name");
	}
	
	
	@Test
	public void testannotation(){
		System.out.println("Learning annotation");
	}
	
	@Ignore
	public void testannotation1(){
		System.out.println("Learning annotation1");
	}
	
	@AfterClass
	public static void testcity(){
		System.out.println("My city");
	}
}
