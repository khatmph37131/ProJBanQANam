package com.example.projbanqanam.Repo;

import com.example.projbanqanam.Entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SanPhamrepo extends JpaRepository<SanPham, Integer> {


    List<SanPham> findByMaContaining(String ma);
    List<SanPham> findByTenContaining(String ten);
    List<SanPham> findByTrangThai(Boolean trangThai);
    List<SanPham> findByMaContainingAndTrangThai(String ma, Boolean trangThai);
    List<SanPham> findByTenContainingAndTrangThai(String ten, Boolean trangThai);
}
