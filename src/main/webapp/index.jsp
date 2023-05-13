<%@ page import="business.User" %>
<%@ page import="business.RoomInfo" %>
<%@ page import="database.RoomDatabase" %>
<%@ page import="java.util.List" %>
<%@ page import="business.RoomInfo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Places &mdash; Free HTML5 Bootstrap 4 Theme by uicookies.com</title>
    <meta name="description" content="Free Bootstrap 4 Theme by uicookies.com">
    <meta name="keywords" content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">


    <link href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,700" rel="stylesheet">

    <link rel="stylesheet" href="assets/css/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="assets/css/animate.css">
    <link rel="stylesheet" href="assets/fonts/ionicons/css/ionicons.min.css">

    <link rel="stylesheet" href="assets/css/owl.carousel.min.css">

    <link rel="stylesheet" href="assets/fonts/flaticon/font/flaticon.css">

    <link rel="stylesheet" href="assets/fonts/fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="assets/css/select2.css">


    <link rel="stylesheet" href="assets/css/helpers.css">
    <link rel="stylesheet" href="assets/css/style.css">

</head>

<body>

<%
//    if(session.getAttribute("info")==null)
    if(false==true)
    {
        List<RoomInfo> roomInfos = RoomDatabase.getAllRoomInfo();
        session.setAttribute("info", roomInfos);
%>

<%
    }
%>
<%--<nav class="navbar navbar-expand-lg navbar-dark probootstrap_navbar" id="probootstrap-navbar">--%>
<%--    <div class="container">--%>
<%--        <a class="navbar-brand" href="index.html">Places</a>--%>
<%--        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#probootstrap-menu" aria-controls="probootstrap-menu" aria-expanded="false" aria-label="Toggle navigation">--%>
<%--            <span><i class="ion-navicon"></i></span>--%>
<%--        </button>--%>
<%--        <div class="collapse navbar-collapse" id="probootstrap-menu">--%>
<%--            <ul class="navbar-nav ml-auto">--%>
<%--                <li class="nav-item active"><a class="nav-link" href="index.jsp">Home</a></li>--%>
<%--                <li class="nav-item"><a class="nav-link" href="city-guides.html">City Guides</a></li>--%>
<%--                <li class="nav-item"><a class="nav-link" href="services.html">Services</a></li>--%>
<%--                <li class="nav-item"><a class="nav-link" href="travel.html">Travel With Us</a></li>--%>
<%--                <li class="nav-item"><a class="nav-link" href="sign-up.jsp">Sign up</a></li>--%>
<%--            </ul>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</nav>--%>
<%
    if(session.getAttribute("user")!=null)
    {
%>
<nav class="navbar navbar-expand-lg navbar-dark probootstrap_navbar" id="probootstrap-navbar">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">Places</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#probootstrap-menu" aria-controls="probootstrap-menu" aria-expanded="false" aria-label="Toggle navigation">
            <span><i class="ion-navicon"></i></span>
        </button>
        <div class="collapse navbar-collapse" id="probootstrap-menu">
<%--            <p class="navbar-nav ml-auto">Hello ${sessionScope.get("user").getFirstName()}</p>--%>
            <style>
                ul.dropdown li
                {
                    display: block;
                    width: 100%;
                }
                ul.dropdown
                {
                    position: absolute;
                    z-index: 999;
                    display: none;
                }
                ul li:hover ul.dropdown{
                    display: block;
                }
            </style>
            <ul class="navbar-nav ml-auto">
                <li>
                    <a href="#">Hello ${sessionScope.get("user").getFirstName()}</a>
                    <ul class = "dropdown">
                        <li>
                            <a href="/Control/LogOut" accesskey="1" title="">Personal Information</a>
                        </li>
                        <li>
                            <form action="LogOut" method="get">
                                <input type="hidden" name="action" value="log out">
                                <input type="submit" style="background:rgba(0,0,0,0.5);" value="Log Out">
                            </form>
                        </li>
                    </ul>
                </li>
            </ul>
<%--            <ul class="navbar-nav ml-auto">--%>
<%--                <li class="nav-item active"><a class="nav-link" href="index.jsp">Home</a></li>--%>
<%--                <li class="nav-item"><a class="nav-link" href="city-guides.html">City Guides</a></li>--%>
<%--                <li class="nav-item"><a class="nav-link" href="services.html">Services</a></li>--%>
<%--                <li class="nav-item"><a class="nav-link" href="travel.html">Travel With Us</a></li>--%>
<%--                <li class="nav-item"><a class="nav-link" href="sign-up.jsp">Sign up</a></li>--%>
<%--            </ul>--%>
        </div>
    </div>
</nav>
<%
    }
    else {
%>
<nav class="navbar navbar-expand-lg navbar-dark probootstrap_navbar" id="probootstrap-navbar">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">Places</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#probootstrap-menu" aria-controls="probootstrap-menu" aria-expanded="false" aria-label="Toggle navigation">
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
<%
    }
