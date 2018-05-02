<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<jsp:include page="header.jsp"></jsp:include>
<script src="resources/datatable/js/jquery.dataTables.js"></script>
<link href="resources/datatable/css/jquery.dataTables_themeroller.css"
	rel="stylesheet">
	

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
		"ajax" : "registration?op=get",
		"columns" : [ {
			"data" : "id"
		}, {
			"data" : "username"
		}, {
			"data" : "password"
		}, {
			"data" : "firstname"
		}, {
			"data" : "lastname"
		}, {
			"data" : "email"
		}, {
			"data" : "phone"
		}, {
			"data" : "url"
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

$(document).ready(function() {
				create();

				$("#dialog").dialog({
					autoOpen : false,
					width : 400,
					buttons : [ {
						text : "Save",
						click : function() {
							$.ajax({
								type: 'POST',
								url : 'registration',
								data : {
									op : 'add',
									username : $('#username').val(),
									password : $('#password').val(),
									firstname : $('#firstname').val(),
									lastname : $('#lastname').val(),
									email : $('#email').val(),
									phone : $('#phone').val(),
									url : $('#url').val(),
									
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
					$("#date").datepicker({
						dateFormat : "yy.mm.dd"
					});
					event.preventDefault();
				});

				var table = $('#example').DataTable();
				$('#example tbody').on('click', 'tr', function() {
					if ($(this).hasClass('selected')) {
						$(this).removeClass('selected');
					} else {
						table.$('tr.selected').removeClass('selected');
						$(this).addClass('selected');
					}
				});
				
				
				
				$('#delete').click(function() {
					var id = $($('#example tr.selected td')[6]).html();
					$.ajax({
						url : 'registration',
						type : 'POST',
						data : {
							op : 'del',
							did : id,
						},
						success : function(data) {
							$('#example').dataTable().fnDestroy();
							create();
						},
						dataType : "html"
					});
				});
				
							
					
				$("#update-dialog").dialog({
						autoOpen : false,
						width : 400,
						buttons : [ {
							text : "Update",
							click : function() {
								$.ajax({
									type: 'POST',
									url : 'registration',
									data : {
										op : 'add',
										username : $('#username-up').val(),
										password : $('#password-up').val(),
										firstname : $('#firstname-up').val(),
										lastname : $('#lastname-up').val(),
										email : $('#email-up').val(),
										phone : $('#phone-up').val(),
										url : $('#url-up').val(),
										
									},
									success : function(data) {
										$("#update-dialog").dialog("close");
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
				});	
			
</script>

</head>
<body>


	<table>

		<tr>
			<td valign="top"><jsp:include page="menu.jsp"></jsp:include></td>
			<td>
				<table>
					<tr>
						<td colspan="3"><table id="example" class="display"
								cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>ID</th>
										<th>Username</th>
										<th>Password</th>
										<th>Firstname</th>
										<th>Lastname</th>
										<th>Email address</th>
										<th>Phone number</th>
										<th>URL</th>

									</tr>
								</thead>

							</table></td>
					</tr>
					<tr>
						<td><a href="#" id="dialog-link"
							class="ui-state-default ui-corner-all"><span
								class="ui-icon ui-icon-newwin"></span> Add </a>
						<td>
						<td><a href="#" id="update-dialog"
							class="ui-state-default ui-corner-all"><span
								class="ui-icon ui-icon-newwin"></span> Update </a>
						<td>
						<td><a href="#" id="delete"
							class="ui-state-default ui-corner-all"><span
								class="ui-icon ui-icon-newwin"></span> Delete </a>
						<td>
					</tr>
				</table>
			</td>
		</tr>
	</table>


<div id="dialog" title="Registration">
		<form id="myform">
			<table>
				<tr>
					<td>Username</td>
					<td><input id="username" type="text" name="username"></td>
				</tr>
				<tr>
					<td>Firstname</td>
					<td><input id="firstname" type="text" name="firstname"></td>
				</tr>
				<tr>
					<td>Lastname</td>
					<td><input id="lastname" type="text" name="lastname"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input id="password" type="password" name="password"></td>
				</tr>
				<tr>
					<td>Password again</td>
					<td><input id="password2" type="password" name="password2" "></td>
				</tr>
				<tr>
					<td>Email address</td>
					<td><input id="email" type="text" name="email"></td>
				</tr>
				<tr>
					<td>Phone number</td>
					<td><input id="phone" type="text" name="phone"></td>
				</tr>
			</table>
		</form>
	</div>



	<div id="update-dialog" title="Update">
	<form>	
		<table>
			
			<tr>
				<td>Username</td>
				<td><input id="username-up" type="text"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input id="password-up" type="text"></td>
			</tr>
			<tr>
				<td>Password again</td>
				<td><input id="password2-up" type="password" name="password2" "></td>
			</tr>
			<tr>
				<td>Firstname</td>
				<td><input id="firstname-up" type="text"></td>
			</tr>
			<tr>
				<td>Lastname</td>
				<td><input id="lastname-up" type="text"></td>
			</tr>
			<tr>
				<td>Email address</td>
				<td><input id="email-up" type="text"></td>
			</tr>
			<tr>
				<td>Phone number</td>
				<td><input id="phone-up" type="text"></td>
			</tr>
			<tr>
				<td>URL</td>
				<td><input id="url-up" type="text"></td>
			</tr>

		</table>
	</form>	
	</div>
								

</body>
</html>
