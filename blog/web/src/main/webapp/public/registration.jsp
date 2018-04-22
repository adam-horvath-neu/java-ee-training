<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">


<title>SignUp Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">


<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/signin.css"/>" rel="stylesheet">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript" src="../resources/js/registrationValidate.js"></script>

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
			<form class="form-signin" action="<c:url value="/Registration" ></c:url>" method="post">

				<h2 class="form-signin-heading">Please Sign Up!</h2>
				<label for="inputUsername" class="sr-only">Username</label> 
				<input type="text" name="username" id="inputUsername" class="form-control"
					placeholder="Username" required autofocus> 
					
<!-- 				<label for="inputPassword" class="sr-only">Password</label>  -->
				<input type="password" name="password" id="inputPassword"
					class="form-control" placeholder="Password" required>
					
<!-- 				<label for="inputPassword" class="sr-only">Password again</label>  -->
				<input type="password" name="password2" id="inputPassword2"
					class="form-control" placeholder="Password2" required>
					
<!-- 				<label for="inputEmail" class="sr-only">First name</label>  -->
				<input type="text" name="firstname" id="inputFirstName" class="form-control"
					placeholder="First name" required> 
					
<!-- 				<label for="inputEmail" class="sr-only">Last name</label>  -->
				<input type="text" name="lastname" id="inputLastName" class="form-control"
					placeholder="Last name" required>
					
<!-- 				<label for="inputEmail" class="sr-only">Email</label>  -->
				<input type="text" name="email" id="inputEmail" class="form-control"
					placeholder="Email address" required>  
					
<!-- 				<label for="inputEmail" class="sr-only">Phone number</label>  -->
				<input type="text" name="phone" id="inputPhone" class="form-control"
					placeholder="Phone number" required> 
					
<!-- 				<label for="inputEmail" class="sr-only">Profile picture</label>  -->
				<input type="text" name="picture" id="inputPicture" class="form-control"
					placeholder="Picture URL" required> 

				<button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>

			</form>
			<h3 align="center"></h3>
		</div>
	</div>
	<!-- /container -->



</body>
</html>
