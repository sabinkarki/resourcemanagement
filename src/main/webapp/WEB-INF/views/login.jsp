<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<form name="frmlogin" id="frmlogin"
	action="<spring:url value="/postLogin" />" method="post">
	<table width="428" border="0" align="center" cellpadding="4"
		cellspacing="0" bgcolor="#FFFFFF" class="outside_border">
		<tr>
			<td width="80" valign="top" class="admin_main_sub_sub">
				<div align="center">
					<br /> <img name="" src="<spring:url value="/resource/images/security.png"/>"
						width="64" height="64" alt="" /><br />
				</div></td>
			<td width="246" valign="middle" class="admin_main_sub">
				<table width="100%" height="124" align="center" style="background-color: rgb(241, 243, 245); padding: 8px;"
					class="outside_border_search_box">
					<tr align="left">
						<td class="admin_main_sub" height="23" colspan="2" align="left">
							<h1>User Login</h1>
							 <font color='red'><c:if test="${not empty error}">Unable to login: ${error}</c:if></font>
						</td>
					</tr>
					<tr align="center">
						<td height="6" colspan="6" class="admin_main_sub"></td>
					</tr>
					<tr>
						<td width="36%" height="23" align="right" class="admin_main_sub"
							nowrap><strong>Username :</strong></td>
						<td width="64%" class="admin_main_sub"><input name="username"
							id="username" type="text" class="required" value=""
							maxlength="50" title=" " /></td>
					</tr>
					<tr>
						<td height="23" align="right" class="admin_main_sub" nowrap><strong>Password
								:</strong></td>
						<td class="admin_main_sub"><input name="password"
							id="password" type="password" class="required" value=""
							maxlength="50" title=" " /></td>
					</tr>
					<tr>
						<td height="27" align="right" class="admin_main_sub">&nbsp;</td>
						<td valign="top" class="admin_main_sub">
							<div align="left">
								<input type="submit" name="btnLoginSubmit" value="Login"
									class="btnclass" /> &nbsp;&nbsp;
							</div>
						</td>
					</tr>

				</table>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<p align="left">Use a valid username and password to gain access
					to the application.</p>
			</td>
		</tr>
	</table>
</form>