<%-- 
    Document   : generalerror
    Created on : Sep 12, 2014, 4:21:45 PM
    Author     : sudarsan
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<fmt:setBundle basename="ApplicationResources" />
<c:set var="t" value="true" />
<title><fmt:message key="title.error" /></title>
</head>
<body>
	<h2>
            <c:if test="${! empty  errorMessage}">
                ${errorMessage}
            </c:if>
	</h2>
</body>
