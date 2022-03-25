<%@include file="taglib.jsp"%>

<html><body>

<h2>Search Results: </h2>
<table>
    <tr>
        <th> First Name </th>
        <th> Last Name </th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.firstName} ${user.lastName}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
