package package1;

public class JavaStr1 {

	public static void main(String[] args) {
		String str1="Girish";
		String str2 = new String("Girish");
		//str2.concat(new String(sb2));
		//System.out.println(str1.toString());
		//System.out.println(str2);
		StringBuffer sb1 = new StringBuffer("Sheela");
		StringBuffer sb2 = new StringBuffer("Sheela");
		//System.out.println(sb1.toString());
		//System.out.println(sb2);
		System.out.println(str2.concat(new String(sb2)));
	}

}
