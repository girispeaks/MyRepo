package dummy;

public class Dummy5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1="MalayalaM";
		//Without built in method
		String str2="";		
		System.out.println(str1.length());
		for(int i=str1.length()-1;i>=0;i--)
			str2=str2+str1.charAt(i);
		System.out.println(str2);
		if(str1.equals(str2))
			System.out.println(str1+" is a Palindrom");
	}
}
