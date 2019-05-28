 function validRoleName() {
	var roleName = get('roleName').value.trim();
	if (isEmpty(roleName)) {
		setDiv('roleNameDiv', 'Please select Role name');
		return false;
	} else {
		setDiv('roleNameDiv', '');
		return true;
	}
}

function validUserName() {
	var userName = get('userName').value.trim();
	if (isEmpty(userName)) {
		setDiv('userNameDiv', 'Please enter User name');
		return false;
	} else if (!isCharacter(userName)) {
		setDiv('userNameDiv', 'Please enter User name');
		return false;
	} else {
		setDiv('userNameDiv', '');
		return true;
	}

}
function validFirstName() {
	var firstName = get('firstName').value.trim();
	if (isEmpty(firstName)) {
		setDiv('firstNameDiv', 'Please enter First name');
		return false;
	} else if (!isCharacter(firstName)) {
		setDiv('firstNameDiv', 'Please enter First name');
		return false;
	} else {
		setDiv('firstNameDiv', '');
		return true;
	}
}

function validLastName() {
	//lastName
	//lastNameDiv

	var lastName = get('lastName').value.trim();
	if (isEmpty(lastName)) {
		setDiv('lastNameDiv', 'Please enter Last name');
		return false;
	} else if (!isCharacter(lastName)) {
		setDiv('lastNameDiv', 'Please enter Last name');
		return false;
	} else {
		setDiv('lastNameDiv', '');
		return true;
	}
}

function validPhone() {
	var phone = getVal('phone').trim();
	if (isEmpty(phone)) {
		setDiv('phoneDiv', 'Please enter Phone No.');
		return false;
	} else if (!isDigit(phone) || phone.length < 10 || phone.length > 13
			|| phone == 0) {
		setDiv('phoneDiv', 'Invalid Phone No.');
		return false;
	} else if (phone.charAt(parseInt("0")) == "0") {
		setDiv('phoneDiv', 'Phone No. cannot start with zero');
		return false;
	} else {
		setDiv('phoneDiv', '');
		return true;
	}
}

function validateUserEmailId() {
	var reg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	var emailAddress = get('emailId').value.trim();
	if (isEmpty(emailAddress)) {
		setDiv('emialDiv', 'Please enter Email Address');
		return false;
	}
	else if (reg.test(emailAddress) == false) {
		setDiv('emialDiv', 'Invalid Email');
		return false;
	} else {
		if (alpha.indexOf(emailAddress.charAt(0)) == -1) {
			setDiv('emialDiv', 'Invalid Email');
			return false;
		}
		setDiv('emialDiv', ' ');
		return true;
	}
}

function validAddress() {
	var name = get('address').value.trim();
	if (isEmpty(name)) {
		setDiv('addressDiv', 'Please enter Address');
		return false;
	} else if (!isCharacter(name)) {
		setDiv('addressDiv', 'Invalid Address');
		return false;
	} else {
		setDiv('addressDiv', '');
		return true;
	}
}

function validUser() {
	if (!validRoleName() | !validUserName() | !validFirstName()
			| !validLastName() | !validPhone() | !validateUserEmailId()) {
		return false;
	}
	return true;
}

function validCreateUser() {
	if (!validRoleName()  | !validUserName() | !validFirstName() //
			| !validLastName() | !validPhone() | !validateUserEmailId()
			| !validAddress()) {
		return false;
	}
	return true;
}

function validEditUser() {
	if (!validRoleName() | !validAddress() | !validUserName() | !validFirstName()
			| !validLastName() | !validPhone()) {
		return false;
	}
	return true;
}

function cancelChangeProfile() {
	window.location.href = "home";
}

/**
 * 
 */
function cancelAccessUserEdit() {
	window.location.href = "access-user-search";
}

function resetCreateUser() {
	window.location.href = "access-user-create";
}

function resetChangeProfile()
{
	window.location.href = "chatak_admin_myprofile";

}

function editUser(userId) {
	get('userIdData').value = userId;
	document.forms["userEditForm"].submit();
}