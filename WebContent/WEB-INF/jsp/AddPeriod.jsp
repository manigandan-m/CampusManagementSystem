<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
    <head>
        <title>Campus Management</title>
        <link rel="stylesheet" type="text/css" href="resources/css/style.css">                        
    </head>

    <body style="background-color:powderblue;">
               
        <h1 align = "center">Period</h1>       
       
        <p align = "left">
            <a  style="padding-left:10px; padding-right:1050px;" href="displayPeriods.html" method = "Post">Display All Periods</a>
            <a  href="index.html" style="padding-right:30px;">Goto Main Page</a>
            <a  href="logout.html">Logout </a>
        </p>        
       
       <div align="center">
            <div style="color: #8B0000;border: 2px solid black; border-color: DarkRed;"> 
                <h2>Add Teacher</h2>                
                
                <form:form class = "formUser" action="addPeriod.html" method="post" modelAttribute="Period">	                            
	                
	                <label id = "label1">Day of period</label>
	                <form:select path = "dayOfPeriod">
	                    <option value="Monday"/>
                        <option value="Tuesday"/>
                        <option value="Wednesday"/>
                        <option value="Thursday"/>
                        <option value="Friday"/>                         
                    </form:select><br></br>		
	                
	                <label id = "label1">Start Time of period:</label>
	                <form:select path = "startTimeOfPeriod">
                        <option value="08:00"/>
                        <option value="09:00"/>
                        <option value="10:00"/>
                        <option value="11:00"/>                         
                    </form:select><br></br>	                
                    
                    <label id = "label1">End Time of period:</label>
	                <form:select path = "endTimeOfPeriod">
                        <option value="09:00"/>
                        <option value="10:00"/>
                        <option value="11:00"/>
                        <option value="12:00"/>                         
                    </form:select><br></br>	 
                    
	                <input type="submit" value="Add" /><br>	                       
                </form:form>
           
                  
                <c:if test="${null != addMessage}">
                    <c:out value="${addMessage}"/>
                </c:if>
            </div>
        
            <br/>

        <div style="color: #00008B;border: 2px solid black; border-color: DarkBlue;">
            <h2>Teacher Removal</h2>        
                
            <form class = "formUser" action="deletePeriod.html" method="GET">
	            <p>
                <label id = "label1">Teacher ID:</label>
	            <input type="text" name="periodId" placeholder="Enter Teacher ID" data-validation="number" data-validation-error-msg ="Please Enter numbers only" required><br>
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
