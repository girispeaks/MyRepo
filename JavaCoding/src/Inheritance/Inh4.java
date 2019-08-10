package Inheritance;

class P2{
	P2(){
		System.out.println("Parent Constructor");
	}
}

public class Inh4 extends P2{
	
	Inh4(){
		//super();
		System.out.println("Child Constructor");
	}
	Inh4(int a){
		this();
		System.out.println("Child arg Constructor");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Inh4 i=new Inh4(10);
	}

}
