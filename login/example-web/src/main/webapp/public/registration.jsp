<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="hu">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Register</title>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/signin.css"/>" rel="stylesheet">
<!--Add bootstrap -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.10/css/all.css"
	integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg"
	crossorigin="anonymous">
<style type="text/css">
.colreg {
	width: 50%;
	display: block;
	margin: 0 auto;
}

.message {
	display: block;
	margin: 0 auto;
	width: 50%;
	text-align: center;
}
</style>
</head>
<body>
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
		<div class="colreg">
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
	<div class="message alert alert-danger">
		<i class="fas fa-bell notification-icon"></i><span
			class="message-text"></span>
	</div>
</body>
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.0/jquery.min.js"></script>
<script>
	jQuery(document)
			.ready(
					function($) {

						var userNameValid = false;
						var firstNameValid = false;
						var lastNameValid = false;
						var emailValid = false;
						var phoneValid = false;
						var userPictureValid = false;
						var passwordValid = false;
						var passwordRepeatValid = false;

						var inputUsername = $("input#username");
						var inputFirstName = $("input#firstname");
						var inputLastName = $("input#lastname");
						var inputEmail = $("input#email");
						var inputPhone = $("input#phone");
						var inputUserPicture = $("input#picture");
						var inputPassword = $("input#password");
						var inputPassword2 = $("input#password2");

						$(".message").hide();

						function validate() {
							if (userNameValid && firstNameValid
									&& lastNameValid && emailValid
									&& phoneValid && userPictureValid
									&& passwordValid && passwordRepeatValid) {
								$("button#registerform")
										.prop("disabled", false);
							} else {
								$("button#registerform").prop("disabled",
										"disabled");
							}
						}

						validate();

						inputUsername
								.keyup(function() {
									if ($(inputUsername).val().length > 0
											&& $(inputUsername).val().length <= 30) {
										$('message-text').text("");
										userNameValid = true;
										$(".message").hide();
										$(".message").removeClass("invalid");
										validate();
									} else {
										$(".message-text").addClass("invalid");
										$(".message-text")
												.text(
														"Minimum 1, maximum 30 karaktert adhat meg username-nek!");
										$(".message").show();
										userNameValid = false;
										validate();
									}
								});

						inputFirstName
								.keyup(function() {
									if (inputFirstName.val().length > 0
											&& inputFirstName.val().length <= 30) {
										$('message-text').text("");
										firstNameValid = true;
										$(".message").hide();
										$(".message").removeClass("invalid");
										validate();
									} else {
										$(".message-text").addClass("invalid");
										$(".message-text")
												.text(
														"Minimum 1, maximum 30 karaktert adhat meg firstname-nek!");
										$(".message").show();
										firstNameValid = false;
										validate();
									}
								});

						inputLastName
								.keyup(function() {
									if (inputLastName.val().length > 0
											&& inputLastName.val().length <= 30) {
										$('message-text').text("");
										lastNameValid = true;
										$(".message").hide();
										$(".message").removeClass("invalid");
										validate();
									} else {
										$(".message-text").addClass("invalid");
										$(".message-text")
												.text(
														"Minimum 1, maximum 30 karaktert adhat meg lastname-nek!");
										$(".message").show();
										lastNameValid = false;
										validate();
									}
								});

						inputEmail
								.keyup(function() {
									if (inputEmail
											.val()
											.match(
													(/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i))) {
										$('message-text').text("");
										emailValid = true;
										$(".message").hide();
										$(".message").removeClass("invalid");
										validate();
									} else {
										$(".message-text").addClass("invalid");
										$(".message-text")
												.text("Ez nem email!");
										$(".message").show();
										emailValid = false;
										validate();
									}
								});

						inputPhone.keyup(function() {
							if (inputPhone.val().match(
									/^\+36\-[0-9]{2}\/[0-9]{4}\-[0-9]{3}/)) {
								$('message-text').text("");
								phoneValid = true;
								$(".message").hide();
								$(".message").removeClass("invalid");
								validate();
							} else {
								$(".message-text").addClass("invalid");
								$(".message-text").text("Ez nem telefon!");
								$(".message").show();
								phoneValid = false;
								validate();
							}
						});

						inputUserPicture.keyup(function() {
							if (inputUserPicture.val().length > 0) {
								$('message-text').text("");
								userPictureValid = true;
								$(".message").hide();
								$(".message").removeClass("invalid");
								validate();
							} else {
								$(".message-text").addClass("invalid");
								$(".message-text")
										.text("Adjon meg egy linket!");
								$(".message").show();
								userPictureValid = false;
								validate();
							}
						});

						inputPassword.keyup(function() {
							if (inputPassword.val().length > 0
									&& inputPassword.val().length <= 8
									&& inputPassword.val().match(/\d/)) {
								$('message-text').text("");
								passwordValid = true;
								$(".message").hide();
								$(".message").removeClass("invalid");
								validate();
							} else {
								passwordValid = false;
								$(".message-text").addClass("invalid");
								$(".message-text").text(
										"Max hossz: 8, number required!");
								$(".message").show();
								validate();
							}
						});

						inputPassword2.keyup(function() {
							if (inputPassword2.val() === inputPassword.val()) {
								$('message-text').text("");
								passwordRepeatValid = true;
								$(".message").hide();
								$(".message").removeClass("invalid");
								validate();
							} else {
								passwordRepeatValid = false;
								$(".message-text").addClass("invalid");
								$(".message-text").text(
										"A jelszavaknak egyeznie kell!");
								$(".message").show();
								validate();
							}
						});
					});
</script>
</html>