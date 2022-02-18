package project02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void init() throws ServletException{
		System.out.println("init메소드호출");
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doHandler(req,res);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doHandler(req,res);
	}
	
	protected void doHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String user_id =req.getParameter("user_id");
		String user_pw =req.getParameter("user_pw");
		String adress =req.getParameter("adress");
		System.out.println("아이디:"+user_id);
		System.out.println("비밀번호:"+user_pw);
		System.out.println("주소:"+adress);
	}
	public void destroy(){
		System.out.println("destroy메소드호출");
	}
}
