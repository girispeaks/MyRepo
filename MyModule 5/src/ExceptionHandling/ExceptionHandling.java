package ExceptionHandling;

public class ExceptionHandling {
	

	public static void main(String[] args) {
		int i;
		try{
			i=8/0;
		}catch(Exception e){
			System.out.println("Error" + e.getMessage());
			e.printStackTrace();
		}

	}

}
