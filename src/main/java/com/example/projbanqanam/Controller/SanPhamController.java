package com.example.projbanqanam.Controller;

import com.example.projbanqanam.Entity.SanPham;
import com.example.projbanqanam.Repo.SanPhamrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SanPhamController {

    @Autowired
    SanPhamrepo sanPhamrepo;

    // Hiển thị danh sách sản phẩm
    @GetMapping("/san-pham/hien-thi")
    public String hienThiSanPham(Model model) {
        List<SanPham> list = sanPhamrepo.findAll();
        model.addAttribute("list", list);
        return "san_pham/hien-thi";
    }

    // Hiển thị trang thêm sản phẩm
    @GetMapping("/san-pham/them")
    public String showAddForm(Model model) {
        return "them"; // Trả về trang them.jsp
    }

    // Thêm sản phẩm
    @PostMapping("/san-pham/them")
    public String themSanPham(@ModelAttribute SanPham sp, Model model) {
        if (sp.getMa() == null || sp.getMa().isEmpty() ||
                sp.getTen() == null || sp.getTen().isEmpty() ||
                sp.getLoai() == null || sp.getLoai().isEmpty()) {

            model.addAttribute("error", "Vui lòng điền đủ thông tin sản phẩm.");
            return "san_pham/them"; // Quay về trang them.jsp với thông báo lỗi
        }

        sanPhamrepo.save(sp);
        model.addAttribute("success", "Thêm sản phẩm thành công!");
        return "san_pham/them"; // Quay về trang them.jsp với thông báo thành công
    }

    // Xóa sản phẩm
    @PostMapping("/san-pham/xoa/{id}")
    public String xoaSanPham(@PathVariable Integer id) {
        sanPhamrepo.deleteById(id);
        return "redirect:/san-pham/hien-thi"; // Quay về danh sách sản phẩm
    }

    // Hiển thị trang cập nhật sản phẩm
    @GetMapping("/san-pham/cap-nhat/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        SanPham sp = sanPhamrepo.findById(id).orElse(null);
        model.addAttribute("sp", sp);
        return "san_pham/update"; // Trả về trang cập nhật sản phẩm
    }

    // Cập nhật sản phẩm
    @PostMapping("/san-pham/cap-nhat")
    public String updateSanPham(@ModelAttribute SanPham sp) {
        sanPhamrepo.save(sp); // Cập nhật sản phẩm
        return "redirect:/san-pham/hien-thi"; // Quay về danh sách sản phẩm
    }

    // Tìm kiếm sản phẩm
    @GetMapping("/san-pham/tim-kiem")
    public String searchSanPham(@RequestParam(required = false) String searchMa,
                                @RequestParam(required = false) String searchTen,
                                @RequestParam(required = false) String searchTrangThai,
                                Model model) {

        List<SanPham> list;

        // Tìm theo trạng thái
        Boolean trangThai = null;
        if ("true".equals(searchTrangThai)) {
            trangThai = true;
        } else if ("false".equals(searchTrangThai)) {
            trangThai = false;
        }

        // Tìm dựa trên điều kiện
        if (searchMa != null && !searchMa.isEmpty()) {
            list = sanPhamrepo.findByMaContaining(searchMa);
        } else if (searchTen != null && !searchTen.isEmpty()) {
            list = sanPhamrepo.findByTenContaining(searchTen);
        } else if (trangThai != null) {
            list = sanPhamrepo.findByTrangThai(trangThai);
        } else {
            list = sanPhamrepo.findAll(); // Hiển thị tất cả nếu không tìm kiếm
        }

        // Tìm kiếm theo mã, tên, trạng thái thì kết hợp
        if (searchMa != null && !searchMa.isEmpty() && trangThai != null) {
            list = sanPhamrepo.findByMaContainingAndTrangThai(searchMa, trangThai);
        } else if (searchTen != null && !searchTen.isEmpty() && trangThai != null) {
            list = sanPhamrepo.findByTenContainingAndTrangThai(searchTen, trangThai);
        }

        model.addAttribute("list", list);
        return "san_pham/hien-thi"; // Quay về trang danh sách sản phẩm
    }
}