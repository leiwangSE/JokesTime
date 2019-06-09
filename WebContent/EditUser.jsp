<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
</head>
<body>
      <div align="center">   
       <form action="update" method="post">
        <table border="1" cellpadding="5">
        <caption>
                <h2>Edit an Existing User</h2>
            </caption>                 
          
                    <input type="hidden" name="user_id" size="30"
                          value="<c:out value="${user.user_id}" />" />
                       
         
            <tr>
                <th>Password: </th>
                <td>
                    <input type="password" name="password" size="50"
                            value="<c:out value="${user.password}" />"
                    />
                </td>
            </tr>
            <tr>
                <th>First Name: </th>
                <td>
                    <input type="text" name="first_name" size="50"
                            value="<c:out value="${user.first_name}" />"
                    />
                </td>
            </tr>
            <tr>
                <th>Last Name: </th>
                <td>
                    <input type="text" name="last_name" size="50"
                            value="<c:out value='${user.last_name}' />"
                    />
                </td>
            </tr>  
            <tr>
                <th>Email: </th>
                <td>
                    <input type="email" name="email" size="50"
                            value="<c:out value='${user.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Gender: </th>
                <td>
                    <input type="text" name="gender" size="10"
                            value="<c:out value='${user.gender}' />"
                    />
                </td>
            </tr>
           <tr>
                <th>Age: </th>
                <td>
                    <input type="number" name="age" size="11"
                            value="<c:out value='${user.age}' />"
                    />
                </td>
            </tr>
           <tr >
                
                    <input type="hidden" name="status" size="10"
                            value="<c:out value='${user.status}' />"
                    />
                
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>