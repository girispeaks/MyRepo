package package1;
//Error in program. When any constructor is defined by user then system wont create default constructor
public class Constructor3 {
	
	Constructor3(int a){
		System.out.println("1-arg");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	Constructor3 ct3=new Constructor3();  commented to avoid error in project
		Constructor3 ct4=new Constructor3(10);

	}

}
