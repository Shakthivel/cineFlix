<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="javax.servlet.http.HttpSession"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Title Icon -->
<link rel="icon"
	href="https://res.cloudinary.com/dfep0loer/image/upload/v1638860594/CineFlix/theatre-icon_ostugn.ico"
	type="image/x-icon">
<!-- Title -->
<title>CineFlix Corporate - Theatre Info</title>
<!-- Local Stylesheet -->
<link rel="stylesheet" type="text/css"
	href="../resources/css/corporate-styles.css">
<!-- Font Awesome CDN -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
	integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
	crossorigin="anonymous">
<!-- Bootstrap CDN -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">

</head>



<body>
	<nav class="navbar navbar-expand-lg navbar-dark"
		style="background-color: #125D98;">
		<a class="navbar-brand" href="#"><img
			src="https://res.cloudinary.com/dfep0loer/image/upload/v1638860411/CineFlix/CineFlix-Corporate_agmn5o.png"
			alt=""></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link"
					href="corporate-login.html">Logout</a></li>
			</ul>
		</div>
	</nav>
	<%
	int noOfScreens = (int) session.getAttribute("noOfScreens");
	%>
	<section class="movie-form">
		<form method="POST">
			<div style="padding: 2rem;">
				<h2>Fill in the Screen Info</h2>
			</div>
			<%
			for (int i = 0; i < noOfScreens; i++) {
			%>
			<div class="container-fluid">


				<div style="padding: .8rem 2rem .8rem 2rem;">
					<h3>
						Screen
						<%=i + 1%></h3>

				</div>

				<div class="form-row">

					<div class="col">
						<h5>Screen Name</h5>
						<input type="text" name="screenName" class="form-style">
					</div>

					<div class="col">
						<h5>Number of Budget rows</h5>
						<input type="text" name="budgetRows" class="form-style">
					</div>

				</div>

				<div class="form-row">

					<div class="col">
						<h5>Number of Rows</h5>
						<input type="text" name="totalRows" class="form-style">
					</div>

					<div class="col">
						<h5>Number of Colums</h5>
						<input type="text" name="totalColumns" class="form-style">
					</div>

				</div>

				<div class="form-row">
					<div class="col">
						<h5>Morning Show Timing</h5>
						<input type="time" name="show1" class="form-style">
					</div>

					<div class="col">
						<h5>Matinee Show Timing</h5>
						<input type="time" name="show2" class="form-style">
					</div>

					<div class="col">
						<h5>Evening Show Timing</h5>
						<input type="time" name="show3" class="form-style">
					</div>

					<div class="col">
						<h5>Night Show Timing</h5>
						<input type="time" name="show4" class="form-style">
					</div>
				</div>


			</div>
			<hr style="color: #000000;">
			<%
			}
			%>
			<div class="text-center m-4">
				<button type="submit" class="btn btn-primary btn-lg btn-login"
					style="color: #125D98;">Save Details</button>
			</div>
		</form>
	</section>
</body>

</html>