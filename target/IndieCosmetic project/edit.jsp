<%@include file="taglib.jsp"%>
<c:set var="title" value="Add/Edit Product" />
<%@include file="head.jsp"%>

<html>
<body>

<p><p></p>
<div class="container-fluid">
    <h2>Add/Edit Product</h2><br/>
    <form id="editProductForm" role="form" data-toggle="validator"
          class="form-horizontal"
          action="editProduct"
          method="POST">

        <input type="hidden" id="id"
               name="id"
               value = ${product.id}>

        <div class="form-group">
            <label class="control-label col-sm-2" for="brand">Brand</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="brand"
                       name="brand"
                       value = "${product.brand}"
                       data-error="Please enter the product's name." required>
            </div>
            <div class="help-block with-errors"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="category">Category</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="category"
                       name="category"
                       value = "${product.category}"
                       data-error="Please enter the category name."
                       required>
            </div>
            <div class="help-block with-errors"></div>
        </div>

        <button type="submit" class="btn btn-default col-sm-offset-3"
                data-disable="true">Add
        </button>
        <button type="reset" class="btn btn-default">Clear</button>
        <a href ="searchUser?searchTerm=&submit=viewAll"><button type="button" class="btn btn-default">Cancel</button></a>
    </form>
</div>
</body>
</html>
