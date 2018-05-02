<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Home</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value="resources/css/bootstrap.min.css"/>"
	rel="stylesheet">


<!-- Custom styles for this template -->
<link href="<c:url value="resources/css/blog.css"/>" rel="stylesheet">

<jsp:include page="header.jsp"></jsp:include>


</head>

<body>

	<div class="blog-masthead">
		<div class="container">
			<nav class="blog-nav">
				<a class="blog-nav-item active" href="<c:url value="/index.jsp"/>"> Home </a>

				<c:if test="${sessionScope.user ==null}">
					<a class="blog-nav-item" href="<c:url value="/public/login.jsp"/>">Login</a>
					<a class="blog-nav-item" href="<c:url value="registration.jsp"/>"> Registration </a>
				</c:if>
				
				<c:if test="${sessionScope.user !=null}">
					<a class="blog-nav-item" href="<c:url value="/Logout"/>"> Logout </a>
				</c:if>
			<%-- 	<a class="blog-nav-item" href="<c:url value="users.jsp"/>"> Users</a> --%>

			</nav>
		</div>
	</div>
	
<%-- <table>
		<tr>
			<td valign="top"><jsp:include page="menu.jsp"></jsp:include></td>
			<td></td>
		</tr>
	</table> --%>

	<div class="container">

		<div class="blog-header">
			<h1 class="blog-title" align="center" > Welcome to my Blog Site </h1>
<!-- 			<p class="lead blog-description" align="center" > The official example template of creating with Bootstrap. </p> -->
		</div>

	

	</div>
	<!-- /.container -->


</body>
</html>
