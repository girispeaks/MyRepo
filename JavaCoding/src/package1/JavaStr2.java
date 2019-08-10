package package1;

public class JavaStr2 {

	public static void main(String[] args) {
		String str1="Girish";
		StringBuffer strb1= new StringBuffer(str1);//string to stringbuffer
		strb1.reverse();
		
		String str2="Sheela";
		String str3="Girish";
		Boolean b = str1.equals(str3);
		//System.out.println(b);
		StringBuffer s1= new StringBuffer("Raja");
		StringBuffer s2= new StringBuffer("Raja");
		String strg1 = new String(s2);//stringbuffer to string
		String strg2 = new String(s1);//stringbuffer to string
		System.out.println(strg1.equals(strg2));
		
		
		Boolean bb=s1.equals(s2);
		//System.out.println(bb);
		//System.out.println(s1.reverse());

	}

}
