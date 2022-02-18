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
		
		System.out.println("아이디:"+user_id);
		System.out.println("비밀번호:"+user_pw);
		System.out.println("주소:"+adress);
		
		
		String data="<html>";
		data+="<style>";
		data+="table{width:100%; border-top:1px solid #444444; border-collapse:collapse;}";
		data+="th,td{border-bottom:1px solid #444444; padding:10px}";
		data+="</style>";
		data+="<body>";
		data+="<table>";
		data+="<tr>";
		data+="<td>아이디:</td><td>"+user_id+"</td>";
		data+="</tr>";
		data+="<tr>";
		data+="<td>패스워드:</td><td>"+user_pw+"</td>";
		data+="</tr>";
		data+="<tr>";
		data+="<td>주소:</td><td>"+adress+"</td>";
		data+="</tr>";
		data+="</table>";
		data+="</body>";
		data+="</html>";
		
		
		out.print(data);
		
	}

}
