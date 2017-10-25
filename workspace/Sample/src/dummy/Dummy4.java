package dummy;

public class Dummy4 {

	public static void main(String[] args) {
		String str1="MalayalaM";
		//Without built in method
		String str2="";		
		System.out.println(str1.length());
		for(int i=str1.length()-1;i>=0;i--)
			str2=str2+str1.charAt(i);
		System.out.println(str2);
		//Using built in method
		StringBuffer str3 = new StringBuffer(str1);
		StringBuffer str4=str3.reverse();
		System.out.println(str4);
	}
}
