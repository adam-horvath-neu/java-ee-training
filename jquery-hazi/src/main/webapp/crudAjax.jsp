<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Házi</title>
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
			"ajax" : "DataServlet?op=get",
			"columns" : [ {
				"data" : "id"
			}, {
				"data" : "name"
			}, {
				"data" : "age"
			}, {
				"data" : "job"
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
						type : "POST",
						url : 'DataServlet',
						data : {
							op : 'add',
							name : $('#name').val(),
							age : $('#age').val(),
							job : $('#job').val(),
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
										<th>Name</th>
										<th>Age</th>
										<th>Job</th>

									</tr>
								</thead>


							</table></td>
					</tr>
					<tr>
						<td><a href="#" id="dialog-link"
							class="ui-state-default ui-corner-all"><span
								class="ui-icon ui-icon-newwin"></span>Add</a>
						<td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	<div id="dialog" title="Dialog Title">
		<table>

			<tr>
				<td>Name</td>
				<td><input id="name" type="text"></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input id="age" type="text"></td>
			</tr>
			<tr>
				<td>Job</td>
				<td><input id="job" type="text"></td>
			</tr>

		</table>

	</div>

	
</body>
</html>