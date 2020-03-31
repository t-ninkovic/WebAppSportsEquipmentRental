<%-- 
    Document   : edit
    Created on : Jul 1, 2019, 11:52:27 AM
    Author     : HP
--%>

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
        <c:if test="${tip == 'radnik'}">
            <%@ include file="../headerRadnik.jsp"%>
        </c:if>
        <c:if test="${tip == 'klijent'}">
            <%@ include file="../headerKlijent.jsp"%>
        </c:if>
        <div class="container">
            <form:form method="POST" action="/WebAppIznajmljivanjeSportskeOpreme/iznajmljivanje/saveEdit" modelAttribute="editIzn" class="formAdd">
                <h2 class="text-center h2">Popunite podatke o iznajmljivanju</h2>
                <div class="form-group">
                    <form:label path="id">Id</form:label>
                    <form:input path="id" class="inputField" readonly="true" value="${editIzn.id}"/> 
                </div>
                <div class="form-group">
                    <form:label path="oprema">Oprema</form:label>
                    <form:input path="oprema.id" class="inputField" readonly="true" value="${editIzn.oprema.id}"/> 
                </div>
                <c:if test="${tip == 'radnik'}">
                    <div class="form-group">
                        <form:label path="klijent">Klijent</form:label>
                        <form:select path="klijent.id" items="${klijenti}" itemValue="id" itemLabel="ime" class="inputField"/>
                    </div>
                    <div class="form-group">
                        <form:label path="radnik">Radnik</form:label>
                        <form:input path="radnik.id" class="inputField" readonly="true" value="${editIzn.radnik.id}"/> 
                    </div>
                </c:if>
                <c:if test="${tip == 'klijent'}">
                    <div class="form-group">
                        <form:label path="klijent">Klijent</form:label>
                        <form:input path="klijent.id" class="inputField" readonly="true" value="${editIzn.klijent.id}"/> 
                    </div>
                </c:if>
                <div class="form-group">
                    <form:label path="status">Status</form:label>
                    <form:input path="status" class="inputField" readonly="true"/> 
                </div>
                <div class="form-group">
                    <form:label path="datumOd">Datum od</form:label>
                    <form:input type="text" path="datumOd" class="inputField"/>
                </div>
                <div class="form-group">
                    <form:label path="datumDo">Datum do</form:label>
                    <form:input type="text" path="datumDo" class="inputField"/>
                </div>
                
                <div class="form-group text-center">
                    <button type="submit" class="btn btnAdd">Sacuvaj</button>  
                </div> 

            </form:form>
            <div>
                </body>
                </html>

