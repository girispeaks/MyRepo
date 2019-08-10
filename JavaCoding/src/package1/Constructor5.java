package package1;

public class Constructor5 {
	//Calling one constructor inside another
	//A constructor can call only one constructor
	
	Constructor5(){
		this(10);
		System.out.println("0-args");
	}
	
	Constructor5(int a){
		this(10,20);
		System.out.println("1-arg");
	}
	Constructor5(int b, int c){
		System.out.println("2-args");
	}
	public static void main(String[] args) {
		Constructor5 cr=new Constructor5();

	}

}
