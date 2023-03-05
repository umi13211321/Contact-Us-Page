<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="dashboard.css" rel="stylesheet">
	<title>Dashboard</title>
</head>

<body>
	<h2 id="activeUsers">Active Users</h2>
	<table border="2">
		<thead>
			<tr>
				<th class="header">Id</th>
				<th class="header">Username</th>
				<th class="header">Email</th>
				<th class="header">Message</th>
				<th class="header">Status</th>
				<th class="header">Time</th>
				<th class="header">Toggle</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="var" items="${activeUsers}">
				<tr>
					<td>${var.id}</td>
					<td>${var.name}</td>
					<td>${var.email}</td>
					<td>${var.message}</td>
					<td>${var.status}</td>
					<td>${var.time}</td>
					<td>
						<form action="DashboardServlet" method="post">
							<input type="hidden" name="status" value="${var.status}">
							<button value="${var.id}" name="id">Change Status</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<h2 id="archivedUsers">Archived Users</h2>
	<table border="2">
		<thead>
			<tr>
				<th class="header">Id</th>
				<th class="header">Username</th>
				<th class="header">Email</th>
				<th class="header">Message</th>
				<th class="header">Status</th>
				<th class="header">Time</th>
				<th class="header">Toggle</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="var" items="${archivedUsers}">
				<tr>
					<td>${var.id}</td>
					<td>${var.name}</td>
					<td>${var.email}</td>
					<td>${var.message}</td>
					<td>${var.status}</td>
					<td>${var.time}</td>
					<td>
						<form action="DashboardServlet" method="post">
							<input type="hidden" name="status" value="${var.status}">
							<button value="${var.id}" name="id">Change Status</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>