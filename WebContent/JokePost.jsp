<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
</head>
<body>
         <div align="center">   
       <form action="post" method="post">
        <table border="1" cellpadding="5">                 
	           
            <tr>
                <th>title: </th>
                <td>
                    <input type="text" name="title" size="100"
                            value=""
                    />
                </td>
            </tr>
            <tr>
                <th>Description: </th>
                <td>
                	 <input type="text" name="description" size="200"
                            value=""
                    />
                   <!-- <textarea input type="text" rows="4" cols="50" name="description" size="200"
                            value="">
                   
                    </textarea> --> 
                </td>
            </tr>
            <!-- 
            <tr>
                <th>tags: </th>
                <td>
                    <input type="text" name="tags" size="50"
                            value=""
                    />
                </td>
            </tr>
             -->
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