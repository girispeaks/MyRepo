
public class Test1 {
	 int total;

	public static void main(String[] args) {
		
		Test2 T = new Test2();
		T.printname();
		Test1 a = new Test1();
		a.total=T.add(4, 6);
		System.out.println("Total of the sum is "+a.total);

	}

}
