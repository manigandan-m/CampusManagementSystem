<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
    <head>
        <title>Campus Management</title>
        <link rel="stylesheet" type="text/css" href="resources/css/style.css">                        
    </head>

    <body style="background-color:powderblue;">
               
        <h1 align = "center">Student</h1>       
       
        <p align = "left">
            <a  style="padding-left:10px; padding-right:1050px;" href="displayEmployees.html">Display All Employees</a>
            <a  href="index.html" style="padding-right:30px;">Goto Main Page</a>
            <a  href="logout.html">Logout </a>
        </p>        
       
       <div align="center">
            <div style="color: #8B0000;border: 2px solid black; border-color: DarkRed;"> 
                <h2>Add Student</h2>                
                
                <form:form class = "formStudent" action="addStudent.html" method="POST" modelAttribute="Student">	                            
	                
	                <label id = "label1">User Name:</label>
	                <form:input path="username" /><br></br>	
	                
	                <label id = "label1">Password:</label>
	                <form:input path="password" /><br></br>	
	                
	                <label id = "label1">First Name:</label>
	                <form:input path="firstName" /><br></br>	
	                
	                <label id = "label1">Last Name:</label>
	                <form:input path="lastName" /><br></br>
	                
	                <label id = "label1">Role:</label>
	                <form:select path = "role">
                        <form:option value="Student"/>                         
                    </form:select><br></br>	                
                    
	                <label id = "label1">Gender :</label>
	                <form:input path="gender" /><br></br>
	                
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
	                
	                <label id = "label1">Date Of Birth:</label>
	                <form:input path="dateOfBirth" /><br></br>
	                
	                <label id = "label1">Date Of Birth:</label>
	                <form:input path="dateOfBirth" /><br></br>
	                
	                <label id = "label1">Date Of Birth:</label>
	                <form:input path="dateOfBirth" /><br></br>
	                
	                <label id = "label1">Date Of Birth:</label>
	                <form:input path="dateOfBirth" /><br></br>
	                
	                <label id = "label1">Date Of Birth:</label>
	                <form:input path="dateOfBirth" /><br></br>
	                
	                <label id = "label1">Date Of Birth:</label>
	                <form:input path="dateOfBirth" /><br></br>
	                
	                <label id = "label1">Nationality:</label>
	                <form:input path="nationality" /><br></br>
	                
	                <label id = "label1">Religion:</label>
	                <form:input path="religion" /><br></br>
	                
	                <input type="submit" value="Add" /><br>	                       
                </form:form>
           
                  
                <c:if test="${null != addMessage}">
                    <c:out value="${addMessage}"/>
                </c:if>
            </div>
        
            <br/>

        <div style="color: #00008B;border: 2px solid black; border-color: DarkBlue;">
            <h2>Student Removal</h2>        
                
            <form class = "formStudent" action="deleteStudent.html" method="GET">
	            <p>
                <label id = "label1">Student Roll Number:</label>
	            <input type="text" name="rollNumber" placeholder="Enter rollNumber" data-validation="number" data-validation-error-msg ="Please Enter numbers only" required><br>
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
            <h3>Student Search</h3>        
                
            <form class = "formStudent" action="searchStudent.html" method="GET" >
	            <p>
                <label id = "label1">Student Roll Number:</label>
	            <input name="rollNumber" placeholder="Enter rollNumber" data-validation="number" data-validation-error-msg ="Please Enter numbers only" required= "required"/><br>
	            </p>	
	            <p>
	            <input type="submit" value="Search" />
	            </p>        
            </form>
            
            <c:if test="${null != searchStudent}">
                <table border = 1>
                            
                    <tr>
                        <td><c:out value="${searchStudent.getRollNumber()}"/></td>
                        <td><c:out value="${searchStudent.getUser().getUsername()}"/></td>
                        <td><c:out value="${searchStudent.getUser().getFirstName()}"/></td>
                        <td><c:out value="${searchStudent.getUser().getLastName()}"/></td>
                        <td><c:out value="${searchStudent.getUser().getGender()}"/></td>
                        <td><c:out value="${searchStudent.getAddress().getHouseNumber()}"/></td>
                        <td><c:out value="${searchStudent.getAddress().getStreetName()}"/></td>
                        <td><c:out value="${searchStudent.getAddress().getCity()}"/></td>
                        <td><c:out value="${searchStudent.getAddress().getState()}"/></td>
                        <td><c:out value="${searchStudent.getAddress().getCountry()}"/></td>
                        <td><c:out value="${searchStudent.getAddress().getPincode()}"/></td>
                        <td><c:out value="${searchStudent.getUser().getBloodGroup()}"/></td>
                        <td><c:out value="${searchStudent.getUser().getMobileNumber()}"/></td>
                        <td><c:out value="${searchStudent.getParent().getFatherFirstName()}"/></td>
                        <td><c:out value="${searchStudent.getParent().getFatherLastName()}"/></td>
                        <td><c:out value="${searchStudent.getParent().getMotherFirstName()}"/></td>
                        <td><c:out value="${searchStudent.getParent().getMotherLastName()}"/></td>
                        <td><c:out value="${searchStudent.getDateOfBirth()}"/></td>
                        <td><c:out value="${searchStudent.getNationality()}"/></td>
                        <td><c:out value="${searchStudent.getReligion()}"/></td>
                        
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
