package package1;

public class Method3 {
	//Calling a method inside a method
	void m1(){
		System.out.println("Method1");
		m2();
	}
	void m2(){
		System.out.println("Method2");
		m3();
	}
	void m3(){
		System.out.println("Method3");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Method3 mtd=new Method3();
		mtd.m1();

	}

}
