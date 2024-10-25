<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm khách hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div class="container">
    <h2>Thêm Nhân Viên</h2>


    <form action="/nhan-vien/add" method="post">
        <div class="form-group">
            <label for="maNV">Mã nhân viên</label>
            <input type="text" id="maNV" name="maNV" class="form-control" value="${nhanVien.maNV}">
        </div>

        <div class="form-group">
            <label for="tenNV">Tên Nhân Viên</label>
            <input type="text" id="tenNV" name="tenNV" class="form-control" value="${nhanVien.tenNV}">
        </div>

        <div class="form-group">
            <label for="ngaySinh">Ngày sinh</label>
            <input type="date" id="ngaySinh" name="ngaySinh" class="form-control" value="${nhanVien.ngaySinh}">
        </div>

        <div class="form-group">
            <label for="gioiTinh">Giới tính</label>
            <select class="form-control" id="gioiTinh" name="gioiTinh">
                <option value="Nam" ${nhanVien.gioiTinh == 'Nam' ? 'selected' : ''}>Nam</option>
                <option value="Nữ" ${nhanVien.gioiTinh == 'Nữ' ? 'selected' : ''}>Nữ</option>
            </select>
        </div>

        <div class="form-group">
            <label for="sdt">Số điện thoại</label>
            <input type="text" id="sdt" name="sdt" class="form-control" value="${nhanVien.sdt}">
        </div>

        <div class="form-group">
            <label for="diaChi">Địa chỉ</label>
            <input type="text" id="diaChi" name="diaChi" class="form-control" value="${nhanVien.diaChi}">
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" id="email" name="email" class="form-control" value="${nhanVien.email}">
        </div>

        <div class="form-group">
            <label for="matkhau">Mật khẩu</label>
            <input type="password" id="matkhau" name="matkhau" class="form-control" value="${nhanVien.matKhau}">
        </div>

        <div class="form-actions">
            <button type="submit" class="btn">Thêm</button>
            <a href="/nhan-vien/index" class="btn-back">Quay lại</a>
        </div>


    </form>
</div>

</body>
</html>


