package ex.sbstudy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex.sbstudy.Action;
import ex.sbstudy.model.UserService;

public class RegisterAction implements Action {

	private UserService userService = UserService.getInstance();
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// POST 처리
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		
		// 회원가입
		boolean worked = userService.register(id, password, name);
		if (!worked)
			return "redirect:/error.do";
		
		// 회원가입 후 메인 페이지로 이동
		return "redirect:/";
	}
}
