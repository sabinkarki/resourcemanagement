<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="contentHeading">
  <h1>Room Management</h1>
</div>

<div class="contentBody">
  <!-- Content Here -->
  <div class="contentSubHeading">${title}</div>
  
<form:form modelAttribute="room">
	<form:errors path="*"></form:errors>
    <div class="contentForm">
      <div class="divLeft">
      
      	<div>
          <label><spring:message code="building.label.name" text="Building :" /></label>
          <form:select path="building.id" >
          	<form:option value="">--Select Building--</form:option>
          	<form:options items="${buildingList}" />
          </form:select><em>*</em>
          <form:errors path="building.id" />
        </div>
        
        <div>
          <label><spring:message code="building.label.name" text="Title :" /></label>
          <form:input path="name" /><em>*</em>
          <form:errors path="name" />
        </div>
        <div>
          <label><spring:message code="building.label.name" text="Decription :" /></label>
          <form:textarea path="description" /><em>*</em>
          <form:errors path="description" />
        </div>
      </div>
      <div class="divRight">
        
      </div>
      <!--Button Bar -->
      <div class="contentBtn">
        <label>&nbsp;</label>
        <form:button class="cmdButton">${buttonName}</form:button>
        &nbsp;
        <input type="button" onclick="document.location.href='<spring:url value="/room/" />'" class="cmdButton" value=" Cancel ">
     
      </div>
    </div>
  </form:form>
  
<br>
  <!-- Content Ends Here -->
  <!-- Content Ends Here -->
  </div>