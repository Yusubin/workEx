<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="web.MemberDAO"%>
<%@page import="web.MemberVO"%>
<%
String id = request.getParameter("id");


//ctrl+shft+m  (in JSP)
//ctrl+shft+o (in JAVA)
MemberDAO dao = new MemberDAO();
ArrayList<MemberVO> list = dao.readAll();
%>

<!-- 
    	한줄복사: 컨트롤 +알트+화살표 아래
    	한줄이동:알트 화살표방향
    	한줄 삭제: 컨트롤 d
    	새로만들기 : 컨트롤 n
    	저장 : 컨트롤 s
		실행:컨트롤 f11
		자동 포맷팅: 컨트롤 쉬프트 f
		자동주석 컨트롤 슬러시
     -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	for(MemberVO vo2 : list) {
	%>
	
		검색한 id는 <%= vo2.getId() %><br>
		검색한 name는
	<a href="one.jsp?id=<%= vo2.getId() %>"><%= vo2.getName() %></a>
		<hr>


	<%
	}
	%>
</body>
</html>