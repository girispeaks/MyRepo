package package1;

public class RevString {

	public static void main(String[] args) {
		// Reverse a string 
		//Method 1
		String str="Hello World";
		StringBuffer str1=new StringBuffer(str);
		str1=str1.reverse();
		str=new String(str1);
		System.out.println(str);
		String str2="";
		//Method 2
		for(int i=str.length()-1;i>=0;i--)
			str2=str2+str.charAt(i);
			//System.out.print(str.charAt(i));
		System.out.println(str2);
	}	
}
