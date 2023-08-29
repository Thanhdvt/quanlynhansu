package com.example.quanlynhansu.repository;

import com.example.quanlynhansu.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Long> {

    // tìm nhân viên theo email
    NhanVien findByEmail(String email);

    // tìm nhân viên theo vai trò
    List<NhanVien> findByVaiTro(String vaiTro);

    // tìm nhân viên theo trạng thái
    List<NhanVien> findByTrangThai(boolean trangThai);

    // tìm nhân viên theo họ tên chứa một chuỗi ký tự
    List<NhanVien> findByHoTenContaining(String keyword);

    // tìm nhân viên theo ngày sinh trong một khoảng thời gian
    List<NhanVien> findByNgaySinhBetween(Date start, Date end);

}
