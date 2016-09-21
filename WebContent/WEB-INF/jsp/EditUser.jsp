<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
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
                <a href="home.html">Home</a>
                <span class="right">
                    <a href="Logout.html">
                        <strong>Logout</strong>
                    </a>
                </span>
                <div class="clr"></div>
            </div><!--/ freshdesignweb top bar -->
			<header>
				<h1>Edit User Personal Details</h1>
            </header>       
      <div class="form">
            <c:if test="${User != null}">
    		<form:form id="contactform" action="editUser.html" method="POST" modelAttribute="User"> 
    			<p class="contact"><label for="username" path = "label1">Username</label></p> 
    			<form:input path="username" placeholder="Username" data-validation="length alphanumeric" data-validation-length="min4" required ="required" tabindex="1" type="text"/>

                        <p class="contact"><label for="password" path = "label1">Password</label><p> 
    			<form:input path="password" placeholder="password" data-validation="length alphanumeric" data-validation-length="min4" required ="required" tabindex="1" type="text"/>

                        <p class="contact"><label for="firstName" path = "label1">First Name</label><p> 
    			<form:input path="firstName" placeholder="FirstName" data-validation="custom" data-validation-regexp="^([a-za-z\s]+)$" data-validation-error-msg = "Enter alphabets only" required = "required" tabindex="1" type="text"/>

                        <p class="contact"><label for="lastName" path = "label1">Last Name</label></p> 
    			<form:input path="lastName" placeholder="Last Name" data-validation="custom" data-validation-regexp="^([A-Za-z\s]+)$" data-validation-error-msg = "Enter alphabets only" required = "required" tabindex="1" type="text"/>
                        
                        <p class="contact"><label for="dateOfBirth" path = "label1">Date Of Birth(YYYY-MM-DD)</label><p> 
    			<form:input path="dateOfBirth" id="datepicker" placeholder="Date Of Birth" required="" tabindex="1" type="text"/>  
    			 
    			<form:select class="select-style gender" name="nationality" path="nationality">
                        <option value="Nationality">Nationality</option>
                        <option value="Indian">Indian</option>
                        <option value="Other">Other</option>
                        </form:select><br><br>
                        
                <form:select class="select-style gender" name="religion" path="religion">
                        <option value="select">Religion</option>
                        <option value="Hindu">Hindu</option>
                        <option value="Christian">Christian</option>
                        <option value="Islam">Islam</option>
                        <option value="Jainism">Jainism</option>
                        <option value="Buddhism">Buddhism</option>
                        </form:select><br><br>
                        
               <form:select class="select-style gender" name="gender" path="gender">
                        <option value="select">i am..</option>
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                        </form:select><br><br>

                        <form:select class="select-style gender" name="bloodGroup" path="bloodGroup">
                        <option value="select">Blood Group</option>
                        <option value="O+">O+</option>
                        <option value="O-">O-</option>
                        <option value="B+">B+</option>
                        <option value="B-">B-</option>
                        <option value="A+">A+</option>
                        <option value="A-">A-</option>
                        <option value="AB+">AB+</option>
                        <option value="AB-">AB-</option>
                        </form:select><br><br>

                        <p class="contact"><label for="mobileNumber" path = "label1">Mobile Number</label></p> 
    			<form:input path="mobileNumber" placeholder="Mobile Number" maxlength="10" pattern="\d{10}" title="Please enter exactly 10 digits" tabindex="1" type="text"/>
    			
    			<form:select class="select-style gender" path="role.roleId">
                <option value="select"> Role </option>
                <c:forEach items="${roleList}" var="userRole">
                <option value="${userRole.roleId}">${userRole.roleName}</option>
                </c:forEach>
               </form:select><br><br>
             
                        
                        
            <form:input type = "hidden" path = "userId" value="${userId}"/>
            <input class="buttom" name="submit" id="submit" tabindex="5" value="Edit" type="submit"> 	 
   </form:form>
   </c:if>
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
