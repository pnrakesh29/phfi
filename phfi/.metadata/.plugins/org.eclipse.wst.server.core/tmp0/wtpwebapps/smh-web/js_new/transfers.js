/**
 * 
 */
function getTransferList(status,transferMode) {
	get('statusId').value = status;
	get('transferMode').value=transferMode;
	document.forms["transferListRequest"].submit();
}

function back2Home(){
	window.location.href = "home";
}
function processAction(pgTransfersId,action){
	get('action').value = action;
	get('pgTransfersId').value=pgTransfersId;
	document.forms["fundTransferActionModel"].submit();
}