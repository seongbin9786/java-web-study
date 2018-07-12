import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sb.study.Cashier;
import sb.study.Coffee;
import sb.study.Customer;
import sb.study.Menu;
import sb.study.MenuItem;
import sb.study.Varista;

class CafeTest {

	private static final String 카페_모카 = "카페 모카";
	private static final String 아메리카노 = "아메리카노";
	private static final String 카페_라떼 = "카페 라떼";

	// 테스트 대상 메뉴 이름
	private String itemList[] = new String[] { 카페_라떼, 아메리카노, 카페_모카 };
	
	// 메뉴 객체
	Menu menu;
	
	@BeforeEach
	void setUp() throws Exception {
		menu = new Menu();
		
		// Menu에 메뉴 등록
		for (String item : itemList) {
			menu.addMenu(new MenuItem(item));
		}
	}

	
	@Test
	void testFindMenuItemFromMenu() {
		// Menu에서 메뉴가 정상적으로 골라지는지 테스트
		MenuItem selected;
		for (String item : itemList) {
			selected = menu.findByName(item);
			
			assertNotNull(selected);
			assertEquals(selected.getName(), item);
		}
	}
	
	@Test
	void testChooseMenu() {
		// 고객은 메뉴를 알아야 함.
		Customer customer = new Customer(menu);
		
		// 카페 라떼를 메뉴에서 조회함
		customer.chooseCoffee(카페_라떼);
		
		assertNotNull(customer.getChosenMenuItem());
		assertEquals(menu.findByName(카페_라떼), customer.getChosenMenuItem());
	}

	@Test
	void testOrderCoffee() {
		Varista varista = new Varista();

		// 캐시어 생성
		Cashier cashier = new Cashier(varista);
		
		// 커피 선택 후 주문
		Customer customer = new Customer(menu);
		customer.chooseCoffee(카페_라떼);
		customer.orderCoffee(cashier);
		
		assertNotNull(cashier.getCurrentOrder());
		assertEquals(cashier.getCurrentOrder(), customer.getChosenMenuItem());
	}
	
	@Test
	void testAskingVarista() {
		// 바리스타 생성
		Varista varista = new Varista();
		
		MenuItem menuItem = new MenuItem(카페_모카);
		Cashier cashier = new Cashier(varista);
		cashier.order(menuItem);
		
		// 바리스타가 주문을 받은 후 캐시어에게 잘 반환했는지 확인
		assertNotNull(cashier.getCurrentCoffee());
		assertEquals(cashier.getCurrentCoffee(), new Coffee(카페_모카));
	}
	
	@Test
	void testReturnCoffee() {
		Varista varista = new Varista();
		Customer customer = new Customer(menu);
		Cashier cashier = new Cashier(varista);

		// 캐시어가 손님에게 반환한 커피가 같아야 함
		customer.chooseCoffee(카페_모카);
		customer.orderCoffee(cashier);
		
		// 손님이 받은 커피와 비교
		assertNotNull(customer.getReceivedCoffee());
		assertEquals(customer.getReceivedCoffee(), new Coffee(카페_모카));		
	}
}
