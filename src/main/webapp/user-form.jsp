<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Appointment Booking</title>
<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href=
	"https://maxcdn.bootstrapcdn.com/bootstrap/
	4.0.0/css/bootstrap.min.css">
	<!-- jQuery library -->
	<script src=
	"https://ajax.googleapis.com/ajax/libs/
	jquery/3.3.1/jquery.min.js">
	</script>
	<!-- Popper JS -->
	<script src=
	"https://cdnjs.cloudflare.com/ajax/libs/
	popper.js/1.12.9/umd/popper.min.js">
	</script>
	<!-- Latest compiled JavaScript -->
	<script src=
	"https://maxcdn.bootstrapcdn.com/bootstrap/
	4.0.0/js/bootstrap.min.js">
	</script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body style="background-image: url('doctor1.jpg')";>


	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="choices.html" class="navbar-brand"> Menu </a>
			</div>

			
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit Appointment
            		</c:if>
						<c:if test="${user == null}">
            			Book New Appointment
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Appointment date</label> <input type="text"
						value="<c:out value='${user.apdate}' />" class="form-control"
						name="apdate" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Appointment time</label> <input type="text"
						value="<c:out value='${user.aptime}' />" class="form-control"
						name="aptime">
				</fieldset>

				<fieldset class="form-group">
					<label>User contact no.</label> <input type="text" id="phoneno"
						value="<c:out value='${user.phoneno}' />" class="form-control"
						name="phoneno">
						
				</fieldset>
				
				<fieldset class="form-group">
					<label>Gender</label> <input type="text"
						value="<c:out value='${user.gender}' />" class="form-control"
						name="gender">
				</fieldset>
				
				<fieldset class="form-group">
				
					<label>User-name</label> <input type="text" id="usernames"
						value="<c:out value='${user.username}' />" class="form-control"
						name="username">
						
				</fieldset>
				
				<fieldset class="form-group">
				
					<label>Disease</label> <input type="text"
						value="<c:out value='${user.disease}' />" class="form-control"
						name="disease">
						
				</fieldset>
                  
				<button id="submitbtn" type="submit" class="btn btn-success">Book Appointment</button>
                 
				</form>
			</div>
		</div>
	</div>
	
	
</body>
</html>
