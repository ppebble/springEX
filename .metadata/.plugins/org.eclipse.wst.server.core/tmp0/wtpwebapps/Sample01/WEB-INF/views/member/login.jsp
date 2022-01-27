<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
<%@ include file="../include/header.jsp" %>
<script>
	$(document).ready(function(){
		$("#btnLogin").click(function(){
			var userId = $("#userId").val();
			var userPw = $("#userPw").val();
			if(userId == ""){
				alert("아이디를 입력하세요.")
				$("#userId").focus();
				return;
			}
			if(userPw == ""){
				alert("비밀번호를 입력하세요")
				$("#userPw").focus();
				return;
			}
			document.form1.action = "${path}/member/loginCheck.do"
			document.form1.submit();
		})
	})
	
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>LOGIN</h2>
	<form name="form1" method="POST">
		<table border="1" width="400px">
			<tr>
				<td>ID :: </td>
				<td><input name="userId" id="userId"></td>
			</tr>
			<tr>
				<td>PW ::</td>
				<td><input name="userPw" id="userPw"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="button" id="btnLogin">LOGIN</button>
				<c:if test="${msg == 'failure'}">
					<div style="color: red">
						아이디 또는 비밀번호가 일치하지 않습니다.
					</div>
				</c:if>
				<c:if test="${msg == 'logout'}">
					
					<div style="color: red">
						로그아웃 되었습니다.
					</div>
					
				</c:if>
				</td>
			</tr>
		</table>
	</form>
	

</body>

</html>