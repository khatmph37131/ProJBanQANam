package com.example.projbanqanam.Repo;

import com.example.projbanqanam.Entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhachHangRepo extends JpaRepository<KhachHang, Integer> {
    // -- Tìm kiếm --
    List<KhachHang> findByMakhContaining(String makh);
    // Check trùng mã khách hàng
    boolean existsByMakh(String makh);
    }

