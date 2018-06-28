package ex.sbstudy;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ex.sbstudy.actions.ErrorAction;
import ex.sbstudy.actions.IndexAction;

public class ActionFactory {
	
	private static Map<String, Action> actions = new HashMap<>();
	
	static {
		actions.put("GET/index.do", new IndexAction());
		actions.put("GET/error.do", new ErrorAction());
	}
	
	public static Action getAction(HttpServletRequest req) {
		String method = req.getMethod();
		String path = req.getRequestURI().toString();
		System.out.println("method: " + method + " path: " + path);
		
		String destination = method + path;		
		return actions.get(destination);
	}
}
