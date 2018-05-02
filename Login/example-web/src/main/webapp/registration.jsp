<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>

<title> Registration </title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

<!-- <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>  -->

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet"> 
<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/registration.css"/>" rel="stylesheet">
 
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"> </script>

<script src="resources/js/validation.js"></script>


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
	
			<form action="registration"  method="post" id="form-registration" name="form-registration" class="form-registration" onsubmit="return Validate(this)" >
				
				<h2 class="form-registration-heading"> Registration </h2>
				
				<p>
				<label for="username" class="sr-only">Username</label>
				<input type="text" name="username" id="username" class="form-control" placeholder="Username" >
				</p>
				
				<p>
				<label for="firstname" class="sr-only">Firstname</label>
				<input type="text" name="firstname" id="firstname" class="form-control" placeholder="Firstname" >
				</p>
				
				<p>
				<label for="lastname" class="sr-only">Lastname</label>
				<input type="text" name="lastname" id="lastname" class="form-control" placeholder="Lastname" >
				</p>	
				
				<p>
				<label for="email" class="sr-only">Email address</label>
				<input type="email" name="email" id="email" class="form-control" placeholder="Email address" >
				</p>
				
				<p>	
				<label for="phone" class="sr-only">Phone number</label>
				<input type="tel" name="phone" id="phone" class="form-control" placeholder="Phone number" >
				</p>
								
				<p>	
				<label for="picture" class="sr-only">Profile picture</label>
				<input type="url" name="picture" id="url" class="form-control" placeholder="Profile picture">
				</p>
				
				<p>
				<label for="password" class="sr-only"> Password </label>				
				<input type="password" name="password" id="password" class="form-control" placeholder="Password" >
				</p>
				
				<p>
				<label for="password2" class="sr-only"> Password again </label>
				<input id="password2" type="password" name="password2" class="form-control" placeholder="Password again" >
				</p>
				
				<button class="btn btn-lg btn-primary btn-block" type="submit"
					 name="bt" id="bt" value="Submit" > Sign up </button>
						
			
			</form> 
		</div>
	</div>
	
	
	 
<!--  	<script type="text/javascript">
		function Validate(form) {
			var username= document.forms["form-registration"]["username"].value;
			if (username=="" || username.length>30){
				alert("Incorrect username. Please write maximum 30 character.");
				form.username.focus();
				return false;
			}
			var firstname= document.forms["form-registration"]["firstname"].value;
			if (firstname.length>30){
				alert("Incorrect firstname. Please write maximum 30 character.");
				form.firstname.focus();
				return false;
			}
			var lastname= document.forms["form-registration"]["lastname"].value;
			if (lastname.length>30){
				alert("Incorrect lastname. Please write maximum 30 character.");
				form.lastname.focus();
				return false;
			}
			var email= document.forms["form-registration"]["email"].value;
			if (email.length>30){
				alert("Incorrect email address. You must provide a valid email address.");
				form.email.focus();
				return false;
			}
	  		var phone= document.forms["form-registration"]["phone"].value;
			var format= /^\[+]d{2}[-]d{2}[/]d{4}[-]d{3}$/ 			
			if (!format.test(phone)){
				alert("Incorrect telephone number format. See an example: +36-30/1234-567");
				form.phone.focus();
				return false;
			}  
			
			var password= document.forms["form-registration"]["password"].value;
			if (password.length<8){
				alert("Incorrect password. The password must contains minimum 8 character. ");
				form.password.focus();
				return false;
			}
			var password2= document.forms["form-registration"]["password2"].value;
			if (password2 != password){
				alert("The passwords don't match. Please write password that above.");
				form.password2.focus();
				return false;
			}
			
			return true;
		}  
						
</script>-->
	
	
	
</body>
</html>