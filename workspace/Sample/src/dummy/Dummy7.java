package dummy;

public class Dummy7 {

	public static void main(String[] args) {
		int k=0,a=0,b=1,n=50;
		while(k<=n){
			k=a+b;
			System.out.print(k+" ");
			a=b;
			b=k;
		}
	}
}
