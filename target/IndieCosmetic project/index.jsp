<%@include file="head.jsp"%>
<%@include file="taglib.jsp"%>
<html>
<body class="container">
<div class="card-panel">
    <div class="section center">
        <h1>Elegant Beauty Products</h1>

        <div class="divider"></div>
        <div class="row center">
            <p></p>
<c:choose>
    <c:when test="${empty userName}">
            <a href="logIn">
                <button type="button" class="btn waves-effect waves-blue darken-2">Log in</button>
            </c:when>
    <c:otherwise>
        <h3>Welcome ${userName}</h3>
                <form action="searchProducts" class="form-inline">
                    <input type="hidden" class="" id="userName" name="userName" value="${userName}">
                    <button type="submit" name="submit" class="btn waves-effect waves-blue darken-2">View Products Detail
                    </button>
    </c:otherwise>
</c:choose>
</body>
</html>