package com.example.projbanqanam.Repo;


import com.example.projbanqanam.Entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {

    List<NhanVien> findByMaNVContaining(String maNV);

    boolean existsByMaNV(String maNV);
}
