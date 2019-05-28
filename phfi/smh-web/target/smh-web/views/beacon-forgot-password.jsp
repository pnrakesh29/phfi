<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.smh.constants.JspConstants"%>

<!DOCTYPE html>
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
     <script src="../js/jquery.js"></script>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body <%-- oncontextmenu="disableRightClick(<%=AdminConstants.ALLOW_RIGHT_CLICK%>)" --%>>
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
					<img class="login-logo-size" src="../images/logo.jpg"  alt="Logo"/>
				</div>
				<!--Header Logo End -->	
			</header>
			<!--Header Block End -->			
			<!--Article Block Start-->
			<article >
				<div class="col-xs-3"></div>
				<div class="col-xs-6 content-wrapper login-page-content loginSize">
					<h3>Forgot Password</h3>
					<div class="row">
						<div class="col-sm-12">
							<!--Success and Failure Message Start-->
							<div class="col-xs-12">
									<span class="green-error" id="green-error-hide">${success}</span> <span
										class="red-error" id="red-error-hide">${error}</span>
									
								</div>
							<!--Success and Failure Message End-->
							<!-- Page Form Start -->
							<form:form action="forgotPassword"  commandName="adminForgotPasswordRequest"  name="forgotPassword" method="post">
								<div class="col-sm-12 login-elements-holder paddingL15">									
									<fieldset class="col-sm-10">
										<div class="input-group">
											<span class="input-group-addon"><img src="../images/user_icon.png"></span>
											<input type="text" class="form-control"  placeholder="Username"  id="userName" name="userName" onblur="validateUserName();fetchSecurityQuestion()"/>
										</div>	
										<div class="discriptionErrorMsg" id="userNameErr">
											<span class="red-error" >&nbsp;</span>
										</div> 
									</fieldset>
									<fieldset class="col-sm-10">
									<label>Security Question</label>
									
										<div  id="securityQuestion">${securityQuestion}</div>
										<span>&nbsp;</span>
									</fieldset>
									<fieldset class="col-sm-10">
										<input  type="password" class="form-control" placeholder="Security Answer" name="securityAnswer" id="securityAnswer" onblur="validateSecurityAnswer()"/>
										<div class="discriptionErrorMsg" id="securityAnswerErr">
											<span class="red-error" >&nbsp;</span>
										</div> 
									</fieldset>
								</div>								
								<!--login Action Button Start -->
								<div class="col-sm-12 login-elements-holder paddingL10P">																		
									<div class="col-sm-6">
										<a href="login" class="form-control button login-main-button width82P">Cancel</a>									
									</div>
									<div class="col-sm-6">
										<input type="submit" class="form-control button login-main-button width83P" value="Submit" onclick="return validateSubmit()">
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
   
  
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../js/bootstrap.min.js"></script>
    	<script src="../js/common-scripts.js"></script>
     <script src="../js/common-lib.js"></script>	
    <script src="../js/beacon-password.js" type="text/javascript"></script>
    
	<script>		
		/* Select li full area function Start */
		$("li").click(function(){
			window.location=$(this).find("a").attr("href"); 
			return false;
		});
		/* Select li full area function End */		
		/* Start restrict copy,paste,cut operation on useranem,securityQuestion,securityAnswer*/
		$('#userName,#securityQuestion,#securityAnswer').bind('copy paste cut', function (e) {
              e.preventDefault();
          });
		/*End restrict copy,paste,cut operation on useranem,securityQuestion,securityAnswer*/
	</script>
  </body>  
</html>