<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	환영합니다....
	<br>
	<form action="login.jsp">
	아이디 : <input type="text" name="id"><br>
	패스워드 : <input type="text" name="pw"><br>
	<button style=background:yellow;color:red;width:100px;>회원로그인 요청</button>
	
	</form><br>
	<hr color="blue">
	<form action="create.jsp">
		아이디:<input type="text" name="id"><br> 패스워드:<input
			type="text" name="pw"><br> 이름:<input type="text"
			name="name"><br> 전화번호:<input type="text" name="tel"><br>
		<button>회원가입요청</button>

	</form>
	<br>
	<hr color="yellow">
	<form action="update.jsp">
		아이디:<input type="text" name="id"><br> 전화번호:<input
			type="text" name="tel"><br>
		<button>수정요청</button>
	</form>

	<br>
	<hr color="red">
	<form action="delete.jsp">
		아이디:<input type="text" name="id" value="${user}"><br>
		<button>삭제요청</button>
	</form>

	<br>
	<hr color="red">
	<form action="one.jsp">
		아이디:<input type="text" name="id" value="${user}"><br>
		<button>검색요청</button>
	</form>
	<a href="one.jsp?id='${user}'">apple검색</a>
	
	<a href="list.jsp">
	<button style="background:yellow;">전체회원 목록</button></a>
</body>
</html>