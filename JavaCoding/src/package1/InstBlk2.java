package package1;

public class InstBlk2 {
	//initializing instance variable using instance block
	int a;
	{
		a=10;
	}
	InstBlk2(){
		System.out.println("Instance variable value is "+a);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InstBlk2 ib=new InstBlk2();
		//System.out.println("Instance variable value is "+ib.a);

	}

}
