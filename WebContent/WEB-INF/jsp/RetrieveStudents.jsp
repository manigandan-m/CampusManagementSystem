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
      <th>Roll</th>
      <th>Username</th>
      <th>Firstname</th>
      <th>Lastname</th>
      <th>Standard</th>
    </tr>
  </thead>
</table>
</div>
<div  class="tbl-content">
<table cellpadding="0" cellspacing="0" border="0">
  <tbody>

   <c:forEach items="${students}" var="student">
                <tr>
                    <td><c:out value="${student.getRollNumber()}" /></td>                    
                    <td><c:out value="${student.getUser().getUsername()}" /></td>
                    <td><c:out value="${student.getUser().getFirstName()}" /></td>
                    <td><c:out value="${student.getUser().getLastName()}" /></td>
                    <td><c:out value="${student.getStandard().getStandardName()}" /></td>
                    <td><a  href="editStudentDetails.html?rollNumber=${student.getRollNumber()}">Edit</a></td>
                    <td><a  href="deleteStudent.html?rollNumber=${student.getRollNumber()}">Delete</a></td>
                    <td><a  href="viewStudent.html?rollNumber=${student.getRollNumber()}">View</a></td>
                </tr>
            </c:forEach>
</tbody>
</table>
</div>
</section>
 <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script src="js/index.js"></script>

    
    
    
  </body>
</html>