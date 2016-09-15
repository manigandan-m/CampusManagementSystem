<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope['username']==null}" >
   <c:redirect url="Login.html"/>
</c:if>
<c:if test="${sessionScope['role']!='admin'}" >
     <c:redirect url="Logout.html"/>
</c:if>
<html>
    <head>
        <title>Campus Management</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">                        
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
                <a href="home.html">Home</a>
                <span class="right">
                    <a href="Logout.html">
                        <strong>Logout</strong>
                    </a>
                </span>
                <div class="clr"></div>
            </div><!--/ freshdesignweb top bar -->
			<header>
				<h1>Address Details</h1>
            </header>       
      <div  class="form">
    		<form:form id="contactform" action="addAddress.html" method="POST" modelAttribute="Address"> 
    			<p class="contact"><label for="houseNumber" path = "label1">House Number</label></p> 
    			<form:input path="houseNumber" placeholder="House Number" required="" tabindex="1" type="text"/>

                        <p class="contact"><label for="streetName" path = "label1">Street Name</label><p> 
    			<form:input path="streetName" placeholder="Street Name" required="" tabindex="1" type="text"/>

                        <p class="contact"><label for="city" path = "label1">City</label><p> 
    			<form:input path="city" placeholder="city" required="" tabindex="1" type="text"/>

                        <p class="contact"><label for="state" path = "label1">State</label></p> 
    			<form:input path="state" placeholder="State" required="" tabindex="1" type="text"/>
                        
                        <p class="contact"><label for="country" path = "label1">Country</label><p> 
    			<form:input path="country" placeholder="Country" required="" tabindex="1" type="text"/>  
    			 
    			<p class="contact"><label for="pincode" path = "label1">PinCode</label></p> 
    			<form:input path="pincode" placeholder="PinCode" required="" tabindex="1" type="text"/> 
                 <form:input type = "hidden" path = "user.userId" value="${userId}"/>     
                       <input class="buttom" name="submit" id="submit" tabindex="5" value="Submit" type="submit"> 	 
                </form:form>
   <c:if test="${null != message}">
                    <c:out value="${message}"/>
                 </c:if> 
</div>      
</div>

</body>
</html>