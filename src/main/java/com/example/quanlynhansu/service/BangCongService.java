package com.example.quanlynhansu.service;

import com.example.quanlynhansu.model.BangCong;
import com.example.quanlynhansu.model.NhanVien;

public interface BangCongService {

    // lấy bảng công theo id
    BangCong getBangCongById(Long id);

    // lưu bảng công
    BangCong saveBangCong(BangCong bangCong);

    // xóa bảng công
    void deleteBangCong(Long id);

    // đếm số ngày đi làm của nhân viên trong tháng
    int countSoNgayDiLam(NhanVien nhanVien, int thang);

    // tính lương của một nhân viên trong một tháng
    double tinhLuong(NhanVien nhanVien, int thang);
}
