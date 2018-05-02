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

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>
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
			<div class="col-sm-6 col-sm-offset-3">
				<c:if test="${requestScope.ok != null}">
					<div class="alert alert-success">
						<span class="glyphicon glyphicon-exclamation-sign"
							aria-hidden="true"></span> ${requestScope.ok}
					</div>
				</c:if>
			</div>
		</div>
		<div class="row">
			<form id="register-form" class="form-signin"
				action="<c:url value="/registration" ></c:url>" method="post">

				<h2 class="form-signin-heading">Registration</h2>
				<label for="username" class="sr-only">Username</label>
				<input type="text" name="username" id="username"
					class="form-control" placeholder="Username" required>

				<label for="last-name" class="sr-only">Last name</label>
				<input type="text" name="lastName" id="last_name"
					class="form-control" placeholder="Last Name" required>

				<label for="first-name" class="sr-only">First name</label>
				<input type="text" name="firstName" id="first_name"
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
				<input type="password" name="passwordConfirm" id="password_confirm"
					class="form-control" placeholder="Password Confirm" required>

				<button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>

			</form>
		</div>

	</div>
	<!-- /container -->

	<script>
	
	$('document').ready(function(){
	    /* validation */
	    $("#register-form").validate({
	        rules:
	        {
	             first_name: {
	                 required: true,
	                 minlength: 3,
	                 maxlength: 30
	             },
	              last_name: {
	                 required: true,
	                 minlength: 3,
	                 maxlength: 30
	             },
	            username: {
	                required: true,
	                minlength: 3,
	                maxlength: 30
	            },
	            password: {
	                required: true,
	                minlength: 8,
	                mypassword: true
	            },
	            password_confirm: {
	                required: true,
	                equalTo: '#password'
	            },
	            email: {
	                required: true,
	                email: true
	            },
	        },
	        messages:
	        {    
	            first_name:{
	                minlength:"Enter a Valid First Name",
	                maxlenghth: "Enter a Valid First Name",
	                required: "Provide a First Name"
	            },
	                
	            last_name:{
	                minlength:"Enter a Valid Last Name",
	                maxlenghth:"Enter a Valid Last Name",
	                required: "Provide a Last Name"
	            },
	            username:{
	                minlength:"Enter a Valid Username",
	                maxlength: "Enter a Valid Username",
	                required: "Provide a User Name"
	            },
	            password:{
	                required: "Provide a Password",
	                minlength: "Password Needs To Be Minimum of 8 Characters",
	                mypassword: "Password must contain at least one numeric character."
	            },
	            email: "Enter a Valid Email",
	            password_confirm:{
	                required: "Retype Your Password",
	                equalTo: "Password Mismatch! Retype"
	            }
	        },
	        submitHandler: submitForm
	    });
	    
	    function submitForm()
	    {
	        var data = $("#register-form").serialize();

	        $.ajax({

	            type : 'POST',
	            url  : 'register.php',
	            data : data,
	            beforeSend: function()
	            {
	                $("#error").fadeOut();
	                $("#btn-submit").html('<span class="glyphicon glyphicon-transfer"></span> &nbsp; sending ...');
	            },
	            success :  function(data)
	            {
	                if(data==1){

	                    $("#error").fadeIn(1000, function(){


	                        $("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Sorry email already taken !</div>');

	                        $("#btn-submit").html('<span class="glyphicon glyphicon-log-in"></span> &nbsp; Create Account');

	                    });

	                }
	                else if(data=="registered")
	                {

	                    $("#btn-submit").html('Signing Up');
	                    setTimeout('$(".form-signin").fadeOut(500, function(){ $(".signin-form").load("successreg.php"); }); ',5000);

	                }
	                else{

	                    $("#error").fadeIn(1000, function(){

	                        $("#error").html('<div class="alert alert-danger"><span class="glyphicon glyphicon-info-sign"></span> &nbsp; '+data+' !</div>');

	                        $("#btn-submit").html('<span class="glyphicon glyphicon-log-in"></span> &nbsp; Create Account');

	                    });

	                }
	            }
	        });
	        return false;
	    }
	});


</script>


</body>
</html>
