package ex.sbstudy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex.sbstudy.Action;
import ex.sbstudy.model.User;
import ex.sbstudy.model.UserService;

public class LoginAction implements Action {

	private UserService userService = UserService.getInstance();
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
		// 로그인
		User user = userService.login(id, password);
		if (user == null)
			return "redirect:/error.do";

		req.getSession().setAttribute("user", user);
		
		// 로그인 후 메인 페이지로 이동
		return "redirect:/";
	}
}
