function validateBeaconId(){
	var beaconId = getVal('beaconId').trim();
	if(isEmpty(beaconId)){
		setDiv("beaconIdErr", "Please Select BeaconId");
		return false;
	}
	else{
		setDiv("beaconIdErr", "");
		return true;
	}
}


function validateLocationId(){
	var locationId = getVal('locationId').trim();
	var regx = /^[A-Za-z0-9 ]+$/;
	if(isEmpty(locationId)){
		setDiv("locationIdErr", "Should not be empty");
		return false;
	}
	if(!regx.test(locationId)){
		setDiv("locationIdErr", "Invalid Input");
		return false;
	}
	else{
		setDiv("locationIdErr", "");
		return true;
	}
}

function validateAddress1() {
	var address1 = get("address1").value;
	if (isEmpty(address1)) {
		setDiv("address1Err", "Should not be empty");
		return false;
	} else {
		setDiv("address1Err", "");
		return true;
	}
}

function validateState() {
	var state = get('state').value.trim();
	if (isEmpty(state)) {
		setDiv("stateErr", "Please select State");
		return false;
	} else {
		setDiv("stateErr", "");
		return true;
	}
}

function validateCountry() {
	var country = get('country').value.trim();
	if (isEmpty(country)) {
		setDiv("countryErr", "Please select Country");
		return false;
	} else {
		setDiv("countryErr", "");
		return true;
	}
}

function validateCity(){
	var city = getVal('city').trim();
	var regx = /^[A-Za-z0-9 ]+$/;
	if(isEmpty(city)){
		setDiv("cityErr", "Should not be empty");
		return false;
	}
	if(!regx.test(city)){
		setDiv("cityErr", "Invalid Input");
		return false;
	}
	else{
		setDiv("cityErr", "");
		return true;
	}
	
}

function validateZip(){
	var countryValue = document.getElementById('country').value;
	var zipCode = getVal('zipCode'); 
	if( countryValue == null ){
		setDiv("zipErr", "Please, select Country first");
		return false;
	} else if (isEmpty(zipCode)) {
		setDiv("zipErr", "Should not be empty");
		return false;
	} else if ((zipCode.length < 3) || (zipCode.length > 10)) {
		setDiv("zipErr", "Invalid length");
		return false;
	} else if((countryValue == "USA")||(countryValue =="India")){
		var addRegxUs = /^\d+$/;
		if((!addRegxUs.test(zipCode))){
			setDiv("zipErr", "Invalid zip code only Numerics are allowed for US and INDIA");
			return false;
		}
		else{
		setDiv("zipErr", "");
		return true;
		}
	}else if((countryValue =="Canada")){
		 var addRegxUk = /^[A-Za-z0-9 ]+$/;
		 if((!addRegxUk.test(zipCode))){
				setDiv("zipErr", "Invalid zip code");
				return false;
			}
			else{
			setDiv("zipErr", "");
			return true;
			}
	}
	return false;
}

function validateBeaconLocationSave(){
	var flag = true;
	if (!validateBeaconId() |! validateLocationId() |!validateAddress1() | !validateState() | !validateCountry()
			| !validateCity() | !validateZip()) {
		flag = false;
		return flag;
	} 
	return flag;
}

function validateBeaconLocationUpdate(){
	var flag = true;
	if (!validateBeaconId() |! validateLocationId() |!validateAddress1() | !validateState() | !validateCountry()
			| !validateCity() | !validateZip()) {
		flag = false;
		return flag;
	} 
	return flag;
}

function getStates(country) {
	$.ajax({
		type : "GET",
		url : "location-map-get-states?country=" + country,
		async : false,
		success : function(response) {
			var obj = JSON.parse(response);
			if (obj.responseCode == "00") {
				// remove the previous option from element
				document.getElementById("state").options.length = 0;

				//create select option
				var selectOption = document.createElement("option");
				selectOption.innerHTML = ".:Select:.";
				selectOption.value = "";
				$("#state").append(selectOption);

				if (obj.responseCode == "00") {
					var data = obj.responseList;

					for ( var i = 0; i < data.length; i++) {
						var state = data[i].label;

						var newOption = document.createElement("option");
						newOption.value = data[i].value;
						newOption.innerHTML = state;

						$("#state").append(newOption);
					}
				}
			}
		},
		error : function(e) {
		}
	});

}

function editLocationMap(beaconId,locationId){
	get('beaconId').value = beaconId;
	get('locationId').value = locationId;
	document.forms["locationMapEdit"].submit();
}
