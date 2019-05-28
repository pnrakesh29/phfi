<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>PHFI</title>
<!-- Bootstrap -->
<link href="../css_new/bootstrap.min.css" rel="stylesheet">
<link href="../css/style.css" rel="stylesheet">
<link href="../css_new/jquery.datetimepicker.css" rel="stylesheet"
	type="text/css" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<script type="text/javascript">
	function stopRKey(evt) {
		var evt = (evt) ? evt : ((event) ? event : null);
		var node = (evt.target) ? evt.target
				: ((evt.srcElement) ? evt.srcElement : null);
		if ((evt.keyCode == 13) && (node.type == "text")) {
			return false;
		}
	}

	document.onkeypress = stopRKey;
</script>
</head>
<body>


	<!--Body Wrapper block Start -->
	<div id="wrapper">
		<!--Container block Start -->
		<div class="container-fluid">
			<!--Header Block Start -->
			<!-- <header class="col-sm-12 all-page-header">
			<!--Header Block End -->
			<!--Navigation Block Start -->
			<nav class="col-sm-12 nav-bar" id="main-navigation">
				<jsp:include page="navigation.jsp"></jsp:include>
			</nav>
			<!--Navigation Block Start -->
			<!--Article Block Start-->
			<article>
				<div class="col-xs-12 content-wrapper">
					<!-- Breadcrumb start -->
					
					<!-- Breadcrumb End -->
					<!-- Tab Buttons Start -->
					<br/>
					<div class="tab-header-container active-background">
						<a href="#"><spring:message code="com.phfi.create" /></a>
					</div>
					<!-- Tab Buttons End -->
					
					
						<!-- Page Form Start -->
						<form:form action="process-doctor-visit-form" commandName="phfiDoctorFormRequest" name="phfiDoctorFormRequest" method="POST">
							<div class="col-sm-12 paddingT20">
								<div class="row">
										<section class="field-element-row women-info-content"
												style="display: none;">
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-4">
														<label><spring:message code="com.phfi.doctor.visitdate" /><span
															class="required-field">*</span></label>
														<div class="input-group registrationdate">
															<form:input cssClass="form-control regDate"
																path="date" id="date"
																onblur="return clientValidation('date', 'required','visitDateErrorDiv')" />
															<span class="input-group-addon"><span
																class="glyphicon glyphicon-calendar"></span></span>
														</div>
														<div class="discriptionErrorMsg">
															<span id="visitDateErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-4" style="margin-left: 330px;">
														<label><spring:message code="com.phfi.doctor.place" /><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="place" id="place"
															maxlength="50"
															onblur="return clientValidation('place', 'numericField','uidErrorId')" />
														<div class="discriptionErrorMsg">
															<span id="uidErrorId" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												
												<fieldset class="col-sm-12" >
												<fieldset class="col-sm-4" >
														<label><spring:message code="com.phfi.doctor.doctorname" /><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="doctorName"
															id="doctorName" maxlength="50"
															onblur="return clientValidation('doctorName', 'alpha','doctorNameErrorDiv')" />
														<div class="discriptionErrorMsg">
															<span id="doctorNameErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-4" style="margin-left: 330px;">
														<label><spring:message code="com.phfi.doctor.qualification" /><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="qualification"
															id="qualification" maxlength="50"
															onblur="return clientValidation('qualification', 'alpha','qualificationErrorDiv')" />
														<div class="discriptionErrorMsg">
															<span id="qualificationErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12" >
												<fieldset class="col-sm-4" >
														<label><spring:message code="com.phfi.doctor.name" /><span class="required-field">*</span></label>
														<form:select cssClass="form-control" path="womanName"
															id="womanName" 
															onblur="return clientValidation('womanName', 'alpha','nameErrorDiv')" >
															<form:option value="">--Select--</form:option>
															 <c:forEach items="${allWomenNameList}" var="allWomenName">
																    <form:option value="${allWomenName}">${allWomenName}</form:option>
															        </c:forEach>
															</form:select>
														<div class="discriptionErrorMsg">
															<span id=nameErrorDiv class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-4" >
														<label><spring:message code="com.phfi.doctor.age" /><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="age"
															id="age" maxlength="50"
															onblur="return clientValidation('age', 'alpha','ageErrorId')" />
														<div class="discriptionErrorMsg">
															<span id="womanNameErrorId" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-4" >
														<label><spring:message code="com.phfi.doctor.years" /><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="years"
															id="years" maxlength="50"
															onblur="return clientValidation('years', 'alpha','yearsErrorDiv')" />
														<div class="discriptionErrorMsg">
															<span id="yearsErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-4" >
														<label><spring:message code="com.phfi.doctor.wid" /><span class="required-field">*</span></label>
														<form:select cssClass="form-control" path="wid"
															id="wid" 
															onblur="return clientValidation('wid', 'alpha','widErrorDiv')" >
															<form:option value="">--Select--</form:option>
															 <c:forEach items="${allWidList}" var="allWid">
																 <form:option value="${allWid}">${allWid}</form:option>
															      </c:forEach>
															</form:select>
														<div class="discriptionErrorMsg">
															<span id="widErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12" >
												<fieldset class="col-sm-4" >
														<label><spring:message code="com.phfi.doctor.village" /><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="village"
															id="village" maxlength="50"
															onblur="return clientValidation('village', 'alpha','villageErrorDiv')" />
														<div class="discriptionErrorMsg">
															<span id="villageErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-4" >
														<label><spring:message code="com.phfi.doctor.taluk" /><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="taluk"
															id="taluk" maxlength="50"
															onblur="return clientValidation('takul', 'alpha','takulErrorId')" />
														<div class="discriptionErrorMsg">
															<span id="takulErrorId" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-4" >
														<label><spring:message code="com.phfi.doctor.district" /><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="district"
															id="district" maxlength="50"
															onblur="return clientValidation('district', 'alpha','districtErrorId')" />
														<div class="discriptionErrorMsg">
															<span id="districtErrorId" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													
												</fieldset>
												<fieldset class="col-sm-12" >
												<fieldset class="col-sm-4" >
														<label><spring:message code="com.phfi.doctor.address.marital" /><span class="required-field">*</span></label>
														<textarea cssClass="form-control" name="addressMartial" 
															id="addressMartial" style="margin: 0px; width: 338px; height: 104px;"
															onblur="return clientValidation('addressMartial', 'alpha','addressMartialErrorId')" >
															</textarea>
														<div class="discriptionErrorMsg">
															<span id="addressMartialErrorId" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-4" style="margin-left: 330px;">
														<label><spring:message code="com.phfi.doctor.address.natal" /><span class="required-field">*</span></label>
														<textarea cssClass="form-control" name="addressnatal" style="margin: 0px; width: 338px; height: 104px;"
															id="addressnatal" 
															onblur="return clientValidation('addressnatal', 'alpha','addressnatalErrorId')" >
															</textarea>
														<div class="discriptionErrorMsg">
															<span id="addressnatalErrorId" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													
												</fieldset>
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-4" >
														<label><spring:message code="com.phfi.doctor.obstic" /><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="obstic" id="obstic"
															maxlength="50"
															onblur="return clientValidation('obstic', 'numericField','obsticErrorId')" />
														<div class="discriptionErrorMsg">
															<span id="obsticErrorId" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-4">
														<label><spring:message code="com.phfi.doctor.lmp" /><span
															class="required-field">*</span></label>
														<div class="input-group registrationdate">
															<form:input cssClass="form-control regDate"
																path="lmp" id="lmp"
																onblur="return clientValidation('lmp', 'required','lmpErrorDiv')" />
															<span class="input-group-addon"><span
																class="glyphicon glyphicon-calendar"></span></span>
														</div>
														<div class="discriptionErrorMsg">
															<span id="lmpErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												
													<fieldset class="col-sm-4">
														<label><spring:message code="com.phfi.doctor.dod" /><span
															class="required-field">*</span></label>
														<div class="input-group registrationdate">
															<form:input cssClass="form-control regDate"
																path="dod" id="dod"
																onblur="return clientValidation('dod', 'required','dodErrorDiv')" />
															<span class="input-group-addon"><span
																class="glyphicon glyphicon-calendar"></span></span>
														</div>
														<div class="discriptionErrorMsg">
															<span id="dodErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													</fieldset>
													<fieldset class="col-sm-12">
													<fieldset class="col-sm-4" >
														<label><spring:message code="com.phfi.doctor.history" /><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="history" 
															id="history" 
															onblur="return clientValidation('history', 'alpha','historyErrorId')" />
														<div class="discriptionErrorMsg">
															<span id="historyErrorId" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													
													<fieldset class="col-sm-4" >
														<label><spring:message code="com.phfi.doctor.labtest" /><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="labtest" 
															id="labtest" 
															onblur="return clientValidation('labtest', 'alpha','labtestErrorId')" />
														<div class="discriptionErrorMsg">
															<span id="addressMartialErrorId" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-4" >
														<label><spring:message code="com.phfi.doctor.diagonosis" /><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="diagonosis" 
															id="diagonosis" 
															onblur="return clientValidation('diagonosis', 'alpha','diagonosisErrorId')" />
														<div class="discriptionErrorMsg">
															<span id="addressMartialErrorId" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-4" >
														<label><spring:message code="com.phfi.doctor.assesmentstatus" /><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="assesmentstatus" 
															id="assesmentstatus" 
															onblur="return clientValidation('assesmentstatus', 'alpha','assesmentstatusErrorId')" />
														<div class="discriptionErrorMsg">
															<span id="assesmentstatusErrorId" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-4" >
														<label><spring:message code="com.phfi.doctor.advice" /><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="advice" 
															id="advice" 
															onblur="return clientValidation('advice', 'alpha','adviceErrorId')" />
														<div class="discriptionErrorMsg">
															<span id="adviceErrorId" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-4" >
														<label><spring:message code="com.phfi.doctor.investigations" /><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="investigations" 
															id="investigations" onblur="return clientValidation('investigations', 'alpha','investigationsErrorId')" />
														<div class="discriptionErrorMsg">
															<span id="investigationsErrorId" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-4" >
														<label><spring:message code="com.phfi.doctor.medication" /><span class="required-field">*</span></label>
														<form:input path="medication" cssClass="form-control" id="medication"
														onblur="return clientValidation('addressMartial', 'alpha','medicationErrorId')"/>
														<div class="discriptionErrorMsg">
															<span id="medicationErrorId" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												
												<fieldset class="col-sm-4" >
														<label><spring:message code="com.phfi.doctor.health" /><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="health" 
															id="health" 
															onblur="return clientValidation('health', 'alpha','healthErrorId')" />
														<div class="discriptionErrorMsg">
															<span id="healthErrorId" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												
												</fieldset>
													
												
												<!--Panel Action Button Start -->
												<div class="col-sm-12 button-content">
													<fieldset class="col-sm-7 pull-right">
														<input type="submit"
															class="form-control button pull-right confirm-next"
															value="Save"><input type="button"
															class="form-control button pull-right marginL10"
															value="Cancel" onclick="cancel()">
													</fieldset>
												</div>
 										<!--Panel Action Button End -->
											</section>
											<!-- Confirmation Content End -->
								</div>
							</div>
						</form:form>
						<!-- Page Form End -->
							</div>
						</div>
						</article>
					</div>
					<!-- Content Block End -->
				</div>
			<!--Article Block End-->
			<jsp:include page="footer.jsp"></jsp:include>
		<!--Container block End -->


	<script src="../js_new/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<!-- <script src="../js_new/bootstrap.min.js"></script> -->
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js_new/jquery.datetimepicker.js"></script>
	<script src="../js_new/common-lib.js"></script>
	<script src="../js_new/validation.js"></script>
	<script src="../js_new/registration.js"></script>
	<script src="../js_new/chatak-ajax.js"></script>
	<script src="../js_new/messages.js"></script>
	<script src="../js_new/hideAndShow.js"></script>
	<script src="../js_new/delivery.js"></script>
	<!--Body Wrapper block End -->
	<script type="text/javascript" src="../js_new/merchant.js"></script>
	<script type="text/javascript" src="../js_new/backbutton.js"></script>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script>
