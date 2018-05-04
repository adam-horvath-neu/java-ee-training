<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/crud.css"/>"
	rel="stylesheet">
<title>Show All Users</title>
</head>
<body>
<h1>All Users in the database: </h1>

<div class="ui-widget">
			<table class="blueTable">
				<thead >
					<tr>
						<th>User Id</th>
						<th>Username</th>
						<th>Password</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>URL</th>
						<th>Email</th>
						<th>Phone</th>
						<th colspan=2>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.username}" /></td>
							<td><c:out value="${user.password}" /></td>
							<td><c:out value="${user.firstname}" /></td>
							<td><c:out value="${user.lastname}" /></td>
							<td><c:out value="${user.url}" /></td>
							<td><c:out value="${user.email}" /></td>
							<td><c:out value="${user.phone}" /></td>
							<td><a
								href="UserController?action=edit&userId=<c:out value="${user.id}"/>">Update</a></td>
							<td><a
								href="UserController?action=delete&userId=<c:out value="${user.id}"/>">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<p>
			    <a href="registration.jsp"><button type="button">Add user</button></a>
			</p>
</div>
</body>
</html>