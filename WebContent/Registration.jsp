<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
    <title>Registration Application</title>
</head>
<body>
  <!--
    <center>
       
       <h1>Users Management</h1>
       <h2>
            <a href="new">Add New User</a>
            &nbsp;&nbsp;&nbsp;
            <a href="list">List All Users</a>
             
        </h2>
    </center>

    <div align="center">
        <c:if joke="${users != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${users == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    
                    <c:if joke="${users != null}">
                        Edit User
                    </c:if>
                    <c:if joke="${users == null}">
                        Add New User
                    </c:if>
                    
                </h2>
            </caption>
              
             <c:if joke="${users != null}">
                    <input type="hidden" name="id" value="<c:out value='${users.user_id }' />" />
                </c:if>   -->  
       <div align="center">   
       <form action="insert" method="post">
        <table border="1" cellpadding="5">                 
            <tr hidden>
                <th>User_id: </th>
                <td>
                    <input type="number" name="user_id" size="10"
                            value="" 
                        />
                </td>
            </tr>
            
            <tr>
                <th>Password: </th>
                <td>
                    <input type="password" name="password" size="50"
                            value=""
                    />
                </td>
            </tr>
            <tr>
                <th>First Name: </th>
                <td>
                    <input type="text" name="first_name" size="50"
                            value=""
                    />
                </td>
            </tr>
            <tr>
                <th>Last Name: </th>
                <td>
                    <input type="text" name="last_name" size="50"
                            value=""
                    />
                </td>
            </tr>  
            <tr>
                <th>Email: </th>
                <td>
                    <input type="email" name="email" size="50"
                            value=""
                    />
                </td>
            </tr>
            <tr>
                <th>Gender: </th>
                <td>
                    <input type="text" name="gender" size="10"
                            value=""
                    />
                </td>
            </tr>
           <tr>
                <th>Age: </th>
                <td>
                    <input type="number" name="age" size="11"
                            value=""
                    />
                </td>
            </tr>
           <tr hidden>
                <th>Status: </th>
                <td>
                    <input type="text" name="status" size="10"
                            value=""
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