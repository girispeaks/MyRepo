package package1;

public class Constructor2 {
	//User defined constructor
	//0-args constructor
	Constructor2(){
		System.out.println("0-args constructor");
	}
	//parameterized constructor
	Constructor2(int a){
		System.out.println("1-arg constructor");
	}
	void m1(){
		System.out.println("Method1");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Constructor2 ct2=new Constructor2();
		Constructor2 ct3=new Constructor2(10);
		ct2.m1();
		ct3.m1();
	}

}
