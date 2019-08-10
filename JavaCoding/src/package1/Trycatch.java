package package1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class Trycatch {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
		/*String str1="";
		Hashtable<String,String> table=new Hashtable<String,String>();
		table.put("a", "100");
		table.put("b", "200");
		System.out.println(table.get("a"));*/
		/*ArrayList<String> str=new ArrayList<String>();
		str.add("test");
		str.add("selenium");
		for(String str2:str)
			System.out.println(str2);
		Collections.sort(str);
		System.out.println("------------");
		for(String str2:str)
			System.out.println(str2);*/
		/*Iterator<String> i=str.iterator();
		while(i.hasNext()){
			 str1=i.next();
			 System.out.println(str1);
		}
		
		
	}*/
	
	/*public void test(){
		int i=0;
	}
*/
		//String str="Hello";
		//String str2="Hello";
		 //str="Hello1";
		//System.out.println(str+str2);
/*		str=str.concat("Sheela");
		String str1="t";
		System.out.println(str);
		StringBuffer str2=new StringBuffer("abc");
		str2.append("def");
		System.out.println(str2);*/
		/*for(int i=str.length()-1;i>=0;i--)
			str1=str1.concat(String.valueOf(str.charAt(i)));
		System.out.println(str1);
		*/
		int[] num={10,80,24,65,19,79};
		ArrayList<Integer> arr=new ArrayList<Integer>();
		for(int i=0;i<num.length;i++)
		arr.add(num[i]);
		System.out.println(arr.size());
		Collections.sort(arr);
		Collections.reverse(arr);
		for(int nm:arr)
			System.out.println(nm);
	}
}
