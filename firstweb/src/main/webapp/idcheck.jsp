<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="java.sql.*"%>
<%@ page import="firstweb.DataBase"%>
<%
	String m_id      = request.getParameter("m_id");
	//--------- 회원정보 가져오는 코딩
	DataBase database = new DataBase();
	Connection con = null;           // database 연결을 위한 객체
	PreparedStatement pstmt  = null; // SQL 문을 서버로 보내기 위한 객체
	ResultSet rs   = null;           // SQL을 실행하고 결과를 받기 위한 객체
	String query = "SELECT m_idx FROM member WHERE m_id = ?";
	con = database.getConnection();
	pstmt = con.prepareStatement(query);
	pstmt.setString(1, m_id);
	rs = pstmt.executeQuery();

	if(rs.next()){
		out.print("true");
	}else{
		out.print("false");
	}
%>