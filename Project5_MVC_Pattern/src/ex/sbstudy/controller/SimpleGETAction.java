package ex.sbstudy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex.sbstudy.Action;

public class SimpleGETAction implements Action {

	private String viewName;
	
	public SimpleGETAction(String viewName) {
		this.viewName = viewName;
	}
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		return viewName;
	}

}