%>
<!-- END nav -->


<section class="probootstrap-cover overflow-hidden relative"  style="background-image: url('assets/images/bg_1.jpg');" data-stellar-background-ratio="0.5"  id="section-home">
    <div class="overlay"></div>
    <div class="container">
        <div class="row align-items-center">
            <div class="col-md">
                <h2 class="heading mb-2 display-4 font-light probootstrap-animate"><img id ="displayImage" style = "width: 420px; height: 240px;" src="assets/images/type1.png" alt=""></h2>
                <p class="lead mb-5 probootstrap-animate">Hope u like it! another free template by <a href="https://uicookies.com/" target="_blank">uicookies.com</a> Under License <a href="https://uicookies.com/license" target="_blank">CC 3.0</a></p>
                <p class="probootstrap-animate">
                    <a href="onepage.html" role="button" class="btn btn-primary p-3 mr-3 pl-5 pr-5 text-uppercase d-lg-inline d-md-inline d-sm-block d-block mb-3">See OnePage Verion</a>
                </p>
            </div>

            <div class="col-md probootstrap-animate">
                <form action="Booking" method="get" class="probootstrap-form">
                    <div class="form-group">
                        <div class="row mb-3">
                            <div class="col-md">
                                <div class="form-group">
                                    <p style = "color:#5897fb"><i><b>${bookingMessage} </b><br></i></p>
                                    <label for="id_label_single">From</label>

                                    <label for="id_label_single" style="width: 100%;">
                                        <select name = "room_option"
                                                class="js-example-basic-single js-states form-control"
                                                id="id_label_single" style="width: 100%;">
                                            <option value="1">Deluxe Double Lake View</option>
                                            <option value="2">Deluxe Single Balcony</option>
                                            <option value="3">Deluxe Double Balcony</option>
                                            <option value="4">Signature Balcony</option>
                                            <option value="5">Junior Suite Courtyard</option>
                                            <option value="6">Junior Suite Courtyard Twin</option>
                                            <option value="7">Courtyard Suite</option>
                                            <option value="8">Lake View Suite</option>
                                            <option value="9">Celebrity Suite</option>
                                            <option value="10">Senator Suite</option>
                                        </select>
                                    </label>


                                </div>
                            </div>
                        </div>
                        <!-- END row -->
                        <div class="row mb-5">
                            <div class="col-md">
                                <div class="form-group">
                                    <label for="probootstrap-date-departure">Arrival Date</label>
                                    <div class="probootstrap-date-wrap">
                                        <span class="icon ion-calendar"></span>
                                        <input name = "Date_In" type="text" id="probootstrap-date-departure" class="form-control" placeholder="">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md">
                                <div class="form-group">
                                    <label for="probootstrap-date-arrival">Check Out Date</label>
                                    <div class="probootstrap-date-wrap">
                                        <span class="icon ion-calendar"></span>
                                        <input name = "Date_Out" type="text" id="probootstrap-date-arrival" class="form-control" placeholder="">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- END row -->
                        <div class="row">
                            <div class="col-md">
                                <label for="round" class="mr-5"><input type="radio" id="round" name="direction">  Round</label>
                                <label for="oneway"><input type="radio" id="oneway" name="direction">  Oneway</label>
                            </div>
                            <div class="col-md">
                                <input type="submit" value="Submit" class="btn btn-primary btn-block">
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

</section>
<!-- END section -->


<%--<section class="probootstrap_section" id="section-feature-testimonial">--%>
<%--    <div class="container">--%>
<%--        <div class="row justify-content-center mb-5">--%>
<%--            <div class="col-md-12 text-center mb-5 probootstrap-animate">--%>
<%--                <h2 class="display-4 border-bottom probootstrap-section-heading">Why we Love Places</h2>--%>
<%--                <blockquote class="">--%>
<%--                    <p class="lead mb-4"><em>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</em></p>--%>
<%--                    <p class="probootstrap-author">--%>
<%--                        <a href="https://uicookies.com/" target="_blank">--%>
<%--                            <img src="assets/images/person_1.jpg" alt="Free Template by uicookies.com" class="rounded-circle">--%>
<%--                            <span class="probootstrap-name">James Smith</span>--%>
<%--                            <span class="probootstrap-title">Chief Executive Officer</span>--%>
<%--                        </a>--%>
<%--                    </p>--%>
<%--                </blockquote>--%>

