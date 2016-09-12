<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%-- <c:if test="${sessionScope['username']==null}" >
   <c:redirect url="Login.html"/>
</c:if>
<c:if test="${sessionScope['role']!='admin'}" >
     <c:redirect url="Logout.html"/>
</c:if>--%>
<html>
    <head>
        <title>List of Employees</title>
        <style>
    body {
    background-color: #00ccff;
    font-family: serif;
    font-style: italic;
    }
    h3 {
    color: red;
    }
    tr:hover {
       background-color: #f5f5f5
    }
    input[type=submit] {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 10px 10px;
            text-decoration: none;
            margin: 2px 2px;
            cursor: pointer;
    }
    </style>
    </head>
    <center>
        <body>
            <h3>Employee List Details</h3> 
	    <table border="2">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Day of Period</th>
                        <th>Time of Period</th>
                    </tr>
                </thead>		
                <tbody>
                
            <c:forEach items="${periods}" var="period">
                <tr>
                    <td><c:out value="${period.getPeriodId()}" /></td>
                    <td><c:out value="${period.getDayOfPeriod()}" /></td>
                    <td><c:out value="${period.getTimeOfPeriod()}" /></td>
                </tr>
            </c:forEach>
            
        </tbody>
    </table>
	   
            <br/><br/>
	    <b>Go to main page </b><a href="EmployeeOperation" style="font-sise:18px"> Click here</a>
	    <br/><br/>
	    <b>Do you want to insert a new record?</b><a href="InsertEmployee">Insert</a><br><br>
		<a href = "EmployeeOperation">Employee Operation</a>
		<form action="logout" method="post">
		    <input type="submit" value="Logout">
	    </form>
	    <c:if test="${displayMessage!=null}" >
            <td>${displayMessage}</td>
        </c:if>
        </body>
    </center>
</html>
