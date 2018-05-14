<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">
<link href="<c:url value="/resources/css/update.css"/>" rel="stylesheet">
<title>Login</title>
</head>
<body>

	<div class="container">
	<div class="button-box col-lg-12">
			<form action="Users" method="GET">
				<button type="submit" class="btn btn-success">List Users</button>
			</form>
				<a href="<c:url value="/registration.jsp" ></c:url>">
					<button class="btn btn-default">Add New User</button>
				</a>
		</div>
		<div class="col-sm-12">
			<table class="table table-hover table-responsive">
				<thead>
					<tr>
						<th>User Name</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Image</th>
						<th>Email</th>
						<th>Phone</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${resultList}" var="record">
						<tr>
							<td>${record.getUsername()}</td>
							<td>${record.getFirstName()}</td>
							<td>${record.getLastName()}</td>
							<td><img src=${record.getPictureUrl() } height="60"
								width="60"></td>
							<td>${record.getUserEmail()}</td>
							<td>${record.getPhoneNumber()}</td>
							<td><button id="${record.getId()}"
									class="btn btn-danger delete-button">Delete</button></td>
							<td><button id="updatevalue" value="${record.getId()}"
									class="btn btn-primary update-button" onclick="div_show()">Update</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>

	<div id="abc">
		<!-- Popup Div Starts Here -->
		<div id="popupContact">
			<!-- Contact Us Form -->
			<form action="#" id="updateform" method="post" name="form">
				<img id="close" src="images/3.png" onclick="div_hide()">
				<h2 id="updateh2">Update User</h2>
				<hr id="updatehr">
				<input class="updateinputs" id="user_name" name="user_name" placeholder="Username" type="text"> 
				<input class="updateinputs" id="first_name" name="first_name" placeholder="First Name" type="text"> 
				<input class="updateinputs" id="last_name" name="last_name" placeholder="Last Name" type="text"> 
				<input class="updateinputs" id="user_email" name="user_email" placeholder="Email" type="text"> 
				<input class="updateinputs" id="phone_number" name="phone_number" placeholder="Phone Number" type="text"> 
				<input class="updateinputs" id="profile_picture" name="profile_picture" placeholder="Picture Url" type="text"> 
				<a id="updatelink" href="javascript:%20check_empty()">Update</a>
			</form>
		</div>
		<!-- Popup Div Ends Here -->
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
	<script>
		$('document').ready(function() {
			$('.delete-button').click(function(e) {
				$.ajax({
					type : 'POST',
					url : 'Users',
					data : {
						id : this.id,
						operation : 'delete'
					},
					success : function(e) {
						location.reload();
					}
				});
			});
		});
	</script>
	<script>
	$(document).ready(function(){
	    $('#updatelink').on('click', function(){
	    	$.ajax({
				type : 'POST',
				url : 'Users',
				data : {
					operation : 'update',
					id : $("#updatevalue").val(),
					user_name : $('input[name="user_name"]').val(),
					first_name : $('input[name="first_name"]').val(),
					last_name : $('input[name="last_name"]').val(),
					user_email : $('input[name="user_email"]').val(),
					profile_picture : $('input[name="profile_picture"]').val(),
					phone_number:  $('input[name="phone_number"]').val()
				},
				success : function(e) {
					location.reload();
				}
			});
	    });
	});
	</script>
	<script>
		function check_empty() {
			if (document.getElementById('user_name').value == "" ||
					 document.getElementById('first_name').value == "" ||
					  document.getElementById('last_name').value == "" ||
					  document.getElementById('user_email').value == "" ||
					   document.getElementById('last_name').value == "" ||
					    document.getElementById('profile_picture').value == "") {
				alert("Fill All Fields !");
			} else {
			}
		}
	</script>
	<script>
		//Function To Display Popup
		function div_show() {
			document.getElementById('abc').style.display = "block";
		}
	</script>
	<script>
		//Function to Hide Popup
		function div_hide() {
			document.getElementById('abc').style.display = "none";
		}
	</script>
</body>



</html>