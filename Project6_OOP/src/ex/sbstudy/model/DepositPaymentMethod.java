package ex.sbstudy.model;

public class DepositPaymentMethod implements PaymentMethod {

	private SavingsAccount savingsAccount;
	
	public DepositPaymentMethod(SavingsAccount savingsAccount) {
		this.savingsAccount = savingsAccount;
	}
	
	public void pay(int amount) {
		savingsAccount.receive(amount);
	}
}
