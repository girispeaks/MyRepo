package test13092017;

public class StringPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//revString("Automation");
		//charOccString("automation");
		//vowelString("Automation");
		//palin("Malayalam");
		//wordInString("I am learning Automation");
		//primeNum(20);
		fiboSer(10);
	}
	
	public static void revString(String str){
		String revStr="";
		for(int i=str.length()-1;i>=0;i--)
			revStr=revStr+str.charAt(i);
		System.out.println(revStr);
	}
	
	public static void charOccString(String str){
		int cnt=0;
		outerloop:
		for(int i=0;i<str.length();i++){
			cnt=0;
			innerloop:
			for(int j=0;j<str.length();j++){
				if(j<i&&(String.valueOf(str.charAt(i)).toLowerCase().equals(String.valueOf((str.charAt(j))).toLowerCase())))
					break innerloop;
				if(str.charAt(i)==str.charAt(j))
					cnt++;
			}
			if(cnt!=0)			
				System.out.println("The character "+str.charAt(i)+" occurs "+cnt+" times");
		}
	}
	
	public static void vowelString(String str){
		String vowel="aeiouAEIOU";
		int i=0;
		for(i=0;i<str.length();i++)
			if(vowel.contains(String.valueOf(str.charAt(i))))
					System.out.println(str.charAt(i)+" is an vowel");
	}
	
	public static void palin(String str){
		String rev="";
		for(int i=str.length()-1;i>=0;i--)
			rev=rev+str.charAt(i);
		if(rev.equalsIgnoreCase(str))
			System.out.println(str+" is a palindrome");
	}
	
	public static void wordInString(String str){
		String word="learn";
		if(str.contains(word))
			System.out.println(word+" found in "+str);
	}
	
	public static void primeNum(int prm){
		for(int i=2;i<=prm;i++)
			for(int j=2;j<=i;j++){
				if(i==j)
					System.out.println(i+" is a prime number");
				
				if((i%j)==0)
					break;
			}			
	}
	
	public static void fiboSer(int fib){
		int i,j,k;
		i=0;
		k=0;
		j=1;
		int l=0;
		while(l<fib){
			k=i+j;
			System.out.println(k+" ");	
			i=j;
			j=k;
			l++;		
		}
	}
}