<%--            </div>--%>
<%--        </div>--%>

<%--    </div>--%>
<%--</section>--%>
<!-- END section -->


<%--<section class="probootstrap_section" id="section-city-guides">--%>
<%--    <div class="container">--%>
<%--        <div class="row text-center mb-5 probootstrap-animate">--%>
<%--            <div class="col-md-12">--%>
<%--                <h2 class="display-4 border-bottom probootstrap-section-heading">Top Places Around The World</h2>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="row">--%>
<%--            <div class="col-lg-3 col-md-6 probootstrap-animate mb-3">--%>
<%--                <a href="#" class="probootstrap-thumbnail">--%>
<%--                    <img src="assets/images/img_1.jpg" alt="Free Template by uicookies.com" class="img-fluid">--%>
<%--                    <div class="probootstrap-text">--%>
<%--                        <h3>Buena</h3>--%>
<%--                    </div>--%>
<%--                </a>--%>
<%--            </div>--%>
<%--            <div class="col-lg-3 col-md-6 probootstrap-animate mb-3">--%>
<%--                <a href="#" class="probootstrap-thumbnail">--%>
<%--                    <img src="assets/images/img_2.jpg" alt="Free Template by uicookies.com" class="img-fluid">--%>
<%--                    <h3>Road</h3>--%>
<%--                </a>--%>
<%--            </div>--%>
<%--            <div class="col-lg-3 col-md-6 probootstrap-animate mb-3">--%>
<%--                <a href="#" class="probootstrap-thumbnail">--%>
<%--                    <img src="assets/images/img_3.jpg" alt="Free Template by uicookies.com" class="img-fluid">--%>
<%--                    <h3>Australia</h3>--%>
<%--                </a>--%>
<%--            </div>--%>
<%--            <div class="col-lg-3 col-md-6 probootstrap-animate mb-3">--%>
<%--                <a href="#" class="probootstrap-thumbnail">--%>
<%--                    <img src="assets/images/img_4.jpg" alt="Free Template by uicookies.com" class="img-fluid">--%>
<%--                    <h3>Japan</h3>--%>
<%--                </a>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</section>--%>



<%--<section class="probootstrap_section">--%>
<%--    <div class="container">--%>
<%--        <div class="row text-center mb-5 probootstrap-animate">--%>
<%--            <div class="col-md-12">--%>
<%--                <h2 class="display-4 border-bottom probootstrap-section-heading">Our Services</h2>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</section>--%>


<%--<section class="probootstrap-section-half d-md-flex" id="section-about">--%>
<%--    <div class="probootstrap-image probootstrap-animate" data-animate-effect="fadeIn" style="background-image: url(assets/images/img_2.jpg)"></div>--%>
<%--    <div class="probootstrap-text">--%>
<%--        <div class="probootstrap-inner probootstrap-animate" data-animate-effect="fadeInRight">--%>
<%--            <h2 class="heading mb-4">Customer Service</h2>--%>
<%--            <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.</p>--%>
<%--            <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar.</p>--%>
<%--            <p><a href="#" class="btn btn-primary">Read More</a></p>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</section>--%>


<%--<section class="probootstrap-section-half d-md-flex">--%>
<%--    <div class="probootstrap-image order-2 probootstrap-animate" data-animate-effect="fadeIn" style="background-image: url(assets/images/img_3.jpg)"></div>--%>
<%--    <div class="probootstrap-text order-1">--%>
<%--        <div class="probootstrap-inner probootstrap-animate" data-animate-effect="fadeInLeft">--%>
<%--            <h2 class="heading mb-4">Payment Options</h2>--%>
<%--            <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.</p>--%>
<%--            <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar.</p>--%>
<%--            <p><a href="#" class="btn btn-primary">Learn More</a></p>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</section>--%>
<!-- END section -->

<%--<section class="probootstrap_section">--%>
<%--    <div class="container">--%>
<%--        <div class="row text-center mb-5 probootstrap-animate">--%>
<%--            <div class="col-md-12">--%>
<%--                <h2 class="display-4 border-bottom probootstrap-section-heading">Travel With Us</h2>--%>
<%--            </div>--%>
<%--        </div>--%>

