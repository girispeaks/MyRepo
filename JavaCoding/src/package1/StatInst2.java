package package1;

public class StatInst2 {
	static int i=100;//memory allocation of static variable happens only once when the class file is loaded into memory
	int j=200;// memory allocation happens each time an object is created.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StatInst2 si2=new StatInst2();
		System.out.println("i value is "+StatInst2.i);
		System.out.println("j value is "+si2.j);
		si2.j=400;
		StatInst2.i=300;
		System.out.println("i value is "+StatInst2.i);
		System.out.println("j value is "+si2.j);
		StatInst2 si=new StatInst2();
		System.out.println("i value is "+StatInst2.i);//updated value
		System.out.println("j value is "+si.j);//old value
		
	}

}
