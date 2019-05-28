var usernameFlag = null;
function cancelCreateMerchant() {
	window.location.href = 'merchant-search';
}

function cancelCreateSubMerchant() {
	//window.location.href = 'showSubMerchantList';
	get('getParentMerchantId').value = getVal('getParentMercId');
	document.forms["showSubMerchantList"].submit();
}

function validateCreateMerchantStep1() {
	var flag = true;
	if (!validateBusinessName() | !validateFirstName() | !validateLastName()
			| !validatePhone()// | !validateFax()
			| !validateAddress1()
			| !validateCity() | !validateEmailId() | !validateState()
			| !validateCountry() | !validatePin() |!validateStatus() | !validateAppMode() |!validateURL()) {
		return false;
	}else{
		var faxValue = getVal('fax').trim();
		var lookingForValue = getVal('lookingFor').trim();
		var businessTypeValue = getVal('businessType').trim();
		if(faxValue != ""){
			setLable('confirmMfax', getVal('fax').trim());
		}else{
			setLable('confirmMfax', "");
		}if(lookingForValue != ""){
			setLable('confirmLookingFor', lookingForValue);
		}else{
			setLable('confirmLookingFor', "");
		}if(businessTypeValue != ""){
			setLable('confirmBusinessType', businessTypeValue);
		}else{
			setLable('confirmBusinessType', "");
		}
	}

	return flag;
}
function validateCreateMerchantStep2() {
	var flag = true;
	if(!clientValidation('bankAccountName', 'bank_name','bankAccountNameErrorDiv')
		//	|!validRoutingNumber()
			|!clientValidation('bankAccountNumber', 'account_numberBank','bankAccountNumberErrorDiv')
			|!clientValidation('bankRoutingNumber', 'routing_number','bankRoutingNumberEr')
			|!clientValidation('bankAccountType', 'account_type','bankAccountTypeErrorDiv')
			|!clientValidation('bankAddress1', 'bank_address2','bankAddress1ErrorDiv')
			|!clientValidation('bankAddress2', 'bank_address2','bankAddress2ErrorDiv')
			|!clientValidation('bankCity', 'bank_address2','bankCityErrorDiv')
			|!clientValidation('bankCountry', 'country','bankCountryErrorDiv')
			|!clientValidation('bankState', 'state','bankStateErrorDiv')
		    |!clientValidation('bankPin', 'zip','bankPinErrorDiv')
		    |!clientValidation('bankNameOnAccount', 'bank_name','bankNameOnAccountErrorDiv')){
		flag = false;
		return flag;
	}else{
		setLable('confirmbankAccountName', get('bankAccountName').value.trim());
		setLable('confirmbankRoutingNumber', get('bankRoutingNumber').value.trim());
		setLable('confirmbankAccountNumber', get('bankAccountNumber').value.trim());
	//	setLable('confirmbankAccountType', get('bankAccountType').value.trim());
		setTypeValueToConfirmPage();
		setLable('confirmbankAddress1', get('bankAddress1').value.trim());
		setLable('confirmbankAddress2', get('bankAddress2').value.trim());
		setLable('confirmbankCity', get('bankCity').value.trim());
		setLable('confirmbankCountry', get('bankCountry').value.trim());
		setLable('confirmbankState', get('bankState').value.trim());
		setLable('confirmbankPin', get('bankPin').value.trim());
		setLable('confirmbankNameOnAccount', get('bankNameOnAccount').value.trim());
		return flag;
	}
}

function validateCreateMerchantStep3() {
	var flag = true;
	if(!clientValidation('legalName', 'contractName','legalNameErrorDiv')
			|!clientValidation('legalTaxId', 'eIN_taxId','legalTaxIdErrorDiv')
			|!clientValidation('legalType', 'state','legalTypeErrorDiv')
			|!clientValidation('legalAnnualCard', 'credit_amount','legalAnnualCardErrorDiv')
			|!clientValidation('legalFirstName', 'first_name','legalFirstNameErrorDiv')
			|!clientValidation('legalLastName', 'last_name','legalLastNameErrorDiv')
			|!clientValidation('legalMobilePhone', 'mobile_phone','legalMobilePhoneErrorDiv')
			|!clientValidation('legalAddress1', 'bank_address1','legalAddress1ErrorDiv')
			|!clientValidation('legalAddress2', 'bank_address2','legalAddress2ErrorDiv')
			|!clientValidation('legalCity', 'bank_city','legalCityErrorDiv')
			|!clientValidation('legalCountry', 'country','legalCountryErrorDiv')
			|!clientValidation('legalState', 'state','legalStateErrorDiv')
			|!clientValidation('legalPin', 'zip','legalPinErrorDiv')){
		flag = false;
		return flag;
	}else{
		setLable('confirmlegalName', get('legalName').value.trim());
		setLable('confirmlegalTaxId', get('legalTaxId').value.trim());
	//	setLable('confirmlegalType', get('legalType').value.trim());
		setValuetoConfirmPage();
		setLable('confirmlegalAnnualCard', get('legalAnnualCard').value.trim());
		setLable('confirmlegalFirstName', get('legalFirstName').value.trim());
		setLable('confirmlegalLastName', get('legalLastName').value.trim());
		setLable('confirmlegalMobilePhone', get('legalMobilePhone').value.trim());
		setLable('confirmlegalAddress1', get('legalAddress1').value.trim());
		setLable('confirmlegalAddress2', get('legalAddress2').value.trim());
		setLable('confirmlegalCity', get('legalCity').value.trim());
		setLable('confirmlegalCountry', get('legalCountry').value.trim());
		setLable('confirmlegalState', get('legalState').value.trim());
		setLable('confirmlegalPin', get('legalPin').value.trim());
		return flag;
	}
}

function setTypeValueToConfirmPage(){
//	setLable('confirmbankAccountType', get('bankAccountType').value.trim());
	var accTypeValue = document.getElementById("bankAccountType");
	var accTypeValueText = accTypeValue.options[accTypeValue.selectedIndex].text;
	setLable('confirmbankAccountType', accTypeValueText);
}

function setValuetoConfirmPage(){
	//var typeValue = get('legalType').value.trim();
	
	var typeValue = document.getElementById("legalType");
	var typeValueText = typeValue.options[typeValue.selectedIndex].text;
	setLable('confirmlegalType', typeValueText);
	
	/*if(typeValue == "1"){
		setLable('confirmlegalType', "Association Estate Trust");
	}
	if(typeValue == "2"){
		setLable('confirmlegalType', "Corporation");
	}
	if(typeValue == "3"){
		setLable('confirmlegalType', "Government Agency");
	}
	if(typeValue == "4"){
		setLable('confirmlegalType', "Individual/Sole Proprietorship");
	}
	if(typeValue == "5"){
		setLable('confirmlegalType', "International Orginization");
	}
	if(typeValue == "6"){
		setLable('confirmlegalType', "Limited Liability Company(LLC)");
	}
	if(typeValue == "7"){
		setLable('confirmlegalType', "Partnership");
	}
	if(typeValue == "8"){
		setLable('confirmlegalType', "Tax Exempt Organization(501C)");
	}
	if(typeValue == "11"){
		setLable('confirmlegalType', "Testing");
	}*/
}

