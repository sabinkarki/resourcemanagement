<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="contentHeading">
  <h1>Building Management</h1>
</div>

<div class="contentBody">
  <!-- Content Here -->
  <div class="contentSubHeading">${title}</div>
  
<form:form modelAttribute="building">
    <div class="contentForm">
      <div class="divLeft">
        <div>
          <label><spring:message code="building.label.name" text="Title :" /></label>
          <form:input path="name" /><em>*</em>
          <form:errors path="name" cssClass="error" />
        </div>
        <div>
          <label><spring:message code="building.label.name" text="Decription :" /></label>
          <form:textarea path="description" /><em>*</em>
          <form:errors path="description" cssClass="error" />
        </div>
      </div>
      <div class="divRight">
        
      </div>
      <!--Button Bar -->
      <div class="contentBtn">
        <label>&nbsp;</label>
        <form:button class="cmdButton">${buttonName}</form:button>
        &nbsp;
        <input type="button" onclick="document.location.href='<spring:url value="/building/" />'" class="cmdButton" value=" Cancel ">
      </div>
      
    </div>
  </form:form>
  
<br>
  <!-- Content Ends Here -->
  <!-- Content Ends Here -->
  </div>