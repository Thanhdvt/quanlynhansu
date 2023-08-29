package com.example.quanlynhansu.controller;

import com.example.quanlynhansu.model.NhanVien;
import com.example.quanlynhansu.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nhanvien")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    // lấy tất cả nhân viên
    @GetMapping
    public ResponseEntity<List<NhanVien>> getAllNhanVien() {
        List<NhanVien> list = nhanVienService.getAllNhanVien();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // lấy nhân viên theo id
    @GetMapping("/{id}")
    public ResponseEntity<NhanVien> getNhanVienById(@PathVariable("id") Long id) {
        NhanVien nhanVien = nhanVienService.getNhanVienById(id);
        return new ResponseEntity<>(nhanVien, HttpStatus.OK);
    }

    // lưu nhân viên
    @PostMapping
    public ResponseEntity<NhanVien> saveNhanVien(@RequestBody NhanVien nhanVien) {
        NhanVien savedNhanVien = nhanVienService.saveNhanVien(nhanVien);
        return new ResponseEntity<>(savedNhanVien, HttpStatus.CREATED);
    }

    // xóa nhân viên theo id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNhanVienById(@PathVariable("id") Long id) {
        nhanVienService.deleteNhanVienById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // tìm nhân viên theo email
    @GetMapping("/email/{email}")
    public ResponseEntity<NhanVien> getNhanVienByEmail(@PathVariable("email") String email) {
        NhanVien nhanVien = nhanVienService.getNhanVienByEmail(email);
        return new ResponseEntity<>(nhanVien, HttpStatus.OK);
    }

    // tìm nhân viên theo vai trò
    @GetMapping("/vaitro/{vaitro}")
    public ResponseEntity<List<NhanVien>> getNhanVienByVaiTro(@PathVariable("vaitro") String vaiTro) {
        List<NhanVien> list = nhanVienService.getNhanVienByVaiTro(vaiTro);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // tìm nhân viên theo trạng thái
    @GetMapping("/trangthai/{trangthai}")
    public ResponseEntity<List<NhanVien>> getNhanVienByTrangThai(@PathVariable("trangthai") boolean trangThai) {
        List<NhanVien> list = nhanVienService.getNhanVienByTrangThai(trangThai);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}

