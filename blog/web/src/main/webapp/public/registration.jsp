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
<title>Registration</title>
<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/signup.css"/>" rel="stylesheet">
<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<!-- <script -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
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
		<div class="row" id="reg">
			<form id="form-signin" name="form-signin" class="form-signin"
				action="<c:url value="/RegistrationServlet" ></c:url>" method="post">
				<h2 class="form-signin-heading">Registration</h2>
				<label for="username" class="sr-only">Username</label>
				<input type="text" name="username" id="username"
					class="form-control" placeholder="Username">
				<label for="firstname" class="sr-only">Firstname</label>
				<input type="text" name="firstname" id="firstname"
					class="form-control" placeholder="Firstname">
				<label for="lastname" class="sr-only">Lastname</label>
				<input type="text" name="lastname" id="lastname"
					class="form-control" placeholder="Lastname">
				<label for="email" class="sr-only">Email address</label>
				<input for="email" type="email" name="email" id="email"
					class="form-control" placeholder="Email address">
				<label for="phone" class="sr-only">Phone number</label>
				<input type="text" name="phone" id="phone" class="form-control"
					placeholder="Phone number">
				<label for="picture" class="sr-only">Profile picture</label>
				<input type="url" name="picture" id="picture" class="form-control"
					placeholder="Profile picture">
				<label for="password" class="sr-only">Password</label>
				<input type="password" name="password" id="password"
					class="form-control" placeholder="Password"
					onchange="checkPasswordMatch();">
				<label for="password2" class="sr-only">Password again</label>
				<input id="password2" type="password" name="password2"
					class="form-control" placeholder="Password again"
					onchange="checkPasswordMatch();">
				<div class="registrationFormAlert" id="divCheckPasswordMatch"></div>
				<button class="btn btn-lg btn-primary btn-block" type="submit"
					name="bt" id="bt" value="regist">Sign up</button>
			</form>
		</div>
	</div>
	<!-- /container -->
	<script type="text/javascript">
		$.validator.addMethod('customphone', function(value, element) {
			return this.optional(element)
					|| /^\+36(?:[0-9] ?){8}[0-9]$/.test(value);
		}, "For example: +36301234567");
	</script>
	<script type="text/javascript">
		$("#form-signin").validate({
			rules : {
				firstname : {
					required : true,
					maxlength : 30
				},
				lastname : {
					required : true,
					maxlength : 30
				},
				username : {
					required : true,
					maxlength : 30
				},
				picture : {
					required : true,
				},
				email : {
					required : true,
					email : true
				},
				phone : 'customphone'
			},
			messages : {
				email : {
					required : "Required",
					email : "For example: example@gmail.com"
				},
				firstname : {
					maxlength : "Maximum 30 characters."
				},
				lastname : {
					maxlength : "Maximum 30 characters."
				},
				username : {
					maxlength : "Maximum 30 characters."
				}
			}
		});
	</script>
	<script type="text/javascript">
		function passwordsMatch() {
			return $('#password').val() == $('#password2').val();
		}
	</script>
	<script type="text/javascript">
		$(document).ready(
				function() {
					$("#password2").keyup(
							function() {
								if (!passwordsMatch()) {
									$("#divCheckPasswordMatch").html(
											"Passwords do not match!");
								} else {
									$("#divCheckPasswordMatch").html(
											"Passwords match.");
								}
							});
					$("#password").keyup(
							function() {
								if (!passwordsMatch()) {
									$("#divCheckPasswordMatch").html(
											"Passwords do not match!");
								} else {
									$("#divCheckPasswordMatch").html(
											"Passwords match.");
								}
							});
					$('#form-signin').submit(function(evt) {
						if (!passwordsMatch()) {
							evt.preventDefault();
						}
					});
				});
	</script>
	<script type="text/javascript">
		$(function() {
			$("#bt").click(function() {
				var password = $("#password").val();
				var confirmPassword = $("#password2").val();
				if (password != confirmPassword) {
					alert("Passwords do not match.");
					return false;
				}
				if (password.length < 8) {
					$("#divCheckPasswordMatch").html("Minimum 8 characters.");
					return false;
				}
				return true;
			});
		});
	</script>
</body>
</html>