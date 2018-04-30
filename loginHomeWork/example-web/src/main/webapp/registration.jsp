<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html lang="en">
<head>

<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.7/jquery.validate.min.js"></script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">


<title>Signin Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">


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
		<div class="row" id= "add"  style="display:none";>
			<form class="form-signin" name = "myform" id= "myform"  action="<c:url value="/registration" ></c:url>" method="post" >

				<h2 class="form-signin-heading">Please fill the fields correctly</h2>
				<label for="username" class="sr-only">Username</label> <input
					type="text" name="username" id="username" class="form-control"
					placeholder="Username" > 
				<label for="firstname" class="sr-only">First name</label> <input
					type="text" name="firstname" id="firstname" class="form-control"
					placeholder="First name" >
				<label for="lastname" class="sr-only">Last name</label> <input
					type="text" name="lastname" id="lastname" class="form-control"
					placeholder="Last name" >
				<label for="email" class="sr-only">Email</label> <input
					type="email" name="email" id="email" class="form-control"
					placeholder="Email address" >
				<label for="phonenumber" class="sr-only">Phone number</label> <input
					type="text" name="phonenumber" id="phonenumber"  class="form-control"
					placeholder="Phone number" > 
				<label for="inputEmail" class="sr-only">Image</label> <input
					type="url" name="image" id="inputEmail" class="form-control"
					placeholder="Image url" >
				<label
					for="password" class="sr-only">Password</label>
				 <input
					type="password" name="password" id="password"
					class="form-control" placeholder="Password" onChange="checkPasswordMatch();" >
					<label
					for="passwordagain" class="sr-only">Password again</label>
				 <input
					type="password" name="passwordagain" id="passwordagain"
					class="form-control" placeholder="Password again" onChange="checkPasswordMatch();" >
					
   					 <div class="registrationFormAlert" id="divCheckPasswordMatch"></div>
					
				
				
				<button class="btn btn-lg btn-primary btn-block" type="submit" id= "bt" name="bt" value = "sign-up" onclick="closeAdd()">Sign up</button>	
				<button class="btn btn-lg btn-primary btn-block" type="submit" id= "bt" name="bt"  onclick="closeAdd()">Cencel</button>	
			</form>
			
		</div>
		<div class="row" id= "del"  style="display:none";>
			<form class="form-signin" name = "myform" id= "myform"  action="<c:url value="/registration" ></c:url>" method="post" >

				<h2 class="form-signin-heading">Delete by ID</h2>
				<label for="id" class="sr-only">ID</label> <input
					type="text" name="id" id="id" class="form-control" > 							
				<button class="btn btn-lg btn-primary btn-block" type="submit" id= "bt" name="bt" value = "delete" onclick="closeDel()">Delete</button>	
				<button class="btn btn-lg btn-primary btn-block" type="submit" id= "bt" name="bt"  onclick="closeUpp()">Cencel</button>	
			</form>
			
		</div>
		<div class="row" id= "findBy"  style="display:none";>
			<form class="form-signin" name = "myform" id= "myform"  action="<c:url value="/registration" ></c:url>" method="post" >

				<h2 class="form-signin-heading">Delete by ID</h2>
				<label for="id" class="sr-only">ID</label> <input
					type="text" name="id" id="id" class="form-control" > 							
				<button class="btn btn-lg btn-primary btn-block" type="submit" id= "bt" name="bt" value = "delete" onclick="closeDel()">Delete</button>	
				<button class="btn btn-lg btn-primary btn-block" type="submit" id= "bt" name="bt"  onclick="closeUpp()">Cencel</button>	
			</form>
			
		</div>
		
<div class="row" id= "find"  style="display:none";>
			<form class="form-signin" name = "myform" id= "myform"  action="<c:url value="/registration" ></c:url>" method="post" >

				<h2 class="form-signin-heading">FInd by name</h2>
				<label for="id" class="sr-only">findByName</label> <input
					type="text"  id="findByName" class="form-control" > 							
				<button class="btn btn-lg btn-primary btn-block" type="submit" id= "bt" name="bt" value = "find" onclick="closeDel()">Find</button>	
				<button class="btn btn-lg btn-primary btn-block" type="submit" id= "bt" name="bt"  onclick="closeUpp()">Cencel</button>	
			</form>
			
		</div>
	</div>
	
	

<script type="text/javascript">

$.validator.addMethod('customphone', function (value, element) {
    return this.optional(element) || /^\+36(?:[0-9] ?){6,8}[0-9]$/.test(value);
}, "Please enter a valid phone number");
</script>



<script type="text/javascript">

        $("#myform").validate({
            rules: {
            	firstname: {
                    required: true,
                    maxlength: 30,
                    
                },
                lastname: {
                    required: true,
                    maxlength: 30,
                    
                },
                username: {
                    required: true,
                    maxlength: 30,
                    
                },
                image: {
                    required: true,
                    
                },
                email: {
                    required: true,
                    email: true
                },
                phonenumber:'customphone',
                
            },
            messages: {
                email: {
                    required: "Please enter a valid email address.",
                    email: "Invalid Email Address."
                },
                firstname: {
                    
                    maxlength: "The maximumm length is 30 char"
                    
                },
                lastname: {
                    
                	maxlength:"The maximumm length is 30 char"
                    
                },
                username: {
                    
                	maxlength: "The maximumm length is 30 char"
                    
                }
            	
            }
        });
        </script>
        <script type="text/javascript">
        function passwordsMatch(){
            return $('#password').val() == $('#passwordagain').val();
        }
</script>
<script type="text/javascript">
        $(document).ready(function () {
            $("#passwordagain").keyup(function(){
            	
                if(!passwordsMatch()){
                    $("#divCheckPasswordMatch").html("Passwords do not match!");
                   
                } else {
                    $("#divCheckPasswordMatch").html("Passwords match.");
                }
            });
            $("#password").keyup(function(){
                if(!passwordsMatch()){
                    $("#divCheckPasswordMatch").html("Passwords do not match!");
                    
                } else {
                    $("#divCheckPasswordMatch").html("Passwords match.");
                }
            });
           
            

            $('#myForm').submit(function(evt) {
               if(!passwordsMatch()){
                    evt.preventDefault();
                }
            });

        });

        </script>
        <script type="text/javascript">
        $(function () {
            $("#bt").click(function () {
                var password = $("#password").val();
                var confirmPassword = $("#passwordagain").val();
                if (password != confirmPassword) {
                    alert("Passwords do not match.");
                    return false;
                }
                if (password.length<8) {
                	$("#divCheckPasswordMatch").html("Password is too short");
                    return false;
                }
                return true;
            });
        });
    </script>
    
<script type="text/javascript">
function showAdd() {
	   document.getElementById('add').style.display = "block";
	}

function showFind() {
	   document.getElementById('find').style.display = "block";
	}

function showDel() {
	   document.getElementById('del').style.display = "block";
	}
function closeFind() {
	   document.getElementById('find').style.display = "none";
	}

function closeAdd() {
	   document.getElementById('add').style.display = "none";
	}
function closeDel() {
	   document.getElementById('del').style.display = "none";
	}
	
</script>


<button class="btn btn-lg btn-primary btn-block" type="submit" id= "bt" name="bt" onclick="showAdd(), closeDel(), closeFind()">Add</button></body>
<button class="btn btn-lg btn-primary btn-block" type="submit" id= "bt" name="bt" onclick="showDel(), closeAdd(), closeFind()">Delete</button></body>
<button class="btn btn-lg btn-primary btn-block" type="submit" id= "bt" name="bt" onclick="showFind(), closeAdd(), closeDel()">Search</button></body>
