<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show all items in the To-Do list</title>
<link rel="stylesheet" href="styles.css">
<%@ page import="com.juan.ToDoAppAPI.NetClient"%>
<%@ page import="com.juan.ToDoAppAPI.ToDoList"%>
<%@ page import="java.util.List"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
	<h2>All Items:</h2>
	<%
		List<ToDoList> listOfItems = null;
		listOfItems = new NetClient().getRequest();
		for (ToDoList items : listOfItems) {
			out.println(items.getItemId() + ". " + items.getItemEntry() + "<br>");
		}
	%>


	<h2>Other actions available:</h2>
	<form action="index.jsp" method="GET">
		<input type="submit" value="Go to home page" name="homePage" />
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