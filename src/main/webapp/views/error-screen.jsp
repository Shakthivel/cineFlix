<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- Title Icon -->
    <link rel="icon" href="https://res.cloudinary.com/dfep0loer/image/upload/v1639764373/CineFlix/favicon_mbfvbz.ico"
        type="image/x-icon">
    <!-- Title -->
    <title>Error! CineFlix</title>
    <!-- Local Stylesheet -->
    <link rel="stylesheet" type="text/css" href="../resources/css/styles.css">
    <!-- Font Awesome CDN -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
        integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
    <!-- Bootstrap CDN -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
        integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body style="background-color: #125D98;">
<div class="d-flex justify-content-center align-items-center " style="width: 100%; height: 90vh;">
    <div class=" text-center ">
       
   	<%
   	String userRole =(String) pageContext.findAttribute("userRole");
   	String redirectUrl ="/"+userRole+"/login";
   	request.setAttribute("redirectUrl", redirectUrl);
   	%>
        
            <h1 class="h1cine"><span style="font-weight: 800;">Cine</span>Flix</h1>
            <img src="https://res.cloudinary.com/dfep0loer/image/upload/v1639940536/CineFlix/404-error_grqmy5.png" class="img-fluid m-5" width="150px" height="150px">
    
        
        
            <h2 style="color: #fff;">You don't seem to have access to the page! Please Login!</h2>
        
        <a class="btn btn-info pr-5 pl-5 mt-2" href="${redirectUrl }" role="button">Login</a>
    </div>

    </div>

</div>
</body>
</html>