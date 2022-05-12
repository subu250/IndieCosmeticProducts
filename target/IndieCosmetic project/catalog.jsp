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

    addToCare = (id) => {
        post('/editProduct/', {"ProductId": id});
        alert(id);
    }

    /**
     * sends a request to the specified url from a form. this will change the window location.
     * @param {string} path the path to send the post request to
     * @param {object} params the parameters to add to the url
     * @param {string} [method=post] the method to use on the form
     */

    function post(path, params, method='post') {


        // It can be made less verbose if you use one.
        const form = document.createElement('form');
        form.method = method;
        form.action = path;

        for (const key in params) {
            if (params.hasOwnProperty(key)) {
                const hiddenField = document.createElement('input');
                hiddenField.type = 'hidden';
                hiddenField.name = key;
                hiddenField.value = params[key];

                form.appendChild(hiddenField);
            }
        }

        document.body.appendChild(form);
        form.submit();
    }
</script>

</head>
<body>
<div class="container-fluid">
    <h2>Product Catalog:</h2>
    <table id="catalogTable" class="display" cellspacing="0"
           width="100%">
        <thead>
        <th>Id</th>
        <th>Brand</th>
        <th>Category</th>
        <th>Name</th>
        <th>Image</th>
        <th>Price</th>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${fn:toUpperCase(product.brand)}</td>
                <td>${product.productType}</td>
                <td>${product.name}</td>
                <td><img src=${product.imageLink} alt=${product.description} width="128" height="128"></td>
                <td><fmt:formatNumber value = "${product.price}" type = "currency"/></td>
                <td><button onClick="addToCart(${product.id})" class="btn btn_primary" />
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>