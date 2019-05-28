<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.smh.constants.JspConstants"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>PHFI</title>
<link rel="icon" href="../images/favicon.png" type="image/png">
<!-- Bootstrap -->
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/style.css" rel="stylesheet">
<link href="../css/jquery.datetimepicker.css" rel="stylesheet"
	type="text/css" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../js/bootstrap.min.js"></script>
<script src="../js/messages.js"></script>
<!-- validation (all field validations) -->
<!-- common-lib -->


</head>
<body>
	<!--Body Wrapper block Start -->
	<div id="wrapper">
		<!--Container block Start -->
		<div class="container-fluid">
			<!--Header Block End -->
			<!--Navigation Block Start -->
			<%@include file="navigation.jsp"%>
			<!--Navigation Block End -->
			<!--Article Block Start-->
			<article>

				<div class="col-xs-12 content-wrapper">
					<!-- Breadcrumb start -->
					<div class="breadCrumb">
						<span class="breadcrumb-text">Dashboard </span> 
						<span class="glyphicon glyphicon-play icon-font-size"></span> 
						<span class="breadcrumb-text">My Profile </span> 
					</div>
					<!-- Breadcrumb End -->
					<!-- Tab Buttons Start -->
					<c:if test="${fn:contains(existingFeatures,myProfileView)}">
						<div class="tab-header-container active-background"
							style="margin-left: 34px">
							<a href="#">My Profile</a>
						</div>
					</c:if>
					<c:if test="${fn:contains(existingFeatures,changePassword)}">
						<div class="tab-header-container">
							<a href="my-profile-changepassword">Change Password</a>
						</div>
					</c:if>
					<%-- <c:if test="${fn:contains(existingFeatures,changeSecurityKey)}">
						<div class="tab-header-container">
							<a href="changeSecurityKey">Change Security Key</a>
						</div>
					</c:if>

					<c:if
						test="${fn:contains(existingFeatures,changeSecurityQuestion)}">
						<div class="tab-header-container">
							<a href="changeSecurityQuestion">Change Security Question</a>
						</div>
					</c:if> --%>
					<!-- Tab Buttons End -->
					<!-- Content Block Start -->
					<div class="main-content-holder">
						<div class="row">
							<div class="col-sm-12">
								<!--Success and Failure Message Start-->
								<div class="col-xs-12">
									<div class="discriptionErrorMsg">
										<span class="green-error" id="successDiv">${success}</span> <span
											class="red-error" id="errorDiv">${error}</span>
									</div>
								</div>
								<!--Success and Failure Message End-->
								<!-- Page Form Start -->
								<form:form modelAttribute="adminUserRequest" method="post" action="process-chatak-admin-user-profile-edit">
									 <form:hidden path="adminUserId" />
									<%---><form:hidden path="userType" /> --%>
									<div class="col-sm-12">
										<div class="row">
											<div class="field-element-row">
											
												<fieldset class="col-sm-4">
													<label>User Name<span class="required-field">*</span></label>
													<form:input path="userName" id="userName"
														cssClass="form-control" readonly="true" onblur="validateUserName()" />
													<div class="discriptionErrorMsg">
														<span class="red-error"  id="userNameErr" >&nbsp;</span>
													</div>
												</fieldset>
												
												<fieldset class="col-sm-4">
													<label>First Name<span class="required-field">*</span></label>
													<form:input cssClass="form-control" path="firstName" id="firstName" readonly="true"
														onblur="validateFirstName()" />
													<div class="discriptionErrorMsg"  >
														<span class="red-error" id="firstNameErr">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-4">
													<label>Last Name<span class="required-field">*</span></label>
													<form:input cssClass="form-control" path="lastName" id="lastName" readonly="true"
														  onblur="validateLastName()"/>
													<div class="discriptionErrorMsg">
														<span class="red-error" id="lastNameErr">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-4"> 
													<label>Contact Number<span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="phone" id="phone" title="Phone"  onblur="validatePhone()"
												 			readonly="true" maxlength="<%=JspConstants.PHONE_MAXLEN %>" />
												 	<div class="discriptionErrorMsg">
														<span class="red-error" id="phoneErr">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-4">
													<label>Security Question<span class="required-field">*</span></label>
													<form:input cssClass="form-control" path="securityQuestion" id="securityQuestion" readonly="true"
														onblur="validateSecurityQuestion()" />
													<div class="discriptionErrorMsg">
														<span class="red-error" id="securityQuestionErr">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-4">
													<label>Security Answer<span class="required-field">*</span></label>
													<form:password cssClass="form-control" path="securityAnswer" id="securityAnswer" readonly="true" showPassword="true" 
													autocomplete="off"	onblur="validateSecurityAnswer()" />
													<div class="discriptionErrorMsg">
														<span class="red-error" id="securityAnswerErr">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-4">
													<label>E-mail ID<span class="required-field">*</span></label>
													<form:input cssClass="form-control" path="email" id="email" readonly="true"
														onblur="validateEmail()" />
													<div class="discriptionErrorMsg">
														<span class="red-error" id="emailErr">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-4">
													<label>Status<span class="required-field">*</span></label>
													<form:input cssClass="form-control" path="status" id="status" readonly="true" />
													<div class="discriptionErrorMsg">
														<span class="red-error" id="statusErr">&nbsp;</span>
													</div>
												</fieldset>
											</div>
										</div>

										<!--Panel Action Button Start -->
										<div class="col-sm-12 form-action-buttons">
											<div class="col-sm-5"></div>
											<div class="col-sm-7">

												<input type="button" class="form-control button pull-right"
													value="Edit" id="myButton" onclick="resetErrorsMsg()">
												<input type="submit" class="form-control button pull-right"
													onclick="return validateEdit()" value="Update" id="myupdate"> 
													<a href="beacon-my-profile" class="form-control button pull-right" id="myCancel">Cancel</a>
												<!-- <a href="show-myprofile-changePassword" class="form-control button button30 pull-right">ChangePassword</a>
													<a href="/myprofile-changePassword" ><input type="submit" class="form-control button button30 pull-right" value="ChangePassword"></a>  -->
											</div>
										</div>

										<!--Panel Action Button End -->
									</div>
								</form:form>
								<!-- Page Form End -->
							</div>
						</div>
					</div>
					<!-- Content Block End -->
				</div>
			</article>
			<!--Article Block Start-->
			<footer class="footer">
			<jsp:include page="footer.jsp"></jsp:include>
			</footer>
		</div>
		<!--Container block End -->
	</div>
	<!--Body Wrapper block End -->
	<script type="text/javascript">
	$(document).ready(function() {
		$( "#navListId1" ).addClass( "active-background" );
		$('#myupdate').hide();
		$('#myCancel').hide();
		$('#myButton').show();
	});
	</script>
	<script>		
		/* Select li full area function Start */
		$("li").click(function(){
			window.location=$(this).find("a").attr("href"); 
			return false;
		});
		/* Select li full area function End */	
		
		/* Common Navigation Include Start */
		$(function() {
			$("#main-navigation").load("main-navigation.html");
		});
		function highlightMainContent() {
			$("#navListId1").addClass("active-background");
		}
		/* Common Navigation Include End */
		

		$("#myButton").click(function(event) {
			$('#myupdate').show();
			$('#myCancel').show();
			$('#myButton').hide();
			$('#firstName').attr('readonly', false);
			$('#lastName').attr('readonly', false);
			$('#email').attr('readonly', false);
			$('#phone').attr('readonly', false);
			$('#securityAnswer').attr('readonly', false);
			$('#securityQuestion').attr('readonly', false);
			
		});
		/*start making  fields editable when user want to edit his profile */
	</script>
	<script src="../js/user.js"></script>	
	<script src="../js/jquery.maskedinput.js"></script>
	<script src="../js/jquery.popupoverlay.js"></script>
	<script src="../js/common-lib.js"></script>
	<script type="text/javascript">
		$("#phone").mask("999-999-9999");
	</script>
</body>
</html>