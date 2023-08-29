package com.example.quanlynhansu.controller;

import com.example.quanlynhansu.model.ThongTinXinNghi;
import com.example.quanlynhansu.service.ThongTinXinNghiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/thongtinxinnghi")
public class ThongTinXinNghiController {

    @Autowired
    private ThongTinXinNghiService thongTinXinNghiService;

    // lấy tất cả thông tin xin nghỉ
    @GetMapping
    public ResponseEntity<List<ThongTinXinNghi>> getAllThongTinXinNghi() {
        List<ThongTinXinNghi> list = thongTinXinNghiService.getAllThongTinXinNghi();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // lấy thông tin xin nghỉ theo id
    @GetMapping("/{id}")
    public ResponseEntity<ThongTinXinNghi> getThongTinXinNghiById(@PathVariable("id") Long id) {
        ThongTinXinNghi thongTinXinNghi = thongTinXinNghiService.getThongTinXinNghiById(id);
        return new ResponseEntity<>(thongTinXinNghi, HttpStatus.OK);
    }

    // lưu thông tin xin nghỉ
    @PostMapping
    public ResponseEntity<ThongTinXinNghi> saveThongTinXinNghi(@RequestBody ThongTinXinNghi thongTinXinNghi) {
        ThongTinXinNghi newthongTinXinNghi = thongTinXinNghiService.addThongTinXinNghi(thongTinXinNghi);
        return new ResponseEntity<>(newthongTinXinNghi, HttpStatus.OK);
    }
}
