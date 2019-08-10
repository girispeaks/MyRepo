package com.inheritence;

import org.testng.annotations.Test;

public class ClassB extends ClassA {
	@Test(priority=1)
	public void testD(){
		testA();
	}
	
	
	@Test(priority=2)
	public void testC(){
		System.out.println("child testC");
		System.out.println(a);
	}
	
	
	
}
