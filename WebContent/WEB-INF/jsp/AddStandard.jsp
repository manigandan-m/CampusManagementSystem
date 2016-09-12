<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
    <head>
        <title>Campus Management</title>
        <link rel="stylesheet" type="text/css" href="resources/css/style.css">                        
    </head>

    <body style="background-color:powderblue;">
               
        <h1 align = "center">Standard</h1>       
       
        <p align = "left">
            
            <a  href="index.html" style="padding-right:30px;">Goto Main Page</a>
            <a  href="logout.html">Logout </a>
            
        </p>        
       
       
       <div align="center">
            <div style="color: #8B0000;border: 2px solid black; border-color: DarkRed;"> 
                <h2>Add Standard</h2>                
                
                <form:form class = "formUser" action="addStandard.html" method="POST" modelAttribute="Standard">             
                    
	                <label id = "label1">Standard Name:</label>
	                 <form:select path = "standardName">
	                    <option value="NONE">--Select--</option>
                        <option value="Standard I">Standard I</option>
                        <option value="Standard II">Standard II</option>
                        <option value="Standard III">Standard III</option>
                        <option value="Standard IV">Standard IV</option>
                        <option value="Standard V">Standard V</option>
                        <option value="Standard VI">Standard IV</option>
                        <option value="Standard VII">Standard V</option>
                        <option value="Standard VIII">Standard IV</option>
                        <option value="Standard IX">Standard V</option>
                        <option value="Standard X">Standard IV</option>
                        <option value="Standard XI">Standard V</option>
                        <option value="Standard XII">Standard IV</option>                        
                    </form:select>                              
	                                  
	                
	                <br>
	                <input type="submit" value="Add" /><br>	                       
                </form:form>
           
                  
                <c:if test="${null != addMessage}">
                    <c:out value="${addMessage}"/>
                </c:if>
            </div>
        
            <br/>
          <div style="color: #006400;border: 2px solid black; border-color: DarkGreen; ">  
         
        
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