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
      <div class="form">
    		<form:form id="contactform" action="addUser.html" method="POST" modelAttribute="User"> 
    			<p class="contact"><label for="username" path = "label1">Username</label></p> 
    			<form:input path="username" placeholder="Username" required="" tabindex="1" type="text"/>

                        <p class="contact"><label for="password" path = "label1">Password</label><p> 
    			<form:input path="password" placeholder="password" required="" tabindex="1" type="text"/>

                        <p class="contact"><label for="firstName" path = "label1">First Name</label><p> 
    			<form:input path="firstName" placeholder="FirstName" required="" tabindex="1" type="text"/>

                        <p class="contact"><label for="lastName" path = "label1">Last Name</label></p> 
    			<form:input path="lastName" placeholder="Last Name" required="" tabindex="1" type="text"/>
                        
                        <p class="contact"><label for="dateOfBirth" path = "label1">Date Of Birth</label><p> 
    			<form:input path="dateOfBirth" placeholder="Date Of Birth" required="" tabindex="1" type="text"/>  
    			 
    			<p class="contact"><label for="nationality" path = "label1">Nationality</label></p> 
    			<form:input path="nationality" placeholder="Nationality" required="" tabindex="1" type="text"/> 
                
                        <p class="contact"><label for="religion" path = "label1">Religion</label></p> 
    			<form:input path="religion" placeholder="Religion" required="" tabindex="1" type="text"/>   
        
                        <form:select class="select-style gender" name="gender" path="gender">
                        <option value="select">i am..</option>
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                        </form:select><br><br>

                        <form:select class="select-style gender" name="bloodGroup" path="bloodGroup">
                        <option value="select">Blood Group</option>
                        <option value="O+">O+</option>
                        <option value="B+">B+</option>
                        <option value="A+">A+</option>
                        </form:select><br><br>

                        <p class="contact"><label for="mobileNumber" path = "label1">Mobile Number</label></p> 
    			<form:input path="mobileNumber" placeholder="Mobile Nunber" required="" tabindex="1" type="text"/>
             
                        <form:select class="select-style gender" path="role.roleId">
	                     <option value="select"> Role </option>
                    	<c:forEach items="${roleList}" var="userRole">
                        <form:option value="${userRole.roleId}">${userRole.roleName}</form:option>
                        </c:forEach>
                        </form:select><br><br>
            
            <input class="buttom" name="submit" id="submit" tabindex="5" value="Submit" type="submit"> 	 
   </form:form>
   <c:if test="${null != addMessage}">
                    <c:out value="${addMessage}"/>
                 </c:if> 
</div>
                 <div  class="form">
                    <form id="contactform" action="deleteUser.html" method="GET">
                    <p class="contact"><label for="username" path = "label1">Enter the Username to delete</label></p> 
                    <input placeholder="Username" required="" tabindex="1" type="text"/>
                    <input class="buttom" name="submit" id="submit" tabindex="5" value="Delete" type="submit">
                    </form>
                    <c:if test="${null != deleteMessage}">
                        <c:out value="${deleteMessage}"/>
                    </c:if>
                 </div>

                 <div  class="form">
                    <form id="contactform" action="searchUser.html" method="GET">
                    <p class="contact"><label for="username" path = "label1">Enter the Username to view</label></p> 
                    <input name ="username" placeholder="Username" required="" tabindex="1" type="text"/>
                    <input class="buttom" name="submit" id="submit" tabindex="5" value="Search" type="submit">
                    </form>
                    <c:if test="${null != searchUser}">
                <table border = 1>
                            
                    <tr>
                        <td><c:out value="${searchUser.getUserId()}"/></td>
                        <td><c:out value="${searchUser.getUsername()}"/></td>
                        <td><c:out value="${searchUser.getPassword()}"/></td>
                        <td><c:out value="${searchUser.getFirstName()}"/></td>
                        <td><c:out value="${searchUser.getLastName()}"/></td>
                        <td><c:out value="${searchUser.getGender()}"/></td>            
                        
                        <td><c:out value="${searchUser.getBloodGroup()}"/></td>
                        <td><c:out value="${searchUser.getMobileNumber()}"/></td>                   
                    </tr>            
                </table>   
            </c:if>  

            <c:if test="${null != searchMessage}">
                <c:out value="${searchMessage}"/>
            </c:if>
            
            <br>  
            </div>      
</div>

</body>
</html>