<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Here is the data</title>
</head>
<body>
<h1>Here is the data:</h1>
<a href="/SimpleServletTest/home">Go back home</a><br/>
<table>
<th>
	<tr><td>Name</td> <td>Date</td> <td>Description</td> <td>Quantity</td> <td>Price</td> <td> User ID </td></tr>
<c:forEach var="record" items="${data}">
	<tr><td>${record.name}</td> <td>${record.date}</td> <td>${record.description}</td> <td>${record.quantity}</td> <td>${record.price}</td> <td>${record.userid}</td></tr>
</c:forEach>
</table>
</body>
</html>