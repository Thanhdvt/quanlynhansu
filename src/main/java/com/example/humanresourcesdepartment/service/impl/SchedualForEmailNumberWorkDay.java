package com.example.humanresourcesdepartment.service.impl;

import com.example.humanresourcesdepartment.model.Employee;
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
        int month = date.getMonth() + 1; // test
//        int month = date.getMonth();
        List<Employee> list = employeeService.getAllEmloyee();
        for (Employee employee : list) {
            int soNgayDiLam = workDayService.countNumberDayHasWork(employee, month);
            String subject = "Cofrimation Salary";
            String text = "Hi" + employee.getName() + ",\n\n"
                    + "You has " + soNgayDiLam + " work day in month.\n\n";
            emailService.sendEmail(employee.getEmail(), subject, text);
            System.out.println("Sended workday to employee: " + employee.getName());
        }
    }
}
