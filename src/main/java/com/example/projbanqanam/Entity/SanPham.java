package com.example.projbanqanam.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SANPHAM")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDSANPHAM")
    Integer id;

    @Column(name = "MASP")
    String ma;

    @Column(name = "TENSP")
    String ten;

    @Column(name = "LOAI")
    String loai;

    @Column(name = "TRANGTHAI")
    Boolean trangThai;


}
