package package1;

public class InstanceVariable2 {
	int a=10;
	int b=30;
	void m1(){//accessing instance variable directly inside instance method
		System.out.println("a value "+a);
		System.out.println("b value "+b);
	}
	
	public static void main(String args[]){
		InstanceVariable2 iv2=new InstanceVariable2();
		iv2.m1();//calling instance method through object reference
		
	}

}
