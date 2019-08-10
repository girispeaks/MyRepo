package package1;

public class StaticVariable3 {
	static void m1(){
		System.out.println("Static method");
	}
	void m2(){
		StaticVariable3.m1();//Calling static method within instance area
	}

	public static void main(String[] args) {
		// Calling static method within static area
		StaticVariable3.m1();
		//calling non static method within static area
		StaticVariable3 sv3=new StaticVariable3();
		sv3.m2();
		

	}

}
