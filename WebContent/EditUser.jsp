<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
</head>
<body>
      <div align="center">   
       <form action="edit" method="post">
        <table border="1" cellpadding="5">                 
            <tr hidden>
                <th>User_id: </th>
                <td>
                    <input type="number" name="user_id" size="10"
                            value="<c:out value='${users.user_id}' />" 
                        />
                </td>
            </tr>
            
            <tr>
                <th>Password: </th>
                <td>
                    <input type="password" name="password" size="50"
                            value="<c:out value='${users.password}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>First Name: </th>
                <td>
                    <input type="text" name="first_name" size="50"
                            value="<c:out value='${users.first_name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Last Name: </th>
                <td>
                    <input type="text" name="last_name" size="50"
                            value="<c:out value='${users.last_name}' />"
                    />
                </td>
            </tr>  
            <tr>
                <th>Email: </th>
                <td>
                    <input type="email" name="email" size="50"
                            value="<c:out value='${users.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Gender: </th>
                <td>
                    <input type="text" name="gender" size="10"
                            value="<c:out value='${users.gender}' />"
                    />
                </td>
            </tr>
           <tr>
                <th>Age: </th>
                <td>
                    <input type="number" name="age" size="11"
                            value="<c:out value='${users.age}' />"
                    />
                </td>
            </tr>
           <tr hidden>
                <th>Status: </th>
                <td>
                    <input type="text" name="status" size="10"
                            value="<c:out value='${users.status}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Submit" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>