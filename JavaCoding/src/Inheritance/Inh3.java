package Inheritance;

class P1{
	void m1(){
		System.out.println("Parent method");
	}
}
public class Inh3 extends P1{
	void m1(){
		System.out.println("Child method");
	}
	void m2(){
		super.m1();
		this.m1();
		System.out.println("Calling child method");
	}
	public static void main(String[] args){
		Inh3 c=new Inh3();
		c.m2();
	}
}
