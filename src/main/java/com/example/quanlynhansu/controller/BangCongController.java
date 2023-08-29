package com.example.quanlynhansu.controller;

import com.example.quanlynhansu.model.BangCong;
import com.example.quanlynhansu.model.NhanVien;
import com.example.quanlynhansu.service.BangCongService;
import com.example.quanlynhansu.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/bang-cong")
public class BangCongController {

    @Autowired
    private BangCongService bangCongService;
    @Autowired
    private NhanVienService nhanVienService;

    // lấy bảng công theo id
    @GetMapping("/{id}")
    public ResponseEntity<BangCong> getBangCongById(@PathVariable Long id) {
        BangCong bangCong = bangCongService.getBangCongById(id);
        if (bangCong == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bangCong);
    }

    // lưu bảng công
    @PostMapping
    public ResponseEntity<BangCong> saveBangCong(@RequestBody BangCong bangCong) {
        BangCong savedBangCong = bangCongService.saveBangCong(bangCong);
        return ResponseEntity.created(URI.create("/api/bang-cong/" + savedBangCong.getId())).body(savedBangCong);
    }

    // xóa bảng công
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBangCong(@PathVariable Long id) {
        bangCongService.deleteBangCong(id);
        return ResponseEntity.noContent().build();
    }

    // tính lương của một nhân viên trong một tháng
    @GetMapping("/tinh-luong")
    public ResponseEntity<Double> tinhLuong(@RequestParam("nhanVienId") Long nhanVienId, @RequestParam("thang") int thang) {
        NhanVien nhanVien = nhanVienService.getNhanVienById(nhanVienId);
        if (nhanVien == null) {
            return ResponseEntity.notFound().build();
        }
        double luong = bangCongService.tinhLuong(nhanVien, thang);
        return ResponseEntity.ok(luong);
    }
}
