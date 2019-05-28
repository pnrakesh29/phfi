$(document).ready(function() {
	//visit form start
	$('#feverId').hide();
	 $('#weightId').hide();
	 $('#breathlessId').hide();
	 $('#coughId').hide();
	 $('#abnormalPain').hide();
	 $('#bleedingId').hide();
	 $('#bpId').hide();
	 $('#hbId').hide();
	 $('#urineId').hide();
	 $('#ultrasoundId').hide();
	 $('#rbsId').hide();
	 $('#malariaId').hide();
	 $('#sputumId').hide();
	 $('#anyOtherTestId').hide();
	 //vigit form end
	 //registration form start
	 
	/* $('#currentPlaceId').hide();
	 $('#otherEducationId').hide();*/
	 $('#isProblemBefore').hide();
	 
	 //registration form end
	 $('#havePainId').hide();
	 $('#otherDeliveryPlaceId').hide();
	 
	 
});
function showFever(){
	$('#feverId').show();
}

function hideFever(){
	$('#feverId').hide();
}
function showBreathless(){
	$('#breathlessId').show();
}
function hideBreathless(){
	$('#breathlessId').hide();
}
function showCough(){
	$('#coughId').show();
}
function hideCough(){
	$('#coughId').hide();
}

function showAbnormalPain(){
	$('#abnormalPain').show();
}
function hideAbnormalPain(){
	$('#abnormalPain').hide();
}

function showBleeding(){
	$('#bleedingId').show();
}
function hideBleeding(){
	$('#bleedingId').hide();
}

function showWeight(){
	$('#weightId').show();
}

function hideWeight(){
	$('#weightId').hide();
}
//

function showBp(){
	$('#bpId').show();
}

function hideBp(){
	$('#bpId').hide();
}

function showHb(){
	$('#hbId').show();
}

function hideHb(){
	$('#hbId').hide();
}

function showUrine(){
	$('#urineId').show();
}

function hideUrine(){
	$('#urineId').hide();
}


function showUltrasound(){
	$('#ultrasoundId').show();
}

function hideUltrasound(){
	$('#ultrasoundId').hide();
}


function showRbs(){
	$('#rbsId').show();
}

function hideRbs(){
	$('#rbsId').hide();
}


function showMalaria(){
	$('#malariaId').show();
}

function hideMalaria(){
	$('#malariaId').hide();
}


function showSputum(){
	$('#sputumId').show();
}

function hideSputum(id){
	$('#sputumId').hide();
}

function showAnyOtherTest(){
	$('#anyOtherTestId').show();
}

function hideAnyOtherTest(){
	$('#anyOtherTestId').hide();
}

/*function showCurrentPlace(){
	var place = document.getElementById("currentPlace").value;
	if(place =="other"){
		$('#currentPlaceId').show();
	}else{
		$('#currentPlaceId').hide();
	}
}

function showOtherEducation(){
	var otherEducation = document.getElementById("education").value;
	if(otherEducation =="other"){
		$('#otherEducationId').show();
	}else{
		$('#otherEducationId').hide();
	}
}*/
/*function showProblemBefore(){
	$('#isProblemBefore').show();	
}

function hideProblemBefore(){
	$('#isProblemBefore').hide();	
}*/

function showHavePain(){
	$('#havePainId').show();	
}

function hideHavePain(){
	$('#havePainId').hide();	
}

function showDeliveryPlace(){
	var deliveryPlace = document.getElementById("deliveryPlace").value;
	if(deliveryPlace =="other"){
		$('#otherDeliveryPlaceId').show();
	}else{
		$('#otherDeliveryPlaceId').hide();
	}
}




