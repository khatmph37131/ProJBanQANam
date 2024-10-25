<%@page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lifestyle Shop</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- FontAwesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>


<div class="content" id="content">
    <div class="container mt-5 pt-5">
        <h2 class="text-center">Danh sách nhân viên</h2>


        <form action="/nhan-vien/search" method="get" class="d-flex justify-content-between mb-4">
            <div class="flex-grow-1 pe-2">
                <input type="text" name="maNV" class="form-control" placeholder="Nhập mã nhân viên">
            </div>
            <button type="submit" class="btn btn-info">Tìm kiếm</button>
        </form>

        <div class="container mb-3">
            <a href="/nhan-vien/add" class="btn btn-info">Thêm nhân viên</a>
        </div>


        <table class="table mt-4" id="customerTable">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Mã nhân viên</th>
                <th scope="col">Tên nhân viên</th>
                <th scope="col">Ngày sinh</th>
                <th scope="col">Giới tính</th>
                <th scope="col">Số điện thoại</th>
                <th scope="col">Địa chỉ</th>
                <th scope="col">Email</th>
                <th scope="col">Trạng thái</th>
                <th scope="col">Hành động</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${data}" var="nv">
                <tr>
                    <td>${nv.id}</td>
                    <td>${nv.maNV}</td>
                    <td>${nv.tenNV}</td>
                    <td>${nv.ngaySinh}</td>
                    <td>${nv.gioiTinh}</td>
                    <td>${nv.sdt}</td>
                    <td>${nv.diaChi}</td>
                    <td>${nv.email}</td>
                    <td>${nv.trangThai == 1 ? "Active" : "Inactive"}</td>

                    <td>
                        <a href="update/${nv.id}">
                            <button class="btn btn-warning">
                                <i class="fas fa-edit"></i>
                            </button>
                        </a>
                        <a href="detail/${nv.id}">
                            <button class="btn btn-primary">
                                <i class="fas fa-info-circle"></i>
                            </button>
                        </a>
                        <a href="delete/${nv.id}">
                            <button class="btn btn-danger">
                                <i class="fas fa-trash-alt"></i>
                            </button>
                        </a>
                    </td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="pagination mt-4">
            <nav aria-label="Page navigation">
                <ul class="pagination justify-content-center">
                    <c:if test="${currentPage > 1}">
                        <li class="page-item">
                            <a class="page-link" href="?page=${currentPage - 1}&size=10" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <c:forEach var="i" begin="1" end="${totalPages}">
                        <li class="page-item ${i == currentPage ? 'active' : ''}">
                            <a class="page-link" href="?page=${i}&size=10">${i}</a>
                        </li>
                    </c:forEach>
                    <c:if test="${currentPage < totalPages}">
                        <li class="page-item">
                            <a class="page-link" href="?page=${currentPage + 1}&size=10" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                </ul>
            </nav>
        </div>

    </div>

</div>

<script>
    function toggleSidebar() {
        document.getElementById('sidebar').classList.toggle('collapsed');
        document.getElementById('content').classList.toggle('collapsed');
        document.querySelector('.navbar').classList.toggle('collapsed');
    }

    function searchCustomer() {
        var input, filter, table, tr, td, i, txtValue;
        input = document.getElementById("searchInput");
        filter = input.value.toUpperCase();
        table = document.getElementById("customerTable");
        tr = table.getElementsByTagName("tr");

        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[0];
            if (td) {
                txtValue = td.textContent || td.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }
</script>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
