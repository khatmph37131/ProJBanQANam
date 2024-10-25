package com.example.projbanqanam.Service;

import com.example.projbanqanam.Entity.HoaDon;

import java.util.List;

public interface HoaDonService {
    List<HoaDon> getAll();

//    Page<HoaDon> getAll(int page);

    public void saveHoaDon(HoaDon hoaDon);


    public void deleteHoaDon(String id);

    public void CustomersDetail(String id);


}
