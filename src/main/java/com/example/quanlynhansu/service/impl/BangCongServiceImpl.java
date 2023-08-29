package com.example.quanlynhansu.service.impl;

import com.example.quanlynhansu.model.BangCong;
import com.example.quanlynhansu.model.NhanVien;
import com.example.quanlynhansu.repository.BangCongRepository;
import com.example.quanlynhansu.service.BangCongService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BangCongServiceImpl implements BangCongService {

    @Autowired
    private BangCongRepository bangCongRepository;

    @Override
    public BangCong getBangCongById(Long id) {
        return bangCongRepository.findById(id).orElse(null);
    }

    @Override
    public BangCong saveBangCong(BangCong bangCong) {
        return bangCongRepository.save(bangCong);
    }

    @Override
    public void deleteBangCong(Long id) {
        bangCongRepository.deleteById(id);
    }

    @Override
    public int countSoNgayDiLam(NhanVien nhanVien, int thang) {
        return bangCongRepository.countSoNgayDiLam(nhanVien, thang);
    }

    @Override
    public double tinhLuong(NhanVien nhanVien, int thang) {
        int soNgayDiLam = bangCongRepository.countSoNgayDiLam(nhanVien, thang);
        double luongCoBan = nhanVien.getLuongCoBan();
        return soNgayDiLam * luongCoBan;
    }


}
