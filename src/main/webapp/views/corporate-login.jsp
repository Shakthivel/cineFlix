
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body{
            background-image: url("https://res.cloudinary.com/dfep0loer/image/upload/v1638859672/CineFlix/theatre-night-blur_llk23n.jpg");
            
        }
    </style>
    <!-- Title Icon -->
    <link rel="icon" href="https://res.cloudinary.com/dfep0loer/image/upload/v1638860594/CineFlix/theatre-icon_ostugn.ico"
        type="image/x-icon">
    <!-- Title -->
    <title>Cineflix Corporate - Login </title>
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
        <form class="login-form text-center" method="POST" novalidate>
            <img src="https://res.cloudinary.com/dfep0loer/image/upload/v1638860470/CineFlix/CineFlix-Corporate_ipe7kd.png" class="img-fluid pb-3" alt="...">
 
            <div class="form-group">
                <input type="number" name="id" id="id" class="form-control form-control-lg" placeholder="Corporate Id" required> 
                <div class="valid-feedback">Sounds Great !</div>
                <div class="invalid-feedback">Oh No ! Enter the Corporate Id!</div>
            </div>
            <div class="form-group">
                <input type="password" name="password" id="pass" class="form-control form-control-lg" placeholder="Password" required>
                <div class="valid-feedback">Sounds Great !</div>
                <div class="invalid-feedback">Oh No ! Enter the Password!</div>
            </div>
            <div class="forgot-link form-group d-flex justify-content-between align-items-center">
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="remember">
                    <label class="form-check-label" for="remember">Remember Password</label>
                </div>
                <a href="#" class="form-link">Forgot Password?</a>
            </div>

            <button type="submit"  class="btn btn-dark btn-block btn-login">Login</button>

            <div style="margin-top: 10px;">
                <a href="user-login.html" class="form-link">Not a Corporate User?</a>
            </div>
           
        </form>
        
    </div>

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