<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="test00.boardDAO"%>
<%@page import="test00.boardVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%
  //1. 클라이언트가 입력해서 서버로 보낸 데이터를 받아주어야함
  String idx = request.getParameter("idx");
  String title = request.getParameter("title");
  String content = request.getParameter("content");
  boardVO vo = new boardVO();
  
  vo.setIdx(Integer.parseInt(idx));
  vo.setTitle(title);
  vo.setContent(content);
 
  //ctrl+shft+m
  boardDAO dao = new boardDAO();
  dao.update(vo);
  
  %>   
     
게시글이 수정되었습니다. 
	<button onclick="location = 'boardList.jsp';">글 목록</button>
<button onclick="location = 'index.html';">글 작성</button>
  <button onclick="location = 'deleteForm.html';">글 삭제</button>
	<button onclick="location = 'modifyForm.html';">글 수정</button>
</body>
</html>