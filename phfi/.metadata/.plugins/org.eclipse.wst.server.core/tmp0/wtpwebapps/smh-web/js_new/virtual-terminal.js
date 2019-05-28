C_MERCHANT_MSG = {
		
};
   var slideDownFlag = 0;
function doAjaxFetchTransactionForAdjust() {
	/*var cardNum = get('cardNumberDiv').value.trim();
	var invoiceNum = get('invoiceNumberDiv').value.trim();
	var authId = get('authNumberDiv').value.trim();
*/
	var refId=get('refNumberDiv').value.trim();
	var txnType='sale';
	$.ajax({
		type : "GET",
		url : "getTransaction?refId=" + refId+"&txnType="+txnType,
		async : false,
		success : function(response) {
			var obj = JSON.parse(response);
			if (obj.errorCode === '00') {
				get('invoiceNumberDiv1').value = zeroFill(obj.invoiceNumber, 6);
				get('cardNumberDiv1').value = obj.cardNum;
				get('authNumberDiv1').value = obj.authId;
				get('subTotalDiv').value = parseFloat(obj.subTotal).toFixed(2);
				
				get('txnRefNum').value =obj.txnRefNum;
				get('expDate').value = obj.expDate;
				get('totalAmtDiv').value =  parseFloat(obj.txnAmount).toFixed(2);
				$(".fetch-content").slideDown();
				$("#refNumberDiv").attr("readOnly",true);
				

			} else {

				alert("No data Found");
			}
		},
		error : function(e) {
		}
	});
}

function doAjaxFetchTransactionForVoid() {
	/*var cardNum = get('cardNumberDiv').value.trim();
	var invoiceNum = get('invoiceNumberDiv').value.trim();
	var authId = get('authNumberDiv').value.trim();
*/
	var refId=get('refNumberDiv').value.trim();
	var merchantId=get('merchantIdDiv').value.trim();
	var txnType='sale';
	$.ajax({
		type : "GET",
		url : "getTransaction?refId=" + refId+"&txnType="+txnType+"&merchantId="+merchantId,
		async : false,
		success : function(response) {
			var obj = JSON.parse(response);
			if (obj.errorCode === '00'&&obj.settlementStatus=='Pending') {
				get('invoiceNumberDiv1').value = zeroFill(obj.invoiceNumber, 6);
				get('cardNumberDiv1').value = obj.cardNum;
				get('authNumberDiv1').value = obj.authId;
				get('expDateDiv').value = obj.expDate;
				get('subTotalDiv').value = parseFloat(obj.subTotal).toFixed(2);
				/*get('taxAmtDiv').value = obj.taxAmt;*/
				get('tipAmountDiv').value = obj.tipAmount;
				get('shippingAmtDiv').value = obj.shippingAmt;
				get('totalAmtDiv').value =  parseFloat(obj.txnAmount).toFixed(2);
				get('feeAmountDiv').value = parseFloat(obj.feeAmount).toFixed(2);
				get('cardHolderNameDiv').value = obj.cardHolderName;
				get('streetDiv').value = "";
				get('cityDiv').value = "";
				get('zipcodeDiv').value = "";
				get('txnRefNumberDiv').value = obj.txnRefNum;
				get('cgRefNumberDiv').value=obj.cgRefNumber;
				get('merchantIdHDiv').value=obj.merchantId;
				
				$(".fetch-content").slideDown();
				$("#refNumberDiv").attr("readOnly",true);
				

			} else {

				alert("No data Found");
			}
		},
		error : function(e) {
		}
	});
}

/**
 * 
 */
