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
    <div align = "center">
        <body>
            <h3>Teacher List Details</h3> 
            <c:if test="${null != teachers}">
	    <table border="2">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>User Name</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Designation</th>
                        <th>Coordinator Standard</th>
                    </tr>
                </thead>		
                <tbody>
                
            <c:forEach items="${teachers}" var="teacher">
                <tr>
                    <td><c:out value="${teacher.getTeacherId()}" /></td>                    
                    <td><c:out value="${teacher.getUser().getUsername()}" /></td>
                    <td><c:out value="${teacher.getUser().getFirstName()}" /></td>
                    <td><c:out value="${teacher.getUser().getLastName()}" /></td>
                    <td><c:out value="${teacher.getDesignation()}" /></td>
                    <td><c:out value="${teacher.getstandardOfCoordinator().getStandardName()}" /></td>
                    <td><a  href="teacherEdit.html">Edit</a></td>
                    <td><a  href="deleteTeacher.html?teacherId=${teacher.getTeacherId()}">Delete</a></td>
                     <td><a  href="viewTeacher.html?teacherId=${teacher.getTeacherId()}">View</a></td>
                </tr>
            </c:forEach>
              
        </tbody>
    </table>
	  </c:if> 
	   <c:if test="${null != mesage}">
              <c:out value="${message}"/>
          </c:if> 
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
    </div>
</html>