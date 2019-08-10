package Inheritance;

class Parent {
	int x=100;
	int y=200;
}
class Inh2 extends Parent{
	int x=10;
	int y=20;
	
	void m1(int x, int y){
		System.out.println("Addition of local variables "+(x+y));
		System.out.println("Addition of current class variables "+(this.x+this.y));
		System.out.println("Addition of parent class variables "+(super.x+super.y));
	}
	public static void main(String[] st){
		Inh2 c=new Inh2();
		c.m1(1, 2);
	}
}