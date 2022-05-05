<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#manufactureTable').DataTable();
    } );
</script>
<html>
<body>

<div class="container-fluid">
    <h2>Manufacture Results: </h2>
    <table id="manufactureTable" class="display" cellspacing="0" width="100%">
        <thead>
        <th>ManufactureId</th>
        <th>ManufactureName</th>
        <th>ManufactureCode</th>

        </thead>
        <tbody>
        <c:forEach var="manufacture" items="${manufacture}">
            <tr>
                <td>${manufacture.manufactureId}</td>
                <td>${manufacture.manufactureName}</td>
                <td>${manufacture.manufactureCode}</td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>