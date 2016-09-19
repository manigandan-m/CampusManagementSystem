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
                <a href="User.html">Admission</a>
                <span class="right">
                    <a href="Logout.html">
                        <strong>Logout</strong>
                    </a>
                </span>
                </div>

    <section> <!--for demo wrap-->
<h1>Student List</h1> 
<div  class="tbl-header">
<table cellpadding="0" cellspacing="0" border="0">
  <thead>
    <tr>
      <th>Roll</th>
      <th>Username</th>
      <th>Firstname</th>
      <th>Lastname</th>
      <th>Standard</th>
      <th>Edit Action</th>
      <th>Delete Action</th>
      <th>View Action</th>
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
<div  class="form">
       <form id="contactform" action="viewStudent.html" method="GET">
           <p class="contact"><label for="rollNumber" path = "label1">Enter Student ID To Search</label></p> 
    	  <input name="rollNumber" placeholder="Student ID" required="" tabindex="1" type="text"/>
          <input class="buttom" name="submit" id="submit" tabindex="5" value="Search" type="submit">
          </form>
</div>
 <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script src="js/index.js"></script>

   
   
   
  </body>
</html>