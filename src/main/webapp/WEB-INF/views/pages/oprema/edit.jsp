<%-- 
    Document   : edit
    Created on : Jun 22, 2019, 10:28:39 AM
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
        <title>JSP izmena opreme</title>

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
            <form:form method="POST" action="/WebAppIznajmljivanjeSportskeOpreme/oprema/saveEdit" modelAttribute="editOprema" class="formAdd">
                <h2 class="text-center h2">Izmena opreme</h2>
                <div class="form-group">
                    <form:label path="id">Id</form:label>
                    <form:input path="id" class="inputField" value="${editOprema.id}" readonly="true"/> <form:errors path="slika"/>
                </div>
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
                    <form:textarea path="opis" class="inputField" value="${editOprema.opis}"/> <form:errors path="opis"/>
                </div>
                <div class="form-group">
                    <form:label path="slika">Slika</form:label>
                    <form:input path="slika" class="inputField" value="${editOprema.slika}"/> <form:errors path="slika"/>
                </div>
                <div class="form-group">
                    <form:label path="naStanju">Na stanju</form:label>
                    <form:input path="naStanju" class="inputField" value="${editOprema.naStanju}"/> <form:errors path="naStanju"/>
                </div>
                <div class="form-group text-center">
                    <button type="submit" class="btn btnAdd">Izmeni</button>  
                </div> 

            </form:form>
            <div>
    </body>
</html>
