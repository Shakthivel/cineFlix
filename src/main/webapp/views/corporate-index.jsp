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
<title>Cineflix Corporate</title>
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
					href="/corporate/login">Logout</a></li>
			</ul>
		</div>
	</nav>

	<!-- Tab Switch Starts -->
	<div class="pt-3">


		<ul class="nav nav-tabs justify-content-center" id="myTab"
			role="tablist">
			<li class="nav-item" role="presentation"><a
				class="nav-link " id="home-tab" data-toggle="tab"
				href="#all-movies" role="tab" aria-controls="home"
				aria-selected="true">All Movies</a></li>
			<li class="nav-item" role="presentation"><a class="nav-link"
				id="profile-tab" data-toggle="tab" href="#acquired-movies" role="tab"
				aria-controls="profile" aria-selected="false">Our Movies</a></li>
		</ul>
		<div class="tab-content" id="myTabContent">
			
			<div class="tab-pane fade show active" id="all-movies"
				role="tabpanel" aria-labelledby="home-tab">

				<div class="row card-deck-spacing">

					<c:forEach items="${movies}" var="movie">
						<div class="col-lg-4 d-flex align-items-stretch">
							<div class="card">
								<img src="${movie.imageUrl}" class="card-img-top"
									alt="${movie.movieName}">
								<div class="card-body">
									<div class="card-title">${movie.movieName.toUpperCase()}</div>
									<div class="badge-div">
										<span class="badge badge-pill badge-info">${movie.censor.toUpperCase()}</span>
										<span class="badge badge-pill badge-secondary">${movie.genre.toUpperCase()}</span>
										<span class="badge badge-pill badge-primary">${movie.language.toUpperCase()}</span>
									</div>
									<div class="card-text">${movie.movieSynopsis}</div>
								</div>
								<div class="card-footer">
									<a class="btn btn-dark btn-block btn-login"
										style="color: #125D98;" href="" role="button">Add</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="tab-pane fade show active" id="acquired-movies"
				role="tabpanel" aria-labelledby="home-tab">

				<div class="row card-deck-spacing">
				<c:forEach items="${acquiredMovies}" var="movie">
						<div class="col-lg-4 d-flex align-items-stretch">
							<div class="card">
								<img src="${movie.imageUrl}" class="card-img-top"
									alt="${movie.movieName}">
								<div class="card-body">
									<div class="card-title">${movie.movieName.toUpperCase()}</div>
									<div class="badge-div">
										<span class="badge badge-pill badge-info">${movie.censor.toUpperCase()}</span>
										<span class="badge badge-pill badge-secondary">${movie.genre.toUpperCase()}</span>
										<span class="badge badge-pill badge-primary">${movie.language.toUpperCase()}</span>
									</div>
									<div class="card-text">${movie.movieSynopsis}</div>
								</div>
								<div class="card-footer">
									<a class="btn btn-dark btn-block btn-login"
										style="color: #125D98;" href="" role="button">Edit</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>

		<script
			src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
			integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
			crossorigin="anonymous"></script>

</body>
</html>