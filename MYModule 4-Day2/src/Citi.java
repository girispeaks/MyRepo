
public class Citi implements BankRules {

	@Override
	public void OpenAccount() {
		System.out.println("Opening an account");
		
	}

	@Override
	public void TransferMoney() {
		System.out.println("Transfering money");
		
	}

	@Override
	public void CloseAccount() {
		System.out.println("Closing an account");
	}
	
	public void AddBeneficiary(){
		System.out.println("Add Beneficiary");
	}

}
