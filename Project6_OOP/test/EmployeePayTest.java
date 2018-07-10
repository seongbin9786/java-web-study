import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.DayOfWeek;
import java.util.Calendar;

import org.junit.jupiter.api.Test;

import ex.sbstudy.model.DepositPaymentMethod;
import ex.sbstudy.model.Employee;
import ex.sbstudy.model.PayDay;
import ex.sbstudy.model.PayType;
import ex.sbstudy.model.PaymentMethod;
import ex.sbstudy.model.SalariedPayType;
import ex.sbstudy.model.SavingsAccount;
import ex.sbstudy.model.SpecificPayday;

class EmployeePayTest {

	@Test
	void testPayDayIsEverySpecificDay() {
		// 임금지급일 지정
		DayOfWeek currentDayOfWeek = DayOfWeek.of(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1);
		PayDay specificDay = new SpecificPayday(currentDayOfWeek);
		
		// 생성
		Employee e = new Employee(null, null, specificDay);
		
		assertTrue(e.isPayDay());
	}
	
	@Test
	void testSalariedPayType() {
		// 임금제 지정 - 고정 월급제
		int salary = 1000000; // 100만원
		PayType salariedPayType = new SalariedPayType(salary);

		// 생성
		Employee e = new Employee(null, salariedPayType, null);
		
		assertThat(e.getPayType(), instanceOf(SalariedPayType.class));
		assertEquals(salary, e.getCashToBePaidForNextPayday());
	}

	@Test
	void testDepositPaymentMethod() {
		// 임금 지급 방식 지정 - 입금 방식
		SavingsAccount myAccount = new SavingsAccount();
		PaymentMethod byDeposit = new DepositPaymentMethod(myAccount);
		
		// 임금이 얼마인지만 알려줄 PayType의 Mock객체
		PayType mockPayType = new MockPayType(100); // 임금 = 100원
		
		// 생성
		Employee e = new Employee(byDeposit, mockPayType, null);
		
		// 계좌에 입금 하는 방식으로 지불
		int toPay = e.getCashToBePaidForNextPayday();
		e.pay();
		
		assertThat(e.getPaymentMethod(), instanceOf(DepositPaymentMethod.class));
		assertEquals(myAccount.getBalance(), toPay);
	}
}
