<%-- 
    Document   : setupschedule
    Created on : Sep 13, 2014, 11:30:53 AM
    Author     : sudarsan
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<fmt:setBundle basename="ApplicationResources" />
    <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/themes/smoothness/jquery-ui.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
    <script>
       
        $(function() {
            $( "#dateOfProgram" ).datepicker({
               dateFormat:"yy-mm-dd"});
            
         });
         
        function searchPresenter()
        {
            alert('Hi');
            window.open( "<%=request.getContextPath()%>"+"/controller/selectpresenter","myWindow", "status = 1, height = 300, width = 600, resizable = 0" ) ;
        }
        function searchProducer()
        {
            alert('Hi');
            window.open( "<%=request.getContextPath()%>"+"/controller/selectproducer","myWindow", "status = 1, height = 300, width = 600, resizable = 0" ) ;
        }
        function searchradioProgram()
        {
           window.open( "<%=request.getContextPath()%>"+"/controller/searchrp","myWindow", "status = 1, height = 300, width = 600, resizable = 0" ) ;
        }
    
         
    </script>
<title><fmt:message key="title.setupschedule" /></title>
</head>
<body>
    <c:if test="${(param['insert'] == 'true')}">
    <h1><fmt:message key="label.setupschedule.create"/></h1></c:if>
    <c:if test="${(param['modify'] == 'true')}">
    <h1><fmt:message key="label.setupschedule.modify"/></h1></c:if>
    <c:if test="${(param['clone'] == 'true')}">
    <h1><fmt:message key="label.setupschedule.clone"/></h1></c:if>
	<form action="${pageContext.request.contextPath}/controller/setupschedule" method=post name="setupschedule">
		<center>
			<table cellpadding=4 cellspacing=2 border=0>
				<tr>
				</tr>
				<tr>
					<td><fmt:message key="label.crudschedule.dateOfProgram" /></td>
					<td><c:if test="${(param['insert'] == 'true')||(param['clone'] == 'true')}">
						
                                                <input type="text" id="dateOfProgram" name="dateOfProgram" value="${param['dateOfProgram']}" size=15 maxlength=20 ></td>
							<input type="hidden" name="mod" value="false" />
                                                        
						</c:if> 
						<c:if test="${param['modify']=='true'}">
							<input type="text"  name="dateOfProgram" value="${param['dateOfProgram']}" size=15
								maxlength=20 readonly="readonly">
							<input type="hidden" name="mod" value="true" />
                                                        
						</c:if>
                                                        
                                        
				</tr>
                                <tr>
                                        <td><fmt:message key="label.crudschedule.startTime" /></td>
					<td><c:if test="${(param['insert'] == 'true')||(param['clone'] == 'true')}">
							<input type="text" name="startTime" value="${param['startTime']}" size=15
								maxlength=20>
							<input type="hidden" name="mod" value="false" />
						</c:if> 
						<c:if test="${(param['modify']=='true')}">
							<input type="text" name="startTime" value="${param['startTime']}" size=15
								maxlength=20 readonly="readonly">
							<input type="hidden" name="mod" value="true" />
						</c:if></td>
                                </tr>
                                <tr>
                                        <td><fmt:message key="label.crudschedule.duration" /></td>
					<td><c:if test="${(param['insert'] == 'true')||(param['clone'] == 'true')}">
							<input type="text" name="duration" value="${param['duration']}" size=15
								maxlength=20 readonly="readonly">
							<input type="hidden" name="mod" value="false" />
						</c:if> 
						<c:if test="${(param['modify']=='true')}">
							<input type="text" name="duration" value="${param['duration']}" size=15
								maxlength=20 readonly="readonly">
							<input type="hidden" name="mod" value="true" />
						</c:if></td>
                                </tr>
                                <tr>
					<td><fmt:message key="label.crudschedule.programName" /></td>
					<td><c:if test="${(param['insert'] == 'true')}">
							<input type="text" name="programName" id="programName" value="${param['programName']}" size=15
								maxlength=20>
							<input type="hidden" name="mod" value="false" />
                                                        <td> <input type="button" value="Select Radio Program" id="selectradioprogram" onclick="javascript:searchradioProgram()">
                                        </td>
						</c:if>
                                                        <c:if test="${(param['modify'] == 'true')}">
							<input type="text" name="programName" id="programName" value="${param['programName']}" size=15
								maxlength=20>
							<input type="hidden" name="mod" value="true" />
                                                        <td> <input type="button" value="Select Radio Program" id="selectradioprogram" onclick="javascript:searchradioProgram()"></td>
						</c:if>
						<c:if test="${param['clone']=='true'}">
							<input type="text" name="programName" id="programName" value="${param['programName']}" size=15
								maxlength=20 readonly="readonly">
							<input type="hidden" name="mod" value="false" />
						</c:if></td>
				</tr>
				<tr>
					<td><fmt:message key="label.crudschedule.presenter" /></td>
					<td>
                                            <c:if test="${(param['insert'] == 'true')}">
                                            <input type="text" name="presenter" id="presenter"
						value="${param['presenter']}" size=15 maxlength=20>
                                                <input type="hidden" name="mod" value="false" />
                                                 <input type="hidden" name="toggle" value="presenter" id="toggle"/>
                                                <td> <input type="button" value="Select Presenter" name="selectpresenter" onclick="javascript:searchPresenter();">
                                        </td>
						</c:if>
                                                
                                            <c:if test="${(param['modify'] == 'true')}">
                                            <input type="text" name="presenter" id="presenter"
						value="${param['presenter']}" size=15 maxlength=20>
                                                <input type="hidden" name="mod" value="true" />
                                                 <input type="hidden" name="toggle" value="presenter" id="toggle"/>
                                                <td> <input type="button" value="Select Presenter" name="selectpresenter" onclick="javascript:searchPresenter();">
                                        </td>
						</c:if>    
                                            <c:if test="${param['clone']=='true'}">
                                            <input type="text" name="presenter"
                                                   value="${param['presenter']}" size=15 maxlength=20 readonly="readonly">
                                            <input type="hidden" name="mod" value="false" />
                                            </c:if>
                                        </td>
				</tr>
				<tr>
					<td><fmt:message key="label.crudschedule.producer" /></td>
					<td><c:if test="${(param['insert'] == 'true')}">
                                            <input type="text" name="producer" id="producerval"
						value="${param['producer']}" size=15 maxlength=20>
                                            <input type="hidden" name="mod" value="false" />
                                             <input type="hidden" name="toggle" value="producer" id="toggle"/>
                                        <td> <input type="button" value="Select Producer" onclick="javaScript:searchProducer();">
                                        </td>
                                            </c:if>
                                            <c:if test="${(param['modify'] == 'true')}">
                                            <input type="text" name="producer" id="producerval"
						value="${param['producer']}" size=15 maxlength=20>
                                            <input type="hidden" name="mod" value="true" />
                                            <input type="hidden" name="toggle" value="producer" id="toggle"/>
                                            <td> <input type="button" value="Select Producer" onclick="javaScript:searchProducer();">
                                        </td>
                                            </c:if>
                                            <c:if test="${param['clone']=='true'}">
                                            <input type="text" name="producer"
                                                   value="${param['producer']}" size=15 maxlength=20 readonly="readonly">
                                            <input type="hidden" name="mod" value="false" />
                                            </c:if>
                                        
                                        </td>
				</tr>
			</table>
		
		<input type="submit" value="Submit"> <input type="reset"
			value="Reset">
                </center>
	</form>

</body>
</html>
