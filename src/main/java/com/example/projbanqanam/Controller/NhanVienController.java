package com.example.projbanqanam.Controller;

import com.example.projbanqanam.Entity.NhanVien;
import com.example.projbanqanam.Repo.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("nhan-vien")
public class NhanVienController {
    @Autowired
    NhanVienRepository repo;

    @GetMapping("index1")
    public String index(Model model){
        model.addAttribute("data",repo.findAll());
        return "index";
    }

    @GetMapping("search")
    public String search(@RequestParam("manv") String manv, Model model) {
        List<NhanVien> nhanVienList = repo.findByMaNVContaining(manv);
        model.addAttribute("data", nhanVienList);
        return "index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("nhanVien", new NhanVien());
        return "nhan_vien/add";
    }

    @PostMapping("add")
    public String saveNhanVien(NhanVien nhanVien, Model model) {
        if (repo.existsByMaNV(nhanVien.getMaNV())) {
            model.addAttribute("error", "Mã nhân viên đã tồn tại!");
            return "nhan_vien/add";
        }
        repo.save(nhanVien);
        return "redirect:/nhan_vien/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") int id){
        this.repo.deleteById(id);
        return "redirect:/nhan_vien/index";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        NhanVien nv = repo.getById(id);
        model.addAttribute("ct", nv);
        return "nhan_vien/detail";
    }
    @GetMapping("update/{id}")
    public String update(@PathVariable("id") Integer id, Model model) {
        NhanVien nhanVien = repo.findById(id).orElse(null);
        if (nhanVien != null) {
            model.addAttribute("nhanVien", nhanVien);
        }
        return "nhan_vien/update";
    }
    @PostMapping("update/{id}")
    public String updateCustomer(@PathVariable("id") Integer id, @ModelAttribute NhanVien nhanVien) {
        NhanVien existingNhanVien = repo.findById(id).orElse(null);
        if (existingNhanVien != null) {
            existingNhanVien.setTenNV(nhanVien.getTenNV());
            existingNhanVien.setNgaySinh(nhanVien.getNgaySinh());
            existingNhanVien.setGioiTinh(nhanVien.getGioiTinh());
            existingNhanVien.setSdt(nhanVien.getSdt());
            existingNhanVien.setDiaChi(nhanVien.getDiaChi());
            existingNhanVien.setEmail(nhanVien.getEmail());
            existingNhanVien.setTrangThai(nhanVien.getTrangThai());
            repo.save(existingNhanVien);
        }
        return "redirect:/nhan_vien/index";
    }
    @GetMapping("index")
    public String index(Model model,
                        @RequestParam(defaultValue = "1") int page,
                        @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<NhanVien> nhanVienPage = repo.findAll(pageable);

        int totalPages = nhanVienPage.getTotalPages();
        System.out.println("Current Page: " + page);
        System.out.println("Total Pages: " + totalPages);

        model.addAttribute("data", nhanVienPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "nhan_vien/index";
    }

}

