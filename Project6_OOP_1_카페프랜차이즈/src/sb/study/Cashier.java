package sb.study;

public class Cashier {
	
	private Varista varista;
	private MenuItem currentOrder;
	private Coffee currentCoffee;
	
	public Cashier(Varista varista) {
		this.varista = varista;
	}

	public Coffee order(MenuItem item) {
		currentOrder = item;
		
		currentCoffee = varista.makeCoffee(item);
		
		return currentCoffee;
	}
	
	public MenuItem getCurrentOrder() {
		return currentOrder;
	}

	public Coffee getCurrentCoffee() {
		return currentCoffee;
	}
}
