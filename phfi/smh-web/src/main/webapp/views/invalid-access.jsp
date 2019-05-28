<!doctype html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PHFI</title>
    <link rel="icon" href="../images/favicon.png" type="image/png">
	<link  type="text/css" rel="stylesheet" href="../css/bootstrap.min.css">
    <link  type="text/css" rel="stylesheet" href="../css/bootstrap-theme.min.css">
    <link href="../css/main.css" rel="stylesheet"/>
    <link href="../css/style.css" rel="stylesheet" />
	<script src="../js/login.js" type="text/javascript"></script>
	 <script src="../js/prepaid-lib.js" type="text/javascript"></script>
	   <script src="../js/backbutton.js" type="text/javascript"></script>
   
</head>
<body>	
	<div id="wrapper">
		<div class="container-fluid prepaid-admin-dashboard">
			<header class="col-sm-12 content-wrapper">
				<div class="col-sm-4"> 
					<img class="login-logo-size" src="../images/smh.PNG" height="81px" width="100px" class="subPageLogo" alt="Prepaid Heading">
				</div>				
			</header> <!-- all-page-header end -->			
			<!-- Dashboard Content start - end -->
			<article> 
				<div class="col-xs-12 content-wrapper login-page-content">
					<label class="font-style-text"> Invalid access! <a href="login">Please Click here To login</a></label>
				</div>
			</article>
			<!-- Dashboard Content start - end -->
			<footer class="footer">
			<jsp:include page="footer.jsp"></jsp:include>
			</footer>
		</div><!-- prepaid-admin-dashboard End -->
	</div>	
</body>
</html>