package sb.study.spring;

public class BeanUser {

	private BeanExample ex;
	
	public void setBeanExample(BeanExample ex) {
		this.ex = ex;
	}
	
	public void doSomething() {
		ex.doSomething();
	}
}
