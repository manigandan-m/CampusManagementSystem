<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%-- <c:if test="${sessionScope['id']==null}" >
   <c:redirect url="Login.jsp"/>
</c:if>
<c:if test="${sessionScope['role']!='admin'}" >
     <% response.sendRedirect("employeeById?id="+session.getAttribute("id")); %>
</c:if>--%>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Fixed table header</title>
    
    
    <link rel="stylesheet" href="css/reset.css">

    
        <link rel="stylesheet" href="css/style3.css">

    
    
    
  </head>

  <body>

    <section> <!--for demo wrap-->
<h1>Fixed Table header</h1>  
<div  class="tbl-header">
<table cellpadding="0" cellspacing="0" border="0">
  <thead>
    <tr>
      <th>ID</th>
      <th>Username</th>
      <th>Firstname</th>
      <th>Lastname</th>
      <th>Designation</th>
    </tr>
  </thead>
</table>
</div>
<div  class="tbl-content">
<table cellpadding="0" cellspacing="0" border="0">
  <tbody>
    <c:forEach items="${teachers}" var="teacher">
    <tr>
      <td><c:out value="${teacher.getTeacherId()}" /></td>
      <td><c:out value="${teacher.getUser().getUsername()}"/></td>
      <td><c:out value="${teacher.getUser().getFirstName()}"/></td>
      <td><c:out value="${teacher.getUser().getLastName()}" /></td>
      <td><c:out value="${teacher.getDesignation()}" /></td>
      <td><a  href="editTeacherDetails.html?teacherId=${teacher.getTeacherId()}">Edit</a></td>
      <td><a  href="deleteTeacher.html?teacherId=${teacher.getTeacherId()}">Delete</a></td>
      <td><a  href="viewTeacher.html?teacherId=${teacher.getTeacherId()}">View</a></td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</section>

<c:if test="${displayMessage!=null}" >
            <td>${displayMessage}</td>
        </c:if>


<!-- follow me template -->

    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script src="js/index.js"></script>

    
    
    
  </body>
</html>