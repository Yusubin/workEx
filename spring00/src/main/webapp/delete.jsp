<%@page import="web.MemberDAO"%>
<%@page import="web.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!-- 
    	1. 클라이언트가 입력해서 서버로 보낸 데이터를 받아주어야함
    	2. vo만들어서 값들을 넣어준다
    	3. DAO한테 vo주면서 create해달라고 요청
		4. 결과 화면 만들어서 클라이언트에게 전달     
     -->
  <%
  //1. 클라이언트가 입력해서 서버로 보낸 데이터를 받아주어야함
  String id = request.getParameter("id");

  MemberVO vo = new MemberVO();
  vo.setId(id);

  //ctrl+shft+m
  MemberDAO dao = new MemberDAO();
  dao.delete(vo);
  
  %>   
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	회원 삭제가 완료되었습니다.
</body>
</html>