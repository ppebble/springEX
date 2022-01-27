<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>::회원가입 ::</title>
<%@ include file="../include/member_header.jsp" %>
</head>
<body>
<%@ include file="../include/member_menu.jsp" %>
	<h2>회원가입</h2>
	<form name="form1" method="post" action="${path}/member/insert.do">
		<table border="1" width="400px">
			<tr>
				<td>ID</td>
				<td><input name="userId"></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="password" name="userPw"></td>
			</tr>
			<tr>
				<td>NAME</td>
				<td><input name="userName"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input name="userEmail"</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="확인">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>