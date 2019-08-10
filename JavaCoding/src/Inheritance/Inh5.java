package Inheritance;

class P3{
	P3(){
		System.out.println("Parent Const");
	}
}

public class Inh5 extends P3 {
	
	Inh5(){
		System.out.println("Child Const");
	}

	public static void main(String[] args) {
		// even without super key word the parent constructor is called
		Inh5 in=new Inh5();
	}

}
