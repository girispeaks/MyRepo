
public class Swap {
	int x;
	int y;
	
	public static void main(String[] arg){
		Swap S=new Swap();
		S.x=10;
		S.y=20;
		Swap1(S.x,S.y);
		System.out.println("Value of X is "+S.x);
		System.out.println("Value of Y is "+S.y);
		Swap1(S);
		System.out.println("Value of X after swap is "+S.x);
		System.out.println("Value of Y after swap is "+S.y);
		
	}
	
	public Swap(){
		System.out.println("Hello");
	}
	public static void Swap1(int a, int b){
		int temp;
		temp=a;
		a=b;
		b=temp;
		//System.out.println("Value of a is "+a);
		//System.out.println("Value of b is "+b);
		
	}
	public static void Swap1(Swap T){
		int tempo;
		tempo=T.x;
		T.x=T.y;
		T.y=tempo;
	}

}
