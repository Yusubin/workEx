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
  
  //값 받아오기
  String title= request.getParameter("title");
  String content =  request.getParameter("content");
  String name = request.getParameter("name");
  
  //제어부분. 가방만들어서 입력데이터를 넣음
  boardVO vo = new boardVO();
  vo.setTitle(title);
  vo.setContent(content);
  vo.setName(name);
  //ctrl+shft+m 
  
 //db에 넣는 처리. DAP에게 가방넣어서 전달
  boardDAO dao = new boardDAO();
  dao.create(vo);
  
  %> 
  
  게시글이 작성되었습니다. 
  	<button onclick="location = 'boardList.jsp';">글 목록</button>
  	<button onclick="location = 'index.html';">글 작성</button>
    <button onclick="location = 'deleteForm.html';">글 삭제</button>
	<button onclick="location = 'modifyForm.html';">글 수정</button>
</body>
</html>