<%--        <div class="row probootstrap-animate">--%>
<%--            <div class="col-md-12">--%>
<%--                <div class="owl-carousel js-owl-carousel">--%>
<%--                    <a class="probootstrap-slide" href="#">--%>
<%--                        <span class="flaticon-teatro-de-la-caridad"></span>--%>
<%--                        <em>Teatro de la Caridad</em>--%>
<%--                    </a>--%>
<%--                    <a class="probootstrap-slide" href="#">--%>
<%--                        <span class="flaticon-royal-museum-of-the-armed-forces"></span>--%>
<%--                        <em>Royal Museum of the Armed Forces</em>--%>
<%--                    </a>--%>
<%--                    <a class="probootstrap-slide" href="#">--%>
<%--                        <span class="flaticon-parthenon"></span>--%>
<%--                        <em>Parthenon</em>--%>
<%--                    </a>--%>
<%--                    <a class="probootstrap-slide" href="#">--%>
<%--                        <span class="flaticon-marina-bay-sands"></span>--%>
<%--                        <em>Marina Bay Sands</em>--%>
<%--                    </a>--%>
<%--                    <a class="probootstrap-slide" href="#">--%>
<%--                        <span class="flaticon-samarra-minaret"></span>--%>
<%--                        <em>Samarra Minaret</em>--%>
<%--                    </a>--%>
<%--                    <a class="probootstrap-slide" href="#">--%>
<%--                        <span class="flaticon-chiang-kai-shek-memorial"></span>--%>
<%--                        <em>Chiang Kai Shek Memorial</em>--%>
<%--                    </a>--%>
<%--                    <a class="probootstrap-slide" href="#">--%>
<%--                        <span class="flaticon-heuvelse-kerk-tilburg"></span>--%>
<%--                        <em>Heuvelse Kerk Tilburg</em>--%>
<%--                    </a>--%>
<%--                    <a class="probootstrap-slide" href="#">--%>
<%--                        <span class="flaticon-cathedral-of-cordoba"></span>--%>
<%--                        <em>Cathedral of Cordoba</em>--%>
<%--                    </a>--%>
<%--                    <a class="probootstrap-slide" href="#">--%>
<%--                        <span class="flaticon-london-bridge"></span>--%>
<%--                        <em>London Bridge</em>--%>
<%--                    </a>--%>
<%--                    <a class="probootstrap-slide" href="#">--%>
<%--                        <span class="flaticon-taj-mahal"></span>--%>
<%--                        <em>Taj Mahal</em>--%>
<%--                    </a>--%>
<%--                    <a class="probootstrap-slide" href="#">--%>
<%--                        <span class="flaticon-leaning-tower-of-pisa"></span>--%>
<%--                        <em>Leaning Tower of Pisa</em>--%>
<%--                    </a>--%>
<%--                    <a class="probootstrap-slide" href="#">--%>
<%--                        <span class="flaticon-burj-al-arab"></span>--%>
<%--                        <em>Burj al Arab</em>--%>
<%--                    </a>--%>
<%--                    <a class="probootstrap-slide" href="#">--%>
<%--                        <span class="flaticon-gate-of-india"></span>--%>
<%--                        <em>Gate of India</em>--%>
<%--                    </a>--%>
<%--                    <a class="probootstrap-slide" href="#">--%>
<%--                        <span class="flaticon-osaka-castle"></span>--%>
<%--                        <em>Osaka Castle</em>--%>
<%--                    </a>--%>
<%--                    <a class="probootstrap-slide" href="#">--%>
<%--                        <span class="flaticon-statue-of-liberty"></span>--%>
<%--                        <em>Statue of Liberty</em>--%>
<%--                    </a>--%>

<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</section>--%>
<!-- END section -->

<%--<section class="probootstrap_section bg-light">--%>
<%--    <div class="container">--%>
<%--        <div class="row text-center mb-5 probootstrap-animate">--%>
<%--            <div class="col-md-12">--%>
<%--                <h2 class="display-4 border-bottom probootstrap-section-heading">More Services</h2>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="row">--%>
<%--            <div class="col-md-6">--%>

<%--                <div class="media probootstrap-media d-flex align-items-stretch mb-4 probootstrap-animate">--%>
<%--                    <div class="probootstrap-media-image" style="background-image: url(assets/images/img_1.jpg)">--%>
<%--                    </div>--%>
<%--                    <div class="media-body">--%>
<%--                        <h5 class="mb-3">01. Service Title Here</h5>--%>
<%--                        <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. </p>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                <div class="media probootstrap-media d-flex align-items-stretch mb-4 probootstrap-animate">--%>
<%--                    <div class="probootstrap-media-image" style="background-image: url(assets/images/img_2.jpg)">--%>
<%--                    </div>--%>
<%--                    <div class="media-body">--%>
<%--                        <h5 class="mb-3">02. Service Title Here</h5>--%>
<%--                        <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. </p>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--            </div>--%>
<%--            <div class="col-md-6">--%>

