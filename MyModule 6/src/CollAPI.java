import java.util.ArrayList;
import java.util.Hashtable;

public class CollAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int i;
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("name1");
		list.add("name2");
		list.add("name3");
		
		System.out.println(list.get(1));
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		
		/**************************** Hashtable***************************/
		
		Hashtable<String, String> hash = new Hashtable<String, String>();
		hash.put("Name", "Girish");
		hash.put("Place", "Bangalore");
		hash.put("Job", "IT");
		
		System.out.println(hash.get("Place"));
	}
}
/**************************** Hashtable***************************/



