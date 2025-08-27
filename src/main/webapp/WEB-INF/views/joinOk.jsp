<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 내역</title>
</head>
<body>
	<h3>아이디 : ${memberDto.mid }</h3>
	<h3>비밀번호 : ${memberDto.mpw }</h3>
	<h3>이름 : ${memberDto.mname }</h3>
	<h3>나이 : ${memberDto.mage }</h3>
</body>
</html>