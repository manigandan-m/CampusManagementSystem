<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Demo Beautiful Registration Form with HTML5 and CSS3</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="css/style2.css" media="all" />
    <link rel="stylesheet" type="text/css" href="css/demo.css" media="all" />
     <link rel="stylesheet" href="css/reset.css">
     <link rel="stylesheet" href="css/style3.css">
</head>
<body>
<div class="container">
			<!-- freshdesignweb top bar -->
            <div class="freshdesignweb-top">
                <a href="http://www.freshdesignweb.com" target="_blank">Home</a>
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

<div  class="form">
       <form:form id="contactform" action="searchTeacher.html" method="GET">
           <p class="contact"><label for="teacherId" path = "label1">Enter Roll Number To Search</label></p> 
    	  <input name="teacherId" placeholder="Teacher ID" required="" tabindex="1" type="text"/>
          <input class="buttom" name="submit" id="submit" tabindex="5" value="Search" type="submit">
          </form:form>
</div>

<section>
<div  class="tbl-header">
<table cellpadding="0" cellspacing="0" border="0">
</table>
</div>
<div  class="tbl-content">
<c:if test="${null != searchTeacher}">
<table cellpadding="0" cellspacing="0" border="0">
  <tbody>

                    <tr><td>Teacher Id :</td><td><c:out value="${searchTeacher.getTeacherId()}"/></td></tr>
                    <tr><td>User Name:</td><td><c:out value="${searchTeacher.getUser().getUsername()}"/></td></tr>
                    <tr><td>First Name :</td><td><c:out value="${searchTeacher.getUser().getFirstName()}"/></td></tr>
                    <tr><td>Last Name :</td><td><c:out value="${searchTeacher.getUser().getLastName()}"/></td></tr>
                    <tr><td>Date Of Birth :</td><td><c:out value="${searchTeacher.getUser().getDateOfBirth()}"/></td></tr>
                    <tr><td>Gender :</td><td><c:out value="${searchTeacher.getUser().getGender()}"/></td></tr>
                    <tr><td>Blood Group :</td><td><c:out value="${searchTeacher.getUser().getBloodGroup()}"/></td></tr>
                    <tr><td>Mobile Number:</td><td><c:out value="${searchTeacher.getUser().getMobileNumber()}"/></td></tr>
                    <tr><td>Nationality:</td>    <td><c:out value="${searchTeacher.getUser().getNationality()}"/></td></tr>
                    <tr><td>Religion:</td><td><c:out value="${searchTeacher.getUser().getReligion()}"/></td></tr>
                    <tr><td>HouseNumber:</td><td><c:out value="${searchTeacher.getUser().getAddress().getHouseNumber()}"/></td></tr>
                    <tr><td>StreetName:</td><td><c:out value="${searchTeacher.getUser().getAddress().getStreetName()}"/></td></tr>
                    <tr><td>City:</td><td><c:out value="${searchTeacher.getUser().getAddress().getCity()}"/></td></tr>
                    <tr><td>State:</td><td><c:out value="${searchTeacher.getUser().getAddress().getState()}"/></td></tr>
                    <tr><td>Country:</td><td><c:out value="${searchTeacher.getUser().getAddress().getCountry()}"/></td></tr>
                    <tr><td>Pin Code:</td><td><c:out value="${searchTeacher.getUser().getAddress().getPincode()}"/></td></tr>
                    <tr><td>Years Of Experience:</td><td><c:out value="${searchTeacher.getYearsOfExperience()}"/></td></tr>
                    <tr><td>Months Of Experience:</td><td><c:out value="${searchTeacher.getMonthsOfExperience()}"/></td></tr>
                    <tr><td>Date Of Joining:</td><td><c:out value="${searchTeacher.getDateOfJoining()}"/></td></tr>
                    <tr><td>Qualification:</td><td><c:out value="${searchTeacher.getQualification()}"/></td></tr>
                    <tr><td>Designation:</td><td><c:out value="${searchTeacher.getDesignation()}"/></td></tr>
                    <tr><td>Marital Status:</td><td><c:out value="${searchTeacher.getMaritalStatus()}"/></td></tr>
              </tbody>
     </table>               
                   
            </c:if>  
     

     <c:if test="${null != searchMessage}">
                <c:out value="${searchMessage}"/>
            </c:if>
            
            <br>
</div>
</section>
 <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script src="js/index.js"></script>

    
    
    
  </body>
</html>