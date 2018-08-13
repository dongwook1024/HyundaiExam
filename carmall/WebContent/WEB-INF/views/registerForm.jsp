<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<style>
	.error {
		font-color: red	
	}
</style>
</head>
<body>
	<h2>회원등록</h2>
	<form method="post" action="${pageContext.request.contextPath }/register">
	<div class="error">${error }</div>
	<table>
		<tr>
			<td>ID</td>
			<td><input type="text" name="id" placeholder="아이디 입력" autofocus></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" placeholder="이름 입력"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pw" placeholder="비밀번호 입력"></td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td><input type="date" name="dob"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="email" name="email" placeholder="abcd@example.com"></td>
		</tr>
		<tr>
			<td><input type="submit" value="등록하기"></td>
		</tr>
	</table>
	</form>
</body>
</html>