<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users List</title>
</head>
<body>
    
    <center>
        <h1>Users Management</h1>
        <h2>
            <a href="new">Add New User</a>
            &nbsp;&nbsp;&nbsp;
            <a href="list">List All Users</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2><caption>
            <tr>
                <th>user_id</th>     
                <th>password</th>
                <th>first_name</th>
                <th>last_name</th>
                <th>gender</th>
                <th>age</th>
                <th>status</th>
            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.user_id}" /></td> 
                    <td><c:out value="${user.password}" /></td>
                    <td><c:out value="${user.first_name}" /></td>
                    <td><c:out value="${user.last_name}" /></td>            
                    <td><c:out value="${user.gender}" /></td>
                    <td><c:out value="${user.age}" /></td>
                    <td><c:out value="${user.status}" /></td>
                    <td>
                        <a href="edit?user_id=<c:out value='${user.user_id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?user_id=<c:out value='${user.user_id}' /> ">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>