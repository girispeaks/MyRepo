package com.inheritence;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClassC extends ClassA {
	@BeforeMethod
	public void test() {
		// TODO Auto-generated method stub
		//ClassA obj=new ClassB();
		testA();
		
		
	}
	
	@Test
	public void testSample(){
		System.out.println(a);
	}

}
