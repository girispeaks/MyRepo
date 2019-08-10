package package1;

public class Stat2 {
	//calling static block from other class which doesnt have a main method
	static{
		System.out.println("Main static block");
	}
	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("package1.Static1");
		Class.forName("package1.Static2");
	}

}

class Static1{
	static{
		System.out.println("Static Block1");
	}
}

class Static2{
	static{
		System.out.println("Static Block2");
	}
}
