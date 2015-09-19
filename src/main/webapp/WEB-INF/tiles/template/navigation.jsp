<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<div id="leftBar" style="visibility: visible;">
	<script type="text/javascript">
		//========================================= Start Show/Hide Menu
		function showHide(visibility) {
			var str_cur_page = "block";
			var imgPath = "";
			document.all("leftMenuPanel").style.display = visibility;
			if (document.all("leftMenuPanel").style.display == "none") {
				document.all("hideImg").style.display = "none";
				document.all("showImg").style.display = "block";
				//document.cookie='menuStatus=hide; expires=; path='
			} else {
				document.all("hideImg").style.display = "block";
				document.all("showImg").style.display = "none";
				//document.cookie='menuStatus=show; expires=; path='
			}
		}
	</script>
	<style type="text/css">
#leftMenuPanel {
	display: block;
}

#showImg {
	display: none;
}

#hideImg {
	display: block;
}

.uploadbox {
	BORDER-TOP-WIDTH: 1px;
	BORDER-BOTTOM-WIDTH: 1px;
	BORDER-LEFT-WIDTH: 1px;
	BORDER-RIGHT-WIDTH: 1px;
	BACKGROUND-COLOR: #FFFFFF;
	border-color: #6699CC;
	FONT: 12px verdana;
	COLOR: #000000;
	border: 1px solid #000000
}
</style>
	<br /> 
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					id="leftMenuPanel" bgcolor="#EDEDED">
					<tr>
						<td valign="top">
							<div style="float: left" id="my_menu" class="sdmenu">

								<div>
									<span>Content Management</span> <a
										href="<spring:url value="/"/>">Menu Lists</a>
								</div>
								<div>
									<span>System Management</span> 
										<a href="<spring:url value="/building" />">Building</a>
										<a href="<spring:url value="/building/add" />">Add Building</a>
										<a href="<spring:url value="/room" />">Room</a>
										<a href="<spring:url value="/room/add" />">Add Room</a>
									
								</div>
								<div>
									<span>Member Management</span> 
										<a href="<spring:url value="/member" />">Member List</a> 
										<a href="<spring:url value="/member/register" />">Add Member</a>
								</div>
								<div>
									<span>Resource Management</span>
									<a href="<spring:url value="/items/list" />">Resource List</a>
									<security:authorize access="hasRole('ADMIN')"> 
										<a href="<spring:url value="/items/item.add" />">Add Resource</a>
										<a href="<spring:url value="/items/requests.resolve" />">Resolve Requests</a>
									</security:authorize>
									<security:authorize access="isAuthenticated()">
										<a href="<spring:url value="/items/list" />">Request Resource</a>
									</security:authorize>
								</div>

							</div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>
