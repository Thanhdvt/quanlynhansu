CREATE DATABASE quanlynhansu;

USE quanlynhansu;

CREATE TABLE nhanvien (
    id BIGINT PRIMARY KEY,
    ho_ten VARCHAR(255) NOT NULL,
    ngay_sinh DATE NOT NULL,
    gioi_tinh VARCHAR(10) NOT NULL,
    dia_chi VARCHAR(255) NOT NULL,
    so_dien_thoai VARCHAR(20) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    mat_khau VARCHAR(255) NOT NULL,
    vai_tro VARCHAR(50) NOT NULL,
    trang_thai BOOLEAN NOT NULL,
    luong_coban DOUBLE PRECISION NOT NULL
);

CREATE TABLE bang_cong (
    id BIGINT PRIMARY KEY,
    nhan_vien_id BIGINT REFERENCES nhanvien(id),
    ngay DATE NOT NULL,
    co_di_lam BOOLEAN NOT NULL
);

CREATE TABLE thong_tin_xin_nghi (
    id BIGINT PRIMARY KEY,
    ly_do VARCHAR(255) NOT NULL,
    ngay_bat_dau DATE NOT NULL,
    ngay_ket_thuc DATE NOT NULL,
    trang_thai VARCHAR(50) NOT NULL,
    ngay_tao TIMESTAMP NOT NULL,
    ngay_sua TIMESTAMP NOT NULL,
    nhan_vien_id BIGINT REFERENCES nhanvien(id),
    phu_trach_id BIGINT REFERENCES nhanvien(id)
);


-- Thêm dữ liệu cho bảng nhanvien
INSERT INTO nhanvien (id, ho_ten, ngay_sinh, gioi_tinh, dia_chi, so_dien_thoai, email, mat_khau, vai_tro, trang_thai, luong_coban)
VALUES (1, 'Nguyen Van A', '1990-01-01', 'Nam', 'Ha Noi', '0123456789', 'thanhak2k2@gmail.com', '123456', 'Nhan vien', true, 10000000);
INSERT INTO nhanvien (id, ho_ten, ngay_sinh, gioi_tinh, dia_chi, so_dien_thoai, email, mat_khau, vai_tro, trang_thai, luong_coban)
VALUES (2, 'Nguyen Van B', '1995-01-01', 'Nam', 'Ha Noi', '0123456789', 'thanhdvt07022002@gmail.com', '123456', 'Nhan vien', true, 18000000);


-- Thêm dữ liệu cho bảng bang_cong
INSERT INTO bang_cong (id, nhan_vien_id, ngay, co_di_lam)
VALUES (1, 1, '2023-08-01', true);



-- Thêm dữ liệu cho bảng thong_tin_xin_nghi
INSERT INTO thong_tin_xin_nghi (id, ly_do, ngay_bat_dau, ngay_ket_thuc, trang_thai, ngay_tao, ngay_sua, nhan_vien_id, phu_trach_id)
VALUES (1, 'Nghi om', '2023-08-20', '2023-08-23', 'Dang xu ly', now(), now(), 1, 2);

select count(bc.ngay) 
from bang_cong bc 
where bc.nhan_vien_id = 2 and month(bc.ngay) = 8 and bc.co_di_lam = true;

select *
from thong_tin_xin_nghi
where DAY(ngay_sua ) = 21;

