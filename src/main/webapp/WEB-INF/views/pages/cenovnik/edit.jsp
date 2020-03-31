<%-- 
    Document   : edit
    Created on : Jun 29, 2019, 4:46:52 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:if test="${exception ne null}">
    <div class="error">${exception.message}</div>
</c:if>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP izmena cenovnika</title>

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

        <script>
            function dodajRed()
            {

                var tabela = document.getElementById('tabelaStavki');
                var row = tabela.insertRow(0);
                var oprID = row.insertCell(0);
                var vrsta = row.insertCell(1);
                var proizvodjac = row.insertCell(2);
                var cena = row.insertCell(3);
                
                oprID.innerHTML = "9";
                vrsta.innerHTML = "Snowboard";
                proizvodjac.innerHTML = "Salomon";
                cena.innerHTML = "700.0 RSD / dan";
            }
        </script>
    </head>
    <body>
        <%@ include file="../headerRadnik.jsp"%>
        <div class="container">
            <form:form method="POST" action="/WebAppIznajmljivanjeSportskeOpreme/cenovnik/saveEdit" modelAttribute="editCenovnik" class="formAdd">
                <h2 class="text-center h2">Izmena cenovnika</h2>
                <div class="form-group">
                    <form:label path="id">Id</form:label>
                    <form:input type="text" path="id" class="inputField" readonly="true" value="${editCenovnik.id}"/>
                </div>
                <div class="form-group">
                    <form:label path="datumOd">Datum od</form:label>
                    <form:input type="text" path="datumOd" class="inputField"/>
                </div>
                <div class="form-group">
                    <form:label path="datumDo">Datum do</form:label>
                    <form:input type="text" path="datumDo" class="inputField"/>
                </div>
                <br><br>
                <table class="table table-striped wrapRadnici" id="tabelaStavki">
                    <thead class="thead-light">
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

                <div class="form-group">
                    <form:label path="">Oprema</form:label>
                    <form:input type="text" path="" class="inputField"/>
                </div>
                <div class="form-group">
                    <form:label path="">Cena</form:label>
                    <form:input type="text" path="" class="inputField"/>
                </div>
                <div class="form-group">
                    <form:label path="">Jedinica mere</form:label>
                    <form:input type="text" path="" class="inputField"/>
                </div>
                <div class="form-group">
                    <form:label path="">Valuta</form:label>
                    <form:input type="text" path="" class="inputField"/>
                </div>
                <div class="form-group text-center">
                    <button class="btn btnStavka" onClick="dodajRed()">Dodaj stavku</button>  
                </div>

                <div class="form-group text-center">
                    <button type="submit" class="btn btnAdd">Sacuvaj</button>  
                </div> 

            </form:form>
            <div>
                </body>
                </html>

