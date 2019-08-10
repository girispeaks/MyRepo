package package1;

public class Method2 {
	//Passing object reference as an argument 
	
	void Mtd(Method1 mtd1){
		System.out.println("Calling method from other class");
		mtd1.m1(100, 'R');
		Method1.m2("Girish", 84.4);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Method1 mt1=new Method1();
		Method2 mt2=new Method2();
		mt2.Mtd(mt1);
		
	}

}
