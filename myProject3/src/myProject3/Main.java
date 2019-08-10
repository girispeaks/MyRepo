package myProject3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Bank b = new Citi();
		b.atm();
		b.withdraw();
		System.out.println(Bank.i);

	}

}
