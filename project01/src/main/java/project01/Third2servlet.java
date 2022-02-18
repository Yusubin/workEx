package project01;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/third2")
public class Third2servlet  extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException{

		
		LocalDateTime now =LocalDateTime.now();
		System.out.println(now+":init 메서드 호출");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{

		doHandle(req,resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{

		doHandle(req,resp);
	}
	protected void doHandle(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{

		LocalDateTime now =LocalDateTime.now();
		System.out.println(now+": doHandle 메서드 호출");
	}
	public void destroy() {
		LocalDateTime now =LocalDateTime.now();
		System.out.println(now+":destroty 메서드 호출");
	}
}
