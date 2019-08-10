import org.testng.Assert;
import org.testng.annotations.Test;

public class testListner {
	
	@Test(priority=1)
	public void userlogin(){
		System.out.println("UserLogin Start");
		try{
		Assert.assertEquals("a", "b");
		}catch(Throwable t){
			System.out.println("Error");
		}
		System.out.println("UserLogin End");
		
	}
	@Test(priority=2)
	public void adminlogin(){
		System.out.println("Admin Login");
		
	}

}
