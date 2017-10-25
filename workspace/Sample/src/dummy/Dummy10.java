package dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class Dummy10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> arr=new ArrayList<String>();
		arr.add("abc");
		arr.add("def");
		arr.add("ghi");
		ArrayList<String> arr1=new ArrayList<String>();
		arr1.add("abc");
		arr1.add("def");
		arr1.add("ghi");
		Boolean value=arr.equals(arr1);
		//System.out.println(value);
		Set<String> st=new HashSet<String>();
		st.add("abc");
		st.add("ghi");
		st.add("def");
		//System.out.println(st);
		Hashtable<String,String> tbl=new Hashtable<String,String>();
		
		HashMap<String,String> hash=new HashMap<String,String>();
		hash.put("city", "bangalore");
		hash.put("name", "Rahul");
		hash.put("text","text");
		//System.out.println(hash.values());
		Set<String> keyst=hash.keySet();
		//System.out.println(keyst);
		for(String str:keyst){
			if(str.equals(hash.get(str)))
				System.out.println(str+"------------"+hash.get(str));
		}
		
		String abc=false?"test":"rest";
		System.out.println(abc);
	}
	

}
