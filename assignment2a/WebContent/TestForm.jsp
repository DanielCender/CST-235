<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test Form</title>
</head>
<body>
		<form action="TestServlet" method="post">
		<label id="firstname">First Name</label>
		<input name="firstname" type="text"/>
		<label id="lastname">Last Name:</label>
		<input name="lastname" type="text"/>
		<button type="submit">Submit</button>
	</form>
</body>
</html>