<%--                <div class="media probootstrap-media d-flex align-items-stretch mb-4 probootstrap-animate">--%>
<%--                    <div class="probootstrap-media-image" style="background-image: url(assets/images/img_4.jpg)">--%>
<%--                    </div>--%>
<%--                    <div class="media-body">--%>
<%--                        <h5 class="mb-3">03. Service Title Here</h5>--%>
<%--                        <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. </p>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                <div class="media probootstrap-media d-flex align-items-stretch mb-4 probootstrap-animate">--%>
<%--                    <div class="probootstrap-media-image" style="background-image: url(assets/images/img_5.jpg)">--%>
<%--                    </div>--%>
<%--                    <div class="media-body">--%>
<%--                        <h5 class="mb-3">04. Service Title Here</h5>--%>
<%--                        <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. </p>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</section>--%>
<!-- END section -->

<%--<section class="probootstrap_section" id="section-feature-testimonial">--%>
<%--    <div class="container">--%>
<%--        <div class="row justify-content-center mb-5">--%>
<%--            <div class="col-md-12 text-center mb-5 probootstrap-animate">--%>
<%--                <h2 class="display-4 border-bottom probootstrap-section-heading">Testimonial</h2>--%>
<%--                <blockquote class="">--%>
<%--                    <p class="lead mb-4"><em>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</em></p>--%>
<%--                    <p class="probootstrap-author">--%>
<%--                        <a href="https://uicookies.com/" target="_blank">--%>
<%--                            <img src="assets/images/person_1.jpg" alt="Free Template by uicookies.com" class="rounded-circle">--%>
<%--                            <span class="probootstrap-name">James Smith</span>--%>
<%--                            <span class="probootstrap-title">Chief Executive Officer</span>--%>
<%--                        </a>--%>
<%--                    </p>--%>
<%--                </blockquote>--%>

<%--            </div>--%>
<%--        </div>--%>

<%--    </div>--%>
<%--</section>--%>
<!-- END section -->

<%--<section class="probootstrap_section bg-light">--%>
<%--    <div class="container">--%>
<%--        <div class="row text-center mb-5 probootstrap-animate">--%>
<%--            <div class="col-md-12">--%>
<%--                <h2 class="display-4 border-bottom probootstrap-section-heading">News</h2>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="row">--%>
<%--            <div class="col-md-6">--%>

<%--                <div class="media probootstrap-media d-flex align-items-stretch mb-4 probootstrap-animate">--%>
<%--                    <div class="probootstrap-media-image" style="background-image: url(assets/images/img_1.jpg)">--%>
<%--                    </div>--%>
<%--                    <div class="media-body">--%>
<%--                        <span class="text-uppercase">January 1st 2018</span>--%>
<%--                        <h5 class="mb-3">Travel To United States Without Visa</h5>--%>
<%--                        <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. </p>--%>
<%--                        <p><a href="#">Read More</a></p>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                <div class="media probootstrap-media d-flex align-items-stretch mb-4 probootstrap-animate">--%>
<%--                    <div class="probootstrap-media-image" style="background-image: url(assets/images/img_2.jpg)">--%>
<%--                    </div>--%>
<%--                    <div class="media-body">--%>
<%--                        <span class="text-uppercase">January 1st 2018</span>--%>
<%--                        <h5 class="mb-3">Travel To United States Without Visa</h5>--%>
<%--                        <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. </p>--%>
<%--                        <p><a href="#">Read More</a></p>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--            </div>--%>
<%--            <div class="col-md-6">--%>

<%--                <div class="media probootstrap-media d-flex align-items-stretch mb-4 probootstrap-animate">--%>
<%--                    <div class="probootstrap-media-image" style="background-image: url(assets/images/img_4.jpg)">--%>
<%--                    </div>--%>
<%--                    <div class="media-body">--%>
<%--                        <span class="text-uppercase">January 1st 2018</span>--%>
<%--                        <h5 class="mb-3">Travel To United States Without Visa</h5>--%>
<%--                        <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. </p>--%>
<%--                        <p><a href="#">Read More</a></p>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                <div class="media probootstrap-media d-flex align-items-stretch mb-4 probootstrap-animate">--%>
<%--                    <div class="probootstrap-media-image" style="background-image: url(assets/images/img_5.jpg)">--%>
<%--                    </div>--%>
<%--                    <div class="media-body">--%>
<%--                        <span class="text-uppercase">January 1st 2018</span>--%>
<%--                        <h5 class="mb-3">Travel To United States Without Visa</h5>--%>
<%--                        <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. </p>--%>
<%--                        <p><a href="#">Read More</a></p>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</section>--%>
<!-- END section -->

