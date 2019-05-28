function validatePreganencyLast(data, div_id){
	var pregLastvalue=getVal(data);
	var regx = /^[0-9]+$/;
	if(isEmpty(pregLastvalue)){
		setDiv(div_id, "This field is mandatory");
		return false;
	}
	if(!regx.test(pregLastvalue)){
		setDiv(div_id, "Enter numeric value only ");
		return false;
	}else if (!(pregLastvalue >= 1 && pregLastvalue <= 9) ){
		setDiv(div_id, "Enter between 1 and 9");
		return false;
	}
	else{
		setDiv(div_id, "");
		return true;
	}
}

function validateBabyWeight(data, div_id){

	var babyWeight=getVal(data);
	var regx = /^[0-9\.]+$/;
	if(isEmpty(babyWeight)){
		setDiv(div_id, "This field is mandatory");
		return false;
	}
	if(!regx.test(babyWeight)){
		setDiv(div_id, "Enter numeric value only ");
		return false;
	}else if (!(babyWeight >= 1 && babyWeight <= 5) ){
		setDiv(div_id, "Enter between 1 and 5");
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


function setDeliveryDetails(){
	setLable('confirmDateOfDelivery', get('deliveryDate').value.trim());
	setLable('confirmPregnancyLast', get('pregnancyLast').value.trim());
	setLable('confirmBabyStatus', get('isBabyAlive').value.trim());
	setLable('confirmDelveryPlace', get('deliveryPlace').value.trim());
	setLable('confirmDeliveryConductedBy', get('deliveryConductedBy').value.trim());
	setLable('confirmDeliveryType', get('deliveryType').value.trim());
	setLable('confirmBabyWeight', get('babyWeight').value.trim());
	setLable('confirmBleedingAfetrDelivery', get('isExcessiveBleeding').value.trim());
	return true;
}