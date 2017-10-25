package dummy;

public class DemoString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//fibo(50);
	    //prime(10);
		//palind("Hello");
		//wordsStr("Hello World !");
		//vowels("Hello");
		repChar("Selenium");
	}
	
	public static void prime(int num){
		for(int i=2;i<=num;i++)
			for(int j=2;j<=i;j++){
				if(i==j){
					System.out.println(i);
					break;
				}
				if((i%j)==0)
					break;
					
			}
	}
	
	public static void fibo(int num){
		int a=0;
		int b=1;
		int c=0;
		while(c<num){
			c=a+b;
			System.out.println(c);
			a=b;
			b=c;			
		}
	}
	
	public static void palind(String str){
		String pal="";
		for(int i=str.length()-1;i>=0;i--)
			pal=pal.concat(String.valueOf(str.charAt(i)));
		System.out.println(pal);
	}
	
	public static void wordsStr(String str){
		String[] words=str.split(" ");
		System.out.println(words.length);
	}
	
	public static void vowels(String str){
		String vow="AEIOUaeiou";
		for(int i=0;i<str.length();i++){
			if(vow.contains(String.valueOf(str.charAt(i))))
				System.out.println(str.charAt(i)+" is an vowel");
		}
	}
	
	public static void repChar(String str){
		int j=0;
		for(int i=0;i<str.length();i++){
			int cnt=0;
			for(j=0;j<str.length();j++){
				if(j<i&&(str.charAt(i)==str.charAt(j)))
					break;
				if(str.charAt(i)==str.charAt(j))
					cnt++;

			}			
			if(!(j<i&&(str.charAt(i)==str.charAt(j))))				
			System.out.println("The character "+str.charAt(i)+" occurs "+cnt+" times");
		}
	}
	
}
