package dummy;

public class Dummy3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		for (int i = 2; i <= n; i++) {
			for (int j = 2; j <= i; j++) {
				if (i == j) {
					System.out.println(i);
					break;
				}
				if (i % j == 0) {
					// System.out.println("Not a Prime number"+i);
					break;
				}

			}
		}
	}
}
