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


