<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users List</title>
</head>
<body>
    
    <center>
        <h1>Jokes Post</h1>
        <h2>
            <a href="listposts">List All Jokes</a>
             
        </h2>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2><caption>
            <tr>
                <th>Joke_id</th>     
                <th>Title</th>
                <th>Content</th>
                <th>User_id</th>
                <th>Tag</th>
                <th>Datetime</th>
               
            </tr>
            <c:forEach var="joke" items="${listJokes}">
                <tr>
                    <td><c:out value="${joke.joke_id}" /></td> 
                    
                    <td><c:out value="${joke.title}" /></td>
                    <td><c:out value="${joke.description}" /></td>
                    <td><c:out value="${joke.user_id}" /></td>  
                    <td><c:forEach var="tag" items="${listTags}">
                       
                       <c:set var = "joke_joke_id" scope = "session" value ="${joke.joke_id}" />
                       <c:set var = "tag_joke_id" scope = "session" value ="${tag.joke_id}" />
                       <c:if test="${joke_joke_id== tag_joke_id}" >
                       <c:out value="${tag.tag}"/>
                       </c:if>
	              
                    	</c:forEach>
                    </td> 
                    <td><c:out value="${joke.dateTime}" /></td>            
                    <!--  <td>
                        <a href="edit?user_id=<c:out value='${user.user_id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?user_id=<c:out value='${user.user_id}' /> ">Delete</a>                     
                    </td>-->
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>