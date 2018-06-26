package ex.sbstudy.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex.sbstudy.Action;

public class IndexAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		return "index";
	}

}
