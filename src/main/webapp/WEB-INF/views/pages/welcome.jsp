<%-- 
    Document   : welcome
    Created on : Jun 17, 2019, 5:51:00 PM
    Author     : HP
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            <%@ include file="css/bootstrap.min.css"%>
            <%@ include file="css/style.css"%>
        </style>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <script>
            <%@include file="js/bootstrap.min.js" %>
        </script>
    </head>
    <body>
        <c:if test="${tip == 'radnik'}">
            <%@ include file="headerRadnik.jsp"%>
            <div class="container">
                <div class="row text-center">

                    <div class="col-12 wrapProfil">
                        <h3 class="myHeading">Ime i prezime: Tijana Ninković</h3>
                        <h3 class="myHeading">Uloga: radnik</h3>
                        <h4 class="myHeading">Broj radne knjižice: 123456</h4>
                        <h4 class="myHeading">Datum zaposlenja: 2018-09-06</h4>
                    </div>
                </div>
            </div>

        </c:if>
        <c:if test="${tip == 'klijent'}">
            <%@ include file="headerKlijent.jsp"%>
            <h1> Zdravo klijentu </h1>
        </c:if>


        <script>
            <%@ include file="js/bootstrap.min.js"%>
        </script>
    </body>
</html>
<!--
        <div class="container">
  <div class="row">
    <div class="col-lg-12">
      <div class="alert alert-danger" role="alert">
        <div class="row vertical-align">
          <div class="col-xs-1 text-center">
            <i class="fa fa-exclamation-triangle fa-2x"></i> 
          </div>
          <div class="col-xs-11">
              Sistem ne može da pronađe iznajmljivanje
          </div>
        </div>
      </div>      
    </div>
  </div>  

                    <div class="container">
  <div class="row">
    <div class="col-lg-12">
      <div class="alert alert-danger" role="alert">
        <div class="row vertical-align">
          <div class="col-xs-1 text-center">
            <i class="fa fa-exclamation-triangle fa-2x"></i> 
          </div>
          <div class="col-xs-11">
              Sistem ne može da pronađe iznajmljivanja
          </div>
        </div>
      </div>      
    </div>
  </div> 
            
  <div class="row">
    <div class="col-lg-12">
      <div class="alert alert-success" role="alert">
        <div class="row vertical-align">
          <div class="col-xs-1 text-center">
            <i class="fa fa-check fa-2x"></i> 
          </div>
          <div class="col-xs-11">
              Sistem je uspešno pronađe iznajmljivanje
          </div>
        </div>
      </div>      
    </div>
  </div>    
            
            
  

    </body>
</html>

-->

<%-- 
<c:if test="${tip == 'radnik'}">

    <%@ include file="headerRadnik.jsp"%>

    <h1>Zdravo radnice</h1>

</c:if>
<c:if test="${tip == 'klijent'}">
    <%@ include file="headerKlijent.jsp"%>

    <h1>Zdravo klijentu</h1>

</c:if>
<c:if test="${tip == 'pogresan'}">
    <%@ include file="headerBasic.jsp"%>

    <h1>Niste ulogovani</h1>

</c:if>
--%>