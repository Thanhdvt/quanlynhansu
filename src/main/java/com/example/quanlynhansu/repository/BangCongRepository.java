package com.example.quanlynhansu.repository;

import com.example.quanlynhansu.model.BangCong;
import com.example.quanlynhansu.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BangCongRepository extends JpaRepository<BangCong, Long> {

    // truy vấn theo nhanVien và ngay
    BangCong findByNhanVienAndNgay(NhanVien nhanVien, LocalDate ngay);

    // truy vấn theo nhanVien và tháng
    @Query("select bc from BangCong bc where bc.nhanVien = :nhanVien and month(bc.ngay) = :thang")
    List<BangCong> findByNhanVienAndThang(@Param("nhanVien") NhanVien nhanVien, @Param("thang") int thang);

    // đếm số ngày đi làm của một nhân viên trong một tháng
    @Query("select count(bc) from BangCong bc where bc.nhanVien = :nhanVien and month(bc.ngay) = :thang and bc.coDiLam = true")
    int countSoNgayDiLam(@Param("nhanVien") NhanVien nhanVien, @Param("thang") int thang);
}

