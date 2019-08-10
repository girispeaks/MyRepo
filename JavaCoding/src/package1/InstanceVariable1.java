package package1;

public class InstanceVariable1 {
	int i=100;
	char ch='c';

	public static void main(String[] args) {
		// TO access instance variable in static method then we need to create the object of class
		InstanceVariable1 iv=new InstanceVariable1();
		System.out.println("Value of i is "+iv.i);
		System.out.println("Value of ch is "+iv.ch);
	}

}
