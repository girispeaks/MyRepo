package dummy;

public class Dummy6 {
	public static void main(String[] args) {
		//using temp variable
		int a=5;
		int b=4;
		int temp=0;
		temp=a;
		a=b;
		b=temp;
		//without using temp variable
		a=a+b;
		b=a-b;
		a=a-b;		
		System.out.println("a is "+a+" b is "+b);				
	}
}
