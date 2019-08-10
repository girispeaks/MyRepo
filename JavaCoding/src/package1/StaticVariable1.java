package package1;

public class StaticVariable1 {
	static int a=100;
	static int b=200;

	public static void main(String[] args) {
		// TO access the static variable, class name must be used
		System.out.println("a value is "+StaticVariable1.a);
		System.out.println("b value is "+StaticVariable1.b);
	}

}
