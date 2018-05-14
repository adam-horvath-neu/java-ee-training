<!DOCTYPE HTML>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Register</title>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/register.css"/>" rel="stylesheet" media="screen">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js">
</script>
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
</div>
<div class="signin-form">
    <div class="container">
        <form class="form-signin"  action="registration" method="post" id="register-form">
            <h2 class="form-signin-heading">Add User</h2><hr />
            <div id="error"></div>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Username" name="user_name" id="user_name" />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="First Name" name="first_name" id="first_name" />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Last Name" name="last_name" id="last_name" />
            </div>
            <div class="form-group">
                <input type="email" class="form-control" placeholder="Email address" name="user_email" id="user_email" />
                <span id="check-e"></span>
            </div>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Phone number (+36-xx-xxxx-xx)" name="phone_number" id="phone_number " />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Profile picture (url)" name="profile_picture" id="profile_picture " />
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="Password" name="password" id="password" />
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="Retype Password" name="cpassword" id="cpassword" />
            </div>
            <hr />
                <div class="form-group">
                <button type="submit" class="btn btn-default" name="btn-save" id="btn-submit">
                    <span class="glyphicon glyphicon-log-in"></span> &nbsp; Create Account
                </button>
            </div>
        </form>
    </div>
</div>

<script>
$('document').ready(function()
{
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
            user_name: {
                required: true,
                minlength: 3,
                maxlength: 30
            },
            password: {
                required: true,
                minlength: 8,
                mypassword: true
            },
            cpassword: {
                required: true,
                equalTo: '#password'
            },
            user_email: {
                required: true,
                email: true,
                myemail:true
            },
            phone_number:{
            	phonenumber:true,
            	required:true
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
            user_name:{
            	minlength:"Enter a Valid Username",
            	maxlength: "Enter a Valid Username",
            	required: "Provide a User Name"
            },
            password:{
                required: "Provide a Password",
                minlength: "Password Needs To Be Minimum of 8 Characters",
                mypassword: "Password must contain at least one numeric character."
            },
            user_email:{
            	myemail: "Enter a valid email."
            },
            phone_number:{
            	phonenumber: "Please enter a valid phone number."
            },
            cpassword:{
                required: "Retype Your Password",
                equalTo: "Password Mismatch! Retype"
            }
        },
    });
    /* validation */


});
</script>
<script>
    $.validator.addMethod('mypassword', function(value, element) {
            return this.optional(element) || (value.match(/[a-zA-Z]/) && value.match(/[0-9]/));
        },
        'Password must contain at least one numeric and one alphabetic character.');
    </script>
    
   <script>
    $.validator.addMethod('myemail', function(value, element) {
            return this.optional(element) || (value.match(/\S+@\S+\.\S+/));
        });
    </script>
       <script>
    $.validator.addMethod('phonenumber', function(value, element) {
            return this.optional(element) || (value.match(/^[0-9\+]{1,}[0-9\-]{3,15}$/));
    });
    </script>

    
    
<script <c:url value="/resources/js/bootstrap.min.js"/>></script>
</body>

</html>