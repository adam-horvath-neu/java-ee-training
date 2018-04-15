<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<jsp:include page="header.jsp"></jsp:include>
<script src="resources/datatable/js/jquery.dataTables.js"></script>
<link href="resources/datatable/css/jquery.dataTables_themeroller.css"
	rel="stylesheet">
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
				"data" : "job"
			}, {
				"data" : "age"
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
							job : $('#job').val(),
							age : $('#age').val(),
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
						<td><table id="example" class="display" cellspacing="0"
								width="100%" /><thead>
									<tr>
										<th>ID</th>
										<th>Name</th>
										<th>job</th>
										<th>Age</th>
									</tr>
								</thead>

								<tfoot>
									<tr>
										<th>ID</th>
										<th>Name</th>
										<th>job</th>
										<th>Age</th>
									</tr>
								</tfoot>

								<tbody>
									<tr>
										<td>0</td>
										<td>0</td>
										<td>0</td>
										<td>0</td>

									</tr>
									<tr>
										<td>1</td>
										<td>1</td>
										<td>1</td>
										<td>1</td>
									</tr>
									<tr>
										<td>2</td>
										<td>2</td>
										<td>2</td>
										<td>2</td>
									</tr>
									<tr>
										<td>3</td>
										<td>3</td>
										<td>3</td>
										<td>3</td>
									</tr>
									<tr>
										<td>4</td>
										<td>4</td>
										<td>4</td>
										<td>4</td>
									</tr>
									<tr>
										<td>5</td>
										<td>5</td>
										<td>5</td>
										<td>5</td>
									</tr>
									<tr>
										<td>6</td>
										<td>6</td>
										<td>6</td>
										<td>6</td>
									</tr>
									<tr>
										<td>7</td>
										<td>7</td>
										<td>7</td>
										<td>7</td>
									</tr>
									<tr>
										<td>8</td>
										<td>8</td>
										<td>8</td>
										<td>8</td>
									</tr>
									<tr>
										<td>9</td>
										<td>9</td>
										<td>9</td>
										<td>9</td>
									</tr>
									<tr>
										<td>10</td>
										<td>10</td>
										<td>10</td>
										<td>10</td>
									</tr>
									<tr>
										<td>11</td>
										<td>11</td>
										<td>11</td>
										<td>11</td>
									</tr>
									<tr>
										<td>12</td>
										<td>12</td>
										<td>12</td>
										<td>12</td>
									</tr>
									<tr>
										<td>13</td>
										<td>13</td>
										<td>13</td>
										<td>13</td>
									</tr>
									<tr>
										<td>14</td>
										<td>14</td>
										<td>14</td>
										<td>14</td>
									</tr>
									<tr>
										<td>15</td>
										<td>15</td>
										<td>15</td>
										<td>15</td>
									</tr>
								</tbody>
							</table> <script>
								$(document).ready(function() {
									$('#example').DataTable({
										"bJQueryUI" : true
									});
								});
							</script></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	 </script>
						<a href="#" id="dialog-link"
		class="ui-state-default ui-corner-all"><span
		class="ui-icon ui-icon-newwin"></span>Add</a>
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