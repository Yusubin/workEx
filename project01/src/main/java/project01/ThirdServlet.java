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
//		SimpleDateFormat format2 = new SimpleDateFormat ( "yyyy년 MM월dd일 HH시mm분ss초");
//		Date time = new Date();
//		String time1 = format2.format(time);
		
		LocalDateTime now =LocalDateTime.now();
		System.out.println(now+":init 메서드 호출");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
//		SimpleDateFormat format2 = new SimpleDateFormat ( "yyyy년 MM월dd일 HH시mm분ss초");
//		Date time = new Date();
//		String time1 = format2.format(time);
		LocalDateTime now =LocalDateTime.now();
		System.out.println(now+":doGet 메서드 호출");
	}
	
	public void destroy() {
		
//		SimpleDateFormat format2 = new SimpleDateFormat ( "yyyy년 MM월dd일 HH시mm분ss초");
//		Date time = new Date();
//		String time1 = format2.format(time);
		LocalDateTime now =LocalDateTime.now();
		System.out.println(now+":destroty 메서드 호출");
	}
}
