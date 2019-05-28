function validateBeaconId(){
	var beaconId = getVal('beaconId').trim();
	if(isEmpty(beaconId)){
		setDiv("beaconIdErr", "Please Select Beacon Id");
		return false;
	}
	else{
		setDiv("beaconIdErr", "");
		return true;
	}
}

function validateZoneId(){
	var zoneId = getVal('zoneId').trim();
	if(isEmpty(zoneId)){
		setDiv("zoneIdErr", "Please Select Zone Id");
		return false;
	}
	else{
		setDiv("zoneIdErr", "");
		return true;
	}
}

function validateZopMapSubmit(){
	var flag = true;
	if(!validateBeaconId() |!validateZoneId()){
		flag = false;
		return flag
	}
	return flag;
}