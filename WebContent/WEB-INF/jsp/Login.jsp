<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%--<c:if test="${sessionScope['id']!=null}" >
   <c:redirect url="index.jsp"/>
</c:if>--%>

<html>
    <head>
        <title>Login Employee</title>
        <style>
        body {
            background-color: #00ccff;
            font-family: serif;
            font-style: italic;
        }
        h2 {
        color: red;
        }
        tr:hover {
        background-color: #f5f5f5
        }
        input[type=text]:{
             width: 20%
        }
        input[type=password] {
            width: 15%;
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
     
    <body>
        <center>
        <h2>Login Page</h2>
        <form action="login.html" method=post>
            ID:
            <br>
            <input type="text" name="username" placeholder="username" required>
            <br>
            Password:
            <br>
            <input type="password" name="password" placeholder="password" required>
            <br>
            <input type="submit" name="login" value="submit">
        </form>
        </center>
        <c:if test="${Message!=null}" >
            <c:out value="${Message}" />
        </c:if>
    </body>
</html>

