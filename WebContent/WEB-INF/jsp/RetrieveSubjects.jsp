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
                <span class="right">
                    <a href="Logout.html">
                        <strong>Logout</strong>
                    </a>
                </span>
                </div>
    <section> <!--for demo wrap-->
<h1>Subject List</h1>  
<div  class="tbl-header">
<table cellpadding="0" cellspacing="0" border="0">
<c:if test="${null != subjects}">
  <thead>
    <tr>
      <th>Subject Code</th>
      <th>Subject Name</th>
      <th>Standard Name</th>
      <th>Faculty Name</th>
      <th>Action</th>
    </tr>
  </thead>
  </c:if>
</table>
</div>
<div  class="tbl-content">
<table id="teachertable" cellpadding="0" cellspacing="0" border="0">
  <tbody>
    <c:forEach items="${subjects}" var="subject">
                <tr>
                    <td><c:out value="${subject.getSubjectCode()}" /></td>    
                    <td><c:out value="${subject.getSubjectName()}" /></td> 
                    <td><c:out value="${subject.getStandard().getStandardName()}" /></td>  
                    <td><c:out value="${subject.getTeacher().getUser().getFirstName()}" /></td>
                    <td><a  href="assignTeacher.html?subjectId=${subject.getSubjectCode()}">Allocate / Deallocate Teacher</a></td>
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