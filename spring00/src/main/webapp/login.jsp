<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@page import="web.MemberDAO"%>
<jsp:useBean id="vo" class="web.MemberVO">
	<jsp:setProperty name="vo" property="*" />
</jsp:useBean>
<!-- 

MemberVO vo = new MemberVO();
String id=request.getParameter("id");
String id=request.getParameter("pw");
vo.setId(id);
vo.setId(pw);

MemberDAO dao = new MemberDAO();
MemberVO vo2= dao.readOne(vo);

 -->
<%
	MemberDAO dao = new MemberDAO();
	boolean result = dao.login(vo);
	String text="로그인 실패";
	if(result){
		session.setAttribute("user", vo.getId());
		text="로그인성공";
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
로그인 결과는 <%= text %>,
세션 user값은 <%= session.getAttribute("user")%>, ${user}
<!--  Attribute로 가져올수있는것만 ${} 사용할수잇음. -->
</body>
</html>