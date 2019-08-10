package Inheritance;

class P {
	//over-ridden method
	void m1(){
		System.out.println("m1 Parent method");
	}

}

class Inh1 extends P{
	//over-riding method
	void m1(){
		System.out.println("m1 Child method");
	}
	public static void main(String[] args){
		Inh1 c=new Inh1();
		c.m1();
	}
}
