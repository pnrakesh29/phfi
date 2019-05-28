<!DOCTYPE html>

<%@page import="com.smh.enums.RoleLevel"%>
<%@page import="com.smh.constants.PHFIWebConstant"%>
<%@page import="com.smh.constants.JspConstants"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html lang="en">
<head>
<!-- <meta charset="utf-8"> -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Smh</title>
<link rel="icon" href="../images/favicon.png" type="image/png">
<!-- Bootstrap -->
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/style.css" rel="stylesheet">
<link href="../css/jquery.datetimepicker.css" rel="stylesheet"
	type="text/css" />
<script src="../js/jquery.min.js"></script>	
<link href="../css/font-awesome.css" rel="stylesheet" type="text/css" />
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body oncontextmenu="disableRightClick(<%=PHFIWebConstant.ALLOW_RIGHT_CLICK%>)">
	<!--Body Wrapper block Start -->
	<div id="wrapper">
		<!--Container block Start -->
		<div class="container-fluid">
			<!--Navigation Block Start -->
			<%@include file="navigation.jsp"%>
			<!--Navigation Block Start -->
			<!--Article Block Start-->
			<article>
				<form name="inActiveRoleForm" action="inActivePage" method="post">
				</form>
				<div class="col-xs-12 content-wrapper">
					<!-- Breadcrumb start -->
					<div class="breadCrumb">
						<span class="breadcrumb-text">Set Up </span> <span
							class="glyphicon glyphicon-play icon-font-size"></span> <span
							class="breadcrumb-text">Role </span> <span
							class="glyphicon glyphicon-play icon-font-size"></span> <span
							class="breadcrumb-text">Edit </span>
					</div>
					<form action="getRoleCategory" name="roleCategoryForm" method="post">
				      <input type="hidden" id="roleCategory" name="roleCategory" />
				      <input type="hidden" id="rolesName" name="roleName" />
				      <input type="hidden" id="roleDiscription" name="description" />
			        </form>
			        
					<!-- Breadcrumb End -->
					<!-- Tab Buttons Start -->
					<div class="tab-header-container-first">
						<a href="access-role-search-page">Search </a>
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
										<span class="red-error" id="errorDiv">${error}</span> <span
											class="green-error" id="sucessDiv">${success}</span>
									</div>
								</div>
								<!--Success and Failure Message End-->
								<!-- Page Form Start -->
								<form:form action="chatakUpdateRole"  modelAttribute="userRoleRequest" method="post" onsubmit="buttonDisabled()" >
								<input type="hidden" id="permissions" name="permissions">
								  <form:hidden path="roleId"/>
									<div class="col-sm-12">
										<div class="row">
											<div class="field-element-row">
												<fieldset class="col-sm-4">
													<label>Role Name</label>
													<form:input path="roleName"  maxlength="<%= JspConstants.ROLE_NAME.toString() %>"
														 cssClass="form-control" readonly ="true"
														onblur="this.value=this.value.trim();validRoleName('roleName','roleDiv','Please enter the role name','Please enter the valid role name')" /> 
													<div class="discriptionErrorMsg">
														<span class="red-error" id="roleDiv">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-4">
													<label>Role Description<span class="required-field">*</span></label>
													<form:input  cssClass="form-control" id="description"
														path="description" maxlength="<%=JspConstants.ROLE_DESCRIPTION.toString()%>"
														onblur="this.value=this.value.trim();validRoleDescription('description','roleDescription','Please enter the description','Please enter the valid description')" />
													<div class="discriptionErrorMsg">
														<span class="red-error" id="roleDescription">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-4"> 
													<label>Role Category</label>
													<form:input path="roleCategory" cssClass="form-control" readonly="true"/>													
													<div class="discriptionErrorMsg">
														<span class="red-error" id="roleCategoryError">&nbsp;</span>
													</div>
												</fieldset>
												<div class="col-sm-12 role_assign_message">
													<label>Select Permissions to Assign</label>
												</div>
												<div class="col-sm-12 roleListDiv">
												<!-- Collapseable panel Main Start -->
												<div class="panel-group" id="accordion">
													<ul id="check-tree" class="marginLM60">
														<c:forEach items="${featureList}" var="feature">
															<c:if test="${feature.getRefFeatureId() == 0}">
																	<div class="panel panel-default clearfix">
																		<!-- Panel Header Start -->
																		<div class="panel-heading permission_color">
																			<h4 class="panel-title">
																				<a id="anchorClick${feature.getFeatureId()}"
																					data-toggle="collapse" data-parent="#accordion"
																					href="#collapse${feature.getFeatureId()}"  class="fa fa-angle-double-left" > <label class="permission_cursor_type" style="font-size: 14px;font-family: Verdana, Geneva, sans-serif;font-style: normal;">${feature.getName()}</label>
																				</a>
																			</h4>
																		</div>
																		<!-- Panel Header End -->
																		<!-- Panel Content Start -->
																		<div id="collapse${feature.getFeatureId()}"
																			class="panel-collapse collapse">

																			<li><label><input type="checkbox" name="featureTO"
																					value="${feature.getFeatureId()}"
																					id="${feature.getFeatureId()}"
																					<c:if test="${fn:contains(roleExistingFeatures,feature.getRoleFeatureId())}">checked</c:if> />${feature.getName()}</label>
																				<ul>
																					<c:forEach items="${featureList}" var="featureSub"
																						varStatus="counter">
																						<c:if
																							test="${featureSub.getRefFeatureId() eq feature.getFeatureId()}">

																							<!-- DisplayChild(Level2) -->
																							<fieldset class="col-sm-4">
																							<li><label><input type="checkbox"
																									name="featureTO"
																									id="${featureSub.getFeatureId()}"
																									<c:if test="${fn:contains(roleExistingFeatures,featureSub.getRoleFeatureId())}">checked</c:if> />${featureSub.getName()}</label>
																								<ul>

																									<c:forEach items="${featureList}"
																										var="featureChild">
																										<c:if
																											test="${featureChild.getRefFeatureId() eq featureSub.getFeatureId()}">
																											<!-- DisplayChild(Level3) -->
																											<li><label><input
																													type="checkbox" name="featureTO"
																													id="${featureChild.getFeatureId()}"
																													<c:if test="${fn:contains(roleExistingFeatures,featureChild.getRoleFeatureId())}">checked</c:if> />${featureChild.getName()}</label>
																											</li>
																										</c:if>
																									</c:forEach>
																								</ul></fieldset></li>
																						</c:if>
																					</c:forEach>
																				</ul></li>
																		</div>

																		<!-- Panel Content End -->
																	</div>
																	<!-- User Information Collapseable panel End-->
															</c:if>
														</c:forEach>
													</ul>
												</div>

											</div>

										</div>
										</form:form>
									</div>
									<!--Panel Action Button Start -->
									
									<div class="col-sm-12 form-action-buttons">
														<div class="col-sm-5"></div>
														<div class="col-sm-7">
															<input type="submit"
															  id="buttonCreate"	class="form-control button pull-right" value="Update"
																onclick="return continueEditRole()">
															 <a href="#" id="processingButton1" style="display: none;">
																<input type="button" class="form-control button pull-right"
																value="Processing...">
															</a> <a href="access-role-search-page"
																class="form-control button pull-right">Cancel</a>
														</div>
													</div>
									<%-- <div class="col-sm-12 form-action-buttons">
										<div class="col-sm-4">&nbsp;</div>
										<div class="col-sm-9">
										<c:if test="${SAME_ROLE_FLAG eq true}">
										<input type="submit" class="form-control button pull-right" value="Update" disabled="disabled" id="buttonCreate" onclick="return continueEditRole()">
										<a href="#" id="processingButton1" 
												class="form-control button pull-right">Processing... </a> <a
												href="access-role-search-page"
												class="form-control button pull-right">Cancel </a>
										</c:if>
										<c:if test="${SAME_ROLE_FLAG eq false}">
												<input type="submit" class="form-control button pull-right" value="Update" id="buttonCreate" onclick="return continueEditRole()"><a href="#" id="processingButton1"
												class="form-control button pull-right">Processing... </a> <a
												href="access-role-search-page"
												class="form-control button pull-right">Cancel </a>
										</c:if>
										</div>
									</div>
 --%>
									<!--Panel Action Button End -->
							</div>
							<!-- Page Form End -->
						</div>
					</div>
				</div>
				<!-- Content Block End -->
		</div>
		</article>
		<!--Article Block End-->
		<jsp:include page="footer.jsp"/>
	</div>
	<!--Container block End -->
	</div>
	<!--Body Wrapper block End -->

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/jquery-checktree.js"></script>
	<script src="../js/common-lib.js"></script>
    <script src="../js/messages.js" type="text/javascript"></script>
	<script src="../js/role.js" type="text/javascript"></script>
	<script src="../js/validation.js" type="text/javascript"></script>
	<script src="../js/jquery.datetimepicker.js"></script>
    <script src="../js/backbutton.js" type="text/javascript"></script>
    <script src="../js/bootstrap.js" type="text/javascript"></script>
	<script>
		var APP_SERVICE_BASE_URL="<%=request.getContextPath()%>";
		/* Common Navigation Include Start */
		$(function() {
			$("#main-navigation").load("main-navigation.html");
	    });
		function highlightMainContent() {
			$("#navListId2").addClass("active-background");
		}
		/* Common Navigation Include End */
		/*Collapse Panel functionality Start */
		function nextPanelOpen(collapsID) {
			$('#anchorClick' + (collapsID + 1)).click();
		}
		/*Collapse Panel functionality End */
		/* Custom Checkbox function Start*/
		$('#check-tree').checktree();
		var _gaq = _gaq || [];
		_gaq.push([ '_setAccount', 'UA-36251023-1' ]);
		_gaq.push([ '_setDomainName', 'jqueryscript.net' ]);
		_gaq.push([ '_trackPageview' ]);

		(function() {
			var ga = document.createElement('script');
			ga.type = 'text/javascript';
			ga.async = true;
			ga.src = ('https:' == document.location.protocol ? 'https://ssl'
					: 'http://www')
					+ '.google-analytics.com/ga.js';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(ga, s);
		})();
		/* Custom Checkbox function End*/
	</script>
</body>
</html>