$(document).ready(function() {
	$( "#navListId3" ).addClass( "active-background" );
	});
		$(".registrationdate").click(function() {
			$(this).children('.regDate').focus();
		});
		$('.regDate').datetimepicker({
			timepicker : false,
			format : 'd/m/Y',
			formatDate : 'Y/m/d',
			maxDate: '0', 
		});

		$(".dateOfrcntDlv").click(function() {
			$(this).children('.dateOfRecentDelivery').focus();
		});
		$('.dateOfRecentDelivery').datetimepicker({
			timepicker : false,
			format : 'd/m/Y',
			formatDate : 'Y/m/d',
			maxDate: '0', 
		});
		$(".lmpdate").click(function() {
			$(this).children('.lmp').focus();
		});
		$('.lmp').datetimepicker({
			timepicker : false,
			format : 'd/m/Y',
			formatDate : 'Y/m/d',
			maxDate: '0', 
		});
		$(".women-info-content").show();
		$(".womenInfo-arrow").show();
		$(".delivery-arrow,.confirm-arrow").hide();
		$(".women-info-list,.delivery-prev").click(
				function() {
					$(".womenInfo-circle-tab").addClass("active-circle");
					$(".delivery-circle-tab,.confirm-circle-tab").removeClass("active-circle");
					$(".womenInfo-arrow").show();
					$(".delivery-arrow,.confirm-arrow").hide();
					$(".women-info-content").show();
					$(".delivery-info-content,.confirm-details-content").hide();
				});
		
		$(".delivery-info-list,.women-next,.confirm-prev").click(
				function() {
					
					$(".delivery-circle-tab").addClass("active-circle");
					$(".womenInfo-circle-tab,.confirm-circle-tab").removeClass("active-circle");
					$(".delivery-arrow").show();
					$(".womenInfo-arrow,.confirm-arrow").hide();
					$(".delivery-info-content").show();
					$(".women-info-content,.confirm-details-content").hide();
				});
		$(".confirm-info-list,.delivery-next").click(
				function() {
					if(!setAshaInfo()|!setDeliveryDetails()){
						return true;
					}
					$(".confirm-circle-tab").addClass("active-circle");
					$(".delivery-circle-tab,.womenInfo-circle-tab").removeClass("active-circle");
					$(".confirm-arrow").show();
					$(".womenInfo-arrow,.delivery-arrow").hide();
					$(".confirm-details-content").show();
					$(".women-info-content,.delivery-info-content").hide();
				});	
	</script>
</body>
</html>