<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${null != teacher}">
<a  href="editUserById.html?userId=${teacher.getUser().getUserId()}">Edit User Details</a>
<a  href="editAddressById.html?addressId=${teacher.getUser().getAddress().getAddressId()}">Edit Address Details</a>
<a  href="editTeacher.html?teacherId=${teacher.getTeacherId()}">Edit Teacher Details</a>
</c:if>
<c:if test="${null != Message}">
                <c:out value="${Message}"/>
            </c:if>
</body>
</html>