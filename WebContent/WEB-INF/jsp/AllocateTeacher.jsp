<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
    <head>
        <title>Campus Management</title>
        <link rel="stylesheet" type="text/css" href="resources/css/style.css">                        
    </head>

    <body style="background-color:powderblue;">
               
        <h1 align = "center">Subjects</h1>       
       
        <p align = "left">
            
            <a  href="index.html" style="padding-right:30px;">Goto Main Page</a>
            <a  href="logout.html">Logout </a>
            
        </p>        
       
       
       <div align="center">
            <div style="color: #8B0000;border: 2px solid black; border-color: DarkRed;"> 
                              
              <c:if test="${null != Subject}">
                <form:form class = "formUser" action="allocateTeacher.html" method="POST" modelAttribute="Subject">             
                   
                   <label id = "label1">Subject Code:</label>
	               <c:out value="${Subject.getSubjectCode()}" /><br></br>
	                
                   <label id = "label1">Subject Name:</label>
	               <c:out value="${Subject.getSubjectName()}" /><br></br>
	                
	                <label id = "label1">Handling Teacher Name:</label>           
	                

                    
                        <form:select path="teacher.teacherId">
                        <option value="select">select</option>
                        <form:option value="0">NONE</form:option>
                        <c:forEach items="${teachers}" var="teacher">
                        <form:option value="${teacher.getTeacherId()}">${teacher.getUser().getFirstName()}  ${teacher.getUser().getLastName()}</form:option>
                        </c:forEach>
                        
                        </form:select><br><br>               
	                                  
	                                   <c:out value="${teacher.teacherId}" /><br></br>
	                <form:input type = "hidden" path = "subjectCode" value="${Subject.getSubjectCode()}"/>
	                
	                
	                <br>
	                <input type="submit" value="Assign / Unassign / Change" /><br>	                       
                </form:form>
                </c:if>
                  
                <c:if test="${null != message}">
                    <c:out value="${message}"/>
                </c:if>
            </div>
        </div>    