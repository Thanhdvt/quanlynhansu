package com.example.quanlynhansu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "thong_tin_xin_nghi")
public class ThongTinXinNghi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ly_do", nullable = false)
    private String lyDo;

    @Column(name = "ngay_bat_dau", nullable = false)
    private Date ngayBatDau;

    @Column(name = "ngay_ket_thuc", nullable = false)
    private Date ngayKetThuc;

    @Column(name = "trang_thai", nullable = false)
    private String trangThai;

    @CreationTimestamp
    @Column(name = "ngay_tao", nullable = false)
    private Date ngayTao;

    @UpdateTimestamp
    @Column(name="ngay_sua", nullable = false)
    private Date ngaySua;

    // quan hệ n-1 với bảng nhân viên
    @ManyToOne
    @JoinColumn(name = "nhan_vien_id", nullable = false)
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "phu_trach_id", nullable = false)
    private NhanVien phuTrach;
}
