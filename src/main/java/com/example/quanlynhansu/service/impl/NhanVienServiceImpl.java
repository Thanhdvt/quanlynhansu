package com.example.quanlynhansu.service.impl;

import com.example.quanlynhansu.model.NhanVien;
import com.example.quanlynhansu.repository.NhanVienRepository;
import com.example.quanlynhansu.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Override
    public List<NhanVien> getAllNhanVien() {
        return nhanVienRepository.findAll();
    }

    @Override
    public NhanVien getNhanVienById(Long id) {
        return nhanVienRepository.findById(id).orElse(null);
    }

    @Override
    public NhanVien saveNhanVien(NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    @Override
    public void deleteNhanVienById(Long id) {
        nhanVienRepository.deleteById(id);
    }

    @Override
    public NhanVien getNhanVienByEmail(String email) {
        return nhanVienRepository.findByEmail(email);
    }

    @Override
    public List<NhanVien> getNhanVienByVaiTro(String vaiTro) {
        return nhanVienRepository.findByVaiTro(vaiTro);
    }

    @Override
    public List<NhanVien> getNhanVienByTrangThai(boolean trangThai) {
        return nhanVienRepository.findByTrangThai(trangThai);
    }

    @Override
    public List<NhanVien> getNhanVienByHoTenContaining(String keyword) {
        return nhanVienRepository.findByHoTenContaining(keyword);
    }

    @Override
    public List<NhanVien> getNhanVienByNgaySinhBetween(Date start, Date end) {
        return nhanVienRepository.findByNgaySinhBetween(start, end);
    }
}

