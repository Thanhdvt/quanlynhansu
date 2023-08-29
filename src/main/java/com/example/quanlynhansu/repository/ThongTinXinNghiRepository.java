package com.example.quanlynhansu.repository;

import com.example.quanlynhansu.model.ThongTinXinNghi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThongTinXinNghiRepository extends JpaRepository<ThongTinXinNghi, Long> {

    // lấy ra ngày nhân viên bắt đầu nghỉ
    @Query("select ttxn from ThongTinXinNghi ttxn where day( ttxn.ngayBatDau ) = :ngay")
    List<ThongTinXinNghi> findByNgay(int ngay);

    // lấy ra ngày nhân viên bắt đầu nghỉ
    @Query("select ttxn from ThongTinXinNghi ttxn where day( ttxn.ngaySua ) = :ngay")
    List<ThongTinXinNghi> findByNgaySua(int ngay);
}
