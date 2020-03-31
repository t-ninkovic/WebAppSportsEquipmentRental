<%-- 
    Document   : headerRadnik
    Created on : Jun 21, 2019, 10:33:04 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<nav class="navbar sticky-top">
    <div class="containter-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigacija">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse" id="navigacija">
            <ul class="nav navbar-nav navbar-right">
                <li><a class="myNav" href="/WebAppIznajmljivanjeSportskeOpreme/welcome">Početna</a></li>
                <li><a class="myNav" href="/WebAppIznajmljivanjeSportskeOpreme/oprema/all">Pretraži opremu</a></li>
                <li><a class="myNav" href="/WebAppIznajmljivanjeSportskeOpreme/oprema/add">Dodaj opremu</a></li>
                <li><a class="myNav" href="/WebAppIznajmljivanjeSportskeOpreme/korisnik/all">Pretraži korisnike</a></li>
                <li><a class="myNav" href="/WebAppIznajmljivanjeSportskeOpreme/iznajmljivanje/all">Aktivna iznajmljivanja</a></li>
                <li><a class="myNav" href="/WebAppIznajmljivanjeSportskeOpreme/cenovnik/view">Cenovnik</a></li>
                <li><a class="myNav" href="/WebAppIznajmljivanjeSportskeOpreme/logout">Logout</a></li>
            </ul>
        </div>
    </div>
</nav>