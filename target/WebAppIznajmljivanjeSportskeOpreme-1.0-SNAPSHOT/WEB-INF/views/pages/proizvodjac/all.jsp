<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP pregled svih proizvodjaca!</title>
    </head>
    <body>
        <h1>Pregled proizvodjaca</h1>
        <table class="table table-striped">
            <tr>
                <th>Id</th>
                <th>Naziv</th>
                <th>Action</th>
            </tr>
            
            <c:forEach items="${proizvodjaci}" var="proizvodjac"> 
                <tr>
                    <td>${proizvodjac.id}</td>
                    <td>${proizvodjac.naziv}</td>
                    <td>
                        <a href="/WebAppIznajmljivanjeSportskeOpreme/proizvodjac/get/${proizvodjac.id}">[View]</a>
                        <a href="/WebAppIznajmljivanjeSportskeOpreme/proizvodjac/delete/${proizvodjac.id}">[Delete]</a>
                    </td>
                    
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
