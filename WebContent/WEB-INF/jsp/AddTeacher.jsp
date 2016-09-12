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
      <div  class="form">
    		<form:form id="contactform" action="addTeacher.html" method="POST" modelAttribute="Teacher"> 
    			<p class="contact"><label for="yearsOfExperience" path = "label1">Years Of Experience</label></p> 
    			<form:input path="yearsOfExperience" placeholder="Years Of Experience" required="" tabindex="1" type="text"/>

                        <p class="contact"><label for="monthsOfExperience" path = "label1">Months Of Experience</label><p> 
    			<form:input path="monthsOfExperience" placeholder="Months Of Experience" required="" tabindex="1" type="text"/>

                        <p class="contact"><label for="dateOfJoining" path = "label1">Date Of Joining (YYYY-MM-DD)</label><p> 
    			<form:input path="dateOfJoining" placeholder="Date Of Joining" required="" tabindex="1" type="text"/>

                        <p class="contact"><label for="designation" path = "label1">Designation</label></p> 
    			<form:input path="designation" placeholder="Designation" required="" tabindex="1" type="text"/>
                        
                        <form:select class="select-style gender" name="qualification" path="qualification">
                        <option value="select">Qualification</option>
                        <option value="B.Ed">B.Ed</option>
                        <option value="B.E">B.E</option>
                        <option value="B.Com">B.Com</option>
                        <option value="Graduate">Graduate</option>
                        </form:select><br><br>

                        <form:select class="select-style gender" name="maritalStatus" path="maritalStatus">
                        <option value="select">Marital Status</option>
                        <option value="Single">Single</option>
                        <option value="Married">Married</option>
                        </form:select><br><br> 

                        <form:input type = "hidden" path = "user.userId" value="${userId}"/>
                        
                       <input class="buttom" name="submit" id="submit" tabindex="5" value="Submit" type="submit"> 	 
                </form:form>
   <c:if test="${null != addMessage}">
                    <c:out value="${addMessage}"/>
                 </c:if> 
</div>
</div>

</body>
</html>