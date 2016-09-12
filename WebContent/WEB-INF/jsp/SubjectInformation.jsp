<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Demo Beautiful Registration Form with HTML5 and CSS3</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="css/style2.css" media="all" />
    <link rel="stylesheet" type="text/css" href="css/demo.css" media="all" />
</head>
<body>
<div class="container">
			<!-- freshdesignweb top bar -->
            <div class="freshdesignweb-top">
                <a href="http://www.freshdesignweb.com" target="_blank">Home</a>
                <span class="right">
                    <a href="http://www.freshdesignweb.com/beautiful-registration-form-with-html5-and-css3.html">
                        <strong>Back to the freshdesignweb Article</strong>
                    </a>
                </span>
                <div class="clr"></div>
            </div><!--/ freshdesignweb top bar -->
			<header>
				<h1><span>Tutorials</span> Demo Beautiful Registration Form with HTML5 and CSS3</h1>
            </header>       
      <div class="form">
    		<form:form id="contactform" action="addSubject.html" method="POST" modelAttribute="Subject"> 
    			<p class="contact"><label for="subjectCode" path = "label1">Subject Code</label></p> 
    			<form:input path="subjectCode" placeholder="Subject Code" required="" tabindex="1" type="text"/>

                        <p class="contact"><label for="subjectName" path = "label1">Subject Name</label><p> 
    			<form:input path="subjectName" placeholder="Subject Name" required="" tabindex="1" type="text"/>

                        <form:select class="select-style gender" path="standard.standardId">
	                     <option value="select">Standard</option>
                    	<c:forEach items="${standards}" var="standard">
                        <form:option value="${standard.standardId}">${standard.standardName}</form:option>
                        </c:forEach>
                        </form:select><br><br>
                        
                        <form:select class="select-style gender" path="teacher.teacherId">
	                     <option value="select">Subject Teacher</option>
                    	<c:forEach items="${teachers}" var="teacher">
                        <form:option value="${teacher.teacherId}">${teacher.getUser().getFirstName()}  ${teacher.getUser().getLastName()}</form:option>
                        </c:forEach>
                        </form:select><br><br>
            
            <input class="buttom" name="submit" id="submit" tabindex="5" value="Submit" type="submit"> 	 
   </form:form>
   <c:if test="${null != addMessage}">
                    <c:out value="${addMessage}"/>
                 </c:if> 
</div>
</div>

</body>
</html>