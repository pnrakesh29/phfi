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
					<!-- <div class="breadCrumb">
						<span class="breadcrumb-text">Registration</span> <span
							class="glyphicon glyphicon-play icon-font-size"></span> <span
							class="breadcrumb-text">Create</span>
					</div> -->
					<!-- Breadcrumb End -->
					<!-- Tab Buttons Start -->
					<br/>
					<div class="tab-header-container active-background">
						<a href="#"><spring:message code="com.phfi.create" /></a>
					</div>
					<!-- Tab Buttons End -->
					<!-- Content Block Start -->
					<div class="main-content-holder padding0">
						<!-- Page Menu Start -->
						<div class="col-sm-12 padding0">
							<div class="sub-nav">
								<ul>
									<!-- <li class="asha-info-list">
										<div class="circle-div">
											<div class="hr"></div>
											<span class="asha-circle-tab active-circle"></span>
										</div> <label>ASHA Info</label>
										<div class="arrow-down asha-arrow"></div>
									</li> -->
									<li class="priliminary-info-list">
										<div class="circle-div">
											<div class="hr"></div>
											<span class="preliminary-circle-tab"></span>
										</div> <label><spring:message code="com.phfi.preliminiryDetails" /></label>
										<div class="arrow-down preliminary-arrow"></div>
									</li>
									<li class="contact-info-list">
										<div class="circle-div">
											<div class="hr"></div>
											<span class="contact-circle-tab"></span>
										</div> <label><spring:message code="com.phfi.contactDetails" /></label>
										<div class="arrow-down contact-arrow"></div>
									</li>
									<li class="personal-info-list">
										<div class="circle-div">
											<div class="hr"></div>
											<span class="personal-circle-tab"></span>
										</div> <label><spring:message code="com.phfi.personalDetails" /></label>
										<div class="arrow-down personal-arrow"></div>
									</li>
									<li class="pasthistory-info-list">
										<div class="circle-div">
											<div class="hr"></div>
											<span class="pasthistory-circle-tab"></span>
										</div> <label><spring:message code="com.phfi.pastHistory" /></label>
										<div class="arrow-down pasthistory-arrow"></div>
									</li>
									<li class="obstetric-info-list">
										<div class="circle-div">
											<div class="hr"></div>
											<span class="obstetric-circle-tab"></span>
										</div> <label><spring:message code="com.phfi.obstetricHistory" /></label>
										<div class="arrow-down obstetric-arrow"></div>
									</li>
									<li class="otherinformation-info-list">
										<div class="circle-div">
											<div class="hr"></div>
											<span class="otherinformation-circle-tab"></span>
										</div> <label><spring:message code="com.phfi.otherInformation" /></label>
										<div class="arrow-down otherinformation-arrow"></div>
									</li>
									<li class="confirm-info-list">
										<div class="circle-div">
											<div class="hr"></div>
											<span class="confirm-circle-tab"></span>
										</div> <label><spring:message code="com.phfi.summary" /></label>
										<div class="arrow-down confirm-arrow"></div>
									</li>
								</ul>
							</div>
						</div>
						<!-- Page Menu End -->
						<div class="row margin0">
							<div class="col-sm-12">
								<!--Success and Failure Message Start-->
								<div class="col-xs-12">
									<div class="discriptionErrorMsg col-xs-12">
										<span class="red-error">&nbsp;${error }</span> <span
											class="green-error">&nbsp;${success }</span>
									</div>
								</div>
								<!--Success and Failure Message End-->
								<!-- Page Form Start -->
								<form:form action="process-phfi-registration-form" commandName="phfiRegistrationRequest"
									name="phfiRegistrationRequest" method="post" onsubmit="buttonDisabled()">
									<div class="col-sm-12 paddingT20">
										<div class="row">
											<!-- Asha Details Content Start -->
										<%-- 	<section class="field-element-row asha-info-content"
												style="display: none;">
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-4">
														<label>Registration date<span
															class="required-field">*</span></label>
														<div class="input-group registrationdate">
															<form:input cssClass="form-control regDate"
																path="regDate" id="regDate"
																onblur="return clientValidation('regDate', 'required','regDateErrorDiv')" />
															<span class="input-group-addon"><span
																class="glyphicon glyphicon-calendar"></span></span>
														</div>
														<div class="discriptionErrorMsg">
															<span id="regDateErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-4" style="margin-left: 330px;">
														<label>Village Id<span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="villageId"
															id="villageId" maxlength="50"
															onblur="return clientValidation('villageId', 'numericField','villageIdErrorId')" />
														<div class="discriptionErrorMsg">
															<span id="villageIdErrorId" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												
												<fieldset class="col-sm-12" style="margin-left: 550px;">
													<fieldset class="col-sm-4">
														<label>UID<span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="uid" id="uid"
															maxlength="50"
															onblur="return clientValidation('uid', 'numericField','uidErrorId')" />
														<div class="discriptionErrorMsg">
															<span id="uidErrorId" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-4">
														<label>Village Name<span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="villageName"
															id="villageName" maxlength="50"
															onblur="return clientValidation('villageName', 'alphanumericField','villageNameErrorDiv')" />
														<div class="discriptionErrorMsg">
															<span id="villageNameErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-4">
														<label>PHC<span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="phc" id="phc"
															maxlength="10"
															onblur="return clientValidation('phc', 'alphaField','phcErrorId')" />
														<div class="discriptionErrorMsg">
															<span id="phcErrorId" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-4">
														<label>Name of the ASHA<span
															class="required-field">*</span></label>
														<form:input cssClass="form-control" path="ashaName"
															id="ashaName" maxlength="13"
															onblur="return clientValidation('ashaName', 'alphaField','ashaNameErrorId')" />
														<div class="discriptionErrorMsg">
															<span id="ashaNameErrorId" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-4">
														<label>Name of the ANM<span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="anmName"
															id="anmName" maxlength="50"
															onblur="return clientValidation('anmName', 'alphaField','anmNameErrorId')" />
														<div class="discriptionErrorMsg">
															<span id="anmNameErrorId" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-4">
														<label>Name of the ASHA facilitator<span
															class="required-field">*</span></label>
														<form:input cssClass="form-control"
															path="ashaFacilitatorName" id="ashaFacilitatorName"
															maxlength="50"
															onblur="return clientValidation('ashaFacilitatorName', 'alphaField','ashaFacilitatorNameErrorId')" />
														<div class="discriptionErrorMsg">
															<span id="ashaFacilitatorNameErrorId" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<!--Panel Action Button Start -->
												<div class="col-sm-12 button-content">
													<fieldset class="col-sm-7 pull-right">
														<input type="button" onclick="return validateAsha()"
															class="form-control button pull-right asha-next"
															value="Continue" > <input type="button"
															class="form-control button pull-right marginL10"
															value="Reset" onclick="return resetAsha()"> <input
															type="button"
															class="form-control button pull-right marginL10"
															value="Cancel" onclick="cancel()">
													</fieldset>
												</div>
												<!--Panel Action Button End -->
											</section> --%>
											<!-- Asha Details Content End -->
											<!-- Priliminary Details Content Start -->
											<section
												class="field-element-row priliminary-details-content"
												style="display: none;">
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-12">
														<label><b><spring:message code="com.phfi.fullNameOfWoman" /></b> <!-- <span class="required-field">*</span> --></label>
													</fieldset>
													<fieldset class="col-sm-4">
														<label><spring:message code="com.phfi.womanFirstName" /><!-- <span class="required-field">*</span> --></label>
														<form:input cssClass="form-control myclass" path="womenFirstName"
															id="womenFirstName" maxlength="50"
															onblur="return clientValidation('womenFirstName', 'alphaField','womenFirstNameErrorDiv')"/>
														<div class="discriptionErrorMsg">
															<span id="womenFirstNameErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-4">
														<label><spring:message code="com.phfi.womanHusbandName" /><!-- <span class="required-field">*</span> --></label>
														<form:input cssClass="form-control myclass"
															path="womenHusbandName" id="womenHusbandName"
															maxlength="50"
															onblur="return clientValidation('womenHusbandName', 'alphaField','womenHusbandNameErrorDiv')" />
														<div class="discriptionErrorMsg">
															<span id="womenHusbandNameErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-4">
														<label><spring:message code="com.phfi.womanSurname" /><!-- <span class="required-field">*</span> --></label>
														<form:input cssClass="form-control myclass" path="womenSurname"
															id="womenSurname" maxlength="50"
															onblur="return clientValidation('womenSurname', 'alphaField','womenSurnameErrorDiv')" />
														<div class="discriptionErrorMsg">
															<span id="womenSurnameErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-12">
														<label><b><spring:message code="com.phfi.fullNameOfHusband" /></b> <!-- <span class="required-field">*</span> --></label>
													</fieldset>
													<fieldset class="col-sm-4">
														<label><spring:message code="com.phfi.husbandFirstName" /><!-- <span class="required-field">*</span> --></label>
														<form:input cssClass="form-control myclass"
															path="husbandFirstName" id="husbandFirstName"
															maxlength="50"
															onblur="return clientValidation('husbandFirstName', 'alphaField','husbandFirstNameErrorDiv')" />
														<div class="discriptionErrorMsg">
															<span id="husbandFirstNameErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-4">
														<label><spring:message code="com.phfi.husbandFatherName" /><!-- <span class="required-field">*</span> --></label>
														<form:input cssClass="form-control myclass"
															path="husbandFatherName" id="husbandFatherName"
															maxlength="50"
															onblur="return clientValidation('husbandFirstName', 'alphaField','husbandFatherNameErrorDiv')" />
														<div class="discriptionErrorMsg">
															<span id="husbandFatherNameErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-4">
														<label><spring:message code="com.phfi.husbandSurname" /><!-- <span class="required-field">*</span> --></label>
														<form:input cssClass="form-control myclass" path="husbandSurname"
															id="husbandSurname" maxlength="50"
															onblur="return clientValidation('husbandSurname', 'alphaField','husbandSurnameErrorDiv')" />
														<div class="discriptionErrorMsg">
															<span id="husbandSurnameErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.maternityStatus" /> <span class="required-field">*</span>
														</label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="maternityStatus" path="maternityStatus"
															value="Pregnant"/><spring:message code="com.phfi.pregnant" /> &nbsp; <form:radiobutton
															id="maternityStatus" path="maternityStatus" value="Postpartum"/>&nbsp;&nbsp;<spring:message code="com.phfi.postpartum" /> 
														<div class="discriptionErrorMsg">
															<span id="maternityStatusDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.registrationDate" /><span
															class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<div class="input-group registrationdate">
															<form:input cssClass="form-control myclass regDate"
																path="regDate" id="regDate"
																onblur="return clientValidation('regDate', 'required','regDateErrorDiv')" />
															<span class="input-group-addon"><span
																class="glyphicon glyphicon-calendar"></span></span>
														</div>
														<div class="discriptionErrorMsg">
															<span id="regDateErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<!--Panel Action Button Start -->
												<div class="col-sm-12 button-content">
													<fieldset class="col-sm-7 pull-right">
														<input type="button"
															class="form-control myclass button pull-right priliminary-next"
															value="Continue" onclick="return validatePreliminary()"> <input type="button"
															class="form-control myclass button pull-right marginL10"
															value="Reset" onclick="return priliminaryReset()"> <input
															type="button"
															class="form-control myclass button pull-right marginL10"
															value="Cancel" onclick="cancel()">
													</fieldset>
												</div>
												<!--Panel Action Button End -->
											</section>
											<!-- Priliminary Details Content End -->
											<!-- Contact Details Content End -->
											<section class="field-element-row contact-details-content"
												style="display: none;">
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-12">
														<label><b><spring:message code="com.phfi.maritalHomeAddress" /></b></label>
													</fieldset>
													<div class="col-sm-12">
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.street" /><!-- <span class="required-field">*</span> --></label>
															<form:input cssClass="form-control myclass" path="streetMarital"
																id="streetMarital" maxlength="20"
																onblur="return clientValidation('streetMarital', 'alphanumericField','streetErrorDiv')" />
															<div class="discriptionErrorMsg">
																<span id="streetErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.landmark" /><!-- <span class="required-field">*</span> --></label>
															<form:input cssClass="form-control myclass"
																path="landmarkMarital" id="landmarkMarital"
																maxlength="50"
																onblur="return clientValidation('landmarkMarital', 'alphanumericField','landmarkMaritalErrorDiv');" />
															<div class="discriptionErrorMsg">
																<span id="landmarkMaritalErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.village" /><!-- <span class="required-field">*</span> --></label>
															<form:input cssClass="form-control myclass" path="villageMarital"
																maxlength="50" id="villageMarital"
																onblur="return clientValidation('villageMarital', 'alphanumericField','villageErrorDiv');" />
															<div class="discriptionErrorMsg">
																<span id="villageErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.taluk" /><!-- <span class="required-field">*</span> --></label>
															<form:input cssClass="form-control myclass" path="talukMarital"
																maxlength="12" id="talukMarital"
																onblur="return clientValidation('talukMarital', 'alphanumericField','talukErrorDiv');" />
															<div class="discriptionErrorMsg">
																<span id="talukErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.district" /><!-- <span class="required-field">*</span> --></label>
															<form:input cssClass="form-control myclass"
																path="districtMarital" maxlength="12"
																onblur="return clientValidation('districtMarital', 'alphanumericField','districtMaritalErrorDiv');"
																id="districtMarital" />
															<div class="discriptionErrorMsg">
																<span id="districtMaritalErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.phoneNumber1" /><!-- <span class="required-field">*</span> --></label>
															<form:input cssClass="form-control myclass" path="phone1Marital"
																maxlength="12" id="phone1Marital"
																onblur="return clientValidation('phone1Marital', 'mobile_phone','phone1MaritalErrorDiv');" />
															<div class="discriptionErrorMsg">
																<span id="phone1MaritalErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.phoneNumber2" /></label>
															<form:input cssClass="form-control myclass" path="phone2Marital"
																maxlength="12" id="phone2Marital" />
															<div class="discriptionErrorMsg">
																<span id="phone2MaritaleErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
													</div>
													<fieldset class="col-sm-12">
														<label><b><spring:message code="com.phfi.addressOfTheNatalHome" /></b></label>
													</fieldset>
													<div class="col-sm-12">
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.street" /><span class="required-field">*</span></label>
															<form:input cssClass="form-control myclass" path="streetNatal"
																id="streetNatal" maxlength="20"
																onblur="return clientValidation('streetNatal', 'alphanumericField','streetNatalErrorDiv');" />
															<div class="discriptionErrorMsg">
																<span id="streetNatalErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.landmark" /><span class="required-field">*</span></label>
															<form:input cssClass="form-control myclass" path="landmarkNatal"
																id="landmarkNatal" maxlength="50"
																onblur="return clientValidation('landmarkNatal', 'alphanumericField','landmarkNatalErrorDiv');" />
															<div class="discriptionErrorMsg">
																<span id="landmarkNatalErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.village" /><span class="required-field">*</span></label>
															<form:input cssClass="form-control myclass" path="villageNatal"
																maxlength="50" id="villageNatal"
																onblur="return clientValidation('villageNatal', 'alphanumericField','villageNatalErrorDiv');" />
															<div class="discriptionErrorMsg">
																<span id="villageNatalErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.taluk" /><!-- <span class="required-field">*</span> --></label>
															<form:input cssClass="form-control myclass" path="talukNatal"
																maxlength="12" id="talukNatal"
																onblur="return clientValidation('talukNatal', 'alphanumericField','talukNatalErrorDiv');" />
															<div class="discriptionErrorMsg">
																<span id="talukNatalErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.district" /><!-- <span class="required-field">*</span> --></label>
															<form:input cssClass="form-control myclass" path="districtNatal"
																maxlength="12" id="districtNatal"
																onblur="return clientValidation('districtNatal', 'alphanumericField','districtNatalErrorDiv');" />
															<%-- onblur="return clientValidation('legalHomePhone', 'contact_phone','legalHomePhoneErrorDiv');" --%>
															<div class="discriptionErrorMsg">
																<span id="districtNatalErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.phoneNumber1" /><!-- <span class="required-field">*</span> --></label>
															<form:input cssClass="form-control" path="phone1Natal"
																maxlength="12" id="phone1Natal"
																onblur="return clientValidation('phone1Natal', 'mobile_phone','phone1NataleErrorDiv');" />
															<div class="discriptionErrorMsg">
																<span id="phone1NataleErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.phoneNumber2" /></label>
															<form:input cssClass="form-control" path="phone2Natal"
																maxlength="12" id="phone2Natal"
																onblur="return clientValidation('phone2Natal', 'mobile_phone','phone2NatalErrorDiv');" />
															<div class="discriptionErrorMsg">
																<span id="phone2NatalErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
													</div>
													<fieldset class="col-sm-12">
														<label><b><spring:message code="com.phfi.others" /></b></label>
													</fieldset>
													<div class="col-sm-12">
														<fieldset class="col-sm-4">
															<label class="control-label" for=""><spring:message code="com.phfi.currentlyLive" /><span class="required-field">*</span>
															</label>
															<form:select path="currentPlace" id="currentPlace"
																cssClass="form-control" 
																onblur="return clientValidation('currentPlace', 'dropdownField','currentPlaceErrorDiv');">
																<form:option value="">.:Select:.</form:option>
																<form:option value="Marital"><spring:message code="com.phfi.maritalHome" /></form:option>
																<form:option value="Natal">
																<spring:message code="com.phfi.natalHome" /></form:option>
																<form:option value="other"><spring:message code="com.phfi.anyOther" /></form:option>
															</form:select>
															<div class="discriptionErrorMsg">
																<span id="currentPlaceErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-6 otherPlace otherplace">
															<label class="control-label"><spring:message code="com.phfi.anyOtherSpecify" /></label>
															<form:input cssClass="form-control myclass"
																path="otherCurrentPlace" id="otherCurrentPlace"
																onblur="return clientValidation('otherCurrentPlace', 'alphanumericField','otherCurrentPlaceErrorDiv');" />
															<div class="discriptionErrorMsg">
																<span id="otherCurrentPlaceErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
													</div>
												</fieldset>
												<!--Panel Action Button Start -->
												<div class="col-sm-12 button-content">
													<fieldset class="col-sm-7 pull-right">
														<input type="button"
															class="form-control button pull-right contact-next"
															value="Continue" onclick="return validateContact()"> <input type="button"
															class="form-control button pull-right marginL10 contact-prev"
															value="Previous"> <input type="button"
															class="form-control button pull-right marginL10"
															value="Reset" onclick="return resetContact()"> <input type="button"
															class="form-control button pull-right marginL10"
															value="Cancel">
													</fieldset>
												</div>
												<!--Panel Action Button End -->
											</section>
											<!--Contact Content Ends  -->
											<!-- Pesrsonal Content Start -->
											<section class="field-element-row personal-details-content"
												style="display: none;">
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-12">
														<label><b><spring:message code="com.phfi.personalDetails" /></b></label>
													</fieldset>
													<div class="col-sm-12">
														<fieldset class="col-sm-4 otherPlace">
															<label class="control-label"><spring:message code="com.phfi.age" /><span
																class="required-field">*</span></label>
															<form:input cssClass="form-control" path="age" id="age"
																onblur="validateAge(this)" />
															<div class="discriptionErrorMsg">
																<span id="ageErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-4">
															<label class="control-label" for=""><spring:message code="com.phfi.education" /> <span
																class="required-field">*</span></label>
															<form:select path="education" id="education"
																cssClass="form-control myclass education" 
																onblur="return clientValidagtion('education', 'dropdownField','educationErrorDiv');">
																<form:option value="">.:Select:.</form:option>
																<form:option value="illiterate"><spring:message code="com.phfi.illiterate" /></form:option>
																<form:option value="literate"><spring:message code="com.phfi.literate" /></form:option>
															</form:select>
															<div class="discriptionErrorMsg">
																<span id="educationErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-6 educationOther">
															<label class="control-label"><spring:message code="com.phfi.passed" /><span
																class="required-field">*</span></label>
															<form:input cssClass="form-control myclass" path="educationOther"
																id="educationOther"
																onblur="return clientValidation('educationOther', 'alphanumericField','educationOtherErrorDiv');" />
															<div class="discriptionErrorMsg">
																<span id="educationOtherErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-4">
															<label class="control-label" for=""><spring:message code="com.phfi.religion" /> <span
																class="required-field">*</span></label>
															<form:select path="religion" id="religion"
																cssClass="form-control"
																onblur="return clientValidation('religion', 'dropdownField','religionErrorDiv');">
																<form:option value="">.:Please Select:.</form:option>
																<form:option value="hindu"><spring:message code="com.phfi.hindu" /></form:option>
																<form:option value="muslim"><spring:message code="com.phfi.muslim" /></form:option>
																<form:option value="christian"><spring:message code="com.phfi.christian" /></form:option>
																<form:option value="other"><spring:message code="com.phfi.other" /></form:option>
															</form:select>
															<div class="discriptionErrorMsg">
																<span id="religionErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-4">
															<label class="control-label"><spring:message code="com.phfi.caste" /><span
																class="required-field">*</span></label>
															<form:input cssClass="form-control" path="caste"
																id="caste"
																onblur="return clientValidation('caste', 'alphaField','casteErrordiv');" />
															<div class="discriptionErrorMsg">
																<span id="casteErrordiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-4">
															<label class="control-label" for=""><spring:message code="com.phfi.casteCategory" /> <span class="required-field">*</span>
															</label>
															<form:select path="castcategory" id="castcategory"
																cssClass="form-control"
																onblur="return clientValidation('castcategory', 'dropdownField','castcategoryErrorDiv');">
																<form:option value="">.:Please Select:.</form:option>
																<form:option value="SC"><spring:message code="com.phfi.sc" /></form:option>
																<form:option value="ST"><spring:message code="com.phfi.st" /></form:option>
																<form:option value="OBC"><spring:message code="com.phfi.obc" /></form:option>
																<form:option value="ST"><spring:message code="com.phfi.general" /></form:option>
																<form:option value="other"><spring:message code="com.phfi.other" /></form:option>
															</form:select>
															<div class="discriptionErrorMsg">
																<span id="castcategoryErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
													</div>
												</fieldset>
												<!--Panel Action Button Start -->
												<div class="col-sm-12 button-content">
													<fieldset class="col-sm-7 pull-right">
														<input type="button"
															class="form-control button pull-right personal-next"
															value="Continue" onclick="return validatePersonal()"> <input type="button"
															class="form-control button pull-right marginL10 personal-prev"
															value="Previous"> <input type="button"
															class="form-control button pull-right marginL10"
															value="Reset" onclick="return resetPersonal">
														<input type="button"
															class="form-control button pull-right marginL10"
															value="Cancel" onclick="cancel()">
													</fieldset>
												</div>
												<!--Panel Action Button End -->
											</section>
											<!-- Personal Content End -->
											<!--Past history Content Start -->
											<section
												class="field-element-row pasthistory-details-content"
												style="display: none;">
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.diabetesBeforePregnancy" /><span class="required-field">*</span>
														</label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="diabetes" path="diabetes"
															value="Yes"/><spring:message code="com.phfi.yes" />&nbsp; <form:radiobutton 
															id="diabetes" path="diabetes" value="No" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="diabetes" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.hypertensionBeforePregnancy" /><span class="required-field">*</span>
														</label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="hypertension" path="hypertension"
															value="Yes"/><spring:message code="com.phfi.yes" />&nbsp; <form:radiobutton 
															id="hypertension" path="hypertension" value="No"/>&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="hypertension" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.heartDiseaseBeforePregnancy" /> <span
															class="required-field">*</span>
														</label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="heartdisease" path="heartdisease"
															value="Yes"/><spring:message code="com.phfi.yes" />&nbsp; <form:radiobutton 
															id="heartdisease" path="heartdisease" value="No"/>&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="heartdisease" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<!-- <fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label>Did your doctor tell you that you had <b>jaundice</b>
															before this pregnancy?<span class="required-field">*</span>
														</label>
													</fieldset>
													<fieldset class="col-sm-3">
														<input type="radio" id="jaundice" name="jaundice"
															value="Yes">Yes&nbsp; <input type="radio"
															id="jaundice" name="jaundice" value="No">&nbsp;&nbsp;No
														<div class="discriptionErrorMsg">
															<span id="jaundice" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset> -->
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.anaemiaBeforePregnancy" /><span class="required-field">*</span>
														</label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="anaemia" path="anaemia" value="Yes"/><spring:message code="com.phfi.yes" />&nbsp;
														<form:radiobutton id="anaemia" path="anaemia" value="No"
															onclick="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="anaemia" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.thyroidBeforePregnancy" /><span
															class="required-field">*</span>
														</label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="thyroidproblem"
															path="thyroidproblem" value="Yes"/><spring:message code="com.phfi.yes" />&nbsp; <form:radiobutton
															id="thyroidproblem" path="thyroidproblem"
															value="No" onclick="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="thyroidproblem" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.otherProblemBeforePregnancy" /> <span
															class="required-field">*</span>
														</label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton  id="anyotherproblem" cssClass="yesclick"
															path="anyotherproblem" value="Yes" /><spring:message code="com.phfi.yes" />&nbsp; <form:radiobutton
															id="anyotherproblem" path="anyotherproblem" cssClass="noclick"
															value="No"/>&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="anyotherproblem" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3 problemDesc">
														<spring:message code="com.phfi.specifyProblem" />							<form:input cssClass="form-control" path="problemDesc"
															id="problemDesc" />
														<div class="discriptionErrorMsg">
															<span id="problemDescDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<!--Panel Action Button Start -->
												<div class="col-sm-12 button-content">
													<fieldset class="col-sm-7 pull-right">
														<input type="button"
															class="form-control button pull-right pasthistory-next"
															value="Continue"> <input type="button"
															class="form-control button pull-right marginL10 pasthistory-prev"
															value="Previous"> <input type="button"
															class="form-control button pull-right marginL10"
															value="Reset" > <input type="button"
															class="form-control button pull-right marginL10"
															value="Cancel">
													</fieldset>
												</div>
												<!--Panel Action Button End -->
											</section>
											<!-- Past history Content End -->
											<!-- obstertric Content Start -->
											<section class="field-element-row obstetric-details-content"
												style="display: none;">
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.howManyPregnancies" /><span class="required-field">*</span>
														</label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:input cssClass="form-control-obstric"
															path="pregnancyCount" id="pregnancyCount"
															onblur="regnancyCount();" />
														<div class="discriptionErrorMsg">
															<span id="pregnancyCountErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<fieldset class=" col-sm-12 pregnancyDetails">
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.livingChildren" /><span
															class="required-field">*</span>
														</label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:input cssClass="form-control-obstric"
															path="noOfChildren" id="noOfChildren"
															onblur="livingChilden();" />
														<div class="discriptionErrorMsg">
															<span id="noOfChildrenErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.dateOfLastDelivery" /><span
															class="required-field">*</span>
														</label>
													</fieldset>
													<fieldset class="col-sm-3">
													<div class="input-group registrationdate">
														 <form:input
																cssClass="form-control regDate"
																path="dateOfRecentDelivery" id="dateOfRecentDelivery"
																onblur="return clientValidation('dateOfRecentDelivery', 'required','noOfChildrenErrorDiv');" />
															<span class="input-group-addon"><span
																class="glyphicon glyphicon-calendar"></span></span>
														</div>
														<div class="discriptionErrorMsg">
															<span id="noOfChildrenErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.pregnanciesBefore7Months" /></b><span class="required-field">*</span>
														</label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:input cssClass="form-control-obstric"
															path="earlyDelivery" id="earlyDelivery"
															onblur="validateEarlyDelivery();" />
														<div class="discriptionErrorMsg">
															<span id="earlyDeliveryErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.howManyCaesareanOperations" /></b><span
															class="required-field">*</span>
														</label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:input cssClass="form-control-obstric"
															path="caesarean" id="caesarean"
															onblur="validateCaesarean()" />
														<div class="discriptionErrorMsg">
															<span id="caesareanErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.breathlessnessInPreviousPregnancy" /><span class="required-field">*</span>
														</label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="breathlessness"
															path="breathlessness" value="Yes"/><spring:message code="com.phfi.yes" />&nbsp; <form:radiobutton
															id="breathlessness" path="breathlessness"
															value="No"/>&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="breathlessness" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.severePallorInPreviousPregnancy"
														/><span class="required-field">*</span>
														</label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="severepallor" path="severepallor"
															value="Yes"/><spring:message code="com.phfi.yes" />&nbsp; <form:radiobutton 
															id="severepallor" path="severepallor" value="No"/>&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="severepallor" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.bleedingAfterPreviousDelivery" /><span class="required-field">*</span>
														</label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="bleedexcessively"
															path="bleedexcessively" value="Yes"/><spring:message code="com.phfi.yes" />&nbsp; <form:radiobutton
															id="bleedexcessively"
															path="bleedexcessively" value="No"/>&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="bleedexcessively" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												</fieldset>
												<!--Panel Action Button Start -->
												<div class="col-sm-12 button-content">
													<fieldset class="col-sm-7 pull-right">
														<input type="button"
															class="form-control button pull-right obstetric-next"
															value="Continue" onclick="return validateObstetric()"> <input type="button"
															class="form-control button pull-right marginL10 obstetric-prev"
															value="Previous"> <input type="button"
															class="form-control button pull-right marginL10"
															value="Reset" onclick="return resetObstetric()"> <input type="button"
															class="form-control button pull-right marginL10"
															value="Cancel">
													</fieldset>
												</div>
												<!--Panel Action Button End -->
											</section>
											<!-- <!--obstertric Content End -->
											<!--Other Information Content Start -->
											<section
												class="field-element-row otherinformation-details-content"
												style="display: none;">
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-4">
														<label><spring:message code="com.phfi.lmp" /><span class="required-field">*</span></label>
														<div class="input-group lmpdate">
															<form:input cssClass="form-control lmp" path="lmp"
																id="lmp" onclick="return clientValidation('lmp', 'required','lmpErrorDiv')"/>
															<span class="input-group-addon"><span
																class="glyphicon glyphicon-calendar"></span></span>
														</div>
														<div class="discriptionErrorMsg">
															<span id="lmpErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-4">
														<label><spring:message code="com.phfi.height" /><span class="required-field">*</span>
														</label>
														<form:input cssClass="form-control" path="height"
															id="height"
															onblur="openPopup(this)" />
														<div class="discriptionErrorMsg">
															<span id="heightErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-4">
														<label><spring:message code="com.phfi.bloodGroup" /><span class="required-field">*</span>
														</label>
														<form:select path="bloodgroup" id="bloodgroup"
															onblur="return clientValidation('bloodgroup', 'dropdownField','bloodgroupErrorDiv');"
															cssClass="form-control">
															<form:option value="">.:Please Select:.</form:option>
															<form:option value="A+"><spring:message code="com.phfi.a+" />
															</form:option>
															<form:option value="A-"><spring:message code="com.phfi.a-" />
															</form:option>
															<form:option value="B+"><spring:message code="com.phfi.b+" />
															</form:option>
															<form:option value="B-"><spring:message code="com.phfi.b-" />
															</form:option>
															<form:option value="O+"><spring:message code="com.phfi.o+" />
															</form:option>
															<form:option value="O-"><spring:message code="com.phfi.o-" />
															</form:option>
															<form:option value="AB+"><spring:message code="com.phfi.ab+" />
															</form:option>
															<form:option value="AB-"><spring:message code="com.phfi.ab-" />
															</form:option>
														</form:select>
														<div class="discriptionErrorMsg">
															<span id="bloodgroupErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-12" style="margin-left: 640px;">
													<fieldset class="col-sm-4">
														<label><spring:message code="com.phfi.wid" /><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="uid" id="uid"
															maxlength="50"
															onblur="return clientValidation('uid', 'numericField','uidErrorId')" />
														<div class="discriptionErrorMsg">
															<span id="uidErrorId" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-4">
														<label><spring:message code="com.phfi.villageName" /><span class="required-field">*</span></label>
														<form:input cssClass="form-control myclass" path="villageName"
															id="villageName" maxlength="50"
															onblur="return clientValidation('villageName', 'alphanumericField','villageNameErrorDiv')" />
														<div class="discriptionErrorMsg">
															<span id="villageNameErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-4">
														<label><spring:message code="com.phfi.phc" /><span class="required-field">*</span></label>
														<form:input cssClass="form-control myclass" path="phc" id="phc"
															maxlength="10"
															onblur="return clientValidation('phc', 'alphaField','phcErrorId')" />
														<div class="discriptionErrorMsg">
															<span id="phcErrorId" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-4">
														<label><spring:message code="com.phfi.nameOfAsha" /><span
															class="required-field">*</span></label>
														<form:input cssClass="form-control myclass" path="ashaName"
															id="ashaName" maxlength="13"
															onblur="return clientValidation('ashaName', 'alphaField','ashaNameErrorId')" />
														<div class="discriptionErrorMsg">
															<span id="ashaNameErrorId" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												
													<fieldset class="col-sm-4">
														<label><spring:message code="com.phfi.nameOfAnm" /><span class="required-field">*</span></label>
														<form:input cssClass="form-control myclass" path="anmName"
															id="anmName" maxlength="50"
															onblur="return clientValidation('anmName', 'alphaField','anmNameErrorId')" />
														<div class="discriptionErrorMsg">
															<span id="anmNameErrorId" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													</fieldset>
													<fieldset class="col-sm-12">
													<fieldset class="col-sm-4">
														<label><spring:message code="com.phfi.nameOfAshaFacilitator" /><span
															class="required-field">*</span></label>
														<form:input cssClass="form-control myclass"
															path="ashaFacilitatorName" id="ashaFacilitatorName"
															maxlength="50"
															onblur="return clientValidation('ashaFacilitatorName', 'alphaField','ashaFacilitatorNameErrorId')" />
														<div class="discriptionErrorMsg">
															<span id="ashaFacilitatorNameErrorId" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												</fieldset>
												<!--Panel Action Button Start -->
												<div class="col-sm-12 button-content">
													<fieldset class="col-sm-7 pull-right">
														<input type="button"
															class="form-control button pull-right otherinform-next"
															value="Continue"> <input type="button"
															class="form-control button pull-right marginL10 otherinform-prev"
															value="Previous"> <input type="button"
															class="form-control button pull-right marginL10"
															value="Reset" onclick="return resetOther()"> <input type="button"
															class="form-control button pull-right marginL10"
															value="Cancel">
													</fieldset>
												</div>
												<!--Panel Action Button End -->
											</section>
											<!-- <!--obstertric Content End -->
											<!-- Confirmation Content Start -->
											<section class="field-element-row confirm-details-content"
												style="display: none;">
												
													<fieldset class="col-sm-6">
														<fieldset class="fieldset registration-content">
															<legend class="legend"><spring:message code="com.phfi.preliminiryDetails" /></legend>
															<table class="confirm-info-table">
																<tr>
																	<td><spring:message code="com.phfi.womanFirstName" /></td>
																	<td><div id="confirmWomenFirstName"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.womanHusbandName" /></td>
																	<td><div id="confirmWomenHusbandname"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.womanSurname" /></td>
																	<td><div id="confirmWomenSurname"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.husbandFirstName" /></td>
																	<td><div id="confirmHusbandFirstName"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.husbandFatherName" /></td>
																	<td><div id="confirmFatherName"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.husbandSurname" /></td>
																	<td><div id="confirmHusbandSurname"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.maternityStatus" /></td>
																	<td><div id="confirmMaternityStatus"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.registrationDate" /></td>
																	<td><div id="confirmRegistrationDate"></div></td>
																</tr>
															</table>
														</fieldset>
													</fieldset>
													<fieldset class="col-sm-6">
														<fieldset class="fieldset registration-content">
															<legend class="legend"><spring:message code="com.phfi.contactDetails" /></legend>
															<table class="confirm-info-table">
																<tr>
																	<td><spring:message code="com.phfi.maritalStreet" /></td>
																	<td><div id="confirmStreetMarital"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.maritalLandmark" /></td>
																	<td><div id="confirmLandmarkMarital"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.maritalVillage" /></td>
																	<td><div id="confirmVillageMarital"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.maritalTaluk" /></td>
																	<td><div id="confirmTalukMarital"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.maritalDistrict" /></td>
																	<td><div id="confirmDistrictMarital"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.maritalPhoneNumber1" /></td>
																	<td><div id="confirmPhone1Marital"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.maritalPhoneNumber2" /></td>
																	<td><div id="confirmPhone2Marital"></div></td>
																</tr>
															</table>
															<table class="confirm-info-table">
																<tr>
																	<td><spring:message code="com.phfi.natalStreet" /></td>
																	<td><div id="confirmStreetNatal"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.natalLandmark" /></td>
																	<td><div id="confirmLandmarkNatal"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.natalVillage" /></td>
																	<td><div id="confirmVillageNatal"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.natalTaluk" /></td>
																	<td><div id="confirmTalukNatal"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.natalDistrict" /></td>
																	<td><div id="confirmDistrictNatal"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.natalPhoneNumber1" /></td>
																	<td><div id="confirmPhone1Natal"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.natalPhoneNumber2" /></td>
																	<td><div id="confirmPhone2Natal"></div></td>
																</tr>
															</table>
															<table class="confirm-info-table">
																<tr>
																	<td><spring:message code="com.phfi.whereIsCurrently" /></td>
																	<td><div id="confirmCurrentPlace"></div></td>
																</tr>
															</table>
														</fieldset>
													</fieldset>
													<fieldset class="col-sm-6">
														<fieldset class="fieldset registration-content">
															<legend class="legend"><spring:message code="com.phfi.personalDetails" /></legend>
															<table class="confirm-info-table">
																<tr>
																	<td><spring:message code="com.phfi.age" /></td>
																	<td><div id="confirmAge"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.education" /></td>
																	<td><div id="confirmEducation"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.relegion" /></td>
																	<td><div id="confirmRelegion"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.caste" /></td>
																	<td><div id="confirmCaste"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.casteCategory" /></td>
																	<td><div id="confirmCasteCategory"></div></td>
																</tr>
															</table>
														</fieldset>
													</fieldset>
													<fieldset class="col-sm-6">
														<fieldset class="fieldset registration-content">
															<legend class="legend"><spring:message code="com.phfi.pastHistory" /></legend>
															<table class="confirm-info-table">
																<tr>
																	<td><spring:message code="com.phfi.diabetes" /></td>
																	<td><div id="confirmdiabetes"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.hyperTension" /></td>
																	<td><div id="confirmhypertension"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.heartDisease" /></td>
																	<td><div id="confirmheartdisease"></div></td>
																</tr>
																
																<tr>
																	<td><spring:message code="com.phfi.anaemia" /></td>
																	<td><div id="confirmAnaemia"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.thyroidProblem" /></td>
																	<td><div id="confirmThyroid"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.anyOtherProblem" /></td>
																	<td><div id="confirmAnyOtherProblem"></div></td>
																</tr>
															</table>
														</fieldset>
													</fieldset>
													<fieldset class="col-sm-6">
														<fieldset class="fieldset registration-content">
															<legend class="legend"><spring:message code="com.phfi.obstetricHistory" /></legend>
															<table class="confirm-info-table">
																<tr>
																	<td style="min-width: 300px;"><spring:message code="com.phfi.noOfPregnancy" /></td>
																	<td><div id="confirmPregnancyCount"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 300px;"><spring:message code="com.phfi.noOfChildrens" /></td>
																	<td><div id="confirmNoOfChildrens"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 300px;"><spring:message code="com.phfi.recentDeliveryDate" /></td>
																	<td><div id="confirmdateOfRecentDelivery"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 300px;"><spring:message code="com.phfi.earlyDeliveryCount" /></td>
																	<td><div id="confirmEarlyDelDate"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 300px;"><spring:message code="com.phfi.caesareanOperationsCount" /></td>
																	<td><div id="confirmCaesareancount"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 300px;"><spring:message code="com.phfi.breathlessness" /></td>
																	<td><div id="confirmBreathlessness"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 300px;"><spring:message code="com.phfi.severePallor" /></td>
																	<td><div id="confirmSeverepallor"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 300px;"><spring:message code="com.phfi.bleedExcessivelyAfterPreviousDelivery" /></td>
																	<td><div id="confirmBleedexcessively"></div></td>
																</tr>
															</table>
														</fieldset>
													</fieldset>
													<fieldset class="col-sm-6">
														<fieldset class="fieldset registration-content">
															<legend class="legend"><spring:message code="com.phfi.otherInformation" /></legend>
															<table class="confirm-info-table">
																<tr>
																	<td><spring:message code="com.phfi.lmp" /></td>
																	<td><div id="confirmLmp"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.height1" /></td>
																	<td><div id="confirmHeight"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.bloodGroup" /></td>
																	<td><div id="confirmBloodGroup"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.wid" /></td>
																	<td><div id="confirmUuid"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.villageName" /></td>
																	<td><div id="confirmVillage"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.phc" /></td>
																	<td><div id="confirmPhc"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.nameOfAsha" /></td>
																	<td><div id="confirmAshaName"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.nameOfAnm" /></td>
																	<td><div id="confirmANM"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.nameOfAshaFacilitator" /></td>
																	<td><div id="confirmAshsaFacil"></div></td>
																</tr>
															</table>
														</fieldset>
												</fieldset>
												<!--Panel Action Button Start -->
												<div class="col-sm-12 button-content">
													<fieldset class="col-sm-7 pull-right">
														<input type="submit"
															class="form-control button pull-right confirm-next"
															value="Confirm"> <input type="button"
															class="form-control button pull-right marginL10 confirm-prev"
															value="Previous"> <input type="button"
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
					</div>
					<!-- Content Block End -->
				</div>
			</article>
			<!--Article Block End-->
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
		<!--Container block End -->
	</div>

	<div id="mandatory-popup" class="popup mandatory">
		<p>This is a mandatory field. Please enter a value</p>
		<input type="button" class="form-control button pull-left row yes" value="OK" onclick="storeChoice(this);">
		<input type="button" class="form-control button pull-left row no" value="No, thanks. Proceed Anyway" onclick="storeChoice(this);" style="width: 140px;">
	</div>
	<div id="range-popup" class="popup range">
		<p>The entry is beyond acceptable range. Please verify and re-enter.</p>
		<input type="button" class="form-control button row yes" value="OK" onclick="storeChoice(this);">
	</div>

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
	<!-- <script src="../js_new/hideAndShow.js"></script> -->
	<!--Body Wrapper block End -->
	<script type="text/javascript" src="../js_new/merchant.js"></script>
	<script type="text/javascript" src="../js_new/backbutton.js"></script>
	<script src="../js/jquery.popupoverlay.js"></script>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script>
	$(document).ready(function() {
		$( "#navListId3" ).addClass( "active-background" );
		
		$('#mandatory-popup').popup({
			blur : false
		});
		
		$('#range-popup').popup({
			blur : false
		});
		
		// Replace #height with a class
		$('#height').one('focus', function() {
			$('#mandatory-popup,#range-popup').removeClass('opened')
		});
		
		//$( ".registrationdate" ).datepicker( "option", "maxDate", '+0m +0w' );
	});
	
	

	function openPopup($this) {
		var height = getVal('height').trim();
		var heightInt = parseInt(height);
		var regx = /^[0-9]+$/;
		var flag = false;
		var mandatotyErrMsg = "";
		var rangeErrMsg = "";
		if(isEmpty(height)){
			mandatotyErrMsg = "This field is mandatory";
			setDiv("heightErrorDiv", mandatotyErrMsg);
		} else if(!regx.test(height)){
			rangeErrMsg = "Enter numeric value only";
			setDiv("heightErrorDiv", rangeErrMsg);
		} else if (!(heightInt >= 120 && heightInt <= 180) ){
			rangeErrMsg = "Enter between 120 and 180";
			setDiv("heightErrorDiv", rangeErrMsg);
		} else{
			setDiv("heightErrorDiv", "");
			flag = true;
		}
		
		if(!flag) {
			var errMsg = "";
			if(mandatotyErrMsg.length > 0) {
				if(!$('#mandatory-popup').hasClass('opened')) {
					$('#mandatory-popup').popup("show");
				}
			} else {
				if(!$('#range-popup').hasClass('opened')) {
					$('#range-popup').popup("show");
				}
			}
		}
		return flag;
	}
	
	function storeChoice($this) {
		
		if($($this).closest('div').hasClass('range')) {
			$('#height').focus();
		} 
		
		$('#' + $($this).closest('div').attr('id')).addClass('opened');
		$('#' + $($this).closest('div').attr('id')).popup("hide");
		
	}
	
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
		$(".problemDesc").hide();
		$(".educationOther").hide();
		$(".otherplace").hide();
		$(".pregnancyDetails").hide();
		
		
		$("#pregnancyCount").blur(function(){
			if(this.value >= 2){
				$(".pregnancyDetails").show();
			}else{
				$(".pregnancyDetails").hide();
			}
		});
		
		$("#education").change(function() {
			if(this.value == "literate"){
				$(".educationOther").show();
			}else{
				$("#educationOther").val("");
				$(".educationOther").hide();
			}
		});
		
		$("#currentPlace").change(function() {
			if(this.value == "other"){
				$(".otherplace").show();
			}else{
				$("#otherCurrentPlace").val("");
				$(".otherplace").hide();
			}
		});
		
		$(".yesclick").click(function() {
			
			$(".problemDesc").show();
		});
		$(".noclick").click(function() {
			$("#problemDesc").val("");
			$(".problemDesc").hide();
		});
		
		$(".priliminary-details-content").show();
		$(".preliminary-arrow").show();
		$(".preliminary-circle-tab").addClass("active-circle");
		$(".contact-arrow,.personal-arrow,.pasthistory-arrow,.obstetric-arrow,.confirm-arrow,.otherinformation-arrow").hide();
		/* $(".asha-info-list,.priliminary-prev")
				.click(
						function() {
							
							$(".asha-circle-tab").addClass("active-circle");
							$(
									".preliminary-circle-tab,.contact-circle-tab,.pasthistory-circle-tab,.personal-circle-tab,.obstetric-circle-tab,.otherinformation-circle-tab,.confirm-circle-tab")
									.removeClass("active-circle");
							$(".asha-arrow").show();
							$(
									".preliminary-arrow,.contact-arrow,.personal-arrow,.pasthistory-arrow,.obstetric-arrow,.otherinformation-arrow,.confirm-arrow")
									.hide();
							$(".asha-info-content").show();
							$(
									".priliminary-details-content,.contact-details-content,.confirm-details-content,.personal-details-content,.pasthistory-details-content,.obstetric-details-content,.otherinformation-details-content")
									.hide();
						}); */
		$(".priliminary-info-list,.contact-prev")
				.click(
						function() {
							/*  if (!validateAsha()) {
									return false;
								} */ 
							$(".preliminary-circle-tab").addClass(
									"active-circle");
							$(
									".contact-circle-tab,.pasthistory-circle-tab,.personal-circle-tab,.obstetric-circle-tab,.otherinformation-circle-tab,.confirm-circle-tab")
									.removeClass("active-circle");
							$(".preliminary-arrow").show();
							$(
									".contact-arrow,.personal-arrow,.pasthistory-arrow,.obstetric-arrow,.otherinformation-arrow,.confirm-arrow")
									.hide();
							$(".priliminary-details-content").show();
							$(
									".contact-details-content,.personal-details-content,.confirm-details-content,.pasthistory-details-content,.obstetric-details-content,.otherinformation-details-content")
									.hide();
						});
		$(".contact-info-list,.priliminary-next,.personal-prev")
				.click(
						function() {
							 /* if (!validatePreliminary()) {
									return false;
								}  */
							$(".contact-circle-tab").addClass("active-circle");
							$(
									".preliminary-circle-tab,.pasthistory-circle-tab,.personal-circle-tab,.obstetric-circle-tab,.otherinformation-circle-tab,.confirm-circle-tab")
									.removeClass("active-circle");
							$(".contact-arrow").show();
							$(
									".preliminary-arrow,.personal-arrow,.pasthistory-arrow,.obstetric-arrow,.otherinformation-arrow,.confirm-arrow")
									.hide();
							$(".contact-details-content").show();
							$(
									".priliminary-details-content,.personal-details-content,.confirm-details-content,.pasthistory-details-content,.obstetric-details-content,.otherinformation-details-content")
									.hide();
						});
		$(".personal-info-list,.contact-next,.pasthistory-prev")
				.click(
						function() {
							/*  if (!validatePreliminary()|!validateContact()) {
									return false;
								}  */
							$(".personal-circle-tab").addClass("active-circle");
							$(
									".preliminary-circle-tab,.contact-circle-tab,.pasthistory-circle-tab,.obstetric-circle-tab,.otherinformation-circle-tab,.confirm-circle-tab")
									.removeClass("active-circle");
							$(".personal-arrow").show();
							$(
									".preliminary-arrow,.contact-arrow,.pasthistory-arrow,.obstetric-arrow,.otherinformation-arrow,.confirm-arrow")
									.hide();
							$(".personal-details-content").show();
							$(
									".priliminary-details-content,.contact-details-content,.confirm-details-content,.pasthistory-details-content,.obstetric-details-content,.otherinformation-details-content")
									.hide();
						});
		$(".pasthistory-info-list,.personal-next,.obstetric-prev")
				.click(
						function() {
							/*  if (!validatePreliminary()|!validateContact()|!validatePersonal()) {
									return false;
								}  */
							$(".pasthistory-circle-tab").addClass(
									"active-circle");
							$(
									".preliminary-circle-tab,.contact-circle-tab,.personal-circle-tab,.obstetric-circle-tab,.otherinformation-circle-tab,.confirm-circle-tab")
									.removeClass("active-circle");
							$(".pasthistory-arrow").show();
							$(
									".preliminary-arrow,.contact-arrow,.personal-arrow,.obstetric-arrow,.otherinformation-arrow,.confirm-arrow")
									.hide();
							$(".pasthistory-details-content").show();
							$(
									".priliminary-details-content,.contact-details-content,.confirm-details-content,.personal-details-content,.obstetric-details-content,.otherinformation-details-content")
									.hide();
						});
		$(".obstetric-info-list,.pasthistory-next,.otherinform-prev")
				.click(
						function() {
							/*  if (!validatePreliminary()|!validateContact()|!validatePersonal()) {
									return false;
								}  */
							$(".obstetric-circle-tab")
									.addClass("active-circle");
							$(
									".preliminary-circle-tab,.contact-circle-tab,.personal-circle-tab,.pasthistory-circle-tab,.otherinformation-circle-tab,.confirm-circle-tab")
									.removeClass("active-circle");
							$(".obstetric-arrow").show();
							$(
									".preliminary-arrow,.contact-arrow,.personal-arrow,.pasthistory-arrow,.otherinformation-arrow,.confirm-arrow")
									.hide();
							$(".obstetric-details-content").show();
							$(
									".priliminary-details-content,.contact-details-content,.confirm-details-content,.personal-details-content,.pasthistory-details-content,.otherinformation-details-content")
									.hide();
						});
		$(".otherinformation-info-list,.obstetric-next,.confirm-prev")
				.click(
						function() {
							/* if (!validatePreliminary()|!validateContact()|!validatePersonal()) {
								return false;
							}  */
							$(".otherinformation-circle-tab").addClass(
									"active-circle");
							$(
									".preliminary-circle-tab,.contact-circle-tab,.personal-circle-tab,.pasthistory-circle-tab,.obstetric-circle-tab,.confirm-circle-tab")
									.removeClass("active-circle");
							$(".otherinformation-arrow").show();
							$(
									".preliminary-arrow,.contact-arrow,.personal-arrow,.pasthistory-arrow,.obstetric-arrow,.confirm-arrow")
									.hide();
							$(".otherinformation-details-content").show();
							$(
									".priliminary-details-content,.contact-details-content,.confirm-details-content,.personal-details-content,.pasthistory-details-content,.obstetric-details-content")
									.hide();
						});
		$(".confirm-info-list,.otherinform-next")
				.click(
						function() {
							/* if (!validatePreliminary()|!validateContact()|!validatePersonal()) {
								return false;
							} */ 
							if(!setPastHistory()|!validateObstetric()|!validateOther()){
								return false;
							}
							$(".confirm-circle-tab").addClass("active-circle");
							$(
									".preliminary-circle-tab,.contact-circle-tab,.personal-circle-tab,.pasthistory-circle-tab,.obstetric-circle-tab,.otherinformation-circle-tab")
									.removeClass("active-circle");
							$(".confirm-arrow").show();
							$(
									".preliminary-arrow,.contact-arrow,.personal-arrow,.pasthistory-arrow,.obstetric-arrow,.otherinformation-arrow")
									.hide();
							$(".confirm-details-content").show();
							$(
									".priliminary-details-content,.contact-details-content,.personal-details-content,.pasthistory-details-content,.obstetric-details-content,.otherinformation-details-content")
									.hide();
						});
	</script>
</body>
</html>