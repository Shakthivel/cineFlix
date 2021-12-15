<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.cineFlix.model.Movie"%>
<%@ page import="com.cineFlix.model.Theatre"%>
<%@ page import="java.util.SortedSet"%>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.Month" %>
<%@ page import="java.time.DayOfWeek" %>
<%@ page import="java.time.temporal.ChronoUnit" %>
<%@ page import="java.util.Locale" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Title Icon -->
<link rel="icon"
	href="https://res.cloudinary.com/dfep0loer/image/upload/v1638545823/CineFlix/favicon_trcikr.ico"
	type="image/x-icon">
<!-- Title -->
<title>${movie.getMovieName().toUpperCase() }
	(${movie.getCensor().toUpperCase() })
	(${movie.getLanguage().toUpperCase() })</title>
<!-- Local Stylesheet -->
<link rel="stylesheet" type="text/css"
	href="../resources/css/styles.css">
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
	<!-- Navbar Section -->
	<section id="nav">
		<!-- Start Of Navbar -->
		<nav class="navbar navbar-expand-lg navbar-dark "
			style="background-color: #125D98;">
			<!-- Navbar Brand -->
			<a class="navbar-brand" href="#"><img
				src="https://res.cloudinary.com/dfep0loer/image/upload/v1638597797/CineFlix/cineflix-white_od5kft.png"
				alt=""></a>
			<!-- Navbar Toggle Action -->
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<!-- Collapse Section Navbar -->
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="#now-showing">Now
							Showing</a></li>
					<li class="nav-item"><a class="nav-link" href="#coming-soon">Coming
							Soon</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
						aria-expanded="false">Account</a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="#" data-toggle="modal"
								data-target="#exampleModal"><i class="fas fa-user-circle"></i>
								View Profile</a> <a class="dropdown-item" href="/user/login"><i
								class="fas fa-sign-out-alt"></i> Logout</a>
						</div> <!-- Profile Modal -->
						<div class="modal fade" id="exampleModal" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header"
										style="background-color: #125D98; border-color: #125D98; color: #fff;">
										<h4 class="modal-title" id="exampleModalLabel">Profile</h4>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close" style="color: #fff;">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
										<div class="text-center">
											<img
												src="https://res.cloudinary.com/dfep0loer/image/upload/v1638693566/CineFlix/Hirotaka_vkfdcx.jpg"
												alt="" class="img-fluid">
										</div>

										<div class="text-center p-4">
											<h3>Hirotaka Nifuji</h3>
										</div>

										<ul class="list-group pl-3 pr-3">
											<li class="list-group-item"><i
												class="fas fa-phone-alt pr-1"></i> <span class="span-bold">Phone</span>
												: 9940123423</li>
											<li class="list-group-item"><i
												class="fas fa-envelope pr-1"></i> <span class="span-bold">E-Mail</span>
												: hirotaka@presidio.com</li>
											<li class="list-group-item"><i
												class="fas fa-location-arrow pr-1"></i> <span
												class="span-bold">Home Location</span> : Chennai</li>
										</ul>
									</div>
									<div class="modal-footer">
										<a class="btn btn-primary btn-cineflex"
											href="edit-profile.html" role="button">Edit Profile</a> <a
											class="btn btn-warning btn-bookings" href="bookings.html"
											role="button">Your Bookings</a>
									</div>
								</div>
							</div>
						</div> <!-- Location Dropdown -->
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
						aria-expanded="false"> Location </a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="#"><img
								src="https://img.icons8.com/office/16/000000/tsunami.png" />
								Chennai</a> <a class="dropdown-item" href="#"><img
								src="https://img.icons8.com/office/16/000000/home-office.png" />
								Bangalore</a> <a class="dropdown-item" href="#"><img
								src="https://img.icons8.com/office/16/000000/kite.png" /> Kochi</a>
							<a class="dropdown-item" href="#"><img
								src="https://img.icons8.com/office/16/000000/skyscrapers.png" />
								Mumbai</a> <a class="dropdown-item" href="#"><img
								src="https://img.icons8.com/office/16/000000/bridge.png" />
								Kolkata</a>
						</div></li>
				</ul>
			</div>
		</nav>

	</section>
	<!-- End of The Nav Section -->
	<%
	Movie m = (Movie) pageContext.findAttribute("movie");
	SortedSet<Theatre> theatres = m.getTheatre();
	request.setAttribute("theatres", theatres);
	%>
	<section id="movie-info">
		<div class=""
			style="background-color: rgb(248, 248, 248); box-shadow: 0 10px 12px -3px rgba(0, 0, 0, 0.1);">
			<div class="p-4">
				<h3>${movie.getMovieName().toUpperCase() }
					(${movie.getCensor().toUpperCase() })
					(${movie.getLanguage().toUpperCase() })</h3>
			</div>
		</div>
		<%
		
		%>
		<div class="mt-3 p-5">
			<ul class="nav nav-pills mb-3 ml-4 justify-content-center"
				id="pills-tab" role="tablist">
				
				<%
				LocalDate today = LocalDate.now();
				int month = today.getMonthValue();
				%>
				
				<c:forEach begin="0" end="6" var="days" varStatus="status">
				<%
					int days = (int)(pageContext.findAttribute("days"));
					request.setAttribute("today","id"+today.toString().replace("-", "_"));
					%>
				<c:if test="${status.first}">
				<li class="nav-item" role="presentation"><a
					class="nav-link active pill-a" id="${today }-tab" 
					href="#${today}" role="tab" aria-controls="pills-home" data-toggle="pill"
					aria-selected="true"> <%out.print(Month.of(month).name().substring(0,3)+" "+today.getDayOfMonth()); %>
					<span class="pill-span"><% 
							DayOfWeek dow = today.getDayOfWeek();
							out.println(dow); %></span>
				</a></li>
				</c:if>
				<c:if test="${not status.first}">
				<li class="nav-item" role="presentation"><a
					class="nav-link pill-a" id="${today }-tab" data-toggle="pill"
					href="#${today}"  role="tab" aria-controls="pills-home"
					aria-selected="true"> <%out.print(Month.of(month).name().substring(0,3)+" "+today.getDayOfMonth()); %>
					<span class="pill-span"><% 
							DayOfWeek dow = today.getDayOfWeek();
							out.println(dow); %></span>
				</a></li>
				</c:if>
				<%
				today = today.plus(1,ChronoUnit.DAYS); %>
				</c:forEach>
			</ul>
			
			<div class="tab-content" id="pills-tabContent">
			
			<%today = LocalDate.now(); 
			%>
			
			<c:forEach begin="0" end="6" var="days" varStatus="status">
			<% request.setAttribute("today", "id"+today.toString().replace("-", "_")); %>
			<c:if test="${status.first}">
				<div class="tab-pane fade show active" id="${today}" role="tabpanel"
					>
					<ul class="list-group">
						<c:forEach items="${theatres }" var="theatre">
							<li class="list-group-item">
								<h4>${theatre.getTheatreName() }</h4> 
								<c:forEach items="${theatre.getScreens() }" var="screen">
									<c:forEach items="${screen.getShows() }" var="show">
									<c:if test="${show.getMovieName() == movie.getMovieName() }">
										<a class="btn btn-book"  href="screen-${screen.getId()}-date-${today.substring(2)}-seats" onclick=setDate() role="button">
											<span class="tips">${show.getShowTime() }
												<span class="tips-text">
													${screen.getScreenName() }
													<span class="pill-span">Budget : Rs. 60</span> 
													<span class="pill-span">Elite : Rs. 190</span>
												</span>
											</span> 
										</a>
										</c:if>
									</c:forEach>
								</c:forEach>
							</li>
						</c:forEach>

					</ul>
				</div>
				</c:if>
				<c:if test="${not status.first}">
				<div class="tab-pane fade show " id="${today}" role="tabpanel"
					>
					<ul class="list-group">
						<c:forEach items="${theatres }" var="theatre">
							<li class="list-group-item">
								<h4>${theatre.getTheatreName() }</h4> 
								<c:forEach items="${theatre.getScreens() }" var="screen">
									<c:forEach items="${screen.getShows() }" var="show">
									<c:if test="${show.getMovieName() == movie.getMovieName() }">
										<a class="btn btn-book"  href="screen-${screen.getId()}-date_${today}_seats"  onclick=setDate role="button">
											<span class="tips">${show.getShowTime() }
												<span class="tips-text">
													${screen.getScreenName() }
													<span class="pill-span">Budget : Rs. 60</span> 
													<span class="pill-span">Elite : Rs. 190</span>
												</span>
											</span> 
										</a>
										</c:if>
									</c:forEach>
								</c:forEach>
							</li>
						</c:forEach>

					</ul>
				</div>
				</c:if>
				<%
				today = today.plus(1,ChronoUnit.DAYS); %>
				</c:forEach>
				
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

</body>
</html>