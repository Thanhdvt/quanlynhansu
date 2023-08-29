package com.example.quanlynhansu.service;

import com.example.quanlynhansu.model.ThongTinXinNghi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThongTinXinNghiService {

    // lấy tất cả thông tin xin nghỉ
    List<ThongTinXinNghi> getAllThongTinXinNghi();

    // lấy thông tin xin nghỉ theo id
    ThongTinXinNghi getThongTinXinNghiById(Long id);

    // lấy thông tin xin nghỉ theo ngày
   List<ThongTinXinNghi> getThongTinXinNghiByNgay(int ngay);

    // thêm mới thông tin xin nghỉ
    ThongTinXinNghi addThongTinXinNghi(ThongTinXinNghi thongTinXinNghi);

    // cập nhật thông tin xin nghỉ
    public ThongTinXinNghi updateThongTinXinNghi(ThongTinXinNghi thongTinXinNghi);
}
