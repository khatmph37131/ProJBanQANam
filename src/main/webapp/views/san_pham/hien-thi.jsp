<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách sản phẩm</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        body {
            background-color: #fff3cd; /* Màu vàng nhạt */
            color: black; /* Màu chữ đen để dễ đọc */
        }
        .table {
            background-color: #ffeeba; /* Màu nền cho bảng */
        }
        .alert {
            background-color: #dc3545; /* Màu nền cho alert */
            color: white; /* Màu chữ cho alert */
        }
    </style>
    <script>
        function confirmDelete() {
            return confirm("Bạn có chắc chắn muốn xóa sản phẩm này không?");
        }

        function confirmAdd() {
            return confirm("Bạn có chắc chắn muốn thêm sản phẩm này không?");
        }

        function confirmSearch() {
            return confirm("Bạn có chắc chắn muốn tìm kiếm không?");
        }
    </script>
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center">Danh sách sản phẩm</h2>

    <c:if test="${not empty error}">
        <div class="alert">${error}</div>
    </c:if>
    <a href="/san-pham/them" class="btn btn-primary mb-3">Thêm sản phẩm mới</a>
<%--    <div class="mb-4">--%>
<%--        <h3>Thêm sản phẩm mới</h3>--%>
<%--        <form action="/san-pham/them" method="post" onsubmit="return confirmAdd();" class="form-inline">--%>
<%--            <div class="form-group mb-2">--%>
<%--                <label for="ma" class="sr-only">Mã sản phẩm</label>--%>
<%--                <input type="text" class="form-control" id="ma" name="ma" placeholder="Mã sản phẩm">--%>
<%--            </div>--%>
<%--            <div class="form-group mx-sm-3 mb-2">--%>
<%--                <label for="ten" class="sr-only">Tên sản phẩm</label>--%>
<%--                <input type="text" class="form-control" id="ten" name="ten" placeholder="Tên sản phẩm">--%>
<%--            </div>--%>
<%--            <div class="form-group mx-sm-3 mb-2">--%>
<%--                <label for="loai" class="sr-only">Loại sản phẩm</label>--%>
<%--                <input type="text" class="form-control" id="loai" name="loai" placeholder="Loại sản phẩm">--%>
<%--            </div>--%>
<%--            <div class="form-group mx-sm-3 mb-2">--%>
<%--                <label for="trangThai" class="sr-only">Trạng thái</label>--%>
<%--                <select class="form-control" id="trangThai" name="trangThai">--%>
<%--                    <option value="true">Còn hàng</option>--%>
<%--                    <option value="false">Hết hàng</option>--%>
<%--                </select>--%>
<%--            </div>--%>
<%--            <button type="submit" class="btn btn-primary mb-2">Thêm sản phẩm</button>--%>
<%--        </form>--%>
<%--    </div>--%>

    <div class="mb-4">
        <h3>Tìm kiếm sản phẩm</h3>
        <form action="/san-pham/tim-kiem" method="get" class="form-inline" onsubmit="return confirmSearch();">
            <div class="form-group mb-2">
                <label for="searchMa" class="sr-only">Tìm kiếm theo mã</label>
                <input type="text" class="form-control" id="searchMa" name="searchMa" placeholder="Tìm theo mã">
            </div>
            <div class="form-group mx-sm-3 mb-2">
                <label for="searchTen" class="sr-only">Tìm kiếm theo tên</label>
                <input type="text" class="form-control" id="searchTen" name="searchTen" placeholder="Tìm theo tên">
            </div>
            <div class="form-group mx-sm-3 mb-2">
                <label for="searchTrangThai" class="sr-only">Tìm kiếm theo trạng thái</label>
                <select class="form-control" id="searchTrangThai" name="searchTrangThai">
                    <option value="">Tất cả</option>
                    <option value="true">Còn hàng</option>
                    <option value="false">Hết hàng</option>
                </select>
            </div>
            <button type="submit" class="btn btn-success mb-2">Tìm kiếm</button>
        </form>
    </div>

    <c:if test="${not empty list}">
        <table class="table table-bordered">
            <thead class="thead-light">
            <tr>
                <th>ID</th>
                <th>Mã</th>
                <th>Tên</th>
                <th>Loại</th>
                <th>Trạng thái</th>
                <th>Hành động</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="sp">
                <tr>
                    <td>${sp.id}</td>
                    <td>${sp.ma}</td>
                    <td>${sp.ten}</td>
                    <td>${sp.loai}</td>
                    <td>
                        <c:choose>
                            <c:when test="${sp.trangThai}">
                                Còn hàng
                            </c:when>
                            <c:otherwise>
                                Hết hàng
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <form action="/san-pham/xoa/${sp.id}" method="post" onsubmit="return confirmDelete();" class="d-inline">
                            <button type="submit" class="btn btn-danger btn-sm">
                                <i class="fas fa-trash-alt"></i> Xóa
                            </button>
                        </form>
                        <form action="/san-pham/cap-nhat/${sp.id}" method="get" class="d-inline">
                            <button type="submit" class="btn btn-warning btn-sm">
                                <i class="fas fa-edit"></i> Cập nhật
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty list}">
        <div class="alert alert-info">Không có sản phẩm nào phù hợp với tìm kiếm.</div>
    </c:if>

    <a href="/san-pham/hien-thi" class="btn btn-secondary mt-3">Trang chủ</a>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>