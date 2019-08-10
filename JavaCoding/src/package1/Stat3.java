package package1;
	//static blocks are used to initialize the static variables
public class Stat3 {
	static int i;
	
	static{
		i=100;
	}
	Stat3(){
		System.out.println("i value is "+i);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stat3 st=new Stat3();

	}

}
