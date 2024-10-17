package com.example.projbanqanam.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "KHACHHANG")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDKHACHHANG")
    private Integer id;

    @Column(name = "MAKH")
    private String makh;

    @Column(name = "TENKH")
    private String ten;

    @Temporal(TemporalType.DATE)
    @Column(name = "NGAYSINH")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date ngaysinh;

    @Column(name = "GIOITINH")
    private String gioitinh;

    @Column(name = "SDT")
    private String sdt;

    @Column(name = "DIACHI")
    private String diachi;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "MATKHAU")
    private String matkhau;

    @Column(name = "TRANGTHAI")
    private String tt;
}
