<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>::회원 상세 정보 ::</title>
<%@ include file="../include/member_header.jsp" %>
<script>
	$(document).ready(function(){
		
	})
	$(document).ready(function(){
		$("#btnUpdate").click(function(){
			if(confirm("수정하시겠습니까 ?")){
				document.form1.action = "${path}/member/update.do";
				document.form1.submit();
				return;
			}
			
		})
		$("#btnDelete").click(function(){
			if(confirm("삭제하시겠습니까?")){
				document.form1.action = "${path}/member/delete.do";
				document.form1.submit();
				return;
			}
		})
	})
</script>
</head>
<body>
<%@ include file="../include/member_menu.jsp" %>
	<h2>회원 상세 정보</h2>
	<form name="form1" method="post" action="${path}/member/update.do">
		<table border="1" width="400px">
			<tr>
				<td>ID</td>
				<td><input name="userId" value="${dto.userId}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="password" name="userPw"></td>
			</tr>
			<tr>
				<td>NAME</td>
				<td><input name="userName" value="${dto.userName}"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input name="userEmail" value="${dto.userEmail}"</td>
			</tr>
			<tr>
				<td>회원가입일자</td>
				<td>
					<fmt:formatDate value ="${dto.userRegdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="수정하기" id="btnUpdate">
					<input type="submit" value="삭제하기" id="btnDelete">
					<div style="color:red;">${message}</div>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>