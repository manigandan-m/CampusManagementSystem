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
            <a  style="padding-left:10px; padding-right:1050px;" href="displayTeachers.html">Display All Teachers</a>
            <a  href="index.html" style="padding-right:30px;">Goto Main Page</a>
            <a  href="logout.html">Logout </a>
        </p>        
       
       <div align="center">
            <div style="color: #8B0000;border: 2px solid black; border-color: DarkRed;"> 
                <h2>Add Teacher</h2>                
                
                <form:form class = "formUser" action="addTeacher.html" method="POST" modelAttribute="Teacher">	                            
	                
	                <label id = "label1">Years of Experience:</label>
	                <form:input path="yearsOfExperience" /><br></br>	
	                
	                <label id = "label1">Months Of Experience:</label>
	                <form:input path="monthsOfExperience" /><br></br>	
	                
	                <label id = "label1">Qualification:</label>
	                <form:input path="qualification" /><br></br>
	                
	                <label id = "label1">Marital Status:</label>
	                <form:select path = "maritalStatus">
                        <form:option value="Single"/>
                        <form:option value="Married"/>                         
                    </form:select><br></br>
	                
	                <label id = "label1">Date of Joining:</label>
	                <form:input path="dateOfJoining" /><br></br>
	                
	                <label id = "label1">Designation:</label>
	                <form:input path="designation" /><br></br>
	                
	                <input type="submit" value="Add" /><br>	                       
                </form:form>
           
                  
                <c:if test="${null != addMessage}">
                    <c:out value="${addMessage}"/>
                </c:if>
            </div>
        
            <br/>

        <div style="color: #00008B;border: 2px solid black; border-color: DarkBlue;">
            <h2>Teacher Removal</h2>        
                
            <form class = "formUser" action="deleteTeacher.html" method="GET">
	            <p>
                <label id = "label1">Teacher ID:</label>
	            <input type="text" name="teacherId" placeholder="Enter Teacher ID" data-validation="number" data-validation-error-msg ="Please Enter numbers only" required><br>
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
            <h3>Teacher Search</h3>        
                
            <form class = "formStudent" action="searchTeacher.html" method="GET" >
	            <p>
                <label id = "label1">Student Roll Number:</label>
	            <input name="teacherId" placeholder="Enter Teacher ID" data-validation="number" data-validation-error-msg ="Please Enter numbers only" required= "required"/><br>
	            </p>	
	            <p>
	            <input type="submit" value="Search" />
	            </p>        
            </form>
            
            <c:if test="${null != searchTeacher}">
                <table border = 1>
                            
                    <tr>
                        <td><c:out value="${searchTeacher.getTeacherId()}"/></td>
                        <td><c:out value="${searchTeacher.getMonthsOfExperience()}"/></td>
                        <td><c:out value="${searchTeacher.getYearsOfExperience()}"/></td>
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
