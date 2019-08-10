import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class testAssertion {
	public ErrorCollector errCltr = new ErrorCollector();
	
	@Test
	public void testequals(){
		int i = 100;
		int j = 101;
		System.out.println("A");
		try{
		Assert.assertEquals(i, j);
		}catch(Throwable t){
			System.out.println("Error Encountered");
			errCltr.addError(t);
		}
		System.out.println("B");
	}
	
	@Test
	public void testprint(){
		System.out.println("C");
	}

}
