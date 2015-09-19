<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
 <a href="member/register">Register</a>
 Language : <a href="?language=en_US">English</a>|<a href="?language=np">Nepali</a>

<P>  The time on the server is ${serverTime}. </P>
<a href='<spring:url value="/members/add" />'>Add member</a>
<br/>

<a href='<spring:url value="items/item.add" />'>Add Item</a>

<br/>
<a href='<spring:url value="items/list" />' > List Items</a>

<br/>
<a href='<spring:url value="/logout" />' > Logout</a>
</body>
</html>
