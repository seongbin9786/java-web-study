package sb.study;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 사용자가 갖고 있는 쿠키를 반환한다.
		request.getCookies();

		// View에 값을 전달할 때 사용한다.
		// View에선 이름으로 해당 Attribute에 접근하고, HTML을 출력하게 된다.
		request.setAttribute("attributeName", "attributeValue, it can be any Object");

		// 이름에 해당하는 attribute를 제거한다.
		request.removeAttribute("attributeName");

		// 이름으로 attribute를 가져온다.
		request.getAttribute("attributeName");

		// 요청에 담긴 헤더 중 매개변수와 동일한 이름을 가진 헤더의 값을 반환한다.
		request.getHeader("headerName");

		// GET의 경우 queryString에 담긴 값, POST의 경우 body에 담긴 값을 반환한다.
		// 이름으로 가져오게 된다.
		request.getParameter("parameterName");

		// QueryString 값을 가져온다.
		// 예: ?type=notice&page=1
		request.getQueryString();

		// 세션 객체를 반환한다.
		// 세션 객체는 세션이 만료되기 전까지 유지된다.
		// 세션 객체를 통해 주로 유저 정보를 저장한다.
		request.getSession();
		
		// ---------------------------------------------------
		
		// 쿠키를 추가한다.
		// 이름, 값 모두 String이어야 한다.
		response.addCookie(new Cookie("name", "value"));
		
		// 헤더를 추가한다.
		response.addHeader("headerName", "value");

		// URL로 리다이렉션 시킬 때 사용된다.
		// 리다이렉션 이후에 작업은 반영되지 않는다.
		response.sendRedirect("http://naver.com");
		
		// 응답 코드를 설정할 때 사용된다.
		response.setStatus(HttpServletResponse.SC_OK);
		
		// append, print, write 등의 메소드를 제공하는
		// PrintWriter 객체를 반환한다.
		// 텍스트 데이터 전용으로, 간단한 스크립트 혹은 값을 반환할 때 사용한다.
		// response.getWriter();
		// getWriter를 사용하는 예시 1
		response.getWriter().append("Served at: ").append(request.getContextPath());
		/*
		 * 예시 코드 2
			out = response1.getWriter();
			out.println("<Script language='JavaScript'>");
			out.println(" alert('" + message + "');");
			out.println("</Script>");
			out.flush();
			out.close(); 
		 */
		
		// 응답을 작성하는 스트림을 반환한다.
		// 주로 파일 전송에서 사용된다.
		//response.getOutputStream();
		/*
		 * 예시 코드 - 파일을 클라이언트로 전송
			File file = new File("파일 경로");
	        byte bytes[] = new byte[(int) file.length()];
	        BufferedInputStream ins = new BufferedInputStream(new FileInputStream(file));
	        BufferedOutputStream outs = new BufferedOutputStream(response.getOutputStream());
	
	        int read = 0;
	        if ((read = ins.read(bytes)) != -1) {
	            outs.write(bytes, 0, read);
	        }
	        outs.flush();
	        outs.close();
	        ins.close();
		 */
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
