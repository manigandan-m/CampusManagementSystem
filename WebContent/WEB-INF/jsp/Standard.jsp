<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <c:if test="${sessionScope['username']==null}" >
   <c:redirect url="Login.html"/>
</c:if>
<c:if test="${sessionScope['role']!='admin'}" >
     <c:redirect url="Logout.html"/>
</c:if>--%>
<!DOCTYPE html>
<html>
<head>
<title>Demo Beautiful Registration Form with HTML5 and CSS3</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="css/style2.css" media="all" />
    <link rel="stylesheet" type="text/css" href="css/demo.css" media="all" />
</head>
   <body>
<div class="container">
			<!-- freshdesignweb top bar -->
            <div class="freshdesignweb-top">
                <a href="AddStandard.html">Add Standard</a>
                <span class="right">
                    <a href="http://www.freshdesignweb.com/beautiful-registration-form-with-html5-and-css3.html">
                        <strong>Back to the freshdesignweb Article</strong>
                    </a>
                </span>
                <div class="clr"></div>
            </div><!--/ freshdesignweb top bar -->
			<header>
				<h1><span>Tutorials</span> Demo Beautiful Registration Form with HTML5 and CSS3</h1>
            </header>    
               
      <div class="form">
      
      
      <c:if test="${null != standards}">
	    <table border="2">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Standard Name</th>
                        <th>Subject 1 Code</th>
                        <th>Subject 1 Name</th>
                        <th>Subject 2 Code</th>
                        <th>Subject 2 Name</th>
                        <th>Subject 3 Code</th>
                        <th>Subject 3 Name</th>
                        <th>Subject 4 Code</th>
                        <th>Subject 4 Name</th>
                        <th>Subject 5 Code</th>
                        <th>Subject 5 Name</th>                        
                        <th>Coordinator Name</th>                        
                    </tr>
                </thead>		
                <tbody>
                
            <c:forEach items="${standards}" var="standard">
                <tr>
                    <td><c:out value="${standard.getStandardId()}" /></td>    
                    <td><c:out value="${standard.getStandardName()}" /></td> 
                    <c:forEach items="${standard.getSubjects()}" var="subject">
                        <td><c:out value="${subject.getSubjectCode()}" /></td>
                        <td><c:out value="${subject.getSubjectName()}" /></td>  
                    </c:forEach>
                    <c:choose>
    <c:when test="${null != standard.getClassCoordinator()}">
       <td><c:out value="${standard.getClassCoordinator().getUser().getFirstName()} ${standard.getClassCoordinator().getUser().getLastName()}" /></td>       
    </c:when>
    <c:otherwise>
        <td>Not Assigned</td> 
    </c:otherwise>
</c:choose>

                                  
                    
                    <td><a  href="Coordinator.html?standardId=${standard.getStandardId()}">Assign / Unassign / Change Coordinator</a></td>
                </tr>
            </c:forEach>
              
        </tbody>
    </table>
	  </c:if> 
	  
	   <c:if test="${null != displaymesage}">
              <c:out value="${displayMessage}"/>
          </c:if> 
	  
    		
</div>

</div>
</body>
</html>