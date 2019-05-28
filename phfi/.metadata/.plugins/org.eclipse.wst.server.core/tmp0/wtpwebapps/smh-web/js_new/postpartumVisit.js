function bpValidation(data, div_id) {
	var bpvalue=getVal(data);
	if (bpvalue != "") {
		var parts = bpvalue.split("/");
		var diastolic = parts[parts.length - 1];
		var systolic = parts[parts.length - 2];
		if ((typeof diastolic == "undefined")
				|| (typeof systolic == "undefined") || (diastolic == "")
				|| (systolic == "")) {

			setDiv(div_id,"Enter valid format:Eg:120/80");
			return false;
		} else {
			setDiv(div_id,"");

		}
		if (diastolic != "" && systolic != "") {
			if ((diastolic < 60 || diastolic > 300 || systolic < 40 || systolic > 140)){
				if (diastolic < 60 && systolic < 40) {
					setDiv(div_id,"The systolic/diastolic BP value you have entered seems very low");
				
				} else if (diastolic > 300 && systolic > 140) {
					setDiv(div_id,"The systolic/diastolic BP value you have entered seems very high");
				} else if (diastolic < 60) {
					setDiv(div_id,"The diastolic BP value you have entered seems very low");
				} else if (systolic < 40) {
					setDiv(div_id,"The systolic BP value you have entered seems very low");
				} else if (diastolic > 300) {
					setDiv(div_id,"The diastolic BP value you have entered seems very high");
				} else if (systolic > 140) {
					setDiv(div_id,"The systolic BP value you have entered seems very high");
				}
			} else {
				setDiv(div_id,"");
			}
		}
	}
}

function weightValidation(data, div_id){
	var weightvalue=getVal(data);
	var regx = /^[0-9]+$/;
	if(isEmpty(weightvalue)){
		setDiv(div_id, "This field is mandatory");
		return false;
	}
	if(!regx.test(weightvalue)){
		setDiv(div_id, "Enter numeric value only ");
		return false;
	}else if (!(weightvalue >= 30 && weightvalue <= 90) ){
		setDiv(div_id, "Enter between 30 and 90");
		return false;
	}
	else{
		setDiv(div_id, "");
		return true;
	}
}

function rbsValidation(data, div_id){
	var rbsvalue=getVal(data);
	var regx = /^[0-9]+$/;
	if(isEmpty(rbsvalue)){
		setDiv(div_id, "This field is mandatory");
		return false;
	}
	if(!regx.test(rbsvalue)){
		setDiv(div_id, "Enter numeric value only ");
		return false;
	}else if (!(rbsvalue >= 40 && rbsvalue <= 400) ){
		setDiv(div_id, "Enter between 40 and 400");
		return false;
	}
	else{
		setDiv(div_id, "");
		return true;
	}
}

function hbValidation(data, div_id){
	var hbvalue=getVal(data);
	var regx = /^[0-9\.]+$/;
	if(isEmpty(hbvalue)){
		setDiv(div_id, "This field is mandatory");
		return false;
	}
	if(!regx.test(hbvalue)){
		setDiv(div_id, "Enter numeric value only ");
		return false;
	}else if (!(hbvalue >= 2 && hbvalue <= 16) ){
		setDiv(div_id, "Enter between 2 and 16");
		return false;
	}
	else{
		setDiv(div_id, "");
		return true;
	}
}


function setAshaInfo(){
	setLable('confirmVigitDate', get('visitDate').value.trim());
	setLable('confirmWid', get('wid').value.trim());
	setLable('confirmWomanName', get('womanName').value.trim());
	return true;
}

function setAskTheWoman(){
	setLable('confirmHaveFeer', get('haveFever').value.trim());
	setLable('confirmHadFit', get('isFits').value.trim());
	setLable('confirmLostConsciousness', get('isConsciousness').value.trim());
	/*setLable('confirmFeltGiddy', get('feltGiddy').value.trim());*/
	setLable('confirmHaveHeadaches', get('haveHeadaches').value.trim());
	setLable('confirmBlurreVission', get('haveBlurredVision').value.trim());
	setLable('confirmBreathless', get('isBreathless').value.trim());
	setLable('confirmHaveCough', get('haveCough').value.trim());
	setLable('confirmAbdominalPain', get('isAbdominalPain').value.trim());
	/*setLable('confirmBlurreVission', get('babyMove').value.trim());*/
	setLable('confirmVaginalDischarge', get('isVaginalDischarge').value.trim());
	setLable('confirmAnyBleeding', get('isBleeding').value.trim());
	/*setLable('confirmHaveWaterBroken', get('isWaterBroken').value.trim());*/
	setLable('confirmBurningPain', get('isBurningPain').value.trim());
	/*setLable('confirmRingTighter', get('toeRingsTighter').value.trim());*/
	/*setLable('confirmWearBangles', get('isBangles').value.trim());*/
	return true;
}

