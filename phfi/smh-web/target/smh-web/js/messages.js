C_MERCHANT_MSG = {
		
};


function validInvoiceNumber(id,divId) {
	var val =getVal(id);
	var len = val.length;
		
	if (isEmpty(val)) {
		setDiv(divId, "Should not be empty");
		return false;
	} else if (!isDigit(val) || len < 4 || len > 16) {
		setDiv(divId, "Should be numeric and 4-16 digit");
		return false;
	}
	else {
		setDiv(divId, "");
		return true;
	}
}

function validCardNumber(id,divId) {
	var val =getVal(id);
	var len = val.length;
		
	if (isEmpty(val)) {
		setDiv(divId, "Should not be empty");
		return false;
	} else if (!isDigit(val) || len < 16 || len > 19) {
		setDiv(divId, "Should be numeric and 16-19 digit");
		return false;
	
	}
	else {
		setDiv(divId, "");
		return true;
	}
}

function validAuthNumber(id,divId) {
	var val =getVal(id);
	var len = val.length;
		
	if (isEmpty(val)) {
		setDiv(divId, "Should not be empty");
		return false;
	} else if (!isDigit(val) || len < 4 || len > 19) {
		setDiv(divId, "Should be numeric and 4-16 digit");
		return false;
	
	}
	else {
		setDiv(divId, "");
		return true;
	}
}

function validCv2() {
	var val =getVal("cv2Div");
	var len = val.length;
		
	if (isEmpty(val)) {
		setDiv("cv2ErrorDiv", "Should not be empty");
		return false;
	} else if (!isDigit(val) || !len ==3) {
		setDiv("cv2ErrorDiv", "Should be numeric and 3 digit");
		return false;
	
	}
	else {
		setDiv("cv2ErrorDiv", "");
		return true;
	}
}function validCardHolderName() {
	var val =getVal("cardHolderNameDiv");
		
	if (isEmpty(val)) {
		setDiv("cardHolderNameErrorDiv", "Should not be empty");
		return false;
	} 
	 else if (isDigit(val)) {
		setDiv("cardHolderNameErrorDiv", "Should be alphabetic");
		return false;
	
	}
	else {
		setDiv("cardHolderNameErrorDiv", "");
		return true;
	}
}

function validAmount(id,divId) {
	var val =getVal(id);
	var regex = /^\s*-?[1-9]\d*(\.\d{2})?\s*$/;
	
	if (isEmpty(val)) {
	setDiv(divId, "Should not be empty");
		return false;
	} else if (regex.test(val) == false) {
	setDiv(divId, "Enter valid data");
		return false;
	} else {
	setDiv(divId, "");
		return true;
	}
}

function validStreet() {
	var val =getVal("streetDiv");
	
	if (isEmpty(val)) {
	setDiv("streetErrorDiv", "Should not be empty");
		return false;
	} else {
	setDiv("streetErrorDiv", "");
		return true;
	}
}

function validZipcode() {
	var val =getVal("zipcodeDiv");
	var len = val.length;
		
	if (isEmpty(val)) {
		setDiv("zipcodeErrorDiv", "Should not be empty");
		return false;
	} else if (!isCharacter(val) || len < 3 || len > 8) {
		setDiv("zipcodeErrorDiv", "Should be alpha-numeric and 3-8 digit");
		return false;
	
	}
	else {
		setDiv("zipcodeErrorDiv", "");
		return true;
	}
}



