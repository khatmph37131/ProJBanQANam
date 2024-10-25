<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm sản phẩm</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script>
        function confirmAdd() {
            return confirm("Bạn có chắc chắn muốn thêm sản phẩm này không?");
        }
    </script>
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center">Thêm sản phẩm mới</h2>

    <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
    </c:if>

    <c:if test="${not empty success}">
        <div class="alert alert-success">${success}</div>
    </c:if>

    <form action="/san-pham/them" method="post" onsubmit="return confirmAdd();">
        <div class="form-group">
            <label for="ma">Mã sản phẩm</label>
            <input type="text" class="form-control" id="ma" name="ma" placeholder="Mã sản phẩm" required>
        </div>
        <div class="form-group">
            <label for="ten">Tên sản phẩm</label>
            <input type="text" class="form-control" id="ten" name="ten" placeholder="Tên sản phẩm" required>
        </div>
        <div class="form-group">
            <label for="loai">Loại sản phẩm</label>
            <input type="text" class="form-control" id="loai" name="loai" placeholder="Loại sản phẩm" required>
        </div>
        <div class="form-group">
            <label for="trangThai">Trạng thái</label>
            <select class="form-control" id="trangThai" name="trangThai">
                <option value="true">Còn hàng</option>
                <option value="false">Hết hàng</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Thêm sản phẩm</button>
        <a href="/san-pham/hien-thi" class="btn btn-secondary">Quay lại</a>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>