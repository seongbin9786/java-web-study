package ex.sbstudy.model;

public class SavingsAccount {

	private int balance = 0;

	public SavingsAccount() {}
	
	public SavingsAccount(int balance) {
		this.balance = balance;
	}
	
	public void receive(int amount) {
		balance += amount;
	}
	
	public int getBalance() {
		return balance;
	}
}
