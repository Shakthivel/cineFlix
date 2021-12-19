<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.SortedSet"%>
<%@page import="java.util.TreeSet"%>
<%@page import="java.sql.Time"%>
<%@page import="com.cineFlix.model.ShowTable"%>
<%@page import="com.cineFlix.model.Screen"%>
<%@page import="com.cineFlix.model.Timings"%>
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
	<form method="POST">
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
						href="/corporate/home">Home</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/corporate/logout">Logout</a></li>
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



											<c:forEach items="${screen.getTimings()}" var="timing">

												<!-- 
										get screen value
										get time value -> showTime
										see if movie is already added in this screen on that timme
										 -->
												<%
										SortedSet<ShowTable> shows = (SortedSet<ShowTable>) ((Screen) (pageContext.findAttribute("screen"))).getShows();
										Timings timing = (Timings)(pageContext.findAttribute("timing"));
										SortedSet<Time> showTimings = new TreeSet<Time>();
										ShowTable show = new ShowTable();
										if(shows!=null)
										{
											for (ShowTable s : shows) {
												if(s.getShowTime().equals(timing.getTiming()) )
												{
													show = s;
													break;
												}
											}
											
										}
										
										request.setAttribute("show", show);
										%>
												<div class="form-check form-check-inline">
													<input class="form-check-input" type="checkbox"
														name="${timing.getId()}"
														<c:if test="${not empty show.movieName }">checked</c:if>
														<c:if test="${(not empty show.movieName) and (movie.movieName ne show.movieName)}">disabled</c:if>
														id="inlineCheckbox1" value="${timing.getTiming()}">
													<p class="check-margin">${timing.getTiming()}</p>
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
				<div class="text-center m-5">
					<button type="submit" class="btn btn-primary btn-lg btn-login"
						style="color: #125D98;" role="button" data-toggle="modal"
						data-target="#exampleModal">Save Details</button>
				</div>
			</div>
			</div>



		</section>


		<script
			src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
			integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
			crossorigin="anonymous"></script>

	</form>
</body>
</html>