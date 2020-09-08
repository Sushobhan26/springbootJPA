<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h3>Add Alien</h3>
	<form action="addAlien">
	<input type="text" name="aid"><br>
	<input type="text" name="aname"><br>
	<input type="text" name="tech"><br>
	<input type="Submit"><br>
	</form>
	<h3>Find Alien by ID</h3>
	<form action="getAlienById">
	<input type="text" name="aid"><br>
	<input type="Submit"><br>
	</form>
	<h3>Find Alien By Tech</h3>
	<form action="getAlienByTech">
	<input type="text" name="tech"><br>
	<input type="Submit"><br>
	</form>
	<h3>Update Alien</h3>
	<form action="updateAlien">
	<input type="text" name="aid"><br>
	<input type="Submit"><br>
	</form>
	
</body>
</html>