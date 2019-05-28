function editFeeProgram(feeProgramId) {
	get('getFeeProgramId').value = feeProgramId;
	document.forms["editFeeProgramForm"].submit();
}

function formatAmount(amount) {

	var value = parseFloat(amount).toFixed(2);
	if (isNaN(value)) {
		amount = '';
		return amount;
	} else {

		return parseFloat(value).toFixed(2);
	}

}

var statusflag = true;

function validateFeeProgramFormData() {
	var flag = true;
	if (!feeProgramNameMethod() | !feeprogramDescription()
			| !validateProcessor() | !validateMultiSelect()) {

		return false;

	}

	if (tableContentCounter > 0) {
		for ( var i = 1; i <= tableContentCounter; i++) {
			if (!validateValue("feeValL1" + i)
					| !validateMinimuVal("feeValL2" + i)
					| !validateMaxVal("feeValL3" + i))
				flag = false;

			if (i == tableContentCounter) {
				return flag;
			}

		}

	}

	return flag;
}

function validateFeeProgramFormDataEdit() {
	var flag = true;
	if (!feeProgramNameMethod() | !feeprogramDescription()
			| !validateProcessor() | !validateMultiSelect() | !validateStatus()) {

		return false;

	}

	if (tableContentCounter > 0) {
		for ( var i = 1; i <= tableContentCounter; i++) {
			if (!validateValue("feeValL1" + i)
					| !validateMinimuVal("feeValL2" + i)
					| !validateMaxVal("feeValL3" + i))
				flag = false;

			if (i == tableContentCounter) {
				return flag;
			}

		}

	}

	return flag;
}

function validateForm() {
	$("#feeProgramCreate").validate();
}

function feeProgramNameMethod() {
	var feeProgram = get('feeProgramName').value.trim();
	if (isEmpty(feeProgram)) {
		setError(get('feeProgramName'), 'Please enter feeProgram ');
		return false;
	} else {
		setError(get('feeProgramName'), '');
		return true;
	}
}

function feeprogramDescription() {
	var feeProgramDescription = get('feeProgramDescription').value.trim();
	if (isEmpty(feeProgramDescription)) {
		setError(get('feeProgramDescription'), 'Please enter feeProgram Desc');
		return false;
	} else {
		setError(get('feeProgramDescription'), '');
		return true;
	}
}

function validateProcessor() {
	var processor = get('processorId').value.trim();
	if (isEmpty(processor)) {
		setError(get('processorId'), 'Please select processor ');
		return false;
	} else {
		setError(get('processorId'), '');
		return true;
	}
}

function validateStatus() {
	var status = get('status').value.trim();
	if (isEmpty(status)) {
		setError(get('status'), 'Please select Status ');
		return false;
	} else {
		setError(get('status'), '');
		return true;
	}
}
function validateMultiSelect() {
	/* if (ValidationRules.fee_Short_Code.mandatory == true) { */
	var multiEle = get('selectedFeeShortCodes');
	if (multiEle.options.length <= 0) {
		setDiv('selectedFeeShortCodes_ErrorDiv', "*This field is mandatory*");
		return false;
	} else {
		setDiv('selectedFeeShortCodes_ErrorDiv', "");
		return true;
	}
	/*
	 * } return true;
	 */
}

function validateValue(id) {

	$("#" + id).next().children().text("");
	var flag = true;
	var val = getVal(id);
	var number = Number(val);
	if (val == "") {
		$("#" + id).next().children().text("Please enter the value");
		statusflag = false;
		return false;
	}

	else if (number < 0) {
		$("#" + id).next().children().text("Please enter the Positive Number");
		statusflag = false;
		return false;
	} else if (!numericDecimal(val, id))
		return false;

	statusflag = true;
	return flag;

}

function validateMinimuVal(id) {

	$("#" + id).next().children().text("");
	var flag = true;
	var val = getVal(id);
	var number = Number(val);
	if (val == "") {
		$("#" + id).next().children().text("Please enter the value");
		statusflag = false;
		return false;
	} else if (number < 0) {
		$("#" + id).next().children().text("Please enter the Possitive Number");
		statusflag = false;
		return false;
	} else if (!numericDecimal(val, id))
		return false;
	statusflag = true;
	return flag;
}

function validateMaxVal(id) {

	$("#" + id).next().children().text("");
	var flag = true;
	var val = getVal(id);
	var number = Number(val);
	if (val == "") {
		$("#" + id).next().children().text("Please enter the value");
		statusflag = false;
		return false;
	}

	else if (number < 0) {
		$("#" + id).next().children().text("Please enter the Positive Number");
		statusflag = false;
		return false;
	}

	else if (!numericDecimal(val, id))
		return false;
	statusflag = true;
	return flag;
}

function numericDecimal(data, div_id) {
	var regex = /^(?:0|[1-9]\d*)(?:\.(?!.*000)\d+)?$/;

	if (regex.test(data)) {
		$("#" + div_id).next().children().text("");
		return true;
	} else {
		$("#" + div_id).next().children().text("*Should contain only numbers*");
		return false;

	}
}
function resetFeeSearch() {
	window.location.href = 'show-fee-program-search';
}

function resetFeeCreate() {
	window.location.href = 'show-fee-program-create';
}

function editPartnerFee(merchantId) {
	get('getMerchantId').value = merchantId;
	document.forms["showChatakPartnerFeeEdit"].submit();
}

function validateFeeProgramEdit(){
	var flag = false;
	if(!clientValidation('feePercentageOnly', 'amount','percentageOfTxnErrorDiv')
			| !clientValidation('flatFee', 'amount','flatFeeErrorDiv')){
		return flag;
	}else{
		flag = true;
		return flag;
	}
}

function editAcquirerFee(acquirerId){
	get('getAquirerId').value = acquirerId;
	document.forms["showChatakAquirerFeeEdit"].submit();
}

function getAcquirerFees(partnerId){
	get('partnerId').value = partnerId;
	document.forms["getAcquirerFeesForm"].submit();
}

function validateAcquirerFeeCode(){
	var flag = false;
	if(!clientValidation('acquirerFeeName', 'country','acquirerFeeNameErrorDiv')
			|!clientValidation('feePercentageOnlyAcquirer', 'amount','feePercentageOnlyAcquirerErrorDiv')
			|!clientValidation('flatFeeAcquirer', 'amount','flatFeeAcquirerErrorDiv')){
		return flag;
	}else{
		flag = true;
		return flag;
	}
}