function doAjaxFetchTransactionForRefund() {
	/*var cardNum = get('cardNumberDiv').value.trim();
	var invoiceNum = get('invoiceNumberDiv').value.trim();
	var authId = get('authNumberDiv').value.trim();
*/
	var refId=get('refNumberDiv').value.trim();
	var merchantId=get('merchantIdDiv').value.trim();
	var txnType='sale';
	$.ajax({
		type : "GET",
		url : "getTransaction?refId=" + refId+"&txnType="+txnType+"&merchantId="+merchantId,
		async : false,
		success : function(response) {
			var obj = JSON.parse(response);
			if (obj.errorCode === '00') {
				get('invoiceNumberDiv1').value = zeroFill(obj.invoiceNumber, 6);
				get('cardNumberDiv1').value = obj.cardNum;
				get('authNumberDiv1').value = obj.authId;
				get('expDateDiv').value = obj.expDate;
				get('subTotalDiv').value = parseFloat(obj.subTotal).toFixed(2);
				get('tipAmountDiv').value = obj.tipAmount;
				/*get('taxAmtDiv').value = obj.taxAmt;*/
				get('shippingAmtDiv').value = obj.shippingAmt;
				get('totalAmtDiv').value = parseFloat(obj.txnAmount).toFixed(2);
				get('feeAmountDiv').value = parseFloat(obj.feeAmount).toFixed(2);
				get('cardHolderNameDiv').value = obj.cardHolderName;
				get('streetDiv').value = "";
				get('cityDiv').value = "";
				get('zipcodeDiv').value = "";
				get('txnRefNumberDiv').value = obj.txnRefNum;
				get('cgRefNumberDiv').value=obj.cgRefNumber;
				get('merchantIdHDiv').value=obj.merchantId;
				$(".fetch-content").slideDown();
				$("#refNumberDiv").attr("readOnly",true);
				$("#merchantIdDiv").attr("readOnly",true);

			} else {

				alert("No data Found");
			}
		},
		error : function(e) {
			alert(e);
		}
	});
}

function doAjaxFetchTransactionForCapture() {
	/*var cardNum = get('cardNumberDiv').value.trim();
	var invoiceNum = get('invoiceNumberDiv').value.trim();
	var authId = get('authNumberDiv').value.trim();*/
	var refId=get('refNumberDiv').value.trim();
	var txnType='auth';
	$.ajax({
		type : "GET",
		url : "getTransaction?refId=" + refId+"&txnType="+txnType,
		/*url : "getTransactionForAdjust?cardNum=" + cardNum + "&authId="
				+ authId + "&invoiceNum=" + invoiceNum,*/
		async : false,
		success : function(response) {
			var obj = JSON.parse(response);
			if (obj.errorCode === '00') {
				get('invoiceNumberDiv1').value = zeroFill(obj.invoiceNumber, 6);
				get('cardNumberDiv1').value = obj.cardNum;
				get('authNumberDiv1').value = obj.authId;
				get('expDateDiv').value = obj.expDate;
				get('subTotalDiv').value = parseFloat(obj.subTotal).toFixed(2);
				get('tipAmountDiv').value = obj.tipAmount;
				/*get('taxAmtDiv').value = obj.taxAmt;*/
				get('shippingAmtDiv').value = obj.shippingAmt;
				get('totalAmtDiv').value = parseFloat(obj.txnAmount).toFixed(2);
				get('feeAmountDiv').value = parseFloat(obj.feeAmount).toFixed(2);
				get('cardHolderNameDiv').value = obj.cardHolderName;
				get('streetDiv').value = obj.street;
				get('cityDiv').value = obj.city;
				get('zipcodeDiv').value = obj.zip;
				get('txnRefNumberDiv').value = obj.txnRefNum;
				get('cgRefNumberDiv').value=obj.cgRefNumber;
				$(".fetch-content").slideDown();
				$("#refNumberDiv").attr("readOnly",true);

			} else {

				alert("No data Found");
			}
		},
		error : function(e) {
		}
	});
}

function doAdd() {

	var subTot = get('subTotalDiv').value ? get('subTotalDiv').value : 0;
	var tipAmt = get('tipAmountDiv').value ? get('tipAmountDiv').value : 0;
	var taxAmt = get('taxAmtDiv').value ? get('taxAmtDiv').value : 0;
	var shipAmp = get('shippingAmtDiv').value ? get('shippingAmtDiv').value : 0;
	var feeAmp = get('feeAmountDiv').value ? get('feeAmountDiv').value : 0;

	var total = parseFloat(subTot) + parseFloat(tipAmt) + parseFloat(taxAmt)
			+ parseFloat(shipAmp) + parseFloat(feeAmp);

	get('totalAmtDiv').value = parseFloat(total).toFixed(2);

}
function doRefundAdd() {

	var subTot = get('subTotalDiv').value ? get('subTotalDiv').value : 0;
	var feeAmp = get('feeAmountDiv').value ? get('feeAmountDiv').value : 0;
	var total = parseFloat(subTot) + parseFloat(feeAmp);
	get('totalAmtDiv').value = parseFloat(total).toFixed(2);

}
function doAddAdjust() {

	var subTot = get('subTotalDiv').value ? get('subTotalDiv').value : 0;
	var tipAmt = get('tipAmountDiv').value ? get('tipAmountDiv').value : 0;

	var total = parseFloat(subTot).toFixed(2) + parseFloat(tipAmt).toFixed(2);

	get('totalAmtDiv').value = parseFloat(total).toFixed(2);

}

