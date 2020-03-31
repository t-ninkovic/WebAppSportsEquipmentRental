<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${exception ne null}">
    <div class="error">${exception.message}</div>
</c:if>

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
        <c:if test="${tip == 'pogresan'}">
            <%@ include file="../headerBasic.jsp"%>
        </c:if>
        
        <div class="container-fluid padding">
            <div class="row text-center">
                <div class="col-12">
                    <h1 class="display-4 myHeading">Detalji opreme</h1>
                </div>
                <hr class="myhr">
            </div>
        </div>
        
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <img src="${viewOprema.slika}" alt="OVDE CE BITI SLIKA PROIZVODA" class="opremaPic">
                </div>
                <div class="col-md-6">
                    <c:if test="${tip == 'radnik'}">
                    <h4>Id: ${viewOprema.id}</h4>
                    </c:if>
                    <h3>Vrsta opreme: ${viewOprema.vrsta.naziv}</h3>
                    <h3>Proizvodjac: ${viewOprema.proizvodjac.naziv}</h3>
                    <h4>Detaljan opis:<br> ${viewOprema.opis}</h4>
                    <h4>Na stanju: ${viewOprema.naStanju}</h4>
                    <c:if test="${tip == 'klijent'}">
                    <a href="/WebAppIznajmljivanjeSportskeOpreme/iznajmljivanje/add/${viewOprema.id}" class="btn myBtn">Rezervisi</a>
                    </c:if>
                    <c:if test="${tip == 'radnik'}">
                    <a href="/WebAppIznajmljivanjeSportskeOpreme/iznajmljivanje/add/${viewOprema.id}" class="btn btn-info">Zaduzi</a>
                    <a href="/WebAppIznajmljivanjeSportskeOpreme/oprema/edit/${viewOprema.id}" class="btn btn-warning">Izmeni</a>
                    <a href="/WebAppIznajmljivanjeSportskeOpreme/oprema/delete/${viewOprema.id}" class="btn btn-danger">Obrisi</a>
                    </c:if>
                </div>
            </div>
        </div>
        
    </body>
</html>