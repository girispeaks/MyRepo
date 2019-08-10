package dummyPOJO;

import java.util.ArrayList;
import java.util.List;

public class ReadData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example exm=new Example();
		
		List<Datum> data=new ArrayList<Datum>();
		Datum d1=new Datum();
		d1.setId(3);
		d1.setAvatar("avatar");
		d1.setFirstName("Rakesh");
		d1.setLastName("Kumar");
		data.add(d1);
		exm.setData(data);
		exm.setPage(2);
		System.out.println(exm.getData().get(0).getAvatar());
		
	}

}
