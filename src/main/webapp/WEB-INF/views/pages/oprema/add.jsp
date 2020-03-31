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
        <title>Web aplikacija za iznajmljivanje sportske opreme</title>
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
        <div class="container">
            <form:form method="POST" action="/WebAppIznajmljivanjeSportskeOpreme/oprema/save" modelAttribute="oprema" class="formAdd">
                <h2 class="text-center h2">Dodavanje nove opreme</h2>
                <div class="form-group">
                    <form:label path="proizvodjac">Proizvodjac</form:label>
                    <form:select path="proizvodjac.id" items="${proizvodjaci}" itemValue="id" itemLabel="naziv" class="inputField"/><form:errors path="proizvodjac"/>
                </div>
                <div class="form-group">
                    <form:label path="vrsta">Vrsta opreme</form:label>
                    <form:select path="vrsta.id" items="${vrste}" itemValue="id" itemLabel="naziv" class="inputField"/><form:errors path="vrsta"/>
                </div>
                <div class="form-group">
                    <form:label path="opis">Detaljan opis</form:label>
                    <form:textarea path="opis" class="inputField"/> <form:errors path="opis"/>
                </div>
                <div class="form-group">
                    <form:label path="slika">Slika</form:label>
                    <form:input path="slika" class="inputField"/> <form:errors path="slika"/>
                </div>
                <div class="form-group">
                    <form:label path="naStanju">Na stanju</form:label>
                    <form:input path="naStanju" class="inputField"/> <form:errors path="naStanju"/>
                </div>
                <div class="form-group text-center">
                    <button type="submit" class="btn btnAdd">Sacuvaj</button>  
                </div> 

            </form:form>
            <div>
                </body>
                </html>