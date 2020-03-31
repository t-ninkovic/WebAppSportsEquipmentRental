<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:if test="${exception ne null}">
    <div class="error">${exception.message}</div>
</c:if>

<form:form method="GET" modelAttribute="viewProizvodjac">
    <fieldset>
        <legend>Pregled proizvodjaca</legend>
        <table>
            <tr>
                <td><form:label path="naziv">Naziv proizvodjaca</form:label></td>
                <td><form:input path="naziv" readonly="true"/></td>
            </tr>
        </table>
    </fieldset>
</form:form>