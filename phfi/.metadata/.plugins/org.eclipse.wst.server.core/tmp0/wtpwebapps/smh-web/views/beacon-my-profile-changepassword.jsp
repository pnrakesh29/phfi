<!doctype html>
<%@ page import="com.smh.constants.JspConstants"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<script src="../js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../js/bootstrap.min.js"></script>
</head>
<body>
	<!--Body Wrapper block Start -->
	<div id="wrapper">
		<!--Container block Start -->
		<div class="container-fluid">
			<!--Header Block Start -->
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
						<span class="glyphicon glyphicon-play icon-font-size"></span> 
						<span class="breadcrumb-text">Change Password </span>
					</div>
					<!-- Breadcrumb End -->
					<!-- Tab Buttons Start -->
					<div class="tab-header-container"
							style="margin-left: 34px">
							<a href="beacon-my-profile">My Profile</a>
						</div>
					<div class="tab-header-container active-background">
						<a href="#">Change Password</a>
					</div>
					<!-- Tab Buttons End -->
					<!-- Content Block Start -->
					<div class="main-content-holder">
						<div class="row">
							<div class="col-sm-12">
								<!--Article Block Start-->
								<article>
									<div class="col-xs-3"></div>
									<div class="col-xs-6 login-page-content">
										<h3>Change Password</h3>
										<div class="row">
											<div class="col-sm-12">
												<!--Success and Failure Message Start-->
												<div class="col-xs-12">
													<div class="discriptionErrorMsg">
														<span class="green-error" id="sucessDiv">${sucess}</span>
														<span class="red-error" id="errorDiv">${error}</span>
													</div>
												</div>
												<!--Success and Failure Message End-->
												<!-- Page Form Start -->
												<form:form action="process-user-profile-change-password" commandName="changeAdminPasswordRequest" method="post">
													<div class="col-sm-12 login-elements-holder">
														<fieldset class="col-sm-12">
															<div class="input-group">
																<span class="input-group-addon"><img
																	src="../images/pass_icon.png"></span> <input
																	type="password" class="form-control" maxlength="<%= JspConstants.PASSWORD_MAXLEN %>"
																	placeholder="Current Password" id="currentPassword"
																	name="oldPass"
																	onblur="validateCurrentPassword()" />
															</div>
															<div class="discriptionErrorMsg">
																<span class="red-error" id="currentPassErr">&nbsp;</span>
															</div>
														</fieldset>
														<fieldset class="col-sm-12">
															<div class="input-group">
																<span class="input-group-addon"><img
																	src="../images/pass_icon.png"></span> <input
																	type="password" class="form-control" maxlength="<%= JspConstants.PASSWORD_MAXLEN %>"
																	placeholder="New Password" id="newPassword"
																	name="newPass" onblur="validateNewPassword()" />
															</div>
															<div class="discriptionErrorMsg">
																<span class="red-error" id="newPassErr">&nbsp;</span>
															</div>
														</fieldset>

														<fieldset class="col-sm-12">
															<div class="input-group">
																<span class="input-group-addon"><img
																	src="../images/pass_icon.png"></span> <input
																	type="password" class="form-control" placeholder="Confirm Password" id="confirmPassword"  maxlength="<%= JspConstants.PASSWORD_MAXLEN %>"
																		onblur="validateConfirmPassword()"/>
															</div>
															<div class="discriptionErrorMsg">
																<span class="red-error" id="confirmPassErr">&nbsp;</span>
															</div>
														</fieldset>
													</div>
													<!--login Action Button Start -->
													<div class="col-sm-12 login-elements-holder">
														<div class="col-sm-6">
															<a href="beacon-my-profile"
																class="form-control button login-main-button">Cancel</a>
														</div>
														<div class="col-sm-6">
															<input type="submit"
																class="form-control button login-main-button"
																value="Submit"  id="myButton" onclick="return validateChangePassword()">
														</div>
													</div>
													<!--login Action Button End -->
												</form:form>
											</div>
										</div>
									</div>
									<div class="col-xs-3"></div>
								</article>
								<!--Article Block End-->
								
							</div>
							<!--Container block End -->
						 </div>
						</article>
						<footer class="footer">
						<jsp:include page="footer.jsp"></jsp:include>
						</footer>
					  </div>
					</div>
					<!--Body Wrapper block End -->
					<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
						
					<!-- Include all compiled plugins (below), or include individual files as needed -->
					<script src="../js/bootstrap.min.js"></script>
					
					<script src="../js/common-lib.js"></script>
					<script src="../js/profile.js" type="text/javascript"></script>

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
		
		/* Start restrict copy,paste,cut operation on currentPassword,newPassword,confirmPassword*/
		/* $('#currentPassword,#newPassword,#confirmPassword').bind('copy paste cut', function (e) {
             e.preventDefault();
          }); */
		/*End restrict copy,paste,cut operation on useranem,securityQuestion,securityAnswer*/
	</script>
</body>
</html>
