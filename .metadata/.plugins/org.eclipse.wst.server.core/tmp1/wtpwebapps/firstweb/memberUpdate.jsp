<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="firstweb.DataBase"%>
<%
	request.setCharacterEncoding("utf-8");
	String m_idx      = request.getParameter("m_idx");
	String m_name     = request.getParameter("m_name");
	String m_pw       = request.getParameter("m_pw");
	String m_phone    = request.getParameter("m_phone");
	String m_email    = request.getParameter("m_email");
	
	System.out.println("m_idx:"+m_idx);
	System.out.println("m_name:"+m_name);
	System.out.println("m_pw:"+m_pw);
	System.out.println("m_phone:"+m_phone);
	System.out.println("m_email:"+m_email);
	
	DataBase database = new DataBase();
	Connection con = null;           // database 연결을 위한 객체
	PreparedStatement pstmt  = null; // SQL 문을 서버로 보내기 위한 객체
	String query = "UPDATE member SET m_name = ?, m_pw = ?, m_phone = ?,  m_email = ?,"
			+" m_mdfydate = now() WHERE m_idx = ?";
	con = database.getConnection();
	pstmt = con.prepareStatement(query);
	pstmt.setString(1, m_name);
	pstmt.setString(2, m_pw);
	pstmt.setString(3, m_phone);
	pstmt.setString(4, m_email);
	pstmt.setInt(5, Integer.parseInt(m_idx));
	
	pstmt.executeUpdate();
	
	pstmt.close();
	con.close();
%>
<script>
alert('회원정보가 수정되었습니다.');
location = "memberView.jsp?m_idx=<%=m_idx%>";
</script>