function validateLegalEntity(){
	var flag = true;
	/*if(!clientValidation('legalSSN', 'ssn','legalSSNErrorDiv')
			|!clientValidation('legalDOB', 'startDate','legalDOBErrorDiv')
			|!clientValidation('legalPassport', 'bank_code','legalPassportErrorDiv')
			|!clientValidation('legalCountryResidence', 'bank_country','legalCountryResidenceErrorDiv')
			|!clientValidation('legalCitizen', 'bank_country','legalCitizenErrorDiv')
			|!clientValidation('legalHomePhone', 'contact_phone','legalHomePhoneErrorDiv')){
		flag = false;
		return flag;
	}else{*/
		setLable('confirmlegalSSN', get('legalSSN').value.trim());
		setLable('confirmlegalDOB', get('legalDOB').value.trim());
		setLable('confirmlegalPassport', get('legalPassport').value.trim());
		setLable('confirmlegalCountryResidence', get('legalCountryResidence').value.trim());
		setLable('confirmlegalCitizen', get('legalCitizen').value.trim());
		setLable('confirmlegalHomePhone', get('legalHomePhone').value.trim());
		return flag;
//	}
}

function validateCreateMerchantStep4() {
	var flag = true;
	if (!vlalidateUserName()// | !validatefederalTaxId() //| !validatestateTaxId() | !validatesalesTaxId()
			//| !validateOwnership()
		//	| !validateURL()
			/*| !validateBusinessStartDate() | !validateEstimatedYearlySale()
			| !validateNoOfEmployees() */) {

		return false;
	}
	return flag;
}
function validateCreateMerchantStep1edit() {
	var flag = true;
	if (!validateBusinessName() | !validateFirstName() | !validateLastName()
			| !validatePhone() | !validateEmailIdEdit() 
			| !validateAddress1()
			| !validateCity() | !validateState() | !validateCountry()
			| !validatePin() | !validateStatus() | !validateAppMode() |!validateURL()) {
		return false;
	}else{
		var faxValue = getVal('fax').trim();
		var lookingForValue = getVal('lookingFor').trim();
		var businessTypeValue = getVal('businessType').trim();
		if(faxValue != ""){
		setLable('confirmMfax', getVal('fax').trim());
		}else{
			setLable('confirmMfax', "");
		}if(lookingForValue != ""){
			setLable('confirmLookingFor', lookingForValue);
		}else{
			setLable('confirmLookingFor', "");
		}if(businessTypeValue != ""){
			setLable('confirmBusinessType', businessTypeValue);
		}else{
			setLable('confirmBusinessType', "");
		}
	}

	return flag;
}

function validateCreateMerchantStep2edit() {
	var flag = true;
	if(!clientValidation('bankAccountName', 'bank_name','bankAccountNameErrorDiv')
		//	|!validRoutingNumber()
			|!clientValidation('bankAccountNumber', 'account_numberBank','bankAccountNumberErrorDiv')
			|!clientValidation('bankRoutingNumber', 'routing_number','bankRoutingNumberEr')
			|!clientValidation('bankAccountType', 'account_type','bankAccountTypeErrorDiv')
			|!clientValidation('bankAddress1', 'bank_address2','bankAddress1ErrorDiv')
			|!clientValidation('bankAddress2', 'bank_address2','bankAddress2ErrorDiv')
			|!clientValidation('bankCity', 'bank_address2','bankCityErrorDiv')
			|!clientValidation('bankCountry', 'country','bankCountryErrorDiv')
			|!clientValidation('bankState', 'state','bankStateErrorDiv')
		    |!clientValidation('bankPin', 'zip','bankPinErrorDiv')
		    |!clientValidation('bankNameOnAccount', 'bank_name','bankNameOnAccountErrorDiv')){
		flag = false;
		return flag;
	}else{
		setLable('confirmbankAccountName', get('bankAccountName').value.trim());
		setLable('confirmbankRoutingNumber', get('bankRoutingNumber').value.trim());
		setLable('confirmbankAccountNumber', get('bankAccountNumber').value.trim());
	//	setLable('confirmbankAccountType', get('bankAccountType').value.trim());
		setTypeValueToConfirmPage();
		setLable('confirmbankAddress1', get('bankAddress1').value.trim());
		setLable('confirmbankAddress2', get('bankAddress2').value.trim());
		setLable('confirmbankCity', get('bankCity').value.trim());
		setLable('confirmbankCountry', get('bankCountry').value.trim());
		setLable('confirmbankState', get('bankState').value.trim());
		setLable('confirmbankPin', get('bankPin').value.trim());
		setLable('confirmbankNameOnAccount', get('bankNameOnAccount').value.trim());
		return flag;
	}
}

function validateCreateMerchantStep3edit() {
	var flag = true;
	if(!clientValidation('legalName', 'contractName','legalNameErrorDiv')
			|!clientValidation('legalTaxId', 'eIN_taxId','legalTaxIdErrorDiv')
			|!clientValidation('legalType', 'state','legalTypeErrorDiv')
			|!clientValidation('legalAnnualCard', 'credit_amount','legalAnnualCardErrorDiv')
			|!clientValidation('legalFirstName', 'first_name','legalFirstNameErrorDiv')
			|!clientValidation('legalLastName', 'last_name','legalLastNameErrorDiv')
			|!clientValidation('legalMobilePhone', 'mobile_phone','legalMobilePhoneErrorDiv')
			|!clientValidation('legalAddress1', 'bank_address1','legalAddress1ErrorDiv')
			|!clientValidation('legalAddress2', 'bank_address2','legalAddress2ErrorDiv')
			|!clientValidation('legalCity', 'bank_city','legalCityErrorDiv')
			|!clientValidation('legalCountry', 'country','legalCountryErrorDiv')
			|!clientValidation('legalState', 'state','legalStateErrorDiv')
			|!clientValidation('legalPin', 'zip','legalPinErrorDiv')){
		flag = false;
		return flag;
	}else{
		setLable('confirmlegalName', get('legalName').value.trim());
		setLable('confirmlegalTaxId', get('legalTaxId').value.trim());
		//setLable('confirmlegalType', get('legalType').value.trim());
		setValuetoConfirmPage();
		setLable('confirmlegalAnnualCard', get('legalAnnualCard').value.trim());
		setLable('confirmlegalFirstName', get('legalFirstName').value.trim());
		setLable('confirmlegalLastName', get('legalLastName').value.trim());
		setLable('confirmlegalMobilePhone', get('legalMobilePhone').value.trim());
		setLable('confirmlegalAddress1', get('legalAddress1').value.trim());
		setLable('confirmlegalAddress2', get('legalAddress2').value.trim());
		setLable('confirmlegalCity', get('legalCity').value.trim());
		setLable('confirmlegalCountry', get('legalCountry').value.trim());
		setLable('confirmlegalState', get('legalState').value.trim());
		setLable('confirmlegalPin', get('legalPin').value.trim());
		return flag;
	}
}

