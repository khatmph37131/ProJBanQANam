package com.example.projbanqanam.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HOADON")
public class HoaDon {

    @Id
    @Column(name = "IDHOADON")  // Đảm bảo cột này tồn tại

    @GeneratedValue(strategy = GenerationType.IDENTITY) // hoặc GenerationType.AUTO
    private Long id; // Hoặc thay đổi tên trường thành mahoadon nếu phù hợp

    @Column(name = "MAHD")
    private String mahd;

//    @Column(name = "IDKHACHHANG")
//    private int IDKHACHHANG;
//@ManyToOne
//@JoinColumn(name = "IDKHACHHANG", referencedColumnName = "IDKHACHHANG")
//private KhachHang khachHang;
    @ManyToOne
    @JoinColumn(name = "IDKHACHHANG", referencedColumnName = "IDKHACHHANG", nullable = false)
    private KhachHang khachHang;

    @Column(name = "IDNHANVIEN")
    private int IDNHANVIEN;

    @Column(name = "IDTHANHTOAN")
    private int IDTHANHTOAN;

    @Column(name = "IDVOUCHER")
    private int IDVOUCHER;

    @Column(name = "GIAMGIA")
    private int GIAMGIA;

    @Column(name = "TONGTIEN")
    private int TONGTIEN;

    @Column(name = "TRANGTHAIDONHANG")
    private String TRANGTHAIDONHANG;

    @Column(name = "TRANGTHAI")
    private String TRANGTHAI;


}
