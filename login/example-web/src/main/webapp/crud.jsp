<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<script language="JavaScript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>

<link
	href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css"
	rel="stylesheet">
<link href="resources/jqueryui/jquery-ui.css" rel="stylesheet">



<style>
.demoHeaders {
	margin-top: 2em;
}

a {
	padding: .4em 1em .4em 20px;
	text-decoration: none;
	position: relative;
}

a span.ui-icon {
	margin: 0 5px 0 0;
	position: absolute;
	left: .2em;
	top: 50%;
	margin-top: -8px;
}

#icons {
	margin: 0;
	padding: 0;
}

#icons li {
	margin: 2px;
	position: relative;
	padding: 4px 0;
	cursor: pointer;
	float: left;
	list-style: none;
}

#icons span.ui-icon {
	float: left;
	margin: 0 4px;
}

.fakewindowcontain .ui-widget-overlay {
	position: absolute;
}

select {
	width: 200px;
}
</style>
<script>
	function create() {
		table = $('#example').dataTable({
			"bJQueryUI" : true,
			"ajax" : "DataServlet?op=get",

			"columns" : [ {
				"data" : "id"
			}, {
				"data" : "username"
			}, {
				"data" : "firstname"
			}, {
				"data" : "lastname"
			}, {
				"data" : "email"
			}, {
				"data" : "phone"
			}

			]
		});

		$('#example tbody tr').click(function() {
			console.log(this);
			if ($(this).hasClass('selected')) {
				$(this).removeClass('selected');
			} else {
				table.$('tr.selected').removeClass('selected');
				$(this).addClass('selected');
			}
		});

	}

	jQuery(document).ready(function($) {
		create();

		$("#dialog").dialog({
			autoOpen : false,
			width : 400,
			buttons : [ {
				text : "Save",
				click : function() {
					$.ajax({
						url : 'DataServlet',
						type : 'POST',
						data : {
							op : 'add',
							username : $('#username').val(),
							password : $('#password').val(),
							password2 : $('#password2').val(),
							firstname : $('#firstname').val(),
							lastname : $('#lastname').val(),
							email : $('#email').val(),
							phone : $('#phone').val(),
						},
						success : function(data) {
							$("#dialog").dialog("close");
							$('#example').dataTable().fnDestroy();
							create();
						},
						dataType : "html"
					});

				}
			}, {
				text : "Cancel",
				click : function() {
					$(this).dialog("close");
				}
			} ]
		});

		$("#dialog-link").click(function(event) {
			$("#dialog").dialog("open");
			event.preventDefault();
		});

		$("#delete").click(function(event) {

			var id = $($('#example tr.selected td')[0]).html();

			$.ajax({
				url : 'DataServlet',
				type : 'Post',
				data : {
					op : 'del',
					id : id,

				},
				success : function(data) {
					$("#udialog").dialog("close");
					$('#example').dataTable().fnDestroy();
					create();
				},
				dataType : "html"
			});

		});

		$("#udialog").dialog({
			autoOpen : false,
			width : 400,
			buttons : [ {
				text : "Update",
				click : function() {
					$.ajax({
						url : 'DataServlet',
						type : 'POST',
						data : {
							op : 'update',
							id : $('#id').val(),
							username : $('#uusername').val(),
							firstname : $('#ufirstname').val(),
							lastname : $('#ulastname').val(),
							email : $('#uemail').val(),
							phone : $('#uphone').val(),
						},
						success : function(data) {
							$("#udialog").dialog("close");
							$('#example').dataTable().fnDestroy();
							create();
						},
						dataType : "html"
					});

				}
			}, {
				text : "Cancel",
				click : function() {
					$(this).dialog("close");
				}
			} ]
		});

		$("#update").click(function(event) {
			$("#udialog").dialog("open");
			var cells = $('#example tr.selected td');
			var id = $(cells[0]).html();
			var username = $(cells[1]).html();
			var firstname = $(cells[2]).html();
			var lastname = $(cells[3]).html();
			var email = $(cells[4]).html();
			var phone = $(cells[5]).html();
			$('#uusername').val(username);
			$('#ufirstname').val(firstname);
			$('#uusername').val(lastname);
			$('#uemail').val(email);
			$('#uphone').val(phone);
			$('#id').val(id);

			event.preventDefault();
		});

	});
</script>

</head>
<body>
	<table>

		<tr>
			<td>
				<table>
					<tr>
						<td colspan="3"><table id="example" class="display"
								cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>ID</th>
										<th>Username</th>
										<th>Firstname</th>
										<th>Lastname</th>
										<th>Email</th>
										<th>Phone</th>


									</tr>
								</thead>


							</table></td>
					</tr>
					<tr>
						<td><a href="#" id="dialog-link"
							class="ui-state-default ui-corner-all"><span
								class="ui-icon ui-icon-newwin"></span>Add</a>
						<td>
						<td><a href="#" id="delete"
							class="ui-state-default ui-corner-all"><span
								class="ui-icon ui-icon-newwin"></span>Delete</a>
						<td>
						<td><a href="#" id="update"
							class="ui-state-default ui-corner-all"><span
								class="ui-icon ui-icon-newwin"></span>Update</a>
						<td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	<div id="dialog" title="Dialog Title">
		<table>

			<tr>
				<td>Username</td>
				<td><input id="username" type="text"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input id="password" type="password"></td>
			</tr>
			<tr>
				<td>PasswordAgain</td>
				<td><input id="password2" type="password"></td>
			</tr>
			<tr>
				<td>Firstname</td>
				<td><input id="firstname" type="text"></td>
			</tr>
			<tr>
				<td>Lastname</td>
				<td><input id="lastname" type="text"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input id="email" type="text"></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input id="phone" type="text"></td>
			</tr>

		</table>

	</div>

	<div id="udialog" title="Dialog Title">
		<table>
			<input id="id" type="hidden">
			<tr>
				<td>Username</td>
				<td><input id="uusername" type="text" readonly="readonly"></td>
			</tr>
			<tr>
				<td>Firstname</td>
				<td><input id="ufirstname" type="text"></td>
			</tr>
			<tr>
				<td>Lastname</td>
				<td><input id="ulastname" type="text"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input id="uemail" type="text"></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input id="uphone" type="text"></td>
			</tr>

		</table>

	</div>

</body>
</html>
