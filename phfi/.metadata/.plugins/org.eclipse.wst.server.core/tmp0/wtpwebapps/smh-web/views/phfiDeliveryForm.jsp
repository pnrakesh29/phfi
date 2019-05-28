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
									<li class="delivery-info-list">
										<div class="circle-div">
											<div class="hr"></div>
											<span class="delivery-circle-tab"></span>
										</div> <label><spring:message code="com.phfi.deliveryDetails" /></label>
										<div class="arrow-down delivery-arrow"></div>
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
					
						<!-- Page Form Start -->
						<form:form action="process-delivery-visit-form" commandName="phfiDeliveryFormRequest" name="phfiDeliveryFormRequest" method="POST">
							<div class="col-sm-12 paddingT20">
								<div class="row">
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
										<!-- delivery Details Content start -->
									<section class="field-element-row delivery-info-content" style="display: none;">
										<fieldset class="col-sm-12">
											<fieldset class="col-sm-6">
												<label><spring:message code="com.phfi.dateOfCurrentDelivery" /><span
													class="required-field">*</span></label>
											 </fieldset>
											 <fieldset class="col-sm-3">
												<div class="input-group registrationdate">
													<form:input cssClass="form-control regDate" path="deliveryDate"
														id="deliveryDate"
														onblur="return clientValidation('deliveryDate', 'required','deliveryDateErrorDiv')" />
													<span class="input-group-addon"><span
														class="glyphicon glyphicon-calendar"></span></span>
												</div>
												<div class="discriptionErrorMsg">
													<span id="deliveryDateErrorDiv" class="red-error">&nbsp;</span>
												</div>
											</fieldset>
										</fieldset>
										<fieldset class="col-sm-12">
											<fieldset class="col-sm-6">
												<label><spring:message code="com.phfi.pregnancyLast" /><span
													class="required-field">*</span></label>
											</fieldset>
											<fieldset class="col-sm-3">
												<form:input cssClass="form-control" path="pregnancyLast"
													id="pregnancyLast" maxlength="50"
													onblur="validatePreganencyLast('pregnancyLast','pregnancyLastErrorDiv')" />
												<div class="discriptionErrorMsg">
													<span id="pregnancyLastErrorDiv" class="red-error">&nbsp;</span>
												</div>
											</fieldset>
										</fieldset>
										<fieldset class="col-sm-12">
											<fieldset class="col-sm-6">
												<label><spring:message code="com.phfi.isBabyAlive" /><span
													class="required-field">*</span>
												</label>
											</fieldset>
											<fieldset class="col-sm-3">
												<input type="radio" id="isBabyAlive" name="isBabyAlive"
													value="Yes" ><spring:message code="com.phfi.yes" />&nbsp; <input
													type="radio" id="isBabyAlive" name="isBabyAlive" value="No"
													onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.no" />
												<div class="discriptionErrorMsg">
													<span id="isBabyAliveErrorDiv" class="red-error">&nbsp;</span>
												</div>
											</fieldset>
										</fieldset>
										<fieldset class="col-sm-12" >
											<fieldset class="col-sm-3">
												<label><spring:message code="com.phfi.placeOfDelivery" /> <span class="required-field">*</span></label>
												<form:select path="deliveryPlace" id="deliveryPlace" onchange="showDeliveryPlace()"
													onblur="return clientValidation('deliveryPlace', 'dropdownField','deliveryPlaceErrorDiv');"
													cssClass="form-control">
													<form:option value="">.:Please Select:.</form:option>
													<form:option value="Home"><spring:message code="com.phfi.home" /></form:option>
													<form:option value="Govt. Facility"><spring:message code="com.phfi.govtFacilities" /></form:option>
													<form:option value="Private nursing home/hospital"><spring:message code="com.phfi.private" /></form:option>
													<form:option value="Other" ><spring:message code="com.phfi.other" /></form:option>
												</form:select>
												<div class="discriptionErrorMsg">
													<span id="deliveryPlaceErrorDiv" class="red-error">&nbsp;</span>
												</div>
											</fieldset>
											<fieldset class="col-sm-3">
											</fieldset>
											<fieldset class="col-sm-3" id="otherDeliveryPlaceId">
												<label class="control-label"><spring:message code="com.phfi.anyOther" /><span
													class="required-field">*</span></label>
												<form:input cssClass="form-control" path="otherPlace"
													id="otherPlace"
													onblur="return clientValidation('otherPlace', 'alphanumericField','otherPlaceErrorDiv');" />
												<div class="discriptionErrorMsg">
													<span id="otherPlaceErrorDiv" class="red-error">&nbsp;</span>
												</div>
											</fieldset>
										</fieldset>
										<fieldset class="col-sm-12">
											<fieldset class="col-sm-6">
												<label><spring:message code="com.phfi.conductedTheDelivery" /><span
													class="required-field">*</span></label>
											</fieldset>
											<fieldset class="col-sm-6">
												<input type="checkbox" id="deliveryConductedBy"
													name="deliveryConductedBy" value="Govt. doctor"><spring:message code="com.phfi.govtDoctor" />&nbsp;<input type="checkbox"
													id="deliveryConductedBy" name="deliveryConductedBy"
													value="Govt. nurse"><spring:message code="com.phfi.govtNurse" />&nbsp; <input type="checkbox" id="deliveryConductedBy"
													name="deliveryConductedBy" value="Private doctor"
													onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.privateDoctor" />&nbsp; <input type="checkbox" id="deliveryConductedBy"
													name="deliveryConductedBy" value="Private nurse"
													onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.privateNurse" />&nbsp; <input type="checkbox" id="deliveryConductedBy"
													name="deliveryConductedBy" value="ANM"
													onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.anm" />&nbsp; <input type="checkbox" id="deliveryConductedBy"
													name="deliveryConductedBy" value="LVH"
													onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.lvh" />&nbsp; <input type="checkbox" id="deliveryConductedBy"
													name="deliveryConductedBy" value="RMP"
													onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.rmp" />
													&nbsp; <input type="checkbox" id="deliveryConductedBy"
													name="deliveryConductedBy" value="Dai"
													onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.dai" />
													&nbsp; <input type="checkbox" id="deliveryConductedBy"
													name="deliveryConductedBy" value="ASHA"
													onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.asha" />
													&nbsp; <input type="checkbox" id="deliveryConductedBy"
													name="deliveryConductedBy" value="Other"
													onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.other" />
												<div class="discriptionErrorMsg">
													<span id="deliveryConductedByErrorDiv" class="red-error">&nbsp;</span>
												</div>
											</fieldset>
										</fieldset>
										<fieldset class="col-sm-12">
											<fieldset class="col-sm-6">
												<label><spring:message code="com.phfi.typeOfDelivery" /><span
													class="required-field">*</span>
												</label>
											</fieldset>
											<fieldset class="col-sm-3">
												<input type="radio" id="deliveryType" name="deliveryType"
													value="Normal" ><spring:message code="com.phfi.normal" />&nbsp; <input
													type="radio" id="deliveryType" name="deliveryType" value="Caesarean"
													onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.caesarean" />
												<div class="discriptionErrorMsg">
													<span id="ultrasoundErrorDiv" class="red-error">&nbsp;</span>
												</div>
											</fieldset>
										</fieldset>
										<fieldset class="col-sm-12">
											<fieldset class="col-sm-6">
												<label><spring:message code="com.phfi.babyWeight" />(Kg):<span
													class="required-field">*</span></label>
											</fieldset>
											<fieldset class="col-sm-3">
												<form:input cssClass="form-control" path="babyWeight"
													id="babyWeight" maxlength="50"
													onblur="validateBabyWeight('babyWeight','babyWeightErrorDiv')" />
												<div class="discriptionErrorMsg">
													<span id="babyWeightErrorDiv" class="red-error">&nbsp;</span>
												</div>
											</fieldset>
										</fieldset>
										<fieldset class="col-sm-12">
											<fieldset class="col-sm-6">
												<label><spring:message code="com.phfi.bleedingAfterDelivery" /><span
													class="required-field">*</span>
												</label>
											</fieldset>
											<fieldset class="col-sm-3">
												<input type="radio" id="isExcessiveBleeding" name="isExcessiveBleeding"
													value="Yes" ><spring:message code="com.phfi.yes" />&nbsp; <input
													type="radio" id="isExcessiveBleeding" name="isExcessiveBleeding" value="No"
													onblur="validateRadio()">&nbsp;&nbsp;<spring:message code="com.phfi.no" />
												<div class="discriptionErrorMsg">
													<span id="isExcessiveBleedingErrorDiv" class="red-error">&nbsp;</span>
												</div>
											</fieldset>
										</fieldset>

										<!--Panel Action Button Start -->
										<div class="col-sm-12 button-content">
											<fieldset class="col-sm-7 pull-right">
												<input type="button"
													class="form-control button pull-right delivery-next"
													value="Continue"> <input type="button"
													class="form-control button pull-right marginL10 delivery-prev"
													value="Previous"> <input type="button"
													class="form-control button pull-right marginL10"
													value="Reset" onclick="">
												<input type="button"
													class="form-control button pull-right marginL10"
													value="Cancel" onclick="cancel()">
											</fieldset>
										</div>
										<!--Panel Action Button End -->

									</section>
									<!-- delivery Details Content End -->
									
										<!-- Confirmation Content Start -->
											<section class="field-element-row confirm-details-content" style="display: none;">
												<fieldset class="col-sm-12" style="padding: 0;">
													<fieldset class="col-sm-6">
														<fieldset class="fieldset registration-content">
															<legend class="legend"><spring:message code="com.phfi.womanInfo" />
															</legend>
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
																	<td><spring:message code="com.phfi.nameOfTheWoman" /></td>
																	<td><div id="confirmWomanName"></div></td>
																</tr>
															</table>
														</fieldset>
													</fieldset>
												
													<fieldset class="col-sm-6">
														<fieldset class="fieldset registration-content">
															<legend class="legend"><spring:message code="com.phfi.deliveryDetails" /></legend>
															<table class="confirm-info-table">
																<tr>
																	<td style="min-width: 328px"><spring:message code="com.phfi.dateOfCurrentDelivery" /></td>
																	<td ><div id="confirmDateOfDelivery"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 328px"><spring:message code="com.phfi.pregnancyLast" /></td>
																	<td><div id="confirmPregnancyLast"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 328px"><spring:message code="com.phfi.isBabyAlive" /></td>
																	<td><div id="confirmBabyStatus"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 328px"><spring:message code="com.phfi.placeOfDelivery" /></td>
																	<td><div id="confirmDelveryPlace"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 328px"><spring:message code="com.phfi.conductedTheDelivery" /></td>
																	<td><div id="confirmDeliveryConductedBy"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 328px"><spring:message code="com.phfi.typeOfDelivery" /></td>
																	<td><div id="confirmDeliveryType"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 328px"><spring:message code="com.phfi.babyWeight" /></td>
																	<td><div id="confirmBabyWeight"></div></td>
																</tr>
																<tr>
																	<td style="min-width: 328px"><spring:message code="com.phfi.bleedingAfterDelivery" /></td>
																	<td><div id="confirmBleedingAfetrDelivery"></div></td>
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