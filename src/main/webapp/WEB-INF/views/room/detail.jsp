<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="contentHeading">
  <h1>Room Management</h1>
</div>

<div class="contentBody">
  <!-- Content Here -->
  <div class="contentSubHeading">Room Detail</div>
  
    <div class="contentForm">
      <div class="divLeft">
        <div>
          <label><spring:message code="building.label.name" text="Title :" /></label>
          ${room.name}<em>*</em>
        </div>
        <div>
          <label><spring:message code="building.label.name" text="Decription :" /></label>
          ${room.description}<em>*</em>
        </div>
      </div>
      <div class="divRight">
        
      </div>
      <!--Button Bar -->
      <div class="contentBtn">
        <label>&nbsp;</label>
        <input type="button" onclick="document.location.href='<spring:url value="/room/" />'" class="cmdButton" value=" Go To List ">
      </div>
    </div>
  
<br>
  <!-- Content Ends Here -->
  <!-- Content Ends Here -->
  </div>