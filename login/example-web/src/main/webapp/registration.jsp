<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Register Form">
<title>Registration</title>
<!--Add bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<c:url value="/resources/css/register.css"/>">
<!-- Add fontAwesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.10/css/all.css"
	integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg"
	crossorigin="anonymous">
</head>
<body>

	<div id="body">
		<div class="form-container">
			<div class="message">
				<i class="fas fa-bell"></i><span class="message-text"></span>
			</div>
			<div class="row">
				<div class="col">
					<form class="form-signup"
						action="<c:url value="/registration" ></c:url>" method="post">
						<h1>Registration form</h1>
						<label for="username" class="sr-only">Enter Username</label>
						<input type="text" name="username" id="username"
							class="form-control" placeholder="Username..." required>

						<label for="lastname" class="sr-only">First Name</label>
						<input type="text" name="firstname" id="firstname"
							class="form-control" placeholder="First name..." required>

						<label for="lastname" class="sr-only">Last Name</label>
						<input type="text" name="lastname" id="lastname"
							class="form-control" placeholder="Last name..." required>

						<label for="email" class="sr-only">E-mail Address</label>
						<input type="text" name="email" id="email" class="form-control"
							placeholder="Email address..." required>

						<label for="phone" class="sr-only">Phone</label>
						<input type="text" name="phone" id="phone" class="form-control"
							placeholder="Phone number..." required>

						<label for="userimage" class="sr-only">Add picture url</label>
						<input type="text" name="userimage" id="picture"
							class="form-control" placeholder="Enter url..." required>

						<label for="password" class="sr-only">Password</label>
						<input type="password" name="password" id="password"
							class="form-control" placeholder="Enter Password..." required>

						<label for="password" class="sr-only">Password again</label>
						<input type="password" name="password2" id="password2"
							class="form-control" placeholder="Re-enter password..." required>

						<button id="registerform" class="btn btn-lg btn-block btn-primary"
							type="submit">Register</button>
					</form>
				</div>
			</div>
		</div>
	</div>

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