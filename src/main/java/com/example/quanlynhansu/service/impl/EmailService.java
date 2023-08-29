package com.example.quanlynhansu.service.impl;

import com.example.quanlynhansu.model.NhanVien;
import com.example.quanlynhansu.model.ThongTinXinNghi;
import com.example.quanlynhansu.repository.BangCongRepository;
import com.example.quanlynhansu.service.BangCongService;
import com.example.quanlynhansu.service.NhanVienService;
import com.example.quanlynhansu.service.ThongTinXinNghiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class EmailService {

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private ThongTinXinNghiService thongTinXinNghiService;

    @Autowired
    private BangCongService bangCongService;

    // email gửi ngày đầu tiên mỗi tháng thông báo tổng số ngày đi làm trong tháng
    @Scheduled(cron = "0 0 9 1 * ?") // chạy vào lúc 9h sáng ngày đầu tiên mỗi tháng
    public void sendEmailThongBaoSoNgayCong() {
        Date date = new Date();
        int month = date.getMonth() + 1; // test
//        int month = date.getMonth();
        List<NhanVien> list = nhanVienService.getAllNhanVien();
        for (NhanVien nhanVien : list) {
            int soNgayDiLam = bangCongService.countSoNgayDiLam(nhanVien, month);
            String subject = "Thống kê số ngày công trong tháng";
            String text = "Xin chào " + nhanVien.getHoTen() + ",\n\n"
                    + "Bạn đã đi làm " + soNgayDiLam + " ngày trong tháng vừa qua.\n\n"
                    + "Cảm ơn bạn đã làm việc chăm chỉ và hiệu quả.\n\n"
                    + "Trân trọng,\n"
                    + "Quản lý nhân sự";
            sendEmail(nhanVien.getEmail(), subject, text);
            System.out.println("Da gui bang cong cho nhan vien: " + nhanVien.getHoTen());
        }
    }

    // Bo dung thêm database ngày tạo mail phân biệt với ngày bắt đầu nghỉ

    // thông báo email nghỉ tới người phụ trách vào 8h sáng mỗi ngày nếu có thông tin xin nghỉ
    @Scheduled(cron = "0 0 8 * * ?") // chạy vào lúc 8h sáng mỗi ngày
    public void sendEmailThongBaoNghi() {
        Date date = new Date();
        int day = date.getDate(); //test
//        int day = date.getDate() - 1;
        System.out.println(date.getDate());
        List<ThongTinXinNghi> list = thongTinXinNghiService.getThongTinXinNghiByNgay(day);
        for (ThongTinXinNghi thongTinXinNghi : list) {
            NhanVien nhanVien = thongTinXinNghi.getNhanVien();
            NhanVien phuTrach = thongTinXinNghi.getPhuTrach();
            String subject = "Thông báo xin nghỉ";
            String text = "Xin chào " + phuTrach.getHoTen() + ",\n\n"
                    + "Nhân viên " + nhanVien.getHoTen() + " đã xin nghỉ vào ngày hôm nay (" + date + ").\n\n"
                    + "Lý do xin nghỉ: " + thongTinXinNghi.getLyDo() + ".\n\n"
                    + "Vui lòng xem xét và phê duyệt yêu cầu xin nghỉ của nhân viên.\n\n"
                    + "Trân trọng,\n"
                    + "Quản lý nhân sự";
            sendEmail(phuTrach.getEmail(), subject, text);
            System.out.println("Da gui bang nghi cua nhan vien " + nhanVien.getHoTen());
        }
    }

    // hàm gửi email
    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }
}