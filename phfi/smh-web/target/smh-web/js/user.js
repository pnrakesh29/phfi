function validateEntityType() {
	var userType = get("userType").value;
	if (isEmpty(userType)) {
		setDiv("userTypeErr", "Please select Entity Type");
		return false;
	} else{
		setDiv("userTypeErr", "");
		return true;	
	}
}

function validateRole() {
	var userRoleId = get("userRoleId").value;
	if (isEmpty(userRoleId)) {
		setDiv("userRoleIdErr", "Please select Role");
		return false;
	} else{
		setDiv("userRoleIdErr", "");
		return true;	
	}
}

function validateUserName() {
	var userName = get('userName').value.trim();
	var regx = /^[A-Za-z0-9_ ]+$/;
	if (isEmpty(userName)) {
		setDiv("userNameErr", "Should not be Empty");
		return false;
	} else if(!regx.test(userName)){
		setDiv("userNameErr", "Invalid input, please enter correct value");
		return false; 
	} else {
		setDiv("userNameErr", " ");
		return true;
	}
}

function validateLastName() {
	var lastName = get('lastName').value.trim();
	var regx = /^[A-Za-z]+$/;
	if (isEmpty(lastName)) {
		setDiv("lastNameErr", "Should not be Empty");
		return false;
	} else if(!regx.test(lastName)){
		setDiv("lastNameErr", "Invalid input, please enter correct value");
		return false; 
	} else {
		setDiv("lastNameErr", " ");
		return true;
	}
}

function validateFirstName() {
	var firstName = get('firstName').value.trim();
	var regx = /^[A-Za-z]+$/;
	if (isEmpty(firstName)) {
		setDiv("firstNameErr", "Should not be Empty");
		return false;
	} else if(!regx.test(firstName)){
		setDiv("firstNameErr", "Invalid input, please enter correct value");
		return false; 
	} else {
		setDiv("firstNameErr", " ");
		return true;
	}
}

function validatePhone() {
		var phone = getVal('phone').trim();
		var regex = /(\d{3}-\d{3}|\*{3}-\*{3})-\d{4}/;
		if (isEmpty(phone)) {
			setDiv("phoneErr", "Should not be empty");
			return false;
		} else if (!regex.test(phone)) {
			setDiv("phoneErr", "Invalid phone number");
			return false;
		}else {
			setDiv("phoneErr", "");
			return true;
		}
	}

function validateUserName() {
	var userName = get('userName').value.trim();
	if (isEmpty(userName)) {
		setDiv("userNameErr", "Should not be Empty");
		return false;
	} else {
		setDiv("userNameErr", " ");
		return true;
	}
}


function validateEmail() {

	//var regx = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var regx = /^([a-zA-Z_\.\-])+([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var emailAddress = get('email').value.trim();

	if (isEmpty(emailAddress)) {
		setDiv("emailErr", "Should not be empty");
		return false;
	}
	else if(!regx.test(emailAddress)){
		setDiv("emailErr", "Invalid format *example@mail.com*");
		return false;
	}
	else{
		setDiv("emailErr", "");
		return true;
	}
}

/*function validateSecurityAnswer() {
	var securityAnswer = get('securityAnswer').value.trim();
	var regx = /^[A-Za-z0-9._ ]+$/;
	if (isEmpty(securityAnswer)) {
		setDiv("securityAnswerErr", "Should not be Empty");
		return false;
	} else if(!regx.test(securityAnswer)){
		setDiv("securityAnswerErr", "Invalid input, please enter correct value");
		return false; 
	} else {
		setDiv("securityAnswerErr", " ");
		return true;
	}
}

function validateSecurityQuestion() {
	var securityQuestion = get('securityQuestion').value.trim();
	if (isEmpty(securityQuestion)) {
		setDiv("securityQuestionErr", "Should not be Empty");
		return false;
	} else {
		setDiv("securityQuestionErr", " ");
		return true;
	}
}*/


function validateCreate(){
	var flag = true;
	if(!validateEntityType()|!validateRole()|!validateLastName()|!validateFirstName()|!validatePhone()|!validateUserName()
			|!validateEmail()){
		flag = false;
		return flag;
	}
	return flag;
}

function validateEdit(){
	var flag = true;
	if(!validateLastName()|!validateFirstName()|!validatePhone()|!validateUserName()|!validateEmail()){
		flag = false;
		return flag;
	}
	return flag;
}


function fetchRoles(){
	var userType = get("userType").value;
	
	if(userType == ""){
		return;
	}
	doAjaxFetchRoles(userType);
}

function doAjaxFetchRoles(userType){
	$.ajax({
		type : "GET",
		url : "doAjaxFetchRoles?userType=" + userType+""+""+"",
		async : true,
		success : function(response) {
			var obj = JSON.parse(response);
			
			document.getElementById("userRoleId").options.length = 0;
			
			var selectOption = document.createElement("option");
			selectOption.innerHTML = ".:Select:.";
			selectOption.value = "";
			$("#userRoleId").append(selectOption);
			
			if (obj.responseCode== "BS_0001") {
				var data = obj.userRoleRequests;
				for (var i = 0; i < data.length; i++) {
					var newOption = document.createElement("option");
					newOption.value = data[i].userRoleId;
					newOption.innerHTML = data[i].roleName;
					$("#userRoleId").append(newOption);
				}
			}
			
		},
		error : function(e) {
			
		}
		
	});
}

function editadminUserItems(adminUserId) {
	get('adminUserId').value = adminUserId;
	document.forms["editUserForm"].submit();
}

function changeadminUserStatus(id , status) {
	get('statusChangeUserId').value = id;
	get('statusChange').value = status;
	$('#activatePop').popup("show");
}

function submitUserStatus() {
	var reason = get('activateReason').value.trim();
	if(isEmpty(reason)){
		$("#activateDiv").addClass("has-error");
		$("#activateErr").addClass("visible");
		setDiv("activateErr", "Please enter reason");
		return false;
	}
	document.forms["userStatusForm"].submit();
}

function confirmDeleteUser(deleteUserId) {
	var r = confirm("Press OK to confirm deletion");
	if (r == true) {
		get('deleteUserId').value = deleteUserId;
		document.forms["deleteUserForm"].submit();
	} else {
		return;
	}
}

function submitUserStatus() {
	var reason = get('activateReason').value.trim();
	if(isEmpty(reason)){
		setDiv("activateErr", "Please enter reason");
		return false;
	}
	document.forms["userStatusForm"].submit();
}