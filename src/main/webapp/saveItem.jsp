<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert item into To-Do list</title>
<link rel="stylesheet" href="styles.css">
<%@ page import="com.juan.ToDoAppAPI.NetClient"%>
</head>
<body>
	<%
		String listItem = request.getParameter("listItem");
		if (listItem != null) {
			new NetClient().postRequest(listItem);
		}
	%>
	<div id="add">
		<h1>Enter to-do list Items</h1>
		<form action="saveItem.jsp" method="POST">
			<table>
				<tr>
					<td>Enter to-do list entry:</td>
					<td><input type="text" name="listItem"></td>
				</tr>
				<tr>
					<td><input type="submit" name="addItem" value="Enter Item"></td>

				</tr>
			</table>
		</form>
	</div>

	<h2>Other actions available:</h2>
	<form action="index.jsp" method="GET">
		<input type="submit" value="Go to home page" name="homePage" />
		&nbsp; &nbsp;<br>
	</form>
	<form action="showAllItems.jsp" method="GET">
		<input type="submit" name="showItem" value="View To-Do Item List">
		&nbsp; &nbsp;<br>
	</form>
	<form action="deleteToDoItem.jsp" method="POST">
		<input type="submit" name="deleteItemSelection"
			value="Delete an Item from the To-Do List"> &nbsp; &nbsp;<br>
	</form>
</body>
</html>