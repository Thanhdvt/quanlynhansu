package com.example.humanresourcesdepartment.service.impl;

import com.example.humanresourcesdepartment.dto.EmployeeDto;
import com.example.humanresourcesdepartment.service.EmployeeService;
import com.example.humanresourcesdepartment.service.WorkDayService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SchedualForEmailNumberWorkDay {

    private EmployeeService employeeService;
    private WorkDayService workDayService;
    private EmailService emailService;
    SchedualForEmailNumberWorkDay( EmployeeService employeeService, WorkDayService workDayService, EmailService emailService){
        this.employeeService = employeeService;
        this.workDayService = workDayService;
        this.emailService = emailService;
    }

    @Scheduled(cron = "0 0 9 1 * ?")
    public void sendEmailNumberWorkDay() {
        Date date = new Date();
        int month = date.getMonth();
        List<EmployeeDto> list = employeeService.getAllEmloyee();
        for (EmployeeDto employeeDto : list) {
            int soNgayDiLam = workDayService.countNumberDayHasWork(employeeDto, month);
            String subject = "Cofrimation Salary";
            String text = "Hi" + employeeDto.getName() + ",\n\n"
                    + "You has " + soNgayDiLam + " work day in month.\n\n";
            emailService.sendEmail(employeeDto.getEmail(), subject, text);
            System.out.println("Sended workday to employee: " + employeeDto.getName());
        }
    }
}
