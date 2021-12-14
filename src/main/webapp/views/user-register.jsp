<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body {
            background-image: url("https://res.cloudinary.com/dfep0loer/image/upload/v1638642281/CineFlix/login-bg_oinwnx.jpg");

        }
    </style>
    <!-- Title Icon -->
    <link rel="icon" href="https://res.cloudinary.com/dfep0loer/image/upload/v1638680466/CineFlix/favicon_hgobuv.ico"
        type="image/x-icon">
    <!-- Title -->
    <title>Cineflix - Signup</title>
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
        <form:form class="login-form text-center" method="POST" modelAttribute="user" >

            <img src="https://res.cloudinary.com/dfep0loer/image/upload/v1638596050/CineFlix/cineflix-black_nleijx.png"
                class="img-fluid" alt="...">
            <h2 class="mb-5"> Register</h2>

            <!-- Fullname & Address -->
            <div class="form-row">
                <div class="col">
                    <div class="form-group">
                        <form:input type="text" path="name" required="required" class="form-control form-control-lg" placeholder="Fullname" />
                    	<form:errors path="name"/>
                    </div>
                </div>
                <div class="col">
                    <div class="form-group">
                        <form:input type="text" path="address" required="required" class="form-control form-control-lg" placeholder="City"/>
                    	<form:errors path="address"/>
                    </div>
                </div>
            </div>
       
            <!-- Email Id & Phone Number -->
            <div class="form-row">
                <div class="col">
                    <div class="form-group">
                        <form:input type="email" path="email" required="required" class="form-control form-control-lg" placeholder="Email id"/>
                    </div>
                </div>
                <div class="col">
                    <div class="form-group">
                        <form:input type="tel" path="number" required="required" class="form-control form-control-lg" placeholder="Phone Number"/>
                    </div>
                </div>
            </div>
            
            <div class="form-row">
                <div class="col">
                    <div class="form-group">
                        <form:input type="password" path="password" required="required" id="password" class="form-control form-control-lg" placeholder="Password"/>
                    </div>
                </div>
                <div class="col">
                    <div class="form-group">
                        <form:input id="confirm-password" path="" required="required" type="password" class="form-control form-control-lg" placeholder="Confirm Password"/>
                    </div>
                </div>
            </div>
       
       
       
       
            <div class="forgot-link form-group d-flex justify-content-between align-items-center">
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="remember">
                    <label class="form-check-label" for="remember">Remember Password</label>
                </div>
               
            </div>
            <button type="submit" class="btn btn-dark btn-block btn-login" >Register</button>
            <div style="margin-top: 10px;">
                <a href="/user/login" class="form-link">Already an user? Login</a>
            </div>
        </form:form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
        crossorigin="anonymous"></script>
    
    <script type="text/javascript">
        
    </script>
</body>

</html>