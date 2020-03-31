<%-- 
    Document   : all
    Created on : Jun 23, 2019, 7:19:20 PM
    Author     : HP
--%>

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

        <div class="container-fluid padding">
            <div class="row text-center">
                <div class="col-12">
                    <h1 class="display-4 myHeading">Pregled iznajmljivanja</h1>
                </div>
                <hr class="myhr">
            </div>
        </div>

        <div class="container">

            <c:forEach items="${aktivna}" var="izn"> 
                <div class="col-md-4">
                    <div class="card">
                        <div class="card-body">
                            <h3 class="card-title h3">${izn.oprema.vrsta.naziv} - ${izn.oprema.proizvodjac.naziv}</h3>
                            <h4 class="h4">Iznajmio ${izn.klijent.ime} ${izn.klijent.prezime}</h4>
                            <h4 class="h4">Cena ${izn.cena}</h4>
                            <h4 class="h4">Status: ${izn.status}</h4>
                            <p>Od: ${izn.datumOd}</p>
                            <p>Do: ${izn.datumDo}</p>
                            <c:if test="${tip == 'radnik'}">
                                <button class="btn" style="width:100%"><a href="/WebAppIznajmljivanjeSportskeOpreme/iznajmljivanje/razduzi/${izn.id}" class="card-link">Razduzi</a></button>
                            </c:if>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <c:if test="${istorija != 'nema'}">
        <div style="height:100px;"></div>
        <div class="container-fluid padding">
            <div class="row text-center">
                <div class="col-12">
                    <h1 class="display-4 myHeading">Istorija</h1>
                </div>
                <hr class="myhr">
            </div>
        </div>
        <div class="container">
                <table class="table table-striped">
                    <thead class="thead-light">
                        <tr>
                            <th scope="col">Oprema</th>
                            <th scope="col">Od - do</th>
                            <th scope="col">Klijent</th>
                            <th scope="col">Cena</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${istorija}" var="iz">
                            <tr>
                                <td>${iz.oprema.vrsta.naziv} - ${iz.oprema.proizvodjac.naziv}</td>
                                <td>${iz.datumOd} - ${iz.datumDo}</td>
                                <td>${iz.klijent.ime} ${iz.klijent.prezime}</td>
                                <td>${iz.cena}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </body>
</html>





