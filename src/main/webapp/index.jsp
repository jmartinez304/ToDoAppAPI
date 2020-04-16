<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
	<h1>This is a to-do-item application</h1>
	<h2>Select an action:</h2>
	<form action="showAllItems.jsp" method="GET">
		<input type="submit" name="showItem" value="View To-Do Item List">
		&nbsp; &nbsp;<br>
	</form>
	<form action="saveItem.jsp" method="GET">
		<input type="submit" value="Add an Item to the To-Do List"
			name="addItem" /> &nbsp; &nbsp;<br>
	</form>
	<form action="deleteToDoItem.jsp" method="POST">
		<input type="submit" name="deleteItemSelection"
			value="Delete an Item from the To-Do List"> &nbsp; &nbsp;<br>
	</form>
</body>
</html>