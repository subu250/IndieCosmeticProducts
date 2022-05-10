<%--
  Created by IntelliJ IDEA.
  User: subu
  Date: 4/26/22
  Time: 8:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<c:import url="head.jsp"/>

</head>
<html>
<!-- Breadcrumb Start -->
<div class="breadcrumb-wrap">
    <div class="container-fluid">
        <ul class="breadcrumb">
            <li class="breadcrumb-item"><a href="about.jsp">About</a></li>
            <li class="breadcrumb-item"><a href="catalog">Catalog</a></li>
            <li class="breadcrumb-item active">Product Information</li>
        </ul>
    </div>
</div>
<!-- Product Info  -->
<div class="product-info">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-8">
                <div class="product-info-top">
                    <div class="row align-items-center">
                        <div class="col-md-5">
                            <div class="product-slider-single normal-slider">
                            </div>
                             </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
    <h2>Product Information</h2>
<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#productTable').DataTable();
    } );

</script>

  <form action="searchProducts" class="form-inline">
        <table id="productTable" class="display" cellspacing="0" width="100%">

            <thead>
            <th>Brand</th>
            <th>Category</th>
            <th>Price</th>

            </thead>
            <tbody>

            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.brand}</td>
                    <td>${product.category}</td>
                    <td>${product.price}</td>
                    <c:forEach var="order" items="${user.orders}">
                        ${order.id} ${order.description}<br/>
                    </c:forEach>

                    </c:forEach>
            </tbody>
        </table>
      <div class="product-price">
          <h3>${product.price}</h3>
          <a class="btn" href=""><i class="fa fa-shopping-cart"></i>Add Product</a>
      </div>
      <class="row center"></class>
      <button type="button" class="btn waves-effect waves-blue">Add Product</button>
      </a>
    </form>

</div>


</html>
