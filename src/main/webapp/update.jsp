<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="addAlien">
	<input type="text" name="aid" value="${alien.aid}" readonly><br>
	<input type="text" name="aname" value="${alien.aname}"><br>
	<input type="text" name="tech" value="${alien.tech}"><br>
	<input type="Submit"><br>
	</form>

</body>
</html>