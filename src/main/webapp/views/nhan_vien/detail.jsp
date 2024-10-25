<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nhân Viên Chi Tiết</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="card">
        <div class="card-header">
            Nhân Viên Chi Tiết
        </div>
        <div class="card-body">
            <div class="mb-3">
                <label for="maNV" class="form-label">Mã nhân viên:</label>
                <input type="text" class="form-control" id="maNV" value="${ct.maNV}" readonly>
            </div>
            <div class="mb-3">
                <label for="tenNV" class="form-label">Tên nhân viên:</label>
                <input type="text" class="form-control" id="tenNV" value="${ct.tenNV}" readonly>
            </div>
            <div class="mb-3">
                <label for="ngaySinh" class="form-label">Ngày sinh:</label>
                <input type="text" class="form-control" id="ngaySinh" value="${ct.ngaySinh}" readonly>
            </div>
            <div class="mb-3">
                <label for="gioiTinh" class="form-label">Giới tính:</label>
                <input type="text" class="form-control" id="gioiTinh" value="${ct.gioiTinh}" readonly>
            </div>
            <div class="mb-3">
                <label for="sdt" class="form-label">Số điện thoại:</label>
                <input type="text" class="form-control" id="sdt" value="${ct.sdt}" readonly>
            </div>
            <div class="mb-3">
                <label for="diaChi" class="form-label">Địa chỉ:</label>
                <input type="text" class="form-control" id="diaChi" value="${ct.diaChi}" readonly>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email:</label>
                <input type="text" class="form-control" id="email" value="${ct.email}" readonly>
            </div>
            <div class="mb-3">
                <label for="trangThai" class="form-label">Trạng thái:</label>
                <input type="text" class="form-control" id="trangThai" value="${ct.trangThai == 1 ? 'Đang Làm' : 'Nghỉ Làm'}" readonly>
            </div>
            <div class="text-end
">
                <a href="/nhan-vien/index" class="btn btn-dark">Quay lại</a>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
