<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add Product</h1>
<form action="addProduct" method="post">
                  <label>ProductId*</label><br>
                 <input placeholder="Enter pId" type="number" name="pid"><br>
                  <br>
                   <label>ProductName*</label><br>
                 <input placeholder="Enter ProductName" type="text" name="pname"><br>
                  <br>
                   <label>ProductQty*</label><br>
                 <input placeholder="Enter ProductQty" type="number" name="pqty"><br>
                  <br>
                  <label>ProductPrice*</label><br>
                 <input placeholder="Enter ProductPrice" type="number" name="pprice"><br>
                  <br>
                   <div id="btnsubmit">
                    <input type="submit" value="SUBMIT">
                    </div>
                    </form>
</body>
</html>