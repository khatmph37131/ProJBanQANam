//package com.example.projbanqanam.Service.Impl;
//
//
//import com.example.projbanqanam.Entity.HoaDon;
//import com.example.projbanqanam.Repo.HoaDonRepository;
//import com.example.projbanqanam.Service.HoaDonService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//@Service
//@RequiredArgsConstructor
//public class HoaDonServiceImpl implements HoaDonService {
//    @Autowired
//    HoaDonRepository repo;
//
////    private  int PAGE_SIZE = 4;
//
//    @Override
////    public Page<HoaDon> getAll(int page){
////        Sort sort = Sort.by(Sort.Direction.DESC,"id");
////        Pageable pageable = PageRequest.of(page, PAGE_SIZE, sort);
////        return repo.findAll(pageable);
////
////    }
//
//    public List<HoaDon> getAll() {
//        return repo.findAll();
//    }
//
//
//    @Override
//    public void saveHoaDon(HoaDon hoaDon) {
//        repo.save(hoaDon);
//    }
//
//    @Override
//    public void deleteHoaDon(String id) {
//        repo.deleteById(Integer.parseInt(id));
//    }
//
//    @Override
//    public void CustomersDetail(String id) {
//
//    }
//}
