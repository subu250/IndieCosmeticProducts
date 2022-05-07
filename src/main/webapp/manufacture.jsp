<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#manufacturerTable').DataTable();
    } );
</script>

<html>
<body>

<div class="container-fluid">
    <h2>Manufacture Results: </h2>
    <table id="manufacturerTable" class="display" cellspacing="0" width="100%">
        <thead>
        <th>ManufacturerId</th>
        <th>ManufacturerName</th>
        <th>ManufacturerCode</th>

        </thead>
        <tbody>
        <c:forEach var="manufacturer" items="${manufacturers}">
            <tr>
                <td>${manufacturer.manufacturerId}</td>
                <td>${manufacturer.manufacturerName}</td>
                <td>${manufacturer.manufacturerCode}</td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script>
    $(document).ready(function(){
        $('#lightgallery').lightingColor();
    });
</script>
</body>
</html>