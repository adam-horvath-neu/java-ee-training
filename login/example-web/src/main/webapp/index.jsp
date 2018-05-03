<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Show All Users</title>
</head>
<body>
    <table id="table" border=1>
        <thead>
            <tr>
           		<th>ID</th>
                <th>Username</th>
                <th>Password</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Picture</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td id="<c:out value="${user.id}" />1"><c:out value="${user.id}" /></td>
                    <td id="<c:out value="${user.id}" />2"><c:out value="${user.username}" /></td>
                    <td id="<c:out value="${user.id}" />3"><c:out value="${user.password}" /></td>
                    <td id="<c:out value="${user.id}" />4"><c:out value="${user.firstname}" /></td>
                    <td id="<c:out value="${user.id}" />5"><c:out value="${user.lastname}" /></td>
                    <td id="<c:out value="${user.id}" />6"><c:out value="${user.email}" /></td>
                    <td id="<c:out value="${user.id}" />7"><c:out value="${user.phone}" /></td>
                    <td id="<c:out value="${user.id}" />8">	<a href="<c:out value="${user.url}" />" target="_blank">URL</a>	</td>
                    <td> <button id="<c:out value="${user.id}" />" class="update" type="button">Update</button></td>
                    <td> <button id="<c:out value="${user.id}" />" class="delete" type="button">Delete</button></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
<form action="index" method="post" >
    <button id="refresh" type="submit">Refresh table</button>
</form>
<form action="registration.jsp" method="post">
<input id="id" type="hidden"><br>
<label>Username</label><input id="username"><br>
<label>Password</label><input id="password"><br>
<label>FirstName</label><input id="firstname"><br>
<label>LastName</label><input id="lastname"><br>
<label>Email</label><input id="email"><br>
<label>Phone</label><input id="phone"><br>
<label>URL</label><input id="url"><br>
   <button id="add" type="button">Add</button>
    <button id="modify" type="button">Modify</button>
    </form>
    <p></p>
    
<script>

 $(document).ready(function(){
	 $('#add').click(function(){
		 $.ajax({
				url: "index",
				type: "POST",
				data: {
					action: "add",
					username: $('#username').val(),
					password: $('#password').val(),
					firstname: $('#firstname').val(),
					lastname: $('#lastname').val(),
					email: $('#email').val(),
					phone: $('#phone').val(),
					picture: $('#url').val()
					},
				success: function(){$('p').html('added');}
		 });
		 $('#refresh').trigger("click");
	 });
	 
	 
	 $('#modify').click(function(){
		 $.ajax({
				url: "index",
				type: "POST",
				data: {
					action: "modify",
					id: $('#id').val(),
					username: $('#username').val(),
					password: $('#password').val(),
					firstname: $('#firstname').val(),
					lastname: $('#lastname').val(),
					email: $('#email').val(),
					phone: $('#phone').val(),
					picture: $('#url').val()
					},
				success: function(){$('p').html('modified');}
		 });
		 $('#refresh').trigger("click");
	 });
	 
	 $('.update').click(function(){
 		 var itemid = ($(this).attr('id'));
 		 var nr = 1;
 		 itemid = '#'+itemid;
 		 
 		 $('#id').val(
				 ($(itemid+nr).text())
		 );
		 nr++;
		 $('#username').val(
				 ($(itemid+nr).text())
		 );
		 nr++;
		 $('#password').val(
				 ($(itemid+nr).text())
		 );
		 nr++;
		 $('#firstname').val(
				 ($(itemid+nr).text())
		 );
		 nr++;
		 $('#lastname').val(
				 ($(itemid+nr).text())
		 );
		 nr++;
		 $('#email').val(
				 ($(itemid+nr).text())
		 );
		 nr++;
		 $('#phone').val(
				 ($(itemid+nr).text())
		 );
		 nr++;
		 $('#url').val(
				 ($(itemid+nr+' a').attr('href'))
		 );
		 nr++;
	 });
	 
	 $('.delete').click(function(){
		 var itemid = ($(this).attr('id'));
 		 itemid = '#'+itemid;
 		 var idd;
 		 
 		 idd = $(itemid+'1').text();
		 $.ajax({
				url: "index",
				type: "POST",
				data: {
					action: "delete",
					id: idd,
					},
				success: function(){$('p').html('deleted');}
		 });
		 $('#refresh').trigger("click");
 });
	 
 });
</script>
</body>
</html>