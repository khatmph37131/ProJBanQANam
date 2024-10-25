//package com.example.projbanqanam.Controller;
//
//import com.example.projbanqanam.Entity.HoaDon;
//import com.example.projbanqanam.Entity.KhachHang;
//import com.example.projbanqanam.Repo.HoaDonRepository;
//import com.example.projbanqanam.Repo.KhachHangRepo;
//import com.example.projbanqanam.Service.HoaDonService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@RequestMapping("/hoa-don")
//public class HoaDonController {
//    @Autowired
//    HoaDonService service;
//
//    @Autowired
//    KhachHangRepo KHrepo;
//
//    @Autowired
//    HoaDonRepository repo;
//
//    @GetMapping("/index")
//    public String getAll(Model model
////            , @RequestParam(name = "page", defaultValue = "0") int page
//    ){
//        model.addAttribute("page"
//                , repo.findAll()
////                , service.getAll(page)
//        );
//
//        return "hoa-don/index";
//    }
//    @GetMapping("/khach")
//    public String index(Model model,
//                        @RequestParam(defaultValue = "1") int page,
//                        @RequestParam(defaultValue = "10") int size) {
//        Pageable pageable = PageRequest.of(page - 1, size);
//        Page<KhachHang> khachHangPage = KHrepo.findAll(pageable);
//
//        int totalPages = khachHangPage.getTotalPages();
//        System.out.println("Current Page: " + page);
//        System.out.println("Total Pages: " + totalPages);
//
//        model.addAttribute("data", khachHangPage.getContent());
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalPages", totalPages);
//        return "khach_hang/index";
//    }
//
//
//
//    @GetMapping("/add")
//    public String addHoaDon(Model model){
//        model.addAttribute("leuleu",KHrepo.findAll());
//        return "hoa-don/add";
//    }
//
//
////    @PostMapping("/save")
////    public String saveHoaDon(HoaDon hoaDon, @RequestParam("IDKHACHHANG") String idKhachHang, Model model){
////        service.saveHoaDon(hoaDon);
////        return "redirect:/hoa-don/index";
////    }
//@PostMapping("/save")
//public String saveHoaDon(HoaDon hoaDon, @RequestParam("IDKHACHHANG") Integer idKhachHang, Model model) {
//    // Tìm khách hàng theo ID
//    KhachHang khachHang = KHrepo.findById(idKhachHang).orElse(null);
//    if (khachHang != null) {
//        hoaDon.setKhachHang(khachHang);  // Gán khách hàng cho hóa đơn
//    } else {
//        // Xử lý trường hợp không tìm thấy khách hàng
//        model.addAttribute("error", "Khách hàng không tồn tại.");
//        return "hoa-don/add"; // Quay lại trang thêm hóa đơn
//    }
//
//    // Lưu hóa đơn
//    service.saveHoaDon(hoaDon);
//    return "redirect:/hoa-don/index";
//}
//    @GetMapping("/delete/{id}")
//    public String deleteHoaDon(@PathVariable("id") String id){
//        service.deleteHoaDon(id);
//        return "redirect:/hoa-don/index";
//    }
////        @GetMapping("/add")
////    public String create(Model model) {
////        model.addAttribute("hoaDon", new HoaDon());
////        return "hoa-don/index";
////    }
//
////    @GetMapping("/create")
////    public String addOrder(){
////        return "order/create";
////
////    }
//
////
////    @GetMapping("/detail/id")
////    public String getDetail(@PathVariable("id") String id, Model model){
////        model.addAttribute("detai", service.get)
////    }
//}
