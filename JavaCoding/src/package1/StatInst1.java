package package1;
//Combination of static and instance members

public class StatInst1 {
	static int i=100;
	static int j=200;
	int a=1000;
	int b=2000;
	void m1(){
		System.out.println("value of i "+StatInst1.i);
		System.out.println("value of j "+StatInst1.j);
		System.out.println("value of a "+a);
		System.out.println("value of b "+b);
	}
	static void m2(){
		System.out.println("value of i "+StatInst1.i);
		System.out.println("value of j "+StatInst1.j);
		StatInst1 si1=new StatInst1();
		System.out.println("value of a "+si1.a);
		System.out.println("value of b "+si1.b);
	}

	public static void main(String[] args) {
		// calling static method
		StatInst1.m2();
		// calling instance method
		StatInst1 si1=new StatInst1();
		si1.m1();
		

	}

}
