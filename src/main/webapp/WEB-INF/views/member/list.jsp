<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="contentHeading">
  <h1>Member Management</h1>
</div>

<div class="contentBody">
  <!-- Content Here -->
  <div class="contentSubHeading">Member List</div>
  <div>
  	<form method="get" onsubmit="return false;" id="frmSearch">
  	<input name="searchname" id="searchname" />
  	<button onclick="searchMember(this.form)">Search</button>
  	</form>
  </div>
  
  <table width="100%" cellspacing="1" cellpadding="1" border="0" class="listing_table" >
    <tr>
      <th width="5%">S.No.</th>
      <th width="17%">Full Name </th>
      <th width="21%">Email Address </th>
      <th width="23%">Username</th>
      <th width="19%">Gender</th>
      <th width="20%">Image</th>
      <th width="15%">Action</th>
    </tr>
    <tbody id="membertablelist">
	<c:forEach items="${memberList}" var="item" varStatus="count">
    <tr id="row-${count.count}">
      <td>${count.count}</td>
      <td>${item.name}</td>
      <td>${item.email}</td>
      <td>${item.username}</td>
      <td>${item.gender}</td>
      <td><img src="<spring:url value="/resource\\memberImages\\${item.imageUrl}" />" width="90px"/></td>
      <td align="center">
      	<a href="<spring:url value="/member/edit/${item.id}" />"><img border="0" alt="Edit" src="<spring:url value="/resource/images/edit.gif" />"></a>&nbsp;&nbsp; 
      	<a onclick="return false;" data-action="delete-toggle" data-target="row-${count.count}"
      	href="<spring:url value="/member/delete/${item.id}" />"><img border="0" alt="Delete" src="<spring:url value="/resource/images/delete.png" />"></a></td>
    </tr>
    </c:forEach>
 
 </tbody></table>
<br>
  <!-- Content Ends Here -->
  <!-- Content Ends Here -->
  </div>