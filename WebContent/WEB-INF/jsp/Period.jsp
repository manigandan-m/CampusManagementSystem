<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%-- <c:if test="${sessionScope['username']==null}" >
   <c:redirect url="Login.html"/>
</c:if>
<c:if test="${sessionScope['role']!='admin'}" >
     <c:redirect url="Logout.html"/>
</c:if>--%>
<!DOCTYPE html>
<html>
<head>
<title>Period</title>
</head>
<body>
<a href = "AddPeriod.html">Add Period </a>
<a href = "deleteperiod.html">Delete Period</a>
<a href = "displayperiods.html">View all periods</a>
</body>
</html>