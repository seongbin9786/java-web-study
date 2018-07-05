package ex.sbstudy;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Action action = ActionFactory.getAction(request);
		String view;
		try {
			view = action.execute(request, response);
		} catch (Exception e) {
			view = "redirect:/error.do";
		}
		navigate(request, response, view);
	}
	
	private void navigate(HttpServletRequest request, HttpServletResponse response, String view) throws IOException, ServletException {
		final String REDIRECT = "redirect:";
		
		if (view.startsWith(REDIRECT)) {
			System.out.println("REDIRECTING...TO=" + view);
			response.sendRedirect(view.split(REDIRECT)[1]);
		} else {
			System.out.println("FORWADING...TO=" + view);
			request.getRequestDispatcher("/WEB-INF/" + view + ".jsp").forward(request, response);
		}
	}
}
