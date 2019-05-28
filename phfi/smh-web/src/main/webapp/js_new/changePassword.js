function validateRoleName()
{
			var roleName = get('roleName').value.trim();
			if (isEmpty(roleName)) 
			{
				setDiv('errorDiv', 'Please enter Business name');
				return false;
			} else if (!isCharacter(roleName)) {
				setDiv('errorDiv', 'Please enter Business name');
				return false;
			} else {
				setDiv('errorDiv', '');
				return true;
			}
}

function validateCurrentPassword()
{
	setDiv('successid', '');
	var currentPassword = get('currentPassword').value.trim();
	if (isEmpty(currentPassword)) 
	{
		setDiv('currentPasswordDiv', 'Please enter Current Password');
		return false;
	} 
	else {
		setDiv('currentPasswordDiv', '');
		return true;
	}
	
}

function validateNewPassword()
{
	setDiv('successid', '');
	var newPassword = get('newPassword').value.trim();
	if (isEmpty(newPassword)) 
	{
		setDiv('newPasswordDiv', 'Please enter new password');
		return false;
	} 
	else {
		setDiv('newPasswordDiv', '');
		return true;
	}
}

function validateConfirmPassword()
{
	setDiv('successid', '');
	var confirmPassword = get('confirmPassword').value.trim();
	if (isEmpty(confirmPassword)) 
	{
		setDiv('confirmPasswordDiv', 'Please enter Confirm password');
		return false;
	} 
	else {
		setDiv('confirmPasswordDiv', '');
		return true;
	}
}

function validPassword()
{
	
	var confirmPassword = get('confirmPassword').value.trim();
	var newPassword = get('newPassword').value.trim();
	if(validateNewPassword() && validateConfirmPassword() && confirmPassword != newPassword)
	{
		setDiv('confirmPasswordDiv', 'New Password and confirm password must be same');
		return false;
	}
	return true;
}


function validSubmit()
{
	if(validateCurrentPassword() & validateNewPassword() & validateConfirmPassword() & validPassword())
	{
		return true;
	}
	return false;
}


function validResetPassword()
{
	if(validateNewPassword() & validateConfirmPassword() & validPassword())
	{
		return true;
	}
	return false;
}

function cancelChangePassword()
{
	window.location.href = "home";
}
