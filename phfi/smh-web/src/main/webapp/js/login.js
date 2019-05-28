function validateSave() {
	if(!validateUser() | !validatePassword())
		return false;
	else
	get('loginform').submit();
	return true;
	
}

function validateUser() {
	var spUser=get('spUser').value;
	if(isEmpty(spUser)){
		setDiv("spUserErr", "Please Enter UserName");
		return false;
	}
	else{
		setDiv("spUserErr", " ");
		return true;
	}
}

function validatePassword() {
	var spPass=get('spPass').value;
	if(isEmpty(spPass)){
		setDiv("passwordError", "Please Enter Password");
		return false;
	}
	else{
		setDiv("passwordError", " ");
		return true;
	}
}