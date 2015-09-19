<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="contentHeading">
  <h1>Room Management</h1>
</div>

<div class="contentBody">
  <!-- Content Here -->
  <div class="contentSubHeading">List of Room</div>
  <table width="100%" cellspacing="1" cellpadding="1" border="0" class="listing_table">
    <tbody><tr>
      <th width="5%">S.No.</th>
      <th width="17%">Building Title</th>
      <th width="17%">Room Title</th>
      <th width="23%">Description</th>
      <th width="15%">Action</th>
    </tr>

    <c:forEach items="${roomList}" var="item" varStatus="count">
    <tr id="row-${count.count}">
      <td>${count.count}</td>
      <td>${item.building.name}</td>
      <td>${item.name}</td>
      <td>${item.description}</td>
      <td align="center">
      	<a href="<spring:url value="/room/edit/${item.id}" />"><img border="0" alt="Edit" src="<spring:url value="/resource/images/edit.gif" />"></a>&nbsp;&nbsp; 
      	<a onclick="return false;" data-action="delete-toggle" data-target="row-${count.count}"
      	href="<spring:url value="/room/delete/${item.id}" />"><img border="0" alt="Delete" src="<spring:url value="/resource/images/delete.png" />"></a></td>
    </tr>
    </c:forEach>
 
 </tbody></table>
<br>
  <!-- Content Ends Here -->
  <!-- Content Ends Here -->
  </div>