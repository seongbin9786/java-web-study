package ex.sbstudy;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ex.sbstudy.controller.LoginAction;
import ex.sbstudy.controller.LogoutAction;
import ex.sbstudy.controller.RegisterAction;
import ex.sbstudy.controller.SimpleGETAction;

public class ActionFactory {
	
	private static Map<String, Action> actions = new HashMap<>();
	
	// Properties로 설정할 수도 있다.
	static {
		actions.put("GET/index.do", new SimpleGETAction("/index"));
		
		actions.put("GET/login.do", new SimpleGETAction("/login"));
		actions.put("POST/login.do", new LoginAction());

		actions.put("GET/logout.do", new LogoutAction());
		
		actions.put("GET/register.do", new SimpleGETAction("/register"));
		actions.put("POST/register.do", new RegisterAction());
		
		actions.put("GET/error.do", new SimpleGETAction("/error"));
	}
	
	public static Action getAction(HttpServletRequest req) {
		String method = req.getMethod();
		String path = req.getRequestURI().toString();
		
		return actions.get(method + path);
	}
}
