<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix= "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit the book</title>
</head>
<body>
<form action = "editBookServlet" method="post">
Title: <input type = "text" name = "title" value = "${bookToEdit.title}">
Author: <input type = "text" name = "author" value = "${bookToEdit.author }">
Genre: <input type = "text" name = "genre" value = "${bookToEdit.genre }">
<input type = "hidden" name= "id" value="${bookToEdit.id}">
<input type = "submit" value="Save Edited Book">
</form>
</body>
</html>