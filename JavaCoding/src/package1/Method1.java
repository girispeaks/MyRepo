package package1;

public class Method1 {
	//Passing arguments to a method
	void m1(int a, char ch){
		System.out.println("value of a is "+a);
		System.out.println("value of ch is "+ch);
	}
	static void m2(String str, double i){
		System.out.println("value of str is "+str);
		System.out.println("value of i is "+i);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Method1 m=new Method1();
		m.m1(10, 'G');
		Method1.m2("GR", 10.5);
	}

}
