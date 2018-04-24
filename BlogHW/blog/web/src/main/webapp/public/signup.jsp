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
<title>SignUp!</title>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/signin.css"/>" rel="stylesheet">
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
			<form class="form-signin"
				action="<c:url value="/SignUpServlet" ></c:url>" method="post">
<!-- 				<h1 id="result">Sajt</h1> -->
				<h2 class="form-signin-heading">Sign Up!</h2>

				<label for="inputEmail" class="sr-only">Username</label> <input
					type="text" name="username" id="inputUsername" class="form-control"
					placeholder="Username" required autofocus> <label
					for="inputPassword" class="sr-only">Password</label> <input
					type="password" name="password" id="inputPassword"
					class="form-control" placeholder="Password" required> <label
					for="inputPassword" class="sr-only">Password again</label> <input
					type="password" name="passwordagain" id="inputPassword2"
					class="form-control" placeholder="RepeatThePassword" required>

				<label for="inputEmail" class="sr-only">First name</label> <input
					type="text" name="firstname" id="inputFirstName"
					class="form-control" placeholder="First name" required autofocus>

				<label for="inputEmail" class="sr-only">Last name</label> <input
					type="text" name="secondname" id="inputLastName"
					class="form-control" placeholder="Last name" required autofocus>

				<label for="inputEmail" class="sr-only">Email</label> <input
					type="text" name="email" id="inputEmail" class="form-control"
					placeholder="Email address" required autofocus> <label
					for="inputEmail" class="sr-only">Phone number</label> <input
					type="text" name="phonenumber" id="inputPhone" class="form-control"
					placeholder="Phone number" required autofocus> <label
					for="inputEmail" class="sr-only">Profile picture</label> <input
					type="text" name="pictureurl" id="inputPicture"
					class="form-control" placeholder="Picture URL" required autofocus>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
					Up</button>

			</form>
		</div>

	</div>

</body>
<script>
// 	$('#inputFirstName').change(function() {
// 		$.ajax({
// 			url : 'SignUpServlet',
// 			firstname : $('inputFirstName').val(),
// 			type : 'POST',
// 			success : function(data) {
// 				$("#result").html(data);
// 			},
// 			dataType : "html"
// 		});

// 	});
</script>

</html>
