<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Insert title here</title>
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
    location = 'index.html';
}
function del(){
    location = 'deleteForm.html';
}
function modi(){
    location = 'modifyForm.html';
}

</script>
</head>
<body>
	<h2>글 목록</h2>
	<%
		
		ResultSet rs   = null;  
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. Connector 라이브러리 설정 성공 @@");
		//2. db 연결 승인된 사용자 (ip+port, user(root), pw db명(big)) 
		String url = "jdbc:mysql://localhost:3366/board?useUnicode=true&characterEncoding=utf8";
		String user ="root";
		String pass = "1234";
		
		String sql = "SELECT * FROM board ORDER BY idx DESC";
		String searchValue = "";
		if(request.getParameter("searchValue") != null){
		    searchValue = request.getParameter("searchValue");
		}
		try {
		  
		    Connection con=DriverManager.getConnection(url, user, pass);
		
		    //3. PreparedStatement 객체 생성
		    if(request.getParameter("searchValue") != null){
		        sql = "SELECT * FROM border WHERE name LIKE ? ORDER BY idx DESC";
		    }
		    PreparedStatement ps = con.prepareStatement(sql);
		    if(request.getParameter("searchValue") != null){
		        ps.setString(1, "%"+request.getParameter("searchValue")+"%");
		    }
		    rs = ps.executeQuery();
		    
		    SimpleDateFormat format1 = new SimpleDateFormat("yyyy.MM.dd");
	    %>
	<form action="boardList.jsp" name="form">

	    검색:<input type="text" name="searchValue">
	    <input id="btn" type="button" onclick="search()" value="검색">
	    <input id="btn" type="button" onclick="insert()" value="글작성">
	    <input id="btn" type="button" onclick="del()" value="글 삭제">
	    <input id="btn" type="button" onclick="modi()" value="글 수정">
	 
	</form>
	<table>
	    <tr>
	        <td>시퀀스</td>
	        <td>제목</td>
	        <td>내용</td>
	        <td>작성자</td>
	        <td>등록일</td>
	    <tr>
	    <%
        while(rs.next()){
    	%>
	    <tr>
		   <td><%=rs.getString("idx")%></td>
	        <td><%=rs.getString("title")%></td>
	        <td><%=rs.getString("content")%></td>
	        <td><%=rs.getString("name")%></td>
	        <td><%=format1.format(rs.getTimestamp("rgstday"))%></td>
	    <tr>
	<%
        }
    %>
	</table>
	<%
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	%>
</body>
</html>