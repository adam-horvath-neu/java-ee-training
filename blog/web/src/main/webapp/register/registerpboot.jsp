<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="container">
	<div class="row">
        <div class="col-md-6">
            <form action="" method="post" id="fileForm" role="form">
            <fieldset><legend class="text-center">Valid information is required to register. <span class="req"><small> required *</small></span></legend>

            <div class="form-group">
            <label for="phonenumber"><span class="req">* </span> Phone Number: </label>
                    <input required type="text" name="phonenumber" id="phone" class="form-control phone" maxlength="28" onkeyup="validatephone(this);" placeholder="not used for marketing"/> 
            </div>

            <div class="form-group"> 	 
                <label for="firstname"><span class="req">* </span> First name: </label>
                    <input class="form-control" type="text" name="firstname" id = "txt" onkeyup = "Validate(this)" required maxlength="30" /> 
                        <div id="errFirst"></div>    
            </div>

            <div class="form-group">
                <label for="lastname"><span class="req">* </span> Last name: </label> 
                    <input class="form-control" type="text" name="lastname" id = "txt" onkeyup = "Validate(this)" placeholder="hyphen or single quote OK"  maxlength="30" required />  
                        <div id="errLast"></div>
            </div>

            <div class="form-group">
                <label for="email"><span class="req">* </span> Email Address: </label> 
                    <input class="form-control" required type="text" name="email" id = "email"  onchange="email_validate(this.value);" />   
                        <div class="status" id="status"></div>
            </div>

            <div class="form-group">
                <label for="username"><span class="req">* </span> User name:  <small>This will be your login user name</small> </label> 
                    <input class="form-control" type="text" name="username" id = "txt" onkeyup = "Validate(this)" placeholder="minimum 6 letters" required />  
                        <div id="errLast"></div>
            </div>

            <div class="form-group">
                <label for="password"><span class="req">* </span> Password: </label>
                    <input required name="password" type="password" class="form-control inputpass" minlength="8" maxlength="16"  id="pass1" /> </p>

                <label for="password"><span class="req">* </span> Password Confirm: </label>
                    <input required name="password" type="password" class="form-control inputpass" minlength="8" maxlength="16" placeholder="Enter again to validate"  id="pass2" onkeyup="checkPass(); return false;" />
                        <span id="confirmMessage" class="confirmMessage"></span>
            </div>

            <div class="form-group">
            
                <?php //$date_entered = date('m/d/Y H:i:s'); ?>
                <input type="hidden" value="<?php //echo $date_entered; ?>" name="dateregistered">
                <input type="hidden" value="0" name="activate" />
                <hr>
            </div>

            <div class="form-group">
                <input class="btn btn-success" type="submit" name="submit_reg" value="Register">
            </div>
  
            </fieldset>
            </form><!-- ends register form -->
            
            <script>
            $('document').ready(function()
            		{
            		    /* validation */
            		    $(".fileForm").validate({
            		        rules:
            		        {
            		            firstname: {
            		                required: true,
            		                minlength: 3,
            		                maxlength: 30
            		            },
            		            lastname: {
            		                required: true,
            		                minlength: 3,
            		                maxlength: 30
            		            },
            		            password: {
            		                required: true,
            		                minlength: 8,
            		                maxlength: 15
            		            },
            		            cpassword: {
            		                required: true,
            		                equalTo: '#password'
            		            },
            		            user_email: {
            		                required: true,
            		                email: true
            		            },
            		        },
            		        messages:
            		        {
            		            user_name: "Enter a Valid Username",
            		            password:{
            		                required: "Provide a Password",
            		                minlength: "Password Needs To Be Minimum of 8 Characters"
            		            },
            		            user_email: "Enter a Valid Email",
            		            cpassword:{
            		                required: "Retype Your Password",
            		                equalTo: "Password Mismatch! Retype"
            		            }
            		        },
            		        submitHandler: submitForm
            		    });
            		    /* validation */

            		    /* form submit */
            		    function submitForm()
            		    {
            		        var data = $("#register-form").serialize();

            		        $.ajax({

            		            type : 'POST',
            		            url  : 'register.php',
            		            data : data,
            		            beforeSend: function()
            		            {
            		                $("#error").fadeOut();
            		                $("#btn-submit").html('<span class="glyphicon glyphicon-transfer"></span> &nbsp; sending ...');
            		            },
            		            success :  function(data)
            		            {
            		                if(data==1){

            		                    $("#error").fadeIn(1000, function(){


            		                        $("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Sorry email already taken !</div>');

            		                        $("#btn-submit").html('<span class="glyphicon glyphicon-log-in"></span> &nbsp; Create Account');

            		                    });

            		                }
            		                else if(data=="registered")
            		                {

            		                    $("#btn-submit").html('Signing Up');
            		                    setTimeout('$(".form-signin").fadeOut(500, function(){ $(".signin-form").load("successreg.php"); }); ',5000);

            		                }
            		                else{

            		                    $("#error").fadeIn(1000, function(){

            		                        $("#error").html('<div class="alert alert-danger"><span class="glyphicon glyphicon-info-sign"></span> &nbsp; '+data+' !</div>');

            		                        $("#btn-submit").html('<span class="glyphicon glyphicon-log-in"></span> &nbsp; Create Account');

            		                    });

            		                }
            		            }
            		        });
            		        return false;
            		    }
            		    /* form submit */

            		});
            
            </script>
            
            
