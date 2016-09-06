<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
    <head>
        <title>Campus Management</title>
        <link rel="stylesheet" type="text/css" href="resources/css/style.css">                        
    </head>

    <body style="background-color:powderblue;">
               
        <h1 align = "center">User</h1>       
       
        <p align = "left">
            <a  style="padding-left:10px; padding-right:1050px;" href="displayEmployees.html">Display All Employees</a>
            <a  href="index.html" style="padding-right:30px;">Goto Main Page</a>
            <a  href="logout.html">Logout </a>
        </p>        
       
       <div align="center">
            <div style="color: #8B0000;border: 2px solid black; border-color: DarkRed;"> 
                <h2>Add User</h2>                
                
                
	                <form:form class = "formUser" action="addAddress.html" method="POST" modelAttribute="Address">
	                
	                    <label id = "label1">House No:</label>
	                    <form:input path="houseNumber" /><br></br>
	                
	                    <label id = "label1">StreetName:</label>
	                    <form:input path="streetName" /><br></br>
	                
	                    <label id = "label1">City:</label>
	                    <form:input path="city" /><br></br>
	               
	                    <label id = "label1">State:</label>
	                    <form:input path="state" /><br></br>
	                
	                   <label id = "label1">Country:</label>
	                   <form:input path="country" /><br></br>
	                
	                   <label id = "label1">PinCode:</label>
	                   <form:input path="pincode" /><br></br>
	                
	                
	                <input type="submit" value="AddAddress" /><br>	                       
                </form:form>
               
           <c:if test="${null != addMessage}">
                    <c:out value="${addMessage}"/>
                </c:if>
                  
                </div>
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