function validateExpiryDate() {
	var today = new Date();
	var thisyear = today.getFullYear();
	var thismonth = parseInt(today.getMonth()) + 1;
	var month = get('monthdropdown').value;
	var year = get('yeardropdown').value;
	if (isEmpty(month) && isEmpty(year)) {
		setDiv("expiryDateErr", "Should not be empty");
		return false;
	} else if (year > thisyear) {
		setDiv("expiryDateErr", "");
		return true;
	} else if ((year == thisyear)) {
		if ((month < thismonth)) {
			setDiv("expiryDateErr", "Invalid date");
			return false;
		}
		setDiv("expiryDateErr", "");
		return true;
	} else {
		setDiv("expiryDateErr", "");
		return true;
	}

}
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
function validRefNumber(id,divId) {
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
	} else if (!isDigit(val) || !(len==3)) {
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
	//var regex = /^\s*-?[1-9]\d*(\.\d{2})?\s*$/;
	var regex = /^[0-9]+(\.[0-9][0-9]?)?$/;
	
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
	console.log(val);
	if(val===null){
		setDiv("streetErrorDiv", "Should not be empty");
		return false;
	}
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
	if(null == val){
		setDiv("zipcodeErrorDiv", "Should not be empty");
		return false;
	}
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
	if(null===val){
		setDiv("streetErrorDiv", "Should not be empty");
		return false;
	}
	
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
	!validAmount('totalAmtDiv','totalAmtErrorDiv') | !validStreet() | !validCity() | !validZipcode() | !validInvoiceNumber('invoiceNumberDiv','invoiceNumberErrorDiv')
	|!validateDesc()|!validState()|!clientValidation('feeAmountDiv', 'fee_amount','feeAmountErrorDiv')|!validMerchantCode('merchantIdDiv','merchantIdErrorDiv')) {
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
setDiv("errorDescDiv","");
setDiv("responseDiv","");
setDiv("stateErrorDiv","");
setDiv("descriptionErrorDiv","");
setDiv("feeAmountErrorDiv","");
setDiv("merchantIdErrorDiv","");

document.getElementById("txnForm").reset(true);
$("#refNumberDiv").attr("readOnly",false);

}

