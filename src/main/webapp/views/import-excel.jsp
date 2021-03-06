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
    <title>CineFlix Admin - Import Excel</title>
    <!-- Local Stylesheet -->
    <link rel="stylesheet" type="text/css" href="../resources/css/admin-styles.css">
    <!-- Font Awesome CDN -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
        integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
    <!-- Bootstrap CDN -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
        integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    </head>
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
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="/admin/login">Logout</a>
                </li>
            </ul>
        </div>
    </nav>


    <div class="container-fluid">
        <div style="padding-top: 2rem; padding-bottom: 2rem;">
            <h1>Upload Movies with a Excel File</h1>
        </div>

        <form action="/admin/import" method="post"
		enctype="multipart/form-data">
        
            <div class="form-group p-3">
               
                        <h2 style=" padding-bottom:1rem;">Upload Your Excel File</h2>
                        <input type="file" name="file" class="form-control-file" id="exampleFormControlFile1">
                        <input type="submit" class="mt-3 btn-login btn" style="color: #125D98;" value="Import">
                        <!-- Button trigger modal -->
                        
                        
                        <!-- Modal -->
                        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Note</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-login" data-dismiss="modal">Close</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    
               </div>
        </form>

        <div class="p-3">
            <h2 style=" padding-bottom:1rem;">Note</h2>
            <h4 style="padding-bottom: 1rem;">Format of the Uploading Excel</h4>
            
            <table class="table">
                <thead class="thead-light">
                    <tr>
                        <th scope="col">Movie name</th>
                        <th scope="col">Release date</th>
                        <th scope="col">Censor Rating</th>
                        <th scope="col">Genre</th>
                        <th scope="col">Language</th>
                        <th scope="col">Synopsis</th>
                        <th scope="col">Poster Link</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                       
                        <td>The Batman</td>
                        <td>04-03-2022</td>
                        <td>A</td>
                        <td>Action</td>
                        <td>English</td>
                        <td>I'm Vengance</td>
                        <td>Batman Poster</td>
                        
                    </tr>
                    
                   
                </tbody>
            </table>
        </div>
       
      

    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
        crossorigin="anonymous"></script>
</body>
</html>