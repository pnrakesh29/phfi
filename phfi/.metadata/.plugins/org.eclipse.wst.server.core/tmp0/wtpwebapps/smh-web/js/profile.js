function validateCurrentPassword() {
	var mapServerLoginPassword = get('currentPassword').value.trim();
	var regx = /^(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
	if (isEmpty(mapServerLoginPassword)) {
		setDiv("currentPassErr", "Should not be Empty");
		return false;
	}else if(!(regx.test(mapServerLoginPassword))){
		setDiv("currentPassErr", "Should contain at least 8 characters,including 1 uppercase letter,1 Special character and 1 number.");
		return false;
	}
	else {
		setDiv("currentPassErr", " ");
		return true;
	}
}

function validateNewPassword() {
	var mapServerLoginPassword = get('newPassword').value.trim();
	var regx = /^(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
	if (isEmpty(mapServerLoginPassword)) {
		setDiv("newPassErr", "Should not be Empty");
		return false;
	}else if(!(regx.test(mapServerLoginPassword))){
		setDiv("newPassErr", "Should contain at least 8 characters,including 1 uppercase letter,1 Special character and 1 number.");
		return false;
	}
	else {
		setDiv("newPassErr", " ");
		return true;
	}
}


function validateConfirmPassword() {
	var confirmPassword = get('confirmPassword').value.trim();
	var regx = /^(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
	if (isEmpty(confirmPassword)) {
		setDiv("confirmPassErr", "Should not be Empty");
		return false;
	}else if(!(regx.test(confirmPassword))){
		setDiv("confirmPassErr", "Should contain at least 8 characters,including 1 uppercase letter,1 Special character and 1 number.");
		return false;
	}
	else {
		setDiv("confirmPassErr", " ");
		return true;
	}
}

function confirmPassword() {
	var confirmPass=document.getElementById("confirmPassword").value;
	var password=document.getElementById("newPassword").value;
	if(isEmpty(confirmPass)) {
		setDiv("confirmPassErr", "Should not be Empty");
		 return false;
	}
   if(isEmpty(password)) {
	   setDiv("newPassErr", "Should not be Empty");
	   return false;
	}
	if(confirmPass==password){
		setDiv("confirmPassErr", " ");
		return true;
	} else{
		 setDiv("confirmPassErr","*New password and Confirm password should be same*");
		 return false;
	}
}


function validateChangePassword() {
	var flag = true;
	if(!validateNewPassword() |!validateConfirmPassword() |!validateCurrentPassword() |!confirmPassword()){
		flag = false;
		return flag;
	}
	return flag;
}
