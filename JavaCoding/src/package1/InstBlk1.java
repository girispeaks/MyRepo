package package1;

public class InstBlk1 {
	//Instance block is executed before constructor and its common to all objects
	//Instance block follows top down approach
	InstBlk1(){
		System.out.println("Constructor");
	}
	{
		System.out.println("Instance block1");
	}
	{
		System.out.println("Instance block2");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InstBlk1 ib=new InstBlk1();
		InstBlk1 ib1=new InstBlk1();

	}

}
