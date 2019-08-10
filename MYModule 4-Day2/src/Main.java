
public class Main {

	public static void main(String[] args) {
		BankRules b=new Citi();
		b.OpenAccount();
		b.TransferMoney();
		b.CloseAccount();
		//BankRules.price=50000000; System will not allow coz this is declared in interface.
		System.out.println(BankRules.price);
		//b.AddBeneficiary(); not possible because its not defined in interface.
		
		Citi c=new Citi();
		c.OpenAccount();
		c.TransferMoney();
		c.CloseAccount();
		c.AddBeneficiary();//This is possible coz an object of class Citi is created and not linked to interface
		System.out.println(Citi.price);
	}

}
