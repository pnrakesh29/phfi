
<!doctype html>

<%@page import="com.smh.constants.JspConstants"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
	<meta charset="utf-8">
    <meta http-equiv="" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>PHFI</title>
    <link rel="icon" href="../images/smh.PNG" type="image/png">
    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">    
    <script src="../js/login.js" type="text/javascript"></script>
	<script src="../js/backbutton.js" type="text/javascript"></script>
</head>

<body oncontextmenu="disableRightClick()">
<br>
<br>
<br>
<div align="right">
<%
	String lang = request.getParameter("locale");
%>
<select id="dynamic_select">
	<% if("hi_IN".equalsIgnoreCase(lang)){%>
	 	<option value="http://localhost:8086/smh-web/sp/login?locale=en"  >--select--</option>
	    <option value="http://localhost:8086/smh-web/sp/login?locale=en"  >English</option>
	    <option value="http://localhost:8086/smh-web/sp/login?locale=hi_IN" selected="selected">Hindi</option>
	    <option value="http://localhost:8086/smh-web/sp/login?locale=ka_IN">Kannada</option>
    <% }else if("ka_IN".equalsIgnoreCase(lang)){%>
    	<option value="http://localhost:8086/smh-web/sp/login?locale=en"  >--select--</option>
	    <option value="http://localhost:8086/smh-web/sp/login?locale=en"  >English</option>
	    <option value="http://localhost:8086/smh-web/sp/login?locale=hi_IN">Hindi</option>
	    <option value="http://localhost:8086/smh-web/sp/login?locale=ka_IN" selected="selected">Kannada</option>
    <%}else if("en".equalsIgnoreCase(lang)){ %>
    	<option value="http://localhost:8086/smh-web/sp/login?locale=en"  >--select--</option>
	    <option value="http://localhost:8086/smh-web/sp/login?locale=en" selected="selected">English</option>
	    <option value="http://localhost:8086/smh-web/sp/login?locale=hi_IN" >Hindi</option>
	    <option value="http://localhost:8086/smh-web/sp/login?locale=ka_IN">Kannada</option>
    <%}else{ %>
    	<option value="http://localhost:8086/smh-web/sp/login?locale=en" selected="selected" >--select--</option>
	    <option value="http://localhost:8086/smh-web/sp/login?locale=en" >English</option>
	    <option value="http://localhost:8086/smh-web/sp/login?locale=hi_IN" >Hindi</option>
	    <option value="http://localhost:8086/smh-web/sp/login?locale=ka_IN">Kannada</option>
    <%} %>
</select>
</div>
	<!--Body Wrapper block Start -->	
    <div id="wrapper">
		<!--Container block Start -->
		<div class="container-fluid marginT15" style="margin-top: 0px;">
			<!--Header Block Start -->
			<header class="col-sm-12 login-page-main">
				<!--Header Logo Start -->
				<div class="col-sm-4">
				</div>	
				<div class="col-sm-6"> 
					<img src="../images/smh.PNG" class="login-logo-size" height="81px" width="100px" alt="Logo"/>
				</div>
				<!--Header Logo End -->	
			</header>
			<!--Header Block End -->			
			<!--Article Block Start-->
			<article >
				<div class="col-xs-3"></div>
				<div class="col-xs-6 content-wrapper login-page-content loginSize">
					<!-- <h3>Login</h3> -->
					<h3><spring:message code="login"/></h3>
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
							<form:form action="show-dashboard" commandName="login" method="post">
								<div class="col-sm-12  login-elements-holder paddingL15">									
										
									<fieldset class="col-sm-10">
										<div class="input-group">
											<span class="input-group-addon"><img src="../images/user_icon.png"></span>
											<input type="text" class="form-control" id="spUser" maxlength="<%= JspConstants.USER_NAME_MAXLEN %>" name="spUser" 
											placeholder="Username" value="" onkeypress="setDiv('loginError', '');setDiv('spUserErr', '');" autocomplete="off"
											onblur="validateUser()">
											
										</div>	
										<div class="discriptionErrorMsg">
											<span class="red-error" id="spUserErr">${userNameValue}</span>
										</div> 
									</fieldset>									
								</div>
								<div class="col-sm-12 login-elements-holder paddingL15">									
									<fieldset class="col-sm-10"> 																					
										<div class="input-group">
											<span class="input-group-addon"><img src="../images/pass_icon.png"></span>
											<input type="password" value="" class="form-control" id="spPass" name="spPass" placeholder="Password"
											 maxlength="<%=JspConstants.PASSWORD_MAXLEN %>" onblur="validatePassword()"  onkeypress="setDiv('loginError', '');setDiv('passwordError', '');">
										</div>
										<div class="discriptionErrorMsg">
											<span class="red-error" id="passwordError"> ${passwordValue}</span>
										</div> 
									</fieldset>									
								</div>
								<!--login Action Button Start -->
								<div class="col-sm-12 login-elements-holder paddingL6">																		
									 <div class="col-sm-6">
										<a href="beacon-forgot-password" class="login-anchor-tag">Forgot Password?</a>										
									</div> 
									<div class="col-sm-3 ">&nbsp;</div>
									<div class="col-sm-6">
										<input type="submit"  value="Login" class="form-control1 button login-main-button width65P" onclick="return validateSave()" id="loginSubmit">
									</div>	
									<div class="col-sm-3 ">&nbsp;</div>
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
	    $("document").ready(function() {
		$('#dynamic_select').on('change', function () {
	          var url = $(this).val(); // get selected value
	          if (url) { // require a URL
	              window.location = url; // redirect
	          }
	          return false;
	      });
	    });
	</script>
  </body>  
</html>