function validatePreAuth() {
	if (!validCardNumber('cardNumberDiv1','cardNumberErrorDiv1') | !validInvoiceNumber('invoiceNumberDiv1','invoiceNumberErrorDiv1') | 
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
setDiv("errorDescDiv","");
setDiv("responseDiv","");
setDiv("stateErrorDiv","");
setDiv("descriptionErrorDiv","");
setDiv("merchantIdErrorDiv","");
$("#refNumberDiv").attr("readOnly",false);
$("#descriptionDiv").attr("readOnly",false);
document.getElementById("txnForm").reset();

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
setDiv("errorDescDiv","");
setDiv("responseDiv","");
document.getElementById("txnForm").reset();
$("#refNumberDiv").attr("readOnly",false);

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

function validatePreAuthFetch() {
  
	if (!validRefNumber('refNumberDiv','refNumberErrorDiv')
			|!validateDesc()|!validMerchantCode('merchantIdDiv','merchantIdErrorDiv')) {
		slideDownFlag = 0;
		return false;
	} else {		
		slideDownFlag = 1;
		return true;		
	}
	
}

function resetPreAuthFetch()
{
setDiv("invoiceNumberErrorDiv", "");
setDiv("cardNumberErrorDiv", "");
setDiv("authNumberErrorDiv", "");
setDiv("refNumberErrorDiv","");
setDiv("errorDescDiv","");
setDiv("responseDiv","");
setDiv("descriptionErrorDiv","");
setDiv("merchantIdErrorDiv","");
$("#refNumberDiv").attr("readOnly",false);
$("#descriptionDiv").attr("readOnly",false);

document.getElementById("txnForm").reset();
}

function validState() {
	var val =getVal("stateDiv");
	var regex = /^[a-zA-Z0-9#\-\s]+$/;
	if(null===val){
		setDiv("stateErrorDiv", "Should not be empty");
		return false;
	}
	
	if (isEmpty(val)) {
	setDiv("stateErrorDiv", "Should not be empty");
		return false;
	} else if (regex.test(val) == false) {
	setDiv("stateErrorDiv", "Enter valid data");
		return false;
	} else {
	setDiv("stateErrorDiv", "");
		return true;
	}
}
function validateDesc() {
	var val =getVal("descriptionDiv");
	console.log(val);
	if(val===null){
		setDiv("descriptionErrorDiv", "Should not be empty");
		return false;
	}
	if (isEmpty(val)) {
	setDiv("descriptionErrorDiv", "Should not be empty");
		return false;
	} else {
	setDiv("descriptionErrorDiv", "");
		return true;
	}
}


function zeroFill( number, width )
{
  width -= number.toString().length;
  if ( width > 0 )
  {
    return new Array( width + (/\./.test( number ) ? 2 : 1) ).join( '0' ) + number;
  }
  return number + ""; // always return a string
}
function validMerchantCode(id,divId) {
	var val =getVal(id);
	var len = val.length;
		
	if (isEmpty(val)) {
		setDiv(divId, "Should not be empty");
		return false;
	} else if (!isDigit(val) || len < 4 || len > 15) {
		setDiv(divId, "Should be numeric and 4-15 digit");
		return false;
	}
	else {
		setDiv(divId, "");
		return true;
	}
}

function openConfirmPage(){
	if (!validCardNumber('cardNumberDiv1','cardNumberErrorDiv1') | !validInvoiceNumber('invoiceNumberDiv1','invoiceNumberErrorDiv1') | 
			!validCardNumber('cardNumberDiv1','cardNumberErrorDiv1') | !validAuthNumber('authNumberDiv1','authNumberErrorDiv1') | !validAmount('subTotalDiv','subTotalErrorDiv') |
			!validCardHolderName() | !validStreet() | !validCity() | !validZipcode()  | !validAmount('totalAmtDiv','totalAmtErrorDiv') |!validExpDate()  ) {
		return false;
	} else {
		setLable('confirmMerchantIdDiv', get('merchantIdDiv').value.trim());
		setLable('confirmRefNumberDiv', get('refNumberDiv').value.trim());
		setLable('confirmDescriptionDiv', get('descriptionDiv').value.trim());
		setLable('confirmInvoiceNumberDiv1', get('invoiceNumberDiv1').value.trim());
		setLable('confirmCardNumberDiv1', get('cardNumberDiv1').value.trim());
		setLable('confirmAuthNumberDiv1', get('authNumberDiv1').value.trim());
		setLable('confirmExpDateDiv', get('expDateDiv').value.trim());
		setLable('confirmSubTotalDiv',(get('subTotalDiv').value.trim()));
		setLable('confirmFeeAmountDiv',( get('feeAmountDiv').value.trim()));
		setLable('confirmTotalAmtDiv', ( get('totalAmtDiv').value.trim()));
		setLable('confirmCardHolderNameDiv', get('cardHolderNameDiv').value.trim());
		setLable('confirmStreetDiv', get('streetDiv').value.trim());
		setLable('confirmCityDiv', get('cityDiv').value.trim());
		setLable('confirmZipcodeDiv', get('zipcodeDiv').value.trim());
		setLable('errorDescDiv', "");

		$("#hideAllFields").hide();
		$("#responseDiv").hide();
		$("#confirmPage").show();
		return true;
	}
}

function showEditPage(){
	$("#hideAllFields").show();
	$("#responseDiv").hide();
	$("#confirmPage").hide();
}

function openConfirmPageSale(){
	if (!validCardNumber('cardNumberDiv','cardNumberErrorDiv') | !validCv2() | !validCardHolderName() | !validAmount('subTotalDiv','subTotalErrorDiv') | 
	!validAmount('totalAmtDiv','totalAmtErrorDiv') | !validStreet() | !validCity() | !validZipcode() | !validInvoiceNumber('invoiceNumberDiv','invoiceNumberErrorDiv')
	|!validateDesc()|!validState()|!clientValidation('feeAmountDiv', 'fee_amount','feeAmountErrorDiv')|!validMerchantCode('merchantIdDiv','merchantIdErrorDiv')) {
		return false;
	} else {
		setLable('confirmMerchantIdDiv', get('merchantIdDiv').value.trim());
		setLable('confirmCardNumberDiv', get('cardNumberDiv').value.trim());
		setLable('confirmYeardropdown', get('yeardropdown').value.trim());
		setLable('confirmMonthdropdown', get('monthdropdown').value.trim());
		setLable('confirmCv2Div', get('cv2Div').value.trim());
		setLable('confirmCardHolderNameDiv', get('cardHolderNameDiv').value.trim());
		setLable('confirmSubTotalDiv', get('subTotalDiv').value.trim());
		setLable('confirmTaxAmtDiv', get('taxAmtDiv').value.trim());
		setLable('confirmTipAmountDiv', get('tipAmountDiv').value.trim());
		setLable('confirmShippingAmtDiv', get('shippingAmtDiv').value.trim());
		setLable('confirmFeeAmountDiv', get('feeAmountDiv').value.trim());
		setLable('confirmTotalAmtDiv', get('totalAmtDiv').value.trim());
		setLable('confirmStreetDiv', get('streetDiv').value.trim());
		setLable('confirmCityDiv', get('cityDiv').value.trim());
		setLable('confirmStateDiv', get('stateDiv').value.trim());
		setLable('confirmZipcodeDiv', get('zipcodeDiv').value.trim());
		setLable('confirmInvoiceNumberDiv', get('invoiceNumberDiv').value.trim());
		setLable('confirmDescriptionDiv', get('descriptionDiv').value.trim());
		setLable('errorDescDiv', "");

		$("#hideAllFields").hide();
		$("#responseDiv").hide();
		$("#confirmPage").show();
		return true;
	}
}

function showEditPageSale(){
	$("#hideAllFields").show();
	$("#responseDiv").hide();
	$("#confirmPage").hide();
}

function openConfirmPageVoid(){
	if (!validCardNumber('cardNumberDiv1','cardNumberErrorDiv1') | !validInvoiceNumber('invoiceNumberDiv1','invoiceNumberErrorDiv1') | 
	!validCardNumber('cardNumberDiv1','cardNumberErrorDiv1') | !validAuthNumber('authNumberDiv1','authNumberErrorDiv1') | !validAmount('subTotalDiv','subTotalErrorDiv') |
	!validCardHolderName() | !validStreet() | !validCity() | !validZipcode()  | !validAmount('totalAmtDiv','totalAmtErrorDiv') |!validExpDate()  ) {
		return false;
	} else {
		setLable('confirmMerchantIdDiv', get('merchantIdDiv').value.trim());
		setLable('confirmRefNumberDiv', get('refNumberDiv').value.trim());
		setLable('confirmDescriptionDiv', get('descriptionDiv').value.trim());
		setLable('confirmInvoiceNumberDiv1', get('invoiceNumberDiv1').value.trim());
		setLable('confirmCardNumberDiv1', get('cardNumberDiv1').value.trim());
		setLable('confirmAuthNumberDiv1', get('authNumberDiv1').value.trim());
		setLable('confirmExpDateDiv', get('expDateDiv').value.trim());
		setLable('confirmSubTotalDiv', get('subTotalDiv').value.trim());
		setLable('confirmFeeAmountDiv', get('feeAmountDiv').value.trim());
		setLable('confirmTotalAmtDiv', get('totalAmtDiv').value.trim());
		setLable('confirmCardHolderNameDiv', get('cardHolderNameDiv').value.trim());
		setLable('confirmStreetDiv', get('streetDiv').value.trim());
		setLable('confirmCityDiv', get('cityDiv').value.trim());
		setLable('confirmZipcodeDiv', get('zipcodeDiv').value.trim());
		setLable('errorDescDiv', "");

		$("#hideAllFields").hide();
		$("#responseDiv").hide();
		$("#confirmPage").show();
		return true;
	}
}

function showEditPageVoid(){
	$("#hideAllFields").show();
	$("#responseDiv").hide();
	$("#confirmPage").hide();
}