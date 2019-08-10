package package1;

public class NumLetStr {

	public static void main(String[] args) {
		// Finding the number of letters and words in a string
		
		String str1="I am learning Java";
		String str2="I love Java";
		str1=str1.replaceAll(" ", "");
		char[] ch=str1.toCharArray();
		System.out.println(ch.length);
		String[] str=str2.split(" ");
		System.out.println(str.length);
	}

}
