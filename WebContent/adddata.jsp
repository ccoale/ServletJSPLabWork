<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Data</title>
</head>
<body>
<h1>Add Data</h1>
<form action="/SimpleServletTest/AddData" method="post">
	Name: <input name="name" type="text" />
	Date: <input name="date" type="text" />
	Quantity: <input name="quantity" type="text" />
	Price: <input name="price" type="text" />
	
	<input type="submit" value="Add Record" />
</form>
</body>
</html>