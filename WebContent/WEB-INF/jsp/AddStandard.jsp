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
        <meta charset="UTF-8">
    <title>Add Standard</title>
    <meta charset="utf-8">
    <meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
   <link href="layout/styles/layout.css" rel="stylesheet" type="text/css"
	media="all">
	<link rel="stylesheet" type="text/css" href="css/style2.css" media="all" />
    <link rel="stylesheet" type="text/css" href="css/demo.css" media="all" />
    </head>

    <body>
           <div class="container">
			<!-- freshdesignweb top bar -->
            <div class="freshdesignweb-top">
                <a href="home.html">Home</a>&nbsp;&nbsp;
                <a href="Standard.html">Standards</a>
                <span class="right">
                    <a href="Logout.html">
                        <strong>Logout</strong>
                    </a>
                </span>
                </div>    
                
       
       
       <div class="form">
            <h2>Add Standard</h2>                
                
                <form:form id = "contactform" action="addStandard.html" method="POST" modelAttribute="Standard">             
                    
	                <label id = "label1">Standard Name:</label>
	                 <form:select path = "standardName">
	                    <option value="NONE">--Select--</option>
                        <option value="Standard I">Standard I</option>
                        <option value="Standard II">Standard II</option>
                        <option value="Standard III">Standard III</option>
                        <option value="Standard IV">Standard IV</option>
                        <option value="Standard V">Standard V</option>
                    </form:select>                              
	                     
	                   <c:forEach items="${Standard.subjects}" var="subject" varStatus="status">
	                   <p><label> Enter Subject Code :</label>
	                         <form:input path="subjects[${status.index}].subjectCode" placeholder="Enter Subject Code" data-validation="length alphanumeric" data-validation-length="min4" required ="required" tabindex="1" type="text"/>
	                      <label> Enter Subject Name:</label>   
	                         <form:input path="subjects[${status.index}].subjectName" placeholder="Enter Subject Name" data-validation="custom" data-validation-regexp="^([A-Za-z\s]+)$" data-validation-error-msg = "Enter alphabets only" required = "required" tabindex="1" type="text"/>
	                   </p>          
	                     </c:forEach>
 	               <br>
	                <input class="buttom" name="submit" id="submit" tabindex="5" value="Add Standard" type="submit">	                       
                </form:form>
           
                  
                <c:if test="${null != addMessage}">
                    <c:out value="${addMessage}"/>
                </c:if>
            </div>
        
            <br/>
          
        </div>
             
       <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
   <script src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>
   <script>
       $.validate({
       lang: 'en'
        });
   </script>   
    </body>
</html> 