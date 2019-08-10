package package1;

public class Method5 {
	//Method with return type int and float
	int sum1(int a, int b){
		int c;
		c=a+b;
		return c;
	}
	
	float sum2(float i, float j){
		float k;
		k=i+j;
		return k;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Method5 mt=new Method5();
		int add = mt.sum1(100, 200);
		float x=mt.sum2(10.5f, 20.5f);
		System.out.println("Addition of two integer numbers is "+add);
		System.out.println("Addition of two floating numbers is "+x);
	}

}
