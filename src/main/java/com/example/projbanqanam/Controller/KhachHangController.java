package com.example.projbanqanam.Controller;

import com.example.projbanqanam.Entity.KhachHang;
import com.example.projbanqanam.Repo.KhachHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("khach-hang")
public class KhachHangController {

    @Autowired
    KhachHangRepo repo;


    // -- Trang chủ khách hàng --


//    @GetMapping("index")
//    public String index(Model model){
//        model.addAttribute("data",repo.findAll());
//        return "khach_hang/index";
//    }

    // -- Tìm kiếm --

    @GetMapping("search")
    public String search(@RequestParam("makh") String makh, Model model) {
        List<KhachHang> khachHangList = repo.findByMakhContaining(makh);
        model.addAttribute("data", khachHangList);
        return "khach_hang/index";
    }


//    @PostMapping("add")
//    public String saveKhachHang(KhachHang khachHang, Model model) {
//        if (repo.existsByMakh(khachHang.getMakh())) {
//            model.addAttribute("error", "Mã khách hàng đã tồn tại!");
//            return "khach_hang/add";
//        }
//
//        repo.save(khachHang);
//        return "redirect:/khach-hang/index";
//    }

    // -- Thêm khách hàng --


    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("khachHang", new KhachHang());
        return "khach_hang/add";
    }

    @PostMapping("add")
    public String saveKhachHang(KhachHang khachHang, Model model) {
        if (repo.existsByMakh(khachHang.getMakh())) {
            model.addAttribute("error", "Mã khách hàng đã tồn tại!");
            return "khach_hang/add";
        }
        repo.save(khachHang);
        return "redirect:/khach-hang/index";
    }


    // -- Xóa khách hàng --


    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") int id){
        this.repo.deleteById(id);
        return "redirect:/khach-hang/index";
    }

    // -- Chi tiết khách hàng


    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        KhachHang kh = repo.getById(id);
        model.addAttribute("detail", kh);
        return "khach_hang/detail";
    }


    // -- Cập nhật khách hàng --


    @GetMapping("update/{id}")
    public String update(@PathVariable("id") Integer id, Model model) {
        KhachHang khachHang = repo.findById(id).orElse(null);
        if (khachHang != null) {
            model.addAttribute("khachHang", khachHang);
        }
        return "khach_hang/update";
    }
    @PostMapping("update/{id}")
    public String updateCustomer(@PathVariable("id") Integer id, @ModelAttribute KhachHang khachHang) {
        KhachHang existingKhachHang = repo.findById(id).orElse(null);
        if (existingKhachHang != null) {
            existingKhachHang.setTen(khachHang.getTen());
            existingKhachHang.setNgaysinh(khachHang.getNgaysinh());
            existingKhachHang.setGioitinh(khachHang.getGioitinh());
            existingKhachHang.setSdt(khachHang.getSdt());
            existingKhachHang.setDiachi(khachHang.getDiachi());
            existingKhachHang.setEmail(khachHang.getEmail());
            existingKhachHang.setTt(khachHang.getTt());
            repo.save(existingKhachHang);
        }
        return "redirect:/khach-hang/index";
    }

    // -- Phân trang --

    //    @GetMapping("/phan-trang")
//    public List<KhachHang> phanTrang(@RequestParam(defaultValue = "0") int p){
//        Pageable pageable = PageRequest.of(p, 5);
//        Page<KhachHang> page = repo.findAll(pageable);
//        return page.getContent();
//    }
//    @GetMapping("/khach-hang")
//    public String getKhachHangPage(Model model,
//                                   @RequestParam(defaultValue = "1") int page,
//                                   @RequestParam(defaultValue = "5") int size) {
//
//        Pageable pageable = PageRequest.of(page - 1, size); // Trang bắt đầu từ 0
//        Page<KhachHang> khachHangPage = repo.findAll(pageable);
//
//        model.addAttribute("data", khachHangPage.getContent());
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalPages", khachHangPage.getTotalPages());
//        return "khach_hang/index";
//    }
    @GetMapping("index")
    public String index(Model model,
                        @RequestParam(defaultValue = "1") int page,
                        @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<KhachHang> khachHangPage = repo.findAll(pageable);

        int totalPages = khachHangPage.getTotalPages();
        System.out.println("Current Page: " + page);
        System.out.println("Total Pages: " + totalPages);

        model.addAttribute("data", khachHangPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "khach_hang/index";
    }

}

