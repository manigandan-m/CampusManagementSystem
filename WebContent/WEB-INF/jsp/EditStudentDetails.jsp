<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <c:if test="${sessionScope['username']==null}" >
   <c:redirect url="Login.html"/>
</c:if>
<c:if test="${sessionScope['role']!='admin'}" >
     <c:redirect url="Logout.html"/>
</c:if>--%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
			<!-- freshdesignweb top bar -->
            <div class="freshdesignweb-top">
                <a href="home.html">Home</a>
                <span class="right">
                    <a href="Logout.html">
                        <strong>Logout</strong>
                    </a>
                </span>
                <div class="clr"></div>
            </div><!--/ freshdesignweb top bar -->
			<header>
				<h1>Edit Student Details</h1>
            </header>
            </div> 
<c:if test="${null != student}">
<a  href="editUserById.html?userId=${student.getUser().getUserId()}">Edit User Details</a>
<a  href="editAddressById.html?addressId=${student.getUser().getAddress().getAddressId()}">Edit Address Details</a>
<a  href="editStudent.html?rollNumber=${student.getRollNumber()}">Edit Student Details</a>
</c:if>
<c:if test="${null != Message}">
                <c:out value="${Message}"/>
            </c:if>
</body>
</html>