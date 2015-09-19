<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="contentHeading">
	<h1>Member Management</h1>
</div>

<div class="contentBody">
	<!-- Content Here -->
	<div class="contentSubHeading">
		<spring:message code="Registration" />
	</div>

	<c:if test="${errMessage != null}">
 			${errMessage}
		</c:if>
	<form:form method="post" modelAttribute="member" enctype="multipart/form-data">
		<div class="contentForm">
			<div class="divLeft">
				<div>
					<label><spring:message code="member.name" /></label>
					<form:input path="name" />
					<em>*</em>
					<form:errors path="name" cssClass="error" />
				</div>
				<div>
					<label><spring:message code="member.email"/></label>
					<form:input path="email" />
					<form:errors path="email" />
				</div>
				<div>
					<label><spring:message code="member.gender" /></label>
					<form:radiobutton path="gender" value="M" />Male <form:radiobutton
							path="gender" value="F" />Female <form:errors path="gender" />
					<form:errors path="gender" />
				</div>
				
				<div>
					<label><spring:message code="member.dob"/></label>
					<form:input path="dob" class="date-picker"/>
					<form:errors path="dob" />

				</div>
				<div>
					<label><spring:message code="member.address"/></label>
					<form:textarea path="address" />
					<form:errors path="address" />
				</div>
				<div>
					<label><spring:message code="member.image"/></label>
					<form:input path="image" type="file"/>
				</div>
			</div>
			<!-- right side -->
			<div class="divRight">
				<div>
					<label><spring:message code="member.username"/></label>
					<form:input path="username" />
					<form:errors path="username" />
				</div>
				<div>
					<label>Edit Password</label> <input type="checkbox"
						name="enablePasswordChange" id="enablePasswordChange" />
				</div>
				
				<div>
					<label><spring:message code="member.password"/></label>
					<form:password path="password" />
					<form:errors path="password" />

				</div>
				<div>
					<label><spring:message code="member.retype"/></label>
					<form:password path="retype" />
				</div>
			
			</div>
			<!-- right ends -->
			<!--Button Bar -->
			<div class="contentBtn">
				<label>&nbsp;</label>
				<form:button class="cmdButton">Edit</form:button>
				&nbsp; <input type="button"
					onclick="document.location.href='<spring:url value="/member/" />'"
					class="cmdButton" value=" Cancel ">
			</div>
		</div>
	</form:form>
	<br>
	<!-- Content Ends Here -->
	<!-- Content Ends Here -->
</div>
<script>
	$("#enablePasswordChange").on("change", function() {
		if ($(this).is(":checked")) {
			$("#password, #retype").removeAttr("disabled");
			$("#password, #retype").removeAttr("readonly");
		} else {

			$("#password, #retype").attr("disabled", "disabled");
			$("#password, #retype").attr("readonly", "readonly");

		}

	}).change();
	$(function() {
	    $('.date-picker').datepicker( {
	        changeMonth: true,
	        changeYear: true,
	        showButtonPanel: true,
	        dateFormat: 'mm/dd/yy',
	        onClose: function(dateText, inst) { 
	            var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
	            var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
	            $(this).datepicker('setDate', new Date(year, month, 1));
	        }
	    });
	});
</script>