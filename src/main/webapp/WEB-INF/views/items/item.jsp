<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<div class="contentSubHeading">Item added:</div>
<c:set var="base" value="/resource/itemsimages/"></c:set>
	<spring:url value="${base }${ item.imageUrl}" var="imagesource"/>
<table cellspacing="1" cellpadding="1" border="0" class="listing_table">
<tr><td>
	Name: </td><td>${item.name} </td></tr>
	<tr><td>Item Code:</td><td> ${item.itemCode}</td></tr>
	<tr><td>Description:</td><td> ${item.description }</td></tr>
	<tr><td>Status: </td><td>${item.status } </td></tr>	
	<tr><td>Image: </td><td><img src="${imagesource }" alt="Image Not Found" height="250px"/></td></tr>
	</table>
</body>
</html>