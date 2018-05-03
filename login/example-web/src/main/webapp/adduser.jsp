<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.10/css/all.css"
	integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg"
	crossorigin="anonymous">

<title>Add user</title>
</head>
<body>
	<form action="/TableController" method="post">
		<table class="table table-striped">
			<tr>
				<td>User ID:</td>
				<td><input class="form-control" type="text" readonly="readonly"
					name="userid" value="<c:out value="${user.id}" />" /> <br /></td>
			</tr>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username"
					value="<c:out value="${user.username}" />" /> <br /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"
					value="<c:out value="${user.password}" />" /> <br /></td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstname"
					value="<c:out value="${user.firstname}" />" /> <br /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastname"
					value="<c:out value="${user.lastname}" />" /> <br /></td>
			</tr>
			<tr>
				<td>URL:</td>
				<td><input type="text" name="url"
					value="<c:out value="${user.url}" />" /> <br /></td>
			</tr>
			<tr>
				<td>E-mail:</td>
				<td><input type="text" name="email" class="form-control"
					value="<c:out value="${user.email}" />" /> <br /></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><input type="text" name="phone"
					value="<c:out value="${user.phone}" />" /> <br /></td>
			</tr>
			<tr>
				<td colspan=2><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
	<!-- jQuery library -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<!-- Popper JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/resources/js/validate.js"></script>
</body>
</html>