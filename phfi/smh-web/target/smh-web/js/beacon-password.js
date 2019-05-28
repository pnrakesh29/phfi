function validateUserName() {
	var userName = get('userName').value.trim();
	if (isEmpty(userName)) {
		$("#userNameDiv").addClass("has-error");
		$("#userNameErr").addClass("visible");
		setDiv("userNameErr", "Should not be Empty");
		return false;
	} else {
		$("#userNameDiv").removeClass("has-error").addClass("has-success");
		$("#userNameErr").removeClass("visible");
		setDiv("userNameErr", " ");
		return true;
	}
}

function validateSecurityQuestion() {
	var securityQuestion = get('securityQuestion').value.trim();
	if (isEmpty(securityQuestion)) {
		$("#securityQuestionDiv").addClass("has-error");
		$("#securityQuestionErr").addClass("visible");
		setDiv("securityQuestionErr", "Should not be Empty");
		return false;
	} else {
		$("#securityQuestionDiv").removeClass("has-error").addClass("has-success");
		$("#securityQuestionErr").removeClass("visible");
		setDiv("securityQuestionErr", " ");
		return true;
	}
}

function validateSecurityAnswer() {
	var securityAnswer = get('securityAnswer').value.trim();
	var regx = /^[A-Za-z0-9._ ]+$/;
	if (isEmpty(securityAnswer)) {
		$("#securityAnswerDiv").addClass("has-error");
		$("#securityAnswerErr").addClass("visible");
		setDiv("securityAnswerErr", "Should not be Empty");
		return false;
	} else if(!regx.test(securityAnswer)){
		$("#securityAnswerDiv").addClass("has-error");
		$("#securityAnswerErr").addClass("visible");
		setDiv("securityAnswerErr", "Invalid input, please enter correct value");
		return false; 
	} else {
		$("#securityAnswerDiv").removeClass("has-error").addClass("has-success");
		$("#securityAnswerErr").removeClass("visible");
		setDiv("securityAnswerErr", " ");
		return true;
	}
}

function validateCurrentPassword() {
	var mapServerLoginPassword = get('oldPass').value.trim();
	var regx = /^(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
	if (isEmpty(mapServerLoginPassword)) {
		$("#currentPassDiv").addClass("has-error");
		$("#currentPassErr").addClass("visible");
		setDiv("currentPassErr", "Should not be Empty");
		return false;
	}else if(!(regx.test(mapServerLoginPassword))){
		$("#currentPassDiv").addClass("has-error");
		$("#currentPassErr").addClass("visible");
		setDiv("currentPassErr", "Should contain at least 8 characters,including 1 uppercase letter,1 Special character and 1 number.");
		return false;
	}
	else {
		$("#currentPassDiv").removeClass("has-error") .addClass("has-success");
		$("#currentPassErr").removeClass("visible");
		setDiv("currentPassErr", " ");
		return true;
	}
}

function validateNewPassword() {
	var mapServerLoginPassword = get('newPass').value.trim();
	var regx = /^(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
	if (isEmpty(mapServerLoginPassword)) {
		$("#newPassDiv").addClass("has-error");
		$("#newPassErr").addClass("visible");
		setDiv("newPassErr", "Should not be Empty");
		return false;
	}else if(!(regx.test(mapServerLoginPassword))){
		$("#newPassDiv").addClass("has-error");
		$("#newPassErr").addClass("visible");
		setDiv("newPassErr", "Should contain at least 8 characters,including 1 uppercase letter,1 Special character and 1 number.");
		return false;
	}
	else {
		$("#newPassDiv").removeClass("has-error") .addClass("has-success");
		$("#newPassErr").removeClass("visible");
		setDiv("newPassErr", " ");
		return true;
	}
}


function validateConfirmPassword() {
	var confirmPassword = get('confirmPass').value.trim();
	var regx = /^(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
	if (isEmpty(confirmPassword)) {
		$("#confirmPassDiv").addClass("has-error");
		$("#confirmPassErr").addClass("visible");
		setDiv("confirmPassErr", "Should not be Empty");
		return false;
	}else if(!(regx.test(confirmPassword))){
		$("#confirmPassDiv").addClass("has-error");
		$("#confirmPassErr").addClass("visible");
		setDiv("confirmPassErr", "Should contain at least 8 characters,including 1 uppercase letter,1 Special character and 1 number.");
		return false;
	}
	else {
		$("#confirmPassDiv").removeClass("has-error") .addClass("has-success");
		$("#confirmPassErr").removeClass("visible");
		setDiv("confirmPassErr", " ");
		return true;
	}
}

function validateSubmit(){
	var flag = true;
	if(!validateUserName() |!validateSecurityAnswer()){
		flag = false;
		return flag;
	}
	return flag;
}

function confirmPassword() {
	var confirmPass=document.getElementById("confirmPass").value;
	var password=document.getElementById("newPass").value;
	if(isEmpty(confirmPass)) {
		$("#confirmPassDiv").addClass("has-error");
		$("#confirmPassErr").addClass("visible");
		setDiv("confirmPassErr", "Should not be Empty");
		 return false;
	}
   if(isEmpty(password)) {
	   $("#newPassDiv").addClass("has-error");
	   $("#newPassErr").addClass("visible");
	   setDiv("newPassErr", "Should not be Empty");
	   return false;
	}
	if(confirmPass==password){
		$("#confirmPassDiv").removeClass("has-error") .addClass("has-success");
		$("#confirmPassErr").removeClass("visible");
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

function validateResetPassword() {
	var flag = true;
	if(!validateNewPassword() |!validateConfirmPassword() |!validateCurrentPassword() |!validateSecurityAnswer() |!validateSecurityQuestion() |!confirmPassword()){
		flag = false;
		return flag;
	}
	return flag;

}

function fetchSecurityQuestion() {
	 var userName = document.getElementById("userName").value.trim();
	 if(!validateUserName()){
		 document.getElementById("red-error-hide").innerHTML="";
		 return false;
	 }
	 document.getElementById("red-error-hide").innerHTML="";
	 $.ajax({
	   type : 'GET',
		  url : "securityQuestion?userName="+userName,
	  success : function(response) {
		  var obj = JSON.parse(response);
	  if (obj.responseCode== "00") {
		   document.getElementById("securityQuestion").innerHTML=obj.securityQuestion;
		   document.getElementById("red-error-hide").innerHTML="";
	   }
	   else if(obj.responseCode == "99"){
		   document.getElementById("securityQuestion").innerHTML="";
		   document.getElementById("red-error-hide").innerHTML="Username is not present";
	   }
	   else if(obj.responseCode == "130") {
		   document.getElementById("red-error-hide").innerHTML="Security Question is not configured";
	   }
	   },
	  failure : function(e) {
	    }
	 });
}
