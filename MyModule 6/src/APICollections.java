import java.util.ArrayList;

public class APICollections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		System.out.println(list.get(2));
		System.out.println(list.size());
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		
		
	}

}