<section class="probootstrap_section">
    <div class="container">
        <div class="row text-center mb-5 probootstrap-animate">
            <div class="col-md-12">
                <h2 class="display-4 border-bottom probootstrap-section-heading">Avaiable roomInfos</h2>
            </div>
        </div>

        <div class="row probootstrap-animate">
            <div class="col-md-12">
                <div class="owl-carousel js-owl-carousel-2">
                    <div>
                        <div class="media probootstrap-media d-block align-items-stretch mb-4 probootstrap-animate">
                            <img src="assets\images\type1.png" alt="Free Template by uiCookies" class="img-fluid">
                            <div class="media-body">
                                <h5 class="mb-3">Deluxe Double Room Lake View</h5>
                                <p>32 sq.m / 344 sq.ft, View: Lake View - Location: Floor 1 to 4 - Shower in some room, bathtub in some rooms.</p>
                            </div>
                        </div>
                    </div>
                    <!-- END slide item -->

                    <div>
                        <div class="media probootstrap-media d-block align-items-stretch mb-4 probootstrap-animate">
                            <img src="assets/images/type2.png" alt="Free Template by uiCookies" class="img-fluid">
                            <div class="media-body">
                                <h5 class="mb-3">Deluxe Single Room with Balcony</h5>
                                <p>25 sq.m / 269 sq.ft, View: Lake View - Location: Highest floor / 5th Floor - Shower only, Balcony or Terrace in all rooms</p>
                            </div>
                        </div>
                    </div>
                    <!-- END slide item -->

                    <div>
                        <div class="media probootstrap-media d-block align-items-stretch mb-4 probootstrap-animate">
                            <img src="assets/images/type3.png" alt="Free Template by uiCookies" class="img-fluid">
                            <div class="media-body">
                                <h5 class="mb-3">Deluxe Double Room with Balcony</h5>
                                <p>35 sq.m / 377 sq.ft, View: Lake View - Location: Highest floor / 5th Floor - Shower in all rooms, Bathtub in some rooms, Balcony or Terrace in all rooms</p>
                            </div>
                        </div>
                    </div>
                    <!-- END slide item -->

                    <div>
                        <div class="media probootstrap-media d-block align-items-stretch mb-4 probootstrap-animate">
                            <img src="assets/images/type4.png" alt="Free Template by uiCookies" class="img-fluid">
                            <div class="media-body">
                                <h5 class="mb-3">Signature Room with Balcony</h5>
                                <p>42 sq.m / 452 sq.ft, View: Lake View - Location: Highest floor / 5th Floor - Shower and Bathtub in all rooms, Balcony or Terrace in all rooms</p>
                            </div>
                        </div>
                    </div>
                    <!-- END slide item -->

                    <div>
                        <div class="media probootstrap-media d-block align-items-stretch mb-4 probootstrap-animate">
                            <img src="assets/images/type5.png" alt="Free Template by uiCookies" class="img-fluid">
                            <div class="media-body">
                                <h5 class="mb-3">Junior Suite Courtyard</h5>
                                <p>45 sq.m / 484 sq.ft, View: Courtyard - Location: Floors 1 to 4 - Bathtub and Shower in all rooms </p>
                            </div>
                        </div>
                    </div>
                    <!-- END slide item -->


                    <div>
                        <div class="media probootstrap-media d-block align-items-stretch mb-4 probootstrap-animate">
                            <img src="assets/images/type6.png" alt="Free Template by uiCookies" class="img-fluid">
                            <div class="media-body">
                                <h5 class="mb-3">Junior Suite Courtyard Twin</h5>
                                <p>45 sq.m / 484 sq.ft, View: Courtyard - Location: Floors 1 to 4 - Bathtub and Shower in all rooms </p>
                            </div>
                        </div>
                    </div>
                    <!-- END slide item -->

                    <div>
                        <div class="media probootstrap-media d-block align-items-stretch mb-4 probootstrap-animate">
                            <img src="assets/images/type7.png" alt="Free Template by uiCookies" class="img-fluid">
                            <div class="media-body">
                                <h5 class="mb-3">Courtyard Suite</h5>
                                <p>80 sq.m / 861 sq.ft, View: Courtyard - Location: 1st Floor - Bathtub and Shower in all rooms </p>
                            </div>
                        </div>
                    </div>
                    <!-- END slide item -->

                    <div>
                        <div class="media probootstrap-media d-block align-items-stretch mb-4 probootstrap-animate">
                            <img src="assets/images/type8.png" alt="Free Template by uiCookies" class="img-fluid">
                            <div class="media-body">
                                <h5 class="mb-3">Lake View Suite</h5>
                                <p>75 sq.m / 807 sq.ft, View: Lake View - Location: Floors 1 to 4 - Bathtub and Shower in all rooms, Balcony or Terrace in some rooms </p>
                            </div>
                        </div>
                    </div>
                    <!-- END slide item -->

                    <div>
                        <div class="media probootstrap-media d-block align-items-stretch mb-4 probootstrap-animate">
                            <img src="assets/images/type9.png" alt="Free Template by uiCookies" class="img-fluid">
                            <div class="media-body">
                                <h5 class="mb-3">Celebrity Suite</h5>
                                <p>95 sq.m / 1023 sq.ft, View: Lake View - Location: Floors 1 to 4 - Bathtub and Shower in all rooms, Jacuzzi in some rooms </p>
                            </div>
                        </div>
                    </div>
                    <!-- END slide item -->

                    <div>
                        <div class="media probootstrap-media d-block align-items-stretch mb-4 probootstrap-animate">
                            <img src="assets/images/type10.png" alt="Free Template by uiCookies" class="img-fluid">
                            <div class="media-body">
                                <h5 class="mb-3">Senator Suite</h5>
                                <p>90 sq.m / 969 sq.ft, View: Lake View - Location: Floors 1 to 4 - Bathtub and Shower in all rooms </p>
                            </div>
                        </div>
                    </div>
                    <!-- END slide item -->

                </div>
            </div>
        </div>
    </div>
