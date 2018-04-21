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


<title>Signin Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">


<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/signin.css"/>" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				<c:if test="${requestScope.error != null}">
					<div class="alert alert-danger" role="alert">
						<span class="glyphicon glyphicon-exclamation-sign"
							aria-hidden="true"></span> ${requestScope.error}
					</div>

				</c:if>
			</div>
		</div>
		<div class="row">
			<form class="form-signin" action="<c:url value="/Register" ></c:url>"
				method="post">

				<h2 class="form-signin-heading">Registration</h2>
				<label for="username" class="sr-only">Username</label>
				<input type="text" name="username" id="username"
					class="form-control" placeholder="Username" required>

				<label for="last-name" class="sr-only">Last name</label>
				<input type="text" name="lastName" id="last-name"
					class="form-control" placeholder="Last Name" required>

				<label for="first-name" class="sr-only">First name</label>
				<input type="text" name="firstName" id="first-name"
					class="form-control" placeholder="First Name" required>

				<label for="email" class="sr-only">E-mail</label>
				<input type="email" name="email" id="email" class="form-control"
					placeholder="E-mail" required>

				<label for="phone" class="sr-only">Phone number</label>
				<input type="text" name="phone" id="phone" class="form-control"
					placeholder="Phone number (+36-30/1234-567)" required>

				<label for="picture" class="sr-only">Profile picture</label>
				<input type="text" name="picture" id="picture" class="form-control"
					placeholder="Profile picture url" required>

				<label for="password" class="sr-only">Password</label>
				<input type="password" name="password" id="password"
					class="form-control" placeholder="Password" required>

				<label for="password-confirm" class="sr-only">Password
					confirm</label>
				<input type="password" name="passwordConfirm" id="password-confirm"
					class="form-control" placeholder="Password Confirm" required>

				<button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>

			</form>
		</div>

	</div>
	<!-- /container -->



</body>
</html>
