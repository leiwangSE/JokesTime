<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">   
       <form action="login" method="post">
        <table border="1" cellpadding="5">                 
            <tr >
                <th>User_id: </th>
                <td>
                    <input type="text" name="user_id" size="38"
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
                <td colspan="2" align="center">
                    <input type="submit" value="Submit" />
                </td>
            </tr>
          
          
          
        </table>
        </form>
    </div>   
</body>
</html>