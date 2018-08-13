<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<div class="container">
		<h1>Hyundai CarMall</h1>
		<form action='${pageContext.request.contextPath }/login' method='post'>
			<input type="hidden" name="orgReqPath" value="${orgReqPath }" />
			<div style="color: red">${error}</div>
			ID: <input type='text' name='id'><br /> Password: <input
				type='password' name='pw'><br /> <input type='submit'
				value='login' />
		</form>
	</div>
</body>
</html>