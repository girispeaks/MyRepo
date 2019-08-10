//Interface is used only for method declaration and variable declaration
//Variable value cannot be changed outside the interface
//Its mandatory to initialize a variable
//Cannot create an object of an interface
//Variables in interface is always static



public interface BankRules {
	int price=30000000;
	public void OpenAccount();
	public void TransferMoney();
	public void CloseAccount();
	
}
