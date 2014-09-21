<%-- 
    Document   : crudschedule
    Created on : Sep 12, 2014, 7:38:57 PM
    Author     : sudarsan
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<link href="<c:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
<fmt:setBundle basename="ApplicationResources" />
<title> <fmt:message key="title.crudschedule"/> </title>
</head>
<body>
        <h1><fmt:message key="label.crudschedule"/></h1>
        Select Year : 
        <select property="year">
            <c:forEach  var="yearList" items="${yearList}">
             <option value="${yearList.year}">${yearList.year}</option>
           </c:forEach>
            
        </select>
        
        <c:url var="url" scope="page" value="/pages/setupschedule.jsp">
        	<c:param name="dateOfProgram" value=""/>
                <c:param name="startTime" value=""/>
                <c:param name="duration" value=""/>
                <c:param name="programName" value=""/>
                <c:param name="presenter" value=""/>
                <c:param name="producer" value=""/>
                <c:param name="insert" value="true"/>
                <c:param name="modify" value="false"/>
                <c:param name="clone" value="false"/>
        </c:url>
        <a href="${url}"><fmt:message key="label.crudschedule.add"/></a>
        <br/><br/>
        <table class="borderAll">
            <tr>
                <th><fmt:message key="label.crudschedule.dateOfProgram"/></th>
                <th><fmt:message key="label.crudschedule.startTime"/></th>
                <th><fmt:message key="label.crudschedule.duration"/></th>
                <th><fmt:message key="label.crudschedule.programName"/></th>
                <th><fmt:message key="label.crudschedule.presenter"/></th>
                <th><fmt:message key="label.crudschedule.producer"/></th>
                <th><fmt:message key="label.crudschedule.edit"/> </th>
                <th><fmt:message key="label.crudschedule.delete"/></th>
                <th><fmt:message key="label.crudschedule.clone"/></th>
            </tr>
            <c:forEach var="crudschedule" items="${sch}" varStatus="status">
                <tr class="${status.index%2==0?'even':'odd'}">
                    <td class="nowrap">${crudschedule.dateOfProgram}</td>
                    <td class="nowrap">${crudschedule.startTime}</td>
                    <td class="nowrap">${crudschedule.duration}</td>
                    <td class="nowrap">${crudschedule.programName}</td>
                    <td class="nowrap">${crudschedule.presenter}</td>
                    <td class="nowrap">${crudschedule.producer}</td>
                    <td class="nowrap">
                        <c:url var="updurl" scope="page" value="/pages/setupschedule.jsp">
                            <c:param name="dateOfProgram" value="${crudschedule.dateOfProgram}"/>
                            <c:param name="startTime" value="${crudschedule.startTime}"/>
                            <c:param name="duration" value="${crudschedule.duration}"/>
                            <c:param name="programName" value="${crudschedule.programName}"/>
                            <c:param name="presenter" value="${crudschedule.presenter}"/>
                            <c:param name="producer" value="${crudschedule.producer}"/>
                            <c:param name="insert" value="false"/>
                            <c:param name="modify" value="true"/>
                            <c:param name="clone" value="false"/>
                        </c:url>
                        <a href="${updurl}"><fmt:message key="label.crudschedule.edit"/></a>
                    </td><td class="nowrap">
                        <c:url var="delurl" scope="page" value="/controller/deleteschedule">
                            <c:param name="dateOfProgram" value="${crudschedule.dateOfProgram}"/>
                            <c:param name="startTime" value="${crudschedule.startTime}"/>
                            <c:param name="duration" value="${crudschedule.duration}"/>
                        </c:url>
                        <a href="${delurl}"><fmt:message key="label.crudschedule.delete"/></a>
                    </td>
                    <td class="nowrap">    
                        <c:url var="cloneurl" scope="page" value="/pages/setupschedule.jsp">
                            <c:param name="dateOfProgram" value="${crudschedule.dateOfProgram}"/>
                            <c:param name="startTime" value="${crudschedule.startTime}"/>
                            <c:param name="duration" value="${crudschedule.duration}"/>
                            <c:param name="programName" value="${crudschedule.programName}"/>
                            <c:param name="presenter" value="${crudschedule.presenter}"/>
                            <c:param name="producer" value="${crudschedule.producer}"/>
                            <c:param name="insert" value="false"/>
                            <c:param name="modify" value="false"/>
                            <c:param name="clone" value="true"/>
                        </c:url>
                        <a href="${cloneurl}"><fmt:message key="label.crudschedule.clone"/></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
</body>
</html>