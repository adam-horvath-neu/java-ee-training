$(document).ready(function() {
	var usernameValid = false;
	var passwordValid = false;
	var password2Valid = false;
	var firstNameValid = false;
	var lastNameValid = false;
	var emailValid = false;
	var phoneValid = false;
	var pictureValid = false;
	
	function submit(){
		if (usernameValid && passwordValid && password2Valid && firstNameValid && lastNameValid && emailValid && phoneValid && pictureValid){
			$('button').prop('disabled', false);
		} else {
			$('button').prop('disabled', true);
		}
	}
	
	$('button').prop('disabled', true);
	
	$('#inputUsername').change(function(){
		if ($('#inputUsername').val().length>0 && $('#inputUsername').val().length<=30){
			$('h3').html('');
			usernameValid = true;
			submit();
		}
		else {
			$('h3').html('Username max 30 karakter hosszu lehet!');
			usernameValid = false;
			submit();
		}
	});
	
	$('#inputPassword').change(function(){
		if ($('#inputPassword').val().length>0 && $('#inputPassword').val().length<=8 
				&& $('#inputPassword').val().match(/\d/)){
			$('h3').html('');
			passwordValid = true;
			submit();
		}
		else {
			$('h3').html('Password max 8 karakter hosszu lehet, tartalmaznia kell legalabb egy szamot!');
			passwordValid = false;
			submit();
		}
	});
	
	$('#inputPassword2').change(function(){
		if ( $('#inputPassword2').val() == $('#inputPassword').val() ){
			$('h3').html('');
			password2Valid = true;
			submit();
		}
		else {
			$('h3').html('A ket jelszonak meg kell egyeznie!');
			password2Valid = false;
			submit();
		}
	});
	
	$('#inputFirstName').change(function(){
		if ($('#inputFirstName').val().length>0 && $('#inputFirstName').val().length<=30){
			$('h3').html('');
			firstNameValid = true;
			submit();
		}
		else {
			$('h3').html('FirstName max 30 karakter hosszu lehet!');
			firstNameValid = false;
			submit();
		}
	});
	
	$('#inputLastName').change(function(){
		if ($('#inputLastName').val().length>0 && $('#inputLastName').val().length<=30){
			$('h3').html('');
			lastNameValid = true;
			submit();
		}
		else {
			$('h3').html('LastName max 30 karakter hosszu lehet!');
			lastNameValid = false;
			submit();
		}
	});
	
	$('#inputEmail').change(function(){
		if ($('#inputEmail').val().match((/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i))){
			$('h3').html('');
			emailValid = true;
			submit();
		}
		else {
			$('h3').html('Helytelen e-mail cim!');
			emailValid = false;
			submit();
		}
	});
	
	$('#inputPhone').change(function(){
		if ($('#inputPhone').val().match(/^\+36\-[0-9]{2}\/[0-9]{4}\-[0-9]{3}/)){
			$('h3').html('');
			phoneValid = true;
			submit();
		}
		else {
			$('h3').html('Helytelen telefonszam formatum!');
			phoneValid = false;
			submit();
		}
	});
	
	$('#inputPicture').change(function(){
		if ($('#inputPicture').val().length>0){
			$('h3').html('');
			pictureValid = true;
			submit();
		}
		else {
			$('h3').html('Adj meg kepet!');
			pictureValid = false;
			submit();
		}
	});
	
});
		
//$(document).ready(function() {
//	var inputs = $("#login-form #username, #login-form #password");
//	inputs.change(function() {
//		var enabled = true;
//		inputs.each(function(index, value) {
//			if (!$(value).val()) {
//				enabled = false;
//			}
//		});
//		var loginButton = $("#login-form #login");
//		if (enabled) {
//			loginButton.prop('disabled', false);
//		} else {
//			loginButton.prop('disabled', true);
//		}
//		
//		loginButton.click(function() {
//			$.ajax({
//				url: "LoginServlet",
//				type: "POST",
//				data: {
//					username: $(inputs[0]).val(),
//					password: $(inputs[1]).val()
//				},
//				success: function(data) {
//					var result = $.parseJSON(data);
//					if (result.success) {
//						$("#login-form #message").html("Successful login!").removeClass("failed").addClass("success");
//					} else {
//						$("#login-form #message").html("Invalid username/password!").removeClass("success").addClass("failed");
//					}
//				}
//			});
//		});
//	});
//});