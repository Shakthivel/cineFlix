
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <style>
        body{
            background-image: url("https://res.cloudinary.com/dfep0loer/image/upload/v1638642281/CineFlix/login-bg_oinwnx.jpg");
            
        }
    </style>
    <!-- Title Icon -->
    <link rel="icon" href="https://res.cloudinary.com/dfep0loer/image/upload/v1638639673/CineFlix/favicon_k3r3vp.ico"
        type="image/x-icon">
    <!-- Title -->
    <title>Cineflix - OTP </title>
    <!-- Local Stylesheet -->
    <link rel="stylesheet" type="text/css" href="../resources/css/styles.css"> 
    <!-- Font Awesome CDN -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
        integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
    <!-- Bootstrap CDN -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
        integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
    <div class="d-flex justify-content-center align-items-center login-container">
        <form class="login-form text-center " method="POST" novalidate id="login-form">
            <img src="https://res.cloudinary.com/dfep0loer/image/upload/v1638596050/CineFlix/cineflix-black_nleijx.png" class="img-fluid" alt="...">
            <h2 class="mb-5"> OTP AUTHENICATION</h2>
            <div class="form-group">
                <input type="text" id="otp" name="otp" class="form-control form-control-lg " placeholder="OTP" required>
            </div>
            <button type="submit" class="btn btn-dark btn-block btn-login">Authenicate</button>
            
        </form>
        
    </div>

    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
        crossorigin="anonymous"></script>


</body>
</html>