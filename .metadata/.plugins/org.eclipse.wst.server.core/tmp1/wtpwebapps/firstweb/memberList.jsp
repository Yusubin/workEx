<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="firstweb.DataBase"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원목록</title>
</head>
	<style>
        table {
            width: 100%;
            border-top: 1px solid #444444;
            border-collapse: collapse;
        }
        th, td {
            border-bottom: 1px solid #444444;
            padding: 10px;
        }
    </style>
    <script>
    function search(){
    	var frm = document.form;
    	
    	//if(frm.searchValue.value == ''){
    		//alert('검색어를 입력해주세요.');
    		//return;
    	//}
    	
    	frm.submit();
    }
    
    function insert(){
    	location = "member.html";
    }
    </script>
<body>
	<h2>회원목록</h2>
	<%
	Connection con = null;           // database 연결을 위한 객체
	PreparedStatement pstmt  = null; // SQL 문을 서버로 보내기 위한 객체
	ResultSet rs   = null;           // SQL을 실행하고 결과를 받기 위한 객체
	
	//String url   = "jdbc:mariadb://localhost:3306/mars";
	//String user  = "mars";
	//String pw    = "p@ss00";
	//String query = "SELECT * FROM member";
	String query = "SELECT m_idx, m_name, m_id, m_pw, m_email, m_phone, m_mdfydate, m_rgstdate FROM member ORDER BY m_idx DESC";
	String searchValue = "";
	if(request.getParameter("searchValue") != null){
		searchValue = request.getParameter("searchValue");
	}
	try {
		//1. JDBC 드라이버 로딩
		//Class.forName("org.postgresql.Driver");
		//Class.forName("org.mariadb.jdbc.Driver");
		
		//2. Connection 생성
		//con = DriverManager.getConnection(url, user, pw);
		DataBase database = new DataBase();
		con = database.getConnection();
		//out.println("Database 연결 성공~");

		//3. PreparedStatement 객체 생성
		if(request.getParameter("searchValue") != null){
			query = "SELECT m_idx, m_name, m_id, m_pw, m_email, m_phone, m_mdfydate, m_rgstdate"
				+" FROM member WHERE m_name LIKE ? ORDER BY m_idx DESC";
		}
		pstmt = con.prepareStatement(query);
		if(request.getParameter("searchValue") != null){
			pstmt.setString(1, "%"+request.getParameter("searchValue")+"%");
		}
		rs = pstmt.executeQuery();
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy.MM.dd");
	%>
	<form action="memberList.jsp" name="form">
		<input type="text" name="searchValue" value="<%=searchValue%>">
		<input type="button" onclick="search()" value="검색">
		<input type="button" onclick="insert()" value="회원가입">
	</form>
	<table>
		<tr>
			<td>시퀀스</td>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>이메일</td>
			<td>휴대폰번호</td>
			<td>수정일</td>
			<td>등록일</td>
		<tr>
		<%
			while(rs.next()){
		%>
		<tr>
			<td><%=rs.getString("m_idx")%></td>
			<td><%=rs.getString("m_id")%></td>
			<td><%=rs.getString("m_pw")%></td>
			<td><a href="memberView.jsp?m_idx=<%=rs.getString("m_idx")%>"><%=rs.getString("m_name")%></a></td>
			<td><%=rs.getString("m_email")%></td>
			<td><%=rs.getString("m_phone")%></td>
			<%if(rs.getTimestamp("m_mdfydate") == null){%>
			<td></td>
			<%}else{%>
			<td><%=format1.format(rs.getTimestamp("m_mdfydate"))%></td>
			<%}%>
			<td><%=format1.format(rs.getTimestamp("m_rgstdate"))%></td>
		<tr>
		<%
			}
		%>
	</table>
	<%
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
		if(rs != null) {
			try {
				rs.close();
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
</body>
</html>