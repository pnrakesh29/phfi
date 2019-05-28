var unique = false;
var msg = false;
function validateZoneId()
{
var zoneId = get("zoneId").value;
var regx = /^[A-Za-z0-9 ]+$/;
if (isEmpty(zoneId)) {
	setDiv("zoneIdErr", "Should not be empty");
	return false;
}
if(!regx.test(zoneId)){
	setDiv("zoneIdErr", "Invalid Input");
	return false;
}
else{
	setDiv("zoneIdErr", "");
	return true;
} 
}

function validateLocationId()
{
	var locationId = get("locationId").value;
	if (isEmpty(locationId)) {
		setDiv("locationIdErr", "Should not be empty");
		return false;
	}
	else{
		setDiv("locationIdErr", "");
		return true;
	} 
	}

function validatezoneName()
{
	var zoneName = getVal('zoneName').trim();
	var regx = /^[A-Za-z0-9 ]+$/;
	if(isEmpty(zoneName)){
		setDiv("zoneNameErr", "Should not be empty");
		return false;
	}else{
		setDiv("zoneNameErr", "");
		return true;
	}
	
}

function validategeofence()
{
	var geofence = getVal('geofence').trim();
	var regx = /^[0-9,]*$/;
	if(isEmpty(geofence)){
		setDiv("geofenceErr", "Should not be empty");
		return false;
	}else if(!regx.test(geofence)){
		setDiv("geofenceErr", "Invalid Input");
		return false;
	}
	else{
		setDiv("geofenceErr", "");
		return true;
	}
	
}

function validateLattitude()
{
	var lattitude = getVal('lattitude').trim();
	var regx = /(^[-+]?[0-9]*\.?[0-9]+$)/;
	if(isEmpty(lattitude)){
		setDiv("lattitudeErr", "Should not be empty");
		return false;
	}else if(!regx.test(lattitude)){
		setDiv("lattitudeErr", "Invalid Input");
		return false;
	}else{
		setDiv("lattitudeErr", "");
		return true;
	}
	
}

/*function validateLattitude1(event) {
    var charCode = (event.which) ? event.which : event.keyCode;
   
    if ((charCode >= 48 && charCode <= 57) || charCode == 109 || charCode == 110 || charCode == 173) {
    	//setVal('lattitude').value = "";
        return true;
    } 
    return false;
}*/

function validateLongitude()
{
	var longitude = getVal('longitude').trim();
	var regx = /(^[-+]?[0-9]*\.?[0-9]+$)/;
	if(isEmpty(longitude)){
		setDiv("longitudeErr", "Should not be empty");
		return false;
	}else if(!regx.test(longitude)){
		setDiv("longitudeErr", "Invalid Input");
		return false;
	}else{
		setDiv("longitudeErr", "");
		return true;
	}
	
}

function validateRadius()
{
	var radius = getVal('radius').trim();
	var regx = /(^\d+(\.\d+)*$)/;
	if(isEmpty(radius)){
		setDiv("radiusErr", "Should not be empty");
		return false;
	}else if(!regx.test(radius)){
		setDiv("radiusErr", "Invalid Input");
		return false;
	}else{
		setDiv("radiusErr", "");
		return true;
	}
	
}

function validateType()
{
	var type = getVal('type').trim();
	var regx = /^[A-Za-z0-9._ ]+$/;
	if(isEmpty(type)){
		setDiv("typeErr", "Should not be empty");
		return false;
	}else {
		setDiv("typeErr", "");
		return true;
	}
	
}

function validateSubType() {
	var subType = getVal('subType').trim();
	var regx = /^[A-Za-z0-9._ ]+$/;
	if(isEmpty(subType)){
		setDiv("subTypeErr", "Should not be empty");
		return false;
	} else {
		setDiv("subTypeErr", "");
		return true;
	}
}
	function validateStatus() {
		var status = getVal('status').trim();
		var regx = /^[A-Za-z ]+$/;
		if(isEmpty(status)){
			setDiv("statusErr", "Should not be empty");
			return false;
		} else {
			setDiv("statusErr", "");
			return true;
		}
	
	
}

function validateZoneCreate() {
	var flag = true;
	if(!validateLocationId() | !validatezoneName() | !validategeofence() | !validateLattitude() | !validateLongitude() | !validateRadius() | !validateType() | !validateSubType()){
		flag = false;
		return flag;
	}
	return flag;
} 

function validateZoneUpdate() {
	var flag = true;
	if(!validateLocationId()|!validatezoneName()|!validategeofence()|!validateLattitude()|!validateLongitude()|!validateRadius()|!validateType()|!validateSubType()){
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

function clearState() {

	document.getElementById('state').options.length = 0;

	var selectOption = document.createElement("option");
	selectOption.innerHTML = ".:Select:.";
	selectOption.value = "";

	$("#state").append(selectOption);
}

function removeDisable() {
	 document.getElementById('applicationId').disabled = false;
	 document.getElementById('myButton').value='Processing...';
	 document.getElementById('myButton').disabled=true;
}

function closePopupActivate() {
	get('activateReason').value =null;
	$("#activateDiv").removeClass("has-error").removeClass( "has-success");
	$("#activateErr").removeClass("visible");
	setDiv("activateErr", "");
	$('#activatePop').popup("hide");
}
function editZone(id) {
	get('id').value = id;
	document.forms["zoneEditForm"].submit();
}

function confirmDeleteZone(zoneId) {
	var r = confirm("Press Ok to confirm deletion");
	if (r == true) {
		get('delZoneId').value = zoneId;
		document.forms["zoneDeleteForm"].submit();
	} else {
		return;
	}
}

function changeStatus(id, status, statusText,roleType) {
	clearPopupDesc();
	$('#changeStatusPopupDiv').popup('show');
	setDiv("sts", " Do you wish to change Role status to " + statusText + '?');
	get('id').value = id;
	get('status').value = status;
}
/**
 * Method for hide the popup
 * 
 */
function hideRolePopUp() {
	$('#rolePopupDiv').popup('hide');
}
