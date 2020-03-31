<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP pregled opreme!</title>

        <style>
            <%@ include file="../css/bootstrap.min.css"%>
            <%@ include file="../css/style.css"%>
        </style>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <script>
            <%@include file="../js/bootstrap.min.js" %>
        </script>
    </head>
    <body>
        <c:if test="${tip == 'radnik'}">
            <%@ include file="../headerRadnik.jsp"%>
        </c:if>
        <c:if test="${tip == 'klijent'}">
            <%@ include file="../headerKlijent.jsp"%>
        </c:if>
        <c:if test="${tip == 'pogresan'}">
            <%@ include file="../headerBasic.jsp"%>
        </c:if>


        <!-- poruka success ili error
        -->
        <c:if test="${msg == 'error'}">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="alert alert-danger" role="alert">
                            <div class="row vertical-align">
                                <div class="col-xs-1 text-center">
                                    <i class="fa fa-exclamation-triangle fa-2x"></i> 
                                </div>
                                <div class="col-xs-10">
                                    Sistem ne može da zapamti opremu
                                </div>
                                <button type="button" class="close col-xs-1" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                        </div>      
                    </div>
                </div>
            </div>
        </c:if>

        <c:if test="${msg == 'success'}">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="alert alert-success" role="alert">
                            <div class="row vertical-align">
                                <div class="col-xs-1 text-center">
                                    <i class="fa fa-check fa-2x"></i> 
                                </div>
                                <div class="col-xs-10">
                                    Sistem je uspešno zapamtio opremu
                                </div>
                                <button type="button" class="close col-xs-1" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                        </div>      
                    </div>
                </div> 
            </div>
        </c:if>


        <div class="container-fluid padding">
            <div class="row text-center">
                <div class="col-12">
                    <h1 class="display-4 myHeading">Pregled opreme</h1>
                </div>
                <hr class="myhr">
            </div>
        </div>
        <div class="container padding">
            <div class="row padding">
                <c:forEach items="${opreme}" var="oprema"> 
                    <div class="col-md-4 col-sm-6 col-xs-12">
                        <div class="card">
                            <img class="card-img-top" src="${oprema.slika}" alt="Card image cap">
                            <div class="card-body">
                                <h3 class="card-title text-center">${oprema.vrsta.naziv} - ${oprema.proizvodjac.naziv}</h3>
                                <button class="btn myBtn" style="width:49%"><a style="color:white;" href="/WebAppIznajmljivanjeSportskeOpreme/oprema/get/${oprema.id}" class="card-link">Pogledaj detalje</a></button>
                                <c:if test="${tip == 'radnik'}">
                                    <button class="btn myBtn" style="width:49%"><a style="color:white;" href="/WebAppIznajmljivanjeSportskeOpreme/oprema/delete/${oprema.id}" class="card-link">Obrisi opremu</a></button>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

        </div>
    </body>
</html>
