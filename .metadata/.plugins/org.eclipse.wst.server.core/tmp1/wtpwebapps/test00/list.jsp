<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="test00.boardDAO"%>
<%@page import="test00.boardVO"%>

<%
	String name = request.getParameter("name");

	boardDAO dao = new boardDAO();
	ArrayList<boardVO> list = dao.readAll();


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	for(boardVO vo2 : list) {
	%>
	
	    title: <%= vo2.getTitle() %><br>
		Name:
	<a href="one.jsp?id=<%= vo2.getName() %>"><%= vo2.getName() %></a>
		content: <%= vo2.getContent() %><br>
		rgstDay:<%= vo2.getRgstday() %><br>
		<hr>


	<%
	}
	%>
</body>
</html>