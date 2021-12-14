<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>CineFlix Corporate - Add Movie</title>
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
					href="corporate-index.jsp">Home</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/corporate/login">Logout</a></li>
			</ul>
		</div>
	</nav>


	<section id="movie-info">
		<div class=""
			style="background-color: rgb(248, 248, 248); box-shadow: 0 10px 12px -3px rgba(0, 0, 0, 0.1);">
			<div class="p-4">
				<h3>${movie.movieName }</h3>
			</div>
		</div>
		<div class="container-fluid">

			<div class="row pt-4">
				<!-- Screen - for loop starts -->
				<c:forEach items="${screens }" var="screen">
					<div class="col-lg-3">
						<div class="card p-3">
							<div class="card-body">
								<h5 class="card-title">${screen.screenName }</h5>
								<div class="card-text">
									<div class="row">
										<!-- Show for loop starts -->
										<c:forEach items="${screen.getShows() }" var="show">
											<div class="form-check form-check-inline">
												<input class="form-check-input" type="checkbox"
													id="inlineCheckbox1" value="showId">
												<p class="check-margin">${show.showTime }</p>
											</div>
											</c:forEach>
											<!-- Show for loop ends -->
									</div>

								</div>
							</div>
						</div>
					</div>
				</c:forEach>
				<!-- for loop ends -->

			</div>

		</div>
		</div>



	</section>





</body>
</html>