<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="firstweb.DataBase"%>
<%
request.setCharacterEncoding("utf-8");
Connection con = null;           // database 연결을 위한 객체
PreparedStatement pstmt  = null; // SQL 문을 서버로 보내기 위한 객체

//String url   = "jdbc:mariadb://localhost:3306/mars";
//String user  = "mars";
//String pw    = "p@ss00";
String query = "INSERT INTO member(m_name, m_id, m_pw, m_email, m_phone) VALUES(?,?,?,?,?)";
try {
	//1. JDBC 드라이버 로딩
	//Class.forName("org.postgresql.Driver");
	//Class.forName("org.mariadb.jdbc.Driver");
	
	//2. Connection 생성
	//con = DriverManager.getConnection(url, user, pw);
	DataBase database = new DataBase();
	con = database.getConnection();
	pstmt = con.prepareStatement(query);
	pstmt.setString(1, request.getParameter("m_name"));
	pstmt.setString(2, request.getParameter("m_id"));
	pstmt.setString(3, request.getParameter("m_pw"));
	pstmt.setString(4, request.getParameter("m_email"));
	pstmt.setString(5, request.getParameter("m_phone"));
	pstmt.executeUpdate();
//} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	//e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} finally {
	if(pstmt != null){
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	if(con != null) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
%>
<script>
alert('회원가입되었습니다.');
location = "memberList.jsp";
</script>