<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<div class="contentSubHeading">Request added successfully</div>
<c:set var="base" value="/resource/itemsimages/"></c:set>
	<spring:url value="${base }${ request.item.imageUrl}" var="imagesource"/>
<table cellspacing="1" cellpadding="1" border="0" class="listing_table">
<tr><td>Request Number: </td><td>${request.id }</td></tr>
<tr><td>Requesting Person: </td><td>${request.member.name }</tr>
<tr><td>Item: </td><td>Code: ${request.item.itemCode }<br/>
					   Name: ${request.item.name }<br/>
					   Category:${request.item.categoryItem.name }<br/><br/>
					   <img src="${imagesource }" alt="No Image Found" height="150px"/></td></tr>
<tr><td>Request Date:</td><td>${request.requestdate }</td></tr>
</table>
<br/>
<br/>
Note: Save/print this confirmation page.
</body>
</html>