</section>
<!-- END section -->

<section class="probootstrap_section" id="section-feature-testimonial">
    <div class="container">
        <div class="row justify-content-center mb-5">
            <div class="col-md-12 text-center mb-5 probootstrap-animate">
                <h2 class="display-4 border-bottom probootstrap-section-heading">About us</h2>
                <blockquote class="">
                    <p class="lead mb-4"><em>We are a group of students that is currently learning web programming. This is the group final project about hotel renting. The page you are looking at is stolen from the internet and we do not understand this 2000-line html/css. So our best effort is to modify things and try not to break anything while doing that.</em></p>
                    <!-- <p class="probootstrap-author">
                      <a href="https://uicookies.com/" target="_blank">
                        <img src="assets/images/person_1.jpg" alt="Free Template by uicookies.com" class="rounded-circle">
                        <span class="probootstrap-name">Vo Duc Hoang Phi</span>
                        <span class="probootstrap-title">20110432</span>
                        <img src="assets/images/person_1.jpg" alt="Free Template by uicookies.com" class="rounded-circle">
                        <span class="probootstrap-name">Huynh Hoang Thai</span>
                        <span class="probootstrap-title">20110xxx</span>
                      </a>
                    </p> -->
                    <style>
                        .aboutUs{
                            box-sizing: border-box;
                            display: block;
                            width: 100%;
                            font-size: 12px;
                            text-transform: uppercase;
                            letter-spacing: .2em;
                            color: #b3b3b3;
                            font-weight: 700;
                            /* color: #b3b3b3; */
                            float: left;
                        }
                        .aboutUs1
                        {
                            display: block;
                            /*border-radius: 1px solid red;*/
                            float: left;
                            width: 33%;
                        }
                        .aboutUs2
                        {
                            border-radius: 50%;
                        }
                    </style>
                    <div class = "aboutUs">
                        <div class = "aboutUs1">
                            <img class = "aboutUs2" src="assets/images/potato.png" alt="Free Template by uicookies.com" width="90" height="90"><br>
                            <span>Vo Duc Hoang Phi</span><br>
                            <span>20110432</span>
                        </div>
                        <div class = "aboutUs1">
                            <img class = "aboutUs2" src="assets/images/potato.png" alt="Free Template by uicookies.com" width="90" height="90"><br>
                            <span>Huynh Hoang Thai</span><br>
                            <span>20110399</span>
                        </div>
                        <div class = "aboutUs1">
                            <img class = "aboutUs2" src="assets/images/potato.png" alt="Free Template by uicookies.com" width="90" height="90"><br>
                            <span>Huynh Hoang Thai</span><br>
                            <span>20110xxx</span>
                        </div>
                    </div>
                </blockquote>

            </div>
        </div>

    </div>
