<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope['username']==null}" >
   <c:redirect url="StudentLogin.html"/>
</c:if>
<c:if test="${sessionScope['role']!='student'}" >
     <c:redirect url="Logout.html"/>
</c:if>   
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
                <a href="index.jsp">Home</a>
                <span class="right">
                    <a href="Logout.html">
                        <strong>Logout</strong>
                    </a>
                </span>
                <div class="clr"></div>
            </div><!--/ freshdesignweb top bar -->
			<header>
				<h1>Student Login</h1>
            </header>       
      <div  class="form">
    		<form id="contactform" action = "studentlogin.html" method="POST"> 
    			<p class="contact"><label for="username">Username</label></p> 
    			<input name="username" placeholder="username" required="" tabindex="1" type="text"> 
    			 
    			<p class="contact"><label for="password">Password</label></p> 
    			<input name="password" placeholder="password" required="" type="text">

                <input class="buttom" name="submit" id="submit" tabindex="5" value="Login" type="submit"> 	 
   </form>
   
      <c:if test="${null != message}">
                <c:out value="${message}"/>
            </c:if>
      <br> 
</div>      
</div>

</body>
</html> 
