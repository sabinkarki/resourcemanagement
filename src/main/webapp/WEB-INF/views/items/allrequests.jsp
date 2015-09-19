<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<div class="contentSubHeading">List of Requests</div>
<table width="100%" cellspacing="1" cellpadding="1" border="0" class="listing_table">
		<thead><th>REQUESTING PERSON</th><th>REQUESTED ITEM</th><th>ACTION</th></thead>
		<c:forEach items="${requests }" var="request">
		<tr>
		<td>${request.member.name }</td>
		<td>${request.item.itemCode }<br/> ${request.item.name }</td>
		<td><a href="<spring:url value='/items/requestgranted/${request.id}'/>">Mark as Granted</a> | <a href="<spring:url value='/items/requestdiscarded/${request.id}'/>">Discard</a></td>
		</tr>
		</c:forEach>
</table>
</body>
</html>