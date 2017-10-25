package com.testng.tests1;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test1 {
	
/*	@BeforeTest(alwaysRun=true)
	public void beforeTest(){
		System.out.println("Before Test in Test1 class");
	}
	*/
	@BeforeClass(alwaysRun=true)
	public void beforeClass(){
		System.out.println("Before class in Test1 class");
	}

	@Test(groups={"regression"})
	public void case1(){
		System.out.println("case1");
	}
	
	@Test(groups={"functional"})
	public void case2(){
		System.out.println("case2");
	}
	
	@Test (groups={"regression"})
	public void case3(){
		System.out.println("case3");
	}
	
	@Test(invocationCount=5,description="running 5 times")
	public void caseA(){
		System.out.println("caseA");
	}
}
