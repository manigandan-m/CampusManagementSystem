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
                <a href="displayStudents.html">Students</a>
                <span class="right">
                    <a href="Logout.html">
                        <strong>Logout</strong>
                    </a>
                </span>
                <div class="clr"></div>
            </div><!--/ freshdesignweb top bar -->
			<header>
				<h1>Edit Student</h1>
            </header>       
      <div  class="form">
            
    		<form:form id="contactform" action="editStudent.html" method="POST" modelAttribute="Student"> 
    			<p class="contact"><label for="fatherFirstName" path = "label1">Father First Name</label></p> 
    			<form:input path="fatherFirstName" placeholder="Father First Name" data-validation="custom" data-validation-regexp="^([A-Za-z\s]+)$" data-validation-error-msg = "Enter alphabets only" required = "required" tabindex="1" type="text"/>

                        <p class="contact"><label for="fatherLastName" path = "label1">Father Last Name</label><p> 
    			<form:input path="fatherLastName" placeholder="Father Last Name" data-validation="custom" data-validation-regexp="^([A-Za-z\s]+)$" data-validation-error-msg = "Enter alphabets only" required = "required" tabindex="1" type="text"/>

                        <p class="contact"><label for="motherFirstName" path = "label1">Mother First Name</label><p> 
    			<form:input path="motherFirstName" placeholder="Mother First Name" data-validation="custom" data-validation-regexp="^([A-Za-z\s]+)$" data-validation-error-msg = "Enter alphabets only" required = "required" tabindex="1" type="text"/>

                        <p class="contact"><label for="motherLastName" path = "label1">Mother Last Name</label></p> 
    			<form:input path="motherLastName" placeholder="Mother Last Name" data-validation="custom" data-validation-regexp="^([A-Za-z\s]+)$" data-validation-error-msg = "Enter alphabets only" required = "required" tabindex="1" type="text"/>
                        
                        <p class="contact"><label for="familyIncome" path = "label1">Annual Income</label><p> 
    			<form:input path="familyIncome" placeholder="Annual Income" maxlength="6" title= "Salary should not be more than 999999" required="required" tabindex="1" type="text"/>  
    			 
    			<p class="contact"><label for="dateOfAdmission" path = "label1">Date Of Admission</label></p> 
    			<form:input path="dateOfAdmission" id="datepicker" placeholder="Date Of Admission" required="" tabindex="1" type="text"/>

                        <form:select class="select-style gender" name="admissionCategory" path="admissionCategory">
                        <option value="select">Admission Category</option>
                        <option value="General">General</option>
                        <option value="OBC">OBC</option>
                        <option value="SC">SC</option>
                        <option value="ST">ST</option>
                        </form:select><br><br> 
                        
                        <label id = "label1">Standard Name:</label>             
                         
                        <form:select class="select-style gender" path="standard.standardId">
                        <option value="select">select</option>
                        
                        <c:forEach items="${standards}" var="standard">
                        <option value="${standard.standardId}">${standard.getStandardName()}</option>
                        </c:forEach>
                        </form:select><br><br>  
                        
                        <form:input type = "hidden" path = "rollNumber" value="${rollNumber}"/>
                        <form:input type = "hidden" path = "user.userId" value="${userId}"/>
                        
                       <input class="buttom" name="submit" id="submit" tabindex="5" value="Edit" type="submit"> 	 
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