package ex.sbstudy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex.sbstudy.Action;

public class LogoutAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 세션 무효화 (세션 객체 내의 객체들이 사라짐)
		req.getSession().invalidate();
		System.out.println("로그아웃 처리가 완료됨");
		
		// 로그인 후 메인 페이지로 이동
		return "redirect:/";
	}
}
