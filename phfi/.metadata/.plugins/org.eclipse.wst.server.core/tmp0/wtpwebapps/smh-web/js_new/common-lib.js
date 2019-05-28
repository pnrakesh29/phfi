/**
 * System constants
 */
var sys_constants = {
	ASCII_EXTENDED : true,
};

var isMultiButtonsDisabled = false;
String.prototype.trim = function() {
	return this.replace(/^\s+|\s+$/g, "");
};

function isCharacter(value) {
	var characterValue = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	for ( var i = 0; i <= value.length; i++) {
		if (characterValue.indexOf(value.charAt(i)) == -1)
			return false;
	}
	return true;
}

function isChar(value) {
	var characterValue = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	for ( var i = 0; i <= value.length; i++) {
		if (characterValue.indexOf(value.charAt(i)) == -1)
			return false;
	}
	return true;
}

function get(id) {
	return document.getElementById(id);
}

function getVal(id) {
	return get(id).value;
}

function hide(id) {
	if (get(id)) {
		get(id).style.display = 'none';
	}
}

function printCustomerDetails() {
	window.print();
}

function show(id) {
	if (get(id)) {
		get(id).style.display = 'block';
	}
}
function showInline(id) {
	if (get(id)) {
		get(id).style.display = 'inline-block';
	}
}

function isDigit(val) {
	var characterValue = "0123456789";
	for ( var i = 0; i <= val.length; i++) {
		if (characterValue.indexOf(val.charAt(i)) == -1)
			return false;
	}
	return true;
}

function setValue(id, val) {
	if (get(id)) {

		console.log(id);
		console.log(val);
		get(id).value = val;
	}

}

function setPlaceholder(id, val) {
	var ele = get(id);
	if (ele) {
		ele.placeholder = val;
		ele.value = '';
	}

}

function setDiv(id, val) {
	if (get(id)) {
		get(id).innerHTML = val;
	}

}

function setElemValue(id, val) {
	if (get(id)) {
		get(id).value = val;
	}

}

function isEmpty(id) {
	if (!id || id === "" || id.length === 0)
		return true;
	else
		return false;
}
function validName(value) {
	var characterValue = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	for ( var i = 0; i <= value.length; i++) {
		if (characterValue.indexOf(value.charAt(i)) == -1)
			return false;
	}
	return true;
}

function validUserNameData(value) {
	var characterValue = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	for ( var i = 0; i <= value.length; i++) {
		if (characterValue.indexOf(value.charAt(i)) == -1)
			return false;
	}
	return true;
}

function validWalletName(id, divId, failureMessage) {
	var walletName = getVal(id);
	if (isEmpty(walletName)) {
		setDiv(divId, "&nbsp;");
		return true;
	} else if (!validName(walletName)) {
		setDiv(divId, failureMessage);
		return false;
	}
	setDiv(divId, "&nbsp;");
	return true;

}

function validWalletUserName(id, divId, failureMessage) {
	var walletName = getVal(id);
	if (isEmpty(walletName)) {
		setDiv(divId, "&nbsp;");
		return true;
	} else if (!validUserNameData(walletName)) {
		setDiv(divId, failureMessage);
		return false;
	}
	setDiv(divId, "&nbsp;");
	return true;

}

function validUserId(id, divId, failureMessage) {
	var userId = getVal(id);
	if (isEmpty(userId)) {
		setDiv(divId, "&nbsp;");
		return true;
	}

	else if (!isDigit(userId)) {
		setDiv(divId, failureMessage);
	}
	return true;
}

function validWalletMobileNumber(id, divId) {
	var val = getVal(id);
	if (isEmpty(val)) {
		setDiv(divId, "&nbsp;");
		return true;
	} else if (!isDigit(val) || val.length < 8 || val.length > 18 || val == 0) {
		setDiv(divId, message.REQ_MOBILE_NUMBER);
		return false;
	} else if (val.charAt(parseInt("0")) == "0") {

		setDiv(divId, message.IN_MOBILE_NUMBER_START);
		return false;
	}

	else {
		setDiv(divId, "&nbsp;");
		return true;
	}
}

