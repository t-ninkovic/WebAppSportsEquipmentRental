<%-- 
    Document   : all
    Created on : Jun 22, 2019, 12:21:43 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP pregled korisnika!</title>

        <style>
            <%@ include file="../css/bootstrap.min.css"%>
            <%@ include file="../css/style.css"%>
        </style>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
    
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <script>
            <%@include file="../js/bootstrap.min.js" %>
        </script>
    </head>
    <body>
        <%@ include file="../headerRadnik.jsp"%>

        <div class="container-fluid padding">
            <div class="row text-center">
                <div class="col-12">
                    <h1 class="display-4 myHeading">Pregled svih korisnika</h1>
                </div>
                <hr>
            </div>
        </div>
        <div class="container wrapRadnici">
            <div class="row">
                <div class="col-md-6">
                    <h2 class="myHeading text-center">Radnici</h2>
                    <hr>
                    <ul class="list-group">
                        <c:forEach items="${radnici}" var="radnik">
                            <li class="list-group-item">${radnik.ime} ${radnik.prezime}</li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="col-md-6">
                    <h2 class="myHeading text-center">Klijenti</h2>
                    <hr>
                    <ul class="list-group">
                        <c:forEach items="${klijenti}" var="klijent">
                            <li class="list-group-item">
                                ${klijent.ime} ${klijent.prezime}
                                <a href="#" class="btn myBtn btn-xs pull-right">Pogledaj iznajmljivanja</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>

        </div>
    </body>
</html>
