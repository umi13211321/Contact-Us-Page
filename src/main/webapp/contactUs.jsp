<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	<link rel="stylesheet" href="contactUs.css">
	<Title>Contact Us</Title>
</head>

<body>
    <h1 id="title"> Contact Us</h1><br>
    <div id="form-div">
        <form action="ContactUsServlet" method="post">
            <input type="text" name="name" placeholder="Enter your Name"> <br />
            <input type="email" name="email" placeholder="Enter your Email"> <br />
            <textarea name="message" placeholder="Enter your Message"></textarea> <br />
            <input type="submit" value="submit" id="submit"> <br />
        </form>
    </div>
</body>
</html>