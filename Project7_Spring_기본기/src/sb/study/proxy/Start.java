package sb.study.proxy;

import org.junit.jupiter.api.Test;

class Start {

	/*
		1. ProxyTarget은 RealButton을 인터페이스 추출한 것임
		2. RealButton은 ProxyTarget을 구현함
		3. ButtonClickLogger는 RealButton을 대상으로 하는 Proxy 객체임
		4. ButtonClickLogger는 RealButton과 마찬가지로 ProxyTarget을 구현하므로,
		   동일한 인터페이스를 가짐
		5. 외부에서 ProxyButtonLogger를 호출하면, ButtonClickLogger는 RealButton에게
		   기능을 위임하고, 자신은 추가적인 작업을 수행함
		6. 이번 예시에서 추가적인 작업이란 Logging임
	*/
	@Test
	void test() {
		ProxyTarget realButton = new RealButton();
		ProxyTarget proxyButtonLogger = new ButtonClickLogger(realButton);
		
		for (int i = 0; i < 10; i++)
			proxyButtonLogger.clickButton();
	}
}