function validCity() {
	var val =getVal("cityDiv");
	var regex = /^[a-zA-Z0-9#\-\s]+$/;
	
	if (isEmpty(val)) {
	setDiv("cityErrorDiv", "Should not be empty");
		return false;
	} else if (regex.test(val) == false) {
	setDiv("cityErrorDiv", "Enter valid data");
		return false;
	} else {
	setDiv("cityErrorDiv", "");
		return true;
	}
}


function validateAuth() {
	if (!validCardNumber('cardNumberDiv','cardNumberErrorDiv') | !validCv2() | !validCardHolderName() | !validAmount('subTotalDiv','subTotalErrorDiv') | 
	!validAmount('totalAmtDiv','totalAmtErrorDiv') | !validStreet() | !validCity() | !validZipcode() | !validInvoiceNumber('invoiceNumberDiv','invoiceNumberErrorDiv')) {
		return false;
	} else {
		return true;
	}
	
}

function resetAuth()
{
setDiv("cardNumberErrorDiv", "");
setDiv("cv2ErrorDiv", "");
setDiv("cardHolderNameErrorDiv", "");
setDiv("subTotalErrorDiv", "");
setDiv("totalAmtErrorDiv", "");
setDiv("streetErrorDiv", "");
setDiv("cityErrorDiv", "");
setDiv("zipcodeErrorDiv", "");
setDiv("invoiceNumberErrorDiv", "");

}

function validatePreAuth() {
	if (!validCardNumber('cardNumberDiv','cardNumberErrorDiv') | !validInvoiceNumber('invoiceNumberDiv','invoiceNumberErrorDiv') | !validAuthNumber('authNumberDiv','authNumberErrorDiv')
	| !validInvoiceNumber('invoiceNumberDiv1','invoiceNumberErrorDiv1') | 
	!validCardNumber('cardNumberDiv1','cardNumberErrorDiv1') | !validAuthNumber('authNumberDiv1','authNumberErrorDiv1') | !validAmount('subTotalDiv','subTotalErrorDiv') |
	!validCardHolderName() | !validStreet() | !validCity() | !validZipcode()  | !validAmount('totalAmtDiv','totalAmtErrorDiv') |!validExpDate()  ) {
		return false;
	} else {
		return true;
	}
	
}

function resetPreAuth()
{
setDiv("invoiceNumberErrorDiv", "");
setDiv("cardNumberErrorDiv", "");
setDiv("authNumberErrorDiv", "");
setDiv("invoiceNumberErrorDiv1", "");
setDiv("cardNumberErrorDiv1", "");
setDiv("authNumberErrorDiv1", "");
setDiv("subTotalErrorDiv", "");
setDiv("totalAmtErrorDiv", "");
setDiv("cardHolderNameErrorDiv", "");
setDiv("streetErrorDiv", "");
setDiv("cityErrorDiv", "");
setDiv("zipcodeErrorDiv", "");
setDiv("expDateErrorDiv", "");

}

function validateAdjust() {
	if (!validCardNumber('cardNumberDiv','cardNumberErrorDiv') | !validInvoiceNumber('invoiceNumberDiv','invoiceNumberErrorDiv') | !validAuthNumber('authNumberDiv','authNumberErrorDiv')
	| !validInvoiceNumber('invoiceNumberDiv1','invoiceNumberErrorDiv1') | 
	!validCardNumber('cardNumberDiv1','cardNumberErrorDiv1') | !validAuthNumber('authNumberDiv1','authNumberErrorDiv1') | !validAmount('subTotalDiv','subTotalErrorDiv') |
	!validAmount('totalDiv','totalErrorDiv')  ) {
		return false;
	} else {
		return true;
	}
	
}

function resetAdjust()
{
setDiv("invoiceNumberErrorDiv", "");
setDiv("cardNumberErrorDiv", "");
setDiv("authNumberErrorDiv", "");
setDiv("invoiceNumberErrorDiv1", "");
setDiv("cardNumberErrorDiv1", "");
setDiv("authNumberErrorDiv1", "");
setDiv("subTotalErrorDiv", "");
setDiv("totalErrorDiv", "");


}


function validExpDate() {
	var val =getVal("expDateDiv");
	var len = val.length;
		
	if (isEmpty(val)) {
		setDiv("expDateErrorDiv", "Should not be empty");
		return false;
	} else if (!isDigit(val) || len < 4 || len > 4 ) {
		setDiv("expDateErrorDiv", "Should be numeric and 4 digit");
		return false;
	}
	else {
		setDiv("expDateErrorDiv", "");
		return true;
	}
}