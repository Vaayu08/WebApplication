<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.soft.beans.product"%>
<%@page import="java.util.List"%>
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
<%String username = (String) request.getAttribute("userName");%>
<h1>Welcome::<%= username %></h1>


<div style="">
<a href="addproduct.jsp"><button>Add New product</button></a>
<table style="border:1px solid black;">
<thead>
<tr>
<th>ProductId</th>
<th>ProductName</th>
<th>ProductQty</th>
<th>ProductPrice</th>
<th>Actions</th>
</tr>
</thead>
<tbody>
<%
 ProductDao productdao = new ProductDao();
 List<product> productlist = productdao.findAllproduct();

%>
<%
 for(product prod:productlist){ %>
	
	<tr>
	<td><%=prod.getPid() %></td>
	<td><%=prod.getPname() %></td>
	<td><%=prod.getPqty() %></td>
	<td><%=prod.getPprice() %></td>
	
	<td>
	<a href="editProduct.jsp?pid=<%=prod.getPid() %>"><button>Edit</button></a>
	<a href="DeleteProductServlet?pid=<%=prod.getPid() %>" onclick="return confirm('Are You sure Delete This Record')"><button>Delete</button></a>
	</td>
	</tr>
	<%
	}
%>

</tbody>
</table>
</div>
</body>
</html>