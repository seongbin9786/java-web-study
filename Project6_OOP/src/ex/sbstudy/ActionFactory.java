package ex.sbstudy;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ex.sbstudy.controller.SimpleGETAction;

public class ActionFactory {
	
	private static Map<String, Action> actions = new HashMap<>();
	
	// Properties로 설정할 수도 있다.
	static {
		actions.put("GET/index.do", new SimpleGETAction("/index"));
		actions.put("GET/error.do", new SimpleGETAction("/error"));
	}
	
	public static Action getAction(HttpServletRequest req) {
		String method = req.getMethod();
		String path = req.getRequestURI().toString();
		
		return actions.get(method + path);
	}
}
