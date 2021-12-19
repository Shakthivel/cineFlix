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
<body>
<div class="d-flex justify-content-center align-items-center " style="width: 100%; height: 90vh;">
    <div class=" text-center ">
       
   	<%
   	String userRole =(String) pageContext.findAttribute("userRole");
   	String redirectUrl ="/"+userRole+"/login";
   	request.setAttribute("redirectUrl", redirectUrl);
   	%>
        
            <img src="https://res.cloudinary.com/dfep0loer/image/upload/v1639766505/CineFlix/icons8-error-cloud_xongqq.gif" class="img-fluid p-4" width="400px" height="400px">
        
        
            <h2>You don't seem to have access to the page! Please <a href="${redirectUrl }">Login</a> !</h2>
        
    </div>

    </div>

</div>
</body>
</html>