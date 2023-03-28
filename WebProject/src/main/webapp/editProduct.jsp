<%@page import="com.soft.beans.product"%>
<%@page import="com.soft.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
int pid = Integer.parseInt(request.getParameter("pid"));
 ProductDao productdao = new ProductDao();
 product exitproduct = productdao.findBypid(pid);

%>
<h1>Update Product</h1>
<form action="editProduct" method="post">
                  <label>ProductId*</label><br>
                 <input placeholder="Enter pId" type="number" name="pid" readonly value="<%=exitproduct.getPid() %>"><br>
                  <br>
                   <label>ProductName*</label><br>
                 <input placeholder="Enter ProductName" type="text" name="pname" value="<%=exitproduct.getPname() %>"><br>
                  <br>
                   <label>ProductQty*</label><br>
                 <input placeholder="Enter ProductQty" type="number" name="pqty" value="<%=exitproduct.getPqty() %>"><br>
                  <br>
                  <label>ProductPrice*</label><br>
                 <input placeholder="Enter ProductPrice" type="number" name="pprice" value="<%=exitproduct.getPprice() %>"><br>
                  <br>
                   <div id="btnsubmit">
                    <input type="submit" value="SUBMIT">
                    </div>
                    </form>
</body>
</html>