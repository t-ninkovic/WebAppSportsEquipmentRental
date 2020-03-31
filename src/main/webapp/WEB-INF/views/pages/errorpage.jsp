<%-- 
    Document   : errorpage
    Created on : Jul 2, 2019, 4:47:34 PM
    Author     : HP
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            <%@ include file="css/bootstrap.min.css"%>
            <%@ include file="css/style.css"%>
        </style>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body class="nemaPristup">
        <c:if test="${tip == 'radnik'}">
            <%@ include file="headerRadnik.jsp"%>
        </c:if>
        <c:if test="${tip == 'klijent'}">
            <%@ include file="headerKlijent.jsp"%>
        </c:if>
        <c:if test="${tip == 'pogresan'}">
            <%@ include file="headerBasic.jsp"%>
        </c:if>

        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="error-template">
                        <!--
                        <img src="https://spiderwebsolutions.com.au/wp-content/uploads/2015/11/logo-accessdenied.png">
                        -->
                        <img src="https://www.freeiconspng.com/uploads/error-icon-4.png" style="width:250px; height:auto">
                        <h2>
                            Greska!</h2>
                        <div class="error-details">
                            Promene nisu sacuvane. Niste uneli odgovarajuce podatke.
                        </div>
                        <div class="error-actions">
                            <a href="/WebAppIznajmljivanjeSportskeOpreme/index" class="btn btn-primary btn-lg">
                                <span class="glyphicon glyphicon-home"></span>
                                Povratak na početnu </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script>
            <%@ include file="js/bootstrap.min.js"%>
        </script>
    </body>
</html>
