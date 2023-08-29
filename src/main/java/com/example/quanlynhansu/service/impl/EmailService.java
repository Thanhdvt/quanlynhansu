package com.example.quanlynhansu.service.impl;

import com.example.quanlynhansu.model.Employee;
import com.example.quanlynhansu.model.InfoRest;
import com.example.quanlynhansu.service.WorkDayService;
import com.example.quanlynhansu.service.EmployeeService;
import com.example.quanlynhansu.service.InfoRestService;
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
    private EmployeeService employeeService;

    @Autowired
    private InfoRestService infoRestService;

    @Autowired
    private WorkDayService workDayService;

    @Scheduled(cron = "0 0 9 1 * ?")
    public void sendEmailNumberWorkDay() {
        Date date = new Date();
        int month = date.getMonth() + 1; // test
//        int month = date.getMonth();
        List<Employee> list = employeeService.getAllEmloyee();
        for (Employee employee : list) {
            int soNgayDiLam = workDayService.countNumberDayHasWork(employee, month);
            String subject = "Cofrimation Salary";
            String text = "Hi" + employee.getName() + ",\n\n"
                    + "You has " + soNgayDiLam + " work day in month.\n\n";
            sendEmail(employee.getEmail(), subject, text);
            System.out.println("Sended workday to employee: " + employee.getName());
        }
    }

    @Scheduled(cron = "0 0 8 * * ?")
    public void sendEmailRestWorkDay() {
        Date date = new Date();
        int day = date.getDate(); //test
//        int day = date.getDate() - 1;
        System.out.println(date.getDate());
        List<InfoRest> list = infoRestService.getInfoRestByNgay(day);
        for (InfoRest infoRest : list) {
            Employee employee = infoRest.getEmployee();
            Employee leader = infoRest.getLeader();
            String subject = "Confirm RestDay Mail";
            String text = "Hi " + leader.getName() + ",\n\n"
                    + "Employee " + employee.getName() + " sended a mail for rest day (" + date + ").\n\n"
                    + "Reason : " + infoRest.getReason() + ".\n\n";
            sendEmail(leader.getEmail(), subject, text);
            System.out.println("Sended mail rest work day of employee: " + employee.getName());
        }
    }

    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }
}