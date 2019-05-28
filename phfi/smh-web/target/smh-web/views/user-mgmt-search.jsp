<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="com.smh.constants.Constant"%>
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
							class="breadcrumb-text">Search </span>					
					</div>
					<!-- Breadcrumb End -->
					<!-- Tab Buttons Start -->
					<div class="tab-header-container-first active-background">
						<a href="#">Search</a>					
					</div>
					<div class="tab-header-container">
						<a href="user-mgmt-create">Create</a>
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
								<div id="activatePop" class="locatioin-list-popup">
									<span class="glyphicon glyphicon-remove"
										onclick="closePopupActivate();clearPopupDesc();"></span>
									<h2>Change Status</h2>
									<form action="update-user-status" name="userStatusForm" method="post">
										<input type="hidden" id="statusChangeUserId" name="statusChangeUserId" /> 
										<input type="hidden" id="statusChange" name="statusChange" /> <label><span
											class="requiredFiled">*</span> Reason </label>
										<textarea id="activateReason" name="activateReason" maxlength="<%=JspConstants.REASON.toString()%>"></textarea>
										<div class="discriptionErrorMsg" id="activateErr">
				            	     <span class="red-error">&nbsp;</span>
				                   </div>
										<!--Panel Action Button Start -->
										<div class="col-sm-12 form-action-buttons">
											<div class="col-sm-12">
												<input type="submit"  class="form-control button pull-right"
													value="Submit" onclick="submitUserStatus()">
											</div>
										</div>
									</form>
									<!--Panel Action Button End -->
									<p>Note: On changing the status, all associated users will
										become same status</p>
								</div>
								
								<form action="admin-user-report" name="downloadReport"
									method="post">
									<input type="hidden" id="downloadPageNumberId"
										name="downLoadPageNumber" /> <input type="hidden"
										id="downloadTypeId" name="downloadType" />
								</form>
								<form action="admin-user-pagination" name="paginationForm"
									method="post">
									<input type="hidden" id="pageNumberId" name="pageNumber" /> <input
										type="hidden" id="totalRecordsId" name="totalRecords" />
								</form>
								<form action="user-mgmt-edit" name="editUserForm" method="post">
									<input type="hidden" name="adminUserId" id="adminUserId">
								</form>
								<form action="process-admin-user-delete" name="deleteUserForm"
									method="post">
									<input type="hidden" name="deleteUserId" id="deleteUserId">
								</form>

								<form:form action="process-user-search" commandName="adminUserRequest">
									<div class="col-sm-12">
										<div class="row">
											<div class="field-element-row">												
												
												<fieldset class="col-sm-4"> 
													<label class="control-label" for="">Role Category</label>
													<form:select cssClass="form-control" title="Entity Type" id="userType" path="userType" onchange="fetchRoles()" >
															<form:option value="">.:Select:.</form:option>
														   <c:forEach items="${roleLevelList}" var="roleLevelList">
														         <form:option value="${roleLevelList.name()}">${roleLevelList.value}</form:option>
													        </c:forEach>
													</form:select>
													<div class="discriptionErrorMsg">
														<span id="manufacturerErr" class="red-error">&nbsp;</span>
													</div> 
												</fieldset>
												
												<fieldset class="col-sm-4"> 
													<label class="control-label" for="">Role Name</label>
													<form:select cssClass="form-control" title="Role Name" id="userRoleId" path="userRoleId"  >
															<form:option value="">.:Select:.</form:option>
														 <c:if test="${not empty roleList}">
															<c:forEach items="${roleList}" var="roleList">													
																<form:option value="${roleList.userRoleId}">${roleList.roleName}</form:option>
															</c:forEach>
														</c:if>
													</form:select>
													<div class="discriptionErrorMsg">
														<span id="userRoleIdErr" class="red-error">&nbsp;</span>
													</div> 
												</fieldset>			
												
											<fieldset class="col-sm-4"> 
													<label class="control-label" for="">User Name</label>
													<form:input path="userName" title="User Name" id="userName" cssClass="form-control" onblur="validateUserName()"
												                maxlength="<%=JspConstants.NAME_MAXLEN.toString()%>" />
													<div class="discriptionErrorMsg">
														<span id="modelErr" class="red-error">&nbsp;</span>
													</div> 
												</fieldset>
												<fieldset class="col-sm-4"> 
													<label class="control-label" for="">E-mail ID</label>
													<form:input path="email" title="E-mail ID" id="email"
													cssClass="form-control" onblur="validateEmail()" maxlength="<%=JspConstants.ADDRESS_MAXLEN.toString()%>"/>
													<div  class="discriptionErrorMsg">
														<span id="descriptionErr" class="red-error">&nbsp;</span>
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
															<span class="red-error">&nbsp;</span>
														</div>
												</fieldset>
											</div>
										</div>
										<!--Panel Action Button Start -->
										<div class="col-sm-12 form-action-buttons">
											<div class="col-sm-5"></div>
											<div class="col-sm-7">
												<input type="submit" class="form-control button pull-right" value="Search" >
												<a href="user-mgmt-search" class="form-control button pull-right">Reset</a>
											</div>	
										</div>
										<!--Panel Action Button End -->
									</div>
								</form:form>
								<!-- Page Form End -->	
							</div>
						</div>
					</div>
					<c:if test="${resultflag eq 'true'}">
					<div class="search-results-table">
						<table class="table table-striped table-bordered table-condensed marginBM1">
							<!-- Search Table Header Start -->
							<tr>
								<td class="search-table-header-column widthP80">
									<span class="glyphicon glyphicon-search search-table-icon-text"></span>									
									<span>Search</span>
								</td>
								<td class="search-table-header-column" style ="font-weight:bold;">Total Count : ${totalCount}</td>
							</tr>
							</table>
							<!-- Search Table Header End -->
							<!-- Search Table Content Start -->
							<table id="serviceResults" class="table table-striped table-bordered table-responsive table-condensed tablesorter marginBM1 common-table">
								<thead>
							<tr>
							    		<th> Role Category</th>
										<th> Role Name</th> 
										<th> Username</th>
										<th> First Name</th>
										<th> Last Name</th>
										<th> Mobile</th>
										<th> E-mail</th>
										<th> Status</th>
										<th class="sorter-false tablesorter-header tablesorter-headerUnSorted">Action</th>
							</tr>
							</thead>
							<c:choose>
										<c:when test="${!(fn:length(searchUserList) eq 0) }">
										
											<c:forEach items="${searchUserList}" var="userListData">
                                             <c:if test="${userListData.status == 'Active'}">
													<tr>
													<td>${userListData.userType}</td>
													<td>${userListData.roleName}</td> 
													<td>${userListData.userName}</td>
													<td>${userListData.firstName}</td>
													<td>${userListData.lastName}</td>
													<td>${userListData.phone}</td>
													<td>${userListData.email}</td>
													<td>${userListData.status}</td>
													<td data-title="Action">
													<c:if test="${fn:contains(existingFeatures,userEdit)}">
														<a href="javascript:editadminUserItems('${userListData.adminUserId}') " title="Edit"><span class="glyphicon glyphicon-pencil"></span></a></c:if>
														<a href="javascript:changeadminUserStatus('${userListData.adminUserId}','Suspended') " title="Suspend"><img src="../images/deactive.png"
																alt="Suspend" title="Suspend"></img></a>
													<c:if test="${fn:contains(existingFeatures,userDelete)}">
														<a href="javascript:confirmDeleteUser('${userListData.adminUserId}') " title="Delete"><span class="glyphicon glyphicon-trash"></span></a></c:if>
													</td>
												</tr> 
											</c:if>
											<c:if test="${userListData.status == 'Suspended'}">
											<tr>
													<td>${userListData.userType}</td>
													<td>${userListData.roleName}</td> 
													<td>${userListData.userName}</td>
													<td>${userListData.firstName}</td>
													<td>${userListData.lastName}</td>
													<td>${userListData.phone}</td>
													<td>${userListData.email}</td>
													<td>${userListData.status}</td>
													<td data-title="Action">
													<c:if test="${fn:contains(existingFeatures,userEdit)}">
														<a href="javascript:changeadminUserStatus('${userListData.adminUserId}','Active') " title="Activate"><img src="../images/active.png"
																alt="Suspend" title="Suspend"></img></a>
													</c:if>
													</td>
												</tr> 
											</c:if>
										<c:if test="${userListData.status == 'Deleted'}">
										<tr>
													<td>${userListData.userType}</td>
													<td>${userListData.roleName}</td> 
													<td>${userListData.userName}</td>
													<td>${userListData.firstName}</td>
													<td>${userListData.lastName}</td>
													<td>${userListData.phone}</td>
													<td>${userListData.email}</td>
													<td>${userListData.status}</td>
													<td data-title="Action"></td>
												</tr> 
										</c:if>
									</c:forEach>
								</c:when>
							<c:otherwise>
											<tr>
												<td colspan="7" style="color: red;">No Records found</td>
											</tr>
										</c:otherwise>
									</c:choose>
							</table>
							<!-- Search Table Content End -->	
						<table class="table table-striped table-bordered table-condensed">
							<c:if test="${!(fn:length(searchUserList) eq 0) }">
							<tr class="table-footer-main">
								<td colspan="8" class="search-table-header-column">
									<div  class="col-sm-12">
										<div class="col-sm-4">
											<div class="btn-toolbar" role="toolbar">
												<div class="btn-group custom-table-footer-button">
													<a href="javascript:downloadReports('${portalListPageNumber}', '<%=Constant.XLS_FILE_FORMAT%>')">
													              <button type="button" class="btn btn-default"><img src="../images/excel.png"></button></a>
													<a href="javascript:downloadReports('${portalListPageNumber}', '<%=Constant.PDF_FILE_FORMAT%>')">
													             <button type="button" class="btn btn-default"><img src="../images/pdf.png" ></button></a>
												</div>
											</div>
										</div>
											<div class="col-sm-8">
												<c:if test="${ !(fn:length(searchUserList) eq 0)}">
													<ul class="pagination custom-table-footer-pagination">
														<c:if test="${portalListPageNumber gt 1}">
															<li><a href="javascript:getPortalOnPageWithRecords('1','${totalRecords}')">&laquo;</a></li>
															<li><a href="javascript:getPortalPrevPageWithRecords('${portalListPageNumber }', '${totalRecords}')">&lsaquo; </a></li>
														</c:if>

														<c:forEach var="page" begin="${beginPortalPage }"
															end="${endPortalPage}" step="1" varStatus="pagePoint">
															<c:if test="${portalListPageNumber == pagePoint.index}">
																<li class="${portalListPageNumber == pagePoint.index?'active':''}">
																	<a href="javascript:">${pagePoint.index}</a>
																</li>
															</c:if>
															<c:if test="${portalListPageNumber ne pagePoint.index}">
																<li class=""><a href="javascript:getPortalOnPageWithRecords('${pagePoint.index }','${totalRecords}')">${pagePoint.index}</a>
																</li>
															</c:if>
														</c:forEach>


														<c:if test="${portalListPageNumber lt portalPages}">
															<li><a href="javascript:getPortalNextPageWithRecords('${portalListPageNumber }', '${totalRecords}')">&rsaquo;</a></li>
															<li><a href="javascript:getPortalOnPageWithRecords('${portalPages }', '${totalRecords}')">&raquo;</a></li>
														</c:if>

													</ul>

												</c:if>
											</div>
										</div>								
								</td>
							</tr>
							</c:if>
							<!-- Search Table Content End -->	
						</table> 
						</div>
					</c:if>
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
	<script src="../js/jquery.datetimepicker.js"></script>
	
	<script src="../js/user.js"></script>
	<script src="../js/jquery.popupoverlay.js"></script>
	<script type="text/javascript">
	function closePopupActivate() {
		get('activateReason').value =null;
		setDiv("activateErr", "");
		$('activatePop').popup("hide");
	}
	
	</script>
	<script type="text/javascript">
    $('#activatePop').popup({
		blur : false
	});
    </script>
	
	
	<!--common script for all pages-->
	<script src="../js/common-lib.js"></script>
	<script>	
	$(document).ready(function() {
		$(".expiryDate_focus").click(function() {
			$(this).children('.expiryDate').focus();
		});
		$('.expiryDate').datetimepicker({
			timepicker : false,
			format : 'm/d/Y',
			formatDate : 'Y/m/d',
		});
	});
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