<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP pregled vrsta!</title>
    </head>
    <body>
        <h1>Pregled vrsta</h1>
        <table class="table table-striped">
            <tr>
                <th>Naziv</th>
            </tr>
            
            <c:forEach items="${vrste}" var="vrsta"> 
                <tr>
                    <td>${vrsta.naziv}</td>
                    <td>
                        <a href="/WebAppIznajmljivanjeSportskeOpreme/proizvodjac/get/${vrsta.id}">[View]</a>
                        <a href="/WebAppIznajmljivanjeSportskeOpreme/proizvodjac/delete/${vrsta.id}">[Delete]</a>
                    </td>
                    
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
