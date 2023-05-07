<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 3/31/2023
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Places &mdash; Free HTML5 Bootstrap 4 Theme by uicookies.com</title>
    <meta name="description" content="Free Bootstrap 4 Theme by uicookies.com">
    <meta name="keywords"
          content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">


    <link href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,700" rel="stylesheet">

    <link rel="stylesheet" href="assets/css/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="assets/css/animate.css">
    <link rel="stylesheet" href="assets/fonts/ionicons/css/ionicons.min.css">

    <link rel="stylesheet" href="assets/css/owl.carousel.min.css">

    <link rel="stylesheet" href="assets/fonts/flaticon/font/flaticon.css">

    <link rel="stylesheet" href="assets/fonts/fontawesome/css/font-awesome.min.css">

    <link rel="stylesheet" href="assets/css/select2.css">


    <link rel="stylesheet" href="assets/css/helpers.css">
    <link rel="stylesheet" href="assets/css/style.css">

</head>

<body>

<style>
    * {
        scroll-behavior: smooth;
    }
</style>

<nav style="background-color: #1b1e21" class="navbar navbar-expand-lg navbar-dark probootstrap_navbar"
     id="probootstrap-navbar">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">Places</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#probootstrap-menu"
                aria-controls="probootstrap-menu" aria-expanded="false" aria-label="Toggle navigation">
            <span><i class="ion-navicon"></i></span>
        </button>
        <div class="collapse navbar-collapse" id="probootstrap-menu">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active"><a class="nav-link" href="index.jsp">Home</a></li>
<%--                <li class="nav-item"><a class="nav-link" href="city-guides.html">City Guides</a></li>--%>
<%--                <li class="nav-item"><a class="nav-link" href="services.html">Services</a></li>--%>
                <li class="nav-item"><a class="nav-link" href="log-in.jsp">Log In</a></li>
                <li class="nav-item"><a class="nav-link" href="sign-up.jsp">Sign Up</a></li>
            </ul>
        </div>
    </div>
</nav>
<!-- END nav -->



<section class="probootstrap_section bg-light" id="section-contact">
    <style>
        .mainform {
            width: 45%;
            margin: auto;
        }
    </style>
    <form class="mainform" action="logIn" method="post" class="probootstrap-form probootstrap-form-box mb60">
        <input type="hidden" name="action" value="logIn">
        <p style="color:#5897fb"><i><b>${message} </b><br></i></p>

        <div class="form-group">
            <label for="userName" class="sr-only sr-only-focusable">User name</label>
            <input type="text" class="form-control" id="userName" name="userName" placeholder="User name"
                   value=${user.getUserName()}>
        </div>
        <div class="form-group">
            <label for="password" class="sr-only sr-only-focusable">User name</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Password">
        </div>
        <div>
            <a href="sign-up.jsp">Sign Up Now</a><br>
            <a href="forget-password.jsp">Forget Password</a>
        </div>
        <div class="form-group">
            <input type="submit" class="btn btn-primary" id="submit" name="submit" value="LOG IN">
        </div>
    </form>
</section>


<footer class="probootstrap_section probootstrap-border-top">
    <div class="container">
        <div class="row mb-5">
            <div class="col-md-3">
                <h3 class="probootstrap_font-18 mb-3">Quick Links</h3>
                <ul class="list-unstyled">
                    <li><a href="https://free-template.co" target="_blank">Home</a></li>
                    <li><a href="https://free-template.co" target="_blank">About</a></li>
                    <li><a href="https://free-template.co" target="_blank">Services</a></li>
                    <li><a href="https://free-template.co" target="_blank">Contact</a></li>
                </ul>
            </div>
            <div class="col-md-3">
                <h3 class="probootstrap_font-18 mb-3">Quick Links</h3>
                <ul class="list-unstyled">
                    <li><a href="https://free-template.co" target="_blank">Home</a></li>
                    <li><a href="https://free-template.co" target="_blank">About</a></li>
                    <li><a href="https://free-template.co" target="_blank">Services</a></li>
                    <li><a href="https://free-template.co" target="_blank">Contact</a></li>
                </ul>
            </div>
            <div class="col-md-3">
                <h3 class="probootstrap_font-18 mb-3">Quick Links</h3>
                <ul class="list-unstyled">
                    <li><a href="https://free-template.co" target="_blank">Home</a></li>
                    <li><a href="https://free-template.co" target="_blank">About</a></li>
                    <li><a href="https://free-template.co" target="_blank">Services</a></li>
                    <li><a href="https://free-template.co" target="_blank">Contact</a></li>
                </ul>
            </div>
            <div class="col-md-3">
                <h3 class="probootstrap_font-18 mb-3">Quick Links</h3>
                <ul class="list-unstyled">
                    <li><a href="https://free-template.co" target="_blank">Home</a></li>
                    <li><a href="https://free-template.co" target="_blank">About</a></li>
                    <li><a href="https://free-template.co" target="_blank">Services</a></li>
                    <li><a href="https://free-template.co" target="_blank">Contact</a></li>
                </ul>
            </div>
        </div>
        <div class="row pt-5">
            <div class="col-md-12 text-center">
                <p class="probootstrap_font-14">&copy; 2017. All Rights Reserved. <br> Designed &amp; Developed by <a
                        href="https://uicookies.com/" target="_blank">uiCookies</a><small> (Don't remove credit link on this
                    footer. See <a href="https://uicookies.com/license/">license</a>)</small></p>
                <p class="probootstrap_font-14">Demo Images: <a href="https://unsplash.com/" target="_blank">Unsplash</a></p>
            </div>
        </div>
    </div>
</footer>

<script src="assets/js/jquery.min.js"></script>

<script src="assets/js/popper.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/owl.carousel.min.js"></script>

<script src="assets/js/jquery.waypoints.min.js"></script>
<script src="assets/js/jquery.easing.1.3.js"></script>

<script src="assets/js/select2.min.js"></script>

<script src="assets/js/main.js"></script>

</body>
</html>