function validateCreateMerchantStep4edit() {
	var flag = true;
	if (!vlalidateUserNameEdit()// | !validatestateTaxId() | !validatesalesTaxId()
			//!validateOwnership() | 
			//!validateURL()
			) {
		return false;
	}
	setLable('confirmMemailId', get('emailId').value.trim());
	setLable('confirmMmerchantCode', get('merchantCode').value.trim());
	setLable('confirmMuserName', get('userName').value.trim());

	return flag;
}

function validateCreateMerchantStep5() {
	var flag = true;
	if (!validatefeeProgram() | !validateProcessor() | !validateCheckBox()
			| !validateRadio() | !validateCallbackURL() |!validateCategory()
			| !validateAutoPaymentMethod() | !validateAutoTransferLimit()) {
		return false;
	}
	var fieldsValue = get('autoTransferDay').value;
	var processor = get('processor').value.trim();
	
	if(fieldsValue == ""){
		setLable('confirmMautoTransferDay', "");
	}
	if(fieldsValue == "D"){
		setLable('confirmMautoTransferDay', "Daily");
		$('#hideDayTable').hide();
		$('#hideWeekyTable').hide();
		setLable('confirmAutoTransferWeeklyDay',"");
		setLable('confirmAutoTransferMonthlyDay',"");
	}
	if(fieldsValue == "W"){
		if(!clientValidation('autoTransferWeeklyDay', 'state','autoTransferWeeklyDayEr')){
			return false;
		}else{
			setLable('confirmMautoTransferDay', "Weekly");
			$('#hideDayTable').show();
			$('#hideWeekyTable').hide();
			setDiv('autoTransferWeeklyDayEr',"");
		//	var weekValue = get('autoTransferWeeklyDay').value.trim();
			
			var weekValue = document.getElementById("autoTransferWeeklyDay");
			var weekDay = weekValue.options[weekValue.selectedIndex].text;
			setLable('confirmAutoTransferWeeklyDay', weekDay);
			
			/*if(weekValue == "2"){
				setLable('confirmAutoTransferWeeklyDay', "Monday");
			}
			if(weekValue == "3"){
				setLable('confirmAutoTransferWeeklyDay', "Tuesday");
			}
			if(weekValue == "4"){
				setLable('confirmAutoTransferWeeklyDay', "Wednesday");
			}
			if(weekValue == "5"){
				setLable('confirmAutoTransferWeeklyDay', "Thursday");
			}
			if(weekValue == "6"){
				setLable('confirmAutoTransferWeeklyDay', "Friday");
			}*/
		}
	}
	if(fieldsValue == "M"){
		if(!clientValidation('autoTransferMonthlyDay', 'state','autoTransferMonthlyDayEr')){
			return false;
		}else{
			setLable('confirmMautoTransferDay', "Monthly");
			$('#hideDayTable').hide();
			$('#hideWeekyTable').show();
			setDiv('autoTransferMonthlyDayEr',"");
			setLable('confirmAutoTransferMonthlyDay', get('autoTransferMonthlyDay').value.trim());
		}
	}
	
	if(processor == "LITLE"){
		return validatelitleMID();
	}else{
		setLable('confirmLitleMID', '');
	}
	//var dayValue = get('autoTransferDay').value.trim();
	/*if(fieldsValue == "D"){
		setLable('confirmMautoTransferDay', "Daily");
		$('#hideDayTable').hide();
		$('#hideWeekyTable').hide();
	}
	if(fieldsValue == "M"){
		setLable('confirmMautoTransferDay', "Monthly");
		$('#hideDayTable').hide();
		$('#hideWeekyTable').show();
	//	setLable('confirmAutoTransferMonthlyDay', get('autoTransferMonthlyDay').value.trim());
	}
	if(fieldsValue == "W"){
		setLable('confirmMautoTransferDay', "Weekly");
		$('#hideDayTable').show();
		$('#hideWeekyTable').hide();
	//	setLable('confirmAutoTransferWeeklyDay', get('autoTransferWeeklyDay').value.trim());
	}*/
	
	//setLable('confirmMautoTransferDay', get('autoTransferDay').value.trim());

	return flag;
}

function validateAddress1() {
	var address1 = get('address1').value.trim();
	/* var addRegx = /^[A-Za-z0-9\#\$\&\,]+(\s{0,1}[a-zA-Z0-9,])*$/; */
	if (isEmpty(address1)) {
		setError(get('address1'), 'Please enter Address1');
		return false;
	} else if (address1.length < 5) {
		setError(get('address1'), 'Invalid Address1 Length');
		return false;
	} else {
		setError(get('address1'), '');
		setLable('confirmMaddress1', address1);
		return true;
	}
}

