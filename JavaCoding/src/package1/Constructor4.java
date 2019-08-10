package package1;

public class Constructor4 {
	int a;
	int b;
	//initializing the instance variables using parameterized constructor
	Constructor4(int a, int b){
		this.a=a;
		this.b=b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Constructor4 cn=new Constructor4(10,20);
		System.out.println("a value is "+cn.a);
		System.out.println("b value is "+cn.b);
		
	}

}
