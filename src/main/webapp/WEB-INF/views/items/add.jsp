<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Resource- Resource Management</title>
</head>
<body>
	<div class="contentSubHeading">Add new item:</div>
	<spring:url var = "action" value="/items/item.add"/>
	<form:form modelAttribute="newItem" action="${action }" method="POST" enctype="multipart/form-data">	
		<table cellspacing="1" cellpadding="1" border="0" class="listing_table">
		<tr><td>
		Item Code:</td><td> <form:input id="itemCode" path="itemCode"/>
					<form:errors path="itemCode"/></td></tr>
		<tr><td>
		Name: </td><td><form:input id="name" path="name"/>
			  <form:errors path="name"/></td></tr>
			  
		<tr><td>
		Description:</td><td> <form:input id="description" path="description"/> 
					 <form:errors path="description"/></td></tr>
		
		<tr><td>
		Category:</td><td><form:select path="categoryItem.id" items="${categories }" itemValue="id" itemLabel="name"></form:select>
				<form:errors path="categoryItem.id"/></td></tr>
				
		<tr><td>
		Location:</td><td>
		Building: 
		<form:select id="buildingId" path="roomItem.building.id" items="${buildings }" itemValue="id" itemLabel="name" onchange="getRoomsForBuilding('#buildingId','#roomItem_id')"></form:select>, 
		Room: 
		<form:select id="roomItem_id" path="roomItem.id"/> 
		<form:errors path="roomItem.building.id"/>
		<form:errors path="roomItem.id"/></td></tr>
		<tr><td>
		Image: </td><td><form:input path="image" type="file"/>
		<form:errors path="image"/></td></tr>
		</table>
		<input type="submit" value="Add"/><br/>
	</form:form>
</body>
</html>