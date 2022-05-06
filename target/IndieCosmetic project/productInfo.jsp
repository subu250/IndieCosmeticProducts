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
            <li class="breadcrumb-item"><a href="about">About</a></li>
            <li class="breadcrumb-item"><a href="#">Products</a></li>
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
<div class="col-md-7">
    <div class="product-content">
        <div class="title"><h2>${product.brand}</h2></div>
        <div class="ratting">
            <i class="fa fa-star"></i>
            <i class="fa fa-star"></i>
            <i class="fa fa-star"></i>
            <i class="fa fa-star"></i>
            <i class="fa fa-star"></i>
        </div>
    </div>
</div>


</html>
