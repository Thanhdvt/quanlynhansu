package com.example.quanlynhansu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nhanvien")
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ho_ten", nullable = false)
    private String hoTen;

    @Column(name = "ngay_sinh", nullable = false)
    private Date ngaySinh;

    @Column(name = "gioi_tinh", nullable = false)
    private String gioiTinh;

    @Column(name = "dia_chi", nullable = false)
    private String diaChi;

    @Column(name = "so_dien_thoai", nullable = false)
    private String soDienThoai;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "mat_khau", nullable = false)
    private String matKhau;

    @Column(name = "vai_tro", nullable = false)
    private String vaiTro;

    @Column(name = "trang_thai", nullable = false)
    private boolean trangThai;

    @Column(name = "luong_coban", nullable = false)
    private double luongCoBan;


    // quan hệ 1-n với bảng thông tin xin nghỉ
    @OneToMany(mappedBy = "nhanVien")
    private List<ThongTinXinNghi> thongTinXinNghi;
}
