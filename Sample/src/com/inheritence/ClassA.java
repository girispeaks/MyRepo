package com.inheritence;

import org.testng.annotations.Test;

public class ClassA {
	public int a;
	
	public void testA(){
		System.out.println("Parent testA");
		a=10;
		System.out.println(a);
	}
	
	
	public void testB(){
		System.out.println("Parent testB");
		System.out.println(a);
	}
}
