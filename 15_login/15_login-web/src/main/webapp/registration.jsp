<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="registration" method="post">
			<label>Username: </label><input name="username"> <br />
			<label>Pass: </label><input type="password" name="password"><br />
			<label>Pass2: </label><input type="password" name="password2"><br />
			<label>Firstname: </label><input name="firstname"> <br />
			<label>Lastname: </label><input name="lastname"> <br />
			<label>URL: </label><input name="url"> <br />
			<label>Email: </label><input name="email"> <br />
			<label>Phone: </label><input name="phone"> <br />
			<input type="submit">
		</form>
</body>
</html>