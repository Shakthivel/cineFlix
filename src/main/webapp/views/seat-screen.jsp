<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.cineFlix.model.ShowTable"%>
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
<title>CineFlix - Maanadu (U) (Tamil)</title>
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

		<div class="container-fluid"></div>
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
				<ul class="navbar-nav" style="margin-left: 80%;">
					<li class="nav-item"><a class="nav-link" href="/"> Home</a></li>

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
											class="btn btn-warning btn-bookings" href="history.html"
											role="button">Booking History</a>
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

	<section id="movie-info">
		<div class="container-fluid">
			<div class=""
				style="background-color: rgb(248, 248, 248); box-shadow: 0 10px 12px -3px rgba(0, 0, 0, 0.1);">
				<div class="p-4">
					<h3>${show.getMovieName() }</h3>
				</div>
			</div>
		</div>

	</section>

	<section class="seat-selection ">
		<div class="">
			<ul class="showcase">
				<li>
					<div class="available-seat seats"
						style="cursor: default; transform: scale(1); background-color: #fff;"></div>
					<p>Available</p>
				</li>
				<li>
					<div class="selected-seat seats"
						style="cursor: default; transform: scale(1);"></div>
					<p>Selected</p>
				</li>
				<li>
					<div class="sold-seat seats"></div>
					<p>Sold</p>
				</li>
			</ul>
			<form method="POST" name="myForm" id="myForm">
				<input type="hidden" name="formValue" id="seatNumbers" value="" />
				<div class="seat-container">
					<div class="screen"></div>

					<c:forEach begin="1" end="${screen.getTotalRows() }" var="row">
						<div class="seat-rows">
							<!-- for loop rows -->

							<div class="row-name">&\#${(row+64)}</div>
							<!-- for loop columns -->
							<c:forEach begin="1" end="${screen.getTotalColumns() }"
								var="column">
								<%
								char row = (char) (((int) (pageContext.findAttribute("row"))) + 64);
								ShowTable show = (ShowTable) pageContext.findAttribute("show");
								String column = String.valueOf(pageContext.findAttribute("column"));
								String id = (row + "_" + column);
								boolean sold = false;
								if(show.getSeats()!=null)
									sold = (show.getSeats().contains(id.replace("_", "")));
								request.setAttribute("id", id);
								%>

								<div class=" <%if(sold){out.println("sold-seat");	}%> seats "
									id="${id}"
									onclick="<%if(!sold){out.println("makeSelected(this)");	}%>"></div>
							</c:forEach>

							<!-- for loop columns -->

						</div>
					</c:forEach>
					<!-- for loop rows -->
				</div>
			</form>
		</div>

		<div class="ticket-container">
			<h6 style="display: inline;" id="seatNumber">Seats :</h6>
			<a class="mb-1" style="margin-left: 7rem; color: #fff;"
				onClick=submitForm()><i
				class="fas fa-lg fa-arrow-right book-arrow"></i></a>


		</div>

		</div>
	</section>

	<script type="text/javascript">
		function makeSelected(obj) {
			var seats = document.getElementById("seatNumber");
			var selectedSeat="";
			obj.id.split("_").forEach((index)=>{
				selectedSeat+=index;
			});
			var alreadySelectedSeats = seats.innerHTML;
			if(alreadySelectedSeats.includes(selectedSeat))
				{
				alreadySelectedSeats = alreadySelectedSeats.replace(selectedSeat+",","");
				}
			else{
				alreadySelectedSeats = alreadySelectedSeats+selectedSeat+",";
			}
			seats.innerHTML = alreadySelectedSeats;
			obj.classList.toggle("selected-seat");
		}
		function submitForm()
		{
			var seats = document.getElementById("seatNumber");
			var formValue = seats.innerHTML.replace("Seats :","");
			document.forms['myForm']['formValue'].value = formValue;
			console.log(formValue);
			document.getElementById("myForm").submit();
		}
	</script>


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