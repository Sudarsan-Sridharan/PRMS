<%-- 
    Document   : selectpresenterproducer
    Created on : Sep 20, 2014, 1:50:35 AM
    Author     : sudarsan
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<fmt:setBundle basename="ApplicationResources" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script type = "text/javascript">
  function onSelectpres(userName)
  {if('${role}'=="producer"){
  opener.document.setupschedule.producer.value=userName;
  }else
  {opener.document.setupschedule.presenter.value=userName;}
  self.close();
  }
  
</script>
Review/Select Presenter/Producer
<table border='1' cellpadding="1" cellspacing="1" width='100%' align='center'>
<tr>
<td>Select</td>

    <th align="left"><b> <fmt:message key="label.presenterSearch.producerName" /></b></th>
 
 </tr>
<c:forEach items="${users}" var="userBean">
    <tr  onClick="javaScript:onSelectpres('${userBean.id}');" onMouseOver="this.bgColor='silver';" onMouseOut="this.bgColor='white';" >

<td width='10%' align='left'><input type="radio" id ='radio' name ='radio' /></td>
  <td> ${userBean.id}</td>
 

  </tr> 
 
</c:forEach>
</table>
</body>
</html>
