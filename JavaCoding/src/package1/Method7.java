package package1;

public class Method7 {
	//returning current class object in a normal way
	Method7 currMeth(){
		Method7 m7=new Method7();
		System.out.println("Normal way");
		return m7;
	}
	//returning current class object using this keyword
	Method7 currMeth1(){
		System.out.println("'this' way");
		return this;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Method7 m=new Method7();
		Method7 mt1=m.currMeth();
		Method7 mt2=m.currMeth1();
		
	}

}
