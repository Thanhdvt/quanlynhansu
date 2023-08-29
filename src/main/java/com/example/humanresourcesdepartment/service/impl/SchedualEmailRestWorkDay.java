package com.example.humanresourcesdepartment.service.impl;

import com.example.humanresourcesdepartment.model.Employee;
import com.example.humanresourcesdepartment.model.InfoRest;
import com.example.humanresourcesdepartment.service.InfoRestService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SchedualEmailRestWorkDay {
    private InfoRestService infoRestService;

    private EmailService emailService;
    SchedualEmailRestWorkDay(InfoRestService infoRestService, EmailService emailService){
        this.infoRestService = infoRestService;
        this.emailService = emailService;
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
            emailService.sendEmail(leader.getEmail(), subject, text);
            System.out.println("Sended mail rest work day of employee: " + employee.getName());
        }
    }
}
