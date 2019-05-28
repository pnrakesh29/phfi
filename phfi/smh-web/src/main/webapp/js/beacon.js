function validateUUID(){
	var uuid = getVal('uuid').trim();
	var regx = /^[A-Za-z0-9]+$/;
	if(isEmpty(uuid)){
		setDiv("uuidErr", "Should not be empty");
		return false;
	}
	if(!regx.test(uuid)){
		setDiv("uuidErr", "Invalid Input");
		return false;
	}
	else{
		setDiv("uuidErr", "");
		return true;
	}
}

function validateZoneId(){
	var zoneId = getVal('zoneId').trim();
	if(isEmpty(zoneId)){
		setDiv("zoneIdErr", "Should not be empty");
		return false;
	}
	else{
		setDiv("zoneIdErr", "");
		return true;
	}
}

function validateBeaconName(){
	var beaconName = getVal('beaconName').trim();
	var regx = /^[A-Za-z0-9._ ]+$/;
	if(isEmpty(beaconName)){
		setDiv("beconNameErr", "Should not be empty");
		return false;
	}
	if(!regx.test(beaconName)){
		setDiv("beconNameErr", "Invalid Input");
		return false;
	}
	else{
		setDiv("beconNameErr", "");
		return true;
	}
}

function validateColor(){
	var color = getVal('color').trim();
	/*var regx = /^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$/;*/
	var regx = /^[A-Za-z]+$/;
	if(isEmpty(color)){
		setDiv("colorErr", "Should not be empty");
		return false;
	}
	if(!regx.test(color)){
		setDiv("colorErr", "Invalid Input");
		return false;
	}
	else{
		setDiv("colorErr", "");
		return true;
	}
}

function validateMajor(){
	var major = getVal('major').trim();
	var regx = /^[A-Za-z0-9._ ]+$/;
	if(isEmpty(major)){
		setDiv("majorErr", "Should not be empty");
		return false;
	}
	if(!regx.test(major)){
		setDiv("majorErr", "Invalid Input");
		return false;
	}
	else{
		setDiv("majorErr", "");
		return true;
	}
}

function validateMinor(){
	var minor = getVal('minor').trim();
	var regx =  /^[A-Za-z0-9._ ]+$/;
	if(isEmpty(minor)){
		setDiv("minorErr", "Should not be empty");
		return false;
	}
	if(!regx.test(minor)){
		setDiv("minorErr", "Invalid Input");
		return false;
	}
	else{
		setDiv("minorErr", "");
		return true;
	}
}

function validateTransmitPower(){
	var transmitPower = getVal('transmitPower').trim();
	var regx = /[0-9]+(\.[0-9][0-9]?)?/;
	if(isEmpty(transmitPower)){
		setDiv("transmitPowerErr", "Should not be empty");
		return false;
	}else if(!regx.test(transmitPower)){
		setDiv("transmitPowerErr", "Invalid Input");
		return false;
	}
	else{
		setDiv("transmitPowerErr", "");
		return true;
	}
}

function validateMacAddress(){
	var macAddress = getVal('macAddress').trim();
	/*var regx =/^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/;*/
	var regx =/^(([A-Fa-f0-9]{2}[:]){5}[A-Fa-f0-9]{2}[,]?)+$/;
	
	if(isEmpty(macAddress)){
		setDiv("macAddressErr", "Should not be empty");
		return false;
	}
	if(!regx.test(macAddress)){
		setDiv("macAddressErr", "Invalid Input");
		return false;
	}
	else{
		setDiv("macAddressErr", "");
		return true;
	}
}

function validateAdvertisingInterval(){
	var name = get("advertisingInterval").value;
	if(name=="0" || name=="00"){
		setDiv("advertisingIntervalErr", "Invalid input, please enter correct value");
		return false;
	}else{
	var regex =/^([0-9]|[0-9][0-9]|[0-9][0-9][0-9]|[0-9][0-9][0-9][0-9]|[0-9][0-9][0-9][0-9][0-9])$/;
	if (isEmpty(name)) {
		setDiv("advertisingIntervalErr", "Should not be empty");
		return false;
	}
	else if(!regex.test(name)){
		setDiv("advertisingIntervalErr", "Invalid input, please enter correct value");
		return false;
	}
	else{
		setDiv("advertisingIntervalErr", "");
		return true;	
	}
	}
}

function validateBeaconSave(){
	var flag = true;
	if (!validateUUID()|!validateZoneId()|! validateBeaconName()|!validateColor()|!validateMajor()|!validateMinor()
			|!validateTransmitPower()|!validateMacAddress()|!validateAdvertisingInterval()) {
		flag = false;
		return flag;
	} 
	return flag;
}

function validateBeaconUpdate(){
	var flag = true;
	if (!validateUUID()|!validateZoneId()|! validateBeaconName()|!validateColor()|!validateMajor()|!validateMinor()
			|!validateTransmitPower()|!validateMacAddress()|!validateAdvertisingInterval()) {
		flag = false;
		return flag;
	} 
	return flag;
}

function confirmDeleteBeacon(id){
	
	var r = confirm("Press Ok to confirm deletion");
	if (r == true) {
		get('deleteBeaconId').value = id;
		document.forms["deleteBeacon"].submit();
	} else {
		return;
	}
}


function editBeacon(editId){
		get('editId').value = editId;
		document.forms["editBeacon"].submit();
}

function changeBeaconStatus(id,status) {
	get('id').value = id;
	get('status').value = status;
	$('#activatePop').popup("show");
}

function submitBeaconStatus() {
	var reason = get('activateReason').value.trim();
	if (isEmpty(reason)) {
		$("#activateDiv").addClass("has-error");
		$("#activateErr").addClass("visible");
		setDiv("activateErr", "Please enter reason");
		return false;
	}
	document.forms["statusBeaconForm"].submit();
}