</section>
<!-- END section -->

<section class="probootstrap_section" id="section-feature-testimonial">
    <div class="container">
        <div class="row justify-content-center mb-5">
            <div class="col-md-12 text-center mb-5 probootstrap-animate">
                <h2 class="display-4 border-bottom probootstrap-section-heading">Other Projects</h2>
                <blockquote class="">
                    <p class="lead mb-4"><em>Below are the in-class projects.
                        Note that we do not have EL and JSTL because we have already used them in the very first projects.
                        Also note that we do not upload many images or video because it is AWS free tier (it is possible but costly).
                    Session will work fine but cookies may have some issues due to timezone difference.</em></p>
                    <!-- <p class="probootstrap-author">
                      <a href="https://uicookies.com/" target="_blank">
                        <img src="assets/images/person_1.jpg" alt="Free Template by uicookies.com" class="rounded-circle">
                        <span class="probootstrap-name">Vo Duc Hoang Phi</span>
                        <span class="probootstrap-title">20110432</span>
                        <img src="assets/images/person_1.jpg" alt="Free Template by uicookies.com" class="rounded-circle">
                        <span class="probootstrap-name">Huynh Hoang Thai</span>
                        <span class="probootstrap-title">20110xxx</span>
                      </a>
                    </p> -->
                    <style>
                        .aboutUs{
                            box-sizing: border-box;
                            display: block;
                            width: 100%;
                            font-size: 12px;
                            text-transform: uppercase;
                            letter-spacing: .2em;
                            color: #b3b3b3;
                            font-weight: 700;
                            /* color: #b3b3b3; */
                            float: left;
                        }
                        .aboutUs1
                        {
                            display: block;
                            /*border-radius: 1px solid red;*/
                            float: left;
                            width: 33%;
                        }
                        .aboutUs2
                        {
                            border-radius: 50%;
                        }
                    </style>
                    <div class = "aboutUs">
                        <a href="http://webprogress-env.eba-cjkygkkp.ap-northeast-1.elasticbeanstalk.com/" target="_blank">
                            <div class = "aboutUs1">
                                <span>Email list</span><br>
                            </div>
                        </a>
                        <div class = "aboutUs1">
                            <a href="http://webprojectgroup-env.eba-pi4pefkh.ap-northeast-1.elasticbeanstalk.com/" target="_blank">
                                <span>Working with cookie and session</span><br>
                            </a>
                            <a href="http://cdshopping.eba-2kyd2ppf.ap-northeast-1.elasticbeanstalk.com/" target="_blank">
                                <span>Also working with cookie and session</span><br>
                            </a>
                        </div>
                    </div>
                </blockquote>

            </div>
        </div>

    </div>
</section>
<!-- END section -->

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
                <h3 class="probootstrap_font-18 mb-3">Quick Links</h3>
                <ul class="list-unstyled">
                    <li><a href="https://free-template.co" target="_blank">Home</a></li>
                    <li><a href="https://free-template.co" target="_blank">About</a></li>
                    <li><a href="https://free-template.co" target="_blank">Services</a></li>
                    <li><a href="https://free-template.co" target="_blank">Contact</a></li>
                </ul>
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
            </div>
        </div>
        <div class="row pt-5">
            <div class="col-md-12 text-center">
                <p class="probootstrap_font-14">&copy; 2017. All Rights Reserved. <br> Designed &amp; Developed by <a href="https://uicookies.com/" target="_blank">uiCookies</a><small> (Don't remove credit link on this footer. See <a href="https://uicookies.com/license/">license</a>)</small></p>
                <p class="probootstrap_font-14">Demo Images: <a href="https://unsplash.com/" target="_blank">Unsplash</a></p>
            </div>
        </div>
    </div>
</footer>


<script src="assets/js/jquery.min.js"></script>

<script src="assets/js/popper.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/owl.carousel.min.js"></script>

<script src="assets/js/bootstrap-datepicker.js"></script>
<script src="assets/js/jquery.waypoints.min.js"></script>
<script src="assets/js/jquery.easing.1.3.js"></script>

<script src="assets/js/select2.min.js"></script>
<script type="text/javascript">
    function displayInfo()
    {
        // document.getElementById("displayImage").src = this.options[this.selectedIndex].value();
        document.getElementById("displayImage").src = document.getElementById("id_label_single").options[this.selectedIndex].value;
    }
</script>

<script src="assets/js/main.js"></script>
</body>
</html>