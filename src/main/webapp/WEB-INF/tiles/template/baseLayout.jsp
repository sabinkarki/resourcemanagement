<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><tiles:insertAttribute name="title" /></title>
<link rel="icon" type="image/png" href="<spring:url value="/resource/images/favicon.png" />"/>

<link href="<spring:url value="/resource/css/style.css" />" rel="stylesheet" type="text/css" />
<link href="<spring:url value="/resource/css/color.css" />" rel="stylesheet" type="text/css" />
<link href="<spring:url value="/resource/css/button.css" />" rel="stylesheet" type="text/css" />
<link href="<spring:url value="/resource/css/Font_1.css" />" rel="stylesheet" type="text/css" />
<link href="<spring:url value="/resource/css/sdmenu.css" />" rel="stylesheet" type="text/css" />

<!-- for calender used jquery-ui -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script type="text/javascript" src="<spring:url value="/resource/js/jquery-1.11.3.min.js" />"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script type="text/javascript" src="<spring:url value="/resource/js/sdmenu.js" />"></script>
<script type="text/javascript" src="<spring:url value="/resource/js/site.js" />"></script>
</head>

<body>
	
<div id="pageBody" align="center">
      <div id="Header">
    <div id="CompanyLogo">

        <img src="<spring:url value="/resource/images/companyLogo.jpg" />"  alt="Code Karma" controls="controls" 
        width='200px' />
		<br />
    </div>
      <div id="GlobalLink">
        <ul>
        	<li>Language :</li>
			<li><a href="?language=en_US">English</a> | </li>
        	<li><a href="?language=np">Nepali</a> | </li>
            <li>[<security:authorize access="isAuthenticated()"> <a href="<spring:url value="/logout"/>" >Logout</a> </security:authorize>
		            	<security:authorize access="isAnonymous()"> <a href="<spring:url value="/login"/>" >Login</a> </security:authorize>]</li>
        </ul>
    </div>
	<div id="GlobalBar">Be Good Do Good - Control Panel</div>
       
</div>
        <div id="mainContent">
            <table style="width: 100%; " border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="" align="left">
                        <tiles:insertAttribute name="navigation" />
                    </td>
                    <td width="" align="left" >
                         
                         <div id="showHideLeftBar" class="showHideLeftBarActive" onclick="ToogleElementView('leftBar');ToogleElementClass(this.id,'showHideLeftBarActive','showHideLeftBarInActive');">&nbsp;
                         </div>
                      
                    </td>
                    <td width="100%" align="left" style="border-left:solid 1px #DCDCDC;;">
                        <div id="rightContent">
                            	<tiles:insertAttribute name="body" />
                     	</div>
                    </td>
                </tr>
            </table>
        </div>
        <div id="footer">
			<tiles:insertAttribute name="footer" />
		</div>
    </div>

</body>
</html>
