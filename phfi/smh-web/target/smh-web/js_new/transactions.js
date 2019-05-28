function resetAll() {
	document.forms["resubmitForm"].submit();
}

function checkFields() {
	if (isEmpty('processCode') && isEmpty('merchantCode')
			&& isEmpty('cardNumber') && isEmpty('fromDate')
			&& isEmpty('toDate') && isEmpty('fromAmtRange')
			&& isEmpty('toAmtRange') && isEmpty('transactionType')
			&& isEmpty('status') && isEmpty('transactionId')) {
		return false;
	}
}


function validateComment(){
	var comment=get('comment').value;
	if(isEmpty(comment)){
		setDiv('commentErr', '*Please enter your comment*')
		return false;
		
	}else {
		setDiv('commentErr', '')
		return true;
	}
}

function getTransactionListToDashBoard(settlementStatus) {
	get('settlementStatus').value = settlementStatus;
	document.forms["transaction"].submit();
}

function getLitleEFTTransactionListToDashBoard() {
	document.forms["litleEFTTransaction"].submit();
}


function backToHome()
{
	window.location.href = "home";
}
function getSignUpRegistrations(status) {
	get('status').value = status;
	document.forms["searchMerchant"].submit();
}

function validateTransactionsDates() {
	var flag = true;
	var toDate = document.getElementById('toDate').value;
	var fromDate = document.getElementById('fromDate').value;

	var toDay = parseInt(toDate.split("/")[0]);
	var toMonth = parseInt(toDate.split("/")[1]);
	var toYear = parseInt(toDate.split("/")[2]);
	var newToDate = new Date(toYear, toMonth, toDay);

	var fromDay = parseInt(fromDate.split("/")[0]);
	var fromMonth = parseInt(fromDate.split("/")[1]);
	var fromYear = parseInt(fromDate.split("/")[2]);
	var newFromDate = new Date(fromYear, fromMonth, fromDay);

	var today = new Date();
	var todayDate = today.getDate();
	var todayMonth = today.getMonth() + 1;
	var todayYear = today.getFullYear();
	var currentDate = new Date(todayYear, todayMonth, todayDate);

	if (toDate != "") {
		if (newFromDate > newToDate) {
			flag = false;
			setDiv('tranFromDateErrorDiv', "Should not be greater than 'To Date'");
		} else if (newFromDate > currentDate) {
			flag = false;
			setDiv('tranFromDateErrorDiv', "Can not be the future date");
		}else {
			setDiv('tranFromDateErrorDiv', "");
		}
	}
	return flag;
}

