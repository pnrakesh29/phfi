<!doctype html>
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
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
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

</head>
<body oncontextmenu="disableRightClick(<%=PHFIWebConstant.ALLOW_RIGHT_CLICK%>)">
	<!--Body Wrapper block Start -->
	<div id="wrapper">
		<!--Container block Start -->
		<div class="container-fluid">
			<!-- Navigation Bar Start --->
			<%@include file="navigation.jsp"%>
			<!-- Navigation Bar End -->
			<!--Article Block Start-->
			<article>
				
				<form action="access-role-edit" name="editRoleForm"
					method="post">
					<input type="hidden" id="roleId" name="roleId" />
				</form>

				

				<div class="col-xs-12 content-wrapper">
					<!-- Breadcrumb start -->
					<div class="breadCrumb">
						<span class="breadcrumb-text">Set Up </span> <span
							class="glyphicon glyphicon-play icon-font-size"></span> <span
							class="breadcrumb-text">Role </span> <span
							class="glyphicon glyphicon-play icon-font-size"></span> <span
							class="breadcrumb-text">Search </span>
					</div>
					<!-- Breadcrumb End -->
					
					<form action="getRolesPages" name="paginationForm" method="post" >
					<input type="hidden" id="pageNumberId" name="pageNumber" />
					<input type="hidden" id="totalRecordsId" name="totalRecords"/>
				</form>
				<form action="downloadRoleReport" name="downloadReport" method="post">
				      <input type="hidden" id="downloadPageNumberId" name="downLoadPageNumber" />
				      <input type="hidden" id="downloadTypeId" name="downloadType" />
			        </form>
				<form action="prepaid-admin-managment-view-role" name="viewRoleForm"
					method="post">
					<input type="hidden" id="viewRoleId" name="roleId" />
				</form>
				<form name="viewUpdateRoleForm" action="viewUpdateRole"
					method="post">
					<input type="hidden" id="viewRolId" name="viewRoleId" /> <input
						type="hidden" id="viewRoleStatus" name="roleStatus" />
				</form>
				
				<form action="deleteRole" name="deleteRoleForm" method="post">
       			  <input type="hidden" id="roleIdDeleteData" name="roleIdDeleteData" />
       			</form> 
					
					<!-- Tab Buttons Start -->
					<div class="marginL40">
					<c:if test="${fn:contains(existingFeatures,roleView)||fn:contains(existingFeatures,roleEdit)||fn:contains(existingFeatures,roleSuspend)||fn:contains(existingFeatures,roleActivate)}">
					<div class="tab-header-container active-background">
						<a href="#">Search</a>
					</div>
					</c:if>
					<c:if test="${fn:contains(existingFeatures,roleCreate)}">
						<div class="tab-header-container">
							<a href="access-role-create-page">Create</a>
						</div>
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
										<span class="red-error" id="errorDiv">&nbsp;${error}</span> <span
											class="green-error" id="sucessDiv">&nbsp;${success}</span>
									</div>
								</div>
								<!--Success and Failure Message End-->
								<!-- Page Form Start -->
								<form:form commandName="userRoleRequest"
									action="proccess-access-role-search-page" method="post">
									<div class="col-sm-12">
										<div class="row">
											<div class="field-element-row">
												<fieldset class="col-sm-4">
													<label>Role Name</label>
													<form:input path="roleName" id="roleName" maxlength="<%= JspConstants.ROLE_NAME.toString() %>"
														title="Use wild card like %* to search"
														cssClass="form-control" />
													<div class="discriptionErrorMsg">
														<span class="red-error">&nbsp;</span>
													</div>
												</fieldset>
												  <fieldset class="col-sm-4"> 
														<label>Role Category</label>
															<form:select  path="roleCategory" cssClass="form-control" onchange="validateRoleCategory(this.value)">
															  <form:option value="">..:All:..</form:option>
																   <c:forEach items="${roleLevelList}" var="roleLevelList">
																         <form:option value="${roleLevelList.name()}">${roleLevelList.value}</form:option>
															        </c:forEach>
															 </form:select>
															<div class="discriptionErrorMsg">
																<span class="red-error" id="roleCategoryError">&nbsp;</span>
															</div>
													</fieldset>
												<fieldset class="col-sm-4"> 
													<label class="control-label" for="">Status</label>
														<form:select path="status" title="Status" id="status" cssClass="form-control">
														<form:option value="">.:Select:.</form:option>
														<form:option value="Active">Active</form:option>
														<form:option value="Suspended">Suspended</form:option>
														<form:option value="Deleted">Deleted</form:option>
													</form:select>
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
												<input type="submit" class="form-control button pull-right"
													value="Search"> <input type="button"
													class="form-control button pull-right"
													onclick="window.location.href='access-role-search-page'"
													value="Reset">
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
					<!-- Search Table Block Start -->
					 <c:set var ="flageCheck" scope="session" value="<%=PHFIWebConstant.Yes%>"/>
					<c:if test="${roleList ne flageCheck }">
					<div class="search-results-table">
						<table class="table table-striped table-bordered table-condensed marginBM1">
							<!-- Search Table Header Start -->
							<tr>
								<td class="search-table-header-column widthP80"><span
									class="glyphicon glyphicon-search search-table-icon-text"></span>
									<span>Search Summary</span></td>
									<td class="search-table-header-column" style ="font-weight:bold;">Total Count : ${totalRecords}</td>
							</tr>
							</table>
							<!-- Search Table Header End -->
							<!-- Search Table Content Start -->
							<table id="serviceResults" class="table table-striped table-bordered table-responsive table-condensed tablesorter marginBM1 common-table resize-table">
							<thead>
							<tr>
								<th>Role Name</th>
								<th>Role Description</th>
								<th>Role Category</th>
								<th>Status</th>
								<th class="sorter-false tablesorter-header tablesorter-headerUnSorted">Action</th>
							</tr>
							</thead>
							<c:choose>
								<c:when test="${!(fn:length(roleList) eq 0) }">
									<c:forEach items="${roleList}" var="role">
										<tr>
											<td class="ellipsis" id="15" title="${role.roleName}">${role.roleName}</td>
											<td><c:choose>
													<c:when test="${fn:length(role.description) gt 25}">
														<div title="${fn:substring(role.description,0,50)}">${role.description}</div>
													</c:when>
													<c:otherwise>
														<div>${role.description}</div>
													</c:otherwise>
												</c:choose></td>
												<td>${role.roleType}</td>
											<td>${role.status}</td>
											<td><c:choose>
													<c:when
														test="${fn:containsIgnoreCase(role.status,'Active') }">
														<c:if test="${fn:contains(existingFeatures,roleEdit)}">
															<a href="javascript:editRole('${role.userRoleId}')"
																title="Edit"><span
																class="glyphicon glyphicon-pencil"></span></a>
														</c:if>
														<%-- <c:if test="${fn:contains(existingFeatures,viewRole)}">
															<a href="javascript:viewRole('${role.userRoleId}')"><img
																src="../images/eyeimage.png" alt="View" title="View"></img><span
																class="glyphicon glyphicon-eye"></span></a>
														</c:if>  --%>
														<c:if test="${fn:contains(existingFeatures,roleSuspend)}">
															<a
																href="javascript:changeStatus('${role.userRoleId}','Suspended','Suspended')"
																title="Suspend"> <img src="../images/deactive.png"
																alt="Suspend" title="Suspend"></img></a>
														</c:if> 
														<%-- <c:if test="${fn:contains(existingFeatures,deleteRole)}">
															<a
																href="javascript:confirmDeleteRole('${role.userRoleId}')"
																title="Delete"> 
																<span class="glyphicon glyphicon-trash"></span>
															</a>
														</c:if> --%>
													</c:when>
													<c:otherwise>
														<c:if test="${fn:contains(existingFeatures,roleEdit) && fn:containsIgnoreCase(role.status,'Suspended')}">
															<a href="javascript:editRole('${role.userRoleId}')"
																title="Edit"><span
																class="glyphicon glyphicon-pencil"></span></a>
														</c:if>
														<c:if
															test="${fn:containsIgnoreCase(role.status,'Suspended') && fn:contains(existingFeatures,roleActivate)}">
															<a
																href="javascript:changeStatus('${role.userRoleId}','Active','Active')"
																title="Active"> <img alt="Active"
																src="../images/active.png" title="Activate"></img>
															</a>
														</c:if>
														
													</c:otherwise>
												</c:choose></td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="5" style="color: red;">Roles are not
											available at this moment</td>
									</tr>
								</c:otherwise>
							</c:choose>
							</table>
							<!-- Search Table Content End -->	
							<table class="table table-striped table-bordered table-condensed">
							<c:if test="${!(fn:length(roleList) eq 0) }">
								<tr class="table-footer-main">
									<td colspan="10" class="search-table-header-column">
										<div class="col-sm-12">
											 <div class="col-sm-4">
												<div class="btn-toolbar" role="toolbar">
													<div class="btn-group custom-table-footer-button">
														 <a href="javascript:downloadReports('${portalListPageNumber}', '<%=PHFIWebConstant.XLS_FILE_FORMAT%>')">
                                                    	<button type="button" class="btn btn-default">
                                                    		<img src="../images/excel.png">
                                                    	</button>
                                                    </a>
                                                    
                                                     <a href="javascript:downloadReports('${portalListPageNumber}','<%=PHFIWebConstant.PDF_FILE_FORMAT%>')">
														<button type="button" class="btn btn-default">
															<img src="../images/pdf.png"/>
														</button>
													</a> 
													</div>
												</div>
											</div> 
										<div class="col-sm-8">
										<c:if test="${ !(fn:length(roleList) eq 0)}">
													<ul class="pagination custom-table-footer-pagination">
														<c:if test="${portalListPageNumber gt 1}">
															<li><a href="javascript:getPortalOnPageWithRecords('1','${totalRecords}')">
																				&laquo;</a></li>
															<li><a href="javascript:getPortalPrevPageWithRecords('${portalListPageNumber }', '${totalRecords}')">
																				&lsaquo; </a></li>
														</c:if>
		
														<c:forEach var="page" begin="${beginPortalPage }"
																end="${endPortalPage}" step="1" varStatus="pagePoint">
																<c:if test="${portalListPageNumber == pagePoint.index}">
																	<li	class="${portalListPageNumber == pagePoint.index?'active':''}">
																		 <a href="javascript:">${pagePoint.index}</a>
																	 </li>
																</c:if>
																<c:if test="${portalListPageNumber ne pagePoint.index}">
																	<li class=""><a
																		href="javascript:getPortalOnPageWithRecords('${pagePoint.index }','${totalRecords}')">${pagePoint.index}</a>
																	</li>
																</c:if>
															</c:forEach>
															<c:if test="${portalListPageNumber lt portalPages}">
																<li><a href="javascript:getPortalNextPageWithRecords('${portalListPageNumber }', '${totalRecords}')">
																				&rsaquo;</a></li>
																<li><a href="javascript:getPortalOnPageWithRecords('${portalPages }', '${totalRecords}')">&raquo;
																    </a></li>
														   </c:if>
													   </ul>
									              </c:if>
										     </div>
										</div> <!-- <div class="col-sm-8">	
											<ul class="pagination custom-table-footer-pagination">
												<li><a href="#">&laquo;</a></li>
												<li><a href="#">1</a></li>
												<li><a href="#">2</a></li>
												<li><a href="#">3</a></li>
												<li><a href="#">4</a></li>
												<li><a href="#">5</a></li>
												<li><a href="#">&raquo;</a></li>
											</ul>	
										</div> -->
									</td>

								</tr>
							</c:if>

							<!-- Search Table Content End -->
						</table>
							<!--Panel Action Button Start -->
							<!-- <div class="col-sm-12 form-action-buttons">
								<fieldset class="col-sm-3 pull-right">
									<input type="button"
										class="form-control button pull-right table-hide-btn"
										value="Back">
								</fieldset>
							</div> -->
							<!--Panel Action Button End -->
						</div>
						</c:if>
					<!-- Search Table Block End -->
				</div>
			</article>
			<!--Article Block End-->
			<jsp:include page="footer.jsp"/>
		</div>
		<!--Container block End -->
	</div>
	<!--Body Wrapper block End -->


	<div id="rolePopupDiv" class="locatioin-list-popup">
		<span class="glyphicon glyphicon-remove"
			onclick="closePopup();clearPopupDesc();"></span>
		<h2>Change Status</h2>
		<form action="roleActivation" name="roleActivationForm" method="post">
			<input type="hidden" id="roleActivateId" name="roleActivateId" /> <input
				type="hidden" id="roleStatus" name="roleStatus" /> 
				<input type="hidden" id="roleType" name="roleType" /> 
				<label><span class="requiredFiled">*</span> Reason </label>
			<textarea id="reason" name="reason" maxlength="<%= JspConstants.REASON.toString() %>"
				onblur="validatePopupDesc();clientValidation('reason', 'reason','popDescError_div')"></textarea>
			<div class="discriptionErrorMsg">
				<span class="red-error" id="popDescError_div">&nbsp;</span>
			</div>
			<!--Panel Action Button Start -->
			<div class="col-sm-12 form-action-buttons">
				<div class="col-sm-12">
					<input type="submit" class="form-control button pull-right"
						value="Submit" onclick="return validatePopupDesc();">
				</div>
			</div>
		</form>
		<!--Panel Action Button End -->
		<p>Note: On changing the status, all associated users will become
			same status</p>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="../js/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/common-lib.js"></script>
	<script src="../js/jquery.popupoverlay.js" type="text/javascript"></script>
	<script src="../js/role.js" type="text/javascript"></script>
	<!-- <script src="../js/prepaid-lib.js" type="text/javascript"></script> -->
	<!-- Tablesorter plugin Start-->
	<!-- <script src="../js/jquery.tablesorter.js"></script>
	<script src="../js/jquery.tablesorter.widgets.js"></script> -->
	<script src="../js/backbutton.js"></script> 
    <script src="../js/common-lib.js"></script>
	<script src="../js/tablesorter.js"></script> 
    <script src="../js/tablesorter.widgets.js"></script> 
    <script src="../js/sorting.js"></script> 
    <script type="text/javascript">
	$('input[id!="@#$"],select[id!="@#$"]').click(function () {
		var spans = $('.red-error');
		var spans1 = $('.green-error');
		spans.hide();
		spans1.hide();
	});
	</script>
	<script>
		/* Select li full area function Start */
		$("li").click(function() {
			window.location = $(this).find("a").attr("href");
			return false;
		});
		/* Select li full area function End */
		/* Common Navigation Include Start */
		$("#navListId2").addClass("active-background");
		/* Common Navigation Include End */

		$(document).ready(function() {
			$('#rolePopupDiv').popup({
				blur : false
			});
			 $('#roleName').focus();
		});
		function closePopup() {
			$('#rolePopupDiv').popup("hide");
		}
		function openPopup() {
			$('#rolePopupDiv').popup("show");
		}
		
		$(".table-hide-btn").click(function(){
			$(".search-results-table").slideUp();
		});
	</script>
</body>
</html>