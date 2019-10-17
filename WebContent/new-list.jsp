<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script>
	function validateList() {
		var listName = document.forms["newList"]["listName"].value;
		var readerName = document.forms["newList"]["readerName"].value;
		var booksToAdd = document.forms["newList"]["allBooksToAdd"].value;
		

		
		/*var month = Integer.parseInt(parts[1]);
		var day = Integer.parseInt(parts[2]);
		var year = Integer.parseInt(parts[0]);*/

		if (listName == "") {
			alert("A list name must be provided.");
			return false;

		} /*else if(month==0|| month >12){ //trying to script error if date is invalid.  
		 alert("provide valid month");
		 return false;
		}*/ else if (readerName == "") {
		
		
			alert("A reader name must be provided");
			return false;
		} else if (booksToAdd == "") {
			alert("You must add books to create a list.");
			return false;
		}

	}
</script>

<title>Create a new list</title>
</head>

<body>
	<form name="newList" action="createNewListServlet"
		onsubmit="return validateList()" method="post">
		List Name: <input type="text" name="listName"><br />  
<c:set var="date" value="${fn:split(listToEdit.readDate, '-')}" /> 
		Read Date: <input type="text" name="month" value="${date[1]}" placeholder="mm" size="4">
		      <input type="text" name="day" value="${date[2]}"placeholder="dd" size="4"> 
		      <input type="text" name="year" value="${date[0]}" placeholder="yyyy" size="4">
		Reader Name: <input type="text" name="readerName"><br />
		Available Books:<br /> <select name="allBooksToAdd" multiple size="6">
			<c:forEach items="${requestScope.allBooks}" var="currentitem">
				<option value="${currentitem.id }">${currentitem.title}|
					${currentitem.author} | ${currentitem.genre }</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Create List and Add Books">
	</form>
	<a href="index.html">Go add new items instead.</a>
</body>
</html>