function validWalletEmail(id, divId) {
	var flag = false;
	var reg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	// var reg = /^([A-Za-z0-9_\-\.])+\@([A-Z a-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	var alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	var emailAddress = getVal(id);

	if (isEmpty(emailAddress)) {
		// emailAddress_Div.innerHTML = "Email Address is Required";
		setDiv(divId, "&nbsp;");
		return true;
	}

	else if (reg.test(emailAddress) == false) {

		setDiv(divId, message.IN_EMAIL);
		return false;
	} else {

		if (alpha.indexOf(emailAddress.charAt(0)) == -1) {
			setDiv(divId, message.IN_EMAIL);
			return false;
		}

		flag = true;
		setDiv(divId, "&nbsp;");
	}

	return flag;

}
function validateToDate(divId, errorMsg) {
	var flag = true;

	var toDate = document.getElementById('startDate').value;
	if (futureDate(toDate)) {
		setDiv(divId, errorMsg);
		flag = false;
		return flag;
	} else {
		setDiv(divId, "&nbsp;");
		return flag;
	}
	setDiv(divId, "&nbsp;");
	return flag;
}
function validateEndDate(divId, errorMsg) {

	var flag = true;
	var endDate = document.getElementById('endDate').value;
	if (futureDate(endDate)) {
		setDiv(divId, errorMsg);
		flag = false;
		return flag;
	} else {
		setDiv(divId, "&nbsp;");
	}
	if (flag) {
		flag = validateDates(divId, message.IN_END_DATE_FUTURE_DATE);
		if (!flag)
			return flag;
	}
	setDiv(divId, "&nbsp;");
	return flag;
}
function validateDates(divId, errorMsg) {
	var flag = true;
	var toDate = document.getElementById('startDate').value;
	var endDate = document.getElementById('endDate').value;
	if (toDate != "") {
		toDate = toDate.split("-");
		toDate = new Date(toDate[0], toDate[1] - 1, toDate[2]).getTime();
		endDate = endDate.split("-");
		endDate = new Date(endDate[0], endDate[1] - 1, endDate[2]).getTime();
		if (toDate > endDate) {
			flag = false;
			setDiv(divId, errorMsg);
		} else {
			setDiv(divId, "&nbsp;");
		}
	}
	return flag;
}
function futureDate(idate) {

	var today = new Date().getTime();
	idate = idate.split("-");

	idate = new Date(idate[0], idate[1] - 1, idate[2]).getTime();
	return (today - idate) < 0 ? true : false;
}

function validMessage(value) {
	var characterValue = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890 .,!?@$%&_-'\n";
	for ( var i = 0; i <= value.length; i++) {
		if (characterValue.indexOf(value.charAt(i)) == -1)
			return false;
	}
	return true;
}

/**
 * Common pagination for all related screens
 */
function getPortalOnPage(pageNumber) {
	get('pageNumberId').value = pageNumber;
	document.forms["paginationForm"].submit();

}
function getPortalPrevPage(curPageNumber) {
	getPortalOnPage(parseInt(curPageNumber) - 1);
}

function getPortalNextPage(curPageNumber) {
	getPortalOnPage(parseInt(curPageNumber) + 1);
}

function hasDoubleSpace(val) {
	return (val.indexOf('  ') != -1);
}

/**
 * Function to check ASCII characters
 * 
 * @param str
 * @returns
 */
function isASCII(str) {
	var isValid = (sys_constants.ASCII_EXTENDED ? /^[\x00-\xFF]*$/
			: /^[\x00-\x7F]*$/).test(str);
	if (!isValid) {
		return validateLatinCharacters(str);
	}
	return true;
}

