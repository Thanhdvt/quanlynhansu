package com.example.quanlynhansu.controller;


import com.example.quanlynhansu.service.impl.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    // gửi email thông báo số ngày đi làm trong tháng
    @GetMapping("/thong-bao-so-ngay-cong")
    public ResponseEntity<String> sendEmailThongBaoSoNgayCong() {
        emailService.sendEmailThongBaoSoNgayCong();
        return ResponseEntity.ok("Đã gửi email thông báo bảng công trong tháng");
    }

    // gửi email thông báo xin nghỉ
    @GetMapping("/thong-bao-nghi")
    public ResponseEntity<String> sendEmailThongBaoNghi() {
        emailService.sendEmailThongBaoNghi();
        return ResponseEntity.ok("Đã gửi email thông báo xin nghỉ");
    }
}
