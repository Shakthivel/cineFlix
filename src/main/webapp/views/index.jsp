<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Title Icon -->
    <link rel="icon" href="https://res.cloudinary.com/dfep0loer/image/upload/v1638545823/CineFlix/favicon_trcikr.ico" type="image/x-icon">
    <!-- Title -->
    <title>CineFlix - Never Miss A Premiere!</title>
    <link rel="stylesheet" type="text/css" href="../../resources/public/css/styles.css">
    <!-- Bootstrap CDN -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
    <!-- Navbar Section -->
    <section id="nav">
        <!-- Start Of Navbar -->
        <nav class="navbar navbar-expand-lg navbar-dark " style="background-color: #125D98;">
            <!-- Navbar Brand -->
            <a class="navbar-brand" href="#"><img src="https://res.cloudinary.com/dfep0loer/image/upload/v1638597797/CineFlix/cineflix-white_od5kft.png" alt=""></a>
            <!-- Navbar Toggle Action -->
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <!-- Collapse Section Navbar -->
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="#nowShowing">Now Showing</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Coming Soon</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Account</a>
                    </li>
                    <!-- Location Dropdown -->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-expanded="false">
                           Location
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="#">Chennai</a>
                            <a class="dropdown-item" href="#">Bangalore</a>
                            <a class="dropdown-item" href="#">Kochi</a>
                            <a class="dropdown-item" href="#">Mumbai</a>
                            <a class="dropdown-item" href="#">Kolkata</a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
    </section>
<!-- End of The Nav Section -->

<!-- Start of Carousel Section -->
    <section id="carousel">
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
                <!--Carousel Items-->
                <div class="carousel-item active">
                    <img src="https://res.cloudinary.com/dfep0loer/image/upload/v1638600006/CineFlix/Carousel%20Images/spiderman-carousel_qvo713.jpg" class="d-block w-100" width="500px" height="545px">
                </div>
                <div class="carousel-item">
                    <img src="https://res.cloudinary.com/dfep0loer/image/upload/v1638599862/CineFlix/Carousel%20Images/re-carousel_irds4a.jpg" class="d-block w-100" width="500px" height="545px">
                </div>
                <div class="carousel-item">
                    <img src="https://res.cloudinary.com/dfep0loer/image/upload/v1638599631/CineFlix/Carousel%20Images/mha-carousel_cmkn6o.jpg" class="d-block w-100" width="500px" height="545px">
                </div>
                <div class="carousel-item">
                    <img src="https://res.cloudinary.com/dfep0loer/image/upload/v1638600852/CineFlix/Carousel%20Images/kurup-carousel_qumjyt.jpg" class="d-block w-100" width="500px" height="545px">
                </div>
                <div class="carousel-item">
                    <img src="https://res.cloudinary.com/dfep0loer/image/upload/v1638600852/CineFlix/Carousel%20Images/maanadu-carousel_linzbg.jpg" class="d-block w-100" width="500px" height="545px">
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </section>
<!-- End of the Carousel Section -->

<!-- Start of Now Showing Section -->
    <section id="nowShowing">
        <div class="container-fluid" style="padding-top: 2rem;">
            <div class="container-nowShow">
                <h1>Now Showing</h1>
                <div class="card-deck" style="padding: 2rem;">
                    <div class="card">
                        <img src="https://res.cloudinary.com/dfep0loer/image/upload/v1638603265/CineFlix/Now%20Showing%20Images/maanadu-now_ztvu1i.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h6 class="card-title">MAANAADU</h6>
                            <div class="badge-div">
                                <span class="badge badge-pill badge-info">U/A</span>
                                <span class="badge badge-pill badge-secondary">Drama</span>
                                <span class="badge badge-pill badge-primary">Tamil</span>
                            </div>
                            
                            <p class="card-text">On the day of a public conference by the state's Chief Minister, his bodyguard and a police officer become stuck in a
                            time loop.</p>
                        </div>
                    </div>
                    <div class="card">
                        <img src="https://res.cloudinary.com/dfep0loer/image/upload/v1638604637/CineFlix/Now%20Showing%20Images/re-now_cqvsgq.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h6 class="card-title">RESIDENT EVIL WELCOME TO RACCOON CITY</h6>
                            <div class="badge-div">
                                <span class="badge badge-pill badge-info">A</span>
                                <span class="badge badge-pill badge-secondary">Horror</span>
                                <span class="badge badge-pill badge-primary">English</span>
                            </div>
                            <p class="card-text">Welcome to Raccoon City, once the booming home of pharmaceutical giant Umbrella Corp. The company's exodus left the city
                            a wasteland, a dying town with great evil brewing below the surface. When that evil is unleashed, a group of survivors
                            must work together to uncover the truth behind Umbrella and make it through the night.</p>
                        </div>
                    </div>
                    <div class="card">
                        <img src="https://res.cloudinary.com/dfep0loer/image/upload/v1638604471/CineFlix/Now%20Showing%20Images/i02_mha-now_ifvu0d.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h6 class="card-title">MY HERO ACADEMIA WORLD HEROES MISSION</h6>
                            <div class="badge-div">
                                <span class="badge badge-pill badge-info">U</span>
                                <span class="badge badge-pill badge-secondary">Anime</span>
                                <span class="badge badge-pill badge-primary">Japanese</span>
                            </div>
                            <p class="card-text">When a terrorist organization threatens to wipe out the superhuman society, the fate of the world hangs in the balance
                            of the future heroes. Within hours until the collapse of civilization, Deku, Bakugo, and Todoroki must work as a team,
                            but there is one problem: Deku's on the run for murder</p>
                        </div>
                    </div>
                </div>
            </div> 
        </div>
    </section>
<!-- End of Now Showing Section -->

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
</body>
</html>