package package1;

import java.util.ArrayList;

public class RemDupStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="Seleeeiinunium";
		String str1="";
		ArrayList<Character> list=new ArrayList<Character>();
		for(int i=0;i<str.length();i++)
			if(!list.contains(str.charAt(i))){
				list.add(str.charAt(i));
				str1=str1.concat(str1.valueOf(str.charAt(i)));
			}
		System.out.println(str1);
		}
}
