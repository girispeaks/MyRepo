package Inheritance;

class P4{
	static{
		System.out.println("Parent Static Block");
	}
	{
		System.out.println("Parent Instance Block");
	}
	P4(){
		System.out.println("Parent Constructor");
	}
}

public class Inh6 extends P4{
	static{
		System.out.println("Child Static Block");
	}
	{
		System.out.println("Child Instance Block");
	}
	Inh6(){
		System.out.println("Child Constructor");
	}
	Inh6(int a){
		System.out.println("Child Arg Constructor");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Inh6();
		new Inh6(10);

	}

}