function validateAddress2() {
	var address2 = get('address2').value.trim();
		setError(get('address2'), '');
		setLable('confirmMaddress2', address2);
		return true;
}
function validateCity() {
	var city = get('city').value.trim();
	var cityRegx = /^[A-Za-z0-9\#\$\&]+(\s{0,1}[a-zA-Z0-9,])*$/;
	if (isEmpty(city)) {
		setError(get('city'), 'Please enter City');
		return false;
	} else if (!cityRegx.test(city)) {
		setError(get('city'), 'Invalid City');
		return false;
	} else {
		setError(get('city'), '');
		setLable('confirmMcity', city);
		return true;
	}
}

function validateState() {
	var state = get('state').value.trim();
	if (isEmpty(state)) {
		setError(get('state'), 'Please select State');
		return false;
	} else {
		setError(get('state'), '');
		setLable('confirmMstate', state);
		return true;
	}
}

function validateCountry() {
	var country = get('country').value.trim();
	if (isEmpty(country)) {
		setError(get('country'), 'Please select Country');
		return false;
	} else {
		setError(get('country'), '');
		setLable('confirmMcountry', country);
		return true;
	}
}

function validatePin() {
	var pin = getVal('pin');
	if (isEmpty(pin)) {
		setError(get('pin'), 'Please enter Zip');
		return false;
	} else if ((pin.length < 3) || (pin.length > 6)) {
		setError(get('pin'), 'Invalid zip');
		return false;
	} else if (!isValidZipChars(pin)) {
		setError(get('pin'), 'Invalid zip');
		return false;
	} else {
		setError(get('pin'), '');
		setLable('confirmMpin', pin);
		return true;
	}
}

function isValidZipChars(val) {
	var firstCharAlphaRegex = /^[A-Za-z0-9][  A-Za-z0-9 -_@ {}:?#$!()`\\*=]*$/;
	return firstCharAlphaRegex.test(val);
}

function submitCreateMerchant() {
	return true;
}

function editMerchant(merchantId) {
	get('getMerchantId').value = merchantId;
	document.forms["editMercahntForm"].submit();
}

function deleteMerchant(merchantId) {
	get('getMerchantsId').value = merchantId;
	document.forms["deleteMercahntForm"].submit();
}

function resetAllFields() {
	get('merchantCode').value = "";
	get('businessName').value = "";
	get('firstName').value = "";
	get('lastName').value = "";
	get('phone').value = "";
	get('status').value = "";
	get('city').value = "";
	get('country').value = "";
	get('emailId').value = "";
}

function validateMerchantCode() {
	var val = /[0-9]{6,16}$/;
	var merchantCode = get('merchantCode').value.trim();
	if (isEmpty(merchantCode)) {
		setError(get('merchantCode'), 'Please enter Merchant Code');
		return false;
	} else if (!val.test(merchantCode)) {
		setError(get('merchantCode'), 'Should be 6-16 numerics');
		return false;
	} else {
		setError(get('merchantCode'), '');
		setLable('confirmMmerchantCode', merchantCode);
		return true;
	}
}

function validateBusinessName() {
	var businessName = get('businessName').value.trim();
	var spaceRegx = /^[a-zA-Z0-9]+(\s{0,1}[a-zA-Z0-9])*$/;
	if (isEmpty(businessName)) {
		setError(get('businessName'), 'Please enter Company Name');
		return false;
	} else if (!spaceRegx.test(businessName)) {
		setError(get('businessName'), 'Invalid Company Name');
		return false;
	} else {
		setError(get('businessName'), '');
		setLable('confirmMbusinessName', businessName);
		return true;
	}
}

function validateFirstName() {
	var firstName = get('firstName').value.trim();
	if (isEmpty(firstName)) {
		setError(get('firstName'), 'Please enter First Name');
		return false;
	} else if (!isCharacter(firstName)) {
		setError(get('firstName'), 'Invalid First Name');
		return false;
	} else {
		setError(get('firstName'), '');
		setLable('confirmMfirstName', firstName);
		return true;
	}
}

function validateLastName() {
	var lastName = get('lastName').value.trim();
	if (isEmpty(lastName)) {
		setError(get('lastName'), 'Please enter last name');
		return false;
	} else if (!isCharacter(lastName)) {
		setError(get('lastName'), 'Invalid last name');
		return false;
	} else {
		setError(get('lastName'), '');
		setLable('confirmMlastName', lastName);
		return true;
	}
}

function validatePhone() {
	var phone = getVal('phone').trim();
	if (isEmpty(phone)) {
		setError(get('phone'), 'Please enter Phone Number');
		return false;
	} else if (!isDigit(phone) || phone.length < 10 || phone.length > 13
			|| phone == 0) {
		setError(get('phone'), 'Invalid Phone Number');
		return false;
	} else if (phone.charAt(parseInt("0")) == "0") {
		setError(get('phone'), 'Phone cannot start with zero');
		return false;
	} else {
		setError(get('phone'), '');
		setLable('confirmMphone', phone);
		return true;
	}
}

function validateFax() {
	var fax = getVal('fax').trim();
	if (isEmpty(fax)) {
		setError(get('fax'), 'Please enter Fax');
		return false;
	} else if (!isDigit(fax) || fax.length < 10 || fax.length > 13 || fax == 0) {
		setError(get('fax'), 'Invalid fax');
		return false;
	} else if (fax.charAt(parseInt("0")) == "0") {
		setError(get('fax'), 'fax cannot start with zero');
		return false;
	} else {
		setError(get('fax'), '');
		setLable('confirmMfax', fax);
		return true;
	}
}

function validateEmailId() {

	var reg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	var emailAddress = get('emailId').value.trim();

	if (isEmpty(emailAddress)) {
		setError(get('emailId'), 'Please enter Email');
		return false;
	}

	else if (reg.test(emailAddress) == false) {

		setError(get('emailId'), 'Invalid Email');
		return false;
	} else {
		if (alpha.indexOf(emailAddress.charAt(0)) == -1) {
			setError(get('emailId'), 'Invalid Email');
			return false;
		} else {
			doAjaxFetchMailIdAvailable();
			if (usernameFlag == false) {
				return true;
			} else {
				return false;
			}
		}

		/*
		 * setError(get('emailId'), ''); setLable('confirmMemailId',
		 * emailAddress); return true;
		 */
	}

}

function validateTimeZone() {
	var timeZone = get('timeZone').value.trim();
	if (isEmpty(timeZone)) {
		setError(get('timeZone'), 'Please enter Time Zone ');
		return false;
	} else {
		setError(get('timeZone'), '');
		setLable('confirmMtimeZone', timeZone);
		return true;
	}
}

function validateAppMode() {
	var appMode = get('appMode').value.trim();
	if (isEmpty(appMode)) {
		setError(get('appMode'), 'Please select App Mode ');
		return false;
	} else if (!isChar(appMode)) {
		setError(get('appMode'), 'Invalid App Mode');
		return false;
	} else {
		setError(get('appMode'), '');
		setLable('confirmMappMode', appMode);
		return true;
	}
}

function validateStatus() {
	var status = get('status').value.trim();
	var statusValue = document.getElementById("status");
	var x = statusValue.options[statusValue.selectedIndex].text;
	if (isEmpty(status)) {
		setError(get('status'), 'Please select Status ');
		return false;
	}
	/*
	 * else if(!isChar(status)){ setError(get('status'), 'Invalid status');
	 * return false; }
	 */
	else {
		setError(get('status'), '');
		setLable('confirmMstatus', x);
		return true;
	}
}

function validatefederalTaxId() {
	var federalTaxId = get('federalTaxId').value.trim();
	if (isEmpty(federalTaxId)) {
		setError(get('federalTaxId'), 'Please enter Federal Tax Id');
		return false;
	} else if (!isCharacter(federalTaxId)) {
		setError(get('federalTaxId'), 'Invalid Federal Tax Id');
		return false;
	} else {
		setError(get('federalTaxId'), '');
		setLable('confirmMfederalTaxId', federalTaxId);
		return true;
	}
}

function validatestateTaxId() {
	var stateTaxId = get('stateTaxId').value.trim();
	if (isEmpty(stateTaxId)) {
		setError(get('stateTaxId'), 'Please enter State Tax Id');
		return false;
	} else if (!isCharacter(stateTaxId)) {
		setError(get('stateTaxId'), 'Invalid State Tax Id');
		return false;
	} else {
		setError(get('stateTaxId'), '');
		setLable('confirmMstateTaxId', stateTaxId);
		return true;
	}
}

function validatesalesTaxId() {
	var salesTaxId = get('salesTaxId').value.trim();
	if (isEmpty(salesTaxId)) {
		setError(get('salesTaxId'), 'Please enter Sales Tax Id');
		return false;
	} else if (!isCharacter(salesTaxId)) {
		setError(get('salesTaxId'), 'Invalid Sales Tax Id');
		return false;
	} else {
		setError(get('salesTaxId'), '');
		setLable('confirmMsalesTaxId', salesTaxId);
		return true;
	}
}

function validateOwnership() {
	var ownership = get('ownership').value.trim();
	if (isEmpty(ownership)) {
		setError(get('ownership'), 'Please select Ownership ');
		return false;
	} else {
		setError(get('ownership'), '');
		setLable('confirmMownership', ownership);
		return true;
	}
}

function validateBusinessStartDate() {
	var flag = false;
	var date1 = getVal('businessStartDate').trim();
	var editStartDate = '';
	if (!isEmpty(date1)) {
		if (editStartDate == date1) {
			setError(get('businessStartDate'),
					'Please enter the Valid Business Start Date');
			return true;
		}
	}

	var cdate = new Date();
	var bdate = cdate.getFullYear() + "/" + (cdate.getMonth() + 1) + "/"
			+ cdate.getDate();

	var arr = date1.split("/");
	var dateString = arr[2] + "/" + arr[1] + "/" + arr[0];

	var givdate = new Date(dateString);
	var currentDate = new Date(bdate);

	if (date1 == "" || date1.length == 0) {
		setError(get('businessStartDate'),
				'Please enter the Valid Business Start Date');
		flag = false;
	} else if (givdate < currentDate) {
		setError(get('businessStartDate'),
				'Business Start Date should not be past date');
		flag = false;
	} else {
		setError(get('businessStartDate'), '');
		setLable('confirmMbusinessStartDate', date1);
		flag = true;
	}
	return flag;
}

function validateEstimatedYearlySale() {
	var estimatedYearlySale = get('estimatedYearlySale').value.trim();
	if (isEmpty(estimatedYearlySale)) {
		setError(get('estimatedYearlySale'),
				'Please enter Estimated Yearly Sale ');
		return false;
	} else if (!isDigit(estimatedYearlySale)) {
		setError(get('estimatedYearlySale'), 'Invalid Estimated Yearly Sale');
		return false;
	} else {
		setError(get('estimatedYearlySale'), '');
		setLable('confirmMestimatedYearlySale', estimatedYearlySale);
		return true;
	}
}

function validateNoOfEmployees() {
	var noOfEmployee = get('noOfEmployee').value.trim();
	if (isEmpty(noOfEmployee)) {
		setError(get('noOfEmployee'), 'Please enter No. of Employee ');
		return false;
	} else if (!isDigit(noOfEmployee)) {
		setError(get('noOfEmployee'), 'Invalid No. of Employee');
		return false;
	} else {
		setError(get('noOfEmployee'), '');
		setLable('confirmMnoOfEmployee', noOfEmployee);
		return true;
	}
}

function validateRole() {
	var role = get('role').value.trim();
	if (isEmpty(role)) {
		setError(get('role'), 'Please enter Role');
		return false;
	} else {
		setError(get('role'), '');
		setLable('confirmMrole', role);
		return true;
	}
}

function validatefeeProgram() {
	var feeProgram = get('feeProgram').value.trim();
	if (isEmpty(feeProgram)) {
		setError(get('feeProgram'), 'Please select Fee Program ');
		return false;
	} else {
		setError(get('feeProgram'), '');
		setLable('confirmMfeeProgram', feeProgram);
		return true;
	}
}

function validateProcessor() {
	var processor = get('processor').value.trim();
	var processorValue = document.getElementById("processor");
	var x = processorValue.options[processorValue.selectedIndex].text;
	if (isEmpty(processor)) {
		setError(get('processor'), 'Please select Processor');
		return false;
	} else {
		setError(get('processor'), '');
		setLable('confirmMprocessor', x);
		
		if(processor == "LITLE"){
			$('#vantivMerchantId').show();
		}else{
				setValue('litleMID', '');
				setLable('confirmLitleMID', '');
				$('#vantivMerchantId').hide();
		}
		return true;
	}
}

function validateURL() {
	//var reg = /[-a-zA-Z0-9@:%._\+~#=]{2,256}\.[a-z]{2,6}\b([-a-zA-Z0-9@:%_\+.~#?&\/=]*)/;
	var reg = /(\w)+\.(\w)+\.(\w)/;
	var businessURL = get('businessURL').value.trim();

	if (isEmpty(businessURL)) {
		setError(get('businessURL'), 'Please enter Business URL');
		return false;
	} else if (reg.test(businessURL) == false) {
		setError(get('businessURL'), 'Invalid Business URL');
		return false;
	} else {
		setError(get('businessURL'), '');
		setLable('confirmMbusinessURL', businessURL);
		return true;
	}

}

function validateCallbackURL() {
	//var reg = /[-a-zA-Z0-9@:%._\+~#=]{2,256}\.[a-z]{2,6}\b([-a-zA-Z0-9@:%_\+.~#?&\/=]*)/;
	var reg = /(\w)+\.(\w)+\.(\w)/;
	var merchantCallBackURL = get('merchantCallBackURL').value.trim();
	if (isEmpty(merchantCallBackURL)) {
		setError(get('merchantCallBackURL'), '');
		setLable('confirmMmerchantCallBackURL', merchantCallBackURL);
		return true;
	} else if (reg.test(merchantCallBackURL) == false) {
		setError(get('merchantCallBackURL'), 'Invalid Merchant CallBack URL');
		return false;
	} else {
		setError(get('merchantCallBackURL'), '');
		setLable('confirmMmerchantCallBackURL', merchantCallBackURL);
		return true;
	}
}

function validateCategory(){
	var category = get('category').value.trim();
	if (isEmpty(category)) {
		setError(get('category'), 'Please select Category');
		return false;
	}  else {
		setError(get('category'), '');
		setLable('confirmMcategory', category);
		return true;
	}
}

function validateAutoPaymentMethod() {
	var autoPaymentMethod = get('autoPaymentMethod').value.trim();
	if (isEmpty(autoPaymentMethod)) {
		setError(get('autoPaymentMethod'), 'Please select Payment Method');
		return false;
	} else {
		setError(get('autoPaymentMethod'), '');
		setLable('confirmMautoPaymentMethod', autoPaymentMethod);
		return true;
	}
}

function validateAutoTransferLimit() {
	var reg = /^[0-9]+(\.[0-9][0-9]?)?$/;
	var autoTransferLimit = get('autoTransferLimit').value.trim();
	if (isEmpty(autoTransferLimit)) {
		setError(get('autoTransferLimit'), '');
		return true;
	} else if (reg.test(autoTransferLimit) == false) {
		setError(get('autoTransferLimit'), 'Invalid Estimated Yearly Sale');
		return false;
	} else {
		setError(get('autoTransferLimit'), '');
		setLable('confirmMautoTransferLimit', autoTransferLimit);
		return true;
	}
}

function validatelitleMID() {
	var litleMID = get('litleMID').value.trim();
	if (isEmpty(litleMID)) {
		setError(get('litleMID'), 'Invalid Vantiv Merchant Id');
		return false;
	} else if (!isDigit(litleMID)) {
		setError(get('litleMID'), 'Invalid Vantiv Merchant Id');
		return false;
	} else {
		setError(get('litleMID'), '');
		setLable('confirmLitleMID', litleMID);
		return true;
	}
}

function validateRadio() {
	var autoSettlement = document.getElementsByName('autoSettlement');

	if ((autoSettlement[0].checked == false)
			&& (autoSettlement[1].checked == false)) {
		setError(get('noAutoSettlement'), 'Please select one');
		return false;
	} else {
		if (autoSettlement[0].checked == true) {
			setError(get('noAutoSettlement'), '');
			setLable('confirmMautoSettlement', 'yes');
			return true;
		}

		else {
			setError(get('noAutoSettlement'), '');
			setLable('confirmMautoSettlement', 'no');
			return true;
		}
	}
}

function validateCheckBox() {

	var list = "";
	if (get('refunds').checked)
		list = list + document.getElementById("refunds").name + ",";
	if (get('tipAmount').checked)
		list = list + document.getElementById("tipAmount").name + ",";
	if (get('taxAmount').checked)
		list = list + document.getElementById("taxAmount").name + ",";
	if (get('shippingAmount').checked)
		list = list + document.getElementById("shippingAmount").name + ",";
	if (get('allowRepeatSale').checked) {
		if (list.length > 42)
			list = list + document.getElementById("allowRepeatSale").name
					+ '\n';
		else
			list = list + document.getElementById("allowRepeatSale").name + ",";
	}
	if (get('showRecurringBilling').checked)
		list = list + document.getElementById("showRecurringBilling").name
				+ " ";

	/*
	 * if (get('refunds').checked | get('tipAmount').checked |
	 * get('taxAmount').checked | get('shippingAmount').checked |
	 * get('allowRepeatSale').checked | get('showRecurringBilling').checked) {
	 */
	if (list != "") {
		list = list.substring(0, list.length - 1);
		setError(get('refunds'), '');

		setLable('confirmMvirtualTerminal', list);
		return true;
	} else {
		setError(get('refunds'), 'Please select one Virtual Terminal');

		return false;
	}

}

function vlalidateUserName() {
	var reg = /^[A-Za-z0-9. _]{8,16}$/;
	var userName = get('userName').value.trim();

	if (isEmpty(userName)) {
		setError(get('userName'), 'Please enter User Name ');
		document.getElementById('userNamegreenEr').innerHTML = "";
		return false;
	} else if (reg.test(userName) == false) {
		setError(get('userName'), '*Can contain 8-16 alpha & numerics');
		document.getElementById('userNamegreenEr').innerHTML = "";
		return false;
	} else {

		doAjaxFetchUsernameAvailable();
		if (usernameFlag == true) {
			return true;
		} else {
			return false;
		}

	}
}

function doAjaxFetchUsernameAvailable() {
	var userName = get('userName').value.trim();

	$
			.ajax({
				type : "GET",
				url : "uniqueUser?userName=" + userName,
				async : false,
				success : function(response) {
					var obj = JSON.parse(response);
					if (obj.errorCode === '00') {
						setError(get('userName'), '');
						document.getElementById('userNamegreenEr').innerHTML = "User Name available";
						setLable('confirmMuserName', get('userName').value
								.trim());
						usernameFlag = true;

					} else {
						setError(get('userName'), 'User Name not available');
						document.getElementById('userNamegreenEr').innerHTML = "";
						usernameFlag = false;
						;
					}
				},
				error : function(e) {
				}
			});
}

function fetchMerchantState(countryid, elementId) {

	if (countryid == '') {
		clearState(elementId);
		return;
	}

	getStates(countryid, elementId);
}

function getStates(countryid, elementId) {
	$.ajax({
		type : "GET",
		url : "getStatesById?countryid=" + countryid,
		async : false,
		success : function(response) {
			var obj = JSON.parse(response);
			if (obj.errorCode === '00') {
				// remove the previous option from element
				document.getElementById(elementId).options.length = 0;

				// create select option
				var selectOption = document.createElement("option");
				selectOption.innerHTML = "..:Select:..";
				selectOption.value = "";
				$(("#"+elementId)).append(selectOption);

				if (obj.errorMessage == "SUCCESS") {
					var data = obj.responseList;

					for (var i = 0; i < data.length; i++) {
						var state = data[i].label;

						var newOption = document.createElement("option");
						newOption.value = data[i].value;
						newOption.innerHTML = state;

						$(("#"+elementId)).append(newOption);
					}
				}
			}
		},
		error : function(e) {
		}
	});

}

function clearState(elementId) {

	document.getElementById(elementId).options.length = 0;

	var selectOption = document.createElement("option");
	selectOption.innerHTML = "..:Select:..";
	selectOption.value = "";

	$(("#"+elementId)).append(selectOption);
}
function fetchMerchantStateForUpdate(countryid, elementId) {

	if (countryid == '') {
		clearState(elementId);
		return;
	}

	getStatesForUpdate(countryid, elementId);
}

function getStatesForUpdate(countryid, elementId) {
	if (countryid == '') {
		/* clearState(); */
		return;
	} else if (countryid === "US" || countryid === "us") {
		countryid = "2";
	}

	// var countryid = this.countryid;
	$.ajax({
		type : "GET",
		url : "getStatesById?countryid=" + countryid,
		async : false,
		success : function(response) {
			var obj = JSON.parse(response);
			if (obj.errorCode === '00') {
				// remove the previous option from element
				document.getElementById(elementId).options.length = 1;

				// create select option
				/*
				 * var selectOption = document.createElement("option");
				 * selectOption.innerHTML = ""+stateId; selectOption.value =
				 * ""+stateId; $("#state").append(selectOption);
				 */

				if (obj.errorMessage == "SUCCESS") {
					var data = obj.responseList;

					for (var i = 0; i < data.length; i++) {
						var state = data[i].label;

						var newOption = document.createElement("option");
						newOption.value = data[i].value;
						newOption.innerHTML = state;

						$(("#"+elementId)).append(newOption);
					}
				}
			}
		},
		error : function(e) {
		}
	});

}

function confirmDeleteMerchant(merchantId) {
	var r = confirm("Press Ok to confirm deletion");
	if (r == true) {
		get('getMerchantsId').value = merchantId;
		document.forms["deleteMercahntForm"].submit();

	} else {
		return;
	}
}

function doAjaxFetchMailIdAvailable() {
	var mailId = get('emailId').value.trim();

	$.ajax({
		type : "GET",
		url : "uniqueEmailId?emailId=" + mailId,
		async : false,
		success : function(response) {
			var obj = JSON.parse(response);
			if (obj.errorCode === '00') {
				setError(get('emailId'), '');
				// document.getElementById('userNamegreenEr').innerHTML =
				// "username available";
				setLable('confirmMemailId', get('emailId').value.trim());
				usernameFlag = false;

			} else {
				setError(get('emailId'), 'Email id already in use');
				usernameFlag = true;
				;
			}
		},
		error : function(e) {
		}
	});
}

function resetBasicInfo() {
	get('businessName').value = "";
	setError(get('businessName'), '');
	get('firstName').value = "";
	setError(get('firstName'), '');
	get('lastName').value = "";
	setError(get('lastName'), '');
	get('phone').value = "";
	setError(get('phone'), '');
	get('fax').value = "";
	setError(get('fax'), '');
	get('emailId').value = "";
	setError(get('emailId'), '');
	get('address1').value = "";
	setError(get('address1'), '');
	get('country').value = "";
	setError(get('country'), '');
	get('address2').value = "";
	setError(get('address2'), '');
	get('state').value = "";
	setError(get('state'), '');
	get('pin').value = "";
	setError(get('pin'), '');
	get('appMode').value = "";
	setError(get('appMode'), '');
	get('city').value = "";
	setError(get('city'), '');
	get('businessURL').value = "";
	setError(get('businessURL'), '');
}
 
function resetBankInfo() {
	get('bankAccountName').value = "";
	setDiv('bankAccountNameErrorDiv', '');
	get('bankRoutingNumber').value = "";
	setDiv('bankRoutingNumberEr', '');
	get('bankAccountNumber').value = "";
	setDiv('bankAccountNumberErrorDiv', '');
	get('bankRoutingNumber').value = "";
	setDiv('bankRoutingNumberEr', '');
	get('bankAccountType').value = "";
	setDiv('bankAccountTypeErrorDiv', '');
	get('bankAddress1').value = "";
	setDiv('bankAddress1ErrorDiv', '');
	get('bankAddress2').value = "";
	setDiv('bankAddress2ErrorDiv', '');
	get('bankCity').value = "";
	setDiv('bankCityErrorDiv', '');
	get('bankCountry').value = "";
	setDiv('bankCountryErrorDiv', '');
	get('bankState').value = "";
	setDiv('bankStateErrorDiv', '');
	get('bankPin').value = "";
	setDiv('bankPinErrorDiv', '');
	get('bankNameOnAccount').value = "";
	setDiv('bankNameOnAccountErrorDiv', '');
}

function resetBankInfoErrorMsg() {
	setDiv('bankAccountNameErrorDiv', '');
	setDiv('bankRoutingNumberEr', '');
	setDiv('bankAccountNumberErrorDiv', '');
	setDiv('bankRoutingNumberEr', '');
	setDiv('bankAccountTypeErrorDiv', '');
	setDiv('bankAddress1ErrorDiv', '');
	setDiv('bankAddress2ErrorDiv', '');
	setDiv('bankCityErrorDiv', '');
	setDiv('bankCountryErrorDiv', '');
	setDiv('bankStateErrorDiv', '');
	setDiv('bankPinErrorDiv', '');
	setDiv('bankNameOnAccountErrorDiv', '');
}

function resetLegalEntityRepInfo() {
	get('legalName').value = "";
	setDiv('legalNameErrorDiv', '');
	get('legalTaxId').value = "";
	setDiv('legalTaxIdErrorDiv', '');
	get('legalType').value = "";
	setDiv('legalTypeErrorDiv', '');
	get('legalAnnualCard').value = "";
	setDiv('legalAnnualCardErrorDiv', '');
	get('legalFirstName').value = "";
	setDiv('legalFirstNameErrorDiv', '');
	get('legalLastName').value = "";
	setDiv('legalLastNameErrorDiv', '');
	get('legalMobilePhone').value = "";
	setDiv('legalMobilePhoneErrorDiv', '');
	get('legalAddress1').value = "";
	setDiv('legalAddress1ErrorDiv', '');
	get('legalAddress2').value = "";
	setDiv('legalAddress2ErrorDiv', '');
	get('legalCity').value = "";
	setDiv('legalCityErrorDiv', '');
	get('legalCountry').value = "";
	setDiv('legalCountryErrorDiv', '');
	get('legalState').value = "";
	setDiv('legalStateErrorDiv', '');
	get('legalPin').value = "";
	setDiv('legalPinErrorDiv', '');
}

function resetLegalEntityInfo(){
	get('legalSSN').value = "";
	setDiv('legalSSNErrorDiv', '');
	get('legalDOB').value = "";
	setDiv('legalDOBErrorDiv', '');
	get('legalPassport').value = "";
	setDiv('legalPassportErrorDiv', '');
	get('legalCountryResidence').value = "";
	setDiv('legalCountryResidenceErrorDiv', '');
	get('legalCitizen').value = "";
	setDiv('legalCitizenErrorDiv', '');
	get('legalHomePhone').value = "";
	setDiv('legalHomePhoneErrorDiv', '');
}

function resetLegalEntityInfoErrorMsg() {
	setDiv('legalNameErrorDiv', '');
	setDiv('legalTaxIdErrorDiv', '');
	setDiv('legalTypeErrorDiv', '');
	setDiv('legalAnnualCardErrorDiv', '');
	setDiv('legalFirstNameErrorDiv', '');
	setDiv('legalLastNameErrorDiv', '');
	setDiv('legalMobilePhoneErrorDiv', '');
	setDiv('legalAddress1ErrorDiv', '');
	setDiv('legalAddress2ErrorDiv', '');
	setDiv('legalCityErrorDiv', '');
	setDiv('legalCountryErrorDiv', '');
	setDiv('legalStateErrorDiv', '');
	setDiv('legalPinErrorDiv', '');
}

function resetLegalEntityErrorMsg(){
	setDiv('legalSSNErrorDiv', '');
	setDiv('legalDOBErrorDiv', '');
	setDiv('legalPassportErrorDiv', '');
	setDiv('legalCountryResidenceErrorDiv', '');
	setDiv('legalCitizenErrorDiv', '');
	setDiv('legalHomePhoneErrorDiv', '');
}

function resetAdditionalInfo() {
	get('userName').value = "";
	setError(get('userName'), '');
	/*get('businessURL').value = "";
	setError(get('businessURL'), '');
	get('federalTaxId').value = "";
	setError(get('federalTaxId'), '');*/
	/*get('stateTaxId').value = "";
	setError(get('stateTaxId'), '');
	get('salesTaxId').value = "";
	setError(get('salesTaxId'), '');*/
	/*get('ownership').value = "";
	setError(get('ownership'), '');*/
	/*get('businessStartDate').value = "";
	setError(get('businessStartDate'), '');
	get('estimatedYearlySale').value = "";
	setError(get('estimatedYearlySale'), '');
	get('noOfEmployee').value = "";
	setError(get('noOfEmployee'), '');*/
	setDiv('userNamegreenEr', '');
}

function resetAdditionalInfoErrorMsg() {
	setError(get('userName'), '');
	//setError(get('businessURL'), '');
	//setError(get('federalTaxId'), '');
	/*setError(get('stateTaxId'), '');
	setError(get('salesTaxId'), '');*/
	//setError(get('ownership'), '');
	//setError(get('businessStartDate'), '');
	//setError(get('estimatedYearlySale'), '');
	//setError(get('noOfEmployee'), '');
}

function resetConfigurationsInfo() {
	get('allowAutoSettlement').checked = false;
	get('noAutoSettlement').checked = false;
	setError(get('noAutoSettlement'), '');
	get('feeProgram').value = "";
	setError(get('feeProgram'), '');
	get('processor').value = "";
	setError(get('processor'), '');
	get('refunds').checked = false;
	get('tipAmount').checked = false;
	get('taxAmount').checked = false;
	get('shippingAmount').checked = false;
	get('allowRepeatSale').checked = false;
	get('showRecurringBilling').checked = false;
	setError(get('refunds'), '');
	get('autoPaymentMethod').value = "";
	setError(get('autoPaymentMethod'), '');
	get('autoTransferDay').value = "";
	get('autoTransferMonthlyDay').value = "";
	setError(get('autoTransferMonthlyDay'), '');
	get('autoTransferWeeklyDay').value = "";
	setError(get('autoTransferWeeklyDay'), '');
}

function resetConfigurationsInfoErrorMsg() {
	setError(get('noAutoSettlement'), '');
	setError(get('feeProgram'), '');
	setError(get('processor'), '');
	setError(get('refunds'), '');
	setError(get('autoPaymentMethod'), '');
	setError(get('autoTransferMonthlyDay'), '');
	setError(get('autoTransferWeeklyDay'), '');
	setError(get('category'), '');
}
function checkStatusAndMerchantType() {
	var status = get('status').value.trim();
	var type = get('merchantType').value.trim();
	if ("0" == status && type == "Merchant") {
		return true;
	} else {
		return false;
	}
}
function editSubMerchant(merchantId) {
	get('getSubMerchantId').value = merchantId;
	document.forms["editSubMercahntForm"].submit();
}
function viewSubMerchant(merchantId) {
	get('getSubMerchantViewId').value = merchantId;
	document.forms["viewSubMercahntForm"].submit();
}
function getSubMerchantList(merchantId) {
	get('getParentMerchantId').value = merchantId;
	document.forms["getSubMerchantListForm"].submit();
}

function validRoutingNumber() {
	var fieldId = document.getElementById('bankRoutingNumber').value;
	if (fieldId== "") {
    	setDiv('bankRoutingNumberEr',"*This field is mandatory*");
        return false;
    }
    // all valid routing numbers are 9 numbers in length
    if (fieldId.length !== 9) {
    	setDiv('bankRoutingNumberEr',"Invalid lenght");
        return false;
    }
    // if it aint a number, it aint a routin' number
    if ( !$.isNumeric( fieldId ) ) {
    	setDiv('bankRoutingNumberEr',"Should contain only numeric");
        return false;
    }
    // routing numbers starting with 5 are internal routing numbers
    // usually found on bank deposit slips
    if ( fieldId[0] == '5' ) {
    	setDiv('bankRoutingNumberEr',"Should not start with 5");
        return false;
    }
    // http://en.wikipedia.org/wiki/Routing_transit_number#MICR_Routing_number_format
    var checksumTotal = (7 * (parseInt(fieldId.charAt(0),10) + parseInt(fieldId.charAt(3),10) + parseInt(fieldId.charAt(6),10))) +
                        (3 * (parseInt(fieldId.charAt(1),10) + parseInt(fieldId.charAt(4),10) + parseInt(fieldId.charAt(7),10))) +
                        (9 * (parseInt(fieldId.charAt(2),10) + parseInt(fieldId.charAt(5),10) + parseInt(fieldId.charAt(8),10)));
    var checksumMod = checksumTotal % 10;
    if (checksumMod !== 0) {
    	setDiv('bankRoutingNumberEr',"Invalid number");
        return false;
    } else {	
    	setDiv('bankRoutingNumberEr',"");
        return true;
    }
}

function showAutoTransferDayFields(){
	var fieldsValue = get('autoTransferDay').value;
	var flag = false;
	if(fieldsValue == "W"){
		$('#weeklySettlement').show();
		$('#monthlySettlement').hide();
		get('autoTransferMonthlyDay').value = "";
		}
	if(fieldsValue == "M"){
		$('#monthlySettlement').show();
		$('#weeklySettlement').hide();
		get('autoTransferWeeklyDay').value = "";
	}
	if(fieldsValue == "D" || fieldsValue == ""){
		$('#monthlySettlement').hide();
		$('#weeklySettlement').hide();
		get('autoTransferMonthlyDay').value = "";
		get('autoTransferWeeklyDay').value = "";
	}
}

function validateEmailIdEdit(){

	var reg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	var emailAddress = get('emailId').value.trim();

	if (isEmpty(emailAddress)) {
		setError(get('emailId'), 'Please enter Email');
		return false;
	}

	else if (reg.test(emailAddress) == false) {

		setError(get('emailId'), 'Invalid Email');
		return false;
	} else {
		if (alpha.indexOf(emailAddress.charAt(0)) == -1) {
			setError(get('emailId'), 'Invalid Email');
			return false;
		} else {
			doAjaxFetchMailIdEdit();
			if (usernameFlag == false) {
				return true;
			} else {
				return false;
			}
		}

		/*
		 * setError(get('emailId'), ''); setLable('confirmMemailId',
		 * emailAddress); return true;
		 */
	}

}

function doAjaxFetchMailIdEdit() {
	var mailId = get('emailId').value.trim();
	var merchantCode = get('merchantCode').value.trim();

	$.ajax({
		type : "GET",
		url : "uniqueEmailIdEdit?emailId=" + mailId+ "&merchantCode=" + merchantCode,
		async : false,
		success : function(response) {
			var obj = JSON.parse(response);
			if (obj.errorCode === '00') {
				setError(get('emailId'), '');
				// document.getElementById('userNamegreenEr').innerHTML =
				// "username available";
				setLable('confirmMemailId', get('emailId').value.trim());
				usernameFlag = false;

			} else {
				setError(get('emailId'), 'Email id already in use');
				usernameFlag = true;
				;
			}
		},
		error : function(e) {
		}
	});
}

function vlalidateUserNameEdit() {
	var reg = /^[A-Za-z0-9. _]{8,16}$/;
	var userName = get('userName').value.trim();

	if (isEmpty(userName)) {
		setError(get('userName'), 'Please enter User Name');
		document.getElementById('userNamegreenEr').innerHTML = "";
		return false;
	} else if (reg.test(userName) == false) {
		setError(get('userName'), '*Can contain 8-16 alpha & numerics');
		document.getElementById('userNamegreenEr').innerHTML = "";
		return false;
	} else {

		doAjaxFetchUsernameAvailableEdit();
		if (usernameFlag == true) {
			return true;
		} else {
			return false;
		}

	}
}

function doAjaxFetchUsernameAvailableEdit() {
	var userName = get('userName').value.trim();
	var merchantCode = get('merchantCode').value.trim();

	$
			.ajax({
				type : "GET",
				url : "uniqueUserEdit?userName=" + userName+ "&merchantCode=" + merchantCode,
				async : false,
				success : function(response) {
					var obj = JSON.parse(response);
					if (obj.errorCode === '00') {
						setError(get('userName'), '');
						document.getElementById('userNamegreenEr').innerHTML = "User Name available";
						setLable('confirmMuserName', get('userName').value
								.trim());
						usernameFlag = true;

					} else {
						setError(get('userName'), 'User Name not available');
						document.getElementById('userNamegreenEr').innerHTML = "";
						usernameFlag = false;
						;
					}
				},
				error : function(e) {
				}
			});
}
