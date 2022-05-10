<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="head.jsp"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<script type="text/javascript" class="init">
    $(document).ready(function() {
        $('#catalogTable').DataTable({
            "columnDefs": [
                { "orderable": false, "targets": [3, 5] }
            ]
        });
    });
</script>
<script>
    $(document).ready(function() {
        $('#lightgallery').lightingColor();
    });
</script>

</head>
<body>
<div class="container-fluid">
    <h2>Product Catalog:</h2>
    <table id="catalogTable" class="display" cellspacing="0"
           width="100%">
        <thead>
        <th>Catalog_Id</th>
        <th>Brand</th>
        <th>Category</th>
        <th>Name</th>
        <th>Image</th>
        <th>Price</th>
        <th></th>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${fn:toUpperCase(product.brand)}</td>
                <td>${product.productType}</td>
                <td>${product.name}</td>
                <td><img src=${product.imageLink} alt=${product.description} width="128" height="128"></td>
                <td><fmt:formatNumber value = "${product.price}" type = "currency"/></td>
                <td><button class="btn btn-primary">Add to card</button></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>