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
   	<title>Chatak Beacon</title>
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
			<%@include file="navigation.jsp"%>
			<!--Navigation Block End -->    			
			<!--Article Block Start-->
			<article>
				<div class="col-xs-12 content-wrapper">					
					<!-- Breadcrumb start -->
					<div class="breadCrumb">						
						<span class="breadcrumb-text">Manage </span>
						<span class="glyphicon glyphicon-play icon-font-size"></span>
						<span class="breadcrumb-text">Zone </span>
						<span class="glyphicon glyphicon-play icon-font-size"></span>
						<span class="breadcrumb-text">Create</span>						
					</div>
					<!-- Breadcrumb End -->
					<!-- Tab Buttons Start -->
					<div class="tab-header-container-first">
						<c:if test="${fn:contains(existingFeatures,zoneView)||fn:contains(existingFeatures,zoneEdit)||fn:contains(existingFeatures,zoneActivate)||fn:contains(existingFeatures,zoneDelete)||fn:contains(existingFeatures,zoneSuspend)}">
							<a href="beacon-zone-mgmt-search-page">Search</a>
						</c:if>					
					</div>
					<div class="tab-header-container active-background">
					<c:if test="${fn:contains(existingFeatures,roleCreate)}">
						<a href="#">Create</a>
					</c:if>
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
								<form:form action="beacon-zone-mgmt-create" commandName="demoTest" method="POST">
									<div class="col-sm-12">
										<div class="row">
											<div class="field-element-row">	
												<fieldset class="col-sm-4">
													<label class="control-label" for=""><spring:message code="name" /><span class="required-field">*</span></label>
													<form:input path="name" title="Name" id="name" cssClass="form-control"  />
														<div class="discriptionErrorMsg">
											<!-- 			<span id="zoneNameErr" class="red-error">&nbsp;</span> -->
													</div> 
												</fieldset>
												
												<fieldset class="col-sm-4">
													<label class="control-label" for=""><spring:message code="address"/><span class="required-field">*</span></label>
													<form:input path="address" title="Address" id="address"  cssClass="form-control" />
														<div class="discriptionErrorMsg">
														<span id="geofenceErr" class="red-error">&nbsp;</span>
													</div> 
												</fieldset>
												<fieldset class="col-sm-4"> 
													<label class="control-label" for=""><spring:message code="age"/><span class="required-field">*</span></label>
													<form:input path="age" title="Age" id="age" cssClass="form-control" />
													<div  class="discriptionErrorMsg">
														<span id="lattitudeErr" class="red-error">&nbsp;</span>
													</div> 
												</fieldset>
												<fieldset class="col-sm-4"> 
												<label class="control-label" for=""><spring:message code="state"/><span class="required-field">*</span></label>
													<form:input path="state" title="State" id="state" cssClass="form-control"/>
													<div class="discriptionErrorMsg">
														<span id="longitudeErr" class="red-error">&nbsp;</span>
													</div> 
												</fieldset>
											</div>
										</div>
										<!--Panel Action Button Start -->
										<div class="col-sm-12 form-action-buttons">
											<div class="col-sm-5"></div>
											<div class="col-sm-7">
												<input type="submit" class="form-control button pull-right" onclick="return validateZoneCreate()" value="Save" >
												<a href="beacon-zone-mgmt-search-page" class="form-control button pull-right">Cancel</a>
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
    <script src="../js/zone.js"></script>
    
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../js/bootstrap.min.js"></script>	
    <script src="../js/jquery.datetimepicker.js"></script>
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
			$( "#navListId10" ).addClass( "active-background" );
		}
		/* Common Navigation Include End */
	</script>
  </body>  
</html>