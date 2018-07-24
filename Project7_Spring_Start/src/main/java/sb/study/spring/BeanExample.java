package sb.study.spring;

// Bean이므로 Singleton이어야 함
public class BeanExample {
	
	private int counter = 0;
	private String message = "";
	
	// 생성자로도 Dependency Injection이 된다.
	public BeanExample(String message) {
		this.message = message;
	}
	
	// Dependency Injection이 값으로도 된다.
	// Setter로도 가능하다.
	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	public BeanExample() {
		System.out.println("BeanExample object is created by Spring!");
	}
	
	// ++ 연산은 Thread-safe 하지 않음
	public void doSomething() {
		System.out.println(message + counter++);
	}

}
