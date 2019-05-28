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
									<li class="testResultThird-info-list">
										<div class="circle-div">
											<div class="hr"></div>
											<span class="testResultThird-circle-tab"></span>
										</div> <label><spring:message code="com.phfi.testResults3" /></label>
										<div class="arrow-down testResultThird-arrow"></div>
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
								<form:form action="process-pregnancy-visit" commandName="phfiVisitRequest"	name="phfiVisitRequest">
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
															<form:radiobutton id="isFeverComeAndGo"
																path="isFeverComeAndGo" value="Yes"/><spring:message code="com.phfi.yes" />&nbsp; <form:radiobutton
																id="isFeverComeAndGo"
																path="isFeverComeAndGo" value="No"
																onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.no" />
															<div class="discriptionErrorMsg">
																<span id="isFeverComeAndGoErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.feelTiredWhenYouCookOrClean" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="isFeelTired" path="isFeelTired"
															value="Yes"/><spring:message code="com.phfi.yes" />&nbsp; <form:radiobutton
															id="isFeelTired" path="isFeelTired" value="No" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="isFeelTiredErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.hadFits" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="isFits" path="isFits"
															value="Yes"/><spring:message code="com.phfi.yes" />&nbsp; <form:radiobutton
															id="isFits" path="isFits" value="No" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.no" />
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
														<form:radiobutton id="isConsciousness" path="isConsciousness"
															value="Yes"/><spring:message code="com.phfi.yes" />&nbsp; <form:radiobutton
															id="isConsciousness" path="isConsciousness" value="No" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="isConsciousnessErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.feltGiddyAndBlackedOut" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="feltGiddy" path="feltGiddy"
															value="Yes"/><spring:message code="com.phfi.yes" />&nbsp; <form:radiobutton
															id="feltGiddy" path="feltGiddy" value="No" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="haveFaintedErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>	
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.severeHeadaches" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="haveHeadaches" path="haveHeadaches"
															value="Yes"/><spring:message code="com.phfi.yes" />&nbsp; <form:radiobutton
															id="haveHeadaches" path="haveHeadaches" value="No" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.no" />
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
														<form:radiobutton id="haveBlurredVision" path="haveBlurredVision"
															value="Yes"/><spring:message code="com.phfi.yes" />&nbsp; <form:radiobutton
															id="haveBlurredVision" path="haveBlurredVision" value="No" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="haveBlurredVisionErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.feelBreathless" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="isBreathless" path="isBreathless"
															value="Yes" onclick="showBreathless()"/><spring:message code="com.phfi.yes" />&nbsp; <form:radiobutton
															id="isBreathless" path="isBreathless" value="No" onblur="validateRadio()" onclick="hideBreathless()"/>&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="isBreathlessErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-12" id="breathlessId">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.whenFeelBreathless" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-6">
														<input type="checkbox" id="whenBreathless" name="whenBreathless"
															value="while sitting or lying down"><spring:message code="com.phfi.whileSittingOrLyingDown" />&nbsp;<input type="checkbox" id="whenBreathless" name="whenBreathless"
															value="cooking or cleaning"><spring:message code="com.phfi.cookingOrCleaning" />&nbsp; <input type="checkbox"
															id="whenBreathless" name="whenBreathless" value="carrying load" onblur="validateRadio()"><spring:message code="com.phfi.carryingLoad" />
														<div class="discriptionErrorMsg">
															<span id="whenBreathlessErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
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
														<form:radiobutton id="haveCough" path="haveCough"
															value="Yes" onclick="showCough()"/><spring:message code="com.phfi.yes" />Yes&nbsp; <form:radiobutton
															id="haveCough" path="haveCough" value="No" onclick="hideCough()" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="haveCoughErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-12" id="coughId">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.howLongHadCough" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-6">
														<form:radiobutton id="howLongHaveCough" path="howLongHaveCough"
															value="less than three weeks"/><spring:message code="com.phfi.lessThanThreeWeeks" />&nbsp; <form:radiobutton
															id="howLongHaveCough" path="howLongHaveCough" value="more than three weeks" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.moreThanThreeWeeks" />									<div class="discriptionErrorMsg">
															<span id="diabetes" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset> 
												</fieldset> 
												
												
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.haveAbdominalPain" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="isAbdominalPain" path="isAbdominalPain"
															value="Yes" onclick="showAbnormalPain()"/><spring:message code="com.phfi.yes" />&nbsp; <form:radiobutton
															id="isAbdominalPain" path="isAbdominalPain" value="No" onclick="hideAbnormalPain()" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.yes" />
														<div class="discriptionErrorMsg">
															<span id="isAbdominalPainErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-12" id="abnormalPain">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.whereItPain" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-6">
														<form:radiobutton id="wherePain" path="wherePain"
															value="Upper abdomen"/><spring:message code="com.phfi.upperAbdomen" />&nbsp;
															<form:radiobutton id="wherePain" path="wherePain"
															value="Lower abdomen"/><spring:message code="com.phfi.lowerAbdomen" />&nbsp;
															 <form:radiobutton
															id="wherePain" path="wherePain" value="All over" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.allOver" />
														<div class="discriptionErrorMsg">
															<span id="wherePainError" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset> 
												</fieldset> 
												
												
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.feltBabyMovePast12hours" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="babyMove" path="babyMove"
															value="Yes"/><spring:message code="com.phfi.yes" />&nbsp; <form:radiobutton
															id="babyMove" path="babyMove" value="No" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="babyMoveErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>  
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.vaginalDischargeSmellsUnpleasant" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="isVaginalDischarge" path="isVaginalDischarge"
															value="Yes"/><spring:message code="com.phfi.yes" />&nbsp; <form:radiobutton
															id="isVaginalDischarge" path="isVaginalDischarge" value="No" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="isVaginalDischargeErroDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset> 
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.haveBleeding" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="isBleeding" path="isBleeding"
															value="Yes" onclick="showBleeding()"/><spring:message code="com.phfi.yes" />&nbsp; <form:radiobutton 
															id="isBleeding" path="isBleeding" value="No" onclick="hideBleeding()" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="isBleedingErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-12" id="bleedingId">
														<fieldset class="col-sm-6">
															<label><spring:message code="com.phfi.kindOfBleeding" /><span
																class="required-field">*</span></label>
														</fieldset>
														<fieldset class="col-sm-6">
															<form:radiobutton id="kindOfBleeding"
																path="kindOfBleeding" value="Spotting"/><spring:message code="com.phfi.spotting" />&nbsp; <form:radiobutton
																id="kindOfBleeding" path="kindOfBleeding"
																value="Period-like" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.periodLike" />
															     &nbsp; <form:radiobutton id="kindOfBleeding"
																path="kindOfBleeding" value="Tap-like" onblur="validateRadio()"/><spring:message code="com.phfi.tapLike" />
															<div class="discriptionErrorMsg">
																<span id="kindOfBleedingErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
													</fieldset>
												</fieldset>  
												
												
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.haveWatersBroken" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="isWaterBroken" path="isWaterBroken"
															value="Yes"/><spring:message code="com.phfi.yes" />&nbsp; <form:radiobutton
															id="isWaterBroken" path="isWaterBroken" value="No" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="isWaterBrokenErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>  
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.haveBurningOrPainWhileUrinating" />
														<span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="isBurningPain" path="isBurningPain"
															value="Yes"/><spring:message code="com.phfi.yes" />&nbsp; <form:radiobutton
															id="isBurningPain" path="isBurningPain" value="No" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="isBurningPainErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset> 
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.haveToeringsBecomeTighter" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="toeRingsTighter" path="toeRingsTighter"
															value="Yes"/><spring:message code="com.phfi.yes" />&nbsp; <form:radiobutton
															id="toeRingsTighter" path="toeRingsTighter" value="No" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="toeRingsTightererrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset> 
												
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.hasDifficultTOWearBangles" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="isBangles" path="isBangles"
															value="Yes"/><spring:message code="com.phfi.yes" />&nbsp; <form:radiobutton
															id="isBangles" path="isBangles" value="No" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="isBanglesErrorDiv" class="red-error">&nbsp;</span>
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
														<form:radiobutton id="outOfBreath" path="isoutOfBreath"
															value="Yes"/><spring:message code="com.phfi.yes" />&nbsp; <form:radiobutton
															id="outOfBreath" path="isoutOfBreath" value="No" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.no" />
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
														<form:radiobutton id="isTalking" path="isTalking"
															value="Yes"/><spring:message code="com.phfi.yes" />&nbsp; <form:radiobutton
															id="isTalking" path="isTalking" value="No" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.no" />
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
														<form:radiobutton id="UpperEyeColor" path="UpperEyeColor"
															value="White"/><spring:message code="com.phfi.white" />&nbsp; <form:radiobutton
															id="upperEyeColor" path="upperEyeColor" value="Yellow" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.yellow" />
														<div class="discriptionErrorMsg">
															<span id="UpperEyeColorErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.pullLowerEyelidLookInsideLowerEyelid" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="LowerEyeColor" path="LowerEyeColor"
															value="Pink"/><spring:message code="com.phfi.pink" />&nbsp; <form:radiobutton
															id="lowerEyeColor" path="lowerEyeColor" value="Pale" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.pale" />
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
														<form:radiobutton id="isAnkleDepression" path="isAnkleDepression"
															value="Yes"/><spring:message code="com.phfi.yes" />&nbsp; <form:radiobutton
															id="isAnkleDepression" path="isAnkleDepression" value="No" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.no" />
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
														<form:radiobutton id="isEyeSwelling" path="isEyeSwelling"
															value="Yes"/><spring:message code="com.phfi.yes" />&nbsp; <form:radiobutton
															id="isEyeSwelling" path="isEyeSwelling" value="No" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.no" />
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
											<!--Test Results part Yes Content Start -->
											<section class="field-element-row testresultfirst-details-content" style="display: none;">
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.weight" /><span class="required-field">*</span>
														</label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="weight" path="weight"
															value="Done" onclick="showWeight()"/><spring:message code="com.phfi.done" />&nbsp; <form:radiobutton
															id="weight" path="weight" value="Not Done" onblur="validateRadio()" onclick="hideWeight()"/>&nbsp;&nbsp;<spring:message code="com.phfi.notDone" />
														<div class="discriptionErrorMsg">
															<span id="weightErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12" id="weightId">
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.aWeight" /><span class="required-field">*</span></label>
															<form:input cssClass="form-control" path="firstWeight"
																id="firstWeight" maxlength="50"
																onblur="weightValidation('firstWeight','firstWeightErrorDiv')" />
															<div class="discriptionErrorMsg">
																<span id="firstWeightErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.date" /><span class="required-field">*</span></label>
															<div class="input-group registrationdate">
																<form:input cssClass="form-control regDate"
																	path="weightDateOne" id="weightDateOne"
																	onblur="return clientValidation('weightDateOne', 'required','weightDateOneErrorDiv')" />
																<span class="input-group-addon"><span
																	class="glyphicon glyphicon-calendar"></span></span>
															</div>
															<div class="discriptionErrorMsg">
																<span id="weightDateOneErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.bWeight" /><span class="required-field">*</span></label>
															<form:input cssClass="form-control" path="SecWeight"
																id="SecWeight" maxlength="50"
																onblur="weightValidation('SecWeight','SecWeightErrorDiv')" />
															<div class="discriptionErrorMsg">
																<span id="SecWeightErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.date" /><span class="required-field">*</span></label>
															<div class="input-group registrationdate">
																<form:input cssClass="form-control regDate"
																	path="weightDateSec" id="weightDateSec"
																	onblur="return clientValidation('weightDateSec', 'required','weightDateSecErrorDiv')" />
																<span class="input-group-addon"><span
																	class="glyphicon glyphicon-calendar"></span></span>
															</div>
															<div class="discriptionErrorMsg">
																<span id="weightDateSecErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.cWeight" /><span class="required-field">*</span></label>
															<form:input cssClass="form-control" path="thirdWeight"
																id="thirdWeight" maxlength="50"
																onblur="weightValidation('thirdWeight','thirdWeightErrorDiv')" />
															<div class="discriptionErrorMsg">
																<span id="thirdWeightErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.date" /><span class="required-field">*</span></label>
															<div class="input-group registrationdate">
																<form:input cssClass="form-control regDate"
																	path="weightDateThird" id="weightDateThird"
																	onblur="return clientValidation('weightDateThird', 'required','weightDateThirdErrorDiv')" />
																<span class="input-group-addon"><span
																	class="glyphicon glyphicon-calendar"></span></span>
															</div>
															<div class="discriptionErrorMsg">
																<span id="weightDateThirdErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.dWeight" /><span class="required-field">*</span></label>
															<form:input cssClass="form-control" path="fourthWeight"
																id="fourthWeight" maxlength="50"
																onblur="weightValidation('fourthWeight','fourthWeightErrorDiv')" />
															<div class="discriptionErrorMsg">
																<span id="fourthWeightErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.date" /><span class="required-field">*</span></label>
															<div class="input-group registrationdate">
																<form:input cssClass="form-control regDate"
																	path="weightDateFour" id="weightDateFour"
																	onblur="return clientValidation('weightDateFour', 'required','weightDateFourErrorDiv')" />
																<span class="input-group-addon"><span
																	class="glyphicon glyphicon-calendar"></span></span>
															</div>
															<div class="discriptionErrorMsg">
																<span id="weightDateFourErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
												</fieldset>
												<fieldset class="col-sm-12" >
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.bp" /> <span class="required-field">*</span>
														</label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="bp" path="bp"
															value="Done" onclick="showBp()"/><spring:message code="com.phfi.done" />&nbsp; <form:radiobutton
															id="bp" path="bp" value="Not Done" onclick="hideBp()" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.notDone" />
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
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.cBP" /><span class="required-field">*</span></label>
															<form:input cssClass="form-control" path="thirdBp"
																id="thirdBp" maxlength="50"
																onblur="bpValidation('thirdBp','thirdBpErrorDiv')" />
															<div class="discriptionErrorMsg">
																<span id="thirdBpErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.date" /><span class="required-field">*</span></label>
															<div class="input-group registrationdate">
																<form:input cssClass="form-control regDate"
																	path="bpDateThird" id="bpDateThird"
																	onblur="return clientValidation('bpDateThird', 'required','bpDateThirdErrorDiv')" />
																<span class="input-group-addon"><span
																	class="glyphicon glyphicon-calendar"></span></span>
															</div>
															<div class="discriptionErrorMsg">
																<span id="bpDateThirdErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.dBP" /><span class="required-field">*</span></label>
															<form:input cssClass="form-control" path="fourBp"
																id="fourBp" maxlength="50"
																onblur="bpValidation('fourBp','fourBpErrorDiv')" />
															<div class="discriptionErrorMsg">
																<span id="fourBpErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.date" /><span class="required-field">*</span></label>
															<div class="input-group registrationdate">
																<form:input cssClass="form-control regDate"
																	path="bpDateFour" id="bpDateFour"
																	onblur="return clientValidation('bpDateFour', 'required','bpDateFourErrorDiv')" />
																<span class="input-group-addon"><span
																	class="glyphicon glyphicon-calendar"></span></span>
															</div>
															<div class="discriptionErrorMsg">
																<span id="bpDateFourErrorDiv" class="red-error">&nbsp;</span>
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
											<fieldset class="col-sm-12" >
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.hb" /><span class="required-field">*</span>
														</label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="hb" path="hb"
															value="Done" onclick="showHb()"/><spring:message code="com.phfi.done" />&nbsp; <form:radiobutton
															id="hb" path="hb" value="Not Done" onclick="hideHb()" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.notDone" />
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
																	onblur="return clientValidation('hbDateSec', 'required','hbDateSecErrorDiv')" />
																<span class="input-group-addon"><span
																	class="glyphicon glyphicon-calendar"></span></span>
															</div>
															<div class="discriptionErrorMsg">
																<span id="hbDateSecErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.cHB" /><span class="required-field">*</span></label>
															<form:input cssClass="form-control" path="thirdHb"
																id="thirdHb" maxlength="50"
																onblur="hbValidation('thirdHb','thirdHbErrorDiv')" />
															<div class="discriptionErrorMsg">
																<span id="thirdHbErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.date" /><span class="required-field">*</span></label>
															<div class="input-group registrationdate">
																<form:input cssClass="form-control regDate"
																	path="hbDateThird" id="hbDateThird"
																	onblur="return clientValidation('hbDateThird', 'required','hbDateThirdErrorDiv')" />
																<span class="input-group-addon"><span
																	class="glyphicon glyphicon-calendar"></span></span>
															</div>
															<div class="discriptionErrorMsg">
																<span id="hbDateThirdErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.dHB" /><span class="required-field">*</span></label>
															<form:input cssClass="form-control" path="fourHb"
																id="fourHb" maxlength="50"
																onblur="hbValidation('fourHb','fourHbErrorDiv')" />
															<div class="discriptionErrorMsg">
																<span id="fourHbErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.date" /><span class="required-field">*</span></label>
															<div class="input-group registrationdate">
																<form:input cssClass="form-control regDate"
																	path="hbDateFour" id="hbDateFour"
																	onblur="return clientValidation('hbDateFour', 'required','hbDateFourErrorDiv')" />
																<span class="input-group-addon"><span
																	class="glyphicon glyphicon-calendar"></span></span>
															</div>
															<div class="discriptionErrorMsg">
																<span id="hbDateFourErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
												</fieldset>
												
												<fieldset class="col-sm-12" >
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.urineAlbumin" /><span class="required-field">*</span>
														</label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="urine" path="urine"
															value="Done" onclick="showUrine()"/><spring:message code="com.phfi.done" />&nbsp; <form:radiobutton
															id="urine" path="urine" value="Not Done" onclick="hideUrine()" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.notDone" />
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
												
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.ultrasoundScan" /><span class="required-field">*</span>
														</label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="ultrasound" path="ultrasound"
															value="Done" onclick="showUltrasound()"/><spring:message code="com.phfi.done" />&nbsp; <form:radiobutton
															id="ultrasound" path="ultrasound" value="No Done" onclick="hideUltrasound()" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.notDone" />
														<div class="discriptionErrorMsg">
															<span id="ultrasoundErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12" id="ultrasoundId">
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.aUltrasoundScan" /><span class="required-field">*</span></label>
															<form:input cssClass="form-control" path="firstUltrasound"
																id="firstUltrasound" maxlength="50"
																onblur="return clientValidation('firstUltrasound', 'numericField','firstUltrasoundErrorDiv')" />
															<div class="discriptionErrorMsg">
																<span id="firstUltrasoundErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.date" /><span class="required-field">*</span></label>
															<div class="input-group registrationdate">
																<form:input cssClass="form-control regDate"
																	path="ultrasoundDateOne" id="ultrasoundDateOne"
																	onblur="return clientValidation('ultrasoundDateOne', 'required','ultrasoundDateOneErrorDiv')" />
																<span class="input-group-addon"><span
																	class="glyphicon glyphicon-calendar"></span></span>
															</div>
															<div class="discriptionErrorMsg">
																<span id="ultrasoundDateOneErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.bUltrasoundScan" /><span class="required-field">*</span></label>
															<form:input cssClass="form-control" path="secUltrasound"
																id="secUltrasound" maxlength="50"
																onblur="return clientValidation('secUltrasound', 'numericField','secUltrasoundErrorDiv')" />
															<div class="discriptionErrorMsg">
																<span id="secUltrasoundErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.date" /><span class="required-field">*</span></label>
															<div class="input-group registrationdate">
																<form:input cssClass="form-control regDate"
																	path="ultrasoundDateSec" id="ultrasoundDateSec"
																	onblur="return clientValidation('ultrasoundDateSec', 'required','ultrasoundDateSecErrorDiv')" />
																<span class="input-group-addon"><span
																	class="glyphicon glyphicon-calendar"></span></span>
															</div>
															<div class="discriptionErrorMsg">
																<span id="ultrasoundDateSecErrorDiv" class="red-error">&nbsp;</span>
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
											
											<!-- test result 3 content start -->

											<section class="field-element-row testresultthird-details-content" style="display: none;">
											<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.rbs" /><span class="required-field">*</span>
														</label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="rbs" path="rbs"
															value="Done" onclick="showRbs()"/><spring:message code="com.phfi.done" />&nbsp; <form:radiobutton
															id="rbs" path="rbs" value="Not Done" onclick="hideRbs()" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.notDone" />
														<div class="discriptionErrorMsg">
															<span id="rbsErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<fieldset class="col-sm-12" id="rbsId">
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.aRBS" /><span class="required-field">*</span></label>
															<form:input cssClass="form-control" path="firstRbs"
																id="firstRbs" maxlength="50"
																onblur="rbsValidation('firstRbs','firstRbsErrorDiv')" />
															<div class="discriptionErrorMsg">
																<span id="firstRbsErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.date" /><span class="required-field">*</span></label>
															<div class="input-group registrationdate">
																<form:input cssClass="form-control regDate"
																	path="rbsDateOne" id="rbsDateOne"
																	onblur="return clientValidation('rbsDateOne', 'required','rbsDateOneErrorDiv')" />
																<span class="input-group-addon"><span
																	class="glyphicon glyphicon-calendar"></span></span>
															</div>
															<div class="discriptionErrorMsg">
																<span id="rbsDateOneErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.bRBS" /><span class="required-field">*</span></label>
															<form:input cssClass="form-control" path="secRbs"
																id="secRbs" maxlength="50"
																onblur="rbsValidation('secRbs','secRbsErrorDiv')" />
															<div class="discriptionErrorMsg">
																<span id="secRbsErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-3">
															<label><spring:message code="com.phfi.date" /><span class="required-field">*</span></label>
															<div class="input-group registrationdate">
																<form:input cssClass="form-control regDate"
																	path="rbsDateSec" id="rbsDateSec"
																	onblur="return clientValidation('rbsDateSec', 'required','rbsDateSecErrorDiv')" />
																<span class="input-group-addon"><span
																	class="glyphicon glyphicon-calendar"></span></span>
															</div>
															<div class="discriptionErrorMsg">
																<span id="rbsDateSecErrorDiv" class="red-error">&nbsp;</span>
															</div>
														</fieldset>
												</fieldset>
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.testForMalaria" /><span class="required-field">*</span>
														</label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="malaria" path="malaria"
															value="Done" onclick="showMalaria()"/><spring:message code="com.phfi.done" />&nbsp; <form:radiobutton
															id="malaria" path="malaria" value="No Done" onclick="hideMalaria()" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.notDone" />
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
																onblur="return clientValidation('firstMalaria', 'required','firstMalariaErrorId')" />
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
																onblur="return clientValidation('secMalaria', 'required','secMalariaErrorDiv')" />
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
														<form:radiobutton id="sputum" path="sputum"
															value="Done" onclick="showSputum()"/><spring:message code="com.phfi.done" />&nbsp; <form:radiobutton
															id="sputum" path="sputum" value="Not Done" onclick="hideSputum()" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.notDone" />
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
															class="form-control button pull-right testresultthird-next"
															value="Continue"> <input type="button"
															class="form-control button pull-right marginL10 testresultthird-prev"
															value="Previous"> <input type="button"
															class="form-control button pull-right marginL10"
															value="Reset"> <input type="button"
															class="form-control button pull-right marginL10"
															value="Cancel">
													</fieldset>
												</div>
												<!--Panel Action Button End -->
											</section>

											<!-- test result 3 content end -->


											<!--Ask the family Content Start -->
											<section class="field-element-row askthefamily-content" style="display: none;">
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-6">
														<label><spring:message code="com.phfi.talkingIllogicalAndDisconnectedManner" /><span class="required-field">*</span></label>
													</fieldset>
													<fieldset class="col-sm-3">
														<form:radiobutton id="talkingIrrelevantly" path="talkingIrrelevantly"
															value="Yes"/><spring:message code="com.phfi.yes" />&nbsp; <form:radiobutton
															id="talkingIrrelevantly" path="talkingIrrelevantly" value="0" onblur="validateRadio()"/>&nbsp;&nbsp;<spring:message code="com.phfi.no" />
														<div class="discriptionErrorMsg">
															<span id="talkingIrrelevantlyErrorDiv" class="red-error">&nbsp;</span>
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
															<table class="confirm-info-table" style="min-height: 50px">
																
																<tr>
																	<td style="min-width: 350px"><spring:message code="com.phfi.talkingIllogicalAndDisconnectedManner" /></td>
																	<td><div id="confirmTalkingAndDisconnected"></div></td>
																</tr>
																
																</table>
														</fieldset>
													</fieldset>
													</fieldset>
													<fieldset class="col-sm-12" style="padding: 0;">
													<fieldset class="col-sm-6">
														<fieldset class="fieldset registration-content">
															<legend class="legend"><spring:message code="com.phfi.askTheWoman" /></legend>
															<table class="confirm-info-table">
																<tr>
																	<td style="min-width: 350px"><spring:message code="com.phfi.haveFever" /></td>
																	<td><div id="confirmHaveFeer"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 350px"><spring:message code="com.phfi.hadFits" /></td>
																	<td><div id="confirmHadFit"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 350px"><spring:message code="com.phfi.lostConsciousness" /></td>
																	<td><div id="confirmLostConsciousness"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 350px"><spring:message code="com.phfi.feltGiddyAndBlackedOut" /></td>
																	<td><div id="confirmFeltGiddy"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 350px"><spring:message code="com.phfi.severeHeadaches" /></td>
																	<td><div id="confirmHaveHeadaches"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 350px"><spring:message code="com.phfi.haveBlurredVision" /></td>
																	<td><div id="confirmBlurreVission"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 350px"><spring:message code="com.phfi.feelBreathless" /></td>
																	<td><div id="confirmBreathless"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 350px"><spring:message code="com.phfi.haveCough" /></td>
																	<td><div id="confirmHaveCough"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 350px"><spring:message code="com.phfi.haveAbdominalPain" /></td>
																	<td><div id="confirmAbdominalPain"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 350px"><spring:message code="com.phfi.feltBabyMovePast12hours" /></td>
																	<td><div id="confirmBabyMove"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 350px"><spring:message code="com.phfi.vaginalDischargeSmellsUnpleasant" /></td>
																	<td><div id="confirmVaginalDischarge"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 350px"><spring:message code="com.phfi.haveBleeding" /></td>
																	<td><div id="confirmAnyBleeding"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 350px"><spring:message code="com.phfi.haveWatersBroken" /></td>
																	<td><div id="confirmHaveWaterBroken"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 350px"><spring:message code="com.phfi.haveBurningOrPainWhileUrinating" /></td>
																	<td><div id="confirmBurningPain"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 350px"><spring:message code="com.phfi.haveToeringsBecomeTighter" /></td>
																	<td><div id="confirmRingTighter"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 350px"><spring:message code="com.phfi.hasDifficultTOWearBangles" /></td>
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
																	<td style="min-width: 350px"><spring:message code="com.phfi.doesLookOutOfBreath" /></td>
																	<td><div id="confirmOutOFBreath"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 350px"><spring:message code="com.phfi.talkingIrrelevantly" /></td>
																	<td><div id="confirmTakingIrrelevantly"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 350px"><spring:message code="com.phfi.raiseUpperEyelidAskLookDown" /></td>
																	<td><div id="confirmUpperEye"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 350px"><spring:message code="com.phfi.pullLowerEyelidLookInsideLowerEyelid" /></td>
																	<td><div id="confirmLowerEye"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 350px"><spring:message code="com.phfi.findDepressionUponPressingShinboneNearAnkle" /></td>
																	<td><div id="confirmHisFeet"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 350px"><spring:message code="com.phfi.seeFullnessOfFaceOrSwellingAroundEyes" /></td>
																	<td><div id="confirmFace"></div></td>
																</tr>
															</table>
														</fieldset>
													</fieldset>
													</fieldset>
													<fieldset class="col-sm-12" style="padding: 0;">
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
																	<td><spring:message code="com.phfi.thirdDate" /></td>
																	<td><div id="confirmThirdWeightDate"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.fourthWeight" /></td>
																	<td><div id="confirmFourthWeight"></div></td>
																	<td><spring:message code="com.phfi.fourthDate" /></td>
																	<td><div id="confirmFourthWeightDate"></div></td>
																</tr>
																<tr>
																	<td><br/><spring:message code="com.phfi.bpStatus" /></td>
																	<td><br/><div id="confirmBpStatus"></div></td>
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
																	<td><spring:message code="com.phfi.secondDate" /></td>
																	<td><div id="confirmSecBpDate"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.thirdBP" /></td>
																	<td><div id="confirmThirdBp"></div></td>
																	<td><spring:message code="com.phfi.thirdDate" /></td>
																	<td><div id="confirmThirdBpDate"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.fourthBP" /></td>
																	<td><div id="confirmFourthBp"></div></td>
																	<td> <spring:message code="com.phfi.fourthDate" /></td>
																	<td><div id="confirmFourthBpDate"></div></td>
																</tr>
																<tr>
																	<td><br/><spring:message code="com.phfi.hbStatus" /></td>
																	<td><br/><div id="confirmHbStatus"></div></td>
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
																	<td><spring:message code="com.phfi.secondDate" /></td>
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
																	<td><br/><spring:message code="com.phfi.urineAlbuminStatus" /></td>
																	<td><br/><div id="confirmUaStatus"></div></td>
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
																	<td> <spring:message code="com.phfi.secondDate" /></td>
																	<td><div id="confirmSecUaDate"></div></td>
																	
																</tr>
																<tr>
																	<td><br/><spring:message code="com.phfi.ultrasoundStatus" /></td>
																	<td><br/><div id="confirmUsStatus"></div></td>
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
																	<td><spring:message code="com.phfi.secondDate" /></td>
																	<td><div id="confirmSecUsDate"></div></td>
																	
																</tr>
																<tr>
																	<td><br/><spring:message code="com.phfi.rbsStatus" /></td>
																	<td><br/><div id="confirmRbsStatus"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.firstRbs" /></td>
																	<td><div id="confirmFirstRbs"></div></td>
																	<td><spring:message code="com.phfi.firstDate" /></td>
																	<td><div id="confirmFirstRbsDate"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.secondRbs" /></td>
																	<td><div id="confirmSecRbs"></div></td>
																	<td> <spring:message code="com.phfi.secondDate" /></td>
																	<td><div id="confirmSecRbsDate"></div></td>
																</tr>
																<tr>
																	<td><br/><spring:message code="com.phfi.testForMalaria" /></td>
																	<td><br/><div id="confirmMalariaStatus"></div></td>
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
																	<td> <spring:message code="com.phfi.secondDate" /></td>
																	<td><div id="confirmSecMalariaDate"></div></td>
																</tr>
																<tr>
																	<td><br/><spring:message code="com.phfi.sputumTestStatus" /></td>
																	<td><br/><div id="confirmSputumStatus"></div></td>
																</tr>
																<tr>
																	<td><spring:message code="com.phfi.firstSputumTest" /></td>
																	<td><div id="confirmFirstSputum"></div></td>
																	<td> <spring:message code="com.phfi.firstDate" /></td>
																	<td><div id="confirmFirstSputumDate"></div></td>
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
	
	<!--Body Wrapper block End -->
	<script type="text/javascript" src="../js_new/merchant.js"></script>
	<script type="text/javascript" src="../js_new/visitform.js"></script>
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
		
		$(".testdate").click(function() {
			$(this).children('.testDate').focus();
		});
		$('.testDate').datetimepicker({
			timepicker : false,
		    showOtherMonths: true,
		    selectOtherMonths: true,
		    changeMonth: true,
		    changeYear: true,
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
									".askTheWomen-circle-tab,.askTheWomenRest-circle-tab,.testResultFirst-circle-tab,.observe-circle-tab,.testResultSec-circle-tab,.testResultThird-circle-tab,.askTheFamily-circle-tab,.confirm-circle-tab")
									.removeClass("active-circle");
							$(".womenInfo-arrow").show();
							$(
									".askTheWomen-arrow,.askTheWomenRest-arrow,.observe-arrow,.testResultFirst-arrow,.testResultSec-arrow,.testResultThird-arrow,.askTheFamily-arrow,.confirm-arrow")
									.hide();
							$(".women-info-content").show();
							$(
									".askthewomefirst-content,.askthewomesec-content,.confirm-details-content,.observe-details-content,.testresultfirst-details-content,.testresultsec-details-content,.testresultthird-details-content,.askthefamily-content")
									.hide();
						});
		$(".askTheWomen-info-list,.women-next,.askTheWomenSec-prev")
				.click(
						function() {
							
							$(".askTheWomen-circle-tab").addClass(
									"active-circle");
							$(
									".womenInfo-circle-tab,.askTheWomenRest-circle-tab,.testResultFirst-circle-tab,.observe-circle-tab,.testResultSec-circle-tab,.testResultThird-circle-tab,.askTheFamily-circle-tab,.confirm-circle-tab")
									.removeClass("active-circle");
							$(".askTheWomen-arrow").show();
							$(
									".womenInfo-arrow,.askTheWomenRest-arrow,.observe-arrow,.testResultFirst-arrow,.testResultSec-arrow,.testResultThird-arrow,.askTheFamily-arrow,.confirm-arrow")
									.hide();
							$(".askthewomefirst-content").show();
							$(
									".women-info-content,.askthewomesec-content,.observe-details-content,.confirm-details-content,.testresultfirst-details-content,.testresultsec-details-content,.testresultthird-details-content,.askthefamily-content")
									.hide();
						});
		$(".askTheWomenRest-info-list,.askTheWomen-next,.observe-prev")
				.click(
						function() {
							
							$(".askTheWomenRest-circle-tab").addClass("active-circle");
							$(
									".womenInfo-circle-tab,.askTheWomen-circle-tab,.testResultFirst-circle-tab,.observe-circle-tab,.testResultSec-circle-tab,.testResultThird-circle-tab,.askTheFamily-circle-tab,.confirm-circle-tab")
									.removeClass("active-circle");
							$(".askTheWomenRest-arrow").show();
							$(
									".womenInfo-arrow,.askTheWomen-arrow,.observe-arrow,.testResultFirst-arrow,.testResultSec-arrow,.testResultThird-arrow,.askTheFamily-arrow,.confirm-arrow")
									.hide();
							$(".askthewomesec-content").show();
							$(
									".women-info-content,.askthewomefirst-content,.observe-details-content,.confirm-details-content,.testresultfirst-details-content,.testresultsec-details-content,.testresultthird-details-content,.askthefamily-content")
									.hide();
						});
		$(".observe-info-list,.askTheWomenSec-next,.testresultfirst-prev")
				.click(
						function() {
							
							$(".observe-circle-tab").addClass("active-circle");
							$(
									".womenInfo-circle-tab,.askTheWomen-circle-tab,.askTheWomenRest-circle-tab,.testResultFirst-circle-tab,.testResultSec-circle-tab,.testResultThird-circle-tab,.askTheFamily-circle-tab,.confirm-circle-tab")
									.removeClass("active-circle");
							$(".observe-arrow").show();
							$(
									".womenInfo-arrow,.askTheWomen-arrow,.askTheWomenRest-arrow,.testResultFirst-arrow,.testResultSec-arrow,.testResultThird-arrow,.askTheFamily-arrow,.confirm-arrow")
									.hide();
							$(".observe-details-content").show();
							$(
									".women-info-content,.askthewomefirst-content,.askthewomesec-content,.confirm-details-content,.testresultfirst-details-content,.testresultsec-details-content,.testresultthird-details-content,.askthefamily-content")
									.hide();
						});
		$(".testResultFirst-info-list,.observe-next,.testresultsec-prev")
				.click(
						function() {
							
							$(".testResultFirst-circle-tab").addClass(
									"active-circle");
							$(
									".womenInfo-circle-tab,.askTheWomen-circle-tab,.askTheWomenRest-circle-tab,.observe-circle-tab,.testResultSec-circle-tab,.testResultThird-circle-tab,.askTheFamily-circle-tab,.confirm-circle-tab")
									.removeClass("active-circle");
							$(".testResultFirst-arrow").show();
							$(
									".womenInfo-arrow,.askTheWomen-arrow,.askTheWomenRest-arrow,.observe-arrow,.testResultSec-arrow,.testResultThird-arrow,.askTheFamily-arrow,.confirm-arrow")
									.hide();
							$(".testresultfirst-details-content").show();
							$(
									".women-info-content,.askthewomefirst-content,.askthewomesec-content,.confirm-details-content,.observe-details-content,.testresultsec-details-content,.testresultthird-details-content,.askthefamily-content")
									.hide();
						});
		$(".testResultSec-info-list,.testresultfirst-next,.testresultthird-prev")
				.click(
						function() {
							
							$(".testResultSec-circle-tab")
									.addClass("active-circle");
							$(
									".womenInfo-circle-tab,.askTheWomen-circle-tab,.askTheWomenRest-circle-tab,.observe-circle-tab,.testResultFirst-circle-tab,.testResultThird-circle-tab,.askTheFamily-circle-tab,.confirm-circle-tab")
									.removeClass("active-circle");
							$(".testResultSec-arrow").show();
							$(
									".womenInfo-arrow,.askTheWomen-arrow,.askTheWomenRest-arrow,.observe-arrow,.testResultFirst-arrow,.testResultThird-arrow,.askTheFamily-arrow,.confirm-arrow")
									.hide();
							$(".testresultsec-details-content").show();
							$(
									".women-info-content,.askthewomefirst-content,.askthewomesec-content,.confirm-details-content,.observe-details-content,.testresultfirst-details-content,.testresultthird-details-content,.askthefamily-content")
									.hide();
						});
		
				$(".testResultThird-info-list,.testresultsec-next,.askthefamily-prev")
				.click(
						function() {
							
							$(".testResultThird-circle-tab")
									.addClass("active-circle");
							$(
									".womenInfo-circle-tab,.askTheWomen-circle-tab,.askTheWomenRest-circle-tab,.observe-circle-tab,.testResultFirst-circle-tab,.testResultSec-circle-tab,.askTheFamily-circle-tab,.confirm-circle-tab")
									.removeClass("active-circle");
							$(".testResultThird-arrow").show();
							$(
									".womenInfo-arrow,.askTheWomen-arrow,.askTheWomenRest-arrow,.observe-arrow,.testResultFirst-arrow,.testResultSec-arrow,.askTheFamily-arrow,.confirm-arrow")
									.hide();
							$(".testresultthird-details-content").show();
							$(
									".women-info-content,.askthewomefirst-content,.askthewomesec-content,.confirm-details-content,.observe-details-content,.testresultfirst-details-content,.testresultsec-details-content,.askthefamily-content")
									.hide();
						});
		
		
		
		
		$(".askTheFamily-info-list,.testresultthird-next,.confirm-prev")
				.click(
						function() {
							
							$(".askTheFamily-circle-tab").addClass(
									"active-circle");
							$(
									".womenInfo-circle-tab,.askTheWomen-circle-tab,.askTheWomenRest-circle-tab,.observe-circle-tab,.testResultFirst-circle-tab,.testResultSec-circle-tab,.testResultThird-circle-tab,.confirm-circle-tab")
									.removeClass("active-circle");
							$(".askTheFamily-arrow").show();
							$(
									".womenInfo-arrow,.askTheWomen-arrow,.askTheWomenRest-arrow,.observe-arrow,.testResultFirst-arrow,.testResultSec-arrow,.testResultThird-arrow,.confirm-arrow")
									.hide();
							$(".askthefamily-content").show();
							$(
									".women-info-content,.askthewomefirst-content,.askthewomesec-content,.confirm-details-content,.observe-details-content,.testresultfirst-details-content,.testresultsec-details-content,.testresultthird-details-content")
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
									".womenInfo-circle-tab,.askTheWomen-circle-tab,.askTheWomenRest-circle-tab,.observe-circle-tab,.testResultFirst-circle-tab,.testResultSec-circle-tab,.testResultThird-circle-tab,.askTheFamily-circle-tab")
									.removeClass("active-circle");
							$(".confirm-arrow").show();
							$(
									".womenInfo-arrow,.askTheWomen-arrow,.askTheWomenRest-arrow,.observe-arrow,.testResultFirst-arrow,.testResultSec-arrow,.testResultThird-arrow,.askTheFamily-arrow")
									.hide();
							$(".confirm-details-content").show();
							$(
									".women-info-content,.askthewomefirst-content,.askthewomesec-content,.observe-details-content,.testresultfirst-details-content,.testresultsec-details-content,.testresultthird-details-content,.askthefamily-content")
									.hide();
						});
	</script>
</body>
</html>