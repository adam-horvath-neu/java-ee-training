<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Users</title>
<script type="text/javascript">
//  $(document).ready(function(){
// 	 $('#refresh').click(function(){
// 		 $.ajax({
// 				url: "index",
// 				type: "POST",
// 				data: {action: "action"},
// 				success: function(){$("html").ajax.reload();}
// 		 });
// 		 $('p').html('almaaaaa');
// 	 })
//  });
</script>
</head>
<body>
    <table id="table" border=1>
        <thead>
            <tr>
                <th>User Id</th>
                <th>Username</th>
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
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.username}" /></td>
                    <td><c:out value="${user.firstname}" /></td>
                    <td><c:out value="${user.lastname}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.phone}" /></td>
                    <td><a href="<c:out value="${user.url}" />" target="_blank">URL</a></td>
                    <td> <button class="update" type="button">Update</button></td>
                    <td> <button class="delete" type="button">Delete</button></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
<form action="index" method="post" >
    <button id="refresh" type="submit">Refresh table</button>
</form>
<form action="registration.jsp" method="post">
<label>Username</label><input id="username" value=""><br>
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
    
<script type="text/javascript">
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
	 });
	 $('.update').click(function(){
		 $('#username').val();
		 $('p').html('lehelyezve');
	 });
 });
</script>
</body>
</html>