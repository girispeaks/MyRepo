package ExceptionHandling;

public class ThrowableException {

	public static void main(String[] args) {
		int i;
			try{
				i=8/0;
			}catch(Throwable t){
				t.printStackTrace();
			}
	}

}