function setObserve(){
	setLable('confirmOutOFBreath', get('outOfBreath').value.trim());
	setLable('confirmTakingIrrelevantly', get('isTalking').value.trim());
	setLable('confirmUpperEye', get('upperEyeColor').value.trim());
	setLable('confirmLowerEye', get('lowerEyeColor').value.trim());
	setLable('confirmHisFeet', get('isAnkleDepression').value.trim());
	setLable('confirmFace', get('isEyeSwelling').value.trim());
	return true;
}

function setTestResult(){
	/*setLable('confirmWeightStatus', get('weight').value.trim());
	setLable('confirmFirstWeight', get('firstWeight').value.trim());
	setLable('confirmFirstWeightDate', get('weightDateOne').value.trim());
	setLable('confirmSecWeight', get('SecWeight').value.trim());
	setLable('confirmSecWeightDate', get('weightDateSec').value.trim());
	setLable('confirmThirdWeight', get('thirdWeight').value.trim());
	setLable('confirmThirdWeightDate', get('weightDateThird').value.trim());
	setLable('confirmFourthWeight', get('fourthWeight').value.trim());
	setLable('confirmFourthWeightDate', get('weightDateFour').value.trim());*/
	
	setLable('confirmBpStatus', get('bp').value.trim());
	setLable('confirmFirstBp', get('firstBp').value.trim());
	setLable('confirmFirstBpDate', get('bpDateOne').value.trim());
	setLable('confirmSecBp', get('secBp').value.trim());
	setLable('confirmSecBpDate', get('bpDateSec').value.trim());
	/*setLable('confirmThirdBp', get('thirdBp').value.trim());
	setLable('confirmThirdBpDate', get('bpDateThird').value.trim());
	setLable('confirmFourthBp', get('fourBp').value.trim());
	setLable('confirmFourthBpDate', get('bpDateFour').value.trim());*/
	
	setLable('confirmHbStatus', get('hb').value.trim());
	setLable('confirmFirstHb', get('firstHb').value.trim());
	setLable('confirmFirstHbDate', get('hbDateOne').value.trim());
	setLable('confirmSecHb', get('secHb').value.trim());
	setLable('confirmSecHbDate', get('hbDateSec').value.trim());
	/*setLable('confirmThirdHb', get('thirdHb').value.trim());
	setLable('confirmThirdHbDate', get('hbDateThird').value.trim());
	setLable('confirmFourthHb', get('fourHb').value.trim());
	setLable('confirmFourthHbDate', get('hbDateFour').value.trim());*/
	
	setLable('confirmUaStatus', get('urine').value.trim());
	setLable('confirmFirstUa', get('firstUrine').value.trim());
	setLable('confirmFirstUaDate', get('urineDateOne').value.trim());
	setLable('confirmSecUa', get('secUrine').value.trim());
	setLable('confirmSecUaDate', get('urineDateSec').value.trim());
	
	/*
	setLable('confirmUsStatus', get('ultrasound').value.trim());
	setLable('confirmFirstUs', get('firstUltrasound').value.trim());
	setLable('confirmFirstUsDate', get('ultrasoundDateOne').value.trim());
	setLable('confirmSecUs', get('secUltrasound').value.trim());
	setLable('confirmSecUsDate', get('ultrasoundDateSec').value.trim());*/
	/*
	setLable('confirmRbsStatus', get('regDate').value.trim());
	setLable('confirmFirstRbs', get('villageId').value.trim());
	setLable('confirmFirstRbsDate', get('uid').value.trim());
	setLable('confirmSecRbs', get('regDate').value.trim());
	setLable('confirmSecRbsDate', get('villageId').value.trim());
	*/
	/*setLable('confirmRbsStatus', get('rbs').value.trim());
	setLable('confirmFirstRbs', get('firstRbs').value.trim());
	setLable('confirmFirstRbsDate', get('rbsDateOne').value.trim());
	setLable('confirmSecRbs', get('secRbs').value.trim());
	setLable('confirmSecRbsDate', get('rbsDateSec').value.trim());*/
	
	setLable('confirmMalariaStatus', get('malaria').value.trim());
	setLable('confirmFirstMalaria', get('firstMalaria').value.trim());
	setLable('confirmFirstMalariaDate', get('malariaDateOne').value.trim());
	setLable('confirmSecMalaria', get('secMalaria').value.trim());
	setLable('confirmSecMalariaDate', get('malariaDateSec').value.trim());
	
	setLable('confirmSputumStatus', get('sputum').value.trim());
	setLable('confirmFirstSputum', get('sputumTest').value.trim());
	setLable('confirmFirstSputumDate', get('sputumDate').value.trim());
	return true;
}
function setAskTheFamily(){
	setLable('confirmTalkingAndDisconnected', get('talkingIrrelevantly').value.trim());
	setLable('confirmCaringBaby', get('carringBabyAndHerself').value.trim());
	setLable('confirmImaginaryVoiceAndPeople', get('isHearingImaginary').value.trim());
	return true;
}



