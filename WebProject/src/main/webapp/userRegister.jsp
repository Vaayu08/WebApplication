<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>User-Regisatration</h1>
<form action="userRegister" method="post">
                 <label>userId*</label><br>
                 <input placeholder="Enter userId" type="number" name="user_id"><br>
                  <br>
                 <label>userName*</label> <br>
                <input placeholder="Enter userName" type="text" name="user_name"><br>
                <br> 
                <label>userEmail*</label> <br>
                <input placeholder="Enter userEmail" type="text" name="user_email"><br>
                <br> 
                <label>Password*</label><br>
                 <input placeholder="Enter Password" type="password" name="password"><br>
                <br> 
                <label>contactNumber*</label><br>
                 <input placeholder="Enter conatactNumber" type="text" name="contact_number"><br>
                <br> 
                <label>Address*</label> <br>
                <input placeholder="Enter Address" type="text" name="address"><br>
                <br> 
                
                <div id="btnsubmit">
                    <input type="submit" value="SUBMIT">
                    </div>
</form>
</body>
</html>