function isValidMinCharsAndSpecial(val) {
	var firstCharAlphaRegex = /^[A-Za-z0-9][A-Za-z0-9 -]*$/;
	return firstCharAlphaRegex.test(val);
}
function isValidChars(val) {
	var firstCharAlphaRegex = /^[A-Za-z][-\'A-Za-z0-9 ]*$/;
	return firstCharAlphaRegex.test(val);
}

function isValidNameChars(val) {
	var firstCharAlphaRegex = /^[A-Za-z][-\'&\/.()-,A-Za-z0-9 ]*$/;
	return firstCharAlphaRegex.test(val);
}

function isValidAddressChars(val) {
	var firstCharAlphaRegex = /^[A-Za-z0-9#][-$#@\/,'.;:'&A-Za-z0-9 ]*$/;
	return firstCharAlphaRegex.test(val);
}

function isValidCityChars(val) {
	var firstCharAlphaRegex = /^[A-Za-z0-9][-,.;'&\/.()A-Za-z0-9 ]*$/;
	return firstCharAlphaRegex.test(val);
}
function isValidZipChars(val) {
	var firstCharAlphaRegex = /^[A-Za-z0-9][A-Za-z0-9 ]*$/;
	return firstCharAlphaRegex.test(val);
}
function isValidCharsExtended(val) {
	var firstCharAlphaRegex = /^[A-Za-z0-9#][A-Za-z0-9 -$#@,']*$/;
	return firstCharAlphaRegex.test(val);
}
function validateChangeAdminPassword(password, errorDiv, errorMessage,
		errormessage1) {
	// Check for the following:
	// - include one lower case
	// - one upper case
	// - one special char; any one of @#$%`!^&()\-_+=[]{};:'",.<>/?
	// - no white spaces
	// - may include numbers
	if (isEmpty(getVal(password))) {
		setDiv(errorDiv, errormessage1);
		return false;
	}
	var passwordReg = /^(?!.*[\s])((?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%`!^&()\-_+=\[\]{};:'\",.<>\/?|\\\\*]).{6,20})/;
	var result = passwordReg.test(getVal(password));
	if (result == false) {
		setDiv(errorDiv, errorMessage);
		return false;
	}
	return result;
}
function resetErrorSuccessMessage() {

	document.getElementById("sucessDiv").innerHTML = "";
	document.getElementById("errorDiv").innerHTML = "";

	//get('sucessDiv').value = "&nbsp;";
	//get('errorDiv').value = "&nbsp;";
}

function clearErrorMsg(divName) {
	setDiv(divName, "&nbsp;");

	resetErrorSuccessMessage();
}

function invalidWords(validMessage) {
	validMessage = validMessage.trim();
	var messageLength = validMessage.split(' ');
	for ( var i = 0; i < messageLength.length; i++) {
		if (messageLength[i].length > parseFloat(20))
			return false;

	}

	return true;
}

function validatePopupDesc() {

	var text = getVal("reason");

	// Since description is not mandatory
	// check for empty text.
	// If so return true.
	if (isEmpty(text)) {
		setDiv("popDescError_div", message.REQ_POPUP_REASON);
		return false;
	}
	if (!invalidWords(text)) {
		setDiv("popDescError_div", message.IN_POPUP_REASON_WORD_LENGTH);
		return false;
	}
	/*if( !validMessage(text))
	{
		setDiv("popDescError_div",message.IN_POPUP_VALID_REASON);
		return false;	
	}*/
	if (text.length > 250) {
		setDiv("popDescError_div", message.IN_POUP_REASON_LENGTH);
		return false;
	} else {
		setDiv("popDescError_div", "&nbsp;");
		return true;
	}

	$('#my_popup').popup('hide');
}

function clearPopupDesc() {
	get("reason").value = "";
}

function cbWrapper(data, funct) {
	if ($("#myForm", data).size() > 0)
		top.location.href = "login.htm";//redirection
	else
		funct(data);
}

/**
 * Ajax related functions
 */
HTTP_METHOD = {
	POST : "POST",
	GET : "GET"
};

CONTENT_TYPE = {
	APP_JSON : "application/json",
	JSON : "json"
};

function invokeREST(httpMethod, url, data, successCallback, failureCallback) {
	$.ajax({
		type : httpMethod,
		dataType : CONTENT_TYPE.JSON,
		url : url,
		data : data,
		success : successCallback,
		error : failureCallback
	});
}

function getValidValue(val) {
	if (!val || val == null || val == 'null') {
		return '';
	}
	return val;
}

function validateLatinCharacters(val) {
	var reg = new RegExp(sys_constants.LATIN, "i");
	if (!reg.test(val)) {
		reg = new RegExp(sys_constants.LATIN_EXT_A, "i");
		if (!reg.test(val)) {
			reg = new RegExp(sys_constants.LATIN_EXT_B, "i");
			return (reg.test(val));
		}
	}
	return true;
}

function highlightMainContent(menuId){
	$(("#"+menuId)).addClass( "active-background" );
}

function setError(ele, errorMsg) {
	get((ele.id+'Er')).innerHTML = errorMsg;
}

function setLable(id, value) {
	get(id).innerHTML = value;
}

/**
 * Common pagination for all related screens
 */
function getPortalOnPage(pageNumber) {
	get('pageNumberId').value = pageNumber;
	document.forms["paginationForm"].submit();
}

function getPortalOnPageWithRecords(pageNumber, totalRecords) {
	get('pageNumberId').value = pageNumber;
	get('totalRecordsId').value = totalRecords;
	document.forms["paginationForm"].submit();
}

function getPortalOnPageWithRecordsForRequest(pageNumber, totalRecords, status, transferMode) {
	get('pageNumberId').value = pageNumber;
	get('totalRecordsId').value = totalRecords;
	get('transferModePagination').value=transferMode;
	get('statusPagination').value=status;
	document.forms["paginationForm"].submit();
}

function getPortalPrevPage(curPageNumber) {
	getPortalOnPage(parseInt(curPageNumber) - 1);
}

function getPortalPrevPageWithRecords(curPageNumber, totalRecords) {
	getPortalOnPageWithRecords(parseInt(curPageNumber) - 1, totalRecords);
}

function getPortalNextPage(curPageNumber) {
	getPortalOnPage(parseInt(curPageNumber) + 1);
}

function getPortalNextPageWithRecords(curPageNumber, totalRecords) {
	getPortalOnPageWithRecords(parseInt(curPageNumber) + 1, totalRecords);
}

function getNextPageWithRecordsForRequest(curPageNumber, totalRecords, status, transferMode) {
	getPortalOnPageWithRecordsForRequest(parseInt(curPageNumber)+1, totalRecords, status, transferMode);
}

function getLastPageWithRecordsForRequest(curPageNumber, totalRecords, status, transferMode) {
	getPortalOnPageWithRecordsForRequest(parseInt(curPageNumber), totalRecords, status, transferMode);
}

function getPortalPrevPageWithRecordsForRequest(curPageNumber, totalRecords, status, transferMode) {
	getPortalOnPageWithRecordsForRequest(parseInt(curPageNumber) - 1, totalRecords, status, transferMode);
}

function formReset(id) {
	document.getElementsByName(id).reset();
}

function downloadReport(curPageNumber, type) {
	 get('downloadPageNumberId').value = curPageNumber;
	 get('downloadTypeId').value = type;
	 document.forms["downloadReport"].submit();
	}
function downloadSubMerchantReport(curPageNumber, type) {
	 get('downloadPageNumberId').value = curPageNumber;
	 get('downloadTypeId').value = type;
	 document.forms["downloadReport"].submit();
	}

function amountValidate(el, evt) {
    var charCode = (evt.which) ? evt.which : event.keyCode;
    if (evt.which===8)
    { 
        return;                                          
    }
    var number = el.value.split('.');
    if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }

    var caratPos = getSelectionStart(el);
    var dotPos = el.value.indexOf(".");
    if( caratPos > dotPos && dotPos>-1 && (number[1].length > 1)){
        return false;
    }    
    return true;
}

function downloadSelectedReport(curPageNumber, type) {
	 get('downloadPageNumberId').value = curPageNumber;
	 get('downloadTypeId').value = type;
		var names = [];
		$('.transaction:checked').each(function() {
			names.push(this.value);
		});
		var myJsonString = JSON.stringify(names);
		get("downloadReportId").value = names;
	 document.forms["downloadReport"].submit();
	}
function downloadAllExecutedTxnsReport(curPageNumber, type) {
	 get('downloadPageNumberId').value = curPageNumber;
	 get('downloadTypeId').value = type;
		var names = [];
		$('.transaction:checked').each(function() {
			names.push(this.value);
		});
		var myJsonString = JSON.stringify(names);
		get("downloadReportId").value = names;
	 document.forms["downloadReport"].submit();
	}
function downloadRequestReport(transferMode,status,curPageNumber, type) {
	 get('downloadPageNumberId').value = curPageNumber;
	 get('downloadTypeId').value = type;
	 get('transferModeId').value=transferMode;
	 get('statusId').value=status;
	 document.forms["downloadReport"].submit();
	}

function numbersonly(myfield, keyevent){
	var key;
	var keychar;
	if (window.event)
		key = window.event.keyCode;
	else if (keyevent)
		key = keyevent.which;
	else
		return true;
	keychar = String.fromCharCode(key);

	// control keys
	if ((key==null) || (key==0) || (key==8) || 
			(key==9) || (key==13) || (key==27) ){
		return true;
	}else if ((("0123456789").indexOf(keychar) > -1)){
		return true;
	}else{
		return false;
	}
}