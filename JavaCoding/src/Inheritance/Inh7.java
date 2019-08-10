package Inheritance;

class Parentt {
	void m1(){
		System.out.println("Method1");
	}
	void m2(){
		System.out.println("Method2");
	}
}

class Inh7 extends Parentt{
	void m1(){
		System.out.println("ChildMethod1");
	}
	void m3(){
		System.out.println("ChildMethod3");
	}
	
	public static void main(String[] args){
		Parentt ii= new Inh7();
		ii.m1();
		Inh7 ch = (Inh7)ii;
		ch.m1();
		ch.m2();
		ch.m3();
		ii.m2();
	}
}