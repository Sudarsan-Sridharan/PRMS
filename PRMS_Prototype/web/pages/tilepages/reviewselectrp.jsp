<%-- 
    Document   : reviewselectrp
    Created on : Sep 15, 2014, 11:52:57 PM
    Author     : sudarsan
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<fmt:setBundle basename="ApplicationResources" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:message key="title.searchrp" /></title>
<script>
    function onSelectrp(programName)
  {
      alert('Hi');
  opener.document.setupschedule.programName.value=programName;
  
  self.close();
  }

</script>
</head>
<body>
	<h2>
		<fmt:message key="title.searchrp" />
	</h2>
	<form name="reviewselrp" action="${pageContext.request.contextPath}/controller/searchrp"
		method=post>
		
	</form>
	<c:if test="${! empty  searchrplist}">
		<table class="borderAll">
			<tr>
                                <th><fmt:message key="label.radioprogram.select" /></th>
				<th><fmt:message key="label.radioprogram.name" /></th>
				<th><fmt:message key="label.radioprogram.description" /></th>
				<th><fmt:message key="label.radioprogram.duration" /></th>
			</tr>
			<c:forEach var="rprogram" items="${searchrplist}" varStatus="status">
				<tr class="${status.index%2==0?'even':'odd'}" onclick="javaScript:onSelectrp('${rprogram.name}');">
                                    <td class="nowrap"> <input type="radio" name="selrp"  /> </td>
					<td class="nowrap">${rprogram.name}</td>
					<td class="nowrap">${rprogram.description}</td>
					<td class="nowrap">${rprogram.typicalDuration}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
                                        
</body>
</html>
