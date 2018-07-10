package ex.sbstudy.model;

public class SalariedPayType implements PayType {

	private int salary;
	
	public SalariedPayType(int salary) {
		this.salary = salary;
	}
	
	@Override
	public int getCashToBePaidForNextPayday() {
		return salary;
	}

	@Override
	public void emptyAllowance() {
		// do nothing
	}
}
