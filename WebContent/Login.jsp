<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
    <title>Registration Application</title>
</head>
<body>
  /*
    <center>
       
        <h1>Students Management</h1>
       <h2>
            <a href="new">Add New Student</a>
            &nbsp;&nbsp;&nbsp;
            <a href="list">List All Students</a>
             
        </h2>
    </center>
  */
    <div align="center">
        
        
            <form action="insert" method="post">
        
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    
                    
                        Add New Student
                    
                </h2>
            </caption>
                           
            <tr hidden>
                <th>User_id: </th>
                <td>
                    <input type="number" name="user_id" size="10"
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