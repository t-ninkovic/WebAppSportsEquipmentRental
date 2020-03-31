<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:if test="${exception ne null}">
    <div class="error">${exception.message}</div>
</c:if>

<form:form method="POST" action="/WebAppIznajmljivanjeSportskeOpreme/proizvodjac/save" modelAttribute="proizvodjac">
    <fieldset>
        <legend>Dodavanje novog proizvodjaca</legend>
        <table>
            <tr>
                <td><form:label path="naziv">Naziv</form:label></td>
                <td><form:input path="naziv"/> <form:errors path="naziv"/> </td>
            </tr>
            <tr><td colspan="2" align="center">
                    <button id="save">Save</button>
                </td></tr>
        </table>
    </fieldset>
</form:form>