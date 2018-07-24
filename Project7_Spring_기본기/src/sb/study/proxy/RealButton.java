package sb.study.proxy;

public class RealButton implements ProxyTarget {

	@Override
	public void clickButton() {
		System.out.println("[Button] 버튼 누르지마시라고요");
	}

}
