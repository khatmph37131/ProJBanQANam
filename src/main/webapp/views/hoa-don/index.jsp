<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0px 100px 100px 100px;
        }
        table {
            border-collapse: collapse;
            width: 100%;
        }

        table, th, td {
            border: 1px solid black;
        }

        th, td {
            padding: 2px;

        }
    </style>
</head>
<body>
<h1 style="text-align: center">Danh sách hóa đơn</h1>
<br>
<br>
<input type="date">
<table>
    <thead>
    <tr>
        <td>ID Hóa Đơn</td>
        <td>Mã Hóa Đơn</td>
        <td>ID Khách Hàng</td>
        <td>ID Nhân Viên</td>
        <td>ID Thanh Toán</td>
        <td>ID Voucher</td>
        <td>Giảm Giá</td>
        <td>Tổng Tiền</td>
        <td>Trạng Thái Đơn Hàng</td>
        <td>Trạng Thái</td>
        <td>Không biết viết gì...</td>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${page}" var="c">
            <tr>
                <td>${c.id}</td>
                <td>${c.mahd}</td>
                <td>${c.khachHang.ten}</td>
                <td>${c.IDNHANVIEN}</td>
                <td>${c.IDTHANHTOAN}</td>
                <td>${c.IDVOUCHER}</td>
                <td>${c.GIAMGIA}</td>
                <td>${c.TONGTIEN}</td>
                <td>${c.TRANGTHAIDONHANG}</td>
                <td>${c.TRANGTHAI == 1 ?"còn hàng":"hết hàng"}</td>
                <td >
                    <a href="/hoa-don/delete/{id}" class="btn btn-warning">Sửa</a>
                    <a href="/hoa-don/delete/${c.id}"  class="btn btn-danger" style="color: white">Xóa</a>
                </td>
<%--                <td>${c.customers.name}</td>--%>
<%--                <td>${c.customers.address}</td>--%>
<%--                <td>${c.note}</td>--%>
<%--                <td>${c.shipping_address}</td>--%>
<%--                <td>${c.total}</td>--%>
<%--                <td>--%>
<%--                    <a href="/order/detail/${c.id}">detail</a>--%>
<%--                </td>--%>
<%--            </tr>--%>
        </c:forEach>

    </tbody>
</table>


<a href="/hoa-don/add" class="btn btn-primary">Thêm Hóa Đơn</a>

</body>
</html>