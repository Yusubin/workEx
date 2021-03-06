package project05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class sessiontest
 */
@WebServlet("/sess")
public class sessiontest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		HttpSession session=request.getSession();
		
		session.setMaxInactiveInterval(10);//세션유효시간 변경(10초후에 새로고침하면 세션이 새로시작된다)
		out.println("세션아이디:"+session.getId()+"<br>");
		out.println("최초 세션생성시자기"+new Date(session.getCreationTime())+"<br>");
		out.println("최초 세션생성시자기"+new Date(session.getLastAccessedTime())+"<br>");
		out.println("세션 유효기간"+session.getMaxInactiveInterval()+"<br>");
		if(session.isNew()) {
			out.println("새 세션이 시작되었습니다");
		}
		session.invalidate();//세션삭ㅈ베
	}

}
