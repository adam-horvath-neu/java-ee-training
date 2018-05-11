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

a{
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
				"data" : "firstname"
			}, {
				"data" : "lastname"
			},
			
			 {
				"data" : "email"
			},
			
			 {
				"data" : "phone"
			},
			
			 {
				"data" : "url"
			},
			 {
				"data" : "password"
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
						url : 'registration',
						data : {
							op : 'add',
							username : $('#username').val(),
							firstname : $('#firstname').val(),
							lastname : $('#lastname').val(),
							phone : $('#phone').val(),
							email : $('#email').val(),
							url : $('#url').val(),
							password : $('#password').val(),
							password2 : $('#password2').val()
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
				url : 'Registration',
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
					if($)
					$.ajax({
						url : 'registration',
						type: 'POST'
						data : {
							op : 'update',
							id : $('#id').val(),
							username : $('#uusername').val(),
							firstname : $('#ufirstname').val(),
							lastname : $('#ulastname').val(),
							phone : $('#uemail').val(),
							url : $('#uurl').val(),
							password : $('#upassword').val(),
							password2 : $('#upassword2').val()
							
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
			var phone = $(cells[4]).html();
			var email = $(cells[5]).html();
			var url = $(cells[6]).html();
			$('#uusername').val(username);
			$('#ufirstname').val(firstname);
			$('#ulastname').val(lastname);
			$('#uphone').val(phone);
			$('#uemail').val(email);
			$('#uurl').val(url);
			$('#id').val(id);
			
			
			

			event.preventDefault();
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
										<th>Firstname</th>
										<th>Lastname</th>
                                        <th>Phone</th>
                                        <th>Email</th>
                                        <th>Url</th>
                                        <th>Password</th>
                                        <th>Lastname</th>
									</tr>
								</thead>


							</table></td>
					</tr>
					<tr>
						<td><a href="#" id="dialog-link"
							class="ui-state-default ui-corner-all"><span
								class="ui-icon ui-icon-newwin"></span>Add</a>
						<td><td>
						<a href="#" id="delete"
							class="ui-state-default ui-corner-all"><span
								class="ui-icon ui-icon-newwin"></span>Delete</a><td>
						<td><a href="#" id="update"
							class="ui-state-default ui-corner-all"><span
								class="ui-icon ui-icon-newwin"></span>Update</a>
						<td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	


</body>
</html>
