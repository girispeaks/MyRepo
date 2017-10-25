package com.testng.tests1;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test2 {
	@BeforeTest(alwaysRun=true)
	public void beforeTest(){
		System.out.println("Before Test in Test2 class");
	}
	
	@BeforeClass(alwaysRun=true)
	public void beforeClass(){
		System.out.println("Before class in Test2 class");
	}

	@Test(groups={"regression"})
	public void case4(){
		System.out.println("case4");
	}
	
	@Test(groups={"functional"})
	public void case5(){
		System.out.println("case5");
	}
	
	@Test (groups={"regression"})
	public void case6(){
		System.out.println("case6");
	}
}
