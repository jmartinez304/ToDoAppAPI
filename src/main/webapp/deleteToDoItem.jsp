<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete To-Do Items Page</title>
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
		int itemId = (request.getParameter("itemId") == null) ? -1
				: Integer.parseInt(request.getParameter("itemId"));
		if (itemId != -1) {
			new NetClient().deleteRequest(itemId);
		}
		List<ToDoList> listOfItems = null;
		listOfItems = new NetClient().getRequest();
		for (ToDoList items : listOfItems) {
			out.println(items.getItemId() + ". " + items.getItemEntry() + "<br>");
		}
	%>
	<p>
		<b>Select the number of the entry in the list you wish to delete:</b>
	</p>
	<form action="deleteToDoItem.jsp" method="POST">
		<br> <select name="itemId">
			<%
				for (ToDoList items : listOfItems) {
					out.println("<option value=\"" + items.getItemId() + "\">" + items.getItemId() + "</option>");
				}
			%>
		</select><br>
		<button type="submit" id="deleteItem" name="deleteItem">
			Delete</button>

	</form>

	<h2>Other actions available:</h2>
	<form action="index.jsp" method="GET">
		<input type="submit" value="Go to home page" name="homePage" />
		&nbsp; &nbsp;<br>
	</form>
	<form action="showAllItems.jsp" method="GET">
		<input type="submit" name="showItem" value="View To-Do Item List">
		&nbsp; &nbsp;<br>
	</form>
	<form action="saveItem.jsp" method="GET">
		<input type="submit" value="Add an Item to the To-Do List"
			name="addItem" /> &nbsp; &nbsp;<br>
	</form>

</body>
</html>