<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
    <head>
        <title>Campus Management</title>
        <meta charset="UTF-8">
    <title>Fixed table header</title>
    <meta charset="utf-8">
    <meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
   <link href="layout/styles/layout.css" rel="stylesheet" type="text/css"
	media="all">
	<link rel="stylesheet" type="text/css" href="css/style2.css" media="all" />
    <link rel="stylesheet" type="text/css" href="css/demo.css" media="all" />
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/style3.css">                       
    </head>

    <body>
           <div class="container">
			<!-- freshdesignweb top bar -->
            <div class="freshdesignweb-top">
                <a href="addUser.html">New Teacher Joining</a>
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
	                                  
	                
	                <br>
	                <input class="buttom" name="submit" id="submit" tabindex="5" value="Search" type="submit">	                       
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