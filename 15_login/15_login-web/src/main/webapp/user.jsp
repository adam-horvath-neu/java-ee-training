<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Update User</title>
</head>
<body>
<h1>Update User: </h1>
	<form method="POST" action='UserController' name="frmAddUser">
		<table>
			<tr>
				<td>User ID:</td>
				<td><input type="text" readonly="readonly" name="userid"
					value="<c:out value="${user.id}" />" /> <br /></td>
			</tr>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username" readonly="readonly"
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
</body>
</html>