package project02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet2
 */
@WebServlet("/login")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		String user_id =request.getParameter("user_id");
		String user_pw =request.getParameter("user_pw");
		String adress =request.getParameter("adress");
		
		System.out.println("���̵�:"+user_id);
		System.out.println("��й�ȣ:"+user_pw);
		System.out.println("�ּ�:"+adress);
		
		
		String data="<html>";
		data+="<style>";
		data+="table{width:100%; border-top:1px solid #444444; border-collapse:collapse;}";
		data+="th,td{border-bottom:1px solid #444444; padding:10px}";
		data+="</style>";
		data+="<body>";
		data+="<table>";
		data+="<tr>";
		data+="<td>���̵�:</td><td>"+user_id+"</td>";
		data+="</tr>";
		data+="<tr>";
		data+="<td>�н�����:</td><td>"+user_pw+"</td>";
		data+="</tr>";
		data+="<tr>";
		data+="<td>�ּ�:</td><td>"+adress+"</td>";
		data+="</tr>";
		data+="</table>";
		data+="</body>";
		data+="</html>";
		
		
		out.print(data);
		
	}

}