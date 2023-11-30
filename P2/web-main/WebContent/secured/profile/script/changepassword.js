var pwdValid = false;
var pwdMatched = false;

function togglePassword(type, chk_id, status) {
	//console.log("here..."+type+"..."+chk_id+"..."+status);
	if(type == "cur_pass") {
		if(status == "show"){
			$("#input-cur-password").attr("type", "text");
		} else {
			$("#input-cur-password").attr("type", "password");
		}
	} else if(type == "new_pass") {
		if(status == "show"){
			$("#input-password").attr("type", "text");
		} else {
			$("#input-password").attr("type", "password");
		}
	} else if(type == "conf_pass") {
		if(status == "show"){
			$("#input-password-check").attr("type", "text");
		} else {
			$("#input-password-check").attr("type", "password");
		}
	}  
}



$(document).ready(function() {
	$("#btn_submit").attr("disabled", true);
	
	// Tooltip for Special charater inputs
	if (!('ontouchstart' in window)) {
		$('.tip').tooltip();
	}

	// Password Validation
	$(function passwordValidation() {
		//alert("here in passwordValidation...");
		var pwdInput = $('#input-password');
	    var pwdInputText = $('#input-password-text'); // This is the input type="text" version for showing password
	    //var pwdValid = false;
	    //alert(pwdInput+"..."+pwdInputText);
	    
	    var pwdCheckInput = $('#input-password-check');
	    var pwdCheckInputText = $('#input-password-check-text'); // This is the input type="text" version for showing password
	
	    function validatePwdStrength() {
	    	//alert("here in validatePwdStrength...");
	    	var pwdValue = $(this).val(); // This works because when it's called it's called from the pwdInput, see end
	
	        // Validate the length
	        if (pwdValue.length > 7) {
	            $('#length').removeClass('invalid').addClass('valid');
	            pwdValid = true;
	        } else {
	            $('#length').removeClass('valid').addClass('invalid');
	            pwdValid = false;
	        }
	
	        // Validate capital letter
	        if (pwdValue.match(/[A-Z]/)) {
	            $('#capital').removeClass('invalid').addClass('valid');
	            pwdValid = pwdValid && true;
	        } else {
	            $('#capital').removeClass('valid').addClass('invalid');
	            pwdValid = false;
	        }
	
	        // Validate lowercase letter
	        if (pwdValue.match(/[a-z]/)) {
	            $('#lowercase').removeClass('invalid').addClass('valid');
	            pwdValid = pwdValid && true;
	        } else {
	            $('#lowercase').removeClass('valid').addClass('invalid');
	            pwdValid = false;
	        }
	
	        // Validate number or special character
	        if (pwdValue.match(/[\d`~!@#$%\^&*()+=|;:'",.<>\/?\\\-]/)) {
	            $('#number-special').removeClass('invalid').addClass('valid');
	            pwdValid = pwdValid && true;
	        } else {
	            $('#number-special').removeClass('valid').addClass('invalid');
	            pwdValid = false;
	        }	               
	    }
	    
	    function checkPasswordIfSame() {
        	var pwdCheckValue = $('#input-password-check').val();
	    	//console.log(pwdCheckValue);
	    	if(pwdCheckValue == $('#input-password').val()) {
	    		$('#pwd_match').text('Password matched.');
	    		$('#pwd_match').css('color', 'green');
	    		pwdMatched = true;
	    		//$("#btn_submit").attr("disabled", false);
	    	} else {
	    		$('#pwd_match').text('Password not matched.');
	    		$('#pwd_match').css('color', 'red');
	    		pwdMatched = false;
	    		//$("#btn_submit").attr("disabled", true);
	    	}
	    	
	    	//console.log(pwdValid+"..."+pwdMatched);
	        // Show/Hide Submit Button	        
	        if(pwdValid && pwdMatched){
	        	$('#btn_submit').prop('disabled', false);
	        } else {
	        	$('#btn_submit').prop('disabled', true);
	        }
        }
	    
	    function validatePwdValid(form, event) {
	    	//alert("here in validatePwdValid...");
	        if (pwdValid == true && pwdMatched == true) {
	            //form.submit();
	        	changePassword();
	        } else {
	            $('#alert-invalid-password').removeClass('hide');
	            event.preventDefault();
	        }
	    }
	
	    pwdInput.bind('change keyup input', validatePwdStrength); // Keyup is a bit unpredictable
	    pwdInputText.bind('change keyup input', validatePwdStrength); // This is the input type="text" version for showing password
	    
	    pwdCheckInput.bind('change keyup input', checkPasswordIfSame); // Keyup is a bit unpredictable
	    pwdCheckInputText.bind('change keyup input', checkPasswordIfSame); // This is the input type="text" version for showing password
	
	    /*
	    // jQuery Validation
	    $(".validate-password").validate({
	    	// Add error class to parent to use Bootstrap's error styles
	        highlight: function (element) {
	            $(element).parent('.form-group').addClass('error');
	        },
	        unhighlight: function (element) {
	            $(element).parent('.form-group').removeClass('error');
	        },
	        rules: {
	        	//alert("here in rules...");
	            // Ensure passwords match
	            "passwordCheckMasked": {
	            	equalTo: "#input-password"
	            }
	        },        
	        errorPlacement: function (error, element) {
	        	//alert("here in errorPlacement..."+element.attr("name"));
	        	if (element.attr("name") == "password" || element.attr("name") == "passwordMasked") {
	        		//alert("here in IF...password");
	                error.insertAfter("#input-password");
	            } else {
	            	//alert("here in ELSE...password");
	                error.insertAfter(element);
	            }
	            if (element.attr("name") == "passwordCheck" || element.attr("name") == "passwordCheckMasked") {
	            	//alert("here in IF...confirm password");
	                error.insertAfter("#input-password-check");
	            } else {
	            	//alert("here in ELSE...confirm password");
	                error.insertAfter(element);
	            }
	        },
	        submitHandler: function (form, event) {
	        	//alert("here in submitHandler...");
	            //this runs when the form validated successfully
	            validatePwdValid(form, event);
	        }
	    });// END jquery validate function
	    */
	}); // END passwordValidation()
}); // END ready function


/**
 * Function to Reset all control
 * @returns
 */
function resetAll(){
	//alert("here in resetAll...");
	$('#input-cur-password').val('');
	$('#input-password').val('');
	$('#input-password-check').val('');
	$('#length').removeClass('valid').addClass('invalid');
	$('#capital').removeClass('valid').addClass('invalid');
	$('#lowercase').removeClass('valid').addClass('invalid');
	$('#number-special').removeClass('valid').addClass('invalid');
    pwdValid = false;
}


/**
 * Function to change Password
 * @returns
 */
function changePassword(){
	//console.log("here in changePassword...");
	//showModal();
	//alert("here in changePassword..."+pwdValid);
	
	var curr_pwd = $('#input-cur-password').val();
	var conf_new_pwd = $('#input-password-check').val();
	//console.log(curr_pwd+"..."+conf_new_pwd);
	
	$.ajax({
		url: "../../change.Pwd",
		type: "POST",
		//dataType: 'json',	//specify the response type, here return type is a JSON Object
		data: {
			curr_pwd: curr_pwd,
			conf_pwd: conf_new_pwd,
		},
		success: function(response) {
			//alert(response);
			if (response == "1") {
				bootbox.alert("Password changed successfully.");
				resetAll();
				//hideModal();
				return;
			}
			else if (response == "0") {
				bootbox.alert("Current Password mismatch.");
				//hideModal();
				return;
			} else {
				bootbox.alert("Error to change Password.");
				//hideModal();
				return;
			}
		},
		error: function(xhr) {
			bootbox.alert("Unable to change Password.");
			//hideModal();
			return;
		}
	});//End of Ajax request	
}