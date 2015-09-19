<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resources - Resource Management</title>
</head>
<body>
	<div class="contentSubHeading">List of Items</div>
	<table width="100%" cellspacing="1" cellpadding="1" border="0" class="listing_table">
		<thead><th>ITEM CODE</th><th>NAME</th><th>CATEGORY</th><th>AVAILABILITY</th><th>DESCRIPTION</th><th>LOCATION</th><th>ACTION</th></thead>
		<c:forEach items="${resources }" var="resource">
		<tr>
		<td>${resource.itemCode }</td>
		<td>${resource.name }</td>
		<td>${resource.categoryItem.name }</td>
		<td>${resource.status }</td>
		<td>${resource.description }</td>
		<td>Building: ${resource.roomItem.building.name } <br/> Room: ${resource.roomItem.name }</td>
		<td>
			<security:authorize access="hasRole('ADMIN')">
				<a href="<spring:url value='/items/delete/${resource.id}'/>">Delete</a> | 
				<a href="<spring:url value='/items/edit/${resource.id}'/>">Edit</a> | 
			</security:authorize>
			<security:authorize access="isAuthenticated()">
				<c:set var="available" value="AVAILABLE"/>
				<c:if test="${resource.status eq available }">
					<a href="<spring:url value='/items/request/${resource.id}'/>">Request</a> |
				</c:if>
			</security:authorize>
			<a href="<spring:url value='/items/detail/${resource.id}'/>">View Detail</a>
		</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>