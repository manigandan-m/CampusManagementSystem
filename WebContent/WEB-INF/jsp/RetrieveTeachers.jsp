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
                <a href="User.html">New Teacher Joining</a>
                <span class="right">
                    <a href="Logout.html">
                        <strong>Logout</strong>
                    </a>
                </span>
                </div>
    <section> <!--for demo wrap-->
<h1>Teacher List</h1>  
<div  class="tbl-header">
<table cellpadding="0" cellspacing="0" border="0">
  <thead>
    <tr>
      <th>ID</th>
      <th>Username</th>
      <th>Firstname</th>
      <th>Lastname</th>
      <th>Designation</th>
      <th>Edit</th>
      <th>Delete</th>
      <th>View</th>
    </tr>
  </thead>
</table>
</div>
<div  class="tbl-content">
<table id="teachertable" cellpadding="0" cellspacing="0" border="0">
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

<div  class="form">
       <form id="contactform" action="viewTeacher.html" method="GET">
           <p class="contact"><label for="teacherId" path = "label1">Enter Teacher ID To Search</label></p> 
    	  <input name="teacherId" placeholder="Teacher ID" data-validation="number" data-validation-error-msg = "Enter numbers only" required="required" tabindex="1" type="text"/>
          <input class="buttom" name="submit" id="submit" tabindex="5" value="Search" type="submit">
          </form>
</div>
<!-- follow me template -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
   <script src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>
   <script>
       $.validate({
       lang: 'en'
        });
   </script>

    
    
    
  </body>
</html>