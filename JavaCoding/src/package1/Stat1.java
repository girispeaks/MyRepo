package package1;

public class Stat1 {
	static{
		System.out.println("Static Block2");
	}
	{
		System.out.println("Instance Block1");
	}
	Stat1(){
		System.out.println("0-arg Constructor");
	}
	static{
		System.out.println("Static Block1");
	}
	Stat1(int a){
		System.out.println("1-arg Constructor");
	}
	{
		System.out.println("Instance Block2");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stat1 st1=new Stat1();
		Stat1 st2=new Stat1(10);
		

	}

}


