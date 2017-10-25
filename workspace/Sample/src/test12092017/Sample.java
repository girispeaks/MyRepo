package test12092017;

public class Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Know kn=new Know();
		System.out.println(kn.getClass());
		System.out.println(Know.class);
		
	}

}

class Know{
	public void knowClass(){
		System.out.println("Testing");
	}
}
