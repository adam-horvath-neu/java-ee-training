<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Website CSS style -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/reg.css"/>" rel="stylesheet">

<title>Login Example - Registration</title>
</head>
<body>
	<div class="container">
		<div class="row main">
			<div class="main-login main-center">
				<h5>Login Example - Registration</h5>
				<form class="" method="post" action="UserController">
					<div class="form-group">
						<label for="username" class="cols-sm-2 control-label">Username</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
								<input type="text" class="form-control"	name="username" 
								id="username" placeholder="Enter your Username" />
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="cols-sm-2 control-label">Password</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
								<input type="password" class="form-control" name="password"
									id="password" placeholder="Enter your Password" />
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="confirm" class="cols-sm-2 control-label">Confirm Password</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-lock fa-lg" aria-hidden="true"></i></span> 
									<input type="password" class="form-control" name="confirm" 
									id="confirm" placeholder="Confirm your Password" />
							</div>
						</div>
					</div>
		            <div class="form-group">
						<label for="firstname" class="cols-sm-2 control-label">First name</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
								<input type="text" class="form-control"	name="firstname" 
								id="firstname" placeholder="Enter your First name" />
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="cols-sm-2 control-label">Last name</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
								<input type="text" class="form-control"	name="lastname" 
								id="lastname" placeholder="Enter your Last name" />
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="url" class="cols-sm-2 control-label">URL</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
								<input type="text" class="form-control"	name="url" 
								id="url" placeholder="Enter your Website" />
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="cols-sm-2 control-label">Your Email</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
								<input type="text" class="form-control" name="email" 
								id="email" placeholder="Enter your Email" />
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="phone" class="cols-sm-2 control-label">Your Phone</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
								<input type="text" class="form-control" name="phone" 
								id="phone" placeholder="Enter your Phone Number" />
							</div>
						</div>
					</div>
					<div class="form-group ">

							<input type="submit" value="Register" id="button" class="btn btn-primary btn-lg btn-block login-button"/>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</body>
</html>