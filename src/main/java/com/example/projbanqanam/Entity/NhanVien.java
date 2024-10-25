package com.example.projbanqanam.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "NHANVIEN")
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDNHANVIEN")
    Integer id;
    @Column(name = "MANV")
    String maNV;
    @Column(name = "TENNV")
    String tenNV;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "dd-MM-yyyy")
    @Column(name = "NGAYSINH")
    Date ngaySinh;
    @Column(name = "GIOITINH")
    String gioiTinh;
    @Column(name = "SDT")
    String sdt;
    @Column(name = "DIACHI")
    String diaChi;
    @Column(name = "EMAIL")
    String email;
    @Column(name = "CHUCVU")
    String chucVu;
    @Column(name = "MATKHAU")
    String matKhau;
    @Column(name = "TRANGTHAI")
    String trangThai;

}

