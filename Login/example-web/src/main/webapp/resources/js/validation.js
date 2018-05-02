
$(document).ready(function() {
		

			$.validator.addMethod('customphone', function(value, element) {
				return this.optional(element) || /^[+]\d{2}\/\d{2}-\d{4}-\d{3}$/.test(value);
			}, "Please enter a valid format of phone number. For example: +36/30-1234-567");
			
	
			// validate signup form on keyup and submit
			$("#form-registration").validate({
 				errorElement: 'div',
						rules : {
							username : {
								required : true,
								maxlength : 30
							},
							firstname : {
								required : true,
								maxlength : 30
							},
							lastname : {
								required : true,
								maxlength : 30
							},
							email : {
								required : true,
								email : true
							},
							phone : {
								required: true,
								customphone: true
							},
							picture : {
								required : true,
								url: true
							},
							password:{
								required : true,
								minlength: 8
							}, 
							password2:{
								required : true,
								minlength: 8,
								equalTo: "#password"
							}
						},
						
						
						messages : {				
							username : {
								required: "Please enter the username" ,
								maxlength : "The  username can't be more than 30 characters"
							},
							firstname : {
								required: "Please enter your firstname" ,
								maxlength : "The  firstname can't be more than 30 characters"
							},
							lastname : {
								required: "Please enter your lastname" ,
								maxlength : "The  lastname can't be more than 30 characters"
							},
							email : {
								required : "We need your email address to contact you. Please enter it.",
								email : "Invalid email adrress. For example: name@domain.com"
							},
							phone : {
								required: "Please enter your phone number" 
							},
							password : {
								required : "Please enter your password",
								minlength : "Invalid password.Passwords must contain at least 8 characters"
							},
							password2 : {
								required : "Please confirm your password",
								minlength : "Invalid password. Passwords must contain at least 8 characters",
								equalTo: "The passwords don't match. Please write password that above."
							},
							picture : {
								required : "Please enter an url",
								url : "Incorrect url. Please enter a valid url"
							}
						},
						//submitHandler: function() { alert("Registration successfull!!") }
						
			});
		
			
				// Username by combining first- and lastname
			$("#username").focus(function() {
						var firstname = $("#firstname").val();
						var lastname = $("#lastname").val();
						if(firstname && lastname && !this.value) {
							this.value = firstname + "." + lastname;
						}
			});
				
			
}); 