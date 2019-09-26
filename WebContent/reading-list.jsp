<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head> 
<meta charset="ISO-8859-1">
<title>Book List</title>
</head>
<body>
<form method = "post" action = "navigationServlet">
	<table>
	<c:forEach items="${requestScope.allBooks}" var="currentitem">
			<tr>
				<td><input type="radio" name="id" value="${currentitem.id}"></td>
				<td>${currentitem.title}</td>
				<td>${currentitem.author}</td>
				<td>${currentitem.genre}</td>
			</tr>
	</c:forEach>
	</table>
	<input type = "submit" value = "Edit Book" name="doThisToBook">
	<input type = "submit" value = "Delete Book" name="doThisToBook">
	<input type = "submit" value = "Add Book" name = "doThisToBook">
	</form>
</body>
</html>
