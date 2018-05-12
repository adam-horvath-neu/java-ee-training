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
	
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.7/jquery.validate.min.js"></script>
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

			"columns" : [  {
				"data" : "username"
			}, {
				"data" : "password"
			}, {
				"data" : "firstname"
			},  {
				"data" : "lastname"
			}, {
				"data" : "email"
			}, {
				"data" : "phone"
			}, {
				"data" : "id"
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
			modal: true,
			buttons : [ {
				
				text : "Save",
				click : function() {
					if($('#myform').valid()){
					$.ajax({
						url : 'registration',
						type : 'POST',
						data : {
							op : 'add',
							username : $('#username').val(),
							firstname : $('#firstname').val(),
							lastname : $('#lastname').val(),
							phone : $('#phone').val(),
							email : $('#email').val(),
							password : $('#password').val(),
							passwordagain : $('#passwordagain').val(),
							
						},
						success : function(data) {
							
							$("#dialog").dialog("close");
							$('#example').dataTable().fnDestroy();
							create();
						},
						dataType : "html"
					});
					 
					$( this ).dialog( 'close' );}
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
		

		
		    var table = $('#example').DataTable();
		    
		    $('#example tbody').on( 'click', 'tr', function () {
		  		    	
		        if ( $(this).hasClass('selected') ) {
		            $(this).removeClass('selected');		            
		        }
		        else {
		            table.$('tr.selected').removeClass('selected');
		            $(this).addClass('selected');		            
		        }		    		        
		    } );
		    
		 
		    
		    $('#delete').click( function () {		       
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
		    } );
		
		
		
		$("#udialog").dialog({
			autoOpen : false,
			width : 400,
			modal: true,
			buttons : [ {
				text : "Update",
				click : function() {
					if($('#myform2').valid()){
					$.ajax({
						url : 'registration',
						type : 'POST',
						data : {
							op : 'update',
							username : $('#uusername').val(),
							firstname : $('#ufirstname').val(),
							lastname : $('#ulastname').val(),
							phone : $('#uphone').val(),
							email : $('#uemail').val(),
							password : $('#upassword').val(),
							passwordagain : $('#upasswordagain').val()
						},
						success : function(data) {
							$("#udialog").dialog("close");
							$('#example').dataTable().fnDestroy();
							create();
						},
						dataType : "html"
					});
					$( this ).dialog( 'close' );}
					

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
			var id = $(cells[6]).html();
			var username = $(cells[0]).html();
			var firstname = $(cells[2]).html();
			var lastname = $(cells[3]).html();
			var email = $(cells[4]).html();
			var password = $(cells[1]).html();
			var passwordagain= $(cells[1]).html();
			var phone = $(cells[5]).html();
			$('#uusername').val(username);
			$('#ufirstname').val(firstname);
			$('#ulastname').val(lastname);
			$('#uphone').val(phone);
			$('#uemail').val(email);
			$('#upassword').val(password);
			$('#upasswordagain').val(passwordagain);
			$('#id').val(id);
			
			event.preventDefault();
		});
		
		
		
		 $("#myform").validate({
	            rules: {
	            	
	            	firstname: {
	                    required: true,
	                    maxlength: 30,
	                    
	                },
	                lastname: {
	                    required: true,
	                    maxlength: 30,
	                    
	                },
	                username: {
	                    required: true,
	                    maxlength: 30,
	                    
	                },
	                email: {
	                    required: true,
	                    email: true
	                },
	                 phone:'customphone',
	            	   
	            },
	            messages: {
	                email: {
	                    required: "Please enter a valid email address.",
	                    email: "Invalid Email Address."
	                },
	                firstname: {
	                    
	                    maxlength: "The maximumm length is 30 char"
	                    
	                },
	                lastname: {
	                    
	                	maxlength:"The maximumm length is 30 char"
	                    
	                },
	                username: {
	                    
	                	maxlength: "The maximumm length is 30 char"
	                    
	                }
	            	
	            },
	            
	            submitHandler: function(form) { 
	                return false;
	            },
	            invalidHandler: function() { 
	            	alert('not valid data given');
	            }
	        });
		 
		 $("#myform2").validate({
	            rules: {
	            	
	            	firstname: {
	                    required: true,
	                    maxlength: 30,
	                    
	                },
	                lastname: {
	                    required: true,
	                    maxlength: 30,
	                    
	                },
	                username: {
	                    required: true,
	                    maxlength: 30,
	                    
	                },
	                email: {
	                    required: true,
	                    email: true
	                },
	                 phone:'customphone',
	            	   
	            },
	            messages: {
	                email: {
	                    required: "Please enter a valid email address.",
	                    email: "Invalid Email Address."
	                },
	                firstname: {
	                    
	                    maxlength: "The maximumm length is 30 char"
	                    
	                },
	                lastname: {
	                    
	                	maxlength:"The maximumm length is 30 char"
	                    
	                },
	                username: {
	                    
	                	maxlength: "The maximumm length is 30 char"
	                    
	                }
	            	
	            },
	            
	            submitHandler: function(form) { 
	                return false;
	            },
	            invalidHandler: function() { 
	            	alert('not valid data given');
	            }
	        });
		 

		 $.validator.addMethod('customphone', function (value, element) {
		     return this.optional(element) || /^\+36(?:[0-9] ?){6,8}[0-9]$/.test(value);
		 }, "Please enter a valid phone number");
		 
		 
		 function passwordsMatch(){
	            return $('#password').val() == $('#passwordagain').val();
	        }
		 
	       $("#passwordagain").keyup(function(){
           	
               if(!passwordsMatch()){
                   $("#divCheckPasswordMatch").html("Passwords do not match!");
                  
               } else {
                   $("#divCheckPasswordMatch").html("Passwords match.");
               }
           });
           $("#password").keyup(function(){
               if(!passwordsMatch()){
                   $("#divCheckPasswordMatch").html("Passwords do not match!");
                   
               } else {
                   $("#divCheckPasswordMatch").html("Passwords match.");
               }
           });
           
           
           
  		 function passwordsUpdateMatch(){
	            return $('#upassword').val() == $('#upasswordagain').val();
	        }
		 
	       $("#upasswordagain").keyup(function(){
        	
            if(!passwordsUpdateMatch()){
                $("#divCheckPasswordMatch2").html("Passwords do not match!");
               
            } else {
                $("#divCheckPasswordMatch2").html("Passwords match.");
            }
        });
        $("#upassword").keyup(function(){
            if(!passwordsUpdateMatch()){
                $("#divCheckPasswordMatch2").html("Passwords do not match!");
                
            } else {
                $("#divCheckPasswordMatch2").html("Passwords match.");
            }
        });
          
           

           $('#myform').submit(function(evt) {
              if(!passwordsMatch()){
                   evt.preventDefault();
               }
           });
           $('#myform2').submit(function(evt) {
               if(!passwordsMatch()){
                    evt.preventDefault();
                }
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
										
										<th>UserName</th>
										<th>Password</th>
										<th>Firstname</th>
										
										<th>Lastname</th>
										
										<th>Email</th>
										<th>Phone</th>
										<th>ID</th>

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
	

	<div id="dialog" title="Dialog Title">
	<form id = "myform" >
		<table>

			<tr>
				<td>Username</td>
				<td><input id="username" type="text" name= "username"></td>
			</tr>
			<tr>
				<td>Firstname</td>
				<td><input id="firstname" type="text" name= "firstname"></td>
			</tr>
			<tr>
				<td>Lastname</td>
				<td><input id="lastname" type="text" name= "lastname"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input id="password" type="password" name= "password" onChange="checkPasswordMatch();"></td>
			</tr>
			<tr>
				<td>Password again</td>
				<td><input id="passwordagain" type="password" name= "passwordagain" onChange="checkPasswordMatch();"></td>
				<div class="registrationFormAlert" id="divCheckPasswordMatch"></div>
			</tr>
			<tr>
				<td>Email</td>
				<td><input id="email" type="text" name= "email"></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input id="phone" type="text" name= "phone"></td>
			</tr>

		</table>
</form>
	</div>
	


	<div id="udialog" title="Dialog Title">
	<form id = "myform2" >
		<table>
<input id="id" type="hidden">
			<tr>
				<td>Username</td>
				<td><input id="uusername" type="text" disabled></td>
			</tr>
			<tr>
				<td>Firstname</td>
				<td><input id="ufirstname" type="text" name= "firstname"></td>
			</tr>
			<tr>
				<td>Lastname</td>
				<td><input id="ulastname" type="text" name= "lastname"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input id="upassword" type="password" name= "password" onChange="checkPasswordMatch();"></td>
			</tr>
			<tr>
				<td>Passwordagain</td>
				<td><input id="upasswordagain" type="password" name= "passwordagain" onChange="checkPasswordMatch();"></td>
				<div class="registrationFormAlert" id="divCheckPasswordMatch2"></div>
			</tr>
			<tr>
				<td>Email</td>
				<td><input id="uemail" type="text" name= "email"></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input id="uphone" type="text" name= "phone"></td>
			</tr>


		</table>
</form>
	</div>

</body>
</html>
