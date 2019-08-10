package Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestGmail {
  @Test
  public void testmessage() {
	  System.out.println("Test message1");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before method1");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After method1");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before Test1");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After Test1");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Before Suite1");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("After Suite1");
  }

}
