package package1;

public class Method4 {
	//Representing Instance method using this keyword
	int a=100;
	String b="Learn Java";
	
	void m1(int a, String b){
		System.out.println("Local variable a = "+a);
		System.out.println("Local variable b = "+b);
		System.out.println("Instance variable a = "+this.a);
		System.out.println("Instance variable b = "+this.b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Method4 mtd=new Method4();
		mtd.m1(200, "Java");

	}

}
