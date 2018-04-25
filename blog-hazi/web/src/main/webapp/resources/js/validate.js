$(document).ready(function() {
	var usernameValid = false;
	var passwordValid = false;
	var password2Valid = false;
	var firstNameValid = false;
	var lastNameValid = false;
	var emailValid = false;
	var phoneValid = false;
	var pictureValid = false;
	
	$('button').prop('disabled', true);
	
	function check(){
		if (usernameValid && passwordValid && password2Valid && firstNameValid && lastNameValid && emailValid && phoneValid && pictureValid){
			$('button').prop('disabled', false);
		} else {
			$('button').prop('disabled', true);
		}
	}
		
	$('#inputUsername').change(function(){
		if ($('#inputUsername').val().length>0 && $('#inputUsername').val().length<=30){
			$('h3').html('');
			usernameValid = true;
		}
		else {
			$('h3').html('A Felhasznalonev nem lehet tobb 30 karakternel');
			usernameValid = false;	
		}
		check();
	});
	
	$('#inputPassword').change(function(){
		if ($('#inputPassword').val().length>=8 && $('#inputPassword').val().match(/\d/)){
			$('h3').html('');
			passwordValid = true;
		}
		else {
			$('h3').html('A jelszonak minimum 8 karakternek kell lennie es tartalmaznia kell egy szamot!');
			passwordValid = false;
		}
		check();
	});
	
	$('#inputPassword2').change(function(){
		if ( $('#inputPassword2').val() == $('#inputPassword').val() ){
			$('h3').html('');
			password2Valid = true;
		}
		else {
			$('h3').html('Nem egyezik meg a ket jelszo');
			password2Valid = false;
		}
		check();
	});
	
	$('#inputFirstName').change(function(){
		if ($('#inputFirstName').val().length>0 && $('#inputFirstName').val().length<=30){
			$('h3').html('');
			firstNameValid = true;
		}
		else {
			$('h3').html('A Keresztnev nem lehet tobb 30 karakternel');
			firstNameValid = false;
		}
		check();
	});
	
	$('#inputLastName').change(function(){
		if ($('#inputLastName').val().length>0 && $('#inputLastName').val().length<=30){
			$('h3').html('');
			lastNameValid = true;
		}
		else {
			$('h3').html('A Vezeteknev nem lehet tobb 30 karakternel');
			lastNameValid = false;
		}
		check();
	});
	
	$('#inputEmail').change(function(){
		if ($('#inputEmail').val().match((/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i))){
			$('h3').html('');
			emailValid = true;
		}
		else {
			$('h3').html('Hibas email cim!');
			emailValid = false;
		}
		check();
	});
	
	$('#inputPhone').change(function(){
		if ($('#inputPhone').val().match(/^\+36\-[0-9]{2}\/[0-9]{4}\-[0-9]{3}/)){
			$('h3').html('');
			phoneValid = true;
		}
		else {
			$('h3').html('Rossz telefonszam! helyes formatum: +36-30/1234-567');
			phoneValid = false;
		}
		check();
	});
	
	$('#inputPicture').change(function(){
		if ($('#inputPicture').val().length>0){
			$('h3').html('');
			pictureValid = true;
		}
		else {
			$('h3').html('Kotelezo kepet megadni!');
			pictureValid = false;
		}
		check();
	});
	
});