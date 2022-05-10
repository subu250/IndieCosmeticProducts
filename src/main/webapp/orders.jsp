<%@include file="taglib.jsp"%>
<%@include file="head.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Orders</title>
<body class="container">
<div class="card-panel">
    <div class="section center">
        <h1>My Orders</h1>
        <table class="table" id="ordersTable">
            <thead>
            <th>Order Description</th>
            <th></th>
            <th></th>
            </thead>
            <tbody>
            <c:forEach var="order" items="${orders}">
                <form action="orderInfo" class="" method="post">
                    <tr>
                        <td>${order.name}</td>
                        <td><input type="hidden" class="" id="orderID" name="orderID" value="${order.id}"></td>
                        <td>
                            <button type="submit" name="submit" class="btn-small waves-effect waves-blue">View</button>
                        </td>
                    </tr>
                </form>
            </c:forEach>
            </tbody>
        </table>

    </div>
    <div class="row center">
        <a href="addProduct.jsp">
            <button type="button" class="btn waves-effect waves-blue">Add Product</button>
        </a>
    </div>
</div>
</body>
</html>
