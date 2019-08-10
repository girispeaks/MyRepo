package com.testng.tests2;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test3 {
	
/*	@BeforeTest(alwaysRun=true)
	public void beforeTest(){
		System.out.println("Before Test in Test1 class");
	}
	*/
	@BeforeClass(alwaysRun=true)
	public void beforeClass(){
		System.out.println("Before class in Test3 class");
	}

	@Test(groups={"regression"})
	public void case7(){
		System.out.println("case7");
	}
	
	@Test(groups={"functional"})
	public void case8(){
		System.out.println("case9");
	}
	
	@Test (groups={"regression"})
	public void case9(){
		System.out.println("case9");
	}
}
