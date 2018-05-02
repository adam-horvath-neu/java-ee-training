<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Starter Template for Bootstrap</title>

<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">

<link href="<c:url value="/resources/css/blog.css"/>" rel="stylesheet">

<link href="<c:url value="/resources/css/my.css"/>" rel="stylesheet">

</head>

<body>

	<div class="blog-masthead">
		<div class="container">
			<nav class="blog-nav">
				<a class="blog-nav-item " href="<c:url value="/index.jsp"/>">Home</a>
				<c:if test="${sessionScope.user ==null}">
					<a class="blog-nav-item" href="<c:url value="/public/login.jsp"/>">Login</a>
				</c:if>
				<c:if test="${sessionScope.user !=null}">
					<a class="blog-nav-item" href="<c:url value="/Logout"/>">Logout</a>
				</c:if>
				<a class="blog-nav-item active"
					href="<c:url value="/secured/secured.jsp"/>">Users</a>

			</nav>
		</div>
	</div>

	<div class="container">


		<div class="row" id="result"></div>
	</div>
	<!-- /.container -->
	<div class="loader col-sm-offset-6"></div>
	<div id="myModal" class="modal fade" role="dialog"></div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/user.js"/>"></script>
</body>
</html>
