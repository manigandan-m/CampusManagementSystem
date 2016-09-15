<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope['username']==null}" >
   <c:redirect url="Login.html"/>
</c:if>
<c:if test="${sessionScope['role']!='admin'}" >
     <c:redirect url="Logout.html"/>
</c:if>
<html>
    <head>
        <title>Campus Management</title>
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
	    <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/style2.css" media="all" />
        <link rel="stylesheet" type="text/css" href="css/demo.css" media="all" />
    </head>
<body>
<div class="container">
			<!-- freshdesignweb top bar -->
            <div class="freshdesignweb-top">
                <a href="home.html">Home</a>&nbsp;&nbsp;
                <a href="Standard.html">Go Back</a>
                <span class="right">
                    <a href="Logout.html">
                        <strong>Logout</strong>
                    </a>
                </span>
                <div class="clr"></div>
            </div><!--/ freshdesignweb top bar -->
			<header>
				<h1>Edit Class Coordinator</h1>
            </header>

<div  class="form">
<c:if test="${null != Standard}">
<form:form id = "contactform" action="editCoordinator.html" method="POST" modelAttribute="Standard">
<p class="contact"><label for="standardName" path = "label1">Standard Name</label></p>
<c:out value="${Standard.getStandardName()}" /><br></br>

<p class="contact"><label for="coordinatorName" path = "label1">Coordinator Name</label><p>
<form:select path="classCoordinator.teacherId">
                        <option value="select">select</option>
                        <form:option value="0">NONE</form:option>
                        <c:forEach items="${teachers}" var="teacher">
                        <form:option value="${teacher.teacherId}">${teacher.getUser().getFirstName()}  ${teacher.getUser().getLastName()}</form:option>
                        </c:forEach>
                        </form:select><br><br>
<form:input type = "hidden" path = "standardId" value="${standardId}"/>
<form:input type = "hidden" path = "standardName" value="${standardName}"/><br>
<input class="buttom" name="submit" id="submit" tabindex="5" value="Assign/Change" type="submit">
</form:form>
</c:if>
<c:if test="${null != message}">
                    <c:out value="${message}"/>
                </c:if>
</div>
</div>
</body>
</html>
