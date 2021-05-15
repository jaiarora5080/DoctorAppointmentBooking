// Document is ready
$(document).ready(function () {
	
// Validate Username
	$('#usercheck').hide();	
	let usernameError = true;
	$('#usernames').keyup(function () {
		validateUsername();
	});
	
	function validateUsername() {
	let usernameValue = $('#usernames').val();
	if (usernameValue.length == '') {
	$('#usercheck').show();
		usernameError = false;
		return false;
	}
	else if((usernameValue.length < 3)||
			(usernameValue.length > 10)) {
		$('#usercheck').show();
		$('#usercheck').html
("**length of username must be between 3 and 10");
		usernameError = false;
		return false;
	}
	else {
		$('#usercheck').hide();
	}
	}

	
// Validate Password
	$('#passcheck').hide();
	let passwordError = true;
	$('#password').keyup(function () {
		validatePassword();
	});
	function validatePassword() {
		let passwrdValue =
			$('#password').val();
		if (passwrdValue.length == '') {
			$('#passcheck').show();
			passwordError = false;
			return false;
		}
		if ((passwrdValue.length < 3)||
			(passwrdValue.length > 10)) {
			$('#passcheck').show();
			$('#passcheck').html
("**length of your password must be between 3 and 10");
			$('#passcheck').css("color", "red");
			passwordError = false;
			return false;
		} else {
			$('#passcheck').hide();
		}
	}
		

// Submitt button
    $('#submitbtn').click(function () {
        validateUsername();
        validatePassword();
        validateConfirmPasswrd();
        validateEmail();
        if ((usernameError == true) && 
            (passwordError == true) ) {
            return true;
        } else {
            return false;
        }
    });
});
