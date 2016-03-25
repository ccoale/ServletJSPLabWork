<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.chris.RegisteredUser" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
<h1>Home</h1>
<% if (request.getAttribute("userName") != null) { %>
	Welcome <%= request.getAttribute("userName") %>
	<a href='/SimpleServletTest/logout'>Logout</a> <br/>
	<a href='/SimpleServletTest/DataServlet'>View Data</a> </br>
	<a href='/SimpleServletTest/AddData'>Add Data</a> </br>
<% } else { %>
	Welcome. Please <a href='/SimpleServletTest/login'>login</a>.
<% } %>
</body>
</html>