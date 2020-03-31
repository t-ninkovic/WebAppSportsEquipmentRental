<%-- 
    Document   : view
    Created on : Jun 22, 2019, 1:34:13 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:if test="${exception ne null}">
    <div class="error">${exception.message}</div>
</c:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cenovnik</title>
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
        <c:if test="${tip == 'pogresan'}">
            <%@ include file="../headerBasic.jsp"%>
        </c:if>

        <div class="container-fluid padding">
            <div class="row text-center">
                <div class="col-12">
                    <h1 class="display-4 myHeading">Cenovnik</h1>
                </div>
                <hr class="myhr">
            </div>
        </div>

        <div class="container">
            <table class="table table-striped">
                <thead class="thead-light cenovnikTabela">
                    <tr>
                        <th scope="col">Oprema ID</th>
                        <th scope="col">Vrsta opreme</th>
                        <th scope="col">Proizvodjac</th>
                        <th scope="col">Cena</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${stavke}" var="stavka">
                        <tr>
                            <td>${stavka.oprema.id}</td>
                            <td>${stavka.oprema.vrsta.naziv}</td>
                            <td>${stavka.oprema.proizvodjac.naziv}</td>
                            <td>${stavka.cena} ${stavka.valuta.naziv} / ${stavka.jm.naziv}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <c:if test="${tip == 'radnik'}">
            <div class="container padding" style="padding-top:200px;">
                <div class="row text-center">
                    <div class="col-12">
                        <a href="/WebAppIznajmljivanjeSportskeOpreme/cenovnik/edit/${cenovnik.id}" class="btn myBtn">Izmeni cenovnik</a>
                    </div>
                    <div>
                    </div>
                </c:if>
                </body>
                </html>
