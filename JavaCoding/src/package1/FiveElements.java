package package1;

public class FiveElements {
	static int a;
	static String st;
	int b;
	char ch;
	static{
		a=10;
		st="StaticValue";
		System.out.println("a value is "+FiveElements.a);
		System.out.println("st value is "+FiveElements.st);
	}
	{
		b=20;
		ch='G';
		System.out.println("b value is "+b);
		System.out.println("ch value is "+ch);
	}
	void m1(){
		System.out.println("Instance Method");
	}
	static void m2(){
		System.out.println("Static method");
	}
	FiveElements(){
		System.out.println("0-args");
	}
	FiveElements(int i){
		System.out.println("1-arg");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FiveElements fe1=new FiveElements();
		FiveElements fe2=new FiveElements(200);
		fe1.m1();
		fe2.m1();
		FiveElements.m2();
	}

}
