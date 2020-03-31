<%-- 
    Document   : index
    Created on : Jun 12, 2019, 1:18:00 PM
    Author     : HP
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web aplikacija za iznajmljivanje sportske opreme</title>
        <style>
            <%@ include file="css/bootstrap.min.css"%>
            <%@ include file="css/style.css"%>
        </style>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body>

        <c:if test="${tip == 'radnik'}">
            <%@ include file="headerRadnik.jsp"%>
        </c:if>
        <c:if test="${tip == 'klijent'}">
            <%@ include file="headerKlijent.jsp"%>
        </c:if>
        <c:if test="${tip == 'pogresan'}">
            <%@ include file="headerBasic.jsp"%>
        </c:if>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-12">


                    <div id="mySlider" class="carousel slide" data-ride="carousel">
                        <ul class="carousel-indicators">
                            <li data-target="#mySlider" data-slide-to="0" class="active"></li>
                            <li data-target="#mySlider" data-slide-to="1"></li>
                            <li data-target="#mySlider" data-slide-to="2"></li>
                        </ul>

                        <div class="carousel-inner carouselSlike">
                            <div class="item active">
                                <img src="https://www.stubaier-gletscher.com/fileadmin/_processed_/2/0/csm_header-intersport-okay-stubaier-gletscher_5b1698e404.jpg" alt="prva slika"/>
                                <div class="carousel-caption">
                                </div>
                            </div>
                            <div class="item">
                                <img src="https://bretonsfly.com/wp-content/uploads/2015/12/Specialized-Bikes-1500x500.jpg" alt="druga slika"/>
                                <div class="carousel-caption">
                                </div>
                            </div>
                            <div class="item">
                                <img src="http://www.spfurano.com/img/imgrentalski01.jpg" alt="treca slika"/>
                                <div class="carousel-caption">
                                </div>
                            </div>
                        </div>

                        <a class="left carousel-control" href="#mySlider" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left"></span>
                        </a>
                        <a class="right carousel-control" href="#mySlider" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right"></span>
                        </a>
                    </div>


                </div>
            </div>
        </div>

        <div class="container-fluid padding">
            <div class="row text-center padding">

                <div class="col-12 social padding">
                    <a href="#" class="fa fa-facebook"></a>
                    <a href="#" class="fa fa-twitter"></a>
                    <a href="#" class="fa fa-google-plus"></a>
                    <a href="#" class="fa fa-instagram"></a>
                    <a href="#" class="fa fa-youtube"></a>
                </div>
                <div class="col-12">
                    <hr>
                    <h5 class="myHeading">&copy Tijana Ninković</h5>
                </div>
            </div>
        </div>
        <script>
            <%@ include file="js/bootstrap.min.js"%>
        </script>
    </body>
</html>
