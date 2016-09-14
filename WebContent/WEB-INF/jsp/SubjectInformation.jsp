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
      
      
      <c:if test="${null != subjects}">
	    <table border="2">
                <thead>
                    <tr>
                        <th>ID</th>                        
                        <th>Subject Code</th>
                        <th>Subject Name</th>                                              
                        <th>Standard Name</th>                        
                    </tr>
                </thead>		
                <tbody>
                
            <c:forEach items="${subjects}" var="subject">
                <tr>
                    <td><c:out value="${subject.getSubjectCode()}" /></td>    
                    <td><c:out value="${subject.getSubjectName()}" /></td> 
                    <td><c:out value="${subject.getStandard().getStandardName()}" /></td>  
                    
                    <td><a  href="editTeacher.html?subjectId=${subject.getSubjectCode()}">Allocate / Deallocate / Change Teacher</a></td>
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