package sb.study.proxy;

public class ButtonClickLogger implements ProxyTarget {

	private ProxyTarget target;
	private int buttonClickCount = 0;
	
	public ButtonClickLogger(ProxyTarget target) {
		this.target = target;
	}
	
	@Override
	public void clickButton() {
		target.clickButton();
		buttonClickCount++;
		System.out.println("[System] 버튼 클릭 횟수: " + buttonClickCount);
	}
}
