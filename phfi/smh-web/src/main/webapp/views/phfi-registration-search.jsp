<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="com.smh.constants.Constant"%>
<%@page import="com.smh.constants.JspConstants"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
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
						<span class="breadcrumb-text"><spring:message code="com.phfi.registration" /></span>
						 <span class="glyphicon glyphicon-play icon-font-size"></span>
						  <span class="breadcrumb-text"><spring:message code="com.phfi.search" /> </span>					
					</div>
					<!-- Breadcrumb End -->
					<!-- Tab Buttons Start -->
						<div class="tab-header-container-first active-background">
							<a href="#"><spring:message code="com.phfi.search" /></a>
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
								<form action="show-medical-case-sheet" name="viewCaseSheet" method="GET">
									<input type="hidden" name="uuid" id="uuid" />
								</form>
								<form action="getBeaconReport" name="downloadReport" method="post">
									<input type="hidden" id="downloadPageNumberId" name="downLoadPageNumber" /> 
									<input type="hidden" id="downloadTypeId" name="downloadType" />
								</form>
								<!--Success and Failure Message End-->
								<!-- Page Form Start -->
								<form:form action="process-phfi-registration-search" commandName="phfiRegistrationRequest" method="POST">
									<div class="col-sm-12">
										<div class="row">
											<div class="field-element-row">
											<fieldset class="col-sm-4"> 
													<label class="control-label" for=""><spring:message code="com.phfi.villageName" /></label>
													<form:input path="villageName" title="Beacon Name" id="villageName" cssClass="form-control" maxlength="<%=JspConstants.BEACON_NAME_MAXLEN %>"/>
													<div class="discriptionErrorMsg">
														<span id="beconNameErr" class="red-error">&nbsp;</span>
													</div> 
												</fieldset>												
												<fieldset class="col-sm-4"> 
													<label class="control-label" for=""><spring:message code="com.phfi.uuid" /></label>
													<form:input path="uid" title="UID" id="uid" cssClass="form-control" maxlength="<%=JspConstants.BEACON_UUID %>"/>
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
												<a href="beacon-mgmt-search" class="form-control button pull-right"><spring:message code="com.phfi.reset" /></a>
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
									<span><spring:message code="com.phfi.search" /></span>
								</td>
								<td class="search-table-header-column" style ="font-weight:bold;"><spring:message code="com.phfi.totalCount" /> ${totalCount}</td>
							</tr>
							</table>
							<!-- Search Table Header End -->
							<!-- Search Table Content Start -->
							<table id="serviceResults" class="table table-striped table-bordered table-responsive table-condensed tablesorter marginBM1 common-table">
								<thead>
							 <tr>
								<th><spring:message code="com.phfi.registrationDate" /></th>
							    <th><spring:message code="com.phfi.uid" /></th>
								<th><spring:message code="com.phfi.firstName" /></th>
								<th><spring:message code="com.phfi.lastName" /></th>
								<th><spring:message code="com.phfi.recentDateOfDelivery" /></th>
								<th><spring:message code="com.phfi.age" /></th>
								<th><spring:message code="com.phfi.bloodGroup" /></th>
								<th><spring:message code="com.phfi.lmp" /></th>
								<th><spring:message code="com.phfi.action" /></th>
							</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${!(fn:length(womanList) eq 0)}">
										<c:forEach items="${womanList}" var="womanData">
											<tr>	
												<td data-title="Registration Date"><div>${womanData.regDate}</div></td>							
												<td data-title="UID"><div class="tableAllign">${womanData.uid}</div></td>
												<td data-title="First Name">${womanData.womenFirstName}</td>
												<td data-title="Last Name">${womanData.womenSurname}</td>
												<td data-title="Recent Date Of Delivery">${womanData.dateOfRecentDelivery}</td>
												<td data-title="Age"><fmt:formatNumber type="decimal" value="${womanData.age}" pattern="<%=JspConstants.POWER_FORMAT %>"/></td>
												<td data-title="Blood Group">${womanData.bloodgroup}</td>
												<td data-title="LMP">${womanData.lmp}</td>
												<td><a href="javascript:viewMedicalCaseSheet('${womanData.uid}')" title="Edit"><span class="glyphicon glyphicon-pencil"></span></a></td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
									<tr>
										<td colspan="8" style="color: red;"><spring:message code="com.phfi.noRecordsFound" /></td>
									</tr>
									</c:otherwise>
								</c:choose>
							</tbody>
							</table>
							<!-- Search Table Content End -->	
							<table class="table table-striped table-bordered table-condensed">
							<c:if test="${!(fn:length(womanList) eq 0) }">
							<tr class="table-footer-main">
								<td colspan="8" class="search-table-header-column">
									<div  class="col-sm-12">
										 <div class="col-sm-4">
											<div class="btn-toolbar" role="toolbar">
												<div class="btn-group custom-table-footer-button">
													<a id="export-to-excel" onclick="$('#serviceResults').tableExport({type:'excel',escape:'false',ignoreColumn:'[8]',worksheetName:'Women Report'});">
													              <button type="button" class="btn btn-default"><img src="../images/excel.png"></button></a>
													<a id="export-to-pdf" >
													             <button type="button" class="btn btn-default"><img src="../images/pdf.png" ></button></a>
												</div>
											</div>
										</div> 
											<div class="col-sm-8">
												<c:if test="${ !(fn:length(womanList) eq 0)}">
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
		<h2><spring:message code="com.phfi.changeStatus" /></h2>
		 <form action="change-beacon-status" name ="statusBeaconForm" method="post">
			<input type="hidden" id="id" name="id" /> 
			<input type="hidden" id="status" name="status" /> 
			<label><span class="requiredFiled">*</span><spring:message code="com.phfi.reason" />  </label>
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
		<p><spring:message code="com.phfi.becomeSameStatus" /></p>
	</div>
	<!--Body Wrapper block End -->	

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <!-- <script src="../js/jquery.min.js"></script> -->
    <script src="../js_new/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
	<!--common script for all pages-->
	<script src="../js_new/registration.js"></script>
	 	<script src="../js/common-lib.js"></script>
	 	
	 	
	 	<script src="../js_new/tableExport.js"></script>
	 	<script src="../js_new/jquery.base64.js"></script>
	 	<!-- <script src="../js_new/sprintf.js"></script>
	 	<script src="../js_new/jspdf.js"></script>
	 	<script src="../js_new/base64.js"></script> -->
	 	
	 	<script src="../js_new/jspdf.debug.js"></script>
	 	
	 	<!-- <script src="../js_new/excelexport.js"></script> -->
	 	
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
	
	<script type="text/javascript">
		
		$(document).on("click", "#export-to-pdf", function () { 
			
			var pdf = new jsPDF('l', 'pt', 'letter');
			
			pdf.cellInitialize();
			
			pdf.setFontSize(10);
			
			pdf.text(350, 40, "Search Result");
			pdf.setLineWidth(1);
			pdf.line(700, 60, 80, 60); // horizontal line (width, x, y, scale)
			
		    $.each( $('#serviceResults tr'), function (i, row){
		        $.each( $(row).find("td, th"), function(j, cell){
		        	if(j <= 7) {
		        		var width = 80;
			            var txt = $(cell).text().trim() || " ";
			            if(j == 0) {
			            	width = 90;
			            } else if(j == 4) {
			            	width = 140;
			            }
			            pdf.cell(20, 100, width, 30, txt, i);		        		
		        	}
		        });
		    });

		    pdf.save('download.pdf');
			
			
			/* specialElementHandlers = {
		        '#bypassme': function (element, renderer) {
		            return true
		        }
		    };	
		
			doc.fromHTML($('#serviceResults')[0], 80, 80, {
				'width': 900, 
				'elementHandlers': specialElementHandlers
			}); 
			
			doc.save("Report.pdf");*/
			
			/* doc.addHTML($('#serviceResults')[0], function() {});
			setTimeout(function(){
				doc.save('Report.pdf');
			},1000); */

		});
		
		/* $("#export-to-excel").on('click',function () {
			//$("#serviceResults th:last-child, #serviceResults td:last-child").remove();
		   var excelData = $("#serviceResults").excelexport({
		        containerid: "serviceResults",
		        worksheetName:"PHFI Management Report",
		        reportDate:"Report Date: "+ "",
	            returnUri: true
		    });
		    $(this).attr('download', 'Report');
		    $(this).attr('href', excelData);
		    $(this).click();
		}); */
	</script>
  </body>  
</html>