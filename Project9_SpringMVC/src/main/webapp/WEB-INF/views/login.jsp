<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<meta charset="UTF-8" />
<head>
	<title>Home</title>
</head>
<body>
<h1>로그인이나 해봅시다</h1>

<p>일반 로그인</p>
<form action="/login" method="POST">
	<input name="id" />
	<input name="password" type="password" />
	<button type="submit">로그인 - 일반 버전</button>
</form>

<p>커맨드 객체 로그인</p>
<form action="/login_command" method="POST">
	<input name="id" />
	<input name="password" type="password" />
	<button type="submit">로그인 - 커맨드 객체 버전</button>
</form>

</body>
</html>
