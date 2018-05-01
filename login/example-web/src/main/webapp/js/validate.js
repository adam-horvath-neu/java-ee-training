jQuery(document).ready(function ($) {

    var userNameValid = false;
    var firstNameValid = false;
    var lastNameValid = false;
    var emailValid = false;
    var phoneValid = false;
    var userPictureValid = false;
    var passwordValid = false;
    var passwordRepeatValid = false;

    var inputUsername = $("input#username");
    var inputFirstName = $("input#firstname");
    var inputLastName = $("input#lastname");
    var inputEmail = $("input#email");
    var inputPhone = $("input#phone");
    var inputUserPicture = $("input#picture");
    var inputPassword = $("input#password");
    var inputPassword2 = $("input#password2");

    function validate() {
        if (userNameValid && firstNameValid && lastNameValid && emailValid && phoneValid && userPictureValid && passwordValid && passwordRepeatValid) {
            $("button#registerform").prop("disabled", false);
        } else {
            $("button#registerform").prop("disabled", "disabled");
        }
    }

    validate();

    inputUsername.change(function () {
        if ($(inputUsername).val().length > 0 && $(inputUsername).val().length <= 30) {
            $('message-text').text("");
            userNameValid = true;
            $(".message").hide();
            $(".message").removeClass("invalid");
            $("i.fa-bell").removeAttr("style");
            validate();
        } else {
            $(".message-text").addClass("invalid");
            $(".message-text").text("Minimum 1, maximum 30 karaktert adhat meg username-nek!");
            $("i.fa-bell").css("color", "red");
            $(".message").show();
            userNameValid = false;
            validate();
        }
    });

    inputFirstName.change(function () {
        if (inputFirstName.val().length > 0 && inputFirstName.val().length <= 30) {
            $('message-text').text("");
            firstNameValid = true;
            $(".message").hide();
            $(".message").removeClass("invalid");
            $("i.fa-bell").removeAttr("style");
            validate();
        }
        else {
            $(".message-text").addClass("invalid");
            $(".message-text").text("Minimum 1, maximum 30 karaktert adhat meg firstname-nek!");
            $("i.fa-bell").css("color", "red");
            $(".message").show();
            firstNameValid = false;
            validate();
        }
    });

    inputLastName.change(function () {
        if (inputLastName.val().length > 0 && inputLastName.val().length <= 30) {
            $('message-text').text("");
            lastNameValid = true;
            $(".message").hide();
            $(".message").removeClass("invalid");
            $("i.fa-bell").removeAttr("style");
            validate();
        } else {
            $(".message-text").addClass("invalid");
            $(".message-text").text("Minimum 1, maximum 30 karaktert adhat meg lastname-nek!");
            $("i.fa-bell").css("color", "red");
            $(".message").show();
            lastNameValid = false;
            validate();
        }
    });

    inputEmail.change(function () {
        if (inputEmail.val().match((/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i))) {
            $('message-text').text("");
            emailValid = true;
            $(".message").hide();
            $(".message").removeClass("invalid");
            $("i.fa-bell").removeAttr("style");
            validate();
        } else {
            $(".message-text").addClass("invalid");
            $(".message-text").text("Ez nem email!");
            $("i.fa-bell").css("color", "red");
            $(".message").show();
            emailValid = false;
            validate();
        }
    });

    inputPhone.change(function () {
        if (inputPhone.val().match(/^\+36\-[0-9]{2}\/[0-9]{4}\-[0-9]{3}/)) {
            $('message-text').text("");
            phoneValid = true;
            $(".message").hide();
            $(".message").removeClass("invalid");
            $("i.fa-bell").removeAttr("style");
            validate();
        } else {
            $(".message-text").addClass("invalid");
            $(".message-text").text("Ez nem telefon!");
            $("i.fa-bell").css("color", "red");
            $(".message").show();
            phoneValid = false;
            validate();
        }
    });

    inputUserPicture.change(function () {
        if (inputUserPicture.val().length > 0) {
            $('message-text').text("");
            userPictureValid = true;
            $(".message").hide();
            $(".message").removeClass("invalid");
            $("i.fa-bell").removeAttr("style");
            validate();
        } else {
            $(".message-text").addClass("invalid");
            $(".message-text").text("Adjon meg egy linket!");
            $("i.fa-bell").css("color", "red");
            $(".message").show();
            userPictureValid = false;
            validate();
        }
    });

    inputPassword.change(function () {
        if (inputPassword.val().length > 0 && inputPassword.val().length <= 8
            && inputPassword.val().match(/\d/)) {
            $('message-text').text("");
            passwordValid = true;
            $(".message").hide();
            $(".message").removeClass("invalid");
            $("i.fa-bell").removeAttr("style");
            validate();
        }
        else {
            passwordValid = false;
            $(".message-text").addClass("invalid");
            $(".message-text").text("Max hossz: 8, number required!");
            $("i.fa-bell").css("color", "red");
            $(".message").show();
            validate();
        }
    });

    inputPassword2.change(function () {
        if (inputPassword2.val() === inputPassword.val()) {
            $('message-text').text("");
            passwordRepeatValid = true;
            $(".message").hide();
            $(".message").removeClass("invalid");
            $("i.fa-bell").removeAttr("style");
            validate();
        }
        else {
            passwordRepeatValid = false;
            $(".message-text").addClass("invalid");
            $(".message-text").text("A jelszavaknak egyeznie kell!");
            $("i.fa-bell").css("color", "red");
            $(".message").show();
            validate();
        }
    });

    $("button#registerform").click(function () {
        jQuery.ajax({
            type: "POST",
            url: "Register",
            data: {
                username: inputUsername,
                firstname: inputFirstName,
                lastname: inputLastName,
                email: inputEmail,
                phone: inputPhone,
                userpicture: inputUserPicture,
                password: inputPassword,
                password2: inputPassword2
            },
            success: function (data) {
                $("i.fa-bell").removeAttr("style");
                $("i.fa-bell").css("color", "green");
                $(".message-text").text("Sikeres register!");
                $(".message-text").removeClass("invalid");
                $(".message-text").addClass("success");
                $(".message").show();
            },
            error: function (data) {
                $(".message-text").text(data['data']);
            },
        });
    });

});