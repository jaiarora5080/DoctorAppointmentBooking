<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Smart health system</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body style="background-image: url('doctor3.jpg')";>
<form action="list" method="get">


	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="choices.html" class="navbar-brand"> Menu
					</a>
			</div>

			
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Bookings</h3>
			<hr>
			
			<br>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Appointment ID</th>
						<th>Appointment date</th>
						<th>Appointment time</th>
						<th>User contact no.</th>
						<th>Gender</th>
						<th>User-name</th>
						<th>Disease</th>
						
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="user" items="${listUser}">

						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.apdate}" /></td>
							<td><c:out value="${user.aptime}" /></td>
							<td><c:out value="${user.phoneno}" /></td>
							<td><c:out value="${user.gender}" /></td>
							<td><c:out value="${user.username}" /></td>
							<td><c:out value="${user.disease}" /></td>

							
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</form>
	
</body>
</html>
