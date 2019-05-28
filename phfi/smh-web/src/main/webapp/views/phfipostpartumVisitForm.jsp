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
					<!-- Content Block Start -->
					<div class="main-content-holder padding0">
						<!-- Page Menu Start -->
						<div class="col-sm-12 padding0">
							<div class="sub-nav">
								<ul>
									<li class="women-info-list">
										<div class="circle-div">
											<div class="hr"></div>
											<span class="womenInfo-circle-tab active-circle"></span>
										</div> <label><spring:message code="com.phfi.womanInfo" /></label>
										<div class="arrow-down womenInfo-arrow"></div>
									</li>
									<li class="askTheWomen-info-list">
										<div class="circle-div">
											<div class="hr"></div>
											<span class="askTheWomen-circle-tab"></span>
										</div> <label><spring:message code="com.phfi.askTheWoman" /> </label>
										<div class="arrow-down askTheWomen-arrow"></div>
									</li>
									<li class="askTheWomenRest-info-list">
										<div class="circle-div">
											<div class="hr"></div>
											<span class="askTheWomenRest-circle-tab"></span>
										</div> <label><spring:message code="com.phfi.askTheWoman" /></label>
										<div class="arrow-down askTheWomenRest-arrow"></div>
									</li>
									<li class="observe-info-list">
										<div class="circle-div">
											<div class="hr"></div>
											<span class="observe-circle-tab"></span>
										</div> <label><spring:message code="com.phfi.observe" /></label>
										<div class="arrow-down observe-arrow"></div>
									</li>
									<li class="testResultFirst-info-list">
										<div class="circle-div">
											<div class="hr"></div>
											<span class="testResultFirst-circle-tab"></span>
										</div> <label><spring:message code="com.phfi.testResults1" /></label>
										<div class="arrow-down testResultFirst-arrow"></div>
									</li>
									<li class="testResultSec-info-list">
										<div class="circle-div">
											<div class="hr"></div>
											<span class="testResultSec-circle-tab"></span>
										</div> <label><spring:message code="com.phfi.testResults2" /></label>
										<div class="arrow-down testResultSec-arrow"></div>
									</li>
									<li class="askTheFamily-info-list">
										<div class="circle-div">
											<div class="hr"></div>
											<span class="askTheFamily-circle-tab"></span>
										</div> <label><spring:message code="com.phfi.askTheFamily" /></label>
										<div class="arrow-down askTheFamily-arrow"></div>
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
											class="green-error">&nbsp;${sucess }</span>
									</div>
								</div>
								<!--Success and Failure Message End-->
								<!-- Page Form Start -->
								<form:form action="process-postpartum-visit-form" commandName="phfiPostPartumVisitRequest"	name="phfiPostPartumVisitRequest">
									<div class="col-sm-12 paddingT20">
										<div class="row">
											<!-- Women Details Content Start -->
											<section class="field-element-row women-info-content"
												style="display: none;">
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-4">
														<label><spring:message code="com.phfi.visitDate" /><span
															class="required-field">*</span></label>
														<div class="input-group registrationdate">
															<form:input cssClass="form-control regDate"
																path="visitDate" id="visitDate"
																onblur="return clientValidation('visitDate', 'required','visitDateErrorDiv')" />
															<span class="input-group-addon"><span
																class="glyphicon glyphicon-calendar"></span></span>
														</div>
														<div class="discriptionErrorMsg">
															<span id="visitDateErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-4" style="margin-left: 330px;">
														<label><spring:message code="com.phfi.wid" /><span class="required-field">*</span></label>
														<form:select cssClass="form-control" path="wid"
															id="wid" 
															onblur="return clientValidation('wid', 'alpha','widErrorDiv')" >
															<form:option value="">--Select--</form:option>
															 <c:forEach items="${allWidList}" var="allWid">
																 <form:option value="${allWid}">${allWid}</form:option>
															      </c:forEach>
															</form:select>
														<div class="discriptionErrorMsg">
															<span id="uidErrorId" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												
												<fieldset class="col-sm-12" >
												<fieldset class="col-sm-4" >
														<label><spring:message code="com.phfi.nameOfTheWoman" /><span class="required-field">*</span></label>
														<form:select cssClass="form-control" path="womanName"
															id="womanName" 
															onblur="return clientValidation('womanName', 'alpha','nameErrorDiv')" >
															<form:option value="">--Select--</form:option>
															 <c:forEach items="${allWomenNameList}" var="allWomenName">
																    <form:option value="${allWomenName}">${allWomenName}</form:option>
															        </c:forEach>
															</form:select>
														<div class="discriptionErrorMsg">
															<span id="womanNameErrorId" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													
												</fieldset>
												
												<!--Panel Action Button Start -->
												<div class="col-sm-12 button-content">
													<fieldset class="col-sm-7 pull-right">
														<input type="button" class="form-control button pull-right women-next"
															value="Continue" > <input type="button"
															class="form-control button pull-right marginL10"
															value="Reset" onclick="return resetAsha()"> <input
															type="button"
															class="form-control button pull-right marginL10"
															value="Cancel" onclick="cancel()">
													</fieldset>
												</div>
												<!--Panel Action Button End -->
											</section>
											<!-- Women Details Content End -->
											<!-- Ask woman Details Content Start -->
											<section class="field-element-row askthewomefirst-content" style="display: none;">
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.haveFever" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<input type="radio" id="haveFever" name="haveFever"
															value="Yes" onclick="showFever()"><spring:message code="com.phfi.yes" />&nbsp; <input type="radio"
															id="haveFever" name="haveFever" value="No"  onclick="hideFever()" onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="haveFeverErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12" id="feverId">
													<fieldset class="col-sm-12">
														<fieldset class="col-sm-6">
															<label><spring:message code="com.phfi.feverAssociatedWithChillsAndShivering" /><span class="required-field">*</span>
															</label>
														</fieldset>
														<fieldset class="col-sm-3">
															<input type="radio" id="isFeverAssocated"
																name="isFeverAssocated" value="Yes"><spring:message code="com.phfi.yes" />&nbsp; <input
																type="radio" id="isFeverAssocated"
																name="isFeverAssocated" value="No"
																onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.no" />
															<div class="discriptionErrorMsg">
																<span id="isFeverAssocatedErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
													</fieldset>
													<fieldset class="col-sm-12">
														<fieldset class="col-sm-6">
															<label><spring:message code="com.phfi.feverComeAndGo" /><span
																class="required-field">*</span></label>
														</fieldset>
														<fieldset class="col-sm-3">
															<input type="radio" id="isFeverComeAndGo"
																name="isFeverComeAndGo" value="Yes"><spring:message code="com.phfi.yes" />&nbsp; <input
																type="radio" id="isFeverComeAndGo"
																name="isFeverComeAndGo" value="0"
																onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.no" />
															<div class="discriptionErrorMsg">
																<span id="isFeverComeAndGoErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.hadFits" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<input type="radio" id="isFits" name="isFits"
															value="Yes"><spring:message code="com.phfi.yes" />&nbsp; <input type="radio"
															id="isFits" name="isFits" value="No" onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="isFitsErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.lostConsciousness" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<input type="radio" id="isConsciousness" name="isConsciousness"
															value="Yes"><spring:message code="com.phfi.yes" />&nbsp; <input type="radio"
															id="isConsciousness" name="isConsciousness" value="0" onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="isConsciousnessErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.severeHeadaches" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<input type="radio" id="haveHeadaches" name="haveHeadaches"
															value="1"><spring:message code="com.phfi.yes" />&nbsp; <input type="radio"
															id="haveHeadaches" name="haveHeadaches" value="0" onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="haveHeadachesErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset> 
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.haveBlurredVision" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<input type="radio" id="haveBlurredVision" name="haveBlurredVision"
															value="Yes" onclick="showHavePain()"><spring:message code="com.phfi.yes" />&nbsp; <input type="radio"
															id="haveBlurredVision" name="haveBlurredVision" value="0" onclick="hideHavePain()" onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="haveBlurredVisionErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.haveDifficultyInFeedingTheBaby" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<input type="radio" id="isDifficultToFeed" name="isDifficultToFeed"
															value="Yes" onclick="showHavePain()"><spring:message code="com.phfi.yes" />&nbsp; <input type="radio"
															id="isDifficultToFeed" name="isDifficultToFeed" value="No"  onclick="hideHavePain()" onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="isDifficultToFeedErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12" id="havePainId">
													<fieldset class="col-sm-12">
														<fieldset class="col-sm-6">
															<label><spring:message code="com.phfi.havePainAndRednessInBreast" /> <span class="required-field">*</span>
															</label>
														</fieldset>
														<fieldset class="col-sm-3">
															<input type="radio" id="painInBreast"
																name="painInBreast" value="Yes"><spring:message code="com.phfi.yes" />&nbsp; <input
																type="radio" id="painInBreast"
																name="painInBreast" value="No"
																onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.no" />
															<div class="discriptionErrorMsg">
																<span id="painInBreastErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
													</fieldset>
													<fieldset class="col-sm-12">
														<fieldset class="col-sm-6">
															<label><spring:message code="com.phfi.anyPainfulLumpInBreast" /><span
																class="required-field">*</span></label>
														</fieldset>
														<fieldset class="col-sm-3">
															<input type="radio" id="lumpInBreast"
																name="lumpInBreast" value="Yes"><spring:message code="com.phfi.yes" />&nbsp; <input
																type="radio" id="lumpInBreast"
																name="lumpInBreast" value="0"
																onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.no" />
															<div class="discriptionErrorMsg">
																<span id="lumpInBreastErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.feelBreathless" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<input type="radio" id="isBreathless" name="isBreathless"
															value="1" onclick="showBreathless()"><spring:message code="com.phfi.yes" />&nbsp; <input type="radio"
															id="isBreathless" name="isBreathless" value="0" onblur="validateRadio()" onclick="hideBreathless()">&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="isBreathlessErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset> 
												<fieldset class="col-sm-12" id="breathlessId">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.whenFeelBreathless" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-6">
														<input type="checkbox" id="whenBreathless" name="whenBreathless"
															value="while sitting or lying down"><spring:message code="com.phfi.whileSittingOrLyingDown" />&nbsp;<input type="checkbox" id="whenBreathless" name="whenBreathless"
															value="cooking or cleaning"><spring:message code="com.phfi.cookingOrCleaning" />&nbsp; <input type="checkbox"
															id="whenBreathless" name="whenBreathless" value="carrying load" onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.carryingLoad" />
														<div class="discriptionErrorMsg">
															<span id="whenBreathlessErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>   
												<!--Panel Action Button Start -->
												<div class="col-sm-12 button-content">
													<fieldset class="col-sm-7 pull-right">
														<input type="button"
															class="form-control button pull-right askTheWomen-next"
															value="Continue" > <input type="button"
															class="form-control button pull-right marginL10 askTheWomen-prev"
															value="Previous"> <input type="button"
															class="form-control button pull-right marginL10"
															value="Reset" onclick="return priliminaryReset()"> <input
															type="button"
															class="form-control button pull-right marginL10"
															value="Cancel" onclick="cancel()">
													</fieldset>
												</div>
												<!--Panel Action Button End -->
											</section>
											<!-- Ask the women first Content End -->
											<!-- Ask the women second Content Start -->
											<section class="field-element-row askthewomesec-content" style="display: none;">
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.haveCough" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<input type="radio" id="haveCough" name="haveCough"
															value="1" onclick="showCough()"><spring:message code="com.phfi.yes" />&nbsp; <input type="radio"
															id="haveCough" name="haveCough" value="0" onclick="hideCough()" onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="haveCoughErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset> 
												
												<fieldset class="col-sm-12" id="coughId">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.howLongHadCough" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-6">
														<input type="radio" id="howLongHaveCough" name="howLongHaveCough"
															value="1"><spring:message code="com.phfi.lessThanThreeWeeks" />&nbsp; <input type="radio"
															id="howLongHaveCough" name="howLongHaveCough" value="0" onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.moreThanThreeWeeks" />				<div class="discriptionErrorMsg">
															<span id="diabetes" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset> 
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.haveAbdominalPain" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<input type="radio" id="isAbdominalPain" name="isAbdominalPain"
															value="1" onclick="showAbnormalPain()"><spring:message code="com.phfi.yes" />&nbsp; <input type="radio"
															id="isAbdominalPain" name="isAbdominalPain" value="0" onclick="hideAbnormalPain()" onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="isAbdominalPainErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset> 
												
												<fieldset class="col-sm-12" id="abnormalPain">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.whereItPain" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-6">
														<input type="radio" id="wherePain" name="wherePain"
															value="1"><spring:message code="com.phfi.upperAbdomen" />&nbsp;
															<input type="radio" id="wherePain" name="wherePain"
															value="1"><spring:message code="com.phfi.lowerAbdomen" />&nbsp;
															 <input type="radio"
															id="wherePain" name="wherePain" value="0" onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.allOver" />
														<div class="discriptionErrorMsg">
															<span id="wherePainError" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset> 
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.vaginalDischargeSmellsUnpleasant" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<input type="radio" id="isVaginalDischarge" name="isVaginalDischarge"
															value="1"><spring:message code="com.phfi.yes" />&nbsp; <input type="radio"
															id="isVaginalDischarge" name="isVaginalDischarge" value="0" onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="isVaginalDischargeErroDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset> 
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.bleedingNow" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<input type="radio" id="isBleeding" name="isBleeding"
															value="1" onclick="showBleeding()"><spring:message code="com.phfi.yes" />&nbsp; <input type="radio"
															id="isBleeding" name="isBleeding" value="0" onclick="hideBleeding()" onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="isBleedingErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>  
												<fieldset class="col-sm-12" id="bleedingId">
													<fieldset class="col-sm-12">
														<fieldset class="col-sm-6">
															<label><spring:message code="com.phfi.bleedingAfterDelivery" /><span class="required-field">*</span>
															</label>
														</fieldset>
														<fieldset class="col-sm-3">
															<form:input cssClass="form-control" path="noDayAfterDel"
																id="noDayAfterDel"
																onblur="return clientValidation('noDayAfterDel', 'alphaField','noDayAfterDelErrorDiv');" />
															<div class="discriptionErrorMsg">
																<span id="noDayAfterDelErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
													</fieldset>
													<fieldset class="col-sm-12">
														<fieldset class="col-sm-6">
															<label><spring:message code="com.phfi.clotsWhileBleeding" /><span class="required-field">*</span>
															</label>
														</fieldset>
														<fieldset class="col-sm-3">
															<input type="radio" id="isPassClotBleeding" name="isPassClotBleeding"
															value="Yes"><spring:message code="com.phfi.yes" />&nbsp; <input type="radio"
															id="isPassClotBleeding" name="isPassClotBleeding" value="No" onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="isPassClotBleedingErroDiv" class="red-error">&nbsp;</span>
														</div>
														</fieldset>
													</fieldset>
													<fieldset class="col-sm-12">
														<fieldset class="col-sm-6">
															<label><spring:message code="com.phfi.clothesChangeInDay" /><span class="required-field">*</span>
															</label>
														</fieldset>
														<fieldset class="col-sm-3">
															<form:input cssClass="form-control" path="noOfClothes"
																id="noOfClothes"
																onblur="return clientValidation('noOfClothes', 'numericField','noOfClothesErrorDiv');" />
															<div class="discriptionErrorMsg">
																<span id="noOfClothesErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
													</fieldset>
													<fieldset class="col-sm-12">
														<fieldset class="col-sm-6">
															<label><spring:message code="com.phfi.bleedingIncreased" /><span class="required-field">*</span>
															</label>
														</fieldset>
														<fieldset class="col-sm-3">
															<form:input cssClass="form-control" path="hasBleedingIncrease"
																id="hasBleedingIncrease"
																onblur="return clientValidation('noDayAfterDel', 'numericField','hasBleedingIncreaseErrorDiv');" />
															<div class="discriptionErrorMsg">
																<span id="hasBleedingIncreaseErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
													</fieldset>

												</fieldset>
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.haveBurningOrPainWhileUrinating" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<input type="radio" id="isBurningPain" name="isBurningPain"
															value="Yes"><spring:message code="com.phfi.yes" />&nbsp; <input type="radio"
															id="isBurningPain" name="isBurningPain" value="No" onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="isBurningPainErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset> 
												<!--Panel Action Button Start -->
												<div class="col-sm-12 button-content">
													<fieldset class="col-sm-7 pull-right">
														<input type="button"
															class="form-control button pull-right askTheWomenSec-next"
															value="Continue" onclick="return validateContact()"> <input type="button"
															class="form-control button pull-right marginL10 askTheWomenSec-prev"
															value="Previous"> <input type="button"
															class="form-control button pull-right marginL10"
															value="Reset" onclick="return resetContact()"> <input type="button"
															class="form-control button pull-right marginL10"
															value="Cancel">
													</fieldset>
												</div>
												<!--Panel Action Button End -->
											</section>
											<!--ask the women second Ends  -->
											<!-- observe Content Start -->
											<section class="field-element-row observe-details-content" style="display: none;">
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.doesLookOutOfBreath" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<input type="radio" id="outOfBreath" name="outOfBreath"
															value="1"><spring:message code="com.phfi.yes" />&nbsp; <input type="radio"
															id="outOfBreath" name="outOfBreath" value="0" onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="outOfBreathErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset> 
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.talkingIrrelevantly" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<input type="radio" id="isTalking" name="isTalking"
															value="Yes"><spring:message code="com.phfi.yes" />&nbsp; <input type="radio"
															id="isTalking" name="isTalking" value="No" onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="isTalkingErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset> 
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.lookAtHerEyes" /></label>
													</fieldset>
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.raiseUpperEyelidAskLookDown" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<input type="radio" id="upperEyeColor" name="upperEyeColor"
															value="Yes"><spring:message code="com.phfi.white" />&nbsp; <input type="radio"
															id="upperEyeColor" name="upperEyeColor" value="No" onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.yellow" />
														<div class="discriptionErrorMsg">
															<span id="UpperEyeColorErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.pullLowerEyelidLookInsideLowerEyelid" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<input type="radio" id="lowerEyeColor" name="lowerEyeColor"
															value="Yes"><spring:message code="com.phfi.pink" />&nbsp; <input type="radio"
															id="lowerEyeColor" name="lowerEyeColor" value="No" onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.pale" />
														<div class="discriptionErrorMsg">
															<span id="LowerEyeColorErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												</fieldset> 
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.findDepressionUponPressingShinboneNearAnkle" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<input type="radio" id="isAnkleDepression" name="isAnkleDepression"
															value="Yes"><spring:message code="com.phfi.yes" />&nbsp; <input type="radio"
															id="isAnkleDepression" name="isAnkleDepression" value="No" onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="isAnkleDepressionErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset> 
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.seeFullnessOfFaceOrSwellingAroundEyes" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<input type="radio" id="isEyeSwelling" name="isEyeSwelling"
															value="Yes"><spring:message code="com.phfi.yes" />&nbsp; <input type="radio"
															id="isEyeSwelling" name="isEyeSwelling" value="No" onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="isEyeSwellingErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset> 
												<!--Panel Action Button Start -->
												<div class="col-sm-12 button-content">
													<fieldset class="col-sm-7 pull-right">
														<input type="button"
															class="form-control button pull-right observe-next"
															value="Continue" > <input type="button"
															class="form-control button pull-right marginL10 observe-prev"
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
											<!-- observe Content End -->
											<!--Test Results part 1 Content Start -->
											<section class="field-element-row testresultfirst-details-content" style="display: none;">
												<fieldset class="col-sm-12" >
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.bp" /><span class="required-field">*</span>
														</label>
													</fieldset>
													<fieldset class="col-sm-3">
														<input type="radio" id="bp" name="bp"
															value="Yes" onclick="showBp()"><spring:message code="com.phfi.done" />&nbsp; <input type="radio"
															id="bp" name="bp" value="No" onclick="hideBp()" onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.notDone" />
														<div class="discriptionErrorMsg">
															<span id="bpErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12" id="bpId">
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.aBP" /><span class="required-field">*</span></label>
															<form:input cssClass="form-control" path="firstBp"
																id="firstBp" maxlength="50"
																onblur="bpValidation('firstBp','firstBpErrorDiv')" />
															<div class="discriptionErrorMsg">
																<span id="firstBpErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.date" /><span class="required-field">*</span></label>
															<div class="input-group registrationdate">
																<form:input cssClass="form-control regDate"
																	path="bpDateOne" id="bpDateOne"
																	onblur="return clientValidation('bpDateOne', 'required','bpDateOneErrorDiv')" />
																<span class="input-group-addon"><span
																	class="glyphicon glyphicon-calendar"></span></span>
															</div>
															<div class="discriptionErrorMsg">
																<span id="bpDateOneErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.bBP" /><span class="required-field">*</span></label>
															<form:input cssClass="form-control" path="secBp"
																id="secBp" maxlength="50"
																onblur="bpValidation('secBp','secBpErrorDiv')" />
															<div class="discriptionErrorMsg">
																<span id="secBpErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.date" /><span class="required-field">*</span></label>
															<div class="input-group registrationdate">
																<form:input cssClass="form-control regDate"
																	path="bpDateSec" id="bpDateSec"
																	onblur="return clientValidation('bpDateSec', 'required','bpDateSecErrorDiv')" />
																<span class="input-group-addon"><span
																	class="glyphicon glyphicon-calendar"></span></span>
															</div>
															<div class="discriptionErrorMsg">
																<span id="bpDateSecErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
												</fieldset>
												
												<fieldset class="col-sm-12" >
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.hb" /><span class="required-field">*</span>
														</label>
													</fieldset>
													<fieldset class="col-sm-3">
														<input type="radio" id="hb" name="hb"
															value="Yes" onclick="showHb()"><spring:message code="com.phfi.done" />&nbsp; <input type="radio"
															id="hb" name="hb" value="No" onclick="hideHb()" onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.notDone" />
														<div class="discriptionErrorMsg">
															<span id="hbErrorId" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12" id="hbId">
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.aHB" /><span class="required-field">*</span></label>
															<form:input cssClass="form-control" path="firstHb"
																id="firstHb" maxlength="50"
																onblur="hbValidation('firstHb','firstHbErrorDiv')" />
															<div class="discriptionErrorMsg">
																<span id="firstHbErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.date" /><span class="required-field">*</span></label>
															<div class="input-group registrationdate">
																<form:input cssClass="form-control regDate"
																	path="hbDateOne" id="hbDateOne"
																	onblur="return clientValidation('hbDateOne', 'required','hbDateOneErrorDiv')" />
																<span class="input-group-addon"><span
																	class="glyphicon glyphicon-calendar"></span></span>
															</div>
															<div class="discriptionErrorMsg">
																<span id="hbDateOneErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.bHB" /><span class="required-field">*</span></label>
															<form:input cssClass="form-control" path="secHb"
																id="secHb" maxlength="50"
																onblur="hbValidation('secHb','secHbErrorDiv')" />
															<div class="discriptionErrorMsg">
																<span id="secHbErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.date" /><span class="required-field">*</span></label>
															<div class="input-group registrationdate">
																<form:input cssClass="form-control regDate"
																	path="hbDateSec" id="hbDateSec"
																	onblur="return clientValidation('regDate', 'required','hbDateSecErrorDiv')" />
																<span class="input-group-addon"><span
																	class="glyphicon glyphicon-calendar"></span></span>
															</div>
															<div class="discriptionErrorMsg">
																<span id="hbDateSecErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
												</fieldset>
												
												<fieldset class="col-sm-12" >
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.urineAlbumin" /><span class="required-field">*</span>
														</label>
													</fieldset>
													<fieldset class="col-sm-3">
														<input type="radio" id="urine" name="urine"
															value="Yes" onclick="showUrine()"><spring:message code="com.phfi.done" />&nbsp; <input type="radio"
															id="urine" name="urine" value="No" onclick="hideUrine()" onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.notDone" />
														<div class="discriptionErrorMsg">
															<span id="urineErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12" id="urineId">
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.aUrineAlbumin" /><span class="required-field">*</span></label>
															<form:select path="firstUrine" id="firstUrine"
															onblur="return clientValidation('firstUrine', 'dropdownField','firstUrineErrorDiv');"
															cssClass="form-control">
															<form:option value="">.:Please Select:.</form:option>
															<form:option value="Nil"><spring:message code="com.phfi.nil" /></form:option>
															<form:option value="Traces"><spring:message code="com.phfi.traces" /></form:option>
															<form:option value="1+"><spring:message code="com.phfi.1+" /></form:option>
															<form:option value="2+"><spring:message code="com.phfi.2+" /></form:option>
															<form:option value="3+"><spring:message code="com.phfi.3+" /></form:option>
														</form:select>
															<div class="discriptionErrorMsg">
																<span id="firstUrineErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.date" /><span class="required-field">*</span></label>
															<div class="input-group registrationdate">
																<form:input cssClass="form-control regDate"
																	path="urineDateOne" id="urineDateOne"
																	onblur="return clientValidation('urineDateOne', 'required','urineDateOneErrorDiv')" />
																<span class="input-group-addon"><span
																	class="glyphicon glyphicon-calendar"></span></span>
															</div>
															<div class="discriptionErrorMsg">
																<span id="urineDateOneErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.bUrineAlbumin" /><span class="required-field">*</span></label>
															<form:select path="secUrine" id="secUrine"
															onblur="return clientValidation('secUrine', 'dropdownField','secUrineErrorDiv');"
															cssClass="form-control">
															<form:option value="">.:Please Select:.</form:option>
															<form:option value="Nil"><spring:message code="com.phfi.nil" /></form:option>
															<form:option value="Traces"><spring:message code="com.phfi.traces" /></form:option>
															<form:option value="1+"><spring:message code="com.phfi.1+" /></form:option>
															<form:option value="2+"><spring:message code="com.phfi.2+" /></form:option>
															<form:option value="3+"><spring:message code="com.phfi.3+" /></form:option>
														</form:select>
															<div class="discriptionErrorMsg">
																<span id="secUrineErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.date" /><span class="required-field">*</span></label>
															<div class="input-group registrationdate">
																<form:input cssClass="form-control regDate"
																	path="urineDateSec" id="urineDateSec"
																	onblur="return clientValidation('urineDateSec', 'required','urineDateSecErrorDiv')" />
																<span class="input-group-addon"><span
																	class="glyphicon glyphicon-calendar"></span></span>
															</div>
															<div class="discriptionErrorMsg">
																<span id="urineDateSecErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
													</fieldset>
												
												<!--Panel Action Button Start -->
												<div class="col-sm-12 button-content">
													<fieldset class="col-sm-7 pull-right">
														<input type="button"
															class="form-control button pull-right testresultfirst-next"
															value="Continue"> <input type="button"
															class="form-control button pull-right marginL10 testresultfirst-prev"
															value="Previous"> <input type="button"
															class="form-control button pull-right marginL10"
															value="Reset" > <input type="button"
															class="form-control button pull-right marginL10"
															value="Cancel">
													</fieldset>
												</div>
												<!--Panel Action Button End -->
											</section>
											<!-- Test Result 1 Content End -->
											<!-- Test Result 2 Content Start -->
											<section class="field-element-row testresultsec-details-content" style="display: none;">
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.testForMalaria" /><span class="required-field">*</span>
														</label>
													</fieldset>
													<fieldset class="col-sm-3">
														<input type="radio" id="malaria" name="malaria"
															value="Yes" onclick="showMalaria()"><spring:message code="com.phfi.done" />&nbsp; <input type="radio"
															id="malaria" name="malaria" value="No" onclick="hideMalaria()" onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.notDone" />
														<div class="discriptionErrorMsg">
															<span id="malariaErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12" id="malariaId">
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.aTestForMalaria" /><span class="required-field">*</span></label>
															<form:input cssClass="form-control" path="firstMalaria"
																id="firstMalaria" maxlength="50"
																onblur="return clientValidation('firstMalaria', 'numericField','firstMalariaErrorId')" />
															<div class="discriptionErrorMsg">
																<span id="firstMalariaErrorId" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.date" /><span class="required-field">*</span></label>
															<div class="input-group registrationdate">
																<form:input cssClass="form-control regDate"
																	path="malariaDateOne" id="malariaDateOne"
																	onblur="return clientValidation('malariaDateOne', 'required','malariaDateOneErrorDiv')" />
																<span class="input-group-addon"><span
																	class="glyphicon glyphicon-calendar"></span></span>
															</div>
															<div class="discriptionErrorMsg">
																<span id="malariaDateOneErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.bTestForMalaria" /><span class="required-field">*</span></label>
															<form:input cssClass="form-control" path="secMalaria"
																id="secMalaria" maxlength="50"
																onblur="return clientValidation('secMalaria', 'numericField','secMalariaErrorDiv')" />
															<div class="discriptionErrorMsg">
																<span id="secMalariaErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.date" /><span class="required-field">*</span></label>
															<div class="input-group registrationdate">
																<form:input cssClass="form-control regDate"
																	path="malariaDateSec" id="malariaDateSec"
																	onblur="return clientValidation('malariaDateSec', 'required','malariaDateSecErrorDiv')" />
																<span class="input-group-addon"><span
																	class="glyphicon glyphicon-calendar"></span></span>
															</div>
															<div class="discriptionErrorMsg">
																<span id="malariaDateSecErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
												</fieldset>
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.sputumTest" /><span class="required-field">*</span>
														</label>
													</fieldset>
													<fieldset class="col-sm-3">
														<input type="radio" id="sputum" name="sputum"
															value="Yes" onclick="showSputum()"><spring:message code="com.phfi.done" />&nbsp; <input type="radio"
															id="sputum" name="sputum" value="No" onclick="hideSputum()" onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.notDone" />
														<div class="discriptionErrorMsg">
															<span id="sputumErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12" id="sputumId">
													<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.testResult" /><span class="required-field">*</span></label>
															<form:select path="sputumTest" id="sputumTest"
															onblur="return clientValidation('sputumTest', 'dropdownField','sputumTestErrorDiv');"
															cssClass="form-control">
															<form:option value="">.:Please Select:.</form:option>
															<form:option value="+ve"><spring:message code="com.phfi.+ve" /></form:option>
															<form:option value="-ve"><spring:message code="com.phfi.-ve" /></form:option>
														</form:select>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.date" /><span class="required-field">*</span></label>
															<div class="input-group registrationdate">
																<form:input cssClass="form-control regDate"
																	path="sputumDate" id="sputumDate"
																	onblur="return clientValidation('sputumDate', 'required','sputumDateErrorDiv')" />
																<span class="input-group-addon"><span
																	class="glyphicon glyphicon-calendar"></span></span>
															</div>
															<div class="discriptionErrorMsg">
																<span id="sputumDateErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
												</fieldset>
												<!--Panel Action Button Start -->
												<div class="col-sm-12 button-content">
													<fieldset class="col-sm-7 pull-right">
														<input type="button"
															class="form-control button pull-right testresultsec-next"
															value="Continue" onclick="return validateObstetric()"> <input type="button"
															class="form-control button pull-right marginL10 testresultsec-prev"
															value="Previous"> <input type="button"
															class="form-control button pull-right marginL10"
															value="Reset" onclick="return resetObstetric()"> <input type="button"
															class="form-control button pull-right marginL10"
															value="Cancel">
													</fieldset>
												</div>
												<!--Panel Action Button End -->
											</section>
											<!-- <!--test result 2 Content End -->
											<!--Ask the family Content Start -->
											<section class="field-element-row askthefamily-content" style="display: none;">
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.talkingIllogicalAndDisconnectedManner" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<input type="radio" id="talkingIrrelevantly" name="talkingIrrelevantly"
															value="1"><spring:message code="com.phfi.yes" />&nbsp; <input type="radio"
															id="talkingIrrelevantly" name="talkingIrrelevantly" value="0" onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="talkingIrrelevantlyErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset> 
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.interestedCaringForTheBabyAndHerself" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<input type="radio" id="carringBabyAndHerself" name="carringBabyAndHerself"
															value="Yes"><spring:message code="com.phfi.yes" />&nbsp; <input type="radio"
															id="carringBabyAndHerself" name="carringBabyAndHerself" value="No" onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="carringBabyAndHerselfErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset> 
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.hearingImaginaryVoicesOrSeeingImaginaryPeople" /> <span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<input type="radio" id="isHearingImaginary" name="isHearingImaginary"
															value="1"><spring:message code="com.phfi.yes" />&nbsp; <input type="radio"
															id="isHearingImaginary" name="isHearingImaginary" value="0" onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="isHearingImaginaryErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset> 
												<!--Panel Action Button Start -->
												<div class="col-sm-12 button-content">
													<fieldset class="col-sm-7 pull-right">
														<input type="button"
															class="form-control button pull-right askthefamily-next"
															value="Continue"> <input type="button"
															class="form-control button pull-right marginL10 askthefamily-prev"
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
												<fieldset class="col-sm-12" style="padding: 0;">
													<fieldset class="col-sm-6">
														<fieldset class="fieldset registration-content">
															<legend class="legend"><spring:message code="com.phfi.ashaInfo" /></legend>
															<table class="confirm-info-table">
																<tr>
																	<td><spring:message code="com.phfi.visitDate" /></td>
																	<td><div id="confirmVigitDate"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.wid" /></td>
																	<td><div id="confirmWid"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.nameOfWoman" /></td>
																	<td><div id="confirmWomanName"></div></td>
																</tr>
															</table>
														</fieldset>
													</fieldset>
													<fieldset class="col-sm-6">
														<fieldset class="fieldset registration-content">
															<legend class="legend"><spring:message code="com.phfi.askTheFamily" /></legend>
															<table class="confirm-info-table">
																<tr>
																	<td style="min-width: 350px"><spring:message code="com.phfi.talkingIllogicalAndDisconnectedManner" /></td>
																	<td><div id="confirmTalkingAndDisconnected"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 350px"><spring:message code="com.phfi.interestedCaringForTheBabyAndHerself" /></td>
																	<td><div id="confirmCaringBaby"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 350px"><spring:message code="com.phfi.hearingImaginaryVoicesOrSeeingImaginaryPeople" /></td>
																	<td><div id="confirmImaginaryVoiceAndPeople"></div></td>
																</tr>
																</table>
														</fieldset>
													</fieldset>
													<fieldset class="col-sm-6">
														<fieldset class="fieldset registration-content">
															<legend class="legend"><spring:message code="com.phfi.askTheWoman" /></legend>
															<table class="confirm-info-table">
																<tr>
																	<td style="min-width: 328px"><spring:message code="com.phfi.haveFever" /></td>
																	<td ><div id="confirmHaveFeer"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 328px"><spring:message code="com.phfi.hadFits" /></td>
																	<td><div id="confirmHadFit"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 328px"><spring:message code="com.phfi.lostConsciousness" /></td>
																	<td><div id="confirmLostConsciousness"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 328px"><spring:message code="com.phfi.feltGiddyAndBlackedOut" /></td>
																	<td><div id="confirmFeltGiddy"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 328px"><spring:message code="com.phfi.severeHeadaches" /></td>
																	<td><div id="confirmHaveHeadaches"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 328px"><spring:message code="com.phfi.haveBlurredVision" /></td>
																	<td><div id="confirmBlurreVission"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 328px"><spring:message code="com.phfi.feelBreathless" /></td>
																	<td><div id="confirmBreathless"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 328px"><spring:message code="com.phfi.haveCough" /></td>
																	<td><div id="confirmHaveCough"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 328px"><spring:message code="com.phfi.haveAbdominalPain" /></td>
																	<td><div id="confirmAbdominalPain"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 328px"><spring:message code="com.phfi.feltBabyMovePast12hours" /></td>
																	<td><div id="confirmBlurreVission"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 328px"><spring:message code="com.phfi.vaginalDischargeSmellsUnpleasant" /></td>
																	<td><div id="confirmVaginalDischarge"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 328px"><spring:message code="com.phfi.haveBleeding" /></td>
																	<td><div id="confirmAnyBleeding"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 328px"><spring:message code="com.phfi.haveWatersBroken" /></td>
																	<td><div id="confirmHaveWaterBroken"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 328px"><spring:message code="com.phfi.haveBurningOrPainWhileUrinating" /></td>
																	<td><div id="confirmBurningPain"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 328px"><spring:message code="com.phfi.haveToeringsBecomeTighter" /></td>
																	<td><div id="confirmRingTighter"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 328px"><spring:message code="com.phfi.hasDifficultTOWearBangles" /></td>
																	<td><div id="confirmWearBangles"></div></td>
																</tr>
															</table>
														</fieldset>
													</fieldset>
													<fieldset class="col-sm-6">
														<fieldset class="fieldset registration-content">
															<legend class="legend"><spring:message code="com.phfi.observe" /></legend>
															<table class="confirm-info-table">
																<tr>
																	<td ><spring:message code="com.phfi.doesLookOutOfBreath" /></td>
																	<td><div id="confirmOutOFBreath"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.talkingIrrelevantly" /></td>
																	<td><div id="confirmTakingIrrelevantly"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.raiseUpperEyelidAskLookDown" /> </td>
																	<td><div id="confirmUpperEye"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.pullLowerEyelidLookInsideLowerEyelid" /></td>
																	<td><div id="confirmLowerEye"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.findDepressionUponPressingShinboneNearAnkle" /></td>
																	<td><div id="confirmHisFeet"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.seePuffinessOfFaceOrSwellingAroundEyes" /></td>
																	<td><div id="confirmFace"></div></td>
																</tr>
															</table>
														</fieldset>
													</fieldset>
													<fieldset class="col-sm-12">
														<fieldset class="fieldset registration-content">
															<legend class="legend"><spring:message code="com.phfi.testResults" /></legend>
															<table class="confirm-info-table">
																<tr>
																	<td><spring:message code="com.phfi.weightStatus" /></td>
																	<td><div id="confirmWeightStatus"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.firstWeight" /></td>
																	<td><div id="confirmFirstWeight"></div></td>
																	<td> <spring:message code="com.phfi.firstDate" /></td>
																	<td><div id="confirmFirstWeightDate"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.secondWeight" /></td>
																	<td><div id="confirmSecWeight"></div></td>
																	<td><spring:message code="com.phfi.secondDate" /></td>
																	<td><div id="confirmSecWeightDate"></div></td>
																	
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.thirdWeight" /></td>
																	<td><div id="confirmThirdWeight"></div></td>
																	<td> <spring:message code="com.phfi.thirdDate" /></td>
																	<td><div id="confirmThirdWeightDate"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.fourthWeight" /></td>
																	<td><div id="confirmFourthWeight"></div></td>
																	<td><spring:message code="com.phfi.fourthDate" /> </td>
																	<td><div id="confirmFourthWeightDate"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.bpStatus" /></td>
																	<td><div id="confirmBpStatus"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.firstBP" /></td>
																	<td><div id="confirmFirstBp"></div></td>
																	<td> <spring:message code="com.phfi.firstDate" /></td>
																	<td><div id="confirmFirstBpDate"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.secondBP" /></td>
																	<td><div id="confirmSecBp"></div></td>
																	<td> <spring:message code="com.phfi.secondDate" /></td>
																	<td><div id="confirmSecBpDate"></div></td>
																	
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.thirdBP" /></td>
																	<td><div id="confirmThirdBp"></div></td>
																	<td> <spring:message code="com.phfi.thirdDate" /></td>
																	<td><div id="confirmThirdBpDate"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.fourthBP" /></td>
																	<td><div id="confirmFourthBp"></div></td>
																	<td><spring:message code="com.phfi.fourthDate" /> </td>
																	<td><div id="confirmFourthBpDate"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.hbStatus" /></td>
																	<td><div id="confirmHbStatus"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.firstHb" /></td>
																	<td><div id="confirmFirstHb"></div></td>
																	<td><spring:message code="com.phfi.firstDate" /></td>
																	<td><div id="confirmFirstHbDate"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.secondHb" /></td>
																	<td><div id="confirmSecHb"></div></td>
																	<td><spring:message code="com.phfi.secondDate" /> </td>
																	<td><div id="confirmSecHbDate"></div></td>
																	
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.thirdHb" /></td>
																	<td><div id="confirmThirdHb"></div></td>
																	<td> <spring:message code="com.phfi.thirdDate" /></td>
																	<td><div id="confirmThirdHbDate"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.fourthHb" /></td>
																	<td><div id="confirmFourthHb"></div></td>
																	<td> <spring:message code="com.phfi.fourthDate" /></td>
																	<td><div id="confirmFourthHbDate"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.urineAlbuminStatus" /></td>
																	<td><div id="confirmUaStatus"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.firstUrineAlbumin" /></td>
																	<td><div id="confirmFirstUa"></div></td>
																	<td><spring:message code="com.phfi.firstDate" /></td>
																	<td><div id="confirmFirstUaDate"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.secondUrineAlbumin" /></td>
																	<td><div id="confirmSecUa"></div></td>
																	<td><spring:message code="com.phfi.secondDate" /> </td>
																	<td><div id="confirmSecUaDate"></div></td>
																	
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.ultrasoundStatus" /></td>
																	<td><div id="confirmUsStatus"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.firstUltrasound" /></td>
																	<td><div id="confirmFirstUs"></div></td>
																	<td><spring:message code="com.phfi.firstDate" /></td>
																	<td><div id="confirmFirstUsDate"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.secondUltrasound" /></td>
																	<td><div id="confirmSecUs"></div></td>
																	<td> <spring:message code="com.phfi.secondDate" /></td>
																	<td><div id="confirmSecUsDate"></div></td>
																	
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.rbsStatus" /></td>
																	<td><div id="confirmRbsStatus"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.firstRbs" /></td>
																	<td><div id="confirmFirstRbs"></div></td>
																	<td> <spring:message code="com.phfi.firstDate" /></td>
																	<td><div id="confirmFirstRbsDate"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.secondRbs" /></td>
																	<td><div id="confirmSecRbs"></div></td>
																	<td><spring:message code="com.phfi.secondDate" /></td>
																	<td><div id="confirmSecRbsDate"></div></td>
																	
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.malariaTestStatus" /></td>
																	<td><div id="confirmMalariaStatus"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.firstMalariaTest" /></td>
																	<td><div id="confirmFirstMalaria"></div></td>
																	<td><spring:message code="com.phfi.firstDate" /></td>
																	<td><div id="confirmFirstMalariaDate"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.secondMalariaTest" /></td>
																	<td><div id="confirmSecMalaria"></div></td>
																	<td><spring:message code="com.phfi.secondDate" /> </td>
																	<td><div id="confirmSecMalariaDate"></div></td>
																	
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.sputumTestStatus" /></td>
																	<td><div id="confirmSputumStatus"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.firstSputumTest" /></td>
																	<td><div id="confirmFirstSputum"></div></td>
																	<td> <spring:message code="com.phfi.firstDate" /></td>
																	<td><div id="confirmFirstSputumDate"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.secondSputumTest" /></td>
																	<td><div id="confirmSecSputum"></div></td>
																	<td><spring:message code="com.phfi.secondDate" /></td>
																	<td><div id="confirmSecSputumDate"></div></td>
																	
																</tr>
															</table>
														</fieldset>
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
	<script src="../js_new/postpartumVisit.js"></script>
	
	<!--Body Wrapper block End -->
	<script type="text/javascript" src="../js_new/merchant.js"></script>
	<script type="text/javascript" src="../js_new/backbutton.js"></script>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script>
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
		$(
				".askTheWomen-arrow,.askTheWomenRest-arrow,.observe-arrow,.testResultFirst-arrow,.testResultSec-arrow,.confirm-arrow,.askTheFamily-arrow")
				.hide();
		$(".women-info-list,.askTheWomen-prev")
				.click(
						function() {
							
							$(".womenInfo-circle-tab").addClass("active-circle");
							$(
									".askTheWomen-circle-tab,.askTheWomenRest-circle-tab,.testResultFirst-circle-tab,.observe-circle-tab,.testResultSec-circle-tab,.askTheFamily-circle-tab,.confirm-circle-tab")
									.removeClass("active-circle");
							$(".womenInfo-arrow").show();
							$(
									".askTheWomen-arrow,.askTheWomenRest-arrow,.observe-arrow,.testResultFirst-arrow,.testResultSec-arrow,.askTheFamily-arrow,.confirm-arrow")
									.hide();
							$(".women-info-content").show();
							$(
									".askthewomefirst-content,.askthewomesec-content,.confirm-details-content,.observe-details-content,.testresultfirst-details-content,.testresultsec-details-content,.askthefamily-content")
									.hide();
						});
		$(".askTheWomen-info-list,.women-next,.askTheWomenSec-prev")
				.click(
						function() {
							
							$(".askTheWomen-circle-tab").addClass(
									"active-circle");
							$(
									".womenInfo-circle-tab,.askTheWomenRest-circle-tab,.testResultFirst-circle-tab,.observe-circle-tab,.testResultSec-circle-tab,.askTheFamily-circle-tab,.confirm-circle-tab")
									.removeClass("active-circle");
							$(".askTheWomen-arrow").show();
							$(
									".womenInfo-arrow,.askTheWomenRest-arrow,.observe-arrow,.testResultFirst-arrow,.testResultSec-arrow,.askTheFamily-arrow,.confirm-arrow")
									.hide();
							$(".askthewomefirst-content").show();
							$(
									".women-info-content,.askthewomesec-content,.observe-details-content,.confirm-details-content,.testresultfirst-details-content,.testresultsec-details-content,.askthefamily-content")
									.hide();
						});
		$(".askTheWomenRest-info-list,.askTheWomen-next,.observe-prev")
				.click(
						function() {
							
							$(".askTheWomenRest-circle-tab").addClass("active-circle");
							$(
									".womenInfo-circle-tab,.askTheWomen-circle-tab,.testResultFirst-circle-tab,.observe-circle-tab,.testResultSec-circle-tab,.askTheFamily-circle-tab,.confirm-circle-tab")
									.removeClass("active-circle");
							$(".askTheWomenRest-arrow").show();
							$(
									".womenInfo-arrow,.askTheWomen-arrow,.observe-arrow,.testResultFirst-arrow,.testResultSec-arrow,.askTheFamily-arrow,.confirm-arrow")
									.hide();
							$(".askthewomesec-content").show();
							$(
									".women-info-content,.askthewomefirst-content,.observe-details-content,.confirm-details-content,.testresultfirst-details-content,.testresultsec-details-content,.askthefamily-content")
									.hide();
						});
		$(".observe-info-list,.askTheWomenSec-next,.testresultfirst-prev")
				.click(
						function() {
							
							$(".observe-circle-tab").addClass("active-circle");
							$(
									".womenInfo-circle-tab,.askTheWomen-circle-tab,.askTheWomenRest-circle-tab,.testResultFirst-circle-tab,.testResultSec-circle-tab,.askTheFamily-circle-tab,.confirm-circle-tab")
									.removeClass("active-circle");
							$(".observe-arrow").show();
							$(
									".womenInfo-arrow,.askTheWomen-arrow,.askTheWomenRest-arrow,.testResultFirst-arrow,.testResultSec-arrow,.askTheFamily-arrow,.confirm-arrow")
									.hide();
							$(".observe-details-content").show();
							$(
									".women-info-content,.askthewomefirst-content,.askthewomesec-content,.confirm-details-content,.testresultfirst-details-content,.testresultsec-details-content,.askthefamily-content")
									.hide();
						});
		$(".testResultFirst-info-list,.observe-next,.testresultsec-prev")
				.click(
						function() {
							
							$(".testResultFirst-circle-tab").addClass(
									"active-circle");
							$(
									".womenInfo-circle-tab,.askTheWomen-circle-tab,.askTheWomenRest-circle-tab,.observe-circle-tab,.testResultSec-circle-tab,.askTheFamily-circle-tab,.confirm-circle-tab")
									.removeClass("active-circle");
							$(".testResultFirst-arrow").show();
							$(
									".womenInfo-arrow,.askTheWomen-arrow,.askTheWomenRest-arrow,.observe-arrow,.testResultSec-arrow,.askTheFamily-arrow,.confirm-arrow")
									.hide();
							$(".testresultfirst-details-content").show();
							$(
									".women-info-content,.askthewomefirst-content,.askthewomesec-content,.confirm-details-content,.observe-details-content,.testresultsec-details-content,.askthefamily-content")
									.hide();
						});
		$(".testResultSec-info-list,.testresultfirst-next,.askthefamily-prev")
				.click(
						function() {
							
							$(".testResultSec-circle-tab")
									.addClass("active-circle");
							$(
									".womenInfo-circle-tab,.askTheWomen-circle-tab,.askTheWomenRest-circle-tab,.observe-circle-tab,.testResultFirst-circle-tab,.askTheFamily-circle-tab,.confirm-circle-tab")
									.removeClass("active-circle");
							$(".testResultSec-arrow").show();
							$(
									".womenInfo-arrow,.askTheWomen-arrow,.askTheWomenRest-arrow,.observe-arrow,.testResultFirst-arrow,.askTheFamily-arrow,.confirm-arrow")
									.hide();
							$(".testresultsec-details-content").show();
							$(
									".women-info-content,.askthewomefirst-content,.askthewomesec-content,.confirm-details-content,.observe-details-content,.testresultfirst-details-content,.askthefamily-content")
									.hide();
						});
		$(".askTheFamily-info-list,.testresultsec-next,.confirm-prev")
				.click(
						function() {
							
							$(".askTheFamily-circle-tab").addClass(
									"active-circle");
							$(
									".womenInfo-circle-tab,.askTheWomen-circle-tab,.askTheWomenRest-circle-tab,.observe-circle-tab,.testResultFirst-circle-tab,.testResultSec-circle-tab,.confirm-circle-tab")
									.removeClass("active-circle");
							$(".askTheFamily-arrow").show();
							$(
									".womenInfo-arrow,.askTheWomen-arrow,.askTheWomenRest-arrow,.observe-arrow,.testResultFirst-arrow,.testResultSec-arrow,.confirm-arrow")
									.hide();
							$(".askthefamily-content").show();
							$(
									".women-info-content,.askthewomefirst-content,.askthewomesec-content,.confirm-details-content,.observe-details-content,.testresultfirst-details-content,.testresultsec-details-content")
									.hide();
						});
		$(".confirm-info-list,.askthefamily-next")
				.click(
						function() {
							 if (!setAshaInfo()|!setAskTheWoman()|!setObserve()|!setTestResult()|!setAskTheFamily()) {
									return false;
								} 
							$(".confirm-circle-tab").addClass("active-circle");
							$(
									".womenInfo-circle-tab,.askTheWomen-circle-tab,.askTheWomenRest-circle-tab,.observe-circle-tab,.testResultFirst-circle-tab,.testResultSec-circle-tab,.askTheFamily-circle-tab")
									.removeClass("active-circle");
							$(".confirm-arrow").show();
							$(
									".womenInfo-arrow,.askTheWomen-arrow,.askTheWomenRest-arrow,.observe-arrow,.testResultFirst-arrow,.testResultSec-arrow,.askTheFamily-arrow")
									.hide();
							$(".confirm-details-content").show();
							$(
									".women-info-content,.askthewomefirst-content,.askthewomesec-content,.observe-details-content,.testresultfirst-details-content,.testresultsec-details-content,.askthefamily-content")
									.hide();
						});
	</script>
</body>
</html>