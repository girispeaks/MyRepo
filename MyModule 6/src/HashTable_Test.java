import java.util.Hashtable;

public class HashTable_Test {

	public static void main(String[] args) {
		Hashtable<String,String> tab1 = new Hashtable<String,String>();
		tab1.put("name1", "Abhi");
		tab1.put("Language","English");
		tab1.put("class", "1");
		
		Hashtable<String,String> tab2 = new Hashtable<String,String>();
		tab2.put("name2", "Adhvi");
		tab2.put("Language","English");
		tab2.put("class", "UKG");
		
		Hashtable<String, Hashtable<String,String>> tab = new Hashtable<String, Hashtable<String,String>>();
		tab.put("name", tab1);
		tab.put("language", tab2);
		System.out.println(tab.get("name").get("name1"));
		System.out.println(tab.get("language").get("name2"));

	}

}
