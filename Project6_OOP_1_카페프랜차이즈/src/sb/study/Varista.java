package sb.study;

public class Varista {

	public Coffee makeCoffee(MenuItem item) {
		return new Coffee(item.getName());
	}
}
