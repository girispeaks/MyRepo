package Inheritance;

class test987 {
	
	static int i=100;
	String str="test";
	public  void getValue(){
		System.out.println("test");
	}

}

public class Inh8 extends test987{
	public  void main(String[] args){
		getValue();
		System.out.println(i);
		System.out.println(str);
	}
	
}
