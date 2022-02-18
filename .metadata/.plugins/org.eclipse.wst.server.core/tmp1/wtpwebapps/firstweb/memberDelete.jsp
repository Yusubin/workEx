<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="firstweb.DataBase"%>
<%
	//---- parameter로 삭제할 유저 이름을 가져오는 경우
	//request.setCharacterEncoding("utf-8");
	/*회원 삭제 기능만들기*/
	String m_idx      = request.getParameter("m_idx");
	//---- parameter로 삭제할 유저 이름을 가져오는 경우
	//String m_name     = request.getParameter("m_name");
	//---- parameter로 삭제할 유저 이름을 가져오지 않는 경우
	String m_name     = "";

	System.out.println("m_idx:"+m_idx);
	System.out.println("m_name:"+m_name);	
	
	DataBase database = new DataBase();
	Connection con = null;           // database 연결을 위한 객체
	ResultSet rs   = null;           // SQL을 실행하고 결과를 받기 위한 객체
	PreparedStatement pstmt  = null; // SQL 문을 서버로 보내기 위한 객체
	con = database.getConnection();
	
	//---- 데이타를 얻어 오는 쿼리
	String query = "SELECT m_name FROM member WHERE m_idx = ?";
	pstmt = con.prepareStatement(query);
	pstmt.setInt(1, Integer.parseInt(m_idx));
	
	rs = pstmt.executeQuery();
	if(rs.next()){
		m_name = rs.getString("m_name");
	}
	//---- 데이타를 얻어 오는 쿼리
	
	rs.close();
	pstmt.close();
	
	//---- 데이타를 삭제하는 쿼리
	query = "DELETE FROM member WHERE m_idx = ?";
	pstmt = con.prepareStatement(query);
	pstmt.setInt(1, Integer.parseInt(m_idx));
	
	pstmt.executeUpdate();
	//---- 데이타를 삭제하는 쿼리
	
	pstmt.close();
	
	//---- 커넥션 정리
	con.close();
%>
<script>
alert('<%=m_name%> 회원이 삭제되었습니다.');
location = "memberList.jsp";
</script>