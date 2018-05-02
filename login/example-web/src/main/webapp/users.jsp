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
<title>Insert title here</title>
</head>
<body>

	<div class="container">

		<!-- 				<table> -->
		<%-- 					<c:forEach items="${resultList}" var="record"> --%>
		<!-- 						<tr> -->
		<%-- 							<td>${record.getUsername()}</td> --%>
		<!-- 						</tr> -->
		<%-- 					</c:forEach> --%>
		<!-- 				</table> -->
		<%-- 				<form action="<c:url value="/users" ></c:url>" method="POST"> --%>
		<!-- 					<input type="text" name="searchName"/> -->
		<!-- 					<button type="submit" class="btn btn-success">Search</button> -->
		<!-- 				</form> -->
		<div class="col-sm-12">
			<div class="text-right">
				<a href="<c:url value="/registration" ></c:url>">
					<button class="btn btn-default">Create new</button>
				</a>

			</div>
		</div>
		<div class="col-sm-12">
			<table class="table table-striped table-responsive">
				<thead>
					<tr>
						<th>Username</th>
						<th>Image</th>
						<th>First Name</th>
						<th>Last name</th>
						<th>Email</th>
						<th>Phone</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${resultList}" var="record">
						<tr>
							<td>${record.getUsername()}</td>
							<td>${record.getUrl()}</td>
							<td>${record.getFirstname()}</td>
							<td>${record.getLastname()}</td>
							<td>${record.getEmail()}</td>
							<td>${record.getPhone()}</td>
							<td><button id="${record.getId()}"
									class="btn btn-danger delete-button">delete</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
		integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
		integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
		crossorigin="anonymous"></script>
	<script>
		$('document').ready(function() {
			$('.delete-button').click(function(e) {
				console.log(this.id);
				$.ajax({
					type : 'POST',
					url : 'users',
					data : {
						id : this.id,
						op : 'delete'
					},
					success : function(e) {
						location.reload();
					}
				});
			});
		});
	</script>
</body>


</html>