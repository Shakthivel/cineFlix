<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<title>CineFlix Corporate - Screen Info</title>
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

	<section class="movie-form">
		<form:form method="POST" modelAttribute="theatre">
			<div class="container-fluid">

				<form:input path="theatreId" type="hidden" class="form-style"/>
				<form:input path="password" type="hidden" class="form-style"/>
				<form:input path="movies" type="hidden" class="form-style"/>
				
				<div style="padding: 2rem;">
					<h1>Fill in the Theatre Info</h1>
				</div>

				<div class="form-row">

					<div class="col">
						<h4>Theatre Name</h4>
						<form:input path="theatreName" type="text" class="form-style"/>
					</div>

					<div class="col">
						<h4>Number of Screens</h4>
						<form:input path="" name="noOfScreens" type="text" class="form-style"/>
					</div>

				</div>

				<div class="form-row">
					<div class="col">
						<h4>Location</h4>
						<form:input path="theatreAddress" type="text" class="form-style"/>
					</div>
				</div>


			</div>

			<div class="text-center m-2">
				<button class="btn btn-primary btn-lg btn-login"
					type="submit" style="color: #125D98;">Save
					Details</button>
			</div>
		</form:form>
	</section>
</body>
</html>