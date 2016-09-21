<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<c:if test="${sessionScope['username']==null}" >
   <c:redirect url="StudentLogin.html"/>
</c:if>
<c:if test="${sessionScope['role']!='student'}" >
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
                <a href="displayStudent?rollNumber=${rollNumber}">Go Back</a>
                <span class="right">
                    <a href="Logout.html">
                        <strong>Logout</strong>
                    </a>
                </span>
                </div>
    <section> <!--for demo wrap-->
<h1>Time Table</h1>  

<c:if test="${null != periodSubjectDetails}">
<div  class="tbl-header">
<table cellpadding="0" cellspacing="0" border="0">
  <thead>
    <tr>
      <th>Day / Hour</th>
      <th>09:00 To 10:00</th>
      <th>10:00 To 11:00</th>
      <th>11:10 To 12:00</th>
      <th>12:00 To 13:00</th>
    </tr>
  </thead>
</table>
</div>
<div  class="tbl-content">
<table id="teachertable" cellpadding="0" cellspacing="0" border="0">
  <tbody>
    <tr>
      <td>Monday</td>
      <td><c:out value="${periodSubjectDetails.get(0).getSubjectCode()}"/></td>
      <td><c:out value="${periodSubjectDetails.get(1).getSubjectCode()}"/></td>
      <td><c:out value="${periodSubjectDetails.get(2).getSubjectCode()}"/></td>
      <td><c:out value="${periodSubjectDetails.get(3).getSubjectCode()}"/></td>
    </tr>
    <tr>
      <td>Tuesday</td>
      <td><c:out value="${periodSubjectDetails.get(4).getSubjectCode()}"/></td>
      <td><c:out value="${periodSubjectDetails.get(5).getSubjectCode()}"/></td>
      <td><c:out value="${periodSubjectDetails.get(6).getSubjectCode()}"/></td>
      <td><c:out value="${periodSubjectDetails.get(7).getSubjectCode()}"/></td>
    </tr>
    <tr>
      <td>Wednesday</td>
      <td><c:out value="${periodSubjectDetails.get(8).getSubjectCode()}"/></td>
      <td><c:out value="${periodSubjectDetails.get(9).getSubjectCode()}"/></td>
      <td><c:out value="${periodSubjectDetails.get(10).getSubjectCode()}"/></td>
      <td><c:out value="${periodSubjectDetails.get(11).getSubjectCode()}"/></td>
    </tr>
    <tr>
      <td>Thursday</td>
      <td><c:out value="${periodSubjectDetails.get(12).getSubjectCode()}"/></td>
      <td><c:out value="${periodSubjectDetails.get(13).getSubjectCode()}"/></td>
      <td><c:out value="${periodSubjectDetails.get(14).getSubjectCode()}"/></td>
      <td><c:out value="${periodSubjectDetails.get(15).getSubjectCode()}"/></td>
    </tr>
    <tr>
      <td>Friday</td>
      <td><c:out value="${periodSubjectDetails.get(16).getSubjectCode()}"/></td>
      <td><c:out value="${periodSubjectDetails.get(17).getSubjectCode()}"/></td>
      <td><c:out value="${periodSubjectDetails.get(18).getSubjectCode()}"/></td>
      <td><c:out value="${periodSubjectDetails.get(19).getSubjectCode()}"/></td>
    </tr>
    
    </tbody>
</table>
</div>

</c:if>

<h1 style="margin-top:20px;">Subject and Teacher Details</h1>
<c:if test="${null != subjects}">
<div  class="tbl-header">
<table cellpadding="0" cellspacing="0" border="0">
  <thead>
    <tr>
      <th>Subject Code</th>
      <th>Subject Name</th>
      <th>Subject Teacher Name</th>
    </tr>
  </thead>
</table>
</div>
<div  class="tbl-content">
<table id="teachertable" cellpadding="0" cellspacing="0" border="0">
  <tbody>
     <c:forEach items="${subjects}" var="subject">
            <tr>
                <td><c:out value="${subject.getSubjectCode()}" /></td>                   
                <td><c:out value="${subject.getSubjectName()}" /></td>
                <td><c:out value="${subject.getTeacher().getUser().getFirstName()} ${subject.getTeacher().getUser().getLastName()}" /></td>
            </tr>
            </c:forEach>
</tbody>
</table>
</div>
</c:if>      



<c:if test="${null != mesage}">
              <c:out value="${message}"/>
          </c:if>
</section>

<!-- follow me template -->

    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script src="js/index.js"></script>

    
    
    
  </body>
</html>
