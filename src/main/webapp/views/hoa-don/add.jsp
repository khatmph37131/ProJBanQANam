<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="/hoa-don/save" method="post">
    <p>id hoa don <input type="text" name="id"></p>
    <p>ma hoa don <input type="text" name="mahd"></p>
<%--    <p>id khach hang <input type="text" name="IDKHACHHANG"></p>--%>
<%--    <p>id khach hang<select class="form-control" id="IDKHACHHANG" name="IDKHACHHANG">--%>
<%--        <c:forEach items="${data}" var="kh">--%>
<%--            <option value="${kh.IDKHACHHANG}">${kh.TENKH}</option>--%>
<%--        </c:forEach>--%>
<%--    </select>--%>
    <p>id khach hang
        <select class="form-control" id="IDKHACHHANG" name="IDKHACHHANG">
            <c:forEach items="${leuleu}" var="kh">
                <option value="${kh.id}">${kh.ten}</option>
            </c:forEach>
        </select>
    </p>


    <p>id nhan vien <input type="text" name="IDNHANVIEN"></p>
    <p>id thanh toan <input type="text" name="IDTHANHTOAN"></p>
    <p>id voucher <input type="text" name="IDVOUCHER"></p>
    <p>giam gia <input type="number" name="GIAMGIA"></p>
    <p>tong tien <input type="number" name="TONGTIEN"></p>
    <p>trang thai don hang <select class="form-control" id="TRANGTHAIDONHANG" name="TRANGTHAIDONHANG">
        <option value="Ðang chờ thanh toán">Ðang chờ thanh toán</option>
        <option value="	Hoàn thành">Hoàn thành</option>
    </select>
    <p>trang thai<select class="form-control" id="TRANGTHAI" name="TRANGTHAI">
        <option value="true">Còn hàng</option>
        <option value="false">Hết hàng</option>
    </select>
    </p>

    <button type="submit">Save</button>
</form>