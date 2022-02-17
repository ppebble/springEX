<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
<%@ include file="include/member_header.jsp" %>
</head>
<body>
<%@ include file="include/main_menu.jsp" %>
	<h2 style="text-align:center; margin-top:150px">${sessionScope.userName}(${sessionScope.userId})님 환영합니다.</h2>
	${result}
</body>
</html>