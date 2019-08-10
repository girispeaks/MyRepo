package package1;

public class StaticVariable2 {
	static int i=1000;
	static String st="test";
	
	void m1(){//accessing static variable in non-static(instance) area is done using class name
		System.out.println("i value is "+StaticVariable2.i);
		System.out.println("string value is "+StaticVariable2.st);
	}

	public static void main(String[] args) {
		// TO access non static method in static area
		StaticVariable2 sv2=new StaticVariable2();
		sv2.m1();

	}

}
