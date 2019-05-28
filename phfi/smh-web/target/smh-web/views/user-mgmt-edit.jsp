<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="com.smh.constants.JspConstants"%>
<%@ page contentType="text/html;charset=UTF-8" %>

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
    <link href="../css/jquery.datetimepicker.css" rel="stylesheet"
	type="text/css" />
     <script src="../js/jquery.min.js"></script>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<!--Body Wrapper block Start -->	
    <div id="wrapper">
		<!--Container block Start -->
		<div class="container-fluid">
			<!--Navigation Block Start --> 
			<jsp:include page="navigation.jsp"></jsp:include>
			<!--Navigation Block End -->    			
			<!--Article Block Start-->
			<article>
				<div class="col-xs-12 content-wrapper">					
					<!-- Breadcrumb start -->
					<div class="breadCrumb">											
						<span class="breadcrumb-text">Set Up </span> <span
							class="glyphicon glyphicon-play icon-font-size"></span> <span
							class="breadcrumb-text">User </span> <span
							class="glyphicon glyphicon-play icon-font-size"></span> <span
							class="breadcrumb-text">Edit </span>					
					</div>
					<!-- Breadcrumb End -->
					<!-- Tab Buttons Start -->
					<div class="tab-header-container-first">
						<a href="user-mgmt-search">Search</a>					
					</div>
					<div class="tab-header-container active-background">
						<a href="#">Edit</a>
					</div>
					<!-- Tab Buttons End -->
					<!-- Content Block Start -->
					<div class="main-content-holder">
						<div class="row">
							<div class="col-sm-12">
								<!--Success and Failure Message Start-->
								<div class="col-xs-12">
									<div class="discriptionErrorMsg">
										<span class="green-error" id="sucessDiv">${success}</span>
										<span class="red-error" id="errorDiv">${error}</span>
									</div>
								</div>
								<!--Success and Failure Message End-->
								<!-- Page Form Start -->
								<form:form action="process-user-mgmt-edit" commandName="adminUserRequest">
									<form:hidden  path="adminUserId" id="adminUserId"/>
									<div class="col-sm-12">
										<div class="row">
											<div class="field-element-row">	
																						
												<%-- <fieldset class="col-sm-4"> 
													<label class="control-label" for="">Entity Type<span class="required-field">*</span></label>
													<form:select cssClass="form-control" title="Entity Type" id="userType" path="userType" onchange="fetchRoles()" >
															<form:option value="">.:Select:.</form:option>
														   <c:forEach items="${roleLevelList}" var="roleLevelList">
														         <form:option value="${roleLevelList.name()}">${roleLevelList.value}</form:option>
													        </c:forEach>
													</form:select>
													<div class="discriptionErrorMsg">
														<span id="userTypeErr" class="red-error">&nbsp;</span>
													</div> 
												</fieldset>		 --%>
												
												<fieldset class="col-sm-4"> 
													<label class="control-label" for="">Role Name<span class="required-field">*</span></label>
													<form:input path="roleName" title="Role" id="userRoleId" readonly="true"
														cssClass="form-control"  maxlength="<%=JspConstants.NAME_MAXLEN %>"/>
													<div class="discriptionErrorMsg">
														<span id="userRoleIdErr" class="red-error">&nbsp;</span>
													</div> 
												</fieldset>		
												
												<fieldset class="col-sm-4"> 
													<label class="control-label" for="">User Name<span class="required-field">*</span></label>
													<form:input path="userName" title="User Name" id="userName" cssClass="form-control" onblur="validateUserName()"
												                maxlength="<%=JspConstants.NAME_MAXLEN.toString()%>" />
													<div class="discriptionErrorMsg">
														<span id="userNameErr" class="red-error">&nbsp;</span>
													</div> 
												</fieldset>
												
												<fieldset class="col-sm-4">
													<label class="control-label" for="">First Name<span class="required-field">*</span></label>
													<form:input path="firstName" title="First Name" id="firstName" onblur="validateFirstName()" cssClass="form-control"
														maxlength="<%=JspConstants.NAME_MAXLEN.toString()%>" />
														<div class="discriptionErrorMsg">
														<span id="firstNameErr" class="red-error">&nbsp;</span>
													</div> 
												</fieldset>
												
												<fieldset class="col-sm-4">
													<label class="control-label" for="">Last Name<span class="required-field">*</span></label>
													<form:input path="lastName" title="Last Name" id="lastName" onblur="validateLastName()" cssClass="form-control"
														maxlength="<%=JspConstants.NAME_MAXLEN.toString()%>" />
														<div class="discriptionErrorMsg">
														<span id="lastNameErr" class="red-error">&nbsp;</span>
													</div> 
												</fieldset>
												<fieldset class="col-sm-4">
													<label class="control-label" for="">Contact Number<span class="required-field">*</span></label>
													<form:input path="phone" title="Contact Number" id="phone" onblur="validatePhone()" cssClass="form-control"
														maxlength="<%=JspConstants.PHONE_MAXLEN.toString()%>" />
														<div class="discriptionErrorMsg">
														<span id="phoneErr" class="red-error">&nbsp;</span>
													</div> 
												</fieldset>	
												<fieldset class="col-sm-4"> 
													<label class="control-label" for="">E-mail ID<span class="required-field">*</span></label>
													<form:input path="email" title="E-mail ID" id="email"
													cssClass="form-control" onblur="validateEmail()" maxlength="<%=JspConstants.ADDRESS_MAXLEN.toString()%>"/>
													<div  class="discriptionErrorMsg">
														<span id="emailErr" class="red-error">&nbsp;</span>
													</div> 
												</fieldset>
												<fieldset class="col-sm-4">
													<label class="control-label" for="">Status<span class="required-field">*</span></label>
													<form:input path="status" id ="status" cssClass="form-control" readonly="true"/>
														<div class="discriptionErrorMsg">
														<span id="statusErr" class="red-error">&nbsp;</span>
													</div> 
												</fieldset>
											</div>
										</div>
										<!--Panel Action Button Start -->
										<div class="col-sm-12 form-action-buttons">
											<div class="col-sm-5"></div>
											<div class="col-sm-7">
												<input type="submit" class="form-control button pull-right" value="Save" onclick="return validateEdit()">
												<a href="user-mgmt-search" class="form-control button pull-right">Cancel</a>
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
    <script src="../js/bootstrap.min.js"></script>	
    <script src="../js/jquery.maskedinput.js"></script>
    <script type="text/javascript">
		$("#phone").mask("+99-999-999-9999");
	</script> 
    
    
    <script src="../js/user.js"></script>	
	<!--common script for all pages-->
	<script src="../js/common-lib.js"></script>
	<script>
		/* Select li full area function Start *
		$("li").click(function(){
			window.location=$(this).find("a").attr("href"); 
			return false;
		});
		/* Select li full area function End */		
		/* Common Navigation Include Start */		
		$(function(){
			$( "#main-navigation" ).load( "main-navigation.html" );
		});
		function highlightMainContent(){
			$( "#navListId2" ).addClass( "active-background" );
		}
		/* Common Navigation Include End */
	</script>
  </body>  
</html>