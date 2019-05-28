<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<spring:message code="chatak.dashboard.feature.id" var="dashboard"></spring:message>
<spring:message code="chatak.myprofile.feature.id" var="myprofileView"></spring:message>

<spring:message code="chatak.setUp.feature.id" var="setUp"></spring:message>
<spring:message code="chatak.role.feature.id" var="role"></spring:message>
<spring:message code="chatak.role.view.feature.id" var="roleView"></spring:message>
<spring:message code="chatak.role.create.feature.id" var="roleCreate"></spring:message>
<spring:message code="chatak.role.edit.feature.id" var="roleEdit"></spring:message>
<spring:message code="chatak.role.activate.feature.id" var="roleActivate"></spring:message>
<spring:message code="chatak.role.delete.feature.id" var="roleDelete"></spring:message>
<spring:message code="chatak.role.suspend.feature.id" var="roleSuspend"></spring:message>

<spring:message code="chatak.user.feature.id" var="user"></spring:message>
<spring:message code="chatak.user.view.feature.id" var="userView"></spring:message>
<spring:message code="chatak.user.create.feature.id" var="userCreate"></spring:message>
<spring:message code="chatak.user.edit.feature.id" var="userEdit"></spring:message>
<spring:message code="chatak.user.activate.feature.id" var="userActivate"></spring:message>
<spring:message code="chatak.user.delete.feature.id" var="userDelete"></spring:message>
<spring:message code="chatak.user.suspend.feature.id" var="userSuspend"></spring:message>



 <style>
.dropdown-menu>li
{	position:relative;
	-webkit-user-select: none; /* Chrome/Safari */        
	-moz-user-select: none; /* Firefox */
	-ms-user-select: none; /* IE10+ */
	/* Rules below not implemented in browsers yet */
	-o-user-select: none;
	user-select: none;
	cursor:pointer;
}
/* .dropdown-menu .sub-menu {
    left: 100%;
    position: absolute;
    top: 0;
    display:none;
    margin-top: -1px;
	border-top-left-radius:0;
	border-bottom-left-radius:0;
	border-left-color:#fff;
	box-shadow:none; 
	color: #d6d6d6 !important;
}
 */


 .dropdown-menu .sub-menu {
 position: absolute;
  top: 100%;
  left: 0;
  z-index: 1000;
  display: none;
  float: left;
  min-width: 160px;
  padding: 5px 0;
  margin: 2px 0 0;
  font-size: 14px;
  list-style: none;
  background-color: #fff;
  background-clip: padding-box;
  border: 1px solid #ccc;
  border: 1px solid rgba(0, 0, 0, .15);
  border-radius: 4px;
  -webkit-box-shadow: 0 6px 12px rgba(0, 0, 0, .175);
          box-shadow: 0 6px 12px rgba(0, 0, 0, .175);
 }
.right-caret:after,.left-caret:after
 {	content:"";
    border-bottom: 5px solid transparent;
    border-top: 5px solid transparent;
    display: inline-block;
    height: 0;
    vertical-align: middle;
    width: 0;
	margin-left:5px;
}
.right-caret:after
{	border-left: 5px solid #ffaf46;
}
.left-caret:after
{	border-right: 5px solid #ffaf46;
}

  </style> 

<header class="col-sm-12 all-page-header">
	<!--Header Logo Start -->
	<div class="col-sm-4">
	<img src="../images/smh.PNG" height="40px" width ="180"  alt="Logo" />
	</div>
	<!--Header Logo End -->
	<!--Header Welcome Text and Logout button Start -->
	<div class="col-sm-6 col-xs-offset-3">
		<div class="pull-right user-settings">
			<span>Welcome ${loginUser}  </span>
			<span>&nbsp;&nbsp;&nbsp;&nbsp;<a href="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></span>
		</div>
	</div>
