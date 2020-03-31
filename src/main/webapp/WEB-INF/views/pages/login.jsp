<%-- 
    Document   : login
    Created on : Jun 20, 2019, 7:01:45 PM
    Author     : HP
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
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
    <body>
        <div class="wrap">
            <%@ include file="headerBasic.jsp"%>

            <form:form method="POST" action="/WebAppIznajmljivanjeSportskeOpreme/welcome" modelAttribute="profil" id="loginForm">
                <div class="imgcontainer">
                    <img src="https://img.pngio.com/parent-directory-avatar-2png-avatar-png-256_256.png" alt="Avatar" class="avatar">
                </div>
                <div class="container">
                    <form:label path="korisnickoIme">Korisnicko ime:</form:label>
                    <form:input placeholder = "Unesite korisnicko ime" path="korisnickoIme" class="inputField"/> 

                    <form:label path="sifra">Sifra:</form:label>
                    <form:input type ="password" placeholder="Unesite sifru" path="sifra" class="inputField"/>

                    <button type="submit" id="loginBtn">Login</button>

                </div

            </form:form>
        </div>


        <script>
            <%@ include file="js/bootstrap.min.js"%>
        </script>
    </body>

</html>

<%--

                <table>

                    <tr>
                        <td><form:label path="korisnickoIme">Korisnicko ime:</form:label></td>
                        <td><form:input placeholder = "Unesite korisnicko ime" path="korisnickoIme"/> </td>
                    </tr>
                    <tr>
                        <td><form:label path="sifra">Sifra:</form:label></td>
                        <td><form:input type ="password" placeholder="Unesite sifru" path="sifra"/></td>
                    </tr>
                    <tr><td colspan="2" align="center">
                            <button id="loginBtn">Login</button>
                        </td></tr>
                </table>

--%>