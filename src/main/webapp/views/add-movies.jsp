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
        <link rel="icon" href="https://res.cloudinary.com/dfep0loer/image/upload/v1638813013/CineFlix/favicon_bhytgt.ico"
            type="image/x-icon">
        <!-- Title -->
        <title>CineFlix Admin - Add Movies</title>
        <!-- Local Stylesheet -->
        <link rel="stylesheet" type="text/css" href="../resources/css/admin-styles.css">
        <!-- Font Awesome CDN -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
            integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
        <!-- Bootstrap CDN -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
            integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

   
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #125D98;">
        <a class="navbar-brand" href="#"><img
                src="https://res.cloudinary.com/dfep0loer/image/upload/v1638775333/CineFlix/CineFlixAdmin_asr8e0.png"
                alt=""></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav" style="margin-left: 83%;">
                <li class="nav-item">
                    <a class="nav-link" href="/admin/home">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/login">Logout</a>
                </li>
            </ul>
        </div>
    </nav>

    <!-- Start of Form -->
    <section id="movie-form">
        <div class="container-fluid">
            <div style="padding: 2rem;">
                <h1>Add Movies</h1>
            </div>

            <form:form method="POST" modelAttribute="movie">
                <div class="form-row">
                    <div class="col">
                        <h5>Movie Name</h5>
                        <form:input path="movieName" type="text" class="form-style"/>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <h5>Censor Rating</h5>
                            <form:select path="censor" class="form-style" id="exampleFormControlSelect1">   
     					<form:option value="u" label="U"/>
                        <form:option value="ua" label="U/A"/>
                        <form:option value="a" label="A"/>
                        <form:option value="r" label="R"/>
                        
					</form:select> 
                        </div>
                    </div>
                </div>
    
                <div class="form-row">
                    <div class="col">
                    <h5>Release Date</h5>
                    <form:input path="releaseDate" type="date" class="form-style"/>
                    </div>
                    <div class="col">
                    <h5>Genre</h5>
                   <form:select path="genre" class="form-style" id="exampleFormControlSelect1">   
     					<form:option value="drama" label="Drama"/>
                        <form:option value="action" label="Action"/>
                        <form:option value="animation" label="Animation"/>
                        <form:option value="anime" label="Anime"/>
                        <form:option value="thriller" label="Thriller"/>
                        <form:option value="comedy" label="Comedy"/>
                        <form:option value="romance" label="Romance"/>
                        <form:option value="horror" label="Horror"/>
					</form:select> 
                    
                   
                    </div>
                </div>
        <div class="form-row">
                    <div class="col">
                        <h5>Language</h5>
                        <form:select path="language" class="form-style" id="exampleFormControlSelect1" >
                            <form:option value="english">English</form:option>
                            <form:option value="tamil">Tamil</form:option>
                            <form:option value="telugu">Telugu</form:option>
                            <form:option value="malayalam">Malayalam</form:option>
                            <form:option value="kannada">Kannada</form:option>
                            <form:option value="hindi">Hindi</form:option>
                            <form:option value="marathi">Marathi</form:option>
                            <form:option value="bengali" label="Bengali" />
                            <form:option value="japanese" label="Japanese"/>
                            <form:option value="korean" label="Korean"/>
                        </form:select>
                    </div>
                    <div class="col">
                            <div class="form-group">
                                <h5>Movie Poster Url</h5>
                                 <form:input path="imageUrl" type="text" class="form-style"/>
                            </div>
                        </div>
                 </div>   
                
            
                    <div class="form-row">
                        
                        <div class="col">
                            <div class="form-group">
                                <h5>Synopsis</h5>
                                <form:input path="movieSynopsis" type="text" class="form-style"/>
                            </div>
                        </div>
                    </div>
                     <div class="text-center m-2">
                   		 <button type="submit" class="btn btn-primary btn-lg btn-login" style="color: #125D98;"  role="button" data-toggle="modal" data-target="#exampleModal">Save Details</button>
                	</div>
                </form:form>
<!-- Form Ending -->
               

                <!-- Profile Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header" style="background-color: #125D98; border-color: #125D98; color: #fff;">
                                <h4 class="modal-title" id="exampleModalLabel">Confirm new Movie</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="color: #fff;">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div class="text-center">
                                                    <img src="https://res.cloudinary.com/dfep0loer/image/upload/v1638627653/CineFlix/Coming%20Soon%20Images/batman-soon_s4llso.jpg"
                                                        class="card-img-top img-fluid" alt="...">
                                </div>
                
                                <div class="text-center p-4 align-items-center">
                                    <h3>The Batman - (A)</h3>

                                   
                                </div>

                                <div class="d-flex justify-content-center">
                                    <ul class="list-group list-group-horizontal">
                                        <li class="list-group-item">04/04/2022</li>
                                        <li class="list-group-item">IMAX 3D</li>
                                        <li class="list-group-item">Action</li>
                                        <li class="list-group-item">English</li>
                                    </ul>

                                    
                                </div>
                                
                                <div class="text-center pt-2">
                                    THE BATMAN is an edgy, action-packed thriller that depicts Batman in his early years,
                                    struggling to balance rage with
                                    righteousness as he investigates a disturbing mystery that has terrorized Gotham. Robert Pattinson
                                    delivers a raw,
                                    intense portrayal of Batman as a disillusioned, desperate vigilante awakened by the realization that the
                                    anger consuming
                                    him makes him no better than the ruthless serial killer he’s hunting.
                                </div>
                           
                            </div>
                            <div class="d-flex justify-content-center">

                                <div class="modal-footer">
                                    <a class="btn btn-outline-info" href="edit-profile.html" role="button" data-dismiss="modal">Edit</a>
                                    <a class="btn btn-outline-warning" href="admin-index.html" role="button">Confirm</a>
                                </div>
                            </div>
                            
                        </div>
                    </div>
                </div>
        </div>
    </section>


    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
        crossorigin="anonymous"></script>
</body>
</html>