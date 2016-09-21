<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope['username']==null}" >
   <c:redirect url="Login.html"/>
</c:if>
<c:if test="${sessionScope['role']!='admin'}" >
     <c:redirect url="Logout.html"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<title>Campus Management</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="css/style2.css" media="all" />
    <link rel="stylesheet" type="text/css" href="css/demo.css" media="all" />
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
</head>
<body>
<div class="container">
			<!-- freshdesignweb top bar -->
            <div class="freshdesignweb-top">
                <a href="home.html">Home</a>&nbsp;&nbsp;
                <a href="displayTeachers.html">Teachers</a>
                <span class="right">
                    <a href="Logout.html">
                        <strong>Logout</strong>
                    </a>
                </span>
                <div class="clr"></div>
            </div><!--/ freshdesignweb top bar -->
			<header>
				<h1>Edit Teacher Details</h1>
            </header>       
      <div  class="form">
           <form:form id="contactform" action="editTeacher.html" method="POST" modelAttribute="Teacher"> 
                
                <form:select class="select-style gender" name="yearsOfExperience" path="yearsOfExperience">
                        <option value="yearsOfExperience">Years Of Experience</option>
                        <option value="0">0</option>
                        <option value="01">01</option>
                        <option value="02">02</option>
                        <option value="03">03</option>
                        <option value="04">04</option>
                        <option value="05">05</option>
                        <option value="05">05</option>
                        <option value="06">06</option>
                        <option value="07">07</option>
                        <option value="08">08</option>
                        <option value="09">09</option>
                        <option value="10">10</option>
                        </form:select><br><br>
                        
                <form:select class="select-style gender" name="monthsOfExperience" path="monthsOfExperience">
                        <option value="monthsOfExperience">Months Of Experience</option>
                        <option value="0">0</option>
                        <option value="01">01</option>
                        <option value="02">02</option>
                        <option value="03">03</option>
                        <option value="04">04</option>
                        <option value="05">05</option>
                        <option value="05">05</option>
                        <option value="06">06</option>
                        <option value="07">07</option>
                        <option value="08">08</option>
                        <option value="09">09</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        </form:select><br><br>
                
                <p class="contact"><label for="dateOfJoining" path = "label1">Date Of Joining (YYYY-MM-DD)</label><p> 
    			<form:input path="dateOfJoining" id="datepicker" placeholder="Date Of Joining" required="" tabindex="1" type="text"/>

                        <form:select class="select-style gender" name="designation" path="designation">
                        <option value="select">Designation</option>
                        <option value="Teacher">Teacher</option>
                        <option value="Senior Teacher">Senior Teacher</option>
                        </form:select><br><br>
                                                
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
                        <form:input type = "hidden" path = "teacherId" value="${teacherId}"/>
                        <form:input type = "hidden" path = "user.userId" value="${userId}"/>
                        
                       <input class="buttom" name="submit" id="submit" tabindex="5" value="Submit" type="submit"> 	 
                </form:form>
   <c:if test="${null != Message}">
                    <c:out value="${Message}"/>
                 </c:if> 
</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
   <script src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>
   <script>
       $.validate({
       lang: 'en'
        });
   </script>

<script>
  $(document).ready(function() {
	  var date = new Date(2012-09-10);
	$("#datepicker").datepicker({
    	minDate: new Date(date),	
        dateFormat:'yy-mm-dd',
        changeYear:true,
        yearRange:'1980:2100'
        
    });
  });
  </script>
</body>
</html>