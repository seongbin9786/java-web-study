package sb.study;

public class Customer {

	private Menu menu;
	private MenuItem chosenMenuItem;
	private Coffee receivedCoffee;
	
	public Customer(Menu menu) {
		this.menu = menu;
	}

	public void chooseCoffee(String coffeeName) {
		chosenMenuItem = menu.findByName(coffeeName);
	}

	public void orderCoffee(Cashier cashier) {
		receivedCoffee = cashier.order(chosenMenuItem);
	}

	public MenuItem getChosenMenuItem() {
		return chosenMenuItem;
	}
	
	public Coffee getReceivedCoffee() {
		return receivedCoffee;
	}
}
