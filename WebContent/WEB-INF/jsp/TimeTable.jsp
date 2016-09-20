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
<h1>Standard List</h1>  
<div  class="tbl-header">
<table cellpadding="0" cellspacing="0" border="0">
<c:if test="${null != standards}">
  <thead>
    <tr>		
			<th>ID</th>
                        <th>Standard Name</th>
                        <th>Generate Action</th>			
                        <th>View Action</th>
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
                    <td><a  href="generateTimeTable.html?standardId=${standard.getStandardId()}">Generate Time Table</a></td>		    
		    <td><a  href="standardTimeTable.html?standardId=${standard.getStandardId()}">View Time Table</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
</div>

<h1 style="margin-top:30px;">Teacher List</h1>
<div  class="tbl-header">
<table cellpadding="0" cellspacing="0" border="0">
<c:if test="${null != teachers}">
  <thead>
    <tr>
			<th>ID</th>
                        <th>Teacher First Name</th>
                        <th>Teacher Last Name</th>
			<th>Time Table</th>
    </tr>
  </thead>
  </c:if>
</table>
</div>
<div  class="tbl-content">
<table id="teachertable" cellpadding="0" cellspacing="0" border="0">
  <tbody>
    <c:forEach items="${teachers}" var="teacher">
    <tr>
      <td><c:out value="${teacher.getTeacherId()}" /></td>      
      <td><c:out value="${teacher.getUser().getFirstName()}"/></td>
      <td><c:out value="${teacher.getUser().getLastName()}" /></td>
      <td><a  href="teacherTimeTable.html?teacherId=${teacher.getTeacherId()}">View Time Table</a></td>
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
