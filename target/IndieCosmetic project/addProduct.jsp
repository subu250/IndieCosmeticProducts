<%--
  Created by IntelliJ IDEA.
  User: subu
  Date: 5/8/22
  Time: 9:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="head.jsp" %>

<html>
<body class="container">
<div class="card-panel">
    <h1>Add Product</h1>
    <form action="/addProduct" class="" method="post">
        <div class="input-field">
            <input type="hidden" class="" id="productID" name="productID" value="${product.id}">
            <input type="text" class="validate" required="" aria-required="true" id="brand"
                   name="brand" aria-describedby="brand" placeholder="Brand">
        </div>
        <div class="input-field">
            <input type="text" class="" id="category" name="category" class="validate" required=""
                   aria-required="true"
                   aria-describedby="category" placeholder="Category">
        </div>
        <button type="submit" name="submit" value="addProduct" class="btn waves-effect waves-blue">Add Product
        </button>
        <p class="error">
            <c:forEach var="err" items="${errMsg}">
                <c:out value="${err}"/>
                <br/>
            </c:forEach>
        </p>
    </form>
</div>
</body>
</html>