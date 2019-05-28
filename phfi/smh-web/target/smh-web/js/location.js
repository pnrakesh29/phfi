

function validateLocationName(){
	var locationName = getVal('locationName').trim();
	var regx = /^[A-Za-z0-9._ ]+$/;
	if(isEmpty(locationName)){
		setDiv("locationNameErr", "Should not be empty");
		return false;
	}
	if(!regx.test(locationName)){
		setDiv("locationNameErr", "Invalid Input");
		return false;
	}
	else{
		setDiv("locationNameErr", "");
		return true;
	}
}


function validateLocationInfo(){
	var locationInfo = getVal('locationInfo').trim();
	var regx = /^[A-Za-z0-9._ ]+$/;
	if(isEmpty(locationInfo)){
		setDiv("locationInfoErr", "Should not be empty");
		return false;
	}
	if(!regx.test(locationInfo)){
		setDiv("locationInfoErr", "Invalid Input");
		return false;
	}
	else{
		setDiv("locationInfoErr", "");
		return true;
	}
}

function validateServiceProvider(){
	var serviceProvider = getVal('serviceProvider').trim();
	var regx = /^[A-Za-z0-9._ ]+$/;
	if(isEmpty(serviceProvider)){
		setDiv("serviceProviderErr", "Should not be empty");
		return false;
	}
	if(!regx.test(serviceProvider)){
		setDiv("serviceProviderErr", "Invalid Input");
		return false;
	}
	else{
		setDiv("serviceProviderErr", "");
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
	if (!validateLocationName()|!validateLocationInfo()|!validateServiceProvider()|!validateAddress1() | !validateState() | !validateCountry()
			| !validateCity() | !validateZip()) {
		flag = false;
		return flag;
	} 
	return flag;
}

function validateBeaconLocationUpdate(){
	var flag = true;
	if (!validateLocationName()|!validateLocationInfo()|!validateServiceProvider()|!validateAddress1() | !validateState() | !validateCountry()
			| !validateCity() | !validateZip()) {
		flag = false;
		return flag;
	} 
	return flag;
}

function getStates(country) {
	$.ajax({
		type : "GET",
		url : "location-mgmt-get-states?country=" + country,
		async : false,
		success : function(response) {
			var obj = JSON.parse(response);
			if (obj.responseCode == "BS_0001") {
				// remove the previous option from element
				document.getElementById("state").options.length = 0;

				//create select option
				var selectOption = document.createElement("option");
				selectOption.innerHTML = ".:Select:.";
				selectOption.value = "";
				$("#state").append(selectOption);

				if (obj.responseCode == "BS_0001") {
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

function editLocation(locationId){
	get('id').value = locationId;
	document.forms["locationEditForm"].submit();
}

function deleteLocation(deletelocationId){
	var r = confirm("Press Ok to confirm deletion");
	if (r == true) {
		get('deletelocationId').value = deletelocationId;
		document.forms["deletelocationId"].submit();
	} else {
	return;
	
	}
}

function changeStatus(id, status, statusText) {
	clearPopupDesc();
	$('#locationPopupDiv').popup('show');
	setDiv("sts", " Do you wish to change Role status to " + statusText + '?');
	get('locationActivateId').value = id;
	get('locationStatus').value = status;
}