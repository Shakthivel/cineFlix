
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <script type="text/javascript">
        var uname = document.getElementById('uname');
        var pass = document.getElementById('pass');
    </script>

    <style>
        body{
            background-image: url("https://res.cloudinary.com/dfep0loer/image/upload/v1638642281/CineFlix/login-bg_oinwnx.jpg");
            
        }
    </style>
    <!-- Title Icon -->
    <link rel="icon" href="https://res.cloudinary.com/dfep0loer/image/upload/v1638639673/CineFlix/favicon_k3r3vp.ico"
        type="image/x-icon">
    <!-- Title -->
    <title>Cineflix - Login </title>
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
            <h2 class="mb-5"> Login</h2>
            <div class="form-group">
                <input type="text" id="uname" name="name" class="form-control form-control-lg " placeholder="Username" required> <div class="valid-feedback">Sounds Great !</div><div class="invalid-feedback">Oh No ! Enter a Value!</div>
            </div>
            
            <div class="form-group">
                <input type="password" id="pass" name="password" class="form-control form-control-lg" placeholder="Password" required> <div class="valid-feedback">Sounds Great !</div><div class="invalid-feedback">Oh No ! Enter the Password!</div>
            </div>
            <div class="forgot-link form-group d-flex justify-content-between align-items-center">
                <a href="#" class="form-link">Forgot Password?</a>
            </div>
            <button type="submit" class="btn btn-dark btn-block btn-login">Login</button>
            <div style="margin-top: 10px;">
                <a href="/user/register" class="form-link" >Not an user? Register</a>
            </div>

            <div style="margin-top: 10px;">
                <a href="/corporate/login" class="form-link">Corporate User</a>
            </div>

        </form>
        
    </div>

    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
        crossorigin="anonymous"></script>


<script type="text/javascript">
    (function () {
        "use strict";
        window.addEventListener("load", function () {
            let forms = document.getElementsByTagName("form");
            var validation = Array.prototype.filter.call(forms, function (form) {
                form.addEventListener("submit", function (event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add("was-validated");
                }, false);
            });
        }, false);
    })
        ();
</script>
</body>
</html>