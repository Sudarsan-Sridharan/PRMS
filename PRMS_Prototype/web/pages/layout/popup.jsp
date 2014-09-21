<%-- 
    Document   : popup
    Created on : Sep 16, 2014, 12:53:48 AM
    Author     : sudarsan
--%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="<c:url value='/css/main.css'/>" rel="stylesheet"
	type="text/css" />

<table class="borderAll">
	
	<tr>
		
		<td valign="top"><tiles:insertAttribute name="body" /></td>
	</tr>
	<tr>
		<td colspan="2"><tiles:insertAttribute name="footer" /></td>
	</tr>
</table>
