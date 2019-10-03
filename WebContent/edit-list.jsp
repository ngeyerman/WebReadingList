<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit a list</title>
</head>
<body>
<form action = "editExistingListServlet" method = "post">
List Name: <input type ="text" name = "listName" value="${listToEdit.listName}"><br/>
Read date: <input type ="text" name = "month" placeholder = "mm" size="4" value="${listToEdit.readDate.getMonthValue()}">
		   <input type ="text" name = "day" placeholder = "dd" size="4"	value="${listToEdit.readDate.getDayOfMonth()}">
		   <input type = "text" name = "year" placeholder="yyyy" size="4" value="${listToEdit.readDate.getYear()}">
Reader Name: <input type ="text" name ="readerName" value="${listToEdit.reader.readerName}"><br/>
<input type = "hidden" name = "id" value="${listToEdit.id}">
Current Books: <br/>

<select name="currentBooks" multiple size="6">
<c:forEach var="listVal" items = "${listToEdit.listOfBooks}">
<option value = "${listVal.id}">${listVal.title} | ${listVal.author} | ${listVal.genre}</option>
</c:forEach>
</select>
<br/>
Remaining Books:<br/>
<select name="booksToAdd" multiple size="6">
<c:forEach items="${requestScope.allBooksToAdd}" var="currentitem">
<option value = "${currentitem.id}">${currentitem.title} | ${currentitem.author} | ${currentitem.genre}</option>
</c:forEach>
</select>

<br/>
<input type = "submit" value="Edit List and Edit Books">
</form>
<a href = "index.html">Go add new books instead.</a>
</body>
</html>