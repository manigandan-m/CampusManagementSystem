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
              <c:if test="${null != Standard}">
                <form:form class = "formUser" action="editCoordinator.html" method="POST" modelAttribute="Standard">             
                    
                    <label id = "label1">Standard Name:</label>
	               <c:out value="${Standard.getStandardName()}" /><br></br>
	                
	                <label id = "label1">Coordinator Name:</label>           
	                
                    
                        <form:select path="classCoordinator.teacherId">
                        <option value="select">select</option>
                        <form:option value="0">NONE</form:option>
                        <c:forEach items="${teachers}" var="teacher">
                        <form:option value="${teacher.teacherId}">${teacher.getUser().getFirstName()}  ${teacher.getUser().getLastName()}</form:option>
                        </c:forEach>
                        </form:select><br><br>               
	                                  
	                <form:input type = "hidden" path = "standardId" value="${standardId}"/>
	                <form:input type = "hidden" path = "standardName" value="${standardName}"/>
	                <br>
	                <input type="submit" value="Assign / Change" /><br>	                       
                </form:form>
                </c:if>
                  
                <c:if test="${null != message}">
                    <c:out value="${message}"/>
                </c:if>
            </div>
        </div>    