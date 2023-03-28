<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>user login</h1>
<form action="userLogin" method="get">
                
                
                <label>userEmail*</label> <br>
                <input placeholder="Enter userEmail" type="text" name="user_email"><br>
                <br> 
                <label>Password*</label><br>
                 <input placeholder="Enter Password" type="password" name="password"><br>

                
                <div id="btnsubmit">
                    <input type="submit" value="SUBMIT">
                    </div><br>
                    <a href="userRegister.jsp">Sign Up</a>
                    
</form>
</body>
</html>