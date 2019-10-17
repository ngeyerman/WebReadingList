<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix= "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script>
function validateEdit(){
	var title = document.forms["editBook"]['title'].value;
	var author = document.forms["editBook"]['author'].value;
	var genre = document.forms["editBook"]['genre'].value;
	
	if(title ==""){
		alert("A title must be provided.");
		return false;
	} else if(author ==""){
		alert('An author must be provided.');
		return false;
	} else if(genre==""){
		alert('A genre must be provided.')
		return false;
	}
	
}
</script>

<title>Edit the book</title>
</head>
<body>
<form name = "editBook" action = "editBookServlet" onsubmit="return validateEdit()" method="post">
Title: <input type = "text" name = "title" value = "${bookToEdit.title}">
Author: <input type = "text" name = "author" value = "${bookToEdit.author }">
Genre: <input type = "text" name = "genre" value = "${bookToEdit.genre }">
<input type = "hidden" name= "id" value="${bookToEdit.id}">
<input type = "submit" value="Save Edited Book">
</form>
</body>
</html>