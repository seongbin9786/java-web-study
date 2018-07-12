import sb.study.PayType;

public class MockPayType implements PayType {
	
	private int income = 0;
	
	public MockPayType(int income) {
		this.income = income;
	}
	
	@Override
	public int getCashToBePaidForNextPayday() {
		return income;
	}

	@Override
	public void emptyAllowance() {
		// do nothing
	}

}