</header>
<nav class="col-sm-12 nav-bar" id="navigation">

	<ul class="navigation">
		<c:if test="${fn:contains(existingFeatures,dashboard)}">
			<li id="navListId1"><a href="dashboard">Dashboard</a>
		</c:if>
		<c:if test="${fn:contains(existingFeatures,myprofileView)}">
			<ul class="dropdown-menu" role="menu">
				<li class="transperent-background"></li>
				<li><a href="my-profile">My Profile</a></li>

			</ul>
		</c:if>
		<!-- 	</li> -->
		<c:if test="${fn:contains(existingFeatures,setUp)}">
			<li id="navListId2" class="dropdown"><a href="#"
				class="dropdown-toggle" data-toggle="dropdown">Set Up</a> <!--Navigation Block Sub Menu Start -->
				<ul class="dropdown-menu" role="menu">
					<li class="transperent-background"></li>
					<c:if test="${fn:contains(existingFeatures,role)}">
						<li><a href="access-role-search-page">Role</a>
						
						</li>
						
					</c:if>
					<c:if test="${fn:contains(existingFeatures,user)}">
						<li><a href="user-mgmt-search">User</a></li>
					</c:if>
				</ul></li>
		</c:if>
		
		<%-- <li id="navListId3" class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Input</a> 
		<ul class="dropdown-menu" role="menu">
		<li class="transperent-background"></li>
		<li><a href="#" class="trigger">Asha</a>
			<ul class="dropdown-menu sub-menu">
				<li class="transperent-background"></li>
				<li><a id="navListId3" href="show-phfi-registration-form"><spring:message code="phfi.nav.registration" /></a></li>
				<li><a href="#"><spring:message code="phfi.nav.visit" /></a></li>
				<li><a href="show-phfi-delivery-visit-form"><spring:message code="phfi.nav.delivery" /></a></li> 
			</ul>
		</li>
		<li><a href="#" class="trigger">Doctor</a>
			<ul class="dropdown-menu sub-menu" style="min-width: 175px;">
			<li><a href="#" ><spring:message code="phfi.nav.ratify" /></a></li>
				<li><a href="#"><spring:message code="phfi.nav.medical.details" /></a></li>
				</ul></li>
		</ul></li>


		<li id="navListId2" class="dropdown"><a href="#"
			class="dropdown-toggle" data-toggle="dropdown">Reports</a> 
			<ul class="dropdown-menu" role="menu">
				<li class="transperent-background"></li>
					<li><a href="#">List of women</a></li>
					<li><a href="#">Asha feedback report</a></li>
					<li><a href="#">Medical Case Sheet: Basic</a></li>
					<li><a href="#">Medical Case Sheet : Advanced</a></li>
					<li><a href="#">Master Raw Data</a></li>
			</ul>
		</li>

		<li id="navListId6" ><a href="show-phfi-visit-form">Visit Form</a></li>
		<li id="navListId4" ><a href="show-phfi-postpartum-visit-form">Postpartum Visit Form</a></li>
		<li id="navListId5" ><a href="show-phfi-delivery-visit-form">Delivery Form</a></li>
 --%>		
	</ul>
	<!--Header Welcome Text and Logout button End -->
</nav>
<!-- <script src="../js/backbutton.js" type="text/javascript"></script>
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script> -->
<script>
	/*Select li full area function Start */
	$("li").click(function() {
		window.location = $(this).find("a").attr("href");
		return false;
	});
</script>
<script>

   $(function(){
	   $(".dropdown-toggle").hover(function(e){
		   $(".sub-menu").hide();
		   });
	$(".dropdown-menu > li > a.trigger").hover(function(e){
		var current=$(this).next();
		var grandparent=$(this).parent().parent();
		if($(this).hasClass('left-caret')||$(this).hasClass('right-caret'))
			$(this).toggleClass('right-caret left-caret');
		grandparent.find('.left-caret').not(this).toggleClass('right-caret left-caret');
	 	grandparent.find(".sub-menu:visible").not(current).hide();
		current.toggle();
		e.stopPropagation();
	},function(){
		var root=$(this).closest('.dropdown');
		root.find('.left-caret').toggleClass('right-caret left-caret');
		//root.find('.sub-menu:visible').hide();
	});
	$(".dropdown-menu > li > a:not(.trigger)").on("click",function(){
		var root=$(this).closest('.dropdown');
		root.find('.left-caret').toggleClass('right-caret left-caret');
	//	root.find('.sub-menu:visible').hide();
	});
});  
</script>

