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
          <form:form id="contactform" action="addPeriodSubject.html" method="POST" modelAttribute="PeriodSubjectDetail">
          <form:select class="select-style gender" path="period.periodId">
	                     <option value="select"> Role </option>
                    	<c:forEach items="${periodList}" var="period">
                        <form:option value="${period.periodId}">${period.dayOfPeriod} ${period.startTimeOfPeriod} ${period.endTimeOfPeriod} </form:option>
                        </c:forEach>
                        </form:select><br><br>
                        
           <form:select class="select-style gender" path="subject.subjectCode">
	                     <option value="select"> Subject </option>
                    	<c:forEach items="${subjectList}" var="subject">
                        <form:option value="${subject.subjectCode}">${subject.subjectName} ${subject.getStandard.getStandardName()} ${subject.getTeacher().getUser().getFirstName()} ${subject.getTeacher().getUser().getLastName()} </form:option>
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