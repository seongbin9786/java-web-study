<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<style>
		label {
			min-width: 150px !important;
			display: inline-block !important;
			text-align: right;
		}
	</style>
<body>
	<h1>Register!</h1>
	<form action="/register.do" method="POST">
	    <div>
			<label for="id">아이디: </label>
			<input name="id" id="id" type="text" />
	    </div>
	    <div>
			<label for="password">비밀번호: </label>
			<input name="password" id="password" type="password" />
	    </div>
	    <div>
			<label for="password_again">비밀번호 다시 입력: </label>
			<input name="password_again" id="password_again" type="password" />
	    </div>
	    <div>
	        <label for="name">이름: </label>
			<input name="name" id="name" type="text" />
	    </div>
	    <div>
	        <button type="submit">제출</button>
	        <button type="reset">초기화</button>
	    </div>
	</form>
</body>
</html>