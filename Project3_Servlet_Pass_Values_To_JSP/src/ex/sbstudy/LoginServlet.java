package ex.sbstudy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ID 값을 받는다.
		String id = request.getParameter("id");
		
		// ID 값을 attribute로 설정한다.
		request.setAttribute("name", id);
		
		// index.jsp 페이지로 attribute를 전달
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
