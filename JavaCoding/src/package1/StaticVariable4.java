package package1;

public class StaticVariable4 {
	static int i=1000;
	static void m(){
		System.out.println("Static method");
	}

	public static void main(String[] args) {
		//4 ways to call static variable
		StaticVariable4 sv4=new StaticVariable4();//1- through object which is not recommended
		System.out.println(sv4.i);
		sv4.m();
		System.out.println(i);
		m(); // 2-directly which is also not recommended
		System.out.println(StaticVariable4.i);//3- through class name RECOMMENDED
		StaticVariable4.m();
	}

}
