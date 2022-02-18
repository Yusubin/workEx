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
		
		session.setMaxInactiveInterval(10);//������ȿ�ð� ����(10���Ŀ� ���ΰ�ħ�ϸ� ������ ���ν��۵ȴ�)
		out.println("���Ǿ��̵�:"+session.getId()+"<br>");
		out.println("���� ���ǻ������ڱ�"+new Date(session.getCreationTime())+"<br>");
		out.println("���� ���ǻ������ڱ�"+new Date(session.getLastAccessedTime())+"<br>");
		out.println("���� ��ȿ�Ⱓ"+session.getMaxInactiveInterval()+"<br>");
		if(session.isNew()) {
			out.println("�� ������ ���۵Ǿ����ϴ�");
		}
		session.invalidate();//���ǻ褸��
	}

}