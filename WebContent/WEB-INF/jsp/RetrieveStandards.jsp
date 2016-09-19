<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<c:if test="${sessionScope['username']==null}" >
   <c:redirect url="Login.html"/>
</c:if>
<c:if test="${sessionScope['role']!='admin'}" >
     <c:redirect url="Logout.html"/>
</c:if>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Campus Management</title>
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
                <a href="home.html">Home</a>&nbsp;&nbsp;
                <a href="AddStandard.html">Add a new Standard</a>
                <span class="right">
                    <a href="Logout.html">
                        <strong>Logout</strong>
                    </a>
                </span>
                </div>
    <section> <!--for demo wrap-->
<h1>Standard List</h1>  
<div  class="tbl-header">
<table cellpadding="0" cellspacing="0" border="0">
<c:if test="${null != standards}">
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
                        <th>Class Teacher</th>
                        <th>Action</th>
    </tr>
  </thead>
  </c:if>
</table>
</div>
<div  class="tbl-content">
<table id="teachertable" cellpadding="0" cellspacing="0" border="0">
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
<td><a  href="Coordinator.html?standardId=${standard.getStandardId()}">Assign / Unassign Coordinator</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
</div>
</section>
<c:if test="${null != displaymesage}">
              <c:out value="${displayMessage}"/>
          </c:if>
</div>
</body>
</html>