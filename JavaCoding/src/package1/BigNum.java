package package1;

public class BigNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num={100,45,68,19,39,88};
		int large=0;
		for(int i=0;i<num.length;i++)
				if(num[i]>large)
					large=num[i];
		
		System.out.println(large);
	}

}
