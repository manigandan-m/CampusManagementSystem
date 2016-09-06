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
                
                <form:form class = "formUser" action="addUser.html" method="POST" modelAttribute="User">	                            
	                
	                <label id = "label1">User Name:</label>
	                <form:input path="username" /><br></br>	
	                
	                <label id = "label1">Password:</label>
	                <form:input path="password" /><br></br>	
	                
	                <label id = "label1">First Name:</label>
	                <form:input path="firstName" /><br></br>	
	                
	                <label id = "label1">Last Name:</label>
	                <form:input path="lastName" /><br></br>               
	                              
                    <label id = "label1">Gender :</label>
	                <form:input path="gender" /><br></br>        
	                	                
	                <label id = "label1">Blood Group:</label>
	                <form:input path="bloodGroup" /><br></br>
	                
	                <label id = "label1">Mobile Number:</label>
	                
	                <form:input path="mobileNumber" /><br></br>	   
	                
	                <input type="submit" value="AddUser" /><br>             
	             </form:form>    
	               
               
           
                  
                <c:if test="${null != addMessage}">
                    <c:out value="${addMessage}"/>
                </c:if>
            </div>
        
            <br/>

        <div style="color: #00008B;border: 2px solid black; border-color: DarkBlue;">
            <h2>User Removal</h2>        
                
            <form class = "formUser" action="deleteUser.html" method="GET">
	            <p>
                <label id = "label1">User Id:</label>
	            <input type="text" name="userId" placeholder="Enter userId" data-validation="number" data-validation-error-msg ="Please Enter numbers only" required><br>
	            </p>	
	            <p>
	            <input type="submit" name ="delete" value="Delete" />
	            </p>        
            </form>
            
            <c:if test="${null != deleteMessage}">
                <c:out value="${deleteMessage}"/>
            </c:if>
        </div>
        
        <br/>
        
        <div style="color: #006400;border: 2px solid black; border-color: DarkGreen; ">
            <h3>User Search</h3>        
                
            <form class = "formUser" action="searchUser.html" method="GET" >
	            <p>
                <label id = "label1">User Id:</label>
	            <input name="userId" placeholder="Enter userId" data-validation="number" data-validation-error-msg ="Please Enter numbers only" required= "required"/><br>
	            </p>	
	            <p>
	            <input type="submit" value="Search" />
	            </p>        
            </form>
            
            <c:if test="${null != searchUser}">
                <table border = 1>
                            
                    <tr>
                        <td><c:out value="${searchUser.getUserId()}"/></td>
                        <td><c:out value="${searchUser.getUsername()}"/></td>
                        <td><c:out value="${searchUser.getPassword()}"/></td>
                        <td><c:out value="${searchUser.getFirstName()}"/></td>
                        <td><c:out value="${searchUser.getLastName()}"/></td>
                        <td><c:out value="${searchUser.getGender()}"/></td>            
                        
                        <td><c:out value="${searchUser.getBloodGroup()}"/></td>
                        <td><c:out value="${searchUser.getMobileNumber()}"/></td>                       
                      
                        
                    </tr>            
                </table>   
            </c:if>  

            <c:if test="${null != searchMessage}">
                <c:out value="${searchMessage}"/>
            </c:if>
            
            <br>
            
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
