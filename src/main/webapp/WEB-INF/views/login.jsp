<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<h3>로그인(request.getParameter로 빼는 것)</h3>
<form action="loginOk" method="get">
		아이디 <input type="text" name="mid"><br/>
		비밀번호 <input type="password" name="mpw"><br/>
		<input type="submit" value="로그인">
	</form>
</body>
</html>