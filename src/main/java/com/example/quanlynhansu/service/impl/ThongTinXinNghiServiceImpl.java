package com.example.quanlynhansu.service.impl;


import com.example.quanlynhansu.model.ThongTinXinNghi;
import com.example.quanlynhansu.repository.ThongTinXinNghiRepository;
import com.example.quanlynhansu.service.ThongTinXinNghiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThongTinXinNghiServiceImpl implements ThongTinXinNghiService {

    @Autowired
    private ThongTinXinNghiRepository thongTinXinNghiRepository;

    @Override
    public List<ThongTinXinNghi> getAllThongTinXinNghi() {
        return thongTinXinNghiRepository.findAll();
    }

    @Override
    public ThongTinXinNghi getThongTinXinNghiById(Long id) {
        return thongTinXinNghiRepository.findById(id).orElse(null);
    }

    @Override
    public List<ThongTinXinNghi> getThongTinXinNghiByNgay(int ngay) {
        return thongTinXinNghiRepository.findByNgaySua(ngay);
    }

    @Override
    public ThongTinXinNghi addThongTinXinNghi(ThongTinXinNghi thongTinXinNghi) {
        return thongTinXinNghiRepository.save(thongTinXinNghi);
    }

    @Override
    public ThongTinXinNghi updateThongTinXinNghi(ThongTinXinNghi thongTinXinNghi) {
        ThongTinXinNghi existing = thongTinXinNghiRepository.findById(thongTinXinNghi.getId()).orElse(null);
        if (existing != null) {
            existing.setNgayBatDau(thongTinXinNghi.getNgayBatDau());
            existing.setNgayKetThuc(thongTinXinNghi.getNgayKetThuc());
            existing.setLyDo(thongTinXinNghi.getLyDo());
            existing.setTrangThai(thongTinXinNghi.getTrangThai());
            existing.setNhanVien(thongTinXinNghi.getNhanVien());
            existing.setPhuTrach(thongTinXinNghi.getPhuTrach());
            return thongTinXinNghiRepository.save(existing);
        } else {
            return null;
        }
    }
}
