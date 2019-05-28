
<!doctype html>

<%@page import="com.smh.constants.JspConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html lang="en">
<head>
	<meta charset="utf-8">
    <meta http-equiv="" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>PHFI</title>
    <link rel="icon" href="../images/favicon.png" type="image/png">
    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <script src="../js/login.js" type="text/javascript"></script>
	<script src="../js/backbutton.js" type="text/javascript"></script>
</head>

<body oncontextmenu="disableRightClick()">
	<!--Body Wrapper block Start -->	
    <div id="wrapper">
		<!--Container block Start -->
		<div class="container-fluid marginT15">
			<!--Header Block Start -->
			<header class="col-sm-12 login-page-main">
				<!--Header Logo Start -->
				<div class="col-sm-4">
				</div>	
				<div class="col-sm-6"> 
					<img src="../images/chatak_logo.jpg" class="login-logo-size" alt="Logo"/>
				</div>
				<!--Header Logo End -->	
			</header>
			<!--Header Block End -->			
			<!--Article Block Start-->
			<article >
				<div class="col-xs-3"></div>
				<div class="col-xs-6 content-wrapper login-page-content loginSize">
					<h3>Reset Password</h3>
					<div class="row">
						<div class="col-sm-12">
							<!--Success and Failure Message Start-->
							<div class="col-xs-12">
								<div class="discriptionErrorMsg">
								<span class="green-error" id="sucessDiv">${success}</span>
									<span id="loginError" class="red-error">${error}</span>
								</div>
							</div>
							<!--Success and Failure Message End-->
							<!-- Page Form Start -->
							<form:form action="processResetPassword"  commandName="changeAdminPasswordRequest"  name="forgotPassword" method="post">
								<div class="col-sm-12 login-elements-holder paddingL15">									
									<fieldset class="col-sm-10"> 																					
										<div class="input-group">
											<span class="input-group-addon"><img src="../images/pass_icon.png"></span>
											<input type="password" class="form-control"  placeholder="Current Password"  id="oldPass" name="oldPass" maxlength="<%= JspConstants.PASSWORD_MAXLEN %>" onblur="validateCurrentPassword()"/>
										</div>
										<div class="discriptionErrorMsg">
											<span class="red-error" id="currentPassErr"></span>
										</div> 
									</fieldset>									
								</div>
								<div class="col-sm-12 login-elements-holder paddingL15">									
									<fieldset class="col-sm-10"> 																					
										<div class="input-group">
											<span class="input-group-addon"><img src="../images/pass_icon.png"></span>
											<input type="password" class="form-control"  placeholder="New Password"  maxlength="<%= JspConstants.PASSWORD_MAXLEN %>"  id="newPass" name="newPass" onblur="validateNewPassword()"/>
										</div>
										<div class="discriptionErrorMsg">
											<span class="red-error" id="newPassErr"></span>
										</div> 
									</fieldset>									
								</div>
								<div class="col-sm-12 login-elements-holder paddingL15">									
									<fieldset class="col-sm-10"> 																					
										<div class="input-group">
											<span class="input-group-addon"><img src="../images/pass_icon.png"></span>
											<input type="password" class="form-control"  placeholder="Confirm Password"  maxlength="<%= JspConstants.PASSWORD_MAXLEN %>"  id="confirmPass" name="confirmPass" onblur="validateConfirmPassword();confirmPassword()"/>
										</div>
										<div class="discriptionErrorMsg">
											<span class="red-error" id="confirmPassErr"></span>
										</div> 
									</fieldset>									
								</div>
								<div class="col-sm-12 login-elements-holder paddingL15">									
									<fieldset class="col-sm-10"> 																					
										<div class="input-group">
											<span class="input-group-addon"><img src="../images/pass_icon.png"></span>
											<input type="text" name="securityQuestion" maxlength="<%= JspConstants.SECURITY_QUESTION%>" title="securityQuestion" id="securityQuestion" placeholder="Security Question" autocomplete="off" class="form-control" onblur="validateSecurityQuestion()"/>
										</div>
										<div class="discriptionErrorMsg">
											<span class="red-error" id="securityQuestionErr"></span>
										</div> 
									</fieldset>									
								</div>
								<div class="col-sm-12 login-elements-holder paddingL15">									
									<fieldset class="col-sm-10"> 																					
										<div class="input-group">
											<span class="input-group-addon"><img src="../images/pass_icon.png"></span>
											<input type="password" name="securityAnswer" maxlength="<%= JspConstants.SECURITY_ANSWER%>" title="securityAnswer" id="securityAnswer" placeholder="Security Answer" autocomplete="off" class="form-control" onblur="validateSecurityAnswer()"/>
										</div>
										<div class="discriptionErrorMsg">
											<span class="red-error" id="securityAnswerErr"></span>
										</div> 
									</fieldset>									
								</div>
								<!--login Action Button Start -->
								<div class="col-sm-12 login-elements-holder paddingL10P">																		
									<div class="col-sm-6">
										<a href="login" class="form-control button login-main-button width82P">Cancel</a>									
									</div>
									<div class="col-sm-6">
										<input type="submit" class="form-control button login-main-button" value="Submit" onclick="return validateResetPassword();">
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
			<footer class="footer">
			<jsp:include page="footer.jsp"></jsp:include>
			</footer>
		</div>
		<!--Container block End -->
	</div>
	<!--Body Wrapper block End -->	

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../js/login.js"></script>
    <script src="../js/bootstrap.min.js"></script>    
    <script src="../js/backbutton.js" type="text/javascript"></script>
    <script src="../js/common-lib.js"></script>
    <script src="../js/beacon-password.js"></script>
	<script>		
		/* Select li full area function Start */
		$("#spUser").focus();
		$("li").click(function(){
			window.location=$(this).find("a").attr("href"); 
			return false;
		});
		/* Select li full area function End */	
		$('#loginUser,#loginPass').bind('copy paste cut', function (e) {
         e.preventDefault();
      });
	</script>
  </body>  
</html>