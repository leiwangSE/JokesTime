<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Students Registration</title>
</head>
<body>
    <center>
        <h1>Students Management</h1>
        <h2>
            <a href="new">Add New Student</a>
            &nbsp;&nbsp;&nbsp;
            <a href="list">List All Students</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Students</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Address</th>
                <th>status</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="student" items="${listStudent}">
                <tr>
                    <td><c:out value="${student.id}" /></td>
                    <td><c:out value="${student.name}" /></td>
                    <td><c:out value="${student.address}" /></td>
                    <td><c:out value="${student.status}" /></td>
                    <td>
                        <a href="edit?id=<c:out value='${student.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?id=<c:out value='${student.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>