<%--
  Created by IntelliJ IDEA.
  User: subu
  Date: 3/28/22
  Time: 8:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <title>Products</title>
    <table class="table" id="productsTable">

<thead>
<th>Product Name</th>
<th></th>
<th></th>
</thead>
<tbody>
<c:forEach var="product" items="${products}">
    <form action="productIno" class="" method="post">
        <tr>
            <td>${product.name}</td>
            <td><input type="hidden" class="" id="productID" name="productID" value="${product.id}"></td>
            <td>
                <button type="submit" name="submit" class="btn-small waves-effect waves-blue">View Product</button>
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