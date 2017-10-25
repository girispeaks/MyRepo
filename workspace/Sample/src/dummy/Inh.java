package dummy;

class Inheritence {
	public void caseA(){
		System.out.println("Parent CaseA");
	}
}

class Inh2 extends Inheritence{

	public void caseA(){
		System.out.println("Child CaseA");
	}
	
	public void caseB(){
		System.out.println("CaseB");
	}
}

public class Inh extends Inh2{
	
	public static void main(String[] args){
		Inheritence obj=new Inh2();
		obj.caseA();
	}
	
}
