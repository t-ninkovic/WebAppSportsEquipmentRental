<%-- 
    Document   : headerKlijent
    Created on : Jun 21, 2019, 10:32:49 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<nav class="navbar">
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
                <li><a href="/WebAppIznajmljivanjeSportskeOpreme/welcome">Početna</a></li>
                <li><a href="/WebAppIznajmljivanjeSportskeOpreme/oprema/all">Pretraži opremu</a></li>
                <li><a href="/WebAppIznajmljivanjeSportskeOpreme/iznajmljivanje/all">Vaša iznajmljivanja</a></li>
                <li><a href="/WebAppIznajmljivanjeSportskeOpreme/cenovnik/view">Cenovnik</a></li>
                <li><a href="/WebAppIznajmljivanjeSportskeOpreme/logout">Logout</a></li>
            </ul>
        </div>
    </div>
</nav>
