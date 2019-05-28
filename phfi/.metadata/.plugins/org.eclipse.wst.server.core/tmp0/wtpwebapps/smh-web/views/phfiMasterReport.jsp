<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="com.smh.constants.Constant"%>
<%@page import="com.smh.constants.JspConstants"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   	<title>Phif</title>
	<link rel="icon" href="../images/favicon.png" type="image/png">
    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
    <link href="../css/jquery.datetimepicker.css" rel="stylesheet"
	type="text/css" />
     <script src="../js/jquery.min.js"></script>
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
						<span class="breadcrumb-text">Master Report</span>
						 <span class="glyphicon glyphicon-play icon-font-size"></span>
						  <span class="breadcrumb-text">Search </span>					
					</div>
					<!-- Breadcrumb End -->
					<!-- Tab Buttons Start -->
						<div class="tab-header-container-first active-background">
							<a href="#">Search</a>
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
								<form action="beacon-pagination" name="paginationForm" method="post">
									<input type="hidden" id="pageNumberId" name="pageNumber" />
									 <input type="hidden" id="totalRecordsId" name="totalRecords" />
								</form>
								<form action="beacon-mgmt-update" name="editBeacon" method="post">
									<input type="hidden" name="editId" id="editId" />
								</form>
								<form action="getBeaconReport" name="downloadReport" method="post">
									<input type="hidden" id="downloadPageNumberId" name="downLoadPageNumber" /> 
									<input type="hidden" id="downloadTypeId" name="downloadType" />
								</form>
								<!--Success and Failure Message End-->
								<!-- Page Form Start -->
								<form:form action="get-master-reports" commandName="reportRequest" method="GET">
									<div class="col-sm-12">
										<div class="row">
											<div class="field-element-row">
											<fieldset class="col-sm-4"> 
													<label class="control-label" for="">Maternity Status</label>
													<form:input path="maternityStatus" title="Maternity Status" id="maternityStatus" cssClass="form-control"/>
													<div class="discriptionErrorMsg">
														<span id="maternityStatusErr" class="red-error">&nbsp;</span>
													</div> 
												</fieldset>												
												<fieldset class="col-sm-4"> 
													<label class="control-label" for="">WID</label>
													<form:input path="wid" title="UID" id="wid" cssClass="form-control" maxlength="<%=JspConstants.BEACON_UUID %>"/>
													<div class="discriptionErrorMsg">
														<span id="uuidErr" class="red-error">&nbsp;</span>
													</div> 
												</fieldset>	
											</div>
										</div>
										<!--Panel Action Button Start -->
										<div class="col-sm-12 form-action-buttons">
											<div class="col-sm-5"></div>
											<div class="col-sm-7">
												<input type="submit" class="form-control button pull-right" value="Search" >
												<a href="#" class="form-control button pull-right">Reset</a>
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
								 <th>SL NO.</th>
							    <th>Woman Name</th>
								<th>WID</th>
								<th>Days To <br/> Deliver</th>
								<th>Obstetric<br/> Score</th>
								<th>Name Of<br/> Asha</th>
								<th>Age</th>
								<th>Cast</th>
								<th>Findings</th>
								<th>Initial Clinical<br/> Assessment</th>
								<th>Assessment <br/>Status</th>
								<th>No Of<br/> Visit</th>
							</tr>
							</thead>
								<c:choose>
									<c:when test="${!(fn:length(masterReportList) eq 0)}">
										<c:forEach items="${masterReportList}" var="womanData">
											<tr>	
												<td data-title="SL NO."><div>${womanData.slNo}</div></td>							
												<td data-title="Woman Name"><div class="tableAllign">${womanData.fullName}</div></td>
												<td data-title="WID">${womanData.wid}</td>
												<td data-title="Days To Deliver">${womanData.daysToDeliver}</td>
												<td data-title="Obstetric Score">${womanData.obstetricScore}</td>
												<td data-title="Name Of Asha">${womanData.nameOfAsha}</td>
												<td data-title="Age">${womanData.age}</td>
												<td data-title="Cast">${womanData.cast}</td>
												<td data-title="Findings"><div class="tableAllign">${womanData.findings}</div></td>
												<td data-title="Initial Clinical Assessment"><div class="tableAllign">${womanData.clinicalAssesment}</div></td>
												<td data-title="Assessment Status">${womanData.clinicalStatus}</td>
												<td data-title="No Of Visit">${womanData.noOfVisit}</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
									<tr>
										<td colspan="12" style="color: red;">No Records Found</td>
									</tr>
									</c:otherwise>
								</c:choose>
							</table>
							<!-- Search Table Content End -->	
							<table class="table table-striped table-bordered table-condensed">
							<c:if test="${!(fn:length(masterReportList) eq 0) }">
							<tr class="table-footer-main">
								<td colspan="8" class="search-table-header-column">
									<div  class="col-sm-12">
										 <div class="col-sm-4">
											<div class="btn-toolbar" role="toolbar">
												<div class="btn-group custom-table-footer-button">
													<a id="export-to-excel" onclick="$('#serviceResults').tableExport({type:'excel',escape:'false',worksheetName:'Master Report'});">
													              <button type="button" class="btn btn-default"><img src="../images/excel.png"></button></a>
													<!-- <a id="export-to-pdf">
													             <button type="button" class="btn btn-default"><img src="../images/pdf.png" ></button></a> -->
												</div>
											</div>
										</div> 
											<div class="col-sm-8">
												<c:if test="${ !(fn:length(masterReportList) eq 0)}">
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
	<div id="beaconActivatePopDiv" class="locatioin-list-popup">
		<span class="glyphicon glyphicon-remove"
			onclick="closePopup();clearPopupDesc();"></span>
		<h2>Change Status</h2>
		 <form action="change-beacon-status" name ="statusBeaconForm" method="post">
			<input type="hidden" id="id" name="id" /> 
			<input type="hidden" id="status" name="status" /> 
			<label><span class="requiredFiled">*</span> Reason </label>
			<textarea id="reason" name="reason" maxlength="<%= JspConstants.REASON.toString() %>"
				onkeyup="checkMaxLength(this);clientValidation('reason', 'reason','popDescError_div')"></textarea>
			 <div class="discriptionErrorMsg" id="activateErr">
				            	     <span class="red-error">&nbsp;</span>
				                   </div>
			<!--Panel Action Button Start -->
			<div class="col-sm-12 form-action-buttons">
				<div class="col-sm-12">
					<input type="submit" class="form-control button pull-right submit-button" value="Submit" onclick="return submitBeaconStatus();">
				</div>
			</div>
		</form>
		<!--Panel Action Button End -->
		<p>Note: On changing the status, all associated users will become
			same status</p>
	</div>
	<!--Body Wrapper block End -->	

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../js/bootstrap.min.js"></script>	
	<script src="../js/jquery.datetimepicker.js"></script>
	<!--common script for all pages-->
	<script src="../js/common-lib.js"></script>
	<script src="../js/beacon.js"></script>
	<script src="../js/jquery.popupoverlay.js"></script>
	<script src="../js/common-lib.js"></script>
	<script src="../js/jquery.maskedinput.js"></script>
	<script src="../js_new/jspdf.debug.js"></script>
	<script src="../js_new/html2canvas.js"></script>
	<script src="../js_new/tableExport.js"></script>
	<script src="../js_new/jquery.base64.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('body').on("click", "#export-to-pdf", function () { 
				
				var doc = new jsPDF('l', 'pt', 'letter');
				
				doc.addHTML($('#serviceResults')[0], function () {
					doc.save('Case-Sheet-Report.pdf');				
				});
			});
		});
	</script>
	<script>		
	function closePopupActivate() {
		get('activateReason').value =null;
		$("#activateDiv").removeClass("has-error").removeClass("has-success");
		$("#activateErr").removeClass("visible");
		setDiv("activateErr", "");
		$('#beaconActivatePopDiv').popup("hide");
	}
	</script>
	<script>
	$('#beaconActivatePopDiv').popup({
		blur : false
	});
	</script>
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
			$( "#navListId3" ).addClass( "active-background" );
		}
		function closePopup() {
			setDiv("activateErr", "&nbsp;");
			$('#beaconActivatePopDiv').popup("hide");
		}
		/* Common Navigation Include End */
		$("#beaconName").focus();
	</script>
  </body>  
</html>