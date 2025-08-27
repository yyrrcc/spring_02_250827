<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 내역</title>
</head>
<body>
	<h3>studentInfomationDto.name 로 보내기</h3>
	<h3>아이디 : ${studentInfomationDto.name }</h3>
	<h3>비밀번호 : ${studentInfomationDto.email }</h3>
	<hr/>
	<h3>@ModelAttribute("sInfo") 로 보내기</h3>
	<h3>아이디 : ${sInfo.name }</h3>
	<h3>비밀번호 : ${sInfo.email }</h3>
</body>
</html>