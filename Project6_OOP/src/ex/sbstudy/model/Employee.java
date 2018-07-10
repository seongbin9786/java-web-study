package ex.sbstudy.model;

public class Employee {

	/*
		Composition으로 OCP 구현
	*/
	private PaymentMethod paymentMethod;
	private PayType payType;
	private PayDay payDay;
	
	public Employee(PaymentMethod paymentMethod, PayType payType, PayDay payDay) {
		this.paymentMethod = paymentMethod;
		this.payType = payType;
		this.payDay = payDay;
	}

	public PayType getPayType() {
		return payType;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}
	
	public boolean isPayDay() {
		return payDay.isPayday();
	}

	public int getCashToBePaidForNextPayday() {
		return payType.getCashToBePaidForNextPayday();
	}
	
	public void pay() {
		int amount = payType.getCashToBePaidForNextPayday();
		payType.emptyAllowance();
		paymentMethod.pay(amount);
	}
}
