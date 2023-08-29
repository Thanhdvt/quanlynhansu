package com.example.quanlynhansu.service;

import com.example.quanlynhansu.model.NhanVien;

import java.util.Date;
import java.util.List;

public interface NhanVienService {

    // lấy tất cả nhân viên
    List<NhanVien> getAllNhanVien();

    // lấy nhân viên theo id
    NhanVien getNhanVienById(Long id);

    // lưu nhân viên
    NhanVien saveNhanVien(NhanVien nhanVien);

    // xóa nhân viên theo id
    void deleteNhanVienById(Long id);

    // tìm nhân viên theo email
    NhanVien getNhanVienByEmail(String email);

    // tìm nhân viên theo vai trò
    List<NhanVien> getNhanVienByVaiTro(String vaiTro);

    // tìm nhân viên theo trạng thái
    List<NhanVien> getNhanVienByTrangThai(boolean trangThai);

    // tìm nhân viên theo họ tên chứa một chuỗi ký tự
    List<NhanVien> getNhanVienByHoTenContaining(String keyword);

    // tìm nhân viên theo ngày sinh trong một khoảng thời gian
    List<NhanVien> getNhanVienByNgaySinhBetween(Date start, Date end);
}
