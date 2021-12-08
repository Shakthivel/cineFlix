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
	href="https://res.cloudinary.com/dfep0loer/image/upload/v1638813013/CineFlix/favicon_bhytgt.ico"
	type="image/x-icon">
<!-- Title -->
<title>CineFlix Admin Panel</title>
<!-- Local Stylesheet -->
<link rel="stylesheet" type="text/css"
	href="../resources/css/admin-styles.css">
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
			src="https://res.cloudinary.com/dfep0loer/image/upload/v1638775333/CineFlix/CineFlixAdmin_asr8e0.png"
			alt=""></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="/admin/login">Logout</a>
				</li>
			</ul>
		</div>
	</nav>

	<section id="movie-cards">
		<div class="container-fluid">
			<div style="padding: 2rem;">
				<h1>List of Movies</h1>
			</div>
			<!-- Start of Deck 1 -->
			<!-- For loop len(list)%3 -->
			<div class="row card-deck-spacing">
				<!-- For loop : 3 times-->	
				<c:forEach items="${movies}" var="movie">
					<div class="col-lg-4 p-3 d-flex align-items-stretch">
						<div class="card">
							<img src="${movie.imageUrl}" class="card-img-top">
							<div class="card-body">
								<h6 class="card-title">${movie.movieName.toUpperCase()}</h6>
								<div class="badge-div">
									<span class="badge badge-pill badge-info">${movie.censor.toUpperCase()}</span>
									<span class="badge badge-pill badge-secondary">${movie.genre.toUpperCase()}</span>
									<span class="badge badge-pill badge-primary">${movie.language.toUpperCase()}</span>
								</div>

								<p class="card-text">${movie.movieSynopsis}</p>
							</div>
							<div class="card-footer">
								<a class="btn btn-dark btn-block btn-login"
									style="color: #125D98;"
									href="/admin/edit-${movie.movieId}-movie" role="button">Edit</a>
							</div>

						</div>
					</div>
				</c:forEach>

				<!-- For loop : 3 times-->
			</div>
			<!-- For loop len(list)%3 -->
			<!-- End of Deck 1 -->
		</div>
		<a class="btn btn-primary btn-float shadow float-right "
			href="/admin/add-movie" role="button">+ </a>
	</section>
</body>
</html>