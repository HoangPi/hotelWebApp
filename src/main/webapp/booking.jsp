<%@ page import="business.Room" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="static java.util.Objects.toString" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page import="static jdk.internal.org.jline.reader.impl.LineReaderImpl.CompletionType.List" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 5/8/2023
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Places</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <%
        if (request.getAttribute("booking_message") != null) {
    %>
    <meta http-equiv="Refresh" content="6; url='index.jsp'"/>
    <%
        }
    %>

    <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="css/style.css">

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark probootstrap_navbar" id="probootstrap-navbar">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">Places</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#probootstrap-menu"
                aria-controls="probootstrap-menu" aria-expanded="false" aria-label="Toggle navigation">
            <span><i class="ion-navicon"></i></span>
        </button>
        <div class="collapse navbar-collapse" id="probootstrap-menu">
            <style>
                ul.dropdown li {
                    display: block;
                    width: 100%;
                }

                ul.dropdown {
                    position: absolute;
                    z-index: 999;
                    display: none;
                }

                ul li:hover ul.dropdown {
                    display: block;
                }
            </style>
            <ul class="navbar-nav ml-auto">
                <li>
                    <a href="#">Hello ${sessionScope.get("user").getFirstName()}</a>
                    <ul class="dropdown">
                        <li><a href="#">Personal Information</a></li>
                        <li><a href="#">Log Out</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<%--End nav--%>
<section class="ftco-section">
    <form class="mainform" action="BookingControl" method="post" class="probootstrap-form probootstrap-form-box mb60">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6 text-center mb-4">
                    <%
                        if (request.getAttribute("booking_message") != null) {
                    %><p class="heading-section">No Room Is Available At The Moment, You Will Be Redirected To The Home
                    Page Soon</p><%
                    }
                %>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <h3 class="h5 mb-4 text-center">List Of Available Rooms</h3>
                    <div class="table-wrap">
                        <table class="table">
                            <thead class="thead-primary">
                            <tr>
                                <th>&nbsp;</th>
                                <%--                            <th>&nbsp;</th>--%>
                                <th>Room number</th>
                                <th>Price</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%int i = 0;%>
                            <c:forEach var="r" items="${requestScope.rooms}">
                                <tr class="alert" role="alert">
                                    <td>
                                        <label class="checkbox-wrap checkbox-primary">
                                            <input type="checkbox" name=<c:out value="${r.getNumber()}"/>>
                                            <span class="checkmark"></span>
                                            <%i++;%>
                                        </label>
                                    </td>
                                    <td><c:out value="${r.getNumber()}"/></td>
                                    <td><c:out value="${requestScope.price}"/></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <a href="index.jsp" class="btn btn-primary" style="margin-right: 20px;">Main Page</a>
                <input type="submit" class="btn btn-primary" id="submit" name="submit" value="Submit">
            </div>
        </div>
    </form>
</section>

<script src="assets/js/jquery.min.js"></script>

<script src="assets/js/popper.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/owl.carousel.min.js"></script>

<script src="assets/js/bootstrap-datepicker.js"></script>
<script src="assets/js/jquery.waypoints.min.js"></script>
<script src="assets/js/jquery.easing.1.3.js"></script>
<script src="assets/js/main.js"></script>
<script src="assets/js/select2.min.js"></script>
<script type="text/javascript">


    <script src="js/jquery.min.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>

</body>
</html>
