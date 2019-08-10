package package1;

public class Method6 {
	//returning an object reference of different in a method
	Method5 metobj(){
		Method5 mth5=new Method5();
		return mth5;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Method6 mt=new Method6();
		Method5 m=mt.metobj();
		int i=m.sum1(200, 300);
		float f=m.sum2(100.2f, 200.3f);
		System.out.println("Sum of integer "+i);
		System.out.println("Sum of float "+f);

	}

}
