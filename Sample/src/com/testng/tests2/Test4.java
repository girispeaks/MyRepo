package com.testng.tests2;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test4 {
	@BeforeTest(alwaysRun=true)
	public void beforeTest(){
		System.out.println("Before Test in Test2 class");
	}
	
	@BeforeClass(alwaysRun=true)
	public void beforeClass(){
		System.out.println("Before class in Test4 class");
	}

	@Test(groups={"regression"})
	public void case10(){
		System.out.println("case4");
	}
	
	@Test(groups={"functional"})
	public void case11(){
		System.out.println("case5");
	}
	
	@Test (groups={"regression"})
	public void case12(){
		System.out.println("case6");
	}
}
