<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="login.css" rel="stylesheet" type="text/css">
	<title>Admin Login</title>
</head>

<body>
	<div id="form-div">
		<h1>Admin Login</h1>
		<form action="LoginServlet" method="post">
			<input type="text" name="username" placeholder="Enter Username">
			<input type="password" name="password" placeholder="Enter Password">
			<input type="submit" value="submit" id="submit">
		</form>
	</div>

</body>
</html>