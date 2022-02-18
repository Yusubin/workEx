package project01;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/third")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID=4203167342058536067L;
	
	public void init() throws ServletException{
//		SimpleDateFormat format2 = new SimpleDateFormat ( "yyyy�� MM��dd�� HH��mm��ss��");
//		Date time = new Date();
//		String time1 = format2.format(time);
		
		LocalDateTime now =LocalDateTime.now();
		System.out.println(now+":init �޼��� ȣ��");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
//		SimpleDateFormat format2 = new SimpleDateFormat ( "yyyy�� MM��dd�� HH��mm��ss��");
//		Date time = new Date();
//		String time1 = format2.format(time);
		LocalDateTime now =LocalDateTime.now();
		System.out.println(now+":doGet �޼��� ȣ��");
	}
	
	public void destroy() {
		
//		SimpleDateFormat format2 = new SimpleDateFormat ( "yyyy�� MM��dd�� HH��mm��ss��");
//		Date time = new Date();
//		String time1 = format2.format(time);
		LocalDateTime now =LocalDateTime.now();
		System.out.println(now+":destroty �޼��� ȣ